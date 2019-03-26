package foldySheetData;

public enum ResultIndex { //Holds the index used to access each match result for ease of readability
	TNB(0), AWS(1), PON(2), DGR(3);
	int indexNumber;
	/**Constructor to assign values
	 * 
	 * @param index the numerical value assigned to each value
	 */
	ResultIndex(int index) {
		this.indexNumber = index;
	}
	
	/**Returns the index
	 * 
	 * @return The index for array access
	 */
	public int getValue() {
		return this.indexNumber;
	}
}
