package main;

import java.util.ArrayList;


public class Game {

	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Game(ArrayList<Player> players)
	{
		this.players = players;
	}
	
	public void playGame()
	{
		for (int i = 0; i < 10; i++) {
			IOUtil.display(String.format("Frame %d", i+1));
			
			for (int j = 0; j < players.size(); j++) {
				IOUtil.display(displayScoreSheet() + "\n" + players.get(j).getName() + " to bowl next, press enter to play");
				
				players.get(j).playFrame();
			}
			
		}
		
		Player winner = players.get(0);
		
		for (int i = 1; i < players.size(); i++) {
			
			
			int test = players.get(i).totalScore();
			
			if(test > winner.totalScore()) winner = players.get(i);
	
		}
		
		IOUtil.display(displayScoreSheet() + "\n" + "The winner is " + winner.getName());

	}
	
	private String displayScoreSheet()
	{
		String result = "";
		for (int i = 0; i < players.size(); i++) {
			result += players.get(i).getName() + "\n" + players.get(i).scoreSheet()[0] + "\n" + players.get(i).scoreSheet()[1] + "\n\n";
		}
		
		return result;
	}
}
