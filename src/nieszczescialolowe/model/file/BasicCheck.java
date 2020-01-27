package nieszczescialolowe.model.file;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clasa sprawdzajaca czy to co jest pisane w FILE ma odpowiedni format
 * 
 * @author HolyCatPL
 */
public class BasicCheck {

	protected static final String HEADERchamps = "<Champions>";
	protected static final String HEADERgames = "<Games>";
	protected static final String HEADERstats = "Date,Champion,Lane,KdaCss,Win/Lose,Time,Afks,Grade";
	
	/**
	 * Oddaje tylko true jesli ma odpowiedni format
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	protected static boolean basicCheck(ArrayList<String> file) throws IOException {
		
		if (file.size() <= 0) return false;
		if (!file.contains(HEADERchamps) || !file.contains(HEADERgames) || !file.contains(HEADERstats)) return false;
		
		String line = file.get(0);
		int i = 0;
		
		while (!line.equals(HEADERgames)) {
			i++;
			line = file.get(i);
		}
		
		if (!file.get(0).equals(HEADERchamps)) return false;
		if (!file.get(i-1).equals("") || !file.get(i-2).equals("")) return false;
		if (!file.get(i+1).equals(HEADERstats)) return false;
		
		return true;
	}
}
