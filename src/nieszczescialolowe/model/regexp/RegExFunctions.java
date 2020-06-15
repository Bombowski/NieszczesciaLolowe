package nieszczescialolowe.model.regexp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.KdaCss;
import nieszczescialolowe.model.pojo.Stats;

/**
 * @author Patryk
 *
 * Tutaj bedziemy wstawiac rozne funkcje uzywane przez funkcje komend
 */
public class RegExFunctions {

	protected Stats getAverageStats(ArrayList<Game> games) {
		if (games.size() == 0) {
			return new Stats(0);
		}
		
		Game toReturn = new Game(new KdaCss(), "", "", "0:0:0", "", "", 2);
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
			time = addTime(game.getTime(), time);

			champions.put(game.getChampion(), add2HashTable(champions, game.getChampion()));
			grade.put(game.getGrade(), add2HashTable(grade, game.getGrade()));
			lane.put(game.getLane(), add2HashTable(lane, game.getLane()));
			winLose.put(game.getWinLose(), add2HashTable(winLose, game.getWinLose()));
		}
		
		Stats s = new Stats();
		int size = games.size();
		s.setAfks(toReturn.getAfks() / Float.parseFloat(size + ""));
		s.setChampion(getMax(champions));
		s.setChampionPercent(getPercent(champions.get(getMax(champions)), size));
		s.setGrade(getMax(grade));
		s.setGradePercent(getPercent(grade.get(getMax(grade)), size));
		s.setKdaCss(avgKdaCss(kdac, size));
		s.setLane(getMax(lane));
		s.setLanePercent(getPercent(lane.get(getMax(lane)), size));
		s.setTime(avgTime(time, size));
		s.setWinLosePercent(getPercent(winLose.get("W"), size));

		return s;
	}
	
	private float getPercent(int num, int size) {
		return Math.round((float)num / size * 100f * 100f) / 100f;
	}
	
	private String avgTime(String time, int size) {
		String[] split = time.split(":");
		
		int seconds = (Integer.parseInt(split[2]) + (Integer.parseInt(split[1]) * 60) + 
				(Integer.parseInt(split[0]) * 60 * 60)) / size;
		
		split[0] = (seconds / 3600) + "";
		split[1] = (seconds / 60 % 60) + "";
		split[2] = (seconds % 60) + "";
		
		return splitTime2Str(split);
	}

	private KdaCss avgKdaCss(KdaCss kdac, int size) {
		kdac.setKill(kdac.getKill() / size);
		kdac.setDead(kdac.getDead() / size);
		kdac.setAssist(kdac.getAssist() / size);
		kdac.setCss(kdac.getCSs() / size);
		
		return kdac;
	}
	
	private String getMax(HashMap<String, Integer> map) {
		int max = 0;
		String maxS = "";
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				maxS = entry.getKey();
				max = entry.getValue();
			}
		}
		return maxS;
	}
	
	private Integer add2HashTable(HashMap<String, Integer> map, String key) {
		return map.containsKey(key) ? map.get(key) + 1 : 1;
	}

	private String addTime(String time, String oldTime) {
		String[] oldT = oldTime.split(":");
		String[] newT = time.split(":");

		int n1 = Integer.parseInt(oldT[0]) + Integer.parseInt(newT[0]);
		int n2 = Integer.parseInt(oldT[1]) + Integer.parseInt(newT[1]);
		int n3 = Integer.parseInt(oldT[2]) + Integer.parseInt(newT[2]);

		String[] arr = {n1 + "", n2 + "", n3 + ""};
		
		return splitTime2Str(arr);
	}
	
	private String splitTime2Str(String[] splitTime) {
		return new StringBuilder()
				.append(splitTime[0])
				.append(":")
				.append(splitTime[1])
				.append(":")
				.append(splitTime[2])
				.toString();
	}
}
