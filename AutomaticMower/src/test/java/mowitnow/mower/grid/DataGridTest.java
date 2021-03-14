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
public class DataGridTest {
	
	@Test
	public void parse_mower(){
		assertThat(DataGrid.parseMower("")).isFalse();
		assertThat(DataGrid.parseMower("1 2 3")).isFalse();
		assertThat(DataGrid.parseMower("12N")).isFalse();
		assertThat(DataGrid.parseMower("1 2 N")).isTrue();
		assertThat(DataGrid.parseMower("1 2 S")).isTrue();
	}
	
	@Test
	public void parse_list_instruction(){
		assertThat(DataGrid.parseListInstruction("")).isFalse();
		assertThat(DataGrid.parseListInstruction(" ")).isFalse();
		assertThat(DataGrid.parseListInstruction("D G")).isFalse();
		assertThat(DataGrid.parseListInstruction("GGAAAGADDAN")).isFalse();
		assertThat(DataGrid.parseListInstruction("GGAAAG ADDAN")).isFalse();
		assertThat(DataGrid.parseListInstruction("DGA")).isTrue();
		assertThat(DataGrid.parseListInstruction("GGAAAGADDA")).isTrue();
	}
	
	@Test
	public void parse_lawn(){
		assertThat(DataGrid.parseSward("")).isFalse();
		assertThat(DataGrid.parseSward("1 2 3")).isFalse();
		assertThat(DataGrid.parseSward("123")).isFalse();
		assertThat(DataGrid.parseSward("1 2 ")).isFalse();
		assertThat(DataGrid.parseSward("1 2")).isTrue();
		assertThat(DataGrid.parseSward("1 N")).isFalse();
	}

}
