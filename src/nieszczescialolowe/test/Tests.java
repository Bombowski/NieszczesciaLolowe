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

@RunWith(Suite.class)
@SuiteClasses({TestRegExChamp.class, TestRegExOther.class, TestRegExLane.class })
public class Tests {

	private static String path = "C:\\Users\\patry\\Documents\\lol.csv";
	protected static FileManaging fm;
	protected static Commands com;
	
	@BeforeClass
	public static void test() {
		Log.setMode(1);
		fm = new FileManaging(path);
		com = new Commands();
		Commands.setFm(fm);
	}
	
	protected static void runCommand(String command, String input) {
		for (Entry<Command, Consumer<Object>> entry : RegEx.COMMANDS.entrySet()) {
			if (Pattern.matches(entry.getKey().getPattern().toString(), command)) {
				entry.getValue().accept(input);
			}
		}
	}
}
