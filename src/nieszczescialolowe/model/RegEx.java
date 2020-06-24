package nieszczescialolowe.model;

import java.util.Hashtable;
import java.util.function.Consumer;

import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.regexp.Commands;

/**
 * @author Patryk
 * 
 * tutaj wstawiamy komendy z ich opisami, w clasie RegExFunctions
 * tworzymy funkcje public void ktore biora jako parametr object,
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
public class RegEx {

	private static final Commands FUNCTIONS = new Commands();
	public static final Hashtable<Command, Consumer<Object>> COMMANDS = 
			new Hashtable<Command, Consumer<Object>>();
	
	// done
	private static final Command HELP = 
			new Command("help - Lists all commands", "^(help)$");
	private static Consumer<Object> HELP_F = FUNCTIONS::help;

	// done
	private static final Command CLEAR = 
			new Command("clear - Clears the console", "^(clear)$");
	private static Consumer<Object> CLEAR_F = FUNCTIONS::clear;
	
	// done
	private static final Command LIST_LAST_X = 
			new Command("list last X - Shows X last games", "^(list last \\d+)$");
	private static Consumer<Object> LIST_LAST_X_F = FUNCTIONS::listLastX;
	
	// done
	private static final Command AVERAGE_GAME_X =
			new Command("average game X - Shows the average statistics from last X games", "^(average game \\d+)$");
	private static Consumer<Object> AVERAGE_STATS_X_F = FUNCTIONS::averageStatsX;
	
	// done
	private static final Command AVERAGE_GAME =
			new Command("average game - Shows the average statistics from all games", "^(average game)$");
	private static Consumer<Object> AVERAGE_STATS_F = FUNCTIONS::averageStats;
	
	// done
	private static final Command MOST_PLAYED_CHAMP =
			new Command("most played champ - Shows the most played champ in any lane", "^(most played champ)$");
	private static Consumer<Object> MOST_PLAYED_CHAMP_F = FUNCTIONS::mostPlayedChamp;
	
	// done
	private static final Command MOST_PLAYED_CHAMP_X =
			new Command("most played champ x - Shows the most played champ in the last x games", "^(most played champ \\d+)$");
	private static Consumer<Object> MOST_PLAYED_CHAMP_X_F = FUNCTIONS::mostPlayedChampX;
	
	private static final Command AVERAGE_STATS_CHAMP =
			new Command("average champ X - Shows the average statistics of x champion", "^(average champ \\w+)$");
	private static Consumer<Object> AVERAGE_STATS_CHAMP_F = FUNCTIONS::averageStats;
	
	private static final Command AVERAGE_STATS_LANE =
			new Command("average lane X - shows average stats from x lane", "^(average lane \\w+)$");
	private static Consumer<Object> AVERAGE_STATS_LANE_F = FUNCTIONS::averageStatsLane;
	
	private static final Command AVERAGE_STATS_LANE_X =
			new Command("average lane X Y - shows average stats in x lane from last y games", "^(average lane \\w+ \\d+)$");
	private static Consumer<Object> AVERAGE_STATS_LANE_X_F = FUNCTIONS::averageStatsLaneX;
	
	private static final Command MOST_PLAYED_LANE =
			new Command("most played lane - shows the most played lane from all games", "^(most played lane)$");
	private static Consumer<Object> MOST_PLAYED_LANE_F = FUNCTIONS::mostPlayedLane;
	
	private static final Command MOST_PLAYED_LANE_X =
			new Command("most played lane X - shows the most played lane from last x games", "^(most played lane \\d+)$");
	private static Consumer<Object> MOST_PLAYED_LANE_X_F = FUNCTIONS::mostPlayedLaneX;
	
	/**
	 * tutaj dodajemy object Command jako key, y Consumer jako
	 * value do hashtable'a.
	 * funkcja static inicjalizuje sie sama
	 */
	static {
		COMMANDS.put(HELP, HELP_F);
		COMMANDS.put(CLEAR, CLEAR_F);
		COMMANDS.put(LIST_LAST_X, LIST_LAST_X_F);
		COMMANDS.put(AVERAGE_GAME_X, AVERAGE_STATS_X_F);
		COMMANDS.put(AVERAGE_GAME, AVERAGE_STATS_F);
		COMMANDS.put(MOST_PLAYED_CHAMP, MOST_PLAYED_CHAMP_F);
		COMMANDS.put(MOST_PLAYED_CHAMP_X, MOST_PLAYED_CHAMP_X_F);
		COMMANDS.put(AVERAGE_STATS_CHAMP, AVERAGE_STATS_CHAMP_F);
		COMMANDS.put(AVERAGE_STATS_LANE, AVERAGE_STATS_LANE_F);
		COMMANDS.put(AVERAGE_STATS_LANE_X, AVERAGE_STATS_LANE_X_F);
		COMMANDS.put(MOST_PLAYED_LANE, MOST_PLAYED_LANE_F);
		COMMANDS.put(MOST_PLAYED_LANE_X, MOST_PLAYED_LANE_X_F);
	}
}
