package nieszczescialolowe.model;

import java.util.regex.Pattern;

import java.util.Hashtable;
import java.util.function.Consumer;

public class RegEx {

	private static final RegExFunctions FUNCTIONS = new RegExFunctions();
	
	public static final Hashtable<Pattern, Consumer<Object>> commands = new Hashtable<Pattern, Consumer<Object>>();
	
	// pokazuje ostatnie x gier
	private static final Pattern LIST_LAST_X = Pattern.compile("^(list last \\d+)$");
	static Consumer<Object> LIST_LAST_X_F = FUNCTIONS::listLastX;
	
	// czysci console
	private static final Pattern CLEAR = Pattern.compile("^(clear)$");
	static Consumer<Object> CLEAR_F = FUNCTIONS::clear;
	
	// help to help xd
	private static final Pattern HELP = Pattern.compile("^(help)$");
	static Consumer<Object> HELP_F = FUNCTIONS::help;
	
	static {
		commands.put(LIST_LAST_X, LIST_LAST_X_F);
		commands.put(CLEAR, CLEAR_F);
		commands.put(HELP, HELP_F);
	}
}
