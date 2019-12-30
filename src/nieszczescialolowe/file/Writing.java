package nieszczescialolowe.file;

import java.io.File;

/**
 * Clasa odpowiedzialna za zapisywanie statystyk X gier
 * 
 * @author HolyCatPL
 */
public class Writing {
	
	public static File FILE;
	
	/**
	 * Metoda wzywana do zapisania nowej gry
	 * Wzywa basicCheck a potem metoda add do zapisania
	 * 
	 * @param line
	 */
	public static void write(String line) {
		try {
			BasicCheck.basicCheck(line);
			add(line);
		}
		catch(Exception e) {
			
		}
	}
	
	/**
	 * Metoda do dodawania statystyk nowej gry i usuwania starych
	 * tak zeby maksymalnie bylo zapisanych X gier
	 * 
	 * @param line
	 * @throws Exception
	 */
	private static void add(String line) throws Exception {
		
	}
}
