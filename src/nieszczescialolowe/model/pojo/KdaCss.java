package nieszczescialolowe.model.pojo;

import nieszczescialolowe.view.Window;

public class KdaCss {

	private int kill;
	private int dead;
	private int assist;
	private int css;
	
	public KdaCss() {}
	
	public KdaCss(int kill, int dead, int assist, int css) {
		this.kill = kill;
		this.dead = dead;
		this.assist = assist;
		this.css = css;
	}
	
	public KdaCss(String line) {
		csvToGame(line);
	}
	
	@Override
	public String toString() {
		return kill + "/" + dead + "/" + assist + "/" + css;
	}
	
    /**
     * Sprawdza format kda
     * 
     * @param kda String
     * @return jesli jest k true
     */
    public static boolean chkKdaFormat(String kda, Window window) {
    	try {
	    	String[] split = kda.split("/");
	    	
	    	if (split.length == 4) {
	    		for (String str : split) {
	    			int value = Integer.parseInt(str);
					if (value < 0) {
						window.showError("Kda must be higher than 0");
						return false;
					}
				}
	    	} else {
	    		window.showError("Please use the following format for the kda textfield: x/x/x/x");
	    		return false;
	    	}
    	} catch (NumberFormatException nfe) {
    		window.showError("Unvalid numbers in the kda textfield");
    		return false;
    	}
    	
    	return true;
    } 
	
	public void csvToGame(String line) {
		String split[] = line.split("/");
		
		kill = Integer.parseInt(split[0]);
		dead = Integer.parseInt(split[1]);
		assist = Integer.parseInt(split[2]);
		css = Integer.parseInt(split[3]);
		
	}
	
	public int getKill() {
		return kill;
	}
	
	public void setKill(int kill) {
		this.kill = kill;
	}
	
	public int getDead() {
		return dead;
	}
	
	public void setDead(int dead) {
		this.dead = dead;
	}
	
	public int getAssist() {
		return assist;
	}
	
	public void setAssist(int assist) {
		this.assist = assist;
	}
	
	public int getCSs() {
		return css;
	}
	
	public void setCss(int css) {
		this.css = css;
	}
}
