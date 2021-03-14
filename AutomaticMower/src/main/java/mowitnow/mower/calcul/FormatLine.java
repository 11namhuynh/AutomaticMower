package mowitnow.mower.calcul;

import java.util.ArrayList;  
import java.util.List;

import mowitnow.mower.params.Informations;
import mowitnow.mower.params.MowerPosition;
import mowitnow.mower.params.Sward;
import mowitnow.mower.params.Params.Orientation;
import mowitnow.mower.params.Params.mowerInstruction;

/**
 * class the format line 
 * 
 * @author phuong-nam.huynh
 *
 * @version 0.0.1
 *
 */

public class FormatLine {

	private static final String CHAINE_ESPACE = " ";

	private FormatLine(){

	}

	/**
	 * retrieve the position of the mower which is defined by its coordinates and its orientation 
	 * @param lineMower : mower position line 
	 * @return the object that defines the position of the mower 
	 */
	public static MowerPosition formatLineMower(String lineMower){
		String[] elts = lineMower.split(CHAINE_ESPACE);
		Informations pCoordonneesMower = new Informations(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationMower = getOrientation(elts[2].charAt(0));
		return new MowerPosition(pCoordonneesMower, orientationMower);
	}

	/**
	 * retrieve the Lawn object containing the boundary coordinates of the lawn 
	 * @param lineLawn : lawn line 
	 * @return the object that defines the boundary of the lawn 
	 */
	public static Sward formatLineLawn(String lineLawn){
		String[] elts = lineLawn.split(CHAINE_ESPACE);
		return new Sward(new Informations(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	/**
	 * retrieve a mower instruction enum list corresponding to the instruction line 
	 * @param lineInstruction : Line Instruction 
	 * @return a list of mower instruction enum 
	 */
	public static List<mowerInstruction> formaterLigneInstruction(String lineInstruction){
		List<mowerInstruction> listInstruction = new ArrayList<mowerInstruction>();
		for(char instruction :lineInstruction.toCharArray()){
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	/**
	 * get an Orientation enum corresponding to the orientation character 
	 * @param charOrientation : orientation character (E, W, N, S)
	 * @return the enum corresponding to the orientation 
	 */
	public static Orientation getOrientation(char charOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == charOrientation){
				return orientation;
			}
		}
		return null;
	}

	/**
	 * retrieve a Mower Instruction enum corresponding to the instruction character 
	 * @param charInstruction : instruction character  (A, L, R)
	 * @return the enum corresponding to the instruction 
	 */
	public static mowerInstruction getInstruction(char charInstruction){
		for(mowerInstruction instruction : mowerInstruction.values()) {
			if (instruction.getCodeInstruction() == charInstruction) {
				return instruction;
			}
		}
		return null;
	}
}