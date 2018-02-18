package strengthOfSchedule;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Class to store information about teams
 * 
 * @author rbroo
 * @version 1.0
 */
public class Team implements Comparable<Team> {
	int strengthOfSchedule;
	TeamID ID;
	ArrayList<TeamID> opponents = new ArrayList<TeamID>();
	
	/**Default blank constructor
	 * 
	 */
	public Team() {
		
	}
	
	
	/**Constructor, creates Team info from a line of a text file in format TeamID SoS
	 * 
	 * @param dataLine: Line from file with Team info
	 * @throws Exception: in case of incorrect formatting, an exception will be thrown.
	 */
	public Team(String dataLine) throws Exception {
		Scanner s = new Scanner(dataLine);
		ID = TeamID.getIDFromString(s.next());
		strengthOfSchedule = s.nextInt();
		if (s.hasNext()) {
			s.close();
			throw new InputMismatchException ("Input file formatted incorrectly");
		}
		s.close();
	}
	/**Takes a string containing the details of one match and adds it to the opponents list of the appropriate teams
	 * 
	 * @param matchInfo: string containing match details
	 * @param teams: arrayList of all teams to be checked.
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
			throw new Exception("One of more of the teams to be added was not included in the team list.");
		}
		s.close();
	}
	/**Goes through the list of teams provided and sums the strength of schedule of teams specified as an opponent, thus calculating the appropriate strength of schedule for this team
	 * 
	 * @param Teams: list of teams from which strength of schedule values can be found
	 */
	public void updateSOS(ArrayList<Team>Teams) throws Exception {
		this.strengthOfSchedule = 0;
		int opponentsFound = 0;
		for (Team team : Teams) {
			if (this.opponents.contains(team.ID)) {
				opponentsFound++;
				this.strengthOfSchedule += team.strengthOfSchedule;
			}
		}
		if (opponentsFound != opponents.size()) {
			throw new Exception("Not all opponents could be found for " + this.ID.toString());
		}
	}
	
	/**Converts to a string in the format [team name} has a strength of schedule of [SOS]
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
		return copy;
	}
	
	/** Comparator requried by comparable interface. Compares teams by Strength of Schedule
	 * @param o: the other team this is being compared to
	 */
	@Override
	public int compareTo(Team o) {
		if (this.strengthOfSchedule > o.strengthOfSchedule)
			return 1;
		else if (this.strengthOfSchedule < o.strengthOfSchedule)
			return -1;
		else
			return 0;
	}
}
