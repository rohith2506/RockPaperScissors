package com.strategygames.rockpaperscissors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerPlayerTest {
    private static ComputerPlayer computerPlayer;

    @BeforeClass
    public static void initComputerPlatyer() {
        computerPlayer = new ComputerPlayer();
    }

    @Test
    public void TestInitValues() {
        assertEquals(computerPlayer.GetNumberOfWins(), 0);
        assertEquals(computerPlayer.GetNumberOfLosses(), 0);
        assertEquals(computerPlayer.GetNumberOfDraws(), 0);
    }

    @Test
    public void getChoice() {
        int ComputerChoice = computerPlayer.GetChoice();
        int IsValid = 0;
        if(ComputerChoice >= 1 && ComputerChoice <= 3) IsValid = 1;
        assertEquals(IsValid, 1);
    }
}