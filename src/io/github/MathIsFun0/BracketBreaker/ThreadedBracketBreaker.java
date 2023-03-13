package io.github.MathIsFun0.BracketBreaker;

import java.util.Scanner;

public class ThreadedBracketBreaker {
    private final BracketBreaker[] bb;
    public ThreadedBracketBreaker(GeneratorTeam[][][] bracket, int threads, int millions, String fileOutput) {
        bb = new BracketBreaker[threads];
        for (int i = 0; i < bb.length; i++)
            bb[i] = new BracketBreaker(bracket, millions, fileOutput, i+1);
    }
    public ThreadedBracketBreaker(int threads, int millions, String fileOutput) {
        bb = new MMBracketBreaker[threads];
        for (int i = 0; i < bb.length; i++)
            bb[i] = new MMBracketBreaker(millions, fileOutput, i+1);
    }
    public static void main(String[] args) {
        System.out.println("BracketBreaker v1.0.0");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of threads to use: ");
        int threads = scanner.nextInt();
        System.out.println("\nNote: Every million brackets takes up 8MB - file storage can be used very quickly!");
        System.out.print("Enter the number of brackets to generate (in millions): ");
        int millions = scanner.nextInt(); scanner.nextLine(); //Stuff I learned in AP Comp Sci actually coming to use here? No way...
        System.out.print("\nEnter the name of the file to save to (without any extension): ");
        String fileName = scanner.nextLine();
        System.out.println();
        new ThreadedBracketBreaker(threads, millions, fileName).run();
    }
    public void run() {
        for (BracketBreaker bracketBreaker : bb)
            new Thread(bracketBreaker).start();
    }
}
