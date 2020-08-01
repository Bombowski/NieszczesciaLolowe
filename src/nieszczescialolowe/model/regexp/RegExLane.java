package nieszczescialolowe.model.regexp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.KdaCss;
import nieszczescialolowe.model.pojo.Stats;

/**
 * @author Patryk
 *
 * Funkcje dotyczace linii
 */
public class RegExLane {

	private FileManaging fm;
	private RegExFunctions ref;
	
	public RegExLane(FileManaging fm) {
		this.fm = fm;
		this.ref = new RegExFunctions();
	}
	
	public String averageStatsLane(Object x) {
		return averageStatsLaneX(x.toString() + " -1");
	}
	
	public String averageStatsLaneX(Object x) {
		try {
			String[] split = x.toString().split(" ");
			String lane = split[3];
			int noGames = Integer.parseInt(split[4]);
			
			if (noGames == 0) {
				return "Ehm you selected 0 games...";
			}
			
			ArrayList<Game> games = fm.getTopXGames(-1);
			ArrayList<Game> stats = new ArrayList<Game>();
			
			for (Game g : games) {
				if (g.getLane().equals(lane)) {
					stats.add(g);
				}
			}
			
			if (stats.size() == 0) {
				return "No games with selected lane found";
			}
			
			// Usuwamy nadmiar gier od najstarszych
			if (noGames > 0) {
				int removeSize = stats.size() - noGames;
				for (int i = 0; i < removeSize; i++) {
					stats.remove(0);
				}
			}
			
			noGames = stats.size();
			
			// Obliczamy staty z wybranej ilosci gier
			KdaCss kda = new KdaCss(0,0,0,0);
			String time = "0:0:0";
			int win = 0;
			int afks = 0;
			
			HashMap<String, Integer> champ = new HashMap<String, Integer>();
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
				champ.put(s.getChampion(), ref.add2HashTable(champ, s.getChampion()));
			}
			
			// Setuje all staty w objekcie stats i printuje
			Stats n = new Stats();
			n.setAfks(Math.round((float)afks / (float)noGames * 100f) / 100f);
			n.setGrade(ref.getMax(grade));
			n.setGradePercent(ref.getPercent(grade.get(ref.getMax(grade)), noGames));
			n.setKdaCss(ref.avgKdaCss(kda, noGames));
			n.setChampion(ref.getMax(champ));
			n.setChampionPercent(ref.getPercent(champ.get(ref.getMax(champ)), noGames));
			n.setTime(ref.avgTime(time, noGames));
			n.setWinLosePercent(ref.getPercent(win, noGames));
			
			return n.toString();
		} catch (IOException | NumberFormatException e) {
			Log.logError(e.getStackTrace(), e.getLocalizedMessage());
			return "";
		}
	}
	
	public String mostPlayedLane(Object x) {
		return mostPlayedLaneX(x.toString() + " -1");
	}
	
	public String mostPlayedLaneX(Object x) {
		try {
			// Zdobywam ilosc gier
			int noGames = Integer.parseInt(x.toString().split(" ")[3]);
			
			if (noGames == 0) {
				return "Ehm you selected 0 games...";
			}
			
			// Zdobywam liste gier
			ArrayList<Game> games = fm.getTopXGames(noGames);
			noGames = games.size();
			
			// Specjalna wiadomosc dla smieszkow
			if(noGames == 0) {
				return "No games found";
			}
			
			// Zapisuje linie w hashmapie
			HashMap<String, Integer> lanes = new HashMap<String, Integer>();
			for (Game game : games) {
				String l = game.getLane();
				lanes.put(l, ref.add2HashTable(lanes, l));
			}
			 
			// Wybieram najczesciej grana linie i printuje 
			String lane = ref.getMax(lanes);
			return new StringBuilder()
					.append("Most played lane: ")
					.append(lane)
					.append(" ; with a percentage of ")
					.append(ref.getPercent(lanes.get(lane), noGames))
					.append("%")
					.toString();
		} catch (IOException | NumberFormatException e) {
			Log.logError(e.getStackTrace(), e.getLocalizedMessage());
			return "";
		}
	}
}
