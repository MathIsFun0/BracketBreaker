package io.github.MathIsFun0.BracketBreaker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.SplittableRandom;
import java.util.Scanner;

public class BracketBreaker implements Runnable {
    private final SplittableRandom rng;
    private final static Scanner scanner = new Scanner(System.in);
    private final static int[] sigmoidArray = new int[12001]; //-6 to 6 by thousandths
    private final int bytesPerBracket;
    private final int reps;
    private final String fileOutput;
    private final int threadID;
    private static int runningInstances = 0;
    private static int millionsGenerated = 0;
    private static boolean generationCompleted = false;
    private static long startTime = System.currentTimeMillis();
    public BracketBreaker(Team[][][] bracket) {
        this(bracket, 1, "brackets", -1);
    }
    public BracketBreaker() {
        this(Brackets.MarchMadness2022);
    }
    public BracketBreaker(Team[][][] bracket, int millionsToGenerate, String outputFileName, int ID) {
        generateSigmoidArray();
        rng = new SplittableRandom();
        teamList = bracket;
        int matchesPerBracket = 0;
        for (Team[][] round : bracket) {
            matchesPerBracket += round.length;
        }
        bytesPerBracket = (int)Math.ceil(matchesPerBracket/8.0);
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
        System.out.println("BracketBreaker v0.10");
        System.out.println("Note: This uses 2022's bracket.");
        BracketBreaker bb = new BracketBreaker();
        System.out.println("Enter the path to the file (don't enter any extension)");
        String ext = scanner.next();
        Path path = Paths.get(ext+".brk22");
        try {
            File file = new File(ext+".brk22");
            file.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Enter the number of brackets to generate (in millions)");
        System.out.println("NOTE: Each bracket is 8 bytes. Make sure to check your storage.");
        int times = scanner.nextInt();
        long time = System.currentTimeMillis();
        for (int i = 1; i <= times; i++) {
            byte[] thisWorks = bb.generate1000000Brackets();
            Files.write(path, thisWorks, StandardOpenOption.APPEND);
            System.out.print(i);
            System.out.print(" million brackets generated! (");
            System.out.print(i*1000000000L/(System.currentTimeMillis() - time));
            System.out.println("/sec)");
        }
        System.out.print("Brackets generated in ");
        long diff = System.currentTimeMillis() - time;
        System.out.print(diff);
        System.out.println(" ms");
        //one bracket trial run
        /*Path path = Paths.get("bracket.brk21");
        long time = System.currentTimeMillis();
                byte[] thisWorks = MarchMadness.generateBracket();
                Files.write(path, thisWorks, StandardOpenOption.APPEND);*/
        //generateBracket();
    }
    private static void generateSigmoidArray() {
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
    private final Team[][][] teamList;
    public byte[] generateBracket() {
        Team[] teamWinners = new Team[32];
        Team[] previousWinners = new Team[32];
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
                Team matchResult = battle(teamList[r][m][0],teamList[r][m][1]);
                System.out.print(matchResult);
                System.out.println(" won!");
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
        Path path = Paths.get(fileOutput+(threadID == -1 ? threadID : "")+".brk22");
        try {
            File file = new File(fileOutput+(threadID == -1 ? threadID : "")+".brk22");
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
            if (threadID != -1)
                System.out.print("[" + threadID + "] ");
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
        Team[] teamWinners = new Team[32];
        Team[] previousWinners = new Team[32];
        byte[] result = new byte[1000000*bytesPerBracket];
        Team matchResult;
        int pos = 0;
        short pow = 1;
        for (int i = 0; i < 1000000; i++) {
            for (byte r = 0; r < 6; r++) {
                for (byte m = 0; m < teamList[r].length; m++) {
                    for (byte t = 0; t <= 1; t++) {
                        if (teamList[r][m][t].placeholderFor != -1) {
                            teamList[r][m][t] = previousWinners[teamList[r][m][t].placeholderFor];
                        }
                    }
                    matchResult = battle(teamList[r][m][0], teamList[r][m][1]);
                    if (matchResult == teamList[r][m][1]) {
                        result[pos] += pow;
                    }
                    pow *= 2;
                    if (pow == 256) {
                        pow = 1;
                        pos++;
                    }
                    teamWinners[m] = matchResult;
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
    public Team battle(Team t1, Team t2) {
        float ratingDiff = t1.rating - t2.rating;
        //base is -0.08f
        float likelinessFactor = Math.min(Math.max(-0.2f*ratingDiff,-6.0f),6.0f);
        int randomness = rng.nextInt();
        if (randomness > sigmoid(likelinessFactor)) {
            return t1;
        }
        return t2;
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