package nieszczescialolowe.model;

import javax.swing.JTextArea;

/**
 * @author Patryk
 *
 * Statyczna klasa sluzaca do logowania wiadomosci w oknie
 */
public class Log {

	private static JTextArea txt;
	
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
	 * @param msg String
	 * @param space boolean, oznacza czy po line breaku maja byc spacje
	 */
	public static void log(String msg, boolean space) {
		final int chars = 70;
		String text = txt.getText();
		String line = space ? "\n     " : "\n";
		String full = msg;
		msg = "";
		
		// jesli wiadomosc jest za dluga rozdzielam ja
		while (full.length() > chars) {
			String tmp = full.substring(0,chars);
			
			if (tmp.contains("\n")) {
				int lineB = tmp.indexOf("\n");
				tmp = tmp.substring(0, lineB);
				full = full.substring(lineB + 1);
			} else {
				full = full.substring(chars);
			}
			
			msg += addBreakContent(msg, tmp, line);
		}
		msg += full;
		
		
		// jesli log nie jest pusty dodaje enter
		if (text.equals("")) {
			txt.setText(msg);
		} else {
			txt.setText(text + "\n" + msg);
		}
	}
	
	private static String addBreakContent(String msg, String tmp, String lineB) {
		if (msg.equals("")) {
			return tmp; 	
		} else {
			return lineB + tmp;
		}
	}
	
	public static void clearLog() {
		txt.setText("");
	}
}
