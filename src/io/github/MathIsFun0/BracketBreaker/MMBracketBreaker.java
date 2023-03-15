package io.github.MathIsFun0.BracketBreaker;

public class MMBracketBreaker extends BracketBreaker {
    private final int[][] teamList;
    public MMBracketBreaker(int millionsToGenerate, String outputFileName, int ID, boolean splitThreads) {
        generateSigmoidArray();
        teamList = Brackets.MarchMadness2023_Optimized;
        reps = millionsToGenerate;
        fileOutput = outputFileName+(splitThreads ? ID : "");
        threadID = ID;
    }
    public byte[] generateBrackets(int numBrackets) {
        int[] teamWinners = new int[largestRoundLen];
        int[] previousWinners = new int[largestRoundLen];
        byte[] result = new byte[numBrackets*bytesPerBracket];
        int pos = 0;
        short pow = 128;
        byte ml = 64;
        for (int i = 0; i < numBrackets; i++) {
            ml = 64;
            for (byte r = 0; r < 6; r++) {
                ml >>= 1;
                for (byte m = 0; m < ml; m++) {
                    if (r == 0) {
                        teamWinners[m] = (rng.nextInt() > sigmoidArray[(teamList[m][1] - teamList[m][0]) + 6000]) ? teamList[m][0] : teamList[m][1];
                        if (teamWinners[m] == teamList[m][1]) {
                            result[pos] += pow;
                        }
                    } else {
                        teamWinners[m] = (rng.nextInt() > sigmoidArray[(previousWinners[m * 2 + 1] - previousWinners[m * 2]) + 6000]) ? previousWinners[m * 2] : previousWinners[m * 2 + 1];
                        if (teamWinners[m] == previousWinners[m * 2 + 1]) {
                            result[pos] += pow;
                        }
                    }
                    pow >>= 1;
                    if (pow == 0) {
                        pow = 128;
                        pos++;
                    }
                }
                System.arraycopy(teamWinners, 0, previousWinners, 0, ml);
            }
            if (pow != 128) {
                pow = 128;
                pos++;
            }
        }
        return result;
    }

    /*public void repeatedGenerateAndSave(int threadID) throws IOException {
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
            byte[] thisWorks = generate1000000BracketsDebug();
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
    }*/
}
