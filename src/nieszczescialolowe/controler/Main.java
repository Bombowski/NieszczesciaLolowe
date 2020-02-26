
package nieszczescialolowe.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.file.FileManaging;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.view.Window;

/**
 * Controller zadzi i decyduje co z czym i kiedy robic
 *
 * @author Patryk
 */
public class Main implements ActionListener {
    
	// okno
    private Window window;
    private FileManaging fm;
    
    public static void main(String args[]) {
        new Main();
    }                
    
    private Main() {
		window = new Window();
		
        fm = new FileManaging(window.getCsvPathStartWindow());
    	
		try {
			ArrayList<String> champs = fm.getChampionList();
	        window.setCmbChamps(champs);
		} catch (IOException e) {
			Log.log(e.getMessage());
		}
    	
        // dodaje action listenery
        window.addBtnActionListener(this);
        
        new CommandPrompt(window, fm);
        
        // podaje klasie log panel w ktorym bedzie logowala
        Log.setTxt(window.getLogPanel());
        Log.log("Type 'help' to show a list of commands.");
    }

    /**
     * Action listener trigerowany przez oba guziki z JFrame'a
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        
        try {
	        switch (btn.getText()) {
	        	case "Add game":
	        		addGame();
	            	break;
		        case "Delete last game":
		        	delLastGame();
		        	Log.log("The last game was deleted");
		        	break;
		        	
		        case "Add champion":
		        	addChamp();
		        	break;
		        	
		        case "Delete champion":
		        	delChamp();
	        }
        } catch (IOException ie) {
        	Log.log(ie.getMessage());
        }
    }
    
    private void addGame() throws IOException {
    	Game game = window.getGame();
    	
    	if (game.getChampion() == null) {
    		window.showError("First you need to add a champion");
    		return;
    	} else if (!Pattern.matches("^(\\d{1,2}\\/\\d{1,2}\\/\\d{1,2}\\/\\d{1,3})$", game.getKdaCss().toString())) {
    		window.showError("Use the following format for the kda css textfield: x/x/x/x");
    		return;
    	} else if (!Pattern.matches("^((S|A|B|C|D)(\\+|-)?)$", game.getGrade())) {
    		window.showError("Unvalid grade, valid grades are: +/- S-A-B-C-D");
    		return;
    	} else if (!Pattern.matches("^(\\d{1,2}:\\d{1,2}:\\d{1,2})$", game.getTime())) {
    		window.showError("Use the following format for the time textfield: x:x:x");
    		return;
    	} else if (game.getKdaCss() == null) {
    		return;
    	}
    	
		Log.log("Adding: " + game);
		fm.addGame(game);	    	
    }
    
    private void delLastGame() throws IOException {
    	fm.deleteLastGame();
    }
    
    private void addChamp() throws IOException {
    	// pytam jaka nazwe ma champ
    	String name = window.showWindowGetChampName();
    	
    	// sprawdzam czy jest valid
    	if (name == null || name.equals("")) {
    		window.showError("Invalid champion name");
    		return;
    	}
    	
    	if (fm.addChampion(name)) {
        	window.addChamp(name);
    	}
    }
    
    private void delChamp() throws IOException {
    	Game game2 = window.getGame();
    	
    	if (game2.getChampion() == null) {
    		window.showError("First you need to add a champion");
    		return;
    	}
    	
    	window.removeSelectedChamp();
    	
    	fm.deleteChampion(game2.getChampion());
    }
}
