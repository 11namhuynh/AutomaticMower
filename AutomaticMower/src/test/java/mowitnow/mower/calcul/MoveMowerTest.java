package mowitnow.mower.calcul;

import static org.fest.assertions.Assertions.assertThat;   
import org.junit.Test;

import mowitnow.mower.common.ExceptionMowitnow;
import mowitnow.mower.params.Informations;
import mowitnow.mower.params.MowerPosition;
import mowitnow.mower.params.Params.Orientation;
import mowitnow.mower.params.Params.mowerInstruction;

/**
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class MoveMowerTest {

	@Test
	public void informations_x_y_south_instruction_Turn_Right () throws ExceptionMowitnow {
		Informations coordonnesMax = new Informations(5, 5);
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.SOUTH);
		MoveMower.executerInstruction(mowerPosition, mowerInstruction.RIGHT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.WEST);
	}
	
	
	@Test
	public void rotate_right() throws ExceptionMowitnow{
		
		Orientation nextOrientation = MoveMower.rotateRight(Orientation.EAST);
		assertThat(nextOrientation).isEqualTo(Orientation.SOUTH);
		
		nextOrientation = MoveMower.rotateRight(Orientation.WEST);
		assertThat(nextOrientation).isEqualTo(Orientation.NORTH);
		
		nextOrientation = MoveMower.rotateRight(Orientation.NORTH);
		assertThat(nextOrientation).isEqualTo(Orientation.EAST);
		
		nextOrientation = MoveMower.rotateRight(Orientation.SOUTH);
		assertThat(nextOrientation).isEqualTo(Orientation.WEST);
	}
	
	@Test
	public void rotate_left () throws ExceptionMowitnow{
		Orientation nextOrientation = MoveMower.rotateLeft(Orientation.EAST);
		assertThat(nextOrientation).isEqualTo(Orientation.NORTH);
		
		nextOrientation = MoveMower.rotateLeft(Orientation.WEST);
		assertThat(nextOrientation).isEqualTo(Orientation.SOUTH);
		
		nextOrientation = MoveMower.rotateLeft(Orientation.NORTH);
		assertThat(nextOrientation).isEqualTo(Orientation.WEST);
		
		nextOrientation = MoveMower.rotateLeft(Orientation.SOUTH);
		assertThat(nextOrientation).isEqualTo(Orientation.EAST);
	}

}
