package edu.berkeley.aep;

import java.util.Random;

//Understands the internal mechanisms of Minesweeper
public class Minesweeper {

    private boolean[][] grid;
    private String[][] board;

    private String output_string;

    //Separate constructors for Minesweeper with random initialization of mines and manual initialization

    //Manual initialization:
    public Minesweeper(int rows) {
        this.grid = new boolean[rows][rows];
        this.board = new String[rows][rows];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = false;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = "X";
            }
        }
    }

    //Random initialization of mines
    public Minesweeper(int rows, int mines) {
        this.grid = new boolean[rows][rows];
        this.board = new String[rows][rows];

        //Create random initializations of mines
        int[][] mine_spots = initialize_mine_spots(rows, mines);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = false;
            }
        }

        //Set randomized mines
        for (int i = 0; i < mine_spots.length; i++) {
            set_mine(mine_spots[i][0], mine_spots[i][1]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = "X";
            }
        }
    }

    //Used in the constructor to create an array of random mine placements
    public int[][] initialize_mine_spots(int rows, int mines) {

        Random r = new Random();

        int[][] mine_spots = new int[mines][2];

        int x;
        int y;

        boolean duplicate;

        int i = 0;
        while (i < mines) {

            duplicate = false;

            //randomly choose 2 numbers between 0 and rows
            x = r.nextInt(rows);
            y = r.nextInt(rows);

            //See if the value is a duplicate, and if so set duplicate to true
            for (int j = 0; j < mines; j++) {
                if (mine_spots[j][0] == x) {
                    if (mine_spots[j][1] == y) {

                        duplicate = true;
                    }
                }
            }

            //If the value is not a duplicate, add it to the array and move on to the next mine
            if (duplicate == false) {
                mine_spots[i][0] = x;
                mine_spots[i][1] = y;

                i = i + 1;

            }
        }
        return (mine_spots);
    }

    //used for testing
    public void set_mine(int row, int col) {
        grid[row][col] = true;
    }

    //Gives the number of mines adjacent to the give spot
    public void check_spot(int row, int col) {

        //Check first if the row or col are out of bounds, and if they are change the output string and return
        if(row >= grid.length | row < 0 | col >= grid.length | col < 0){
            output_string = "Out of Bounds.  Try another spot";
            return;
        }

        //Check if the spot has already been chosen, and if so change output string and return
        if(board[row][col] != "X" && board[row][col] != "F"){
            output_string = "Spot already chosen.  Try another spot";
            return;
        }

        int[] row_spots = {row - 1, row, row + 1};
        int[] col_spots = {col - 1, col, col + 1};

        int count = 0;

        //Check if the spot is a mine itself, and if so, set output string to 'You Lose', the mine to -1 and end the game
        if (grid[row][col] == true) {
            board[row][col] = "M";
            output_string = "Mine! You Lose";
            return;
        }

        //Count the number of mines around the spot and set count to that number
        for (int i = 0; i < row_spots.length; i++) {
            for (int j = 0; j < col_spots.length; j++) {
                //Check if the indices to check are within the range of the board, else skip
                if ((row_spots[i] >= 0) && (row_spots[i] < grid.length) && (col_spots[j] >= 0) && (col_spots[j] < grid.length)) {
                    //Check if said spot is a mine
                    System.out.println(row_spots[i]);
                    System.out.println(col_spots[j]);
                    //System.out.println(grid[row_spots[i]][row_spots[j]] == true);
                    //System.out.println("Break");
                    //System.out.println(grid[row_spots[i]][row_spots[j]]);
                    if (grid[row_spots[i]][col_spots[j]] == true) {
                        count = count + 1;
                    }
                }
            }
        }

        board[row][col] = String.valueOf(count);
        output_string = "Press C for Choose, F for Flag";
    }

    //Method used for testing to verify contents of visible board
    public String check_board(int row, int col){
        return(board[row][col]);
    }

    public String game_output(){
        return(output_string);
    }

    //Flags the mine and also checks if the victory condition has been met, calling check_victory
    public void flag_mine(int row, int col){
        board[row][col] = "F";

        check_victory_condition();
    }

    public void check_victory_condition(){
        //Check that all mines have been flagged
        //Check that there is an equal amount of flags and mines

        int mine_count = 0;
        int correctly_flagged = 0;
        int total_flag_count = 0;

        // Gets mine count and correctly flagged count
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == true){
                    mine_count = mine_count + 1;
                    if(board[i][j] == "F"){
                        correctly_flagged = correctly_flagged + 1;
                    }
                }
            }
        }

        // Counts total number of flags
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (board[i][j] == "F") {
                    total_flag_count = total_flag_count + 1;
                }
            }
        }

        if(mine_count == correctly_flagged && mine_count == total_flag_count){
            output_string = "You Win!";
        }

    }


    public void show_board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }



}

