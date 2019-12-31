package nieszczescialolowe.model.file;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clasa sprawdzajaca czy to co jest pisane w FILE ma odpowiedni format
 * 
 * @author HolyCatPL
 */
public class BasicCheck {

	private static final String HEADERchamps = "<Champions>";
	protected static final String HEADERgames = "<Games>";
	private static final String HEADERstats = "Champion,lane,kda,win/lose,time,afks";
	
	/**
	 * Oddaje tylko true jesli ma odpowiedni format
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	protected static boolean basicCheck(ArrayList<String> file) throws IOException {
		String line = null;
		
		if (file.size() <= 0) return false;
		if (!file.contains(HEADERchamps) || !file.contains(HEADERgames) || !file.contains(HEADERstats)) return false;
		
		int i = 0;
		while (line != HEADERgames) {
			i++;
			line = file.get(i);
		}
		
		if (file.get(0) != HEADERchamps) return false;
		if (file.get(i-1) != "" || file.get(i-2) != "") return false;
		if (file.get(i+1) != HEADERstats) return false;
		
		return true;
	}
}
