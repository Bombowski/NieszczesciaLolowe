package nieszczescialolowe.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.RegEx;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Command;
import nieszczescialolowe.model.regexp.Commands;
import nieszczescialolowe.view.Window;

/**
 * @author Patryk
 *
 * Kontroler zajmujacy sie ewentami z inputu textu z konsoli
 */
public class CommandPrompt implements KeyListener {

	private JTextField txt;
	private Calendar cal;
	
	protected CommandPrompt(Window window, FileManaging fm) {
		this.txt = window.getInputPanel();
		
		Commands.setFm(fm);
		
		window.addTxtActionListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			getFunctionFromCommand();			
			txt.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	private void getFunctionFromCommand() {
		String command = txt.getText();
		
		if (command.equals("")) {
			return;
		}
		
		Log.log(new StringBuilder()
				.append(">")
				.append(getCurrentTime())
				.append("- ")
				.append(command)
				.toString());
		
		for (Entry<Command, Function<Object, String>> entry : RegEx.COMMANDS.entrySet()) {
			if (Pattern.matches(entry.getKey().getPattern().toString(), command)) {
				String result = entry.getValue().apply(command);
				
				if (result.equals("cl")) {
					Log.clearLog();
				} else {
					Log.log(result);
				}
				return;
			}
		}
		
		Log.log("Command not found");
	}
	
	private String getCurrentTime() {
		cal = Calendar.getInstance();
		int s = cal.get(Calendar.SECOND);
		int m = cal.get(Calendar.MINUTE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		
		return new StringBuilder()
				.append(h < 10 ? "0" + h : h)
				.append(":")
				.append(m < 10 ? "0" + m : m)
				.append(":")
				.append(s < 10 ? "0" + s : s)
				.toString();
	}
}
