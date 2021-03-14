package mowitnow.mower.calcul;

import mowitnow.mower.common.ExceptionMowitnow;
import mowitnow.mower.params.Informations;
import mowitnow.mower.params.MowerPosition;
import mowitnow.mower.params.Params;
import mowitnow.mower.params.Params.Orientation;
import mowitnow.mower.params.Params.mowerInstruction;

/**
 * class the movement 
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public  class MoveMower {

	private MoveMower(){

	}
	/**
	 * move the mower 
	 * @param mowerPosition : mower initial position 
	 * @param informations : lawn coordinates - upper right corner of the lawn 
	 * @return informations : new mower details 
	 * @throws ExceptionMowitnow 
	 */
	public static Informations advanceMower(MowerPosition mowerPosition, Informations informations) throws ExceptionMowitnow{
		Informations followingCoordinates = null;
		int x, y;
		switch (mowerPosition.getOrientationMower()) {
		case NORTH:
			x = mowerPosition.getInformationsMower().getX();
			y = mowerPosition.getInformationsMower().getY() + 1;
			break;
		case EAST:
			x = mowerPosition.getInformationsMower().getX() + 1;
			y = mowerPosition.getInformationsMower().getY();
			break;
		case SOUTH:
			x = mowerPosition.getInformationsMower().getX();
			y = mowerPosition.getInformationsMower().getY() - 1;
			break;
		case WEST:
			x = mowerPosition.getInformationsMower().getX() - 1;
			y = mowerPosition.getInformationsMower().getY();
			break;
		default:
			throw new ExceptionMowitnow(Params.INCORRECT_POSITION );
		}
		followingCoordinates = new Informations(x, y);
		// if the new coordinates are outside the lawn, we keep the last known position 
		if (followingCoordinates != null
				&& informations.isOutCoordinatesMax (followingCoordinates)) {
			return followingCoordinates;
		} else {
			return mowerPosition.getInformationsMower();
		}
	}
	
	/**
	 * rotate the mower to the right 
	 * @param orientation : initial orientation of the mower 
	 * @return new orientation 
	 * @throws ExceptionMowitnow
	 */
	
	public static Orientation rotateRight(Orientation orientation) throws ExceptionMowitnow{
		Orientation nextOrientation  = null ;
		switch (orientation){
			case NORTH : 
				nextOrientation =  Orientation.EAST;
				break;
			case EAST : 
				nextOrientation =  Orientation.SOUTH;
				break;
			case SOUTH : 
				nextOrientation =  Orientation.WEST;
				break;
			case WEST : 
				nextOrientation =  Orientation.NORTH;
				break;
			default : 
				throw new ExceptionMowitnow(Params.INCORRECT_ORIENTATION );
		}
		return nextOrientation;		
	}
	
	/**
	 * rotate the mower to the left 
	 * @param orientation : initial orientation of the mower 
	 * @return new direction 
	 * @throws ExceptionMowitnow
	 */
	public static Orientation rotateLeft(Orientation orientation) throws ExceptionMowitnow{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.WEST; 
				break;
			case EAST : 
				orientationSuivante =  Orientation.NORTH; 
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.EAST; 
				break;
			case WEST : 
				orientationSuivante =  Orientation.SOUTH; 
				break;
			default : 
				throw new ExceptionMowitnow(Params.INCORRECT_ORIENTATION );
		}
		return orientationSuivante;		
	}

	/**
	 * execute a single instruction  ( A, D ou G)
	 * @param mowerPosition
	 * @param instruction
	 * @param coordonnesMax
	 * @throws ExceptionMowitnow
	 */
	public static void executerInstruction(MowerPosition mowerPosition, mowerInstruction instruction,Informations coordonnesMax) throws ExceptionMowitnow{
		
		switch (instruction){
			case ADVANCE : 
				mowerPosition.setInformationsMower(MoveMower.advanceMower(mowerPosition, coordonnesMax)); 
				break;
			case RIGHT : 
				mowerPosition.setOrientationMower(MoveMower.rotateRight(mowerPosition.getOrientationMower())); 
				break;
			case LEFT : 
				mowerPosition.setOrientationMower(MoveMower.rotateLeft(mowerPosition.getOrientationMower())); 
				break;
			default: throw new ExceptionMowitnow(Params.INCORRECT_INSTRUCTION );
		}
	}
}