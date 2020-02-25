package nieszczescialolowe.model;

import java.util.Hashtable;
import java.util.function.Consumer;

import nieszczescialolowe.model.pojo.Command;

public class RegEx {

	private static final RegExFunctions FUNCTIONS = new RegExFunctions();
	public static final Hashtable<Command, Consumer<Object>> COMMANDS = 
			new Hashtable<Command, Consumer<Object>>();
	
	/*
	 * tutaj wstawiamy komendy z ich opisami, w clasie RegExFunctions
	 * tworzymy funkcje protected void ktore biora jako parametr object,
	 * te funkcje wstawiamy w consumeze.
	 * Object w javie to clasa ktora inherituja (dziedzicza) wszystkie 
	 * inne clasy, wiec object jest widziany przez jave jako niezidentyfikowany
	 * object, to moze byc cokolwiek, tylko nie typ prymitywny (int, char, float,
	 * double, etc.), ale my wiemy co ta funkcja otrzymuje i wiemy czym tak 
	 * naprawde jest ten object. 
	 * Przyklady jak zamienic object na inny typ:
	 * 
	 * public void przyklad(Object x) {
	 * 
	 * ArrayList<Game> games = (ArrayList<Game>)x;
	 * Integer integer = (Integer)x;
	 * String str = x.toString(); 
	 * 
	 * }
	 */
	private static final Command HELP = 
			new Command("help - Lists all commands", "^(help)$");
	private static Consumer<Object> HELP_F = FUNCTIONS::help;

	private static final Command CLEAR = 
			new Command("clear - Clears the console", "^(clear)$");
	private static Consumer<Object> CLEAR_F = FUNCTIONS::clear;
	
	private static final Command LIST_LAST_X = 
			new Command("list last X - Shows X last games", "^(list last \\d+)$");
	private static Consumer<Object> LIST_LAST_X_F = FUNCTIONS::listLastX;
	
	private static final Command AVERAGE_LAST_X =
			new Command("average last X - Shows the average statistics from last X games", "^(average last \\d+)$");
	private static Consumer<Object> AVERAGE_LAST_X_F = FUNCTIONS::averageLastX;
	
	/**
	 * tutaj dodajemy object Command jako key, y Consumer jako
	 * value do hashtable'a.
	 * funkcja static initializuje sie sama
	 */
	static {
		COMMANDS.put(LIST_LAST_X, LIST_LAST_X_F);
		COMMANDS.put(CLEAR, CLEAR_F);
		COMMANDS.put(HELP, HELP_F);
		COMMANDS.put(AVERAGE_LAST_X, AVERAGE_LAST_X_F);
	}
}
