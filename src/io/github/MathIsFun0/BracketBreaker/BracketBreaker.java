package io.github.MathIsFun0.BracketBreaker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BracketBreaker implements Runnable {
    protected final XoShiRo256PlusRandom rng;
    protected final static int[] sigmoidArray = new int[12001]; //-6 to 6 by thousandths
    protected final int bytesPerBracket;
    protected final int largestRoundLen;
    protected int reps;
    protected String fileOutput;
    protected int threadID;
    protected static int runningInstances = 0;
    protected static int millionsGenerated = 0;
    protected static boolean generationCompleted = false;
    protected static long startTime = System.currentTimeMillis();
    public BracketBreaker(GeneratorTeam[][][] bracket) {
        this(bracket, 1, "brackets", -1);
    }
    public BracketBreaker() {
        this(Brackets.MarchMadness2022);
    }
    public BracketBreaker(GeneratorTeam[][][] bracket, int millionsToGenerate, String outputFileName, int ID) {
        generateSigmoidArray();
        rng = new XoShiRo256PlusRandom();
        teamList = bracket;
        int matchesPerBracket = 0;
        int largestRoundLen = 0;
        for (Team[][] round : bracket) {
            largestRoundLen = Math.max(largestRoundLen, round.length);
            matchesPerBracket += round.length;
        }
        bytesPerBracket = (int)Math.ceil(matchesPerBracket/8.0);
        this.largestRoundLen = largestRoundLen;
        reps = millionsToGenerate;
        fileOutput = outputFileName;
        threadID = ID;
    }

    public void run() {
        try {
            repeatedGenerateAndSave(threadID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new BracketBreaker().generateBracket();
    }
    protected static void generateSigmoidArray() {
        int i = 0;
        long newRange = (long)(Integer.MAX_VALUE) - Integer.MIN_VALUE;
        for (float f = 6.0f; f > -6.001f; f -= 0.001f) {
            if (i <= 12000) {
                //Converts from -2147483648 to 2147483647
                sigmoidArray[i] = (int)(newRange * (1.0 / (1 + Math.exp(f))) + Integer.MIN_VALUE);
            }
            i++;
        }
    }
    protected final GeneratorTeam[][][] teamList;
    public byte[] generateBracket() {
        GeneratorTeam[] teamWinners = new GeneratorTeam[32];
        GeneratorTeam[] previousWinners = new GeneratorTeam[32];
        byte[] result = new byte[8];
        int pos = 0;
        int pow = 128;
        for (int r = 0; r < 6; r++) {
            for (int m = 0; m < teamList[r].length; m++) {
                for (int t = 0; t <= 1; t++) {
                    if (teamList[r][m][t].placeholderFor != -1) {
                        teamList[r][m][t] = previousWinners[teamList[r][m][t].placeholderFor];
                    }
                }
                GeneratorTeam matchResult = battle(teamList[r][m][0],teamList[r][m][1]);
                if (matchResult == teamList[r][m][1]) {
                    result[pos] += pow;
                }
                if (pow == 1) {
                    pow = 128;
                    pos++;
                } else {
                    pow >>= 1;
                }
                teamWinners[m] = matchResult;
            }
            System.arraycopy(teamWinners, 0, previousWinners, 0, teamList[r].length);
        }
        return result;
    }
    public void repeatedGenerateAndSave(int threadID) throws IOException {
        if (runningInstances == 0) {
            millionsGenerated = 0;
            startTime = System.currentTimeMillis();
            generationCompleted = false;
        }
        runningInstances++;
        Path path = Paths.get(fileOutput+(threadID == -1 ? threadID : "")+".brk23");
        try {
            File file = new File(fileOutput+(threadID == -1 ? threadID : "")+".brk23");
            file.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        while (millionsGenerated < reps) {
            byte[] thisWorks = generate1000000Brackets();
            if (millionsGenerated < reps) {
                Files.write(path, thisWorks, StandardOpenOption.APPEND);
                if (threadID != -1)
                    System.out.print("[" + threadID + "] ");
                millionsGenerated++;
                System.out.print(millionsGenerated);
                System.out.print(" million brackets generated! (");
                System.out.print(millionsGenerated * 1000000000L / (System.currentTimeMillis() - startTime));
                System.out.println("/sec)");
            }
        }
        if (millionsGenerated == reps && !generationCompleted) {
            generationCompleted = true;
            System.out.print("Brackets generated in ");
            long diff = System.currentTimeMillis() - startTime;
            System.out.print(diff);
            System.out.println(" ms");
        }
        runningInstances--;
    }

    public void repeatedGenerateAndSave() throws IOException {
        //simple overloading
        repeatedGenerateAndSave(-1);
    }
    public byte[] generate1000000Brackets() {
        GeneratorTeam[] teamWinners = new GeneratorTeam[largestRoundLen];
        GeneratorTeam[] previousWinners = new GeneratorTeam[largestRoundLen];
        byte[] result = new byte[1000000*bytesPerBracket];
        GeneratorTeam matchResult;
        int pos = 0;
        short pow = 1;
        byte il = (byte)teamList.length;
        for (int i = 0; i < 1000000; i++) {
            for (byte r = 0; r < il; r++) {
                byte ml = (byte) teamList[r].length;
                for (byte m = 0; m < ml; m++) {
                    for (byte t = 0; t <= 1; t++) {
                        if (teamList[r][m][t].placeholderFor != -1) {
                        //if (r >= 1) { //Optimization for March Madness only...
                            teamList[r][m][t].rating = previousWinners[teamList[r][m][t].placeholderFor].rating;
                        }
                    }
                    teamWinners[m] = battle(teamList[r][m][0], teamList[r][m][1]);
                    if (teamWinners[m] == teamList[r][m][1]) {
                        result[pos] += pow;
                    }
                    pow *= 2;
                    if (pow == 256) {
                        pow = 1;
                        pos++;
                    }
                }
                System.arraycopy(teamWinners, 0, previousWinners, 0, teamList[r].length);
            }
            if (pow != 1) {
                pow = 1;
                pos++;
            }
        }
        return result;
    }
    public GeneratorTeam battle(GeneratorTeam t1, GeneratorTeam t2) {
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
        //Making the ratings integers made things 20% faster by making the math easier... MarchMadness only
        return (rng.nextInt() > sigmoid(Math.min(Math.max(-0.175365f*(t1.rating - t2.rating),-6.0f),6.0f))) ? t1 : t2;
        //return (rng.nextInt() > sigmoidArray[(t2.rating - t1.rating)+6000]) ? t1 : t2;
    }
    static int sigmoid(float x) {
        //return 1/(1+(float)Math.pow(Math.E,-1.0f*x));
        /*if (Math.abs(x) < 1) {
            return ((x/(1+Math.abs(x)))+1)/2;
        }
        return ((x*x*x/(1+Math.abs(x*x*x)))+1)/2;*/
        return sigmoidArray[(int)(x*1000+6000)];
    }
}