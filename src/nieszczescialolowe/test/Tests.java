package nieszczescialolowe.test;

import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.RegEx;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.regexp.Commands;

/**
 * @author Patryk
 *
 * Te classe odpalamy kiedy chcemy runowac testy, jesli chcemy dodac wiecej class z testami,
 * dodajemy je do notacji SuiteClasses.
 * 
 * Tests that test console output, must use a StringBuilder object for the expected result,
 * and line in console must be one line of append() method. The purpose of this is readability,
 * and it will also make easier changing these tests in the future.
 */
@RunWith(Suite.class)
@SuiteClasses({TestRegExChamp.class, TestRegExOther.class, TestRegExLane.class })
public class Tests {

	private static String path = "src\\test\\testFile.csv";
	protected static FileManaging fm;
	protected static Commands com;
	
	@BeforeClass
	public static void test() {
		Log.setMode(1);
		fm = new FileManaging(path);
		com = new Commands();
		Commands.setFm(fm);
	}
	
	protected static String runCommand(String command) {
		for (Entry<Command, Consumer<Object>> entry : RegEx.COMMANDS.entrySet()) {
			if (Pattern.matches(entry.getKey().getPattern().toString(), command)) {
				entry.getValue().accept(command);
			}
		}
		return Log.getLog();
	}
}
