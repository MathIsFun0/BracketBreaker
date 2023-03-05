package io.github.MathIsFun0.BracketBreaker;

public class Brackets {
    public static GeneratorTeam[][][] MarchMadness2022 = {
            // Doesn't include the First Four. Uses FiveThirtyEight ratings.
            { //First Round
                    {new GeneratorTeam("Gonzaga", 96.46, 1), new GeneratorTeam("Georgia State", 73.46, 16)},
                    {new GeneratorTeam("Boise State", 82.49, 8), new GeneratorTeam("Memphis", 84.91, 9)},
                    {new GeneratorTeam("Connecticut", 86.37, 5), new GeneratorTeam("New Mexico State", 77.68, 12)},
                    {new GeneratorTeam("Arkansas", 86.77, 4), new GeneratorTeam("Vermont", 80.32, 13)},
                    {new GeneratorTeam("Alabama", 85.15, 6), new GeneratorTeam("Notre Dame", 82.10, 11)},
                    {new GeneratorTeam("Texas Tech", 88.70, 3), new GeneratorTeam("Montana State", 74.30, 14)},
                    {new GeneratorTeam("Michigan State", 83.46, 7), new GeneratorTeam("Davidson", 81.83, 10)},
                    {new GeneratorTeam("Duke", 89.28, 2), new GeneratorTeam("Cal State Fullerton", 71.78, 15)},
                    {new GeneratorTeam("Baylor", 87.66, 1), new GeneratorTeam("Norfolk State", 71.39, 16)},
                    {new GeneratorTeam("North Carolina", 83.99, 8), new GeneratorTeam("Marquette", 81.90, 9)},
                    {new GeneratorTeam("Saint Mary's (CA)", 84.34, 5), new GeneratorTeam("Indiana", 83.43, 12)},
                    {new GeneratorTeam("UCLA", 89.83, 4), new GeneratorTeam("Akron", 76.69, 13)},
                    {new GeneratorTeam("Texas", 86.32, 6), new GeneratorTeam("Virginia Tech", 84.68, 11)},
                    {new GeneratorTeam("Purdue", 89.10, 3), new GeneratorTeam("Yale", 74.74, 14)},
                    {new GeneratorTeam("Murray State", 81.35, 7), new GeneratorTeam("San Francisco", 81.78, 10)},
                    {new GeneratorTeam("Kentucky", 91.22, 2), new GeneratorTeam("Saint Peter's", 74.17, 15)},
                    {new GeneratorTeam("Arizona", 90.92, 1), new GeneratorTeam("Wright State", 74.25, 16)},
                    {new GeneratorTeam("Seton Hall", 82.61, 8), new GeneratorTeam("Texas Christian", 81.93, 9)},
                    {new GeneratorTeam("Houston", 88.72, 5), new GeneratorTeam("Alabama-Birmingham", 81.17, 12)},
                    {new GeneratorTeam("Illinois", 86.76, 4), new GeneratorTeam("Chattanooga", 78.70, 13)},
                    {new GeneratorTeam("Colorado State", 81.65, 6), new GeneratorTeam("Michigan", 84.73, 11)},
                    {new GeneratorTeam("Tennessee", 88.87, 3), new GeneratorTeam("Longwood", 73.42, 14)},
                    {new GeneratorTeam("Ohio State", 84.15, 7), new GeneratorTeam("Loyola Chicago", 83.70, 10)},
                    {new GeneratorTeam("Villanova", 90.22, 2), new GeneratorTeam("Delaware", 73.57, 15)},
                    {new GeneratorTeam("Kansas", 91.27, 1), new GeneratorTeam("Texas Southern", 71.14, 16)},
                    {new GeneratorTeam("San Diego State", 83.49, 8), new GeneratorTeam("Creighton", 81.49, 9)},
                    {new GeneratorTeam("Iowa", 88.96, 5), new GeneratorTeam("Richmond", 79.91, 12)},
                    {new GeneratorTeam("Providence", 82.72, 4), new GeneratorTeam("South Dakota State", 79.67, 13)},
                    {new GeneratorTeam("Louisiana State", 85.72, 6), new GeneratorTeam("Iowa State", 80.57, 11)},
                    {new GeneratorTeam("Wisconsin", 84.66, 3), new GeneratorTeam("Colgate", 76.40, 14)},
                    {new GeneratorTeam("Southern California", 83.02, 7), new GeneratorTeam("Miami (FL)", 81.13, 10)},
                    {new GeneratorTeam("Auburn", 89.48, 2), new GeneratorTeam("Jacksonville State", 73.15, 15)},
            },
            { //Second Round
                    {new GeneratorTeam(0), new GeneratorTeam(1)},
                    {new GeneratorTeam(2), new GeneratorTeam(3)},
                    {new GeneratorTeam(4), new GeneratorTeam(5)},
                    {new GeneratorTeam(6), new GeneratorTeam(7)},
                    {new GeneratorTeam(8), new GeneratorTeam(9)},
                    {new GeneratorTeam(10), new GeneratorTeam(11)},
                    {new GeneratorTeam(12), new GeneratorTeam(13)},
                    {new GeneratorTeam(14), new GeneratorTeam(15)},
                    {new GeneratorTeam(16), new GeneratorTeam(17)},
                    {new GeneratorTeam(18), new GeneratorTeam(19)},
                    {new GeneratorTeam(20), new GeneratorTeam(21)},
                    {new GeneratorTeam(22), new GeneratorTeam(23)},
                    {new GeneratorTeam(24), new GeneratorTeam(25)},
                    {new GeneratorTeam(26), new GeneratorTeam(27)},
                    {new GeneratorTeam(28), new GeneratorTeam(29)},
                    {new GeneratorTeam(30), new GeneratorTeam(31)}
            },
            { //Sweet Sixteen
                    {new GeneratorTeam(0), new GeneratorTeam(1)},
                    {new GeneratorTeam(2), new GeneratorTeam(3)},
                    {new GeneratorTeam(4), new GeneratorTeam(5)},
                    {new GeneratorTeam(6), new GeneratorTeam(7)},
                    {new GeneratorTeam(8), new GeneratorTeam(9)},
                    {new GeneratorTeam(10), new GeneratorTeam(11)},
                    {new GeneratorTeam(12), new GeneratorTeam(13)},
                    {new GeneratorTeam(14), new GeneratorTeam(15)}
            },
            { //Elite Eight
                    {new GeneratorTeam(0), new GeneratorTeam(1)},
                    {new GeneratorTeam(2), new GeneratorTeam(3)},
                    {new GeneratorTeam(4), new GeneratorTeam(5)},
                    {new GeneratorTeam(6), new GeneratorTeam(7)}
            },
            { //Final Four
                    {new GeneratorTeam(0), new GeneratorTeam(1)},
                    {new GeneratorTeam(2), new GeneratorTeam(3)}
            },
            { //Championship
                    {new GeneratorTeam(0), new GeneratorTeam(1)}
            }
    };

    public static AnalyzerTeam[][][] MarchMadness2022Analyzer = {
            // Doesn't include the First Four. Uses FiveThirtyEight ratings.
            { //First Round
                    {new AnalyzerTeam("Gonzaga", 96.46, 1), new AnalyzerTeam("Georgia State", 73.46, 16)},
                    {new AnalyzerTeam("Boise State", 82.49, 8), new AnalyzerTeam("Memphis", 84.91, 9)},
                    {new AnalyzerTeam("Connecticut", 86.37, 5), new AnalyzerTeam("New Mexico State", 77.68, 12)},
                    {new AnalyzerTeam("Arkansas", 86.77, 4), new AnalyzerTeam("Vermont", 80.32, 13)},
                    {new AnalyzerTeam("Alabama", 85.15, 6), new AnalyzerTeam("Notre Dame", 82.10, 11)},
                    {new AnalyzerTeam("Texas Tech", 88.70, 3), new AnalyzerTeam("Montana State", 74.30, 14)},
                    {new AnalyzerTeam("Michigan State", 83.46, 7), new AnalyzerTeam("Davidson", 81.83, 10)},
                    {new AnalyzerTeam("Duke", 89.28, 2), new AnalyzerTeam("Cal State Fullerton", 71.78, 15)},
                    {new AnalyzerTeam("Baylor", 87.66, 1), new AnalyzerTeam("Norfolk State", 71.39, 16)},
                    {new AnalyzerTeam("North Carolina", 83.99, 8), new AnalyzerTeam("Marquette", 81.90, 9)},
                    {new AnalyzerTeam("Saint Mary's (CA)", 84.34, 5), new AnalyzerTeam("Indiana", 83.43, 12)},
                    {new AnalyzerTeam("UCLA", 89.83, 4), new AnalyzerTeam("Akron", 76.69, 13)},
                    {new AnalyzerTeam("Texas", 86.32, 6), new AnalyzerTeam("Virginia Tech", 84.68, 11)},
                    {new AnalyzerTeam("Purdue", 89.10, 3), new AnalyzerTeam("Yale", 74.74, 14)},
                    {new AnalyzerTeam("Murray State", 81.35, 7), new AnalyzerTeam("San Francisco", 81.78, 10)},
                    {new AnalyzerTeam("Kentucky", 91.22, 2), new AnalyzerTeam("Saint Peter's", 74.17, 15)},
                    {new AnalyzerTeam("Arizona", 90.92, 1), new AnalyzerTeam("Wright State", 74.25, 16)},
                    {new AnalyzerTeam("Seton Hall", 82.61, 8), new AnalyzerTeam("Texas Christian", 81.93, 9)},
                    {new AnalyzerTeam("Houston", 88.72, 5), new AnalyzerTeam("Alabama-Birmingham", 81.17, 12)},
                    {new AnalyzerTeam("Illinois", 86.76, 4), new AnalyzerTeam("Chattanooga", 78.70, 13)},
                    {new AnalyzerTeam("Colorado State", 81.65, 6), new AnalyzerTeam("Michigan", 84.73, 11)},
                    {new AnalyzerTeam("Tennessee", 88.87, 3), new AnalyzerTeam("Longwood", 73.42, 14)},
                    {new AnalyzerTeam("Ohio State", 84.15, 7), new AnalyzerTeam("Loyola Chicago", 83.70, 10)},
                    {new AnalyzerTeam("Villanova", 90.22, 2), new AnalyzerTeam("Delaware", 73.57, 15)},
                    {new AnalyzerTeam("Kansas", 91.27, 1), new AnalyzerTeam("Texas Southern", 71.14, 16)},
                    {new AnalyzerTeam("San Diego State", 83.49, 8), new AnalyzerTeam("Creighton", 81.49, 9)},
                    {new AnalyzerTeam("Iowa", 88.96, 5), new AnalyzerTeam("Richmond", 79.91, 12)},
                    {new AnalyzerTeam("Providence", 82.72, 4), new AnalyzerTeam("South Dakota State", 79.67, 13)},
                    {new AnalyzerTeam("Louisiana State", 85.72, 6), new AnalyzerTeam("Iowa State", 80.57, 11)},
                    {new AnalyzerTeam("Wisconsin", 84.66, 3), new AnalyzerTeam("Colgate", 76.40, 14)},
                    {new AnalyzerTeam("Southern California", 83.02, 7), new AnalyzerTeam("Miami (FL)", 81.13, 10)},
                    {new AnalyzerTeam("Auburn", 89.48, 2), new AnalyzerTeam("Jacksonville State", 73.15, 15)},
            },
            { //Second Round
                    {new AnalyzerTeam(0), new AnalyzerTeam(1)},
                    {new AnalyzerTeam(2), new AnalyzerTeam(3)},
                    {new AnalyzerTeam(4), new AnalyzerTeam(5)},
                    {new AnalyzerTeam(6), new AnalyzerTeam(7)},
                    {new AnalyzerTeam(8), new AnalyzerTeam(9)},
                    {new AnalyzerTeam(10), new AnalyzerTeam(11)},
                    {new AnalyzerTeam(12), new AnalyzerTeam(13)},
                    {new AnalyzerTeam(14), new AnalyzerTeam(15)},
                    {new AnalyzerTeam(16), new AnalyzerTeam(17)},
                    {new AnalyzerTeam(18), new AnalyzerTeam(19)},
                    {new AnalyzerTeam(20), new AnalyzerTeam(21)},
                    {new AnalyzerTeam(22), new AnalyzerTeam(23)},
                    {new AnalyzerTeam(24), new AnalyzerTeam(25)},
                    {new AnalyzerTeam(26), new AnalyzerTeam(27)},
                    {new AnalyzerTeam(28), new AnalyzerTeam(29)},
                    {new AnalyzerTeam(30), new AnalyzerTeam(31)}
            },
            { //Sweet Sixteen
                    {new AnalyzerTeam(0), new AnalyzerTeam(1)},
                    {new AnalyzerTeam(2), new AnalyzerTeam(3)},
                    {new AnalyzerTeam(4), new AnalyzerTeam(5)},
                    {new AnalyzerTeam(6), new AnalyzerTeam(7)},
                    {new AnalyzerTeam(8), new AnalyzerTeam(9)},
                    {new AnalyzerTeam(10), new AnalyzerTeam(11)},
                    {new AnalyzerTeam(12), new AnalyzerTeam(13)},
                    {new AnalyzerTeam(14), new AnalyzerTeam(15)}
            },
            { //Elite Eight
                    {new AnalyzerTeam(0), new AnalyzerTeam(1)},
                    {new AnalyzerTeam(2), new AnalyzerTeam(3)},
                    {new AnalyzerTeam(4), new AnalyzerTeam(5)},
                    {new AnalyzerTeam(6), new AnalyzerTeam(7)}
            },
            { //Final Four
                    {new AnalyzerTeam(0), new AnalyzerTeam(1)},
                    {new AnalyzerTeam(2), new AnalyzerTeam(3)}
            },
            { //Championship
                    {new AnalyzerTeam(0), new AnalyzerTeam(1)}
            }
    };
}
