package nieszczescialolowe.model.pojo;

/**
 * @author Patryk
 *
 * Klasa z danymi gry
 */
public class Game {

	private KdaCss kdaCss;
	private String champion;
	private String lane;
	private String time;
	private String winLose;
	private String grade;
	private int afks;
	
	public Game(String kdaCss, String champion, String lane, String time, String winLose, String grade, int afks) {
		this.kdaCss = new KdaCss(kdaCss);
		this.champion = champion;
		this.lane = lane;
		this.time = time;
		this.winLose = winLose;
		this.afks = afks;
		this.grade = grade;
	}
	
	public Game() {}

	@Override
	public String toString() {
		return "[kda/css: " + kdaCss + " ; champion: " + champion + " ; lane: " + lane + 
				" ; time: " + time + " ; win/lose: " + winLose + " ; afks: " + afks + " ; grade: " + grade + "]";
	}
	
	/**
	 * Zamienia parametry objectu Game a String z formatem z jakim dane beda zapisywane w pliku csv
	 * 
	 * @return String
	 */
	public String stringToCsv() {
		return champion + "," + lane + "," + kdaCss + "," + winLose + "," + time + "," + afks + "," + grade;
	}
	
	/**
	 * Zamienia linie z pliku csv w parametry objectu Game i odrazu je setuje.
	 * 
	 * @param line String
	 */
	public void csvToGame(String line) {
		String split[] = line.split(",");

		this.champion = split[1];
		this.lane = split[2];
		this.kdaCss = new KdaCss(split[3]);
		this.winLose = split[4];
		this.time = split[5];
		this.afks = Integer.parseInt(split[6]);
		this.grade = split[7];
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

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWinLose() {
		return winLose;
	}

	public void setWinLose(String winLose) {
		this.winLose = winLose;
	}

	public int getAfks() {
		return afks;
	}

	public void setAfks(int afks) {
		this.afks = afks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
