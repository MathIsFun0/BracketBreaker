package io.github.MathIsFun0.BracketBreaker;

public class Team {
    public float rating;
    //int seed;
    //String name;
    public byte placeholderFor;
    public Team(String n, double r, int s) {
        rating = (float)r;
        //seed = s;
        //name = n;
        placeholderFor = -1;
    }
    public Team(int p) {
        placeholderFor = (byte)p;
    }
}