# Bowling

Java Application using the following specification:

A game of bowling consists of 10 frames, each of which can have a maximum of 2 bowls, excluding the tenth and final frame, which is slightly different.

The player scores 1 point for each pin knocked down every bowl and this is simply added up over all 10 frames to calculate the final score.

If the player knocks down all 10 pins using both bowls of a frame, this is considered a spare. When the player gets a spare the score for that frame is 10 points, plus a bonus of the next bowl. For example a spare followed by a score of 5 pins would mean the player scores 10 + 5 = 15 points in the frame in which the spare occurred.

If the player knocks down all 10 pins on the first bowl of a frame, this is considered a strike. When the player gets a strike the score for that frame will be 10 points, plus a bonus of the next 2 bowls added together. For example a strike followed by a score of 5 and then a score of 4 would mean the player scores 10 + 5 + 4 = 19 points in the frame in which the strike occurred.

The tenth and final frame of the game is slightly different in that if the player scores a strike with the first bowl or a spare using the second bowl they are given a bonus bowl. In this case the final frame of the game can have 3 bowls and the best possible score would be 3 strikes, totalling 10 + 10 + 10 = 30 (including the strike bonus).
