package nieszczescialolowe.test;

import java.util.Map.Entry;
import java.util.function.Function;
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
 * Testy ktory testuja output z konsoli musza uzywac StringBuilder'a dla oczekiwanego rezultatu.
 * Jedna linia w konsoli musi reprezentowac jedna linie append(). Robi tak dla czytelnosci, i
 * dla latwiejszego modyfikowania testow w przyszlosci.
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
		for (Entry<Command, Function<Object, String>> entry : RegEx.COMMANDS.entrySet()) {
			if (Pattern.matches(entry.getKey().getPattern().toString(), command)) {
				return entry.getValue().apply(command);
			}
		}
		return "Command not found";
	}
}
