package com.strategygames.rockpaperscissors;

import java.util.Random;

/**
 * Implementation of ComputerPlayer
 */

public class ComputerPlayer implements Player {
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;
    private int difficultyLevel;
    private Frequency frequency;
    private MarkovModel markovModel;

    ComputerPlayer() {
        numberOfWins = 0;
        numberOfLosses = 0;
        numberOfDraws = 0;
        difficultyLevel = 0;
        frequency = new Frequency();
        markovModel = new MarkovModel();
    }

    public int GetNumberOfWins() {
        return numberOfWins;
    }

    public int GetNumberOfLosses() {
        return numberOfLosses;
    }

    public int GetNumberOfDraws() {
        return numberOfDraws;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void TieMatch() {
        numberOfDraws = numberOfDraws + 1;
    }

    public void WonMatch() {
        numberOfWins = numberOfWins + 1;
    }

    public void LoseMatch() {
        numberOfLosses = numberOfLosses + 1;
    }

    public int GetRandomChoice() {
        return new Random().nextInt(Constants.MAX_COMPUTER_CHOICE) + 1;
    }

    public void RecordHumanOutput(int HumanChoice) {
        switch(difficultyLevel) {
            case 1:
                frequency.UpdateFrequencyCounter(HumanChoice);
                break;
            case 2:
                markovModel.UpdateFrequencyCounter(HumanChoice);
                break;
        }
    }

    public int GetChoice() {
        int ComputerChoice;
        switch (difficultyLevel) {
            case 1:
                ComputerChoice = frequency.GetChoice();
                break;
            case 2:
                ComputerChoice = markovModel.GetChoice();
                break;
            default:
                ComputerChoice = GetRandomChoice();
        }
        return ComputerChoice;
    }
}
