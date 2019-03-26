package foldySheetData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FoldySheetCalculator {
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
	 * @throws Exception: errors within update SoS
	 */
	public static ArrayList<Team> getSoS(ArrayList<Team> teams, int scenario) throws Exception {
		ArrayList<Team> baseSoSTeams = new ArrayList<Team>();
		for (Team team : teams) { //Necessary so the strengths of schedules prior to this pass are used.
			baseSoSTeams.add(team.clone());
		}
		for (Team team : teams) {
			team.setScenario(scenario);
			team.updateSOS(baseSoSTeams);
		}
		return teams;
	}
	
	/**Calculates the initial SoS based on each team's score
	 * 
	 * @param teams List of teams to calculate initial SoS for
	 */
	public static void setInitSoS(ArrayList<Team> teams) {
		int numUniqueScores = 0;
		int prevScore = 0;
		for (Team team : teams) {
			if (prevScore != team.getScore()) {
				numUniqueScores++;
				prevScore = team.getScore();
			}
		}
		prevScore = teams.get(0).getScore();
		for (Team team:teams) {
			if (prevScore != team.getScore()) {
				numUniqueScores--;
				prevScore = team.getScore();
			}
			team.setSoS(numUniqueScores);
			team.isFinal(true);
		}
	}
	/**For each scenario calculates the outcomes and writes to the results file.
	 * 
	 * @param baseTeams ArrayList of teams so the scenario can be resolved
	 * @param scenarioNumber Number of the scenario
	 * @param scenario String containing details of the scenario in terms of the result of matches in a short string delimited by commas
	 * @param writer Writes to the output file
	 */
	public static void resolveScenario(ArrayList<Team> baseTeams, int scenarioNumber, String scenario, BufferedWriter writer) throws Exception {
		ArrayList<Team> teams = new ArrayList<Team>();
		for (Team team : baseTeams) {
			teams.add(team.clone()); //Necessary so that the base stuff is not overridden
		}
		Scanner s = new Scanner (scenario);
		s.useDelimiter(",");
		String result = new String();
		ArrayList <TeamID> winners = new ArrayList<TeamID>();
		ArrayList <Boolean> draws = new ArrayList<Boolean>();
		for (int iii = 0; iii < 4; iii++) { //We know there are four matches to calculate so used this way
			result = s.next();
			if (result.equals("DRAW")) {
				winners.add(null);
				draws.add(true);
			}
			else {
				winners.add(TeamID.getIDFromString(result));
				draws.add(false);
			}
		}
		for (Team team: teams) {
			team.setScenario(scenarioNumber);
			switch(team.getID()) {
			case BEST_TEAM:
				if (draws.get(ResultIndex.TNB.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.TNB.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case GROSSLY_MEALEVOLENT:
				if (draws.get(ResultIndex.TNB.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.TNB.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case AWFUL_SYMPTOMS:
				if (draws.get(ResultIndex.AWS.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.AWS.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case BREAKDOWNERS:
				if (draws.get(ResultIndex.AWS.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.AWS.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case PONCY_ELVES:
				if (draws.get(ResultIndex.PON.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.PON.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case VLADS_VAMPIRES:
				if (draws.get(ResultIndex.PON.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.PON.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case GOBBO_REVOLUSHUN:
				if (draws.get(ResultIndex.DGR.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.DGR.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			case PHEEENIX_KING_AMBASSADORS:
				if (draws.get(ResultIndex.DGR.getValue())) { //Adds 1 point if it is a draw
					team.updateScore(1);
				}
				else if (winners.get(ResultIndex.DGR.getValue()) == team.getID()) { //Adds three points if this team won
					team.updateScore(3);
				}
				break;
			default:
				continue;
			}
		}
		
		if (s.hasNext()) {
			s.close();
			throw new Exception("Scenario information formatted incorrectly");
		}
		Collections.sort(teams, Collections.reverseOrder()); //Places in order prior to tiebreaks
		setInitSoS(teams);
		for (int iii = 0; iii < 2; iii++) //Change final value ifyou want a different order of SoS
			getSoS(teams, scenarioNumber);
		Collections.sort(teams, Collections.reverseOrder());
		for (int iii = 0; iii < teams.size()-1; iii++) { //SHould not be a comma at the end so must be done like this
			writer.write(TeamID.abbrFromID(teams.get(iii).getID()));
			writer.write(",");
		}
		writer.write(TeamID.abbrFromID(teams.get(teams.size()-1).getID()));
		writer.newLine();
		s.close();
	}
	
	public static void main(String args[]) {
		try {
			ArrayList<Team> teams = teamsFromFile("src/ranking.txt");
			getMatches("src/Games.txt", teams);
			FileReader fr = new FileReader("src/Scenarios.csv");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("src/Outcomes.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			String line;
			int numScenarios = 0;
			while (((line=br.readLine()) != null)) {
				numScenarios++;
				resolveScenario(teams, numScenarios, line, bw);
			}
			br.close();
			bw.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
