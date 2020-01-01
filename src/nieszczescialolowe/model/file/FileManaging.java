package nieszczescialolowe.model.file;

import java.io.IOException;
import java.util.ArrayList;

import nieszczescialolowe.model.pojo.Game;

/**
 * @author Patryk
 *
 * Klasa za pomoca ktorej main moze komunikowac sie z Reading, Writing i BasicCheck
 */
public class FileManaging {

	private Writing out;
	private Reading in;
	
	public FileManaging(String path) {
		out = new Writing(path);
		in = new Reading(path);
	}
	
	/**
	 * Dodaje podana gre do pliku csv
	 * 
	 * @param game Game
	 * @throws IOException
	 */
	public void addGame(Game game) throws IOException {
		ArrayList<String> lines = in.getExistingFileLines(); 
		
		if (BasicCheck.basicCheck(lines)) {
			out.addGame(game);
		} else {
			out.createDocFormat();
			out.addGame(game);
		}
	}
	
	/**
	 * Dodaje championa do pliku csv
	 * 
	 * @param champ String
	 * @throws IOException
	 */
	public void addChampion(String champ) throws IOException {
		ArrayList<String> lines = in.getExistingFileLines(); 
		
		if (BasicCheck.basicCheck(lines)) {
			out.addChamp(champ);
		} else {
			out.createDocFormat();
			out.addChamp(champ);
		}
	}
	
	/**
	 * Zdobywa ostatnie x gier
	 * 
	 * @param x int
	 * @return ArrayList<Game>
	 * @throws IOException
	 */
	public ArrayList<Game> getTopXGames(int x) throws IOException {
		ArrayList<String> lines = in.getExistingFileLines(); 
		
		if (BasicCheck.basicCheck(lines)) {
			return in.getLastGames(x);
		} else {
			out.createDocFormat();
			return new ArrayList<Game>();
		}
	}
	
	/**
	 * Usuwa championa z podana nazwa
	 * 
	 * @param champ String
	 * @throws IOException 
	 */
	public void deleteChampion(String champ) throws IOException {
		ArrayList<String> lines = in.getExistingFileLines();
		
		if (BasicCheck.basicCheck(lines)) {
			out.deleteChampion(champ);
		} else {
			out.createDocFormat();
		}
	}
	
	/**
	 * Usuwa najnowsza gre
	 * 
	 * @throws IOException 
	 */
	public void deleteLastGame() throws IOException {
		ArrayList<String> lines = in.getExistingFileLines();
		
		if (BasicCheck.basicCheck(lines)) {
			out.deleteLastGame();
		} else {
			out.createDocFormat();
		}
	}
	
	/**
	 * Zdobywa liste championow
	 * 
	 * @return ArrayList<String>
	 * @throws IOException
	 */
	public ArrayList<String> getChampionList() throws IOException {
		ArrayList<String> lines = in.getExistingFileLines();
		
		if (BasicCheck.basicCheck(lines)) {
			return in.getChampionList();
		} else {
			out.createDocFormat();
			return new ArrayList<String>();
		}
	}
}
