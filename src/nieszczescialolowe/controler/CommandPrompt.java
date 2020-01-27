package nieszczescialolowe.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

import nieszczescialolowe.model.Log;
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
		
		window.addTxtActionListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			getFuntcionFromCommand();
			txt.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	private void getFuntcionFromCommand() {
		String command[] = txt.getText().split(" ");
		
		if (command.length == 3 && command[1].equals("last")) {
			if (command[0].equals("list")) {
				listCommand(command);
			} else if (command[0].equals("average")) {
				listCommand(command);
				calculateAverege();
			}
		} else if (command[0].equals("clear")) {
			
		} else if (command[0].equals("today")) {
			
		}
	}
	
	/**
	 * TODO bedzie pokazywac liste comend
	 */
	private void help() {
		
	}
	
	private void listCommand(String command[]) {
		try {
			int noGames = Integer.parseInt(command[2]);
			
			ArrayList<Game> tmp = fm.getTopXGames(noGames);
			list = new ArrayList<Game>();
			
			for (int i = tmp.size() - noGames; i < tmp.size(); i++) {
				list.add(tmp.get(i));
			}
			
			for (Game game : tmp) {
				Log.log(game.toString());
			}
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
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
