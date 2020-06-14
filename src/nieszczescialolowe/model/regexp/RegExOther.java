package nieszczescialolowe.model.regexp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map.Entry;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.RegEx;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.Stats;

/**
 * @author Patryk
 *
 * ogolne funkcje
 */
public class RegExOther {

	private FileManaging fm;
	private RegExFunctions ref;
	
	protected RegExOther(FileManaging fm) {
		this.fm = fm;
		this.ref = new RegExFunctions();
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
			
			Stats st = ref.getAverageStats(fm.getTopXGames(noGames));
			
			Log.log(st.toString());
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	public void averageStats(Object x) {
//		fm.getTopXGames(-1);
	}
}
