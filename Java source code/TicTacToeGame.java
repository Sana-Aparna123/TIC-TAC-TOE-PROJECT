package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	static ArrayList<Integer> player = new ArrayList<Integer>();
	static ArrayList<Integer> cpu = new ArrayList<Integer>();
	  
	static void displayBoard(char board[][]) {
		for (char x[] : board) {
			System.out.println(x);
		}
	}

	static void insertPosition(char board[][], int position, String playerType) {
		char ch;
		if (playerType.equals("player")) {
			ch = 'X';
			player.add(position);
		} 
		else {
			ch = 'O';
			cpu.add(position);
		}
		switch (position) {
		case 1:
			board[0][0] = ch;
			break;
		case 2:
			board[0][2] = ch;
			break;
		case 3:
			board[0][4] = ch;
			break;
		case 4:
			board[2][0] = ch;
			break;
		case 5:
			board[2][2] = ch;
			break;
		case 6:
			board[2][4] = ch;
			break;
		case 7:
			board[4][0] = ch;
			break;
		case 8:
			board[4][2] = ch;
			break;
		case 9:
			board[4][4] = ch;
			break;
		default:
			System.out.println("Please select the position between(1-9)");
			break;
		}

	}
	public static void winningCondition() {
		 
		 List topRow = Arrays.asList(1,2,3);
		 List midRow = Arrays.asList(4,5,6);
		 List bottomRow = Arrays.asList(7,8,9);
		 List leftCol = Arrays.asList(1,4,7);
		 List midCol = Arrays.asList(2,5,8);
		 List rightCol = Arrays.asList(3,6,9);
		 List diag1 = Arrays.asList(1,5,9);
		 List diag2 = Arrays.asList(3,5,7);
		 
		 List<List>winningCondition = new ArrayList<List>();
		 
		 winningCondition.add(topRow);
		 winningCondition.add(midRow);
		 winningCondition.add(bottomRow);
		 winningCondition.add(leftCol);
		 winningCondition.add(midCol);
		 winningCondition.add(rightCol);
		 winningCondition.add(diag1);
		 winningCondition.add(diag2);
		 
		 if(player.containsAll(winningCondition.get(0)) || player.containsAll(winningCondition.get(0))
				 || player.containsAll(winningCondition.get(1)) || player.containsAll(winningCondition.get(2))
				 || player.containsAll(winningCondition.get(3)) || player.containsAll(winningCondition.get(4))
				 || player.containsAll(winningCondition.get(5)) || player.containsAll(winningCondition.get(6))
				 || player.containsAll(winningCondition.get(7))) {
			     System.out.println("Player Wins");
			     System.exit(0);
		   }
		 else if(cpu.containsAll(winningCondition.get(0)) || cpu.containsAll(winningCondition.get(0))
				 || cpu.containsAll(winningCondition.get(1)) || cpu.containsAll(winningCondition.get(2))
				 || cpu.containsAll(winningCondition.get(3)) || cpu.containsAll(winningCondition.get(4))
				 || cpu.containsAll(winningCondition.get(5)) || cpu.containsAll(winningCondition.get(6))
				 || cpu.containsAll(winningCondition.get(7))) {
			     System.out.println("CPU Wins");
			     System.exit(0);
		   }
		 else if((player.size()+cpu.size())==9) {
			 System.out.println("Draw");
			 System.exit(0);
		 }
			
	}
}

public class TicTacToeGame {
	public static void main(String[] args) {
		char board[][] = { { ' ', '|', ' ', '|', ' ' }, 
				           { '-', '+', '-', '+', '-' }, 
				           { ' ', '|', ' ', '|', ' ' },
				           { '-', '+', '-', '+', '-' },
				           { ' ', '|', ' ', '|', ' ' }
				         };
		TicTacToe.displayBoard(board);
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Player,Please select the position:");
			int playerPosition = scan.nextInt();
			
			while(TicTacToe.player.contains(playerPosition) || TicTacToe.cpu.contains(playerPosition)) {
				System.out.println("Position not availabe.please select a new position");
				playerPosition = scan.nextInt();
			}

			TicTacToe.insertPosition(board, playerPosition, "player");
			TicTacToe.displayBoard(board);
			TicTacToe.winningCondition();

			System.out.println("CPU,Please select the position:");
			
			Random rand = new Random();
			int cpuPosition = rand.nextInt(1,10);
			System.out.println("CPU has selected "+cpuPosition);
			
			while(TicTacToe.player.contains(cpuPosition) || TicTacToe.cpu.contains(cpuPosition)) {
				System.out.println("Position not availabe.please select a new position");
				cpuPosition = rand.nextInt(1,10);
				System.out.println("CPU has selected "+cpuPosition);
			}
			
			TicTacToe.insertPosition(board, cpuPosition, "cpu");
			TicTacToe.displayBoard(board);
			TicTacToe.winningCondition();

			
			
			
		}

	}

}
