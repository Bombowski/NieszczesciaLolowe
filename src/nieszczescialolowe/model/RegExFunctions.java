package nieszczescialolowe.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.function.Consumer;

import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.pojo.Game;

public class RegExFunctions {
	
	public static FileManaging fm;

	protected RegExFunctions() {
	}
	
	protected void clear(Object x) {
		Log.clearLog();
	}
	
	protected void help(Object x) {
		Hashtable<Command, Consumer<Object>> commands = RegEx.COMMANDS;
		StringBuilder sb = new StringBuilder();	
		
		for (Command com : commands.keySet()) {
			sb.append(com.getDescription())
				.append("\n");
		}
		
		Log.log(sb.toString(),false);
	}
	
	protected void listLastX(Object x) {
		try {
			String command[] = x.toString().split(" ");
			int noGames = Integer.parseInt(command[2]);
			
			ArrayList<Game> tmp = fm.getTopXGames(noGames);
			
			for (int i=0; i<tmp.size(); i++) {
				Log.log(tmp.get(i).toString());
			}
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	protected void averageLastX(Object x) {
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
}
