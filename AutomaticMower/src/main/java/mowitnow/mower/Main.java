package mowitnow.mower;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mowitnow.mower.calcul.CalculSward;
import mowitnow.mower.calcul.FormatLine;
import mowitnow.mower.common.ExceptionMowitnow;
import mowitnow.mower.grid.DataClipper;
import mowitnow.mower.params.Params;

/**
 * main class allowing to read the file content .
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class Main {

	/**
	 * Result list
	 */
	protected static List<String> listResults;

	/**
	 * @param args
	 * @throws ExceptionMowitnow
	 * @throws IOException
	 */
	public static void main(String... args) throws ExceptionMowitnow, IOException {
		// Read inputs
		if (args.length == 1) {
			File file = new File(args[0]);
			Main instance = new Main();
			listResults = instance.launchTreatmentsMowers(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Read / validate the file and start the mowers
	 * 
	 * @param  file
	 * @throws ExceptionMowitnow
	 * @throws IOException
	 * @return List<String> : mower position
	 */
	private List<String> launchTreatmentsMowers(File file) throws ExceptionMowitnow, IOException {
		// Read file.
		if (!file.isFile()) {
			throw new ExceptionMowitnow(Params.EXISTING_FILE_ERROR);
		} else {
			DataClipper parser = new DataClipper();
			Scanner scanner = new Scanner(file);
			try {
				treatFirstLine(parser, scanner);
				return processFollowingLines(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	/**
	 * Process the first line of the file
	 * 
	 * @param parser
	 * @param scanner
	 * @throws ExceptionMowitnow : error if the file contains less than 2 lines
	 */
	protected void treatFirstLine(DataClipper parser, Scanner scanner) throws ExceptionMowitnow {
		if (scanner.hasNext()) {
			parser.setSward(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionMowitnow(Params.INCORRECT_DATA_ERROR);
		}
	}

	/**
	 * Processing of subsequent lines
	 * 
	 * @param parser
	 * @param scanner
	 * @return the position of the mowers
	 * @throws ExceptionMowitnow
	 */
	private List<String> processFollowingLines(DataClipper parser, Scanner scanner) throws ExceptionMowitnow {
		List<String> listPositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			// reading the mower's initial position
			parser.setMower(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listPositions.add(parseAndStartProcessing(parser));
			} else {
				throw new ExceptionMowitnow(Params.INCORRECT_DATA_ERROR);
			}
		}
		return listPositions;
	}

	/**
	 * Start and run the mower treatment
	 * 
	 * @param parser : the object containing the mower information
	 * @throws ExceptionMowitnow
	 */
	private String parseAndStartProcessing(DataClipper parser) throws ExceptionMowitnow {
		if (!parser.executeParse()) {
			throw new ExceptionMowitnow(Params.INCORRECT_DATA_ERROR);
		} else {
			CalculSward caculSward = new CalculSward();
			caculSward.setSward(FormatLine.formatLineLawn(parser.getSward()));
			caculSward.setMowerPosition(FormatLine.formatLineMower(parser.getMower()));
			caculSward.setInstructionList(FormatLine.formaterLigneInstruction(parser.getInstructions()));
			caculSward.executerInstructions();
			System.out.println(caculSward);
			return caculSward.toString();
		}
	}
}