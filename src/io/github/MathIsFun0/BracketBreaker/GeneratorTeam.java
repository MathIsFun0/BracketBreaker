package io.github.MathIsFun0.BracketBreaker;

public class GeneratorTeam extends Team {
    public float rating;
    public GeneratorTeam(String n, double r, int s) {
        rating = (float)r;
        placeholderFor = -1;
    }
    public GeneratorTeam(int p){super(p);}
}
