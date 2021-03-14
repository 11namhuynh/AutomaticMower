package mowitnow.mower.calcul;
import java.util.ArrayList;    
import java.util.List;

import mowitnow.mower.common.ExceptionMowitnow;
import mowitnow.mower.params.MowerPosition;
import mowitnow.mower.params.Params;
import mowitnow.mower.params.Sward;
import mowitnow.mower.params.Params.mowerInstruction;

/**
 * class the calcul 
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class CalculSward {

	private Sward sward;
	private MowerPosition mowerPosition;
	private List<Params.mowerInstruction> instructionList ;
	
	/**
	 * @param sward
	 */
	public void setSward(Sward sward) {
		this.sward = sward;
	}
	
	/**
	 * @param mowerPosition
	 */
	public void setMowerPosition(MowerPosition mowerPosition) {
		this.mowerPosition = mowerPosition;
	}

	/**
	 * @param pinstructionList
	 */
	public void setInstructionList (
			List<Params.mowerInstruction> pinstructionList ) {
		this.instructionList  = pinstructionList ;
		if(pinstructionList  == null){
			instructionList  = new ArrayList<mowerInstruction>();
		}
	}
	/**
	 * carry out all the instructions with a mower 
	 * @throws ExceptionMowitnow
	 */
	public void executerInstructions() throws ExceptionMowitnow{
		for(mowerInstruction instruction : instructionList ){
			MoveMower.executerInstruction(mowerPosition,
					instruction, this.sward.getPositionMax());
		}
	}

	/**
	 * Concatenate 
	 */
	public String toString(){
		return 	mowerPosition.getInformationsMower().getX() 
				+ " " 
				+ mowerPosition.getInformationsMower().getY()
				+ " " 
				+ mowerPosition.getOrientationMower().getCodeOrientation() ;
	}
}