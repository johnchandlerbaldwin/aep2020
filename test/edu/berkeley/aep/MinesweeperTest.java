package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinesweeperTest {

    @Test
    public void initializeMineSpotsShouldReturnAllocationBetweenZeroAndRowNumber(){
        Minesweeper game = new Minesweeper(8);

        int[][] random_mines = game.initialize_mine_spots(8, 1);

        assertTrue(random_mines[0][0] >= 0);
        assertTrue(random_mines[0][0] < 8);

    }

    @Test
    public void initializeMineSpotsShouldReturnUnequalAllocations(){
        Minesweeper game = new Minesweeper(8);

        int[][] random_mines = game.initialize_mine_spots(2,3);

        //Create string to test that x and y coordinates are jointly different
        String[] s = new String[3];

        s[0] = String.valueOf(random_mines[0][0]) + String.valueOf(random_mines[0][1]);
        s[1] = String.valueOf(random_mines[1][0]) + String.valueOf(random_mines[1][1]);
        s[2] = String.valueOf(random_mines[2][0]) + String.valueOf(random_mines[2][1]);

        //Assert that the 3 mines are in different locations
        assertTrue(s[0] != s[1]);
        assertTrue(s[1] != s[2]);
        assertTrue(s[2] != s[0]);

    }

    @Test
    public void setMineShouldExplodeWhenAccessed(){
        Minesweeper game = new Minesweeper(8);

        game.set_mine(3,7);
        game.check_spot(3,7);

        System.out.println(game.game_output());

        assertTrue(game.game_output() == "Mine! You Lose");
    }

    @Test
    public void checkSpotWithTwoAdjacentShouldRevealTwo(){
        Minesweeper game = new Minesweeper(8);
        game.set_mine(1,1);
        game.set_mine(1,2);
        game.check_spot(2,2);

        assertEquals(game.check_board(2,2), "2");
    }

    @Test
    public void checkSpotInCornerWithOneMineShouldReturnOne(){
        Minesweeper game = new Minesweeper(8);
        game.set_mine(1,1);
        game.check_spot(0,0);

        assertEquals(game.check_board(0,0), "1");
    }

//    @Test
//    public void checkSpotInAreaWithNoAdjacentMinesShouldReturnZero(){
//        Minesweeper game = new Minesweeper(8);
//        game.set_mine(1,1);
//        game.check_spot(5,5);
//        //System.out.println("final value: " + game.check_spot(5,5));
//
//        assertEquals(game.check_board(5,5), "0");
//    }
//
//    @Test
//    public void FlaggingTheMineShouldResultInVictory(){
//        Minesweeper game = new Minesweeper(8);
//        game.set_mine(0,0);
//        game.flag_mine(0,0);
//
//        assertTrue(game.game_output() == "You Win!");
//    }
//
//    @Test
//    public void FlaggingWrongMinesInAdditionToCorrectOnesShouldNotResultInVictory(){
//        Minesweeper game = new Minesweeper(8);
//        game.set_mine(0,0);
//        game.flag_mine(1,0);
//        game.flag_mine(0,0);
//
//        assertTrue(game.game_output() != "You Win!");
//    }
//
//    @Test
//    public void ShouldNotBeAbleToSelectSpotOutsideOfBounds(){
//        // Should not throw error - message is sent to ask to check a different spot
//        Minesweeper game = new Minesweeper(8);
//        game.check_spot(9,9);
//
//        assertTrue(game.game_output() == "Out of Bounds.  Try another spot");
//    }
//
//    @Test
//    public void ShouldNotBeAbleToSelectSpotAlreadyChosen(){
//        // Should not throw error - message is sent to ask to check a different spot
//        Minesweeper game = new Minesweeper(8);
//        game.check_spot(5,5);
//        game.check_spot(5,5);
//
//        assertTrue(game.game_output() == "Spot already chosen.  Try another spot");
//    }

}
