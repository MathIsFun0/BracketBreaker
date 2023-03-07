package io.github.MathIsFun0.BracketBreaker;

public class GeneratorTeam extends Team {
    public int rating;
    public GeneratorTeam(String n, double r, int s) {
        rating = (int)(r*175);
        placeholderFor = -1;
    }
    public GeneratorTeam(int p){super(p);}
}
