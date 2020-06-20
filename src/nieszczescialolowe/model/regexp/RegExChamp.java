package nieszczescialolowe.model.regexp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;

/**
 * @author Patryk
 *
 * funkcje dotyczace championow
 */
public class RegExChamp {

	private FileManaging fm;
	private RegExFunctions ref;
	
	public RegExChamp(FileManaging fm) {
		this.fm = fm;
		this.ref = new RegExFunctions();
	}
	
	public void mostPlayedChamp(Object x) {
		mostPlayedChampX(x.toString().concat(" -1"));	
	}
	
	public void mostPlayedChampX(Object x) {
		try {
			// zdobywam wybrana ilosc gier, -1 = wszystkie
			int selectedNoGames = Integer.parseInt(x.toString().split(" ")[3]);
			// zdobywam liste gier
			ArrayList<Game> games = fm.getTopXGames(selectedNoGames);
			// zapisuje lokalnie ilosc itemow w liscie gier
			int gamesSize = games.size();
			// robie hihihi wiadomosc jesli wybrano 0
			if (selectedNoGames == 0) {
				Log.log("Ehm you selected 0 games...");
				return;
			}
			
			HashMap<String, Integer> champs = new HashMap<String, Integer>();
			Game game;
			// obliczam ile gier nie zostalo wybranych
			int noGames = gamesSize - selectedNoGames;
			// jesli zostalo wybranych za duzo lub mniej niz 1 setuje na 0
			noGames = noGames < 1 || noGames >= gamesSize ? 0 : noGames;
			
			// zdobywam gry z listy i zapisuje championy w hashmaie
			for (; noGames < gamesSize; noGames++) {
				game = games.get(noGames);
				champs.put(game.getChampion(), ref.add2HashTable(champs, game.getChampion()));
			}
			
			// wybieram najczesciej granego champa i printuje
			String champ = ref.getMax(champs);
			Log.log(new StringBuilder()
					.append("Most played champion: ")
					.append(champ)
					.append(" ; with a percentage of ")
					.append(ref.getPercent(champs.get(champ), selectedNoGames))
					.append("%")
					.toString());
		} catch (IOException | NumberFormatException e) {
			Log.log(e.getMessage());
		}
	}
	
	public void averageStatsChamp(Object x) {
		
	}
	
	public void averageStatsChampX(Object x) {
		
	}
}
