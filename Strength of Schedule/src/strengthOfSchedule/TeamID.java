package strengthOfSchedule;

/**Stores teamIDs, in order listed in the pinned post. Converts from 3 letter strings in text file for ease of team lookup.
 * 
 * @author rbroo
 * @version 1.0
 */
public enum TeamID {
	NEW_RADICAL_SYNDICALISTS, LIZPING_LIZARDS, MAGICAL_MINCING_MUMMIES, CHAOSIUM_OLD_GODS,
	LUNCH_LIZARDS, ONE_PERCENT, THE_ARISTORATS, BLOODCHAMBER_ORCESTRA, DYING_DAISIES,
	HONEST_FOLK, BEST_TEAM, REDDER_BARONS, AGGRUTS_ALL_STARS, UNDEAD_TEAM, NOT_SLANN,
	BOYZ_II_HUMAN, HUUBS_HUMBLERS, SHADES_OF_BRUISES, DELICIOUS_KETTLES, COLD_ONES;

	/**Converts from three letter identifier to enum
	 * 
	 * @param teamID: three letter team identifier
	 */
	public static TeamID getIDFromString(String teamID) throws Exception {
		teamID = teamID.toUpperCase();
		switch (teamID) {
		case "NRS":
			return TeamID.NEW_RADICAL_SYNDICALISTS;
		case "LIZ":
			return TeamID.LIZPING_LIZARDS;
		case "MMM":
			return TeamID.MAGICAL_MINCING_MUMMIES;
		case "COG":
			return TeamID.CHAOSIUM_OLD_GODS;
		case "LUN":
			return TeamID.LUNCH_LIZARDS;
		case "ONE":
			return TeamID.ONE_PERCENT;
		case "BOC":
			return TeamID.BLOODCHAMBER_ORCESTRA;
		case "DYD":
			return TeamID.DYING_DAISIES;
		case "HFT":
			return TeamID.HONEST_FOLK;
		case "WAC":
			return TeamID.BEST_TEAM;
		case "RED":
			return TeamID.REDDER_BARONS;
		case "AAS":
			return TeamID.AGGRUTS_ALL_STARS;
		case "UND":
			return TeamID.UNDEAD_TEAM;
		case "NSS":
			return TeamID.NOT_SLANN;
		case "BOY":
			return TeamID.BOYZ_II_HUMAN;
		case "HUB":
			return TeamID.HUUBS_HUMBLERS;
		case "SOB":
			return TeamID.SHADES_OF_BRUISES;
		case "DEL":
			return TeamID.DELICIOUS_KETTLES;
		case "COL":
			return TeamID.COLD_ONES;
		case "TAR":
			return TeamID.THE_ARISTORATS;
		default:
			throw new Exception("Invalid ID submitted for conversion: " + teamID);
		}
	}
	public String toString() {
		switch (this) {
		case NEW_RADICAL_SYNDICALISTS:
			return "The New Radical Syndicalists";
		case LIZPING_LIZARDS:
			return "The Lizping Lizards";
		case MAGICAL_MINCING_MUMMIES:
			return "Magical Mincing Mummies";
		case CHAOSIUM_OLD_GODS:
			return "The Chaosium Old Gods";
		case LUNCH_LIZARDS:
			return "Lunch Lizards";
		case ONE_PERCENT:
			return "TheOnePercent";
		case THE_ARISTORATS:
			return "The_Aristorats";
		case BLOODCHAMBER_ORCESTRA:
			return "Bloodchamber Orcestra";
		case DYING_DAISIES:
			return "Dying Daisis";
		case HONEST_FOLK:
			return "Honest Folk O Thiefington";
		case BEST_TEAM:
			return "We are the Champagnes";
		case REDDER_BARONS:
			return "Redder Barons";
		case AGGRUTS_ALL_STARS:
			return "Aggrut's All Stars";
		case UNDEAD_TEAM:
			return "(|Dead> + |Alive>)/sqrt(2)";
		case NOT_SLANN:
			return "Th-e Not Slann Smashers";
		case BOYZ_II_HUMAN:
			return "Boyz II Humanz";
		case HUUBS_HUMBLERS:
			return "Huub's Humblers";
		case SHADES_OF_BRUISES:
			return "50 Shades of Bruises";
		case DELICIOUS_KETTLES:
			return "Delicious Kettles";
		case COLD_ONES:
			return "The (Very) Cold Ones";
		default:
			return null;
		}
	}
}
