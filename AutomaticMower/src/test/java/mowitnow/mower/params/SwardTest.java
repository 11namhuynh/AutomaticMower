package mowitnow.mower.params;

import static org.fest.assertions.Assertions.assertThat; 
import org.junit.Test;
/**
 * 
 * @author phuong-nam.huynh
 *
 * @version 0.0.1
 * 
 */
public class SwardTest {

	@Test
	public void check_overload_equals() {
		Sward p1 = new Sward(new Informations(1, 2));
		Sward p2 = new Sward(new Informations(1, 2));
		assertThat(p1.equals(p2)).isTrue();
		p2 = new Sward(new Informations(1, 3));
		assertThat(p1.equals(p2)).isFalse();
	}
}
