package mowitnow.mower.params;

import static org.fest.assertions.Assertions.assertThat;   
import org.junit.Test;
import mowitnow.mower.params.Params.Orientation;
/**
 * 
 * @author phuong-nam.huynh
 *
 * @version 0.0.1
 * 
 */
public class MowerPositionTest {

	@Test
	public void check_overload_equals() {
		
		MowerPosition positionT = new MowerPosition(new Informations(5, 5), Orientation.NORTH);
		MowerPosition positionTOk = new MowerPosition(new Informations(5, 5), Orientation.NORTH);
		MowerPosition positionTKo = new MowerPosition(new Informations(5, 5), Orientation.SOUTH);
		
		assertThat(positionT.equals(positionTOk)).isTrue();
		assertThat(positionT.equals(positionTKo)).isFalse();
	}

}
