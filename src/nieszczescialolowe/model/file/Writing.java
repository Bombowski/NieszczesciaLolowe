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
	
	protected static File FILE;
	
	/**
	 * Wyznacza rute do FILE
	 */
	protected Writing() {
		
	}
	
	/**
	 * Metoda wzywana do zapisania nowej gry
	 * Wzywa basicCheck a potem metoda add do zapisania
	 * 
	 * @param line
	 */
	protected static void write(Game stats) {
		
	}
	
	/**
	 * Metoda do dodawania statystyk nowej gry i usuwania starych
	 * tak zeby maksymalnie bylo zapisanych X gier
	 * 
	 * @param line
	 * @throws Exception
	 */
	private static void addGame(Game stats) {
		
	}
}
