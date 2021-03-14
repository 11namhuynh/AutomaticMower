package mowitnow.mower.grid;

import mowitnow.mower.params.Params.Orientation;
import mowitnow.mower.params.Params.mowerInstruction;

/**
 * class containing the methods used to validate the format of the lines in the file. 
 * 
 * @author phuong-nam.huynh
 *
 * @version 0.0.1
 * 
 */
public class DataGrid {

	private DataGrid(){

	}

	/**
	 * parse mower position and orientation Position 
	 * and orientation are provided as 2 digits and 
	 * a letter separated by a space 
	 * @param mower 
	 * @return true if the position row is correct, false otherwise 
	 */
	public static boolean parseMower(String mower ){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation())
			.append("|").append(Orientation.SOUTH.getCodeOrientation())
			.append("|").append(Orientation.EAST.getCodeOrientation())
			.append("|").append(Orientation.WEST.getCodeOrientation());
		return mower .matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	
	/**
	 * parse the line of instructions the instructions
	 * are a sequence of characters (L, R, A) without spaces 
	 * @param instructions
	 * @return true if the instruction line is correct, false otherwise
	 */
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(mowerInstruction.ADVANCE.getCodeInstruction())
		.append("|").append(mowerInstruction.RIGHT.getCodeInstruction())
		.append("|").append(mowerInstruction.LEFT.getCodeInstruction())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}

	/**
	 * parse lawn position the lawn position 
	 * is in the form of 2 digits separated by space 
	 * @param lawn 
	 * @return true if the instruction line is correct, false otherwise
	 */
	public static boolean parseSward(String lawn ){
		return lawn .matches("(\\d+) (\\d+)");
	}
}