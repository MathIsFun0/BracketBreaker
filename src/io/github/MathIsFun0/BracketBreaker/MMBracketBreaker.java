package io.github.MathIsFun0.BracketBreaker;

public class MMBracketBreaker extends BracketBreaker {
    private final int[][][] teamList;
    public MMBracketBreaker(int millionsToGenerate, String outputFileName, int ID) {
        generateSigmoidArray();
        teamList = Brackets.MarchMadness2022_Optimized;
        reps = millionsToGenerate;
        fileOutput = outputFileName;
        threadID = ID;
    }
    public byte[] generate1000000Brackets() {
        int[] teamWinners = new int[largestRoundLen];
        int[] previousWinners = new int[largestRoundLen];
        byte[] result = new byte[1000000*bytesPerBracket];
        int pos = 0;
        short pow = 128;
        for (int i = 0; i < 1000000; i++) {
            for (byte r = 0; r < 6; r++) {
                byte ml = (byte) teamList[r].length;
                for (byte m = 0; m < ml; m++) {
                    for (byte t = 0; t <= 1; t++) {
                        if (r >= 1)
                            teamList[r][m][t] = previousWinners[m*2+t];
                    }
                    teamWinners[m] = (rng.nextInt() > sigmoidArray[(teamList[r][m][1] - teamList[r][m][0])+6000]) ? teamList[r][m][0] : teamList[r][m][1];
                    if (teamWinners[m] == teamList[r][m][1]) {
                        result[pos] += pow;
                    }
                    pow >>= 1;
                    if (pow == 0) {
                        pow = 128;
                        pos++;
                    }
                }
                System.arraycopy(teamWinners, 0, previousWinners, 0, teamList[r].length);
            }
            if (pow != 128) {
                pow = 128;
                pos++;
            }
        }
        return result;
    }

    private int[] createArray() {
        return new int[largestRoundLen];
    }
    private byte[] createByteArray() {
        return new byte[1000000*bytesPerBracket];
    }
    private void updateTeamList(byte r, byte m, byte t, int[] previousWinners) {
        teamList[r][m][t] = previousWinners[m*2+t];
    }
    private int random() {
        return rng.nextInt();
    }
    private int doTheMath(byte r, byte m) {
      return (teamList[r][m][1] - teamList[r][m][0])+6000;
    }
    private int getFromArray(int i) {
        return sigmoidArray[i];
    }
    public byte[] generate1000000BracketsDebug() {
        int[] teamWinners = createArray();
        int[] previousWinners = createArray();
        byte[] result = createByteArray();
        int pos = 0;
        short pow = 128;
        for (int i = 0; i < 1000000; i++) {
            for (byte r = 0; r < 6; r++) {
                byte ml = (byte) teamList[r].length;
                for (byte m = 0; m < ml; m++) {
                    for (byte t = 0; t <= 1; t++) {
                        if (r >= 1)
                            updateTeamList(r, m, t, previousWinners);
                    }
                    teamWinners[m] = (random() > getFromArray(doTheMath(r, m))) ? teamList[r][m][0] : teamList[r][m][1];
                    if (teamWinners[m] == teamList[r][m][1]) {
                        result[pos] += pow;
                    }
                    pow >>= 1;
                    if (pow == 0) {
                        pow = 128;
                        pos++;
                    }
                }
                System.arraycopy(teamWinners, 0, previousWinners, 0, teamList[r].length);
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
