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
        this.numberOfWins = 0;
        this.numberOfLosses = 0;
        this.numberOfDraws = 0;
        this.difficultyLevel = 0;
        frequency = new Frequency();
        markovModel = new MarkovModel();
    }

    public int GetNumberOfWins() {
        return this.numberOfWins;
    }

    public int GetNumberOfLosses() {
        return this.numberOfLosses;
    }

    public int GetNumberOfDraws() {
        return this.numberOfDraws;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void TieMatch() {
        this.numberOfDraws = this.numberOfDraws + 1;
    }

    public void WonMatch() {
        this.numberOfWins = this.numberOfWins + 1;
    }

    public void LoseMatch() {
        this.numberOfLosses = this.numberOfLosses + 1;
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
