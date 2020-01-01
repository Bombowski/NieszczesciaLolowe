package nieszczescialolowe.model.file;

import java.io.File;
import java.io.IOException;

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
	
	protected void addChamp(String champ) {
		
	}
	
	protected void createDocFormat() {
		
	}
	
	protected void deleteLastGame() {
		
	}
	
	protected void deleteChampion(String name) {
		
	}
}
