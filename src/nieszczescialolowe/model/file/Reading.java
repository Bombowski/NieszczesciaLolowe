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
			Log.logError(e.getStackTrace(), e.getLocalizedMessage());
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
			Log.logError(e.getStackTrace(), e.getLocalizedMessage());
		} finally {
			reader.close();
		}
		
		return list;
	}
	
	/**
	 * Oddaje wszystkie gry w pliku
	 * 
	 * @return ArrayList<Game>
	 * @throws IOException
	 */
	protected ArrayList<Game> getAllGames() throws IOException {
		return getLastGames(-1, getExistingFileLines());
	}
	
	/**
	 * Oddaje liste X ostatnich gier (komentarze w funkcji zsuplajowane przez bumboxa)
	 * 
	 * @return ArrayList<Game>
	 * @throws IOException 
	 */
	protected ArrayList<Game> getLastGames(int x, ArrayList<String> file) throws IOException {
		ArrayList<Game> list = new ArrayList<Game>();
		
		try {
			int i = 0;
			String line = file.get(i);
			
			// czyta az znajdzie header gier
			while (!line.equals(BasicCheck.HEADERstats)) {
				i++;
				line = file.get(i);
			}
			// dodaje 1 zeby nastepnie czytac liste gier
			i++;
			
			// najnowsze gry sa na koncu, wiec ustawia i na pozycji x od konca
			if (x > -1 && i <= file.size() - x) {
				i = file.size() - x;
			}
			
			// czyta i zapisuje gry w liscie
			while (i < file.size()) {
				line = file.get(i);
				Game newGame = new Game();
				newGame.csvToGame(line);
				list.add(newGame);
				i++;
			}
		} catch (Exception e) {
			Log.logError(e.getStackTrace(), e.getLocalizedMessage());
		}		
		
		return list;
	}
}
