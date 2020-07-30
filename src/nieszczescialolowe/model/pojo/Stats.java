package nieszczescialolowe.model.pojo;

/**
 * @author Patryk
 *
 *         Klasa ze stadystykami, najrpawdopodobniej bedzie do roznych typow
 *         funkcji ktore beda kalkulowaly srednia jakichs statystyk
 */
public class Stats {

	private KdaCss kdaCss;
	private String champion;
	private float championPercent;
	private String lane;
	private float lanePercent;
	private float winLosePercent;
	private String time;
	private String grade;
	private float gradePercent;
	private float afks;

	public Stats(KdaCss kdaCss, String champion, float championPercent, String lane, float lanePercent,
			float winLosePercent, String time, String grade, float gradePercent, float afks) {
		super();
		this.kdaCss = kdaCss;
		this.champion = champion;
		this.championPercent = championPercent;
		this.lane = lane;
		this.lanePercent = lanePercent;
		this.winLosePercent = winLosePercent;
		this.time = time;
		this.grade = grade;
		this.gradePercent = gradePercent;
		this.afks = afks;
	}
	
	public Stats() {
		this.kdaCss = new KdaCss();
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Average KDACss - ")
				.append(kdaCss.toString())
				.append("\n")
				.append(champion == null ? "" : 
					new StringBuilder()
					.append("Most played champion - ")
					.append(champion)
					.append("\nMost played champion pickrate - ")
					.append(championPercent)
					.append("\n")
					.toString())
				.append(lane == null ? "" : 
					new StringBuilder()
					.append("Most played lane - ")
					.append(lane)
					.append("\nMost played lane % - ")
					.append(lanePercent)
					.append("\n")
					.toString())
				.append("Win ratio % - ")
				.append(winLosePercent)
				.append("\nAverage game time - ")
				.append(time)
				.append("\nMost often grade - ")
				.append(grade)
				.append("\nMost often grade % - ")
				.append(gradePercent)
				.append("\nAverage afk's - ")
				.append(afks)
				.toString();
	}

	public KdaCss getKdaCss() {
		return kdaCss;
	}

	public void setKdaCss(KdaCss kdaCss) {
		this.kdaCss = kdaCss;
	}

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public float getChampionPercent() {
		return championPercent;
	}

	public void setChampionPercent(float championPercent) {
		this.championPercent = championPercent;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public float getLanePercent() {
		return lanePercent;
	}

	public void setLanePercent(float lanePercent) {
		this.lanePercent = lanePercent;
	}

	public float getWinLosePercent() {
		return winLosePercent;
	}

	public void setWinLosePercent(float winLosePercent) {
		this.winLosePercent = winLosePercent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getGradePercent() {
		return gradePercent;
	}

	public void setGradePercent(float gradePercent) {
		this.gradePercent = gradePercent;
	}

	public float getAfks() {
		return afks;
	}

	public void setAfks(float afks) {
		this.afks = afks;
	}

}
