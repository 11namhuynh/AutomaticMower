package mowitnow.mower.params;

import static org.fest.assertions.Assertions.assertThat ;  
import org.junit.Test;
/**
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class InformationsTest {

	@Test
	public void check_overload_equals(){
		Informations c1 = new Informations(1, 2);
		Informations c2 = new Informations(1, 2);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Informations(1, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void check_information(){
		Informations informations = new Informations(5,5);
		Informations c0 = new Informations(-1,1);
		Informations c1 = new Informations(1,1);
		assertThat(informations.isOutCoordinatesMax (c0)).isFalse();
		assertThat(informations.isOutCoordinatesMax (c1)).isTrue();
	}
}
