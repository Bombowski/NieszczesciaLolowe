package nieszczescialolowe.model.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.pojo.Game;

/**
 * Clasa czytajaca plik csv
 * 
 * @author HolyCatPL
 *
 */
public class Reading {

	private File path;
	
	protected Reading(String path) {
		this.path = new File(path);
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
			reader = new BufferedReader(new FileReader(this.path));
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
			reader = new BufferedReader(new FileReader(this.path));
			String line = reader.readLine();
			line = reader.readLine();
			
			while (!line.equals(BasicCheck.HEADERgames)) {
				if (!line.equals("")) list.add(line);
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
	 * @throws IOException 
	 */
	protected ArrayList<Game> getLastGames(int x) throws IOException {
		ArrayList<Game> list = new ArrayList<Game>();
		ArrayList<String> file = null;
		
		try {
			file = getExistingFileLines();
			String line = null;
			int i = 0;
			while (!line.equals(BasicCheck.HEADERstats)) {
				line = file.get(i);
				i++;
			}
			
			if (i <= file.size() - x) i = file.size() - x;
			
			while (i < file.size()) {
				line = file.get(i);
				Game newGame = new Game();
				newGame.csvToGame(line);
				list.add(newGame);
				i++;
			}
			
		} catch(IOException e) {
			Log.log(e.getMessage());
		}
		
		
//		return list;
		return new ArrayList<Game>();
	}
}
