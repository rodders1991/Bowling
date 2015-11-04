package main;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<Player>();
		int option = 0;
		
		do{
			try {option = IOUtil.getInt("Welcome to bowling, add two or more players and start playing:\n"
					+ "Press 1 to Add a Player\n"
					+ "Press 2 to Play\n"
					+ "Press 3 to Exit");
			}catch(NumberFormatException e)
			{
				option = 0;
			}
			
			if(option == 1)
			{
				String name = IOUtil.getString("Whats your name?");
				players.add(new Player(name));
				IOUtil.display(name + " has been added to the game");
				
			}
			
			else if (option == 2)
			{
				if(players.size() > 1)
				{
					Game newGame = new Game(players);
					newGame.playGame();
				}
				
				else
				{
					IOUtil.display("Please enter more players");
					
				}
			}
			
			else if (option == 3)
			{
				System.out.println("Goodbye");
				System.exit(0);
			}
			
			else
			{
				IOUtil.display("Invalid Format");
			}
			
		}while(option != 3);
	}

}
