package com.strategygames.rockpaperscissors;

/**
 * Implementation of Markov Model.
 * This will create a transition matrix which stores the probability of state transitions
 */

public class MarkovModel {
    private int[][] TransitionMatrix = new int[Constants.GAME_CHOICE_MAX_SIZE][Constants.GAME_CHOICE_MAX_SIZE];
    private int HumanPreviousChoice;

    MarkovModel() {
        for(int i = 0; i < Constants.GAME_CHOICE_MAX_SIZE; i++) {
            for(int j = 0; j < Constants.GAME_CHOICE_MAX_SIZE; j++) {
                TransitionMatrix[i][j] = 0;
            }
        }
        HumanPreviousChoice = Constants.ROCK;
    }

    public void UpdateFrequencyCounter(int Choice) {
        TransitionMatrix[HumanPreviousChoice][Choice - 1] += 1;
        HumanPreviousChoice = Choice - 1;
    }

    public int GetChoice() {
        int predictedOpponentChoice = 0;
        int maxValue = 0;
        for(int i = 0; i < TransitionMatrix[HumanPreviousChoice].length; i++) {
            if(TransitionMatrix[HumanPreviousChoice][i] > maxValue) {
                maxValue = TransitionMatrix[HumanPreviousChoice][i];
                predictedOpponentChoice = i + 1;
            }
        }

        int selectedChoice;
        switch(predictedOpponentChoice) {
            case Constants.ROCK:
                selectedChoice = Constants.PAPER;
                break;
            case Constants.SCISSORS:
                selectedChoice = Constants.ROCK;
                break;
            default:
                selectedChoice = Constants.SCISSORS;
        }
        return selectedChoice;
    }
}
