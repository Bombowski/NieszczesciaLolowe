package nieszczescialolowe.model.regexp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.RegEx;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.KdaCss;
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
			StringBuilder sb = new StringBuilder();
			
			for (Game game : tmp) {
				sb.append(game.toString())
					.append("\n");
			}
			
			Log.log(sb.toString());
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	public void averageGameX(Object x) {
		try {
			String command[] = x.toString().split(" ");
			int noGames = Integer.parseInt(command[2]);
			ArrayList<Game> games = fm.getTopXGames(noGames);
			
			if (games.size() == 0) {
				return;
			}
			
			int afks = 0;
			String time = "0:0:0";
			KdaCss kdac = new KdaCss(0, 0, 0, 0);

			HashMap<String, Integer> champions = new HashMap<String, Integer>();
			HashMap<String, Integer> grade = new HashMap<String, Integer>();
			HashMap<String, Integer> lane = new HashMap<String, Integer>();
			HashMap<String, Integer> winLose = new HashMap<String, Integer>();
			winLose.put("W", 0);

			for (Game game : games) {
				KdaCss tmp = game.getKdaCss();
				kdac.setKill(kdac.getKill() + tmp.getKill());
				kdac.setDead(kdac.getDead() + tmp.getDead());
				kdac.setAssist(kdac.getAssist() + tmp.getAssist());
				kdac.setCss(kdac.getCSs() + tmp.getCSs());

				afks += game.getAfks();
				time = ref.addTime(game.getTime(), time);

				champions.put(game.getChampion(), ref.add2HashTable(champions, game.getChampion()));
				grade.put(game.getGrade(), ref.add2HashTable(grade, game.getGrade()));
				lane.put(game.getLane(), ref.add2HashTable(lane, game.getLane()));
				winLose.put(game.getWinLose(), ref.add2HashTable(winLose, game.getWinLose()));
			}
			
			Stats s = new Stats();
			int size = games.size();
			s.setAfks(Math.round((float)afks / (float)size * 100f) / 100f);
			s.setChampion(ref.getMax(champions));
			s.setChampionPercent(ref.getPercent(champions.get(ref.getMax(champions)), size));
			s.setGrade(ref.getMax(grade));
			s.setGradePercent(ref.getPercent(grade.get(ref.getMax(grade)), size));
			s.setKdaCss(ref.avgKdaCss(kdac, size));
			s.setLane(ref.getMax(lane));
			s.setLanePercent(ref.getPercent(lane.get(ref.getMax(lane)), size));
			s.setTime(ref.avgTime(time, size));
			s.setWinLosePercent(ref.getPercent(winLose.get("W"), size));

			Log.log(s.toString());
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	public void averageStats(Object x) {
		averageGameX(x.toString() + " -1");
	}
}
