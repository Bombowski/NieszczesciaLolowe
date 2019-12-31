
package nieszczescialolowe.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import nieszczescialolowe.model.Log;
import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.view.Window;

/**
 * Controller zadzi
 *
 * @author Patryk
 */
public class Main implements ActionListener {
    
	// okno
    private Window window;
    // w tym 
    private String path;
    
    public static void main(String args[]) {
        new Main();
    }                
    
    private Main() {
    	/*
    	 * ArrayList<String> champs = 
    	 * TODO tutaj trzeba zawolac funkcje ktora zreturnuje
    	 * liste z championami
    	 */
    	
    	// TODO window = new Window(champs);
		window = new Window();
		
		/*
		 * TODO zamiast String bedzie inicializacja jakiesc klasy ktora bedzie czytac/ pisac/
		 * miec kontakt z klasa od czytana pisania (ostatnia opcja najlepsza)
		 */
        path = window.getCsvPathStartWindow();
        
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
    	// zdobywal nacisniety guzik z eventu
        JButton btn = (JButton) e.getSource();
        
        // sprawdzam ktory byl nacisniety
        if (btn.getText().equals("Add game")) {
        	// zdobywam wszystkie informacje gry
        	Game game = window.getGame();
        	
        	// sprawdzam czy kda ma poprawny format
        	if (chkKdaFormat(game.getKda())) {
        		
        		// loguje gre ktora chcem dodac
        		Log.log("Adding: " + game);
        		
            	// TODO tutaj trzeba podac form funkcji ktora bedzie zapisywala gry
        	}
        } else {
        	// pytam jaka nazwe ma champ
        	String name = window.showWindowGetChampName();
        	
        	// sprawdzam czy jest valid
        	if (name == null || name.equals("")) {
        		window.showError("Invalid champion name");
        		return;
        	}
        	
        	/*
        	 *  TODO tutaj trzeba podac name funkcji ktora bedzie zapisywac nazwy champow
        	 * (i sprawdzac czy jeszcze nie istnieja)
        	 */
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
