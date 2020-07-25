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
		return averageStatsChampX(x.toString().concat(" -1"));
	}
	
	public String averageStatsChampX(Object x) {
		try {
			String[] split = x.toString().split(" ");
			String champ = split[3];
			int noGames = Integer.parseInt(split[4]);
			
			if(noGames == 0) {
				return "Okay, you get 0 games :)";
			}
			
			ArrayList<Game> games = fm.getTopXGames(-1);
			ArrayList<Game> stats = new ArrayList<Game>();
			
			for (Game g : games) {
				if (g.getChampion().equals(champ)) {
					stats.add(g);
				}
			}
			
			if (noGames > 0) {
				int removeSize = stats.size() - noGames;
				for (int i = 0; i < removeSize; i++) {
					stats.remove(0);
				}
			}
			
			// obliczamy staty z wybranej ilosci ostatnich gier
			int k = 0;
			int d = 0;
			int a = 0;
			int c = 0;
			int win = 0;
			
			for (Game s : stats) {
				k = k + s.getKdaCss().getKill();
				d = d + s.getKdaCss().getDead();
				a = a + s.getKdaCss().getAssist();
				c = c + s.getKdaCss().getCSs();
				if (s.getWinLose() == "W") {
					win++;
				}
			}
			
			return new StringBuilder()
					.append("Average kda: ")
					.append(k/noGames)
					.append("/")
					.append(d/noGames)
					.append("/")
					.append(a/noGames)
					.append('\n')
					.append("Average Cs: ")
					.append(c/noGames)
					.append('\n')
					.append("Win ratio: ")
					.append(ref.getPercent(win, noGames))
					.append("%")
					.toString();
		} catch(NumberFormatException | IOException e) {
			return e.getMessage();
		}
	}
}
