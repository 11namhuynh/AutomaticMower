package mowitnow.mower;

import static org.fest.assertions.Assertions.assertThat;   
import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import mowitnow.mower.common.ExceptionMowitnow;
import mowitnow.mower.params.Params;

/**
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class MainTest {
	final String PATH_FILE = "./src/test/resources/"; 

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test(expected = IllegalArgumentException.class)
	public void main_file_error_args() throws ExceptionMowitnow, IOException {
		Main.main("1", "2");
	}
	
	@Test
	public void main_file_existing_file_error() throws ExceptionMowitnow, IOException {
		expectedEx.expect(ExceptionMowitnow.class);
		expectedEx.expectMessage(Params.EXISTING_FILE_ERROR);
		Main.main("file not found");
	}
	
	@Test
	public void main_file_error_line_1() throws ExceptionMowitnow, IOException {
		expectedEx.expect(ExceptionMowitnow.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		Main.main(PATH_FILE + "file_line_1.txt");
	}
	
	
	@Test
	public void main_file_error_line_2() throws ExceptionMowitnow, IOException {
		expectedEx.expect(ExceptionMowitnow.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		Main.main(PATH_FILE + "file_line_2.txt");
	}
	
	@Test
	public void main_file_empty_file_error() throws ExceptionMowitnow, IOException {
		expectedEx.expect(ExceptionMowitnow.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		Main.main(PATH_FILE + "file_empty.txt");

	}
	
	@Test
	public void main_file_ko_file_error() throws ExceptionMowitnow, IOException {
		expectedEx.expect(ExceptionMowitnow.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		Main.main(PATH_FILE + "file_ko.txt");
	}
	
	
	@Test
	public void main_file_error_file() throws ExceptionMowitnow, IOException {
		Main.main(PATH_FILE + "file.txt");
		assertThat(Main.listResults).isNotNull();
		assertThat(Main.listResults).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}
	
}