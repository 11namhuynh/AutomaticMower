package mowitnow.mower.calcul;

import static org.fest.assertions.Assertions.assertThat;     
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import mowitnow.mower.common.ExceptionMowitnow;
import mowitnow.mower.params.Informations;
import mowitnow.mower.params.MowerPosition;
import mowitnow.mower.params.Params;
import mowitnow.mower.params.Sward;
import mowitnow.mower.params.Params.Orientation;
import mowitnow.mower.params.Params.mowerInstruction;

/**
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class CalculSwardTest {
	Informations coordonnesMax = new Informations(5, 5);
	
	@Test
	public void execute_instruction_no_instruction() throws ExceptionMowitnow{
		int x = 0;
		int y = 0;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations, Orientation.NORTH);
		
		CalculSward calculSward = new CalculSward();
		calculSward.setSward(new Sward(coordonnesMax));
		calculSward.setMowerPosition(mowerPosition);
		calculSward.setInstructionList(new ArrayList<Params.mowerInstruction>());
		calculSward.executerInstructions();
		assertThat(calculSward.toString()).isEqualTo("0 0 N");
	}
	
	@Test
	public void execute_instruction_unitaire() throws ExceptionMowitnow{
		List<mowerInstruction> listInstruction = new ArrayList<Params.mowerInstruction>();
		listInstruction.add(mowerInstruction.ADVANCE);
		int x = 1;
		int y = 1;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations, Orientation.NORTH);
		CalculSward calculSward = new CalculSward();
		calculSward.setSward(new Sward(coordonnesMax));
		calculSward.setMowerPosition(mowerPosition);
		calculSward.setInstructionList(listInstruction);
		calculSward.executerInstructions();
		assertThat(calculSward.toString()).isEqualTo("1 2 N");
	}
	
	@Test
	public void execute_instruction_several() throws ExceptionMowitnow{
		List<mowerInstruction> listInstruction = new ArrayList<Params.mowerInstruction>();
		listInstruction.add(mowerInstruction.LEFT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.LEFT);
		listInstruction.add(mowerInstruction.ADVANCE);
		int x = 3;
		int y = 2;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations, Orientation.NORTH);
		CalculSward calculSward = new CalculSward();
		calculSward.setSward(new Sward(coordonnesMax));
		calculSward.setMowerPosition(mowerPosition);
		calculSward.setInstructionList(listInstruction);
		calculSward.executerInstructions();
		assertThat(calculSward.toString()).isEqualTo("2 1 S");
	}
	
	@Test
	public void execute_instruction_cas_reel_1() throws ExceptionMowitnow{
		List<mowerInstruction> listInstruction = new ArrayList<Params.mowerInstruction>();
		listInstruction.add(mowerInstruction.LEFT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.LEFT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.LEFT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.LEFT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.ADVANCE);
		int x = 1;
		int y = 2;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations, Orientation.NORTH);
		CalculSward calculSward = new CalculSward();
		calculSward.setSward(new Sward(coordonnesMax));
		calculSward.setMowerPosition(mowerPosition);
		calculSward.setInstructionList(listInstruction);
		calculSward.executerInstructions();
		assertThat(calculSward.toString()).isEqualTo("1 3 N");
	}
	@Test
	public void execute_instruction_cas_reel_2() throws ExceptionMowitnow{
		List<mowerInstruction> listInstruction = new ArrayList<Params.mowerInstruction>();
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.RIGHT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.RIGHT);
		listInstruction.add(mowerInstruction.ADVANCE);
		listInstruction.add(mowerInstruction.RIGHT);
		listInstruction.add(mowerInstruction.RIGHT);
		listInstruction.add(mowerInstruction.ADVANCE);
		int x = 3;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations, Orientation.EAST);
		CalculSward calculSward = new CalculSward();
		calculSward.setSward(new Sward(coordonnesMax));
		calculSward.setMowerPosition(mowerPosition);
		calculSward.setInstructionList(listInstruction);
		calculSward.executerInstructions();
		assertThat(calculSward.toString()).isEqualTo("5 1 E");
	}
	
	
	@Test
	public void informations_x_y_north_instruction_avancer() throws ExceptionMowitnow {
		int x = 0;
		int y = 0;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.NORTH);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.ADVANCE, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y+1));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.NORTH);
	}
	
	@Test
	public void informations_x_y_East_instruction_avancer() throws ExceptionMowitnow {
		int x = 0;
		int y = 0;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.EAST);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.ADVANCE, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x+1, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void informations_x_y_South_instruction_avancer() throws ExceptionMowitnow {
		int x = 5;
		int y = 5;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.SOUTH);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.ADVANCE, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y-1));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void informations_x_y_West_instruction_avancer() throws ExceptionMowitnow {
		int x = 5;
		int y = 5;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.WEST);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.ADVANCE, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x-1, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.WEST);
	}
	@Test
	public void informations_x_y_West_instruction_Tourner_gauche() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.WEST);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.LEFT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void informations_x_y_east_instruction_Tourner_gauche() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.EAST);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.LEFT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void informations_x_y_west_instruction_Tourner_gauche() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.WEST);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.LEFT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}
	@Test
	public void informations_x_y_south_instruction_Tourner_gauche() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.SOUTH);
		MoveMower.executerInstruction(mowerPosition, Params.mowerInstruction.LEFT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void informations_x_y_north_instruction_Tourner_Droite() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.NORTH);
		MoveMower.executerInstruction(mowerPosition, mowerInstruction.RIGHT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void informations_x_y_east_instruction_Tourner_Droite() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.EAST);
		MoveMower.executerInstruction(mowerPosition, mowerInstruction.RIGHT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void informations_x_y_west_instruction_Tourner_Droite() throws ExceptionMowitnow {
		int x = 2;
		int y = 3;
		Informations informations = new Informations(x, y);
		MowerPosition mowerPosition = new MowerPosition(informations,Orientation.WEST);
		MoveMower.executerInstruction(mowerPosition, mowerInstruction.RIGHT, coordonnesMax);
		assertThat(mowerPosition.getInformationsMower()).isEqualTo(new Informations(x, y));
		assertThat(mowerPosition.getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

}