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

    public static int[][][] MarchMadness2022_Optimized_OUTDATED = {
            // Doesn't include the First Four. Uses FiveThirtyEight ratings.
            { //First Round
                    {new GeneratorTeam("Gonzaga", 96.46, 1).toInt(), new GeneratorTeam("Georgia State", 73.46, 16).toInt()},
                    {new GeneratorTeam("Boise State", 82.49, 8).toInt(), new GeneratorTeam("Memphis", 84.91, 9).toInt()},
                    {new GeneratorTeam("Connecticut", 86.37, 5).toInt(), new GeneratorTeam("New Mexico State", 77.68, 12).toInt()},
                    {new GeneratorTeam("Arkansas", 86.77, 4).toInt(), new GeneratorTeam("Vermont", 80.32, 13).toInt()},
                    {new GeneratorTeam("Alabama", 85.15, 6).toInt(), new GeneratorTeam("Notre Dame", 82.10, 11).toInt()},
                    {new GeneratorTeam("Texas Tech", 88.70, 3).toInt(), new GeneratorTeam("Montana State", 74.30, 14).toInt()},
                    {new GeneratorTeam("Michigan State", 83.46, 7).toInt(), new GeneratorTeam("Davidson", 81.83, 10).toInt()},
                    {new GeneratorTeam("Duke", 89.28, 2).toInt(), new GeneratorTeam("Cal State Fullerton", 71.78, 15).toInt()},
                    {new GeneratorTeam("Baylor", 87.66, 1).toInt(), new GeneratorTeam("Norfolk State", 71.39, 16).toInt()},
                    {new GeneratorTeam("North Carolina", 83.99, 8).toInt(), new GeneratorTeam("Marquette", 81.90, 9).toInt()},
                    {new GeneratorTeam("Saint Mary's (CA)", 84.34, 5).toInt(), new GeneratorTeam("Indiana", 83.43, 12).toInt()},
                    {new GeneratorTeam("UCLA", 89.83, 4).toInt(), new GeneratorTeam("Akron", 76.69, 13).toInt()},
                    {new GeneratorTeam("Texas", 86.32, 6).toInt(), new GeneratorTeam("Virginia Tech", 84.68, 11).toInt()},
                    {new GeneratorTeam("Purdue", 89.10, 3).toInt(), new GeneratorTeam("Yale", 74.74, 14).toInt()},
                    {new GeneratorTeam("Murray State", 81.35, 7).toInt(), new GeneratorTeam("San Francisco", 81.78, 10).toInt()},
                    {new GeneratorTeam("Kentucky", 91.22, 2).toInt(), new GeneratorTeam("Saint Peter's", 74.17, 15).toInt()},
                    {new GeneratorTeam("Arizona", 90.92, 1).toInt(), new GeneratorTeam("Wright State", 74.25, 16).toInt()},
                    {new GeneratorTeam("Seton Hall", 82.61, 8).toInt(), new GeneratorTeam("Texas Christian", 81.93, 9).toInt()},
                    {new GeneratorTeam("Houston", 88.72, 5).toInt(), new GeneratorTeam("Alabama-Birmingham", 81.17, 12).toInt()},
                    {new GeneratorTeam("Illinois", 86.76, 4).toInt(), new GeneratorTeam("Chattanooga", 78.70, 13).toInt()},
                    {new GeneratorTeam("Colorado State", 81.65, 6).toInt(), new GeneratorTeam("Michigan", 84.73, 11).toInt()},
                    {new GeneratorTeam("Tennessee", 88.87, 3).toInt(), new GeneratorTeam("Longwood", 73.42, 14).toInt()},
                    {new GeneratorTeam("Ohio State", 84.15, 7).toInt(), new GeneratorTeam("Loyola Chicago", 83.70, 10).toInt()},
                    {new GeneratorTeam("Villanova", 90.22, 2).toInt(), new GeneratorTeam("Delaware", 73.57, 15).toInt()},
                    {new GeneratorTeam("Kansas", 91.27, 1).toInt(), new GeneratorTeam("Texas Southern", 71.14, 16).toInt()},
                    {new GeneratorTeam("San Diego State", 83.49, 8).toInt(), new GeneratorTeam("Creighton", 81.49, 9).toInt()},
                    {new GeneratorTeam("Iowa", 88.96, 5).toInt(), new GeneratorTeam("Richmond", 79.91, 12).toInt()},
                    {new GeneratorTeam("Providence", 82.72, 4).toInt(), new GeneratorTeam("South Dakota State", 79.67, 13).toInt()},
                    {new GeneratorTeam("Louisiana State", 85.72, 6).toInt(), new GeneratorTeam("Iowa State", 80.57, 11).toInt()},
                    {new GeneratorTeam("Wisconsin", 84.66, 3).toInt(), new GeneratorTeam("Colgate", 76.40, 14).toInt()},
                    {new GeneratorTeam("Southern California", 83.02, 7).toInt(), new GeneratorTeam("Miami (FL)", 81.13, 10).toInt()},
                    {new GeneratorTeam("Auburn", 89.48, 2).toInt(), new GeneratorTeam("Jacksonville State", 73.15, 15).toInt()},
            },
            { //Second Round
                    {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}
            },
            { //Sweet Sixteen
                    {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}
            },
            { //Elite Eight
                    {0,0},{0,0},{0,0},{0,0}
            },
            { //Final Four
                    {0,0},{0,0}
            },
            { //Championship
                    {0,0}
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

    public static int[][] MarchMadness2023_Optimized = {
            // Includes the First Four. Uses FiveThirtyEight ratings.
            // For First Four, the rating is a weighted average of the teams, plus 1/2.
                    {new GeneratorTeam("Alabama", 92.24, 1).toInt(), new GeneratorTeam("TAMU-CC/SEMO", 69.40, 16).toInt()},
                    {new GeneratorTeam("Maryland", 84.48, 8).toInt(), new GeneratorTeam("West Virginia", 84.14, 9).toInt()},
                    {new GeneratorTeam("San Diego St.", 86.07, 5).toInt(), new GeneratorTeam("Charleston Col.", 79.76, 12).toInt()},
                    {new GeneratorTeam("Virginia", 83.81, 4).toInt(), new GeneratorTeam("Furman", 78.22, 13).toInt()},
                    {new GeneratorTeam("Creighton", 87.54, 6).toInt(), new GeneratorTeam("North Carolina St.", 81.44, 11).toInt()},
                    {new GeneratorTeam("Baylor", 87.12, 3).toInt(), new GeneratorTeam("UC-Santa Barbara", 75.51, 14).toInt()},
                    {new GeneratorTeam("Missouri", 81.39, 7).toInt(), new GeneratorTeam("Utah St.", 83.49, 10).toInt()},
                    {new GeneratorTeam("Arizona", 88.98, 2).toInt(), new GeneratorTeam("Princeton", 74.83, 15).toInt()},
                    {new GeneratorTeam("Purdue", 89.60, 1).toInt(), new GeneratorTeam("TXSO/FDU", 66.12, 16).toInt()},
                    {new GeneratorTeam("Memphis", 84.18, 8).toInt(), new GeneratorTeam("Florida Atlantic", 82.56, 9).toInt()},
                    {new GeneratorTeam("Duke", 87.13, 5).toInt(), new GeneratorTeam("Oral Roberts", 79.18, 12).toInt()},
                    {new GeneratorTeam("Tennessee", 86.87, 4).toInt(), new GeneratorTeam("Louisiana", 76.36, 13).toInt()},
                    {new GeneratorTeam("Kentucky", 86.03, 6).toInt(), new GeneratorTeam("Providence", 82.78, 11).toInt()},
                    {new GeneratorTeam("Kansas St.", 84.46, 3).toInt(), new GeneratorTeam("Montana St.", 75.32, 14).toInt()},
                    {new GeneratorTeam("Michigan St.", 83.82, 7).toInt(), new GeneratorTeam("USC", 83.05, 10).toInt()},
                    {new GeneratorTeam("Marquette", 87.59, 2).toInt(), new GeneratorTeam("Vermont", 76.24, 15).toInt()},
                    {new GeneratorTeam("Houston", 93.84, 1).toInt(), new GeneratorTeam("N. Kentucky", 72.87, 16).toInt()},
                    {new GeneratorTeam("Iowa", 84.47, 8).toInt(), new GeneratorTeam("Auburn", 84.86, 9).toInt()},
                    {new GeneratorTeam("Miami FL", 83.60, 5).toInt(), new GeneratorTeam("Drake", 81.17, 12).toInt()},
                    {new GeneratorTeam("Indiana", 85.80, 4).toInt(), new GeneratorTeam("Kent St.", 79.37, 13).toInt()},
                    {new GeneratorTeam("Iowa St.", 84.54, 6).toInt(), new GeneratorTeam("MSU/Pitt", 81.39, 11).toInt()},
                    {new GeneratorTeam("Xavier", 84.35, 3).toInt(), new GeneratorTeam("Kennesaw St.", 73.28, 14).toInt()},
                    {new GeneratorTeam("Texas A&M", 85.51, 7).toInt(), new GeneratorTeam("Penn St.", 82.66, 10).toInt()},
                    {new GeneratorTeam("Texas", 90.07, 2).toInt(), new GeneratorTeam("Colgate", 73.57, 15).toInt()},
                    {new GeneratorTeam("Kansas", 89.61, 1).toInt(), new GeneratorTeam("Howard", 69.29, 16).toInt()},
                    {new GeneratorTeam("Arkansas", 85.12, 8).toInt(), new GeneratorTeam("Illinois", 84.54, 9).toInt()},
                    {new GeneratorTeam("Saint Mary's CA", 85.87, 5).toInt(), new GeneratorTeam("VCU", 81.35, 12).toInt()},
                    {new GeneratorTeam("UConn", 89.23, 4).toInt(), new GeneratorTeam("Iona", 79.58, 13).toInt()},
                    {new GeneratorTeam("TCU", 85.42, 6).toInt(), new GeneratorTeam("ASU/Nevada", 80.51, 11).toInt()},
                    {new GeneratorTeam("Gonzaga", 89.90, 3).toInt(), new GeneratorTeam("Grand Canyon", 75.91, 14).toInt()},
                    {new GeneratorTeam("Northwestern", 82.24, 7).toInt(), new GeneratorTeam("Boise St.", 82.62, 10).toInt()},
                    {new GeneratorTeam("UCLA", 88.26, 2).toInt(), new GeneratorTeam("UNC-Asheville", 73.02, 15).toInt()}
    };

    public static AnalyzerTeam[][][] MarchMadness2023Analyzer = {
            // Doesn't include the First Four. Uses FiveThirtyEight ratings.
            { //First Round
                    {new AnalyzerTeam("Alabama", 92.24, 1), new AnalyzerTeam("TAMU-CC/SEMO", 69.40, 16)},
                    {new AnalyzerTeam("Maryland", 84.48, 8), new AnalyzerTeam("West Virginia", 84.14, 9)},
                    {new AnalyzerTeam("San Diego St.", 86.07, 5), new AnalyzerTeam("Charleston Col.", 79.76, 12)},
                    {new AnalyzerTeam("Virginia", 83.81, 4), new AnalyzerTeam("Furman", 78.22, 13)},
                    {new AnalyzerTeam("Creighton", 87.54, 6), new AnalyzerTeam("North Carolina St.", 81.44, 11)},
                    {new AnalyzerTeam("Baylor", 87.12, 3), new AnalyzerTeam("UC-Santa Barbara", 75.51, 14)},
                    {new AnalyzerTeam("Missouri", 81.39, 7), new AnalyzerTeam("Utah St.", 83.49, 10)},
                    {new AnalyzerTeam("Arizona", 88.98, 2), new AnalyzerTeam("Princeton", 74.83, 15)},
                    {new AnalyzerTeam("Purdue", 89.60, 1), new AnalyzerTeam("TXSO/FDU", 66.12, 16)},
                    {new AnalyzerTeam("Memphis", 84.18, 8), new AnalyzerTeam("Florida Atlantic", 82.56, 9)},
                    {new AnalyzerTeam("Duke", 87.13, 5), new AnalyzerTeam("Oral Roberts", 79.18, 12)},
                    {new AnalyzerTeam("Tennessee", 86.87, 4), new AnalyzerTeam("Louisiana", 76.36, 13)},
                    {new AnalyzerTeam("Kentucky", 86.03, 6), new AnalyzerTeam("Providence", 82.78, 11)},
                    {new AnalyzerTeam("Kansas St.", 84.46, 3), new AnalyzerTeam("Montana St.", 75.32, 14)},
                    {new AnalyzerTeam("Michigan St.", 83.82, 7), new AnalyzerTeam("USC", 83.05, 10)},
                    {new AnalyzerTeam("Marquette", 87.59, 2), new AnalyzerTeam("Vermont", 76.24, 15)},
                    {new AnalyzerTeam("Houston", 93.84, 1), new AnalyzerTeam("N. Kentucky", 72.87, 16)},
                    {new AnalyzerTeam("Iowa", 84.47, 8), new AnalyzerTeam("Auburn", 84.86, 9)},
                    {new AnalyzerTeam("Miami FL", 83.60, 5), new AnalyzerTeam("Drake", 81.17, 12)},
                    {new AnalyzerTeam("Indiana", 85.80, 4), new AnalyzerTeam("Kent St.", 79.37, 13)},
                    {new AnalyzerTeam("Iowa St.", 84.54, 6), new AnalyzerTeam("MSU/Pitt", 81.39, 11)},
                    {new AnalyzerTeam("Xavier", 84.35, 3), new AnalyzerTeam("Kennesaw St.", 73.28, 14)},
                    {new AnalyzerTeam("Texas A&M", 85.51, 7), new AnalyzerTeam("Penn St.", 82.66, 10)},
                    {new AnalyzerTeam("Texas", 90.07, 2), new AnalyzerTeam("Colgate", 73.57, 15)},
                    {new AnalyzerTeam("Kansas", 89.61, 1), new AnalyzerTeam("Howard", 69.29, 16)},
                    {new AnalyzerTeam("Arkansas", 85.12, 8), new AnalyzerTeam("Illinois", 84.54, 9)},
                    {new AnalyzerTeam("Saint Mary's CA", 85.87, 5), new AnalyzerTeam("VCU", 81.35, 12)},
                    {new AnalyzerTeam("UConn", 89.23, 4), new AnalyzerTeam("Iona", 79.58, 13)},
                    {new AnalyzerTeam("TCU", 85.42, 6), new AnalyzerTeam("ASU/Nevada", 80.51, 11)},
                    {new AnalyzerTeam("Gonzaga", 89.90, 3), new AnalyzerTeam("Grand Canyon", 75.91, 14)},
                    {new AnalyzerTeam("Northwestern", 82.24, 7), new AnalyzerTeam("Boise St.", 82.62, 10)},
                    {new AnalyzerTeam("UCLA", 88.26, 2), new AnalyzerTeam("UNC-Asheville", 73.02, 15)}
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
