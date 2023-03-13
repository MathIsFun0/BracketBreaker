package io.github.MathIsFun0.BracketBreaker;

public class AnalyzerTeam extends Team {
    public int seed;
    public String name;
    public float rating;
    public AnalyzerTeam(String n, double r, int s) {
        name = n;
        seed = s;
        rating = (float)r;
        placeholderFor = -1;
    }
    public AnalyzerTeam(int p){super(p);}
}
