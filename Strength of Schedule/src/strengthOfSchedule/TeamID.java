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
		BOYZ_II_HUMAN, HUUBS_HUMBLERS;
	
		/**Converts from three letter identifier to enum
		 * 
		 * @param teamID: three letter team identifier
		 */
		public static TeamID getIDFromString(String teamID) throws Exception {
			teamID = teamID.toUpperCase();
			switch (teamID) {
			case "NRS":
				return TeamID.NEW_RADICAL_SYNDICALISTS;
			case "LZL":
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
			case "BIH":
				return TeamID.BOYZ_II_HUMAN;
			case "HUB":
				return TeamID.HUUBS_HUMBLERS;
			default:
					throw new Exception("Invalid ID submitted for conversion");
			}
		}
	}
