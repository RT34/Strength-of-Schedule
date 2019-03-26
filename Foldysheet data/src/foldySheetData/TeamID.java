package foldySheetData;

/**Stores teamIDs, in order listed in the pinned post. Converts from 3 letter strings in text file for ease of team lookup.
 * 
 * @author rbroo
 * @version 1.0
 */
public enum TeamID {
	HOT_STUFFS, AWFUL_SYMPTOMS, VLADS_VAMPIRES, GOBBO_REVOLUSHUN, GROSSLY_MEALEVOLENT, DA_FUN_GIS, BEST_TEAM, 
	PIOUS_PLANE_POUNDERS, PHEEENIX_KING_AMBASSADORS, PONCY_ELVES, BREAKDOWNERS, BYE_TEAM;

	/**Converts from three letter identifier to enum
	 * 
	 * @param teamID: three letter team identifier
	 */
	public static TeamID getIDFromString(String teamID) throws Exception {
		teamID = teamID.toUpperCase();
		switch (teamID) {
		case "HOT":
			return TeamID.HOT_STUFFS;
		case "AWS":
			return TeamID.AWFUL_SYMPTOMS;
		case "VVV":
			return TeamID.VLADS_VAMPIRES;
		case "DGR":
			return TeamID.GOBBO_REVOLUSHUN;
		case "GRS":
			return TeamID.GROSSLY_MEALEVOLENT;
		case "DFG":
			return TeamID.DA_FUN_GIS;
		case "TNB":
			return TeamID.BEST_TEAM;
		case "PPP":
			return TeamID.PIOUS_PLANE_POUNDERS;
		case "FKA":
			return TeamID.PHEEENIX_KING_AMBASSADORS;
		case "PON":
			return TeamID.PONCY_ELVES;
		case "BRK":
			return TeamID.BREAKDOWNERS;
		case "BYE":
			return TeamID.BYE_TEAM;
		default:
			throw new Exception("Invalid ID submitted for conversion: " + teamID);
		}
	}
	public static String abbrFromID(TeamID toConvert) throws Exception {
		switch (toConvert) {
		case HOT_STUFFS:
			return "HOT";
		case AWFUL_SYMPTOMS:
			return "AWS";
		case VLADS_VAMPIRES:
			return "VVV";
		case GOBBO_REVOLUSHUN:
			return "DGR";
		case GROSSLY_MEALEVOLENT:
			return "GRS";
		case DA_FUN_GIS:
			return "DFG";
		case BEST_TEAM:
			return "TNB";
		case PIOUS_PLANE_POUNDERS:
			return "PPP";
		case PHEEENIX_KING_AMBASSADORS:
			return "FKA";
		case PONCY_ELVES:
			return "PON";
		case BREAKDOWNERS:
			return "BRK";
		case BYE_TEAM:
			return "BYE";
		default: throw new Exception ("Invalid ID for conversion");
		}
	}
	
	/**converts enum to it's full team name in plaintext
	 * 
	 */
	public String toString() {
		switch (this) {
		case HOT_STUFFS:
			return "Hot Stuffs";
		case AWFUL_SYMPTOMS:
			return "The Awful Symptoms";
		case VLADS_VAMPIRES:
			return "Vlad's Vintage Vampires";
		case GOBBO_REVOLUSHUN:
			return "DA GOBBO REVOLUSHUN";
		case GROSSLY_MEALEVOLENT:
			return "Grossly Mealevolent";
		case DA_FUN_GIS:
			return "DA FUN GIS";
		case BEST_TEAM:
			return "Totally Normal Bretonians";
		case PIOUS_PLANE_POUNDERS:
			return "Pious Plane Pounders";
		case PHEEENIX_KING_AMBASSADORS:
			return "Pheunix King Ambassadors";
		case PONCY_ELVES:
			return "The Poncy Elves";
		case BREAKDOWNERS:
			return "Breakdowners";
		case BYE_TEAM:
			return "Pink Knifes";
		default:
			return null;
		}
	}
}
