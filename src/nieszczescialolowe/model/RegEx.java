package nieszczescialolowe.model;

import java.util.regex.Pattern;

import nieszczescialolowe.model.pojo.Command;

import java.util.Hashtable;
import java.util.function.Consumer;

public class RegEx {

	private static final RegExFunctions FUNCTIONS = new RegExFunctions();
	
	public static final Hashtable<Command, Consumer<Object>> commands = new Hashtable<Command, Consumer<Object>>();
	
	private static final Command LIST_LAST_X = 
			new Command("list last X - Shows X last games", "^(list last \\d+)$");
	static Consumer<Object> LIST_LAST_X_F = FUNCTIONS::listLastX;
	
	private static final Command CLEAR = 
			new Command("clear - Clears the console", "^(clear)$");
	static Consumer<Object> CLEAR_F = FUNCTIONS::clear;
	
	private static final Command HELP = 
			new Command("help - Lists all commands", "^(help)$");
	static Consumer<Object> HELP_F = FUNCTIONS::help;
	
	static {
		commands.put(LIST_LAST_X, LIST_LAST_X_F);
		commands.put(CLEAR, CLEAR_F);
		commands.put(HELP, HELP_F);
	}
}
