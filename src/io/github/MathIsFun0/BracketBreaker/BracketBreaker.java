package io.github.MathIsFun0.BracketBreaker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class BracketBreaker {
    static Random rng = new Random();
    static Scanner scanner = new Scanner(System.in);
    static float[] sigmoidArray = new float[12001]; //-6 to 6 by thousandths
    public static void main(String[] args) throws IOException {
        System.out.println("BracketBreaker v0.10");
        System.out.println("Note: This uses 2022's bracket.");
        generateSigmoidArray();
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
            byte[] thisWorks = BracketBreaker.generate1000000Brackets();
            Files.write(path, thisWorks, StandardOpenOption.APPEND);
            System.out.print(i);
            System.out.print(" million brackets generated! (");
            System.out.print(i*1000000000L/(System.currentTimeMillis() - time));
            System.out.println("/sec)");
        };
        System.out.print("Brackets generated in ");
        long diff = System.currentTimeMillis() - time;
        System.out.print(diff);
        System.out.println(" ms");
        //MarchMadness.generateStats();
        //one bracket trial run
        /*Path path = Paths.get("bracket.brk21");
        long time = System.currentTimeMillis();
                byte[] thisWorks = MarchMadness.generateBracket();
                Files.write(path, thisWorks, StandardOpenOption.APPEND);*/
        //generateBracket();
        /*Generator R1 = new Generator( "1");
        R1.start();

        Generator R2 = new Generator( "2");
        R2.start();

        Generator R3 = new Generator( "3");
        R3.start();

        Generator R4 = new Generator( "4");
        R4.start();*/
    }
    static void generateSigmoidArray() {
        int i = 0;
        for (float f = 6.0f; f > -6.001f; f -= 0.001f) {
            if (i <= 12000) {
                sigmoidArray[i] = 1.0f / (float) (1 + Math.exp(f));
            }
            i++;
        }
    }
    static Team[][][] teamList = {
            /*{ //First Four
                    {new Team("Rutgers", 10.86, 11), new Team("Notre Dame", 13.63, 11)},
                    {new Team("Wyoming", 13.10, 12), new Team("Indiana", 14.94, 12)},
                    {new Team("Wright St.", -0.87, 16), new Team("Bryant", -0.95, 16)},
                    {new Team("Texas Southern", -1.33, 16), new Team("Texas A&M-CC", -6.31, 16)}
            },*/
            { //First Round
                    {new Team("Gonzaga", 32.97, 1), new Team("Georgia St.", 1.84, 16)},
                    {new Team("Boise St.", 16.41, 8), new Team("Memphis", 16.22, 9)},
                    {new Team("UConn", 19.33, 5), new Team("New Mexico St.", 10.10, 12)},
                    {new Team("Arkansas", 19.02, 4), new Team("Vermont", 13.07, 13)},
                    {new Team("Alabama", 17.36, 6), new Team("Notre Dame", 13.63, 11)}, //no idea, just using Rutgers cuz go Rutgers
                    {new Team("Texas Tech", 24.64, 3), new Team("Montana St.", 3.81, 14)},
                    {new Team("Michigan St.", 14.87, 7), new Team("Davidson", 14.80, 10)},
                    {new Team("Duke", 23.71, 2), new Team("CS Fullerton", 2.10, 15)},
                    {new Team("Baylor", 26.32, 1), new Team("Norfolk St.", 0.15, 16)},
                    {new Team("North Carolina", 16.04, 8), new Team("Marquette", 14.00, 9)},
                    {new Team("Saint Mary's", 19.81, 5), new Team("Indiana", 15.34, 12)},
                    {new Team("UCLA", 24.85, 4), new Team("Akron", 3.49, 13)},
                    {new Team("Texas", 20.41, 6), new Team("Virginia Tech", 17.86, 11)},
                    {new Team("Purdue", 22.29, 3), new Team("Yale", 2.23, 14)},
                    {new Team("Murray St.", 16.39, 7), new Team("San Francisco", 18.37, 10)},
                    {new Team("Kentucky", 26.59, 2), new Team("Saint Peter's", 4.28, 15)},
                    {new Team("Arizona", 27.21, 1), new Team("Wright St.", -0.32, 16)},
                    {new Team("Seton Hall", 14.97, 8), new Team("TCU", 14.91, 9)},
                    {new Team("Houston", 26.50, 5), new Team("UAB", 14.03, 12)},
                    {new Team("Illinois", 19.59, 4), new Team("Chattanooga", 11.27, 13)},
                    {new Team("Colorado St.", 15.86, 6), new Team("Michigan", 15.65, 11)},
                    {new Team("Tennessee", 25.24, 3), new Team("Longwood", 2.48, 14)},
                    {new Team("Ohio St.", 15.82, 7), new Team("Loyola Chicago", 17.69, 10)},
                    {new Team("Villanova", 24.11, 2), new Team("Delaware", 2.28, 15)},
                    {new Team("Kansas", 25.49, 1), new Team("Texas Southern", -0.99, 16)},
                    {new Team("San Diego St.", 18.15, 8), new Team("Creighton", 13.47, 9)},
                    {new Team("Iowa", 23.53, 5), new Team("Richmond", 9.82, 12)},
                    {new Team("Providence", 13.88, 4), new Team("South Dakota St.", 11.44, 13)},
                    {new Team("LSU", 19.08, 6), new Team("Iowa St.", 13.95, 11)},
                    {new Team("Wisconsin", 15.58, 3), new Team("Colgate", 4.22, 14)},
                    {new Team("USC", 14.45, 7), new Team("Miami FL", 12.62, 10)},
                    {new Team("Auburn", 24.45, 2), new Team("Jacksonville St.", 2.24, 15)},
            },
            { //Second Round
                    {new Team(0), new Team(1)},
                    {new Team(2), new Team(3)},
                    {new Team(4), new Team(5)},
                    {new Team(6), new Team(7)},
                    {new Team(8), new Team(9)},
                    {new Team(10), new Team(11)},
                    {new Team(12), new Team(13)},
                    {new Team(14), new Team(15)},
                    {new Team(16), new Team(17)},
                    {new Team(18), new Team(19)},
                    {new Team(20), new Team(21)},
                    {new Team(22), new Team(23)},
                    {new Team(24), new Team(25)},
                    {new Team(26), new Team(27)},
                    {new Team(28), new Team(29)},
                    {new Team(30), new Team(31)}
            },
            { //Sweet Sixteen
                    {new Team(0), new Team(1)},
                    {new Team(2), new Team(3)},
                    {new Team(4), new Team(5)},
                    {new Team(6), new Team(7)},
                    {new Team(8), new Team(9)},
                    {new Team(10), new Team(11)},
                    {new Team(12), new Team(13)},
                    {new Team(14), new Team(15)}
            },
            { //Elite Eight
                    {new Team(0), new Team(1)},
                    {new Team(2), new Team(3)},
                    {new Team(4), new Team(5)},
                    {new Team(6), new Team(7)}
            },
            { //Final Four
                    {new Team(0), new Team(1)},
                    {new Team(2), new Team(3)}
            },
            { //Championship
                    {new Team(0), new Team(1)}
            }
    };
    static byte[] generateBracket() {
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
            for (int j = 0; j < teamList[r].length; j++) {
                previousWinners[j] = teamWinners[j];
            }
        }
        return result;
    }
    static byte[] generateStats() {
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
                int w = 0;
                for (int i = 0; i < 1000000; i++) {
                    Team matchResult = battle(teamList[r][m][0], teamList[r][m][1]);
                    if (matchResult == teamList[r][m][1]) {
                        w++;
                    }
                }
                int t = 0;
                if (w >= 500000) {
                    result[pos] += pow;
                    t = 1;
                }
                //System.out.print(teamList[r][m][0].name);
                System.out.print(" ");
                System.out.print(1000000-w);
                System.out.print("-");
                System.out.print(w);
                System.out.print(" ");
                //System.out.println(teamList[r][m][1].name);
                if (pow == 1) {
                    pow = 128;
                    pos++;
                } else {
                    pow >>= 1;
                }
                teamWinners[m] = teamList[r][m][t];
            }
            for (int j = 0; j < teamList[r].length; j++) {
                previousWinners[j] = teamWinners[j];
            }
        }
        return result;
    }
    static byte[] generate1000000Brackets() {
        Team[] teamWinners = new Team[32];
        Team[] previousWinners = new Team[32];
        byte[] result = new byte[8000000];
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
                    Team matchResult = battle(teamList[r][m][0], teamList[r][m][1]);
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
                for (int j = 0; j < teamList[r].length; j++) {
                    previousWinners[j] = teamWinners[j];
                }
            }
            pow = 1;
            pos++;
        }
        return result;
    }
    static Team battle(Team t1, Team t2) {
        float ratingDiff = t1.rating - t2.rating;
        //base is -0.08f
        float likelinessFactor = Math.min(Math.max(-0.2f*ratingDiff/*Math.pow(Math.abs(ratingDiff),1.15)*/,-6.0f),6.0f);
        float randomness = rng.nextFloat();
        if (randomness > sigmoid(likelinessFactor)) {
            return t1;
        }
        return t2;
    }
    static float sigmoid(float x) {
        //return 1/(1+(float)Math.pow(Math.E,-1.0f*x));
        /*if (Math.abs(x) < 1) {
            return ((x/(1+Math.abs(x)))+1)/2;
        }
        return ((x*x*x/(1+Math.abs(x*x*x)))+1)/2;*/
        return sigmoidArray[(int)(x*1000+6000)];
    }
}

class Team {
    float rating;
    //int seed;
    //String name;
    byte placeholderFor;
    Team(String n, double r, int s) {
        rating = (float)r;
        //seed = s;
        //name = n;
        placeholderFor = -1;
    }
    Team(int p) {
        placeholderFor = (byte)p;
    }
}

/*class Generator implements Runnable {
    private Thread t;
    private String threadName;

    Generator(String name) {
        threadName = name;
        System.out.println("Loading " + threadName + "...");
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            Path path = Paths.get("brackets"+threadName+".brk21");
            long time = System.currentTimeMillis();
            for (int i = 1; i <= 1; i++) {
                for (int j = 0; j < 1000; j++) {
                    byte[] thisWorks = MarchMadness.generate10000Brackets();
                    Files.write(path, thisWorks, StandardOpenOption.APPEND);
                }
                System.out.print(i);
                System.out.println(" million brackets generated!");
            };
            System.out.print("Brackets generated in ");
            long diff = System.currentTimeMillis() - time;
            System.out.print(diff);
            System.out.println(" ms");
            long speed = 1000000000L/diff;
            System.out.print(speed);
            System.out.println(" brackets per second (Thread "+threadName+")");
        } catch (Exception e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " +  threadName + "...");
        if (t == null) {
            t = new Thread(this, threadName);
            t.start ();
        }
    }
}*/