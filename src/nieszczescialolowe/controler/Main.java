
package nieszczescialolowe.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
        
        // podaje klasie log panel w ktorym bedzie logowala
        Log.setTxt(window.getLogPanel());
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
		        	Game game = window.getGame();
		        	
		        	// sprawdzam czy kda ma poprawny format
		        	if (chkKdaFormat(game.getKda())) {
		        		Log.log("Adding: " + game);
		        		fm.addGame(game);
		        	}
		        	break;
		        	
		        case "Delete last game":
		        	fm.deleteLastGame();
		        	break;
		        	
		        case "Add champion":
		        	// pytam jaka nazwe ma champ
		        	String name = window.showWindowGetChampName();
		        	
		        	// sprawdzam czy jest valid
		        	if (name == null || name.equals("")) {
		        		window.showError("Invalid champion name");
		        		return;
		        	}
		        	
		        	fm.addChampion(name);
		        	break;
		        	
		        case "Delete champion":
		        	Game game2 = window.getGame();
		        	
		        	if (game2.getChampion() == null) {
		        		window.showError("First you need to add a champion");
		        		return;
		        	}
		        	
		        	fm.deleteChampion(game2.getChampion());
	        }
        } catch (IOException ie) {
        	Log.log(ie.getMessage());
        }
    }
    
    /**
     * Sprawdza format kda
     * 
     * @param kda String
     * @return jesli jest k true
     */
    private boolean chkKdaFormat(String kda) {
    	try {
	    	String[] split = kda.split("/");
	    	
	    	if (split.length == 3) {
	    		for (String str : split) {
	    			int value = Integer.parseInt(str);
					if (value > 99 || value < 0) {
						window.showError("Kda has to be between 0 and 99");
						return false;
					}
				}
	    	} else {
	    		window.showError("Please use the following format for the kda textfield: x/x/x");
	    		return false;
	    	}
    	} catch (NumberFormatException nfe) {
    		window.showError("Unvalid numbers in the kda textfield");
    		return false;
    	}
    	
    	return true;
    } 
}
