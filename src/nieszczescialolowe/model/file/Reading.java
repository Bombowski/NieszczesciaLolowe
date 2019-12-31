package nieszczescialolowe.model.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clasa czytajaca plik csv
 * 
 * @author HolyCatPL
 *
 */
public class Reading {

	protected Reading() {
		
	}
	
	/**
	 * Oddaje cala zawartosc pliku csv
	 * 
	 * @return
	 * @throws Exception
	 */
	protected ArrayList<String> getExistingFileLines() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(Writing.FILE));
		ArrayList<String> file = new ArrayList<String>();
		String line = reader.readLine();
		
		while (line != null) {
			file.add(line);
			line = reader.readLine();
		}
		reader.close();
		return file;
	}
	
	/**
	 * Oddaje liste championow
	 * 
	 * @return
	 */
	protected ArrayList<String> getChampionList() {
		ArrayList<String> list = new ArrayList<String>();
		
		
		
		return list;
	}
	
	/**
	 * Oddaje liste X ostatnich gier
	 * 
	 * @return
	 */
	protected ArrayList<String> getLastGames(){
		ArrayList<String> list = new ArrayList<String>();
		
		
		
		return list;
	}
}
