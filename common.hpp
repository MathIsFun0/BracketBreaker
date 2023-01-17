// Contains useful classes and methods for generation
#include <string>
#include <vector>
#include <random>

/*
Stores tournament information.
All defaults reference 2019 March Madness,
since it did not have a lot of upsets.
Will be updated to the latest year after First Four in 2023.
*/
struct Tournament {
    // The name of the tournament (useful for output)
    std::string name;

    // The list of seeds used in the tournament (useful for output)
    std::vector<std::string> seedList;

    // The list of teams participating in the tournament, in seed order
    std::vector<std::string> teams;

    // The list of ratings for the teams
    std::vector<float> ratings;

    // How much a difference in rating affects predictions.
    // FiveThirtyEight uses 0.175364880682 for theirs.
    float ratingScale;

    // A representation of the tournament bracket.
    // A list of rounds, each of which are a list of matches.
    std::vector<std::vector<Match>> bracket;
    
    // A default constructor, using 2019 March Madness data
    Tournament();

    // A constructor that takes in the path to a file
    Tournament(std::string filePath);

    // Generates a filled-out tournament bracket
    bool* generate();
};

struct Match {
    // Stores references to teams (as an index of the previous round or the team list)
    int team1;
    int team2;

    // The type of reference each team refers to.
    TeamRefType ref1;
    TeamRefType ref2;

    // Stores ratings of teams (used during match calculation)
    int rat1;
    int rat2;

    // Stores strings to team names (used in string constructor)
    std::string teamStr1;
    std::string teamStr2;

    // Initializes Match (for use in bracket)
    Match(TeamRefType r1, int t1, TeamRefType r2, int t2);
    Match(TeamRefType r, int t1, int t2);
    Match(std::string s1, std::string s2); //seeds
    Match(int t1, int t2);

    // Uses ref1 and ref2 to assign proper team ratings
    void getRatings(std::vector<float> ratings, std::vector<Match> prevRound);

    // Simulates the outcome of a match.
    // Returns true if and only if team1 wins.
    bool simulate(std::mt19937 random);
};

enum TeamRefType {
    SEED,
    WINNER,
    LOSER
};