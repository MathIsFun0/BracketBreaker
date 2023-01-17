#include "common.hpp"

// A default constructor, using 2019 March Madness data
Tournament::Tournament() {
    name = "2019 March Madness";

    seedList = {"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8",
                "E9","E10","E11","E12","E13","E14","E15","E16",
                "W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8",
                "W9","W10","W11","W12","W13","W14","W15","W16",
                "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8",
                "S9","S10","S11","S12","S13","S14","S15","S16",
                "M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8",
                "M9","M10","M11","M12","M13","M14","M15","M16"};
    
             //East
    teams = {"Duke", "Michigan St.", "LSU", "Virginia Tech", "Mississippi St.", "Maryland", "Louisville", "VCU",
             "UCF", "Minnesota", "Belmont", "Liberty", "Saint Louis", "Yale", "Bradley", "North Dakota St.",
             //West
             "Gonzaga", "Michigan", "Texas Tech", "Florida St.", "Marquette", "Buffalo", "Nevada", "Syracuse",
             "Baylor", "Florida", "Arizona St.", "Murray St.", "Vermont", "N. Kentucky", "Montana", "Fairleigh D.",
             //South
             "Virginia", "Tennessee", "Purdue", "Kansas St.", "Wisconsin", "Villanova", "Cincinnati", "Mississippi",
             "Oklahoma", "Iowa", "Saint Mary's", "Oregon", "UC Irvine", "Old Dominion", "Colgate", "Gardner-Webb",
             //Midwest
             "North Carolina", "Kentucky", "Houston", "Kansas", "Auburn", "Iowa St.", "Wofford", "Utah St.",
             "Washington", "Seton Hall", "Ohio St.", "New Mexico St.", "Northeastern", "Georgia St.", "Abilene C.", "Iona"};

    // In the actual tourney I'll use the more accurate ratings
    // Ratings from FiveThirtyEight
               //East
    ratings = {96.3, 92.3, 86.4, 89.3, 85.1, 84.8, 85.9, 81.7,
               81.7, 80.8, 81.7, 78.0, 77.0, 77.1, 72.9, 70.8,
               //West
               95.0, 91.0, 89.7, 88.4, 84.4, 85.7, 86.1, 83.9,
               80.8, 84.0, 81.9, 81.3, 79.3, 77.3, 76.2, 70.9,
               //South
               95.2, 91.3, 89.0, 86.7, 86.5, 87.0, 85.4, 81.6,
               83.0, 82.4, 83.6, 82.6, 78.4, 77.0, 75.0, 71.7,
               //Midwest
               93.2, 91.2, 87.9, 86.3, 89.0, 86.1, 84.4, 82.3,
               82.6, 82.2, 82.6, 80.9, 78.6, 76.3, 72.3, 71.9};

    ratingScale = 0.175364880682;

    std::vector<Match> round1 = {
        Match("E1", "E16"), Match("E8", "E9"), Match("E5", "E12"), Match("E4", "E13"),
        Match("E6", "E11"), Match("E3", "E14"), Match("E7", "E10"), Match("E2", "E15"),
        Match("W1", "W16"), Match("W8", "W9"), Match("W5", "W12"), Match("W4", "W13"),
        Match("W6", "W11"), Match("W3", "W14"), Match("W7", "W10"), Match("W2", "W15"),
        Match("S1", "S16"), Match("S8", "S9"), Match("S5", "S12"), Match("S4", "S13"),
        Match("S6", "S11"), Match("S3", "S14"), Match("S7", "S10"), Match("S2", "S15"),
        Match("M1", "M16"), Match("M8", "M9"), Match("M5", "M12"), Match("M4", "M13"),
        Match("M6", "M11"), Match("M3", "M14"), Match("M7", "M10"), Match("M2", "M15")
    };

    std::vector<Match> round2 = {
        Match(0, 1), Match(2, 3), Match(4, 5), Match(6, 7),
        Match(8, 9), Match(10, 11), Match(12, 13), Match(14, 15),
        Match(16, 17), Match(18, 19), Match(20, 21), Match(22, 23),
        Match(24, 25), Match(26, 27), Match(28, 29), Match(30, 31)
    };

    std::vector<Match> round3 = {
        Match(0, 1), Match(2, 3), Match(4, 5), Match(6, 7),
        Match(8, 9), Match(10, 11), Match(12, 13), Match(14, 15)
    };

    std::vector<Match> round4 = {
        Match(0, 1), Match(2, 3), Match(4, 5), Match(6, 7)
    };

    std::vector<Match> round5 = {
        Match(0, 1), Match(2, 3)
    };

    std::vector<Match> round6 = {
        Match(0, 1)
    };

    bracket = {round1, round2, round3, round4, round5, round6};
};