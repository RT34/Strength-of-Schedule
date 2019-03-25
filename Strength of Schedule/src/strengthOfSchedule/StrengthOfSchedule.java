package strengthOfSchedule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class StrengthOfSchedule {

	/**Gets the full list of teams from ranking file
	 * 
	 * @param url: location of file
	 * @return: the teams found
	 * @throws Exception: various file IO exceptions or errors in the Team constructor
	 */
	public static ArrayList<Team> teamsFromFile (String url) throws Exception { 
		FileReader fr = new FileReader(url);
		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList<Team> teams = new ArrayList<Team>();
		while(((line = br.readLine()) != null)) {
			teams.add(new Team(line));
		}
		br.close();
		return teams;
	}
	
	/**Gets all matches from the games file for SoS comparison
	 * 
	 * @param url: file location
	 * @param teams: list of teams to update with their opponents
	 * @throws Exception: various IO Exceptions and errors within addOpponents
	 */
	public static void getMatches (String url, ArrayList<Team>teams) throws Exception {
		FileReader fr = new FileReader(url);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while (((line = br.readLine()) != null)) {
			Team.addOpponents(line, teams);
		}
		br.close();
	}
	
	/**Calculates Strength of Schedule for all teams
	 * 
	 * @param teams: teams to calculate SoS for
	 * @return: the updated teams
	 * @throws Exception: errors within update SoS, if errors were made while inputting match history
	 */
	public static ArrayList<Team> getSoS(ArrayList<Team> teams) throws Exception {
		ArrayList<Team> baseSoSTeams = new ArrayList<Team>();
		for (Team team : teams) { //Necessary so the strengths of schedules prior to this pass are used.
			baseSoSTeams.add(team.clone());
		}
		int numOpponents = 0;
		for (Team team : teams) {
			team.updateSOS(baseSoSTeams);
			if (numOpponents == 0) { //On the first pass only, sets a value. Can't find a cleaner way to do this unfortunately.
				numOpponents = team.numOpponents();
			}
			else if (numOpponents != team.numOpponents()) { //Ensures that all teams have the same number of opponents registered as the first
				throw new Exception (team.toString() + " does not have the correct number of opponents registered");
			}
		}
		return teams;
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Team> teams = teamsFromFile("./rankings.txt");
			getMatches("./games.txt", teams);
			int order = 2; //If for some reason you want to do a different order SoS calculation, change this
			for (int iii = 0; iii < order; iii++)
				getSoS(teams);
			Collections.sort(teams, Collections.reverseOrder()); //Sorts descending
			for (Team team:teams) { //Prints array line by line
				System.out.println(team);
			}
		}
		catch (InputMismatchException e) {
			System.out.println("The file was formatted incorrectly:" + e);
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}

	}

}
