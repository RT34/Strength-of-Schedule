package strengthOfSchedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;

import strengthOfSchedule.Team;

public class StrengthOfSchedule {

	public static ArrayList<Team> teamsFromFile (String url) throws Exception { 
		FileReader fr = new FileReader(url);
		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList<Team> teams = new ArrayList<Team>();
		while(((line = br.readLine()) != null)) {
			teams.add(new Team(line));
		}
		return teams;
	}
	
	public static void getMatches (String url, ArrayList<Team>teams) throws Exception {
		FileReader fr = new FileReader(url);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while (((line = br.readLine()) != null)) {
			Team.addOpponents(line, teams);
		}
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Team> teams = teamsFromFile("./rankings.txt");
			System.out.println(teams);
			getMatches("./games.txt", teams);
			ArrayList<Team> baseSoSTeams = (ArrayList<Team>)teams.clone();
			for (Team team : teams) {
				team.updateSOS(baseSoSTeams);
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
