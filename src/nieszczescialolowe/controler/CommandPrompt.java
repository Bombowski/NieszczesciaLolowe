package nieszczescialolowe.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import nieszczescialolowe.model.RegEx;
import nieszczescialolowe.model.RegExFunctions;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.view.Window;

public class CommandPrompt implements KeyListener {

	private JTextField txt;
	private ArrayList<Game> list;
	private Game average;
	private FileManaging fm;
	
	protected CommandPrompt(Window window, FileManaging fm) {
		this.txt = window.getInputPanel();
		this.fm = fm;
		
		RegExFunctions.fm = fm;
		
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
		Hashtable<Pattern, Consumer<Object>> commands = RegEx.commands;
		String command = txt.getText();
		
		for (Pattern reg : commands.keySet()) {
			if (Pattern.matches(reg.toString(), command)) {
				commands.get(reg).accept(command);
			}
		}
		
		
//		if (command.length == 3 && command[1].equals("last")) {
//			if (command[0].equals("list")) {
//				listCommand(command);
//			} else if (command[0].equals("average")) {
//				listCommand(command);
//				calculateAverege();
//			}
//		} else if (command[0].equals("clear")) {
//			
//		} else if (command[0].equals("today")) {
//			
//		}
	}
	
	private void calculateAverege() {
		
	}
	
	public ArrayList<Game> getGameList() {
		if (list == null) {
			return new ArrayList<Game>();
		}
		return list;
	}
	
	public Game getAverage() {
		if (average == null) {
			return new Game();
		}
		return average;
	}
}
