package main;

import java.util.concurrent.ThreadLocalRandom;

public class Frame {

	protected int pins;
	protected int[] roundScores;
	protected int bowls; // Number of throws
	protected boolean spare;
	protected boolean strike;
	protected int lastScore;
	
	public int[] getRoundScores() {
		return roundScores;
	}

	public boolean isSpare() {
		return spare;
	}

	public boolean isStrike() {
		return strike;
	}

	public Frame()
	{
		pins = 10;
		roundScores = new int[2];
		bowls = 0;
		spare = false;
		strike = false;
		
		
	}
	
	public int getLastScore() {
		return lastScore;
	}

	public void bowl()
	{
		int score = ThreadLocalRandom.current().nextInt(0,remainPins() + 1);
		lastScore = score;
		if(bowls == 0)
		{
			roundScores[0] = score;
			IOUtil.display("You knocked " + score + " pins down " + remainPins() + " stand");
			
			if(remainPins() == 0) 
			{
				strike = true;
				IOUtil.display("STRIKE");
			
			}
			
		}
		
		if(bowls == 1 && !strike)
		{
			roundScores[1] = score;
			IOUtil.display("You knocked " + score + " pins down " + remainPins() + " stand");
			
			if(remainPins() == 0)
			{
				IOUtil.display("Spare");
				spare = true;
			}
		}
		
		if(bowls < 2) bowls++; // needed to allow a super in FinalFrame
	}
	
	public int remainPins()
	{
		return pins - (roundScores[0] + roundScores[1]);
	}
	
	public void playFrame()
	{
		
		IOUtil.display("Press Enter to bowl ball");
		bowl();
		
		if(!strike)
		{
			IOUtil.display("Press ok to bowl your second ball");
			bowl();
		}
		
		
	}
	
	
}
