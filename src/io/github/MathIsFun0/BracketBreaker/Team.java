package io.github.MathIsFun0.BracketBreaker;

public class Team {
    public byte placeholderFor;
    public Team(String n, double r, int s) {
        placeholderFor = -1;
    }
    public Team(int p) {
        placeholderFor = (byte)p;
    }
    public Team(){};
}