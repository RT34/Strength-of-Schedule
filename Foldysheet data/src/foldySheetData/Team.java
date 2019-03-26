package foldySheetData;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Class to store information about teams
 * 
 * @author rbroo
 * @version 1.0
 */
public class Team implements Comparable<Team> {
	int strengthOfSchedule = 0;
	TeamID ID;
	ArrayList<TeamID> opponents = new ArrayList<TeamID>();
	int points;
	int scenario;
	boolean finalRanking = false; //Used so it can be tracked of the initial ranked sort for SoS to show head to head ties only when appropriate
	
	/**Default blank constructor
	 * 
	 */
	public Team() {
		
	}
	
	
	/**Constructor, creates Team info from a line of a text file in format TeamID points
	 * 
	 * @param dataLine Line from file with Team info
	 * @throws Exception: in case of incorrect formatting, an exception will be thrown.
	 */
	public Team(String dataLine) throws Exception {
		Scanner s = new Scanner(dataLine);
		ID = TeamID.getIDFromString(s.next());
		points = s.nextInt();
		if (s.hasNext()) {
			s.close();
			throw new InputMismatchException ("Input file formatted incorrectly");
		}
		s.close();
	}
	/**Takes a string containing the details of one match and adds it to the opponents list of the appropriate teams
	 * 
	 * @param matchInfo string containing match details
	 * @param teams arrayList of all teams to be checked.
	 * @throws Exception: throws exception if the text string is formatted incorrectly, or if the teams aren't found
	 */
	public static void addOpponents(String matchInfo, ArrayList<Team>teams) throws Exception {
		if (matchInfo.equals("")) {
			return;
		}
		Scanner s = new Scanner(matchInfo);
		
		//Teams sorted into home and away for convenience
		TeamID homeTeam = TeamID.getIDFromString(s.next()); 
		TeamID awayTeam = TeamID.getIDFromString(s.next());
		if (s.hasNext()) { //Throws exception if more tokens found than expected
			s.close();
			throw new InputMismatchException ("Input file formatted incorrectly");
		}
		boolean homeAdded = false, awayAdded = false;
		for (Team team: teams) {
			if (team.ID.equals(homeTeam)) {
				team.opponents.add(awayTeam);
				homeAdded = true;
				if (awayAdded) {
					break; //Exits loop if both match participants have been found
				}
			}
			else if (team.ID.equals(awayTeam)) {
				team.opponents.add(homeTeam);
				awayAdded = true;
				if(homeAdded) {
					break; //Exits loop if both match participants have been found
				}
			}
			
		}
		if (!(homeAdded && awayAdded)) { //Throws exception if both opponents weren't found for whatever reason
			s.close();
			throw new Exception("One or more of the teams to be added was not included in the team list.");
		}
		s.close();
	}
	/**Goes through the list of teams provided and sums the strength of schedule of teams specified as an opponent, thus calculating the appropriate strength of schedule for this team
	 * 
	 * @param Teams list of teams from which strength of schedule values can be found
	 */
	public void updateSOS(ArrayList<Team>Teams) throws Exception {
		this.strengthOfSchedule = 0;
		for (Team team : Teams) {
			if (this.opponents.contains(team.ID)) {
				this.strengthOfSchedule += team.strengthOfSchedule;
			}
		}
	}
	
	/**Converts to a string in the format [team name] has a strength of schedule of [SOS]
	 * 
	 */
	public String toString() {
		return this.ID + " has a strength of schedule of " + strengthOfSchedule;
	}
	
	/** Creates a new, independent copy of the Team
	 * 
	 */
	public Team clone() {
		Team copy = new Team();
		copy.ID = this.ID;
		copy.strengthOfSchedule = this.strengthOfSchedule;
		copy.opponents = this.opponents;
		copy.points = this.points;
		copy.scenario = this.scenario;
		return copy;
	}
	
	/** Comparator required by comparable interface. Compares teams by Strength of Schedule
	 * @param o the other team this is being compared to
	 */
	@Override
	public int compareTo(Team o) {
		if (this.points > o.points)
			return 1;
		else if (this.points < o.points)
			return -1;
		else if (this.strengthOfSchedule > o.strengthOfSchedule)
			return 1;
		else if(this.strengthOfSchedule < o.strengthOfSchedule)
			return -1;
		else
			if (finalRanking) { //Ensure this is only done when resolving ties after the scenario is fully resolved
				System.out.println("Tie involving " + this.ID + " and " + o.getID()  + " in scenario " + scenario); //In the event of a tie not resolved by SoS allows head to head ties to be identified
			}
			return 0;
	}
	/**Allows you to specify with which scenario the team is associated
	 * 
	 * @param scenario The associated scenario
	 */
	public void setScenario (int scenario) {
		this.scenario = scenario;
	}
	/**Adds the result of a match to be simulated
	 * 
	 * @param toAdd The number of points to be added
	 */
	public void updateScore (int toAdd) {
		this.points += toAdd;
	}
	
	/**Returns number of opponents registered to the team
	 * 
	 * @return Number of opponents that the team has faced
	 */
	public int numOpponents() {
		return this.opponents.size();
	}
	/**Sets strength of schedule to an initial value to allow calculation
	 * 
	 * @param newSoS The value of Strength of Schedule to set
	 */
	public void setSoS(int newSoS) {
		this.strengthOfSchedule = newSoS;
	}
	/**Returns this team's ID
	 * 
	 * @return this team's ID
	 */
	public TeamID getID() {
		return this.ID;
	}
	
	/**Gets the team's points
	 * 
	 * @return The team's score
	 */
	public int getScore()  {
		return this.points;
	}
	
	/**Sets if future comparisons will be for the final ranking to determine if head to head needs to be noted
	 * 
	 * @param isFinal The new value for finalRanking
	 */
	public void isFinal(boolean isFinal) {
		this.finalRanking = isFinal;
	}
	public int getSoS() {
		return this.strengthOfSchedule;
	}
}
