package nieszczescialolowe.model.regexp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.RegEx;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.pojo.Game;

/**
 * @author Patryk
 *
 * ogolne funkcje
 */
public class RegExOther {

	private FileManaging fm;
	
	protected RegExOther(FileManaging fm) {
		this.fm = fm;
	}
	
	public void help(Object x) {
		// Wstawiam hashtable do arraylista, i sortuje liste alfabetycznie 
		ArrayList<Command> sorted = Collections.list(RegEx.COMMANDS.keys());
		Collections.sort(sorted);
		
		StringBuilder sb = new StringBuilder();
		
		for (Command com : sorted) {
			sb.append(com.getDescription())
				.append("\n");
		}
		
		Log.log(sb.toString(),false);
	}
	
	public void clear(Object x) {
		Log.clearLog();
	}
	
	public void listLastX(Object x) {
		try {
			String command[] = x.toString().split(" ");
			int noGames = Integer.parseInt(command[2]);
			
			ArrayList<Game> tmp = fm.getTopXGames(noGames);
			
			for (Game game : tmp) {
				Log.log(game.toString());
			}
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	public void averageStatsX(Object x) {
		try {
			String command[] = x.toString().split(" ");
			int noGames = Integer.parseInt(command[2]);
			
			ArrayList<Game> tmp = fm.getTopXGames(noGames);
			
			/*
			 * TODO duzo roboty tak ogolnie, zrobic tutaj jakies
			 * obliczenia srednich statystyk, takie ez rzeczy jak kda css
			 * po najczesciej grany czempion, srednia ocena, etc
			 */
			Log.log("TODO");
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	public void averageStats(Object x) {
		
	}
}
