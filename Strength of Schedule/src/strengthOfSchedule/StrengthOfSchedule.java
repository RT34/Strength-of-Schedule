package strengthOfSchedule;

import java.io.BufferedReader;
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
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		ArrayList<Team> teams = new ArrayList<Team>();
		while(((line = br.readLine()) != null)) {
			teams.add(new Team(line));
		}
		return teams;
	}
	
	public static void getMatches (String url, ArrayList<Team>teams) throws Exception {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while (((line = br.readLine()) != null)) {
			Team.addOpponents(line, teams);
		}
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Team> teams = teamsFromFile("./rankings.txt");
			getMatches("./games.txt", teams);
			for (Team team : teams) {
				team.updateSOS(teams);
				System.out.println(team);
			}
		}
		catch (MalformedURLException e) {
			System.out.println("Something went wrong with the URL.");
			System.out.println(e.getStackTrace());
		}
		catch (InputMismatchException e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}

	}

}
