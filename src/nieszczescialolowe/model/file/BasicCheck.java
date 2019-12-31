package nieszczescialolowe.model.file;

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

	private static final String HEADER = "Champion,lane,kda,win/lose,time,afks";
	
	protected static void basicCheck() throws Exception {
		BufferedReader read = new BufferedReader(new FileReader(Writing.FILE));
		BufferedWriter write = new BufferedWriter(new FileWriter(Writing.FILE,true));
		
		String first = read.readLine();
		read.close();
		
		if (first == null) {
			BufferedWriter writes = new BufferedWriter(new FileWriter(Writing.FILE));
			writes.write(HEADER);
			writes.close();
		}
		
		write.write('\n' + " , , , , ,0");
		write.close();
		
	}
}
