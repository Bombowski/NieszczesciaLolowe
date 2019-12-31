package nieszczescialolowe.model.file;

import java.util.ArrayList;

import nieszczescialolowe.model.pojo.Game;

public class FileManaging {

	private Writing in;
	private Reading out;
	
	public FileManaging(String path) {
		in = new Writing(path);
		out = new Reading(path);
	}
	
	public void addGame(Game game) {
		
	}
	
	public void addChampion(String champ) {
		
	}
	
	public ArrayList<String> getExistingFileLines() {
		
		return null;
	}
	
	public ArrayList<Game> getTopXGames(int x) {
		
		
		return null;
	}
}
