package com.strategygames.rockpaperscissors;

import java.util.Scanner;

public class Game {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private int DifficultyLevel;

    Game() {
        humanPlayer = new HumanPlayer();
        computerPlayer = new ComputerPlayer();
        DifficultyLevel = 0;
    }

    private void ShowWelComeMessage() {
        System.out.println("\t\t\t#########################################################");
        System.out.println("\t\t\t#          Welcome to Rock Paper Scissors               #");
        System.out.println("\t\t\t#########################################################");
    }

    private int GetNumberOfGamesUserWantsToPlay() {
        Scanner scanner = new Scanner(System.in);
        int numberOfGames = 0;
        boolean validInput = false;

        System.out.println(Constants.ANSI_CYAN +  "\n\nEnter number of games you want to play against the Computer");

        do {
            System.out.print(Constants.ANSI_CYAN + "Enter a number: ");
            if(scanner.hasNextInt()) {
                numberOfGames = scanner.nextInt();
                validInput = true;
            } else {
                scanner.nextLine();
                System.out.println("Please Enter Valid Integer Value");
            }
        } while(!validInput);

        System.out.println(Constants.ANSI_CYAN + "Total number of games: " + numberOfGames + Constants.ANSI_RESET);

        return numberOfGames;
    }

    private void SetGameDifficultyLevel() {
        System.out.println(Constants.ANSI_BLUE + "\n\t\tDifficulty Levels");
        System.out.println(Constants.ANSI_BLUE + "0) Computer will play completely random irrespective of previous results");
        System.out.println(Constants.ANSI_BLUE + "1) Computer will try to record your entries and predict your next step based on a naive counting algorithm");
        System.out.println(Constants.ANSI_BLUE + "2) Computer will try to predict based on Markov Model");

        DifficultyLevel = Utils.GetHumanChoice(Constants.MIN_DIFFICULTY_CHOICE, Constants.MAX_DIFFICULTY_CHOICE);
        computerPlayer.setDifficultyLevel(DifficultyLevel);
        System.out.println(Constants.ANSI_BLUE + "You chose difficulty level:  " + DifficultyLevel + Constants.ANSI_RESET);
    }

    private int GetWinnerOfGame(int HumanChoice, int ComputerChoice) {
        if(HumanChoice == ComputerChoice) {
            return Constants.NONE;
        } else {
            if(HumanChoice == Constants.PAPER) {
                if (ComputerChoice == Constants.ROCK)
                    return Constants.HUMAN;
                else
                    return Constants.COMPUTER;
            }
            else if(HumanChoice == Constants.ROCK) {
                if (ComputerChoice == Constants.SCISSORS)
                    return Constants.HUMAN;
                else
                    return Constants.COMPUTER;
            }
            else {
                if(ComputerChoice == Constants.PAPER)
                    return Constants.HUMAN;
                else
                    return Constants.COMPUTER;
            }
        }
    }

    public void ShowGameStats(int HumanChoice, int ComputerChoice, int Winner) {
        System.out.print("Result: ");
        if(Winner == Constants.HUMAN) {
            System.out.print("You Won the game");
        } else if(Winner == Constants.COMPUTER) {
            System.out.print("Computer won the game");
        } else {
            System.out.print("It's a tie");
        }
        System.out.println();
    }

    private void PlayGame(int GameNumber) {
        System.out.println("\n\n");
        System.out.println("############ Game " + GameNumber + " ##############");
        int HumanChoice = humanPlayer.GetChoice();
        int ComputerChoice = computerPlayer.GetChoice();

        String HumanConvertedChoice = Constants.OptionsMap.get(HumanChoice);
        String ComputerConvertedChoice = Constants.OptionsMap.get(ComputerChoice);

        System.out.println("\n\n");
        System.out.println("You chose: " + HumanConvertedChoice);
        System.out.println("Computer chose: " + ComputerConvertedChoice);

        int HumanOrComputer = GetWinnerOfGame(HumanChoice, ComputerChoice);

        if(HumanOrComputer == Constants.HUMAN) {
            humanPlayer.WonMatch();
            computerPlayer.LoseMatch();
            ShowGameStats(HumanChoice, ComputerChoice, Constants.HUMAN);
        } else if(HumanOrComputer == Constants.COMPUTER) {
            humanPlayer.LoseMatch();
            computerPlayer.WonMatch();
            ShowGameStats(HumanChoice, ComputerChoice, Constants.COMPUTER);
        } else {
            humanPlayer.TieMatch();
            computerPlayer.TieMatch();
            ShowGameStats(HumanChoice, ComputerChoice, Constants.NONE);
        }

        computerPlayer.RecordHumanOutput(HumanChoice);
    }

    private void ShowFinalStats() {
        System.out.println("\n\n");
        System.out.println(Constants.ANSI_GREEN + "Final Stats");
        System.out.println(Constants.ANSI_GREEN + "Player\t\tWins\tLosses\tDraw");
        System.out.println(Constants.ANSI_GREEN + "You\t\t" + humanPlayer.GetNumberOfWins() + "\t" + humanPlayer.GetNumberOfLosses() + "\t" + humanPlayer.GetNumberOfDraws());
        System.out.println(Constants.ANSI_GREEN + "Computer\t" + computerPlayer.GetNumberOfWins() + "\t" + computerPlayer.GetNumberOfLosses() + "\t" + computerPlayer.GetNumberOfDraws());
        System.out.println(Constants.ANSI_GREEN +"\nFinal result: ");
        if(humanPlayer.GetNumberOfWins() > computerPlayer.GetNumberOfWins()) {
            System.out.print(Constants.ANSI_GREEN +"You are the Champion. Congratulations!!");
        } else if(humanPlayer.GetNumberOfWins() < computerPlayer.GetNumberOfWins()) {
            System.out.print(Constants.ANSI_GREEN + "Computer wins. Singularity is near");
        } else {
            System.out.print(Constants.ANSI_GREEN + "No one wins");
        }
    }

    public void EnterGamePlayMode() {
        ShowWelComeMessage();
        int numberOfGames = GetNumberOfGamesUserWantsToPlay();
        SetGameDifficultyLevel();
        for(int GameNumber = 1 ; GameNumber <= numberOfGames; GameNumber++) {
            PlayGame(GameNumber);
        }
        ShowFinalStats();
    }

}
