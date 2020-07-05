package nieszczescialolowe.model.regexp;

import nieszczescialolowe.model.file.FileManaging;

public class Commands {
	
	private static FileManaging fm;
	private static RegExOther other;
	private static RegExLane lane;
	private static RegExChamp champ;
	
	public Commands() {}
	
	public static void setFm(FileManaging fmNew) {
		fm = fmNew;
		other = new RegExOther(fm);
		lane = new RegExLane(fm);
		champ = new RegExChamp(fm);
	}
	
	public String help(Object x) {
		return other.help(x);
	}
	
	public String clear(Object x) {
		return "cl";
	}
	
	public String listLastX(Object x) {
		return other.listLastX(x);
	}
	
	public String averageStatsX(Object x) {
		return other.averageGameX(x);
	}
	
	public String averageStats(Object x) {
		return other.averageStats(x);
	}
	
	public String mostPlayedChamp(Object x) {
		return champ.mostPlayedChamp(x);
	}
	
	public String mostPlayedChampX(Object x) {
		return champ.mostPlayedChampX(x);
	}
	
	public String averageStatsChamp(Object x) {
		return champ.averageStatsChamp(x);
	}
	
	public String averageStatsChampX(Object x) {
		return champ.averageStatsChampX(x);
	}
	
	public String averageStatsLane(Object x) {
		return lane.averageStatsLane(x);
	}
	
	public String averageStatsLaneX(Object x) {
		return lane.averageStatsLaneX(x);
	}
	
	public String mostPlayedLane(Object x) {
		return lane.mostPlayedLane(x);
	}
	
	public String mostPlayedLaneX(Object x) {
		return lane.mostPlayedLaneX(x);
	}
}
