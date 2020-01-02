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
	 * @throws IOException 
	 */
	protected void addGame(Game stats) throws IOException {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(this.file, true));
			writer.write(stats.stringToCsv());
			
		} catch(IOException e){
			Log.log(e.getMessage());
		} finally {
			if (writer != null) writer.close();
		}
	}
	
	protected void addChamp(ArrayList<String> file, String champ) throws IOException {
		int index = 0;
		String line = null;
		line = file.get(index);
		
		while (!line.equals(BasicCheck.HEADERgames)) {
			index++;
			line = file.get(index);
		}
		
		file.add(index - 2, champ);
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(this.file));
			for (int i = 0; i < file.size(); i++) {
				writer.write(file.get(i) + '\n');
			}
			
		} catch(IOException e) {
			Log.log(e.getMessage());
		} finally {
			if (writer != null) writer.close();
		}
	}
	
	protected void createDocFormat() throws IOException {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(this.file));
			writer.write(BasicCheck.HEADERchamps + '\n' + '\n' + '\n' + BasicCheck.HEADERgames + '\n' + BasicCheck.HEADERstats + '\n');
			
		} catch(IOException e) {
			Log.log(e.getMessage());
		} finally {
			if (writer != null) writer.close();
		}
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
			
			int i = 0;
			for (String line : file) {
				if (i == 0) {
					out.write(line);
				} else {
					out.write("\n" + line);
				}
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
				int i = 0;
				for (String line : file) {
					if (i == 0) {
						out.write(line);
					} else {
						out.write("\n" + line);
					}
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
