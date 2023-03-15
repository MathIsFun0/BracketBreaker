package io.github.MathIsFun0.BracketBreaker;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class BracketAnalyzer {
    // This time I'm intentionally making everything static, so it can be accessed from anywhere without making a class...
    public static String currentFile = "D:/one1.brk23";
    public static String perfectionFile = "perfection.brk23";
    public static AnalyzerTeam[][][] bracket = Brackets.MarchMadness2023Analyzer;
    public static int bytesPerBracket = 8;
    public static int largestRoundLen = 32;
    public static ArrayList<Integer[]> completedGames = new ArrayList<>();
    protected static final XoShiRo256PlusRandom rng = new XoShiRo256PlusRandom();

    public static void main(String[] args) {
        BracketBreaker.generateSigmoidArray();
        completedGames.add(new Integer[]{20, 1}); //11 Michigan upsets 6 Colorado St
        completedGames.add(new Integer[]{27, 0}); //4 Providence beats 13 South Dakota St
        completedGames.add(new Integer[]{1, 1}); //9 Memphis upsets 8 Boise St
        completedGames.add(new Integer[]{8, 0}); //1 Baylor beats 16 Norfolk St
        try {
            getAndSavePerfectBrackets();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AnalyzerTeam battle(AnalyzerTeam t1, AnalyzerTeam t2) {
        /* Uncompressed code:
        float ratingDiff = t1.rating - t2.rating;
        //The float value -0.175365 comes from FiveThirtyEight's system
        float likelinessFactor = Math.min(Math.max(-0.175365f*ratingDiff,-6.0f),6.0f);
        int randomness = rng.nextInt();
        if (randomness > sigmoid(likelinessFactor)) {
            return t1;
        }
        return t2;*/
        //The float value -0.175365 comes from FiveThirtyEight's system
        return (rng.nextInt() > BracketBreaker.sigmoid(Math.min(Math.max(-0.175f*(t1.rating - t2.rating),-6.0f),6.0f))) ? t1 : t2;
        //return (rng.nextInt() > sigmoidArray[(t2.rating - t1.rating)+6000]) ? t1 : t2;
    }

    public static void verboseBracketGeneration(int x) {
        AnalyzerTeam[] teamWinners = new AnalyzerTeam[largestRoundLen];
        AnalyzerTeam[] previousWinners = new AnalyzerTeam[largestRoundLen];
        byte il = (byte)bracket.length;
        for (int q = 0; q < x; q++) {
            for (byte r = 0; r < il; r++) {
                byte ml = (byte) bracket[r].length;
                for (byte m = 0; m < ml; m++) {
                    for (byte t = 0; t <= 1; t++) {
                        if (bracket[r][m][t].placeholderFor != -1) {
                            //if (r >= 1) { //Optimization for March Madness only...
                            bracket[r][m][t].rating = previousWinners[bracket[r][m][t].placeholderFor].rating;
                            bracket[r][m][t].seed = previousWinners[bracket[r][m][t].placeholderFor].seed;
                            bracket[r][m][t].name = previousWinners[bracket[r][m][t].placeholderFor].name;
                        }
                    }
                    teamWinners[m] = battle(bracket[r][m][0], bracket[r][m][1]);
                    if (teamWinners[m] == bracket[r][m][0]) System.out.print(1);
                    else System.out.print(2);
                    if (teamWinners[m] == bracket[r][m][0])
                        previousWinners[m] = teamWinners[m];
                }
                System.arraycopy(teamWinners, 0, previousWinners, 0, bracket[r].length);
            }
            System.out.println();
        }
    }
    public static void getAndSavePerfectBrackets() throws IOException {
        try (RandomAccessFile data = new RandomAccessFile(currentFile, "r")) {
            byte[] rawResults = new byte[1000000*bytesPerBracket];
            byte[] perfectBrackets = new byte[1000000*bytesPerBracket];
            int perfectBracketIdx = 0;
            Path path = Paths.get(perfectionFile);
            File file = new File(perfectionFile);
            file.createNewFile();
            long[] perfectionByRound = new long[completedGames.size()];
            for (long i = 0, len = data.length() / 1000000 / bytesPerBracket; i < len; i++) {
                data.readFully(rawResults);
                for (int j = 0; j < 1000000; j++) {
                    int gamesChecked = 0;
                    boolean busted = false;
                    for (Integer[] completedGame : completedGames) {
                        int index = bytesPerBracket * j + completedGame[0] / 8;
                        if ((rawResults[index] & (1 << (7 - completedGame[0] % 8))) == 0) {
                            if (completedGame[1] == 0) gamesChecked++;
                            else busted = true;
                        } else {
                            if (completedGame[1] == 1) gamesChecked++;
                            else busted = true;
                        }
                        if (busted) break;
                        perfectionByRound[gamesChecked - 1]++;
                    }
                    if (!busted) {
                        if (perfectBracketIdx == 1000000 * bytesPerBracket) {
                            Files.write(path, perfectBrackets, StandardOpenOption.APPEND);
                            perfectBrackets = new byte[1000000 * bytesPerBracket];
                            perfectBracketIdx = 0;
                        }
                        if (bytesPerBracket >= 0)
                            System.arraycopy(rawResults, bytesPerBracket * j, perfectBrackets, perfectBracketIdx, bytesPerBracket);
                        perfectBracketIdx += bytesPerBracket;
                    }
                }
            }
            byte[] perfectBracketsLeftOver = Arrays.copyOfRange(perfectBrackets, 0, perfectBracketIdx);
            Files.write(path, perfectBracketsLeftOver, StandardOpenOption.APPEND);
            System.out.println("Perfection by Round:");
            System.out.println(Arrays.toString(perfectionByRound));
        }
    }

    public static void getWinners() throws IOException { //todo: update this to work with MMBB's storage system
        try (RandomAccessFile data = new RandomAccessFile(currentFile, "r")) {
            byte[] rawResults = new byte[1000000*bytesPerBracket];
            AnalyzerTeam[] teamWinners = new AnalyzerTeam[largestRoundLen];
            AnalyzerTeam[] previousWinners = new AnalyzerTeam[largestRoundLen];
            HashMap<String, Long> winnerAmounts = new HashMap<>();
            for (AnalyzerTeam[][] analyzerTeams : bracket) {
                for (AnalyzerTeam[] analyzerTeam : analyzerTeams) {
                    for (AnalyzerTeam team : analyzerTeam) {
                        if (team.placeholderFor == -1) {
                            winnerAmounts.put(team.seed + " " + team.name, 0L);
                        }
                    }
                }
            }
            for (long i = 0, len = data.length() / 1000000 / bytesPerBracket; i < len; i++) {
                data.readFully(rawResults);
                int pos = 0;
                short pow = 128;
                for (int j = 0; j < 1000000; j++) {
                    for (AnalyzerTeam[][] analyzerTeams : bracket) {
                        for (byte m = 0; m < analyzerTeams.length; m++) {
                            for (byte t = 0; t <= 1; t++) {
                                if (analyzerTeams[m][t].placeholderFor != -1) {
                                    analyzerTeams[m][t].name = previousWinners[analyzerTeams[m][t].placeholderFor].name;
                                    analyzerTeams[m][t].seed = previousWinners[analyzerTeams[m][t].placeholderFor].seed;
                                }
                            }
                            if (((rawResults[pos] & pow) == 0))
                                teamWinners[m] = analyzerTeams[m][0];
                            else teamWinners[m] = analyzerTeams[m][1];
                            //teamWinners[m] = ((rawResults[pos] & pow) == 0) ? bracket[r][m][0] : bracket[r][m][1];
                            pow >>= 1;
                            if (pow == 0) {
                                pow = 128;
                                pos++;
                            }
                        }
                        System.arraycopy(teamWinners, 0, previousWinners, 0, analyzerTeams.length);
                    }
                    if (pow != 128) {
                        pow = 128;
                        pos++;
                    }
                    String key = teamWinners[0].seed + " " + teamWinners[0].name;
                    winnerAmounts.put(key, winnerAmounts.get(key)+1);
                }}
            System.out.println("Wins: ");
            winnerAmounts = sortByValue(winnerAmounts);
            winnerAmounts.forEach((team, wins) -> System.out.println(team + new String(new char[25 - team.length()]).replace("\0", " ") + " - " + wins));
        }
    }

    private static long byteToLong(byte[] arr) { //Has to be eight bytes, unfortunately.
        long x1 = (long)(arr[0] & 0xff) << 56L;
        long x2 = (long)(arr[1] & 0xff) << 48L;
        long x3 = (long)(arr[2] & 0xff) << 40L;
        long x4 = (long)(arr[3] & 0xff) << 32L;
        long x5 = (long)(arr[4] & 0xff) << 24L;
        long x6 = (long)(arr[5] & 0xff) << 16L;
        long x7 = (long)(arr[6] & 0xff) << 8L;
        long x8 = arr[7] & 0xff;
        return x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8;
    }
    private static boolean[] byteToBin(byte[] arr) {
        boolean[] out = new boolean[arr.length*8];
        for (int i = 0; i < arr.length; i++) {
            out[8 * i] = (arr[i] & 1) != 0;
            out[8 * i + 1] = (arr[i] & 2) != 0;
            out[8 * i + 2] = (arr[i] & 4) != 0;
            out[8 * i + 3] = (arr[i] & 8) != 0;
            out[8 * i + 4] = (arr[i] & 16) != 0;
            out[8 * i + 5] = (arr[i] & 32) != 0;
            out[8 * i + 6] = (arr[i] & 64) != 0;
            out[8 * i + 7] = (arr[i] & 128) != 0;
        }
        return out;
    }

    //Source: https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
    public static HashMap<String, Long> sortByValue(HashMap<String, Long> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Long> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort((o1, o2) -> {
            return -(o1.getValue()).compareTo(o2.getValue()); // But now in descending order!
        });

        // put data from sorted list to hashmap
        HashMap<String, Long> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
