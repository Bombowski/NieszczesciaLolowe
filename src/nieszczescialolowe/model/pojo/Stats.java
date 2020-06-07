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
		super();
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Average KDACss - ")
				.append(kdaCss.toString())
				.append("\n")
				.append("Most played champion - ")
				.append(champion)
				.append("\n")
				.append("Most played champion pickrate - ")
				.append(championPercent)
				.append("\n")
				.append("Most played lane - ")
				.append(lane)
				.append("\n")
				.append("Most played lane % - ")
				.append(lanePercent)
				.append("\n")
				.append("Win ratio - ")
				.append(winLosePercent)
				.append("\n")
				.append("Average game time - ")
				.append(time)
				.append("\n")
				.append("Most often grade - ")
				.append(grade)
				.append("\n")
				.append("Most often grade % - ")
				.append(gradePercent)
				.append("\n")
				.append("Average afk's - ")
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
