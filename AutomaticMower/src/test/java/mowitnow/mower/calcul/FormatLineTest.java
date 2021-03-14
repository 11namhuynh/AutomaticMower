package mowitnow.mower.calcul;

import static org.fest.assertions.Assertions.assertThat;     
import org.junit.Test;
import mowitnow.mower.params.Informations;
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
public class FormatLineTest {

	@Test
	public void format_mower_line() {
		assertThat(FormatLine.formatLineMower("10 15 N").getInformationsMower()).isEqualTo(new Informations(10, 15));
		assertThat(FormatLine.formatLineMower("10 15 N").getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void format_lawn_line() {
		assertThat(FormatLine.formatLineLawn("10 15")).isEqualTo(new Sward(new Informations(10, 15)));
	}

	@Test
	public void format_instruction_line() {
		assertThat(FormatLine.formaterLigneInstruction("DGAD")).hasSize(4)
				.contains(mowerInstruction.RIGHT)
				.contains(mowerInstruction.LEFT)
				.contains(mowerInstruction.ADVANCE);
	}

	@Test
	public void retrieve_orientation() {
		assertThat(FormatLine.getOrientation('E')).isEqualTo(Orientation.EAST);
		assertThat(FormatLine.getOrientation('N')).isEqualTo(Orientation.NORTH);
		assertThat(FormatLine.getOrientation('S')).isEqualTo(Orientation.SOUTH);
		assertThat(FormatLine.getOrientation('W')).isEqualTo(Orientation.WEST);
		assertThat(FormatLine.getOrientation('a')).isNull();
	}

	@Test
	public void testGetInstruction() {
		assertThat(FormatLine.getInstruction('A')).isEqualTo(mowerInstruction.ADVANCE);
		assertThat(FormatLine.getInstruction('D')).isEqualTo(mowerInstruction.RIGHT);
		assertThat(FormatLine.getInstruction('G')).isEqualTo(mowerInstruction.LEFT);
		assertThat(FormatLine.getInstruction(' ')).isNull();
	}

}
