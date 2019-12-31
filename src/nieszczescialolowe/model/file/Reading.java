package nieszczescialolowe.model.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import nieszczescialolowe.model.Log;

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
	protected ArrayList<String> getExistingFileLines() throws IOException {
		BufferedReader reader = null;
		ArrayList<String> file = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(Writing.FILE));
			String line = reader.readLine();
			
			while (line != null) {
				file.add(line);
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			Log.log(e.getMessage());
		} finally {
			reader.close();
		}
		
		return file;
	}
	
	/**
	 * Oddaje liste championow
	 * 
	 * @return
	 * @throws IOException 
	 */
	protected ArrayList<String> getChampionList() throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(Writing.FILE));
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != BasicCheck.HEADERgames) {
				if (line != "") list.add(line);
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			Log.log(e.getMessage());
		} finally {
			reader.close();
		}
		
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
