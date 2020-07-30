package nieszczescialolowe.model.regexp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.KdaCss;
import nieszczescialolowe.model.pojo.Stats;

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
		return averageStatsChampX(x.toString() + " -1");
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
			
			noGames = stats.size();
			
			// obliczamy staty z wybranej ilosci ostatnich gier
			KdaCss kda = new KdaCss(0,0,0,0);
			String time = "0:0:0";
			int win = 0;
			int afks = 0;
			
			HashMap<String, Integer> lane = new HashMap<String, Integer>();
			HashMap<String, Integer> grade = new HashMap<String, Integer>();
			
			for (Game s : stats) {
				KdaCss tmp = s.getKdaCss();
				kda.setKill(kda.getKill() + tmp.getKill());
				kda.setDead(kda.getDead() + tmp.getDead());
				kda.setAssist(kda.getAssist() + tmp.getAssist());
				kda.setCss(kda.getCSs() + tmp.getCSs());
				
				if (s.getWinLose().equals("W")) {
					win++;
				}
				
				afks += s.getAfks();
				time = ref.addTime(s.getTime(), time);
				
				grade.put(s.getGrade(), ref.add2HashTable(grade, s.getGrade()));
				lane.put(s.getLane(), ref.add2HashTable(lane, s.getLane()));
			}
			
			Stats n = new Stats();
			n.setAfks(Math.round((float)afks / (float)noGames * 100f) / 100f);
			n.setGrade(ref.getMax(grade));
			n.setGradePercent(ref.getPercent(grade.get(ref.getMax(grade)), noGames));
			n.setKdaCss(ref.avgKdaCss(kda, noGames));
			n.setLane(ref.getMax(lane));
			n.setLanePercent(ref.getPercent(lane.get(ref.getMax(lane)), noGames));
			n.setTime(ref.avgTime(time, noGames));
			n.setWinLosePercent(ref.getPercent(win, noGames));
			
			return n.toString();
		} catch(NumberFormatException | IOException e) {
			return e.getMessage();
		}
	}
}
