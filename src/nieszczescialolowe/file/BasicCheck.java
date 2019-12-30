package nieszczescialolowe.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Clasa sprawdzajaca czy to co jest pisane w FILE ma odpowiedni format
 * 
 * @author HolyCatPL
 */
public class BasicCheck {

	public static final String HEADER = "Champion,lane,kda,win/lose,game length,afks";
	
	public static void basicCheck(String line) throws Exception {
		BufferedReader read = new BufferedReader(new FileReader(Writing.FILE));
		
		String first = read.readLine();
		read.close();
		
		if (first == null) {
			BufferedWriter write = new BufferedWriter(new FileWriter(Writing.FILE));
			write.write(HEADER + '\n');
			write.close();
		}
		else {
			
		}
	}
}
