package strengthOfSchedule;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Class to store information about teams
 * 
 * @author rbroo
 * @version 1.0
 */
public class Team {
	int strengthOfSchedule;
	TeamID ID;
	ArrayList<TeamID> opponents = new ArrayList<TeamID>();
	
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
		Scanner s = new Scanner(matchInfo);
		TeamID homeTeam = TeamID.getIDFromString(s.next());
		TeamID awayTeam = TeamID.getIDFromString(s.next());
		if (s.hasNext()) {
			s.close();
			throw new InputMismatchException ("Input file formatted incorrectly");
		}
		boolean homeAdded = false, awayAdded = false;
		for (Team team: teams) {
			if (team.ID.equals(homeTeam)) {
				team.opponents.add(awayTeam);
				homeAdded = true;
				if (awayAdded) {
					break;
				}
			}
			else if (team.ID.equals(awayTeam)) {
				team.opponents.add(homeTeam);
				awayAdded = true;
				if(homeAdded) {
					break;
				}
			}
			
		}
		if (!(homeAdded && awayAdded)) {
			s.close();
			throw new Exception("One of more of the teams to be added was not included in the team list.");
		}
		s.close();
	}
	/**Goes through the list of teams provided and sums the strength of schedule of teams specified as an opponent, thus calculating the appropriate strength of schedule
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
	public String toString() {
		return this.ID + " had a strength of schedule of " + strengthOfSchedule;
	}
}
