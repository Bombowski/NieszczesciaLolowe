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
	
	public String mostPlayedChamp(Object x) {
		return mostPlayedChampX(x.toString().concat(" -1"));	
	}
	
	public String mostPlayedChampX(Object x) {
		try {
			// zdobywam wybrana ilosc gier, -1 = wszystkie
			int selectedNoGames = Integer.parseInt(x.toString().split(" ")[3]);
			// zdobywam liste gier
			ArrayList<Game> games = fm.getTopXGames(selectedNoGames);
			selectedNoGames = selectedNoGames < 0 ? games.size() : selectedNoGames;
			
			// robie hihihi wiadomosc jesli wybrano 0
			if (selectedNoGames == 0) {
				return "Ehm you selected 0 games...";
			}
			
			HashMap<String, Integer> champs = new HashMap<String, Integer>();
			
			for (Game game : games) {
				champs.put(game.getChampion(), ref.add2HashTable(champs, game.getChampion()));
			}
			
			// wybieram najczesciej granego champa i printuje
			String champ = ref.getMax(champs);
			return new StringBuilder()
					.append("Most played champion: ")
					.append(champ)
					.append(" ; with a percentage of ")
					.append(ref.getPercent(champs.get(champ), selectedNoGames))
					.append("%")
					.toString();
		} catch (IOException | NumberFormatException e) {
			return e.getMessage();
		}
	}
	
	public String averageStatsChamp(Object x) {
		try {
			String[] split = x.toString().split(" ");
			String champ = split[2];
			
			ArrayList<Game> games = fm.getTopXGames(-1);
			ArrayList<Game> stats = new ArrayList<Game>();
			
			for (Game g : games) {
				if (g.getChampion().equals(champ)) {
					stats.add(g);
				}
			}
			
			// tutaj obliczyc wszystkie statu ze stats
			
		} catch(NumberFormatException | IOException e) {
			Log.log(e.getMessage());
		}
		
		return "Not implemented yet";
	}
	
	public String averageStatsChampX(Object x) {
		return "Not implemented yet";
	}
}
