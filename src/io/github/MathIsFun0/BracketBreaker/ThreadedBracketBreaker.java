package io.github.MathIsFun0.BracketBreaker;

public class ThreadedBracketBreaker {
    private final BracketBreaker[] bb;
    public ThreadedBracketBreaker(Team[][][] bracket, int threads, int reps, String fileOutput) {
        bb = new BracketBreaker[threads];
        for (int i = 0; i < bb.length; i++)
            bb[i] = new BracketBreaker(bracket, reps, fileOutput, i+1);
    }
    public static void main(String[] args) {
        new ThreadedBracketBreaker(Brackets.MarchMadness2022, 8, 40, "smol").run();
    }
    public void run() {
        for (BracketBreaker bracketBreaker : bb)
            new Thread(bracketBreaker).start();
    }
}
