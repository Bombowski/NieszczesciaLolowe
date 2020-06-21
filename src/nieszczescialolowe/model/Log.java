package nieszczescialolowe.model;

import javax.swing.JTextArea;

/**
 * @author Patryk
 *
 * Statyczna klasa sluzaca do logowania wiadomosci w oknie
 */
public class Log {

	private static JTextArea txt;
	// 0 = default, 1 = tests 
	private static int mode = 0;
	private static String testResult;
	
	/**
	 * Changes the mode at which the class is running.
	 * 0 = default, 1 = tests
	 * 
	 * @param mode int
	 */
	public static void setMode(int mode) {
		Log.mode = mode < 0 || mode > 1 ? 0 : mode;
	}
	
	public static String getLog() {
		return Log.testResult;
	}
	
	/**
	 * Inicializacja JTextArea
	 * 
	 * @param txtArea JTextArea
	 */
	public static void setTxt(JTextArea txtArea) {
		txt = txtArea;
	}
	
	/**
	 * Pokazuje wiadomosc w oknie loga, co int chars znakow robi line break
	 * 
	 * @param msg String
	 */
	public static void log(String msg) {
		log(msg, true);
	}
	
	/**
	 * Pokazuje wiadomosc w oknie loga, co int chars znakow robi line break
	 * 
	 * @param toReturn String
	 * @param space boolean, oznacza czy po line breaku maja byc spacje
	 */
	public static void log(String full, boolean space) {
		final int chars = 60;
		String text = Log.mode == 0 ? txt.getText() : "";
		String line = space ? "\n     " : "\n";
		String toReturn = "";
		
		// jesli wiadomosc jest za dluga rozdzielam ja
		while (full.length() > 0) {
			int total = full.length() < chars ? full.length() : chars;
			String tmp = full.substring(0,total);
			
			if (tmp.contains("\n")) {
				int lineB = tmp.indexOf("\n");
				tmp = tmp.substring(0, lineB);
				full = full.substring(lineB + 1);
			} else {
				full = full.substring(total);
			}
			
			toReturn += addBreakContent(toReturn, tmp, line);
		}
		toReturn += full;
		
		// jesli jestem teraz w modzie test, zapisuje rezultat do logowania
		if (Log.mode == 1) {
			testResult = toReturn;
			return;
		}
		// jesli log nie jest pusty dodaje enter
		if (text.equals("")) {
			txt.setText(toReturn);
		} else {
			txt.setText(text + "\n\n" + toReturn);
		}
	}
	
	private static String addBreakContent(String msg, String tmp, String lineB) {
		if (msg.equals("")) {
			return tmp; 	
		} else {
			return lineB + tmp;
		}
	}
	
	/**
	 * Clear the console, if the mode is set to tests, the test variable gets cleared
	 */
	public static void clearLog() {
		if (mode == 1) {
			testResult = "";
			return;
		}
		
		txt.setText("");		
	}
}
