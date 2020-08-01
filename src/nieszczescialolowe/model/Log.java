package nieszczescialolowe.model;

import javax.swing.JTextArea;

import nieszczescialolowe.view.Window;

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
	private static final int maxLength = 396;
	
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
	 * Formatuje podanego stringa tak zeby sie miescil w szerokosci
	 * konsoli
	 * 
	 * @param full String
	 * @return String
	 */
	private static String formatText(String full) {
		String toReturn = "";
		String[] split = full.split(" ");
		String tmp = "";
				
		for (String str : split) {
			if (tmp.equals("")) {
				tmp = str;
			} else {
				String[] lineBreaks = str.split("\n");
				
				if (lineBreaks.length > 1) {
					int l = lineBreaks.length;
					for (int i = 0; i < l; i++) {
						if (i + 1 == l) {
							tmp += lineBreaks[i];
						} else {
							toReturn += new StringBuilder()
									.append(tmp)
									.append(" ")
									.append(lineBreaks[i])
									.append("\n");
							tmp = "";
						}						
					}
				} else {
					if (Window.testMetrics(tmp + str) >= maxLength) {
						toReturn += tmp + "\n";
						tmp = str;
					} else {
						tmp += " " + str;
					}
				}
			}
		}
		
		toReturn += !tmp.equals("") ? tmp : "";
		return toReturn;
	}
	
	/**
	 * Pokazuje wiadomosc w oknie loga, automatycznie rozdziela zbiory slow
	 * na kilka linii jesli jest to konieczne, jak narazie nie dziala z
	 * za duzymi na konsole slowami.
	 * 
	 * @param toReturn String
	 */
	public static void log(String full) {
		String toReturn = formatText(full);
		
		// jesli jestem teraz w modzie test, zapisuje rezultat do logowania
		if (Log.mode == 1) {
			testResult = toReturn;
			return;
		}
		
		add2Log(toReturn);
	}
	
	/**
	 * Pokazuje w konsoli zformatowany error
	 * 
	 * @param stackTrace StackTraceElement[]
	 * @param cause localized message errora
	 */
	public static void logError(StackTraceElement[] stackTrace, String cause) {
		StringBuilder sb = new StringBuilder();
		sb.append("There has been an unexpected error - ")
			.append(stackTrace[0].getClassName())
			.append(" ")
			.append(cause)
			.append("\n");
		
		for (StackTraceElement ste : stackTrace) {
			sb.append(ste.getFileName())
				.append(" - ")
				.append(ste.getMethodName())
				.append(" at line [")
				.append(ste.getLineNumber())
				.append("]\n");
		}
		add2Log(formatText(sb.toString()));
	}
	
	private static void add2Log(String message) {
		// jesli log nie jest pusty dodaje enter
		String currentTxt = Log.mode == 0 ? txt.getText() : " ";
		txt.setText(currentTxt.equals("") ? message : 
			new StringBuilder()
				.append(currentTxt)
				.append("\n\n")
				.append(message)
				.toString());
	}
	
	/**
	 * Czysci konsole, jesli Log jest w modzie testowym, zmienna testResult 
	 * zostaje wyczyszczona
	 */
	public static void clearLog() {
		if (mode == 1) {
			testResult = "";
			return;
		}
		
		txt.setText("");		
	}
}
