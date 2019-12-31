package nieszczescialolowe.model.pojo;

/**
 * @author Patryk
 *
 * Klasa z danymi gry
 */
public class Game {

	private String kda;
	private String champion;
	private String lane;
	private String time;
	private String winLose;
	private int afks;
	
	public Game(String kda, String champion, String lane, String time, String winLose, int afks) {
		this.kda = kda;
		this.champion = champion;
		this.lane = lane;
		this.time = time;
		this.winLose = winLose;
		this.afks = afks;
	}
	
	public Game() {}

	@Override
	public String toString() {
		return "[kda: " + kda + " ; champion: " + champion + " ; lane: " + lane + 
				" ; time: " + time + " ; win/lose: " + winLose + " ; afks: " + afks + "]";
	}
	
	/**
	 * Zamienia parametry objectu Game a String z formatem z jakim dane beda zapisywane w pliku csv
	 * 
	 * @return String
	 */
	public String strinToCsv() {
		return champion + "," + lane + "," + kda + "," + winLose + "," + time + "," + afks;
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
		this.kda = split[3];
		this.winLose = split[4];
		this.time = split[5];
		this.afks = Integer.parseInt(split[6]);
	}
	
	public String getKda() {
		return kda;
	}

	public void setKda(String kda) {
		this.kda = kda;
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
}
