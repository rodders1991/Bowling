package main;

public class Player {

	private String name;
	private int points;
	private int bonusBalls;
	private int bonusPoints;
	private Frame[] frames;
	private int frameNumber; // 0 is frame 1
	
	
	public String getName() {
		return name;
	}

	public Player(String name)
	{
		this.name = name;
		frames = new Frame[10];
		points = 0;
		frameNumber = 0;
		for (int i = 0; i < frames.length; i++) {
			if(i != 9) frames[i] = new Frame();
			else frames[i] = new FinalFrame();
		}
	}
	
	public String[] scoreSheet()
	{
		String[] result = new String[2];
		result[0] = "";
		result[1] = "";
		for (int i = 0; i < frames.length; i++) {
			if(i < frameNumber)
			{
				if(frames[i].isStrike())
				{
					result[0] += String.format("%3s", "X");
					
					if(frames[i] instanceof FinalFrame) result[1] += String.format("%3d", frames[i].roundScores[1]);
					else result[1] += String.format("%3s", "");
					
					
				}
				else
				{
					if(frames[i].isSpare())
					{
						result[0] += String.format("%3d", frames[i].roundScores[0]);
						
						if(frames[i] instanceof FinalFrame)
						{
							result[1] += String.format("%3s", "/");
							result[2] += String.format("%3d", frames[i].roundScores[2]);
						}
						else result[1] += String.format("%3s", "/");
					}
					else
					{
						result[0] += String.format("%3d", frames[i].roundScores[0]);
						result[1] += String.format("%3d", frames[i].roundScores[1]);
					}
				}
				
				
			}
			else
			{
				result[0] += String.format("%3s", "-");
				result[1] += String.format("%3s", "-");
			}
		}
		
		result[1] += "Total - " + totalScore();
		
		return result;
	}
	
	public int totalScore()
	{
		return points + bonusPoints;
	}
	
	public void playFrame()
	{
		IOUtil.display(name + " to play || Frame " + (frameNumber+1) + " || Press Enter to bowl ball");
		
		frames[frameNumber].bowl();
		points += frames[frameNumber].getLastScore();

		if(bonusBalls > 0){
			bonusPoints += frames[frameNumber].getLastScore();
			bonusBalls--;
		}
		
		if(!frames[frameNumber].strike)
		{
			IOUtil.display("Press ok to bowl your second ball");
			
			frames[frameNumber].bowl();
			points += frames[frameNumber].getLastScore();

			if(bonusBalls > 0){
				bonusPoints += frames[frameNumber].getLastScore();
				bonusBalls--;
			}
			
			if(frames[frameNumber].spare)
			{
				bonusBalls = 2;
				
				if(frames[frameNumber] instanceof FinalFrame)
				{
					frames[frameNumber].bowl();
					points += frames[frameNumber].getLastScore();

					if(bonusBalls > 0){
						bonusPoints += frames[frameNumber].getLastScore();
						bonusBalls--;
					}
				}
				
			}
			
		}else
		{
			bonusBalls = 2;
			
			if(frames[frameNumber] instanceof FinalFrame)
			{
				frames[frameNumber].bowl();
				points += frames[frameNumber].getLastScore();

				if(bonusBalls > 0){
					bonusPoints += frames[frameNumber].getLastScore();
					bonusBalls--;
				}
			}
			
			if(frames[frameNumber].getLastScore() == 10)
			{
				bonusBalls = 2;
				
				frames[frameNumber].bowl();
				points += frames[frameNumber].getLastScore();
				
				if(bonusBalls > 0){
					bonusPoints += frames[frameNumber].getLastScore();
					bonusBalls--;
				}
				
			}
		}
		
		frameNumber++;
	}
}
