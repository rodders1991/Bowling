package main;

import java.util.concurrent.ThreadLocalRandom;

public class FinalFrame extends Frame {

	public FinalFrame()
	{
		super();
		roundScores = new int[3];
	}
	
	public void bowl()
	{
		super.bowl();
		int score = ThreadLocalRandom.current().nextInt(0,remainPins() + 1);
		lastScore = score;
		if(bowls == 1 && strike)
		{
			pins = 10;
			roundScores[1] = score;
			IOUtil.display("You knocked " + score + " pins down " + remainPins() + " stand");
			
			if(remainPins() == 0)
			{
				IOUtil.display("Spare");
				spare = true;
			}
		}
		
		if(bowls == 2 && spare)
		{
			pins = 10;
			roundScores[2] = score;
			IOUtil.display("You knocked " + score + " pins down " + remainPins() + " stand");
			
			if(remainPins() == 0)
			{
				IOUtil.display("Spare");
				spare = true;
			}
		}
		
		if(bowls == 2) bowls++;
	}
	
	public void playFrame()
	{
		super.playFrame();
		
		if(strike)
		{
			IOUtil.display("Press ok to bowl your second ball");
			bowl();
		}
		
		if(spare)
		{
			IOUtil.display("Press ok to bowl your third ball");
			bowl();
		}
	}
	
	public int remainPins()
	{
		return super.remainPins() - roundScores[2];
	}
}
