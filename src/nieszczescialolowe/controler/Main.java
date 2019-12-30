
package nieszczescialolowe.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import nieszczescialolowe.view.Window;

/**
 *
 * @author Patryk
 */
public class Main implements ActionListener {
                
    private Window window;
    
    public static void main(String args[]) {
        new Main();
    }                
    
    public Main() {
        window = new Window();
        window.addBtnActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());
    }
    
}
