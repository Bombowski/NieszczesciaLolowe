package nieszczescialolowe.model.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.pojo.Game;

/**
 * Clasa odpowiedzialna za zapisywanie statystyk X gier
 * 
 * @author HolyCatPL
 */
public class Writing {
	
	private File file;
	
	/**
	 * Wyznacza rute do FILE
	 */
	protected Writing(String path) {
		file = new File(path);
	}
	
	/**
	 * 
	 * 
	 * @param stats
	 */
	protected void addGame(Game stats) {
		
	}
	
	protected void addChamp(ArrayList<String> file, String champ) {
		
	}
	
	protected void createDocFormat() {
		
	}
	
	protected void deleteLastGame(ArrayList<String> file) throws IOException {
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter(this.file));
			
			if (!file.get(file.size() - 1).equals(BasicCheck.HEADERstats)) {
				file.remove(file.size() - 1);
			} else {
				return;
			}
			
			for (String line : file) {
				out.write(line);
			}
		} catch (IOException e) {
			Log.log(e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	protected void deleteChampion(ArrayList<String> file, String name) throws IOException {
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter(this.file));
			
			if (file.remove(name)) {
				for (String line : file) {
					out.write(line);
				}
			}
			
			out.close();
		} catch (IOException e) {
			Log.log(e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
