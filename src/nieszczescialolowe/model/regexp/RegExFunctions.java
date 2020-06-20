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
	
	public RegExFunctions() {}
	
	/**
	 * Returns the percentage with 2 decimals at most
	 * 
	 * @param num int how many was repeated
	 * @param size total number
	 * @return float
	 */
	protected float getPercent(int num, int size) {
		return Math.round(((float)num * 100f / (float)size) * 100f) / 100f;
	}
	
	protected String avgTime(String time, int size) {
		String[] split = time.split(":");
		
		int seconds = (Integer.parseInt(split[2]) + (Integer.parseInt(split[1]) * 60) + 
				(Integer.parseInt(split[0]) * 60 * 60)) / size;
		
		split[0] = (seconds / 3600) + "";
		split[1] = (seconds / 60 % 60) + "";
		split[2] = (seconds % 60) + "";
		
		return splitTime2Str(split);
	}

	protected KdaCss avgKdaCss(KdaCss kdac, int size) {
		kdac.setKill(kdac.getKill() / size);
		kdac.setDead(kdac.getDead() / size);
		kdac.setAssist(kdac.getAssist() / size);
		kdac.setCss(kdac.getCSs() / size);
		
		return kdac;
	}
	
	protected String getMax(HashMap<String, Integer> map) {
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
	
	/**
	 * Znajduje w podanym HashMapie value za pomoca key'a, jesli
	 * nie istnieje, oddaje 1, jesli tak, value + 1.
	 * 
	 * @param map HashMap
	 * @param key String
	 * @return Integer
	 */
	protected Integer add2HashTable(HashMap<String, Integer> map, String key) {
		return map.containsKey(key) ? map.get(key) + 1 : 1;
	}

	protected String addTime(String time, String oldTime) {
		String[] oldT = oldTime.split(":");
		String[] newT = time.split(":");

		int n1 = Integer.parseInt(oldT[0]) + Integer.parseInt(newT[0]);
		int n2 = Integer.parseInt(oldT[1]) + Integer.parseInt(newT[1]);
		int n3 = Integer.parseInt(oldT[2]) + Integer.parseInt(newT[2]);

		String[] arr = {n1 + "", n2 + "", n3 + ""};
		
		return splitTime2Str(arr);
	}
	
	protected String splitTime2Str(String[] splitTime) {
		return new StringBuilder()
				.append(splitTime[0])
				.append(":")
				.append(splitTime[1])
				.append(":")
				.append(splitTime[2])
				.toString();
	}
}
