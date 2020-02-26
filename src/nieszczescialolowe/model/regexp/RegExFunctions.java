package nieszczescialolowe.model.regexp;

import nieszczescialolowe.model.file.FileManaging;

public class RegExFunctions {
	
	private static FileManaging fm;
	private static RegExOther other;
	private static RegExLane lane;
	private static RegExChamp champ;
	
	public RegExFunctions() {}
	
	public static void setFm(FileManaging fmNew) {
		fm = fmNew;
		other = new RegExOther(fm);
		lane = new RegExLane(fm);
		champ = new RegExChamp(fm);
	}
	
	public void help(Object x) {
		other.help(x);
	}
	
	public void clear(Object x) {
		other.clear(x);
	}
	
	public void listLastX(Object x) {
		other.listLastX(x);
	}
	
	public void averageStatsX(Object x) {
		other.averageStatsX(x);
	}
	
	public void averageStats(Object x) {
		other.averageStats(x);
	}
	
	public void mostPlayedChamp(Object x) {
		champ.mostPlayedChamp(x);
	}
	
	public void mostPlayedChampX(Object x) {
		champ.mostPlayedChampX(x);
	}
	
	public void averageStatsChamp(Object x) {
		champ.averageStatsChamp(x);
	}
	
	public void averageStatsChampX(Object x) {
		champ.averageStatsChampX(x);
	}
	
	public void averageStatsLane(Object x) {
		lane.averageStatsLane(x);
	}
	
	public void averageStatsLaneX(Object x) {
		lane.averageStatsLaneX(x);
	}
	
	public void mostPlayedLane(Object x) {
		lane.mostPlayedLane(x);
	}
	
	public void mostPlayedLaneX(Object x) {
		lane.mostPlayedLaneX(x);
	}
}
