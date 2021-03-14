package mowitnow.mower.grid;

/**
 * class allowing to validate the information which allows to launch a baler
 *  
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class DataClipper {

	private String sward;
	private String mower;
	private String instructions;

	public DataClipper(){
		this.sward = "";
		this.mower = "";
		this.instructions = "";
	}
	
	/**
	 * @return true if the mower information is correct, false otherwise 
	 */
	public boolean executeParse(){
		return DataGrid.parseMower(mower)
				&& DataGrid.parseSward(sward)
				&& DataGrid.parseListInstruction(instructions);
	}
	
	/**
	 * @return sward
	 */
	public String getSward() {
		return sward;
	}

	/**
	 * @param sward
	 */
	public void setSward(String sward) {
		this.sward = sward;
	}

	/**
	 * @return mower
	 */
	public String getMower() {
		return mower;
	}

	/**
	 * @param mower
	 */
	public void setMower(String mower) {
		this.mower = mower ;
	}

	/**
	 * @return instructions
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}