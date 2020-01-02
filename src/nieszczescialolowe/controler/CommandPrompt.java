package nieszczescialolowe.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.Kda;
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
			pickFuncionFromCommand();
			txt.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	private void pickFuncionFromCommand() {
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
	
	private void listCommand(String command[]) {
		try {
			int noGames = Integer.parseInt(command[2]);
			
			ArrayList<Game> tmp = fm.getTopXGames(noGames);
			list = new ArrayList<Game>();
			
			for (int i = tmp.size() - 1; i >= noGames; i--) {
				list.add(tmp.get(i));
			}
		} catch (NumberFormatException | IOException nfe) {
			Log.log(nfe.getMessage());
		}
	}
	
	private void calculateAverege() {
		int afks = 0;
		int k = 0;
		int d = 0;
		int a = 0;
		int w = 0;
		int l = 0;
		int top = 0;
		int mid = 0;
		int jun = 0;
		int bot = 0;
		int sup = 0;
		
		for (Game game : list) {
			afks += game.getAfks();
			
			Kda kda = game.getKda();
			k += kda.getKill();
			d += kda.getDead();
			a += kda.getAssist();
			
			w += game.getWinLose().equals("w") ? 1 : 0;
			l += game.getWinLose().equals("l") ? 1 : 0;
			
			top += game.getWinLose().equals("top") ? 1 : 0;
			mid += game.getWinLose().equals("mid") ? 1 : 0;
			jun += game.getWinLose().equals("jun") ? 1 : 0;
			bot += game.getWinLose().equals("bot") ? 1 : 0;
			sup += game.getWinLose().equals("sup") ? 1 : 0;
		}
	}
	
	public ArrayList<Game> getList() {
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
