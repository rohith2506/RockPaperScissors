package com.strategygames.rockpaperscissors;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    static final int ROCK = 1;
    static final int PAPER = 2;
    static final int SCISSORS = 3;

    static final int MIN_HUMAN_CHOICE = 1;
    static final int MAX_HUMAN_CHOICE = 3;

    static final int MIN_DIFFICULTY_CHOICE = 0;
    static final int MAX_DIFFICULTY_CHOICE = 2;

    static final int MAX_COMPUTER_CHOICE = 3;

    static final int GAME_CHOICE_MAX_SIZE = 3;

    static final int HUMAN = 1;
    static final int COMPUTER = 2;
    static final int NONE = 0;

    static final Map<Integer, String> OptionsMap = new HashMap<Integer, String>();
    static {
        OptionsMap.put(ROCK, "Rock");
        OptionsMap.put(PAPER, "Paper");
        OptionsMap.put(SCISSORS, "Scissors");
    }

    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_CYAN = "\u001B[36m";
}
