package com.strategygames.rockpaperscissors;

public interface Player {
    int GetNumberOfWins();
    int GetNumberOfLosses();
    int GetNumberOfDraws();

    int GetChoice();

    void TieMatch();
    void WonMatch();
    void LoseMatch();
}
