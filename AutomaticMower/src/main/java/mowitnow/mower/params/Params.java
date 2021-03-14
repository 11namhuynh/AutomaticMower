package mowitnow.mower.params;

/**
 * class containing the parameters
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class Params {

	private Params() {

	}

	/**
	 * possible orientations
	 *
	 */
	public static enum Orientation {
		NORTH('N', "Nord"), EAST('E', "est"), WEST('W', "ouest"), SOUTH('S', "sud");

		private char codeOrientation;
		private String labelOrientation;

		private Orientation(char pCodeOrientation, String pLabelOrientation) {
			this.codeOrientation = pCodeOrientation;
			this.labelOrientation = pLabelOrientation;
		}

		public char getCodeOrientation() {
			return codeOrientation;
		}

		public String getLabelOrientation() {
			return labelOrientation;
		}
	}

	/**
	 * possible instructions 
	 *
	 */
	public static enum mowerInstruction {
		RIGHT('D', "Pivot right"), LEFT('G', "Pivot left"), ADVANCE('A', "Advance");

		private String labelInstruction;
		private char codeInstruction;

		private mowerInstruction(char pCodeInstruction, String labelInstruction) {
			this.labelInstruction = labelInstruction;
			this.codeInstruction = pCodeInstruction;
		}

		public String getlabelInstruction() {
			return labelInstruction;
		}

		public char getCodeInstruction() {
			return codeInstruction;
		}

	}

	public static final String INCORRECT_DATA_ERROR = "Incorrect data";
	public static final String EXISTING_FILE_ERROR = "File not found";
	public static final String INCORRECT_ORIENTATION = "Incorrect orientation";
	public static final String INCORRECT_INSTRUCTION = "Incorrect instruction";
	public static final String INCORRECT_POSITION = "Incorrect position ";
}