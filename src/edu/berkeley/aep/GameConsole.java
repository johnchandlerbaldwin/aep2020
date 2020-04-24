package edu.berkeley.aep;

import java.util.Scanner;

//Understands how to play a game of Minesweeper in a Java console
public class GameConsole {

    public static void main(String[] args){

        Scanner scanner = new Scanner((System.in));

        System.out.println("Welcome to Minesweeper!");

        System.out.println("Choose board size (integer greater than 0)");

        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose number of mines (int greater than 0)");

        int mines = Integer.parseInt(scanner.nextLine());

        Minesweeper sweeper = new Minesweeper(rows, mines);

        char input;
        int row;
        int col;

        while(sweeper.game_output() != "Mine! You Lose" && sweeper.game_output() != "You Win!"){

            sweeper.show_board();

            System.out.println("Press C for Choose, F for Flag");

            input = scanner.next().charAt(0);

            if(input != 'C' & input != 'F'){
                System.out.println("Input must be C or F.  Please try again.");
                continue;
            }

            System.out.println("Input Row.");
            row = scanner.nextInt();

            if(row < 1 | row > rows){
                System.out.println("Row out of range.  Please try again.");
                continue;
            }

            System.out.println("Input Column.");
            col = scanner.nextInt();

            if(col < 1 | col > rows){
                System.out.println("Column out of range.  Please try again.");
                continue;
            }

            if(input == 'C'){
                sweeper.check_spot(row-1,col-1);
            }

            if(input == 'F'){
                sweeper.flag_mine(row-1,col-1);
            }

            System.out.println(sweeper.game_output());

        }

    }

}
