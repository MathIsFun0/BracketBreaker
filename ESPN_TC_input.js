// Change how often upsets occur
var stability = 0.175;

// Generation
var bracket = new Array(63);
var ratings = [92.24, 69.40, 84.48, 84.14, 86.07, 79.76, 83.81, 78.22, 87.54, 81.44, 87.12, 75.51, 81.39, 83.49, 88.98, 74.83,
               89.60, 66.12, 84.18, 82.56, 87.13, 79.18, 86.87, 76.36, 86.03, 82.78, 84.46, 75.32, 83.82, 83.05, 87.59, 76.24,
               93.84, 72.87, 84.47, 84.86, 83.60, 81.17, 85.80, 79.37, 84.54, 81.39, 84.35, 73.28, 85.51, 82.66, 90.07, 73.57,
               89.61, 69.29, 85.12, 84.54, 85.87, 81.35, 89.23, 79.58, 85.42, 80.51, 89.90, 75.91, 82.24, 82.62, 88.26, 73.02]
var teamWinners = new Array(32);
var previousWinners = new Array(32);
var matchLen = 64;
var m = 0;
var winnerScore = 0;
var loserScore = 0;

//Some util functions for finding score
function logit(x) {
	return Math.log(x/(1-x));
}

for (var i = 0; i < 7; i++) {
    matchLen >>= 1;
    for (var j = 0; j < matchLen; j++) {
        team1 = ratings[2*j];
        team2 = ratings[2*j+1];
        if (i > 0) {
            team1 = previousWinners[2*j];
            team2 = previousWinners[2*j+1];
        }
        difference = team1 - team2;
        sigmoidVal = 1 / (1 + Math.exp(-1 * difference * stability));
        randNum = Math.random();
        if (randNum > sigmoidVal) {
            bracket[m] = "2";
            teamWinners[j] = team2;
        } else {
            bracket[m] = "1";
            teamWinners[j] = team1;
        }
        if (matchLen == 1) {
            var avgScore = Math.round(5*logit(Math.random())+54+((team1/10)+(team2/10)));
            var scoreDiff = Math.abs(Math.round(1.6*(logit(randNum)-difference)))
            if (scoreDiff == 0) {
                scoreDiff = 1
            }
            if (scoreDiff % 1 != 0) {
                avgScore += 0.5
            }
            winnerScore = avgScore + scoreDiff;
            loserScore = Math.max(avgScore - scoreDiff, 0);
        }
        m++;
    }
    previousWinners = teamWinners;
}

for (var i = 1; i < 64; i++) {
    document.querySelector("#bracketForm > div.bracketWrapper > div > div.mW.mW_" + Math.ceil(i/2)+" > div.matchup.m_"+i+" > div > a.slot.s_"+bracket[i-1]).click();
}
document.querySelector("#t1").value = winnerScore;
document.querySelector("#t2").value = loserScore;