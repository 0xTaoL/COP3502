//Name: Tao Ling
//UFL ID: tao.ling
//Section: 9994
//Project Number: 1
//Brief description of file contents: Brokemon Go

import java.util.Scanner;
public class CaptureCalculator {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//gathering all the initial user input
		System.out.print("Hello and welcome to the Monster Capture "
				+ "Possibility Calculator.\n");
		System.out.println("Please enter the latitude of the monster (1-10): ");
		int monsterLatitude = console.nextInt();
		System.out.println("Please enter the longitude of the monster (1-10): ");
		int monsterLongitude = console.nextInt();
		System.out.println("Please enter the time of the monster appear"
				+ " (1-1440): ");
		int timeAppear = console.nextInt();
		System.out.println("Please enter the possible time of the monster will"
				+ " exist (10-59): ");
		int possibleTimeExist = console.nextInt();
		System.out.println("Please enter the player's ID (8 digits): ");
		int playerID = console.nextInt();
		System.out.println("Please enter the time of the player noticing monster"
				+ " (1-1440 and greater than the time the monster appears): ");
		int playerNoticeMonsterTime = console.nextInt();
		System.out.println("Please enter the latitude of the player (1-10): ");
		int playerLatitude = console.nextInt();
		System.out.println("Please enter the longitude of the player (1-10): ");
		int playerLongitude = console.nextInt();
		System.out.println("Please enter the player's walking speed (10-200): ");
		int playerWalkingSpeed = console.nextInt();
		
		//determines if player is on lucky or normal list
		String normalOrLucky = " ";
		String calculatedNormalOrLucky = "";
		String lucky = "lucky";
		String normal = "normal";
		if (playerID % 100 <= 49)
			calculatedNormalOrLucky = normalOrLucky.replace(" ","lucky");
		else if (playerID % 100 >= 50)
			calculatedNormalOrLucky = normalOrLucky.replace(" ","normal");
		
		//calculate how far the monster is from the player
		double distanceFromMonster = ((Math.sqrt(
				Math.pow((monsterLatitude-playerLatitude), 2) 
				+ Math.pow((monsterLongitude-playerLongitude), 2)))*1000);
		
		//calculates the arrival time
		double arrivalTime = (playerNoticeMonsterTime+(distanceFromMonster
				/playerWalkingSpeed));
		
		//calculates the disappear time
		int disappearTime = possibleTimeExist + timeAppear;
		
		//calculates the probability
		String probability = null;
		double disappearProbability = (((arrivalTime-(disappearTime))
				/possibleTimeExist) * 100);
		
		//determines definitely capture
		if (arrivalTime <= disappearTime)
			probability = "definitely";
		
		//calculates the probability if lucky
		if (calculatedNormalOrLucky.equals(lucky)){
			if (disappearProbability <= 10 && disappearProbability >= 0)
				probability = "highly likely";
			else if (disappearProbability <= 30 && disappearProbability > 10)
				probability = "likely";
			else if (disappearProbability <= 40 && disappearProbability > 30)
				probability = "unsure";
			else if (disappearProbability <= 50 && disappearProbability > 40)
				probability = "unlikely";
			else if (disappearProbability > 50)
				probability = "highly unlikely";
		}
		
		//calculates probability if normal
		if (calculatedNormalOrLucky.equals(normal)){
			if (disappearProbability <= 5 && disappearProbability >= 0)
				probability = "highly likely";
			else if (disappearProbability <= 20 && disappearProbability > 5)
				probability = "likely";
			else if (disappearProbability <= 35 && disappearProbability > 20)
				probability = "unsure";
			else if (disappearProbability <= 40 && disappearProbability > 35)
				probability = "unlikely";
			else if (disappearProbability > 40)
				probability = "highly unlikely";
		}
		
		//prints out all the outputs
		System.out.println("\nPlayer " + playerID + " who is on the " +
				calculatedNormalOrLucky + " list,");
		System.out.println("noticed the monster at time " +
				playerNoticeMonsterTime + ",");
		System.out.println("is " + (Math.round(distanceFromMonster*10)/10.0) 
				+ " m away from the monster,");
		System.out.println("and will arrive at time " + 
				(Math.round(arrivalTime*10)/10.0) + ".");
		System.out.println("The monster's disappear time is about " + 
				disappearTime + ".");
		System.out.println("So the player will capture this monster with " + 
				probability + " possibility.");
		
	}	
}