package com.strategygames.rockpaperscissors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanPlayerTest {
    private static HumanPlayer humanPlayer;

    @BeforeClass
    public static void initComputerPlatyer() {
        humanPlayer = new HumanPlayer();
    }

    @Test
    public void TestInitValues() {
        assertEquals(humanPlayer.GetNumberOfWins(), 0);
        assertEquals(humanPlayer.GetNumberOfLosses(), 0);
        assertEquals(humanPlayer.GetNumberOfDraws(), 0);
    }
}