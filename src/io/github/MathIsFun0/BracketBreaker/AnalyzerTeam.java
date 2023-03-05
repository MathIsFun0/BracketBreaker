package io.github.MathIsFun0.BracketBreaker;

public class AnalyzerTeam extends Team {
    public int seed;
    public String name;
    public AnalyzerTeam(String n, double r, int s) {
        name = n;
        seed = s;
        placeholderFor = -1;
    }
    public AnalyzerTeam(int p){super(p);}
}
