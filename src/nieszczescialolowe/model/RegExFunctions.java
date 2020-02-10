package nieszczescialolowe.model;

import java.io.IOException;
import java.util.ArrayList;

import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;

public class RegExFunctions {
	
	public static FileManaging fm;

	protected RegExFunctions() {
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
	
	protected void clear(Object x) {
		Log.clearLog();
	}
	
	protected void help(Object x) {
		Log.log("Available commands:" + '\n' + "list last X - Shows X last games" + '\n' + "clear - Clears the console");
	}
}
