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
	 * Pokazuje wiadomosc w oknia loga
	 * 
	 * @param msg String
	 */
	public static void log(String msg) {
		String text = txt.getText();
		
		// jesli wiadomosc jest za dluga rozdzielam ja
		
		String full = msg;
		msg = "";
		
		while (full.length() > 50) {
			String tmp = full.substring(0,50);
			full = full.substring(50);
			
			if (msg.equals("")) {
				msg = tmp; 	
			} else {
				msg = msg + "\n     " + tmp;
			}
		}
		msg = msg + "\n     " + full;
		
		
		// jesli log nie jest pusty dodaje enter
		if (text.equals("")) {
			txt.setText(msg);
		} else {
			txt.setText(text + "\n" + msg);
		}
	}
	
	public static void clearLog() {
		txt.setText("");
	}
}
