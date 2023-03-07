package io.github.MathIsFun0.BracketBreaker;

import java.util.SplittableRandom;

public class MMBracketBreaker extends BracketBreaker {
    private int[][][] teamList;
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
}
