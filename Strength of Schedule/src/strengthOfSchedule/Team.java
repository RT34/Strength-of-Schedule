package strengthOfSchedule;

import java.util.ArrayList;
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
	
	public Team(String dataLine) throws Exception {
		Scanner s = new Scanner(dataLine);
		ID = TeamID.getIDFromString(s.next());
		strengthOfSchedule = s.nextInt();
		if (s.hasNext()) {
			s.close();
			throw new Exception ("Input file formatted incorrectly");
		}
		s.close();
	}
	
	public void AddOpponents(String matchInfo, ArrayList<Team>teams) throws Exception {
		Scanner s = new Scanner(matchInfo);
		TeamID homeTeam = TeamID.getIDFromString(s.next());
		TeamID awayTeam = TeamID.getIDFromString(s.next());
		if (s.hasNext()) {
			s.close();
			throw new Exception ("Input file formatted incorrectly");
		}
		boolean homeAdded = false, awayAdded = false;
		for (Team team: teams) {
			if (team.ID == homeTeam) {
				team.opponents.add(awayTeam);
				homeAdded = true;
				if (awayAdded) {
					break;
				}
			}
			else if (team.ID == awayTeam) {
				team.opponents.add(homeTeam);
				awayAdded = true;
				if(homeAdded) {
					break;
				}
			}
			
		}
		s.close();
	}
}
