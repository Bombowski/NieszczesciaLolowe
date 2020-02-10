package nieszczescialolowe.model;

import java.util.regex.Pattern;
import java.util.Hashtable;
import java.util.function.Consumer;

public class RegEx {

	private static final RegExFunctions FUNCTIONS = new RegExFunctions();
	
	public static final Hashtable<Pattern, Consumer<Object>> idk = new Hashtable<Pattern, Consumer<Object>>();
	
	private static final Pattern LIST_LAST_X = Pattern.compile("^(list last \\d+)$");
	static Consumer<Object> LIST_LAST_X_F = FUNCTIONS::listLastX;
	
	static {
		idk.put(LIST_LAST_X, LIST_LAST_X_F);
	}
}
