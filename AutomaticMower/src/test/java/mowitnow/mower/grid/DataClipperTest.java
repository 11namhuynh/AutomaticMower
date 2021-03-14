package mowitnow.mower.grid;

import static org.fest.assertions.Assertions.assertThat;    
import org.junit.Test;
/**
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class DataClipperTest {
	
	@Test
	public void parse_mower(){
		DataClipper dataClipper = new DataClipper();
		dataClipper.setInstructions("DGDGA");
		dataClipper.setSward("50 5");
		dataClipper.setMower("1 2 N");
		assertThat(dataClipper.executeParse()).isTrue();
	}
	
	@Test
	public void parse_incorrect_lawn_mower(){
		DataClipper dataClipper = new DataClipper();
		dataClipper.setInstructions("DGDGA");
		dataClipper.setSward("0 -1");
		dataClipper.setMower("1 2 N");
		assertThat(dataClipper.executeParse()).isFalse();
	}
	
	@Test
	public void parse_mower_data_empty(){
		DataClipper dataClipper = new DataClipper();
		assertThat(dataClipper.executeParse()).isFalse();
	}
}
