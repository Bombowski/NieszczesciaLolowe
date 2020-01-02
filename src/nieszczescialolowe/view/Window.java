package nieszczescialolowe.view;

import java.awt.Dialog;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import nieszczescialolowe.model.pojo.Game;
import nieszczescialolowe.model.pojo.Kda;

/**
 * @author Patryk
 * 
 * Klasa ktora generuje i wyswietla okno
 */
public class Window extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JButton btnAddChamp;
    private JButton btnAddGame;
    private JButton btnDelChamp;
    private JButton btnDelGame;
    private JComboBox<String> cmbChamp;
    private JComboBox<String> cmbLane;
    private JScrollPane jScrollPane1;
    private JLabel lblAfks;
    private JLabel lblChamp;
    private JLabel lblKda;
    private JLabel lblLane;
    private JLabel lblTime;
    private JLabel lblWL;
    private JPanel panelConsole;
    private JPanel panelControl;
    private JSpinner spinAfks;
    private JSpinner spinHour;
    private JSpinner spinMin;
    private JSpinner spinSec;
    private JSpinner spinWL;
    private JTextField txtInput;
    private JTextField txtKda;
    private JTextArea txtOutput;
    
    public Window() {}
    
    public String getCsvPathStartWindow() {
    	String path = setCustomFileSave();
        initComponents();
        
        return path;
    }
    
    /**
     * Generacja okna
     */
    private void initComponents() {
        panelControl = new JPanel();
        lblKda = new JLabel();
        txtKda = new JTextField();
        lblChamp = new JLabel();
        cmbChamp = new JComboBox<>();
        lblLane = new JLabel();
        cmbLane = new JComboBox<>();
        lblTime = new JLabel();
        spinHour = new JSpinner();
        spinMin = new JSpinner();
        spinSec = new JSpinner();
        spinWL = new JSpinner();
        lblWL = new JLabel();
        lblAfks = new JLabel();
        spinAfks = new JSpinner();
        btnAddGame = new JButton();
        btnAddChamp = new JButton();
        btnDelChamp = new JButton();
        btnDelGame = new JButton();
        panelConsole = new JPanel();
        jScrollPane1 = new JScrollPane();
        txtOutput = new JTextArea();
        txtInput = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nieszczescia lolowe");
        setResizable(false);

        lblKda.setText("Kda");

        txtKda.setText("0/0/0");

        lblChamp.setText("Champion");

        lblLane.setText("Lane");

        cmbLane.setModel(new DefaultComboBoxModel<>(new String[] { "Top", "Mid", "Adc", "Sup", "Jun" }));

        lblTime.setText("Game length");

        spinHour.setModel(new SpinnerNumberModel(0, 0, 24, 1));

        spinMin.setModel(new SpinnerNumberModel(0, 0, 60, 1));

        spinSec.setModel(new SpinnerNumberModel(0, 0, 60, 1));

        spinWL.setModel(new SpinnerListModel(new String[] {"W", "L"}));

        lblWL.setText("Win/ Lose");

        lblAfks.setText("Afks");

        spinAfks.setModel(new SpinnerNumberModel(0, 0, 5, 1));

        btnAddGame.setText("Add game");

        btnAddChamp.setText("Add champion");

        btnDelChamp.setText("Delete champion");

        btnDelGame.setText("Delete last game");

        GroupLayout panelControlLayout = new GroupLayout(panelControl);
        panelControl.setLayout(panelControlLayout);
        panelControlLayout.setHorizontalGroup(
            panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelControlLayout.createSequentialGroup()
                                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKda)
                                    .addComponent(lblAfks))
                                .addGap(42, 42, 42))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelControlLayout.createSequentialGroup()
                                .addComponent(lblWL)
                                .addGap(18, 18, 18)))
                        .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtKda, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinAfks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinWL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelControlLayout.createSequentialGroup()
                                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTime)
                                    .addComponent(lblLane))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelControlLayout.createSequentialGroup()
                                        .addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbLane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbChamp, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblChamp)
                            .addGroup(panelControlLayout.createSequentialGroup()
                                .addComponent(btnAddChamp)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelChamp))))
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addComponent(btnAddGame)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelGame)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelControlLayout.setVerticalGroup(
            panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKda)
                    .addComponent(txtKda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTime))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(spinWL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbChamp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChamp)
                    .addComponent(lblWL))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAfks)
                    .addComponent(spinAfks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddChamp)
                    .addComponent(btnDelChamp))
                .addGap(9, 9, 9)
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLane))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddGame)
                    .addComponent(btnDelGame))
                .addGap(18, 18, Short.MAX_VALUE))
        );

        txtOutput.setEditable(false);
        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        GroupLayout panelConsoleLayout = new GroupLayout(panelConsole);
        panelConsole.setLayout(panelConsoleLayout);
        panelConsoleLayout.setHorizontalGroup(
            panelConsoleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelConsoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsoleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtInput))
                .addContainerGap())
        );
        panelConsoleLayout.setVerticalGroup(
            panelConsoleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelConsoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelControl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConsole, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelConsole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }

    /**
     * @return Returnuje Game ze wszystkimi danymi ktore byly wprowadzone w oknie
     */
    public Game getGame() {
    	Game game = new Game();
    	
    	if (Kda.chkKdaFormat(txtKda.getText(), this)) {
        	game.setKda(new Kda(txtKda.getText()));
    	}
    	
    	game.setChampion((String) cmbChamp.getSelectedItem());
    	game.setLane((String) cmbLane.getSelectedItem());
    	game.setTime(spinHour.getValue() + ":" + spinMin.getValue() + ":" + spinSec.getValue());
    	game.setWinLose((String) spinWL.getValue());
    	game.setAfks((int) spinAfks.getValue());
    	    	    	
		return game;
    }
    
    /**
     * twozy popujace okno, zeby muc przejsc do nastepnego okna trzeba wybrac plik csv
     * 
     * @param frame JFrame
     */
    private String setCustomFileSave() {
    	// tworze okno i pokazuje file chooser
        JDialog jd = new JDialog(this, "Csv file", Dialog.ModalityType.APPLICATION_MODAL);
        JFileChooser chooser = new JFileChooser();

        // zdobywam path do pliku i sprawdzam czy jest poprawny
        String path = askForCsvFile(jd, chooser);
        while (path.equals("")) {
        	// pokazuje error jesli nie jest poprawny
            JOptionPane.showMessageDialog(jd, "Select a csv file please.", "Error", JOptionPane.ERROR_MESSAGE);
            path = askForCsvFile(jd, chooser);
        }

        // zamykam okno
        jd.dispose();
        
        return path;
    }

    /**
     * Sprawdza czy wybrano plik z odpowiednim formatem, lub czy wybrano jaki kolwiek plik
     * 
     * @param jd JDialog popup okno
     * @param chooser JFileChooser
     * @return String
     */
    private String askForCsvFile(JDialog jd, JFileChooser chooser) {
    	// otwieram dialog i czekam na odpowiedz
        int returnVal = chooser.showOpenDialog(jd);

        // jesli okno zostalo zamkniete/ zcancelowane zakanczam pogram
        if (returnVal == JFileChooser.CANCEL_OPTION || chooser.getSelectedFile() == null) {
            System.exit(1);
        }
        
        // jesli nie sprawdzam format
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	// zdobywam nazwe
        	String name = chooser.getSelectedFile().getName();
        	
        	// sprawdzam nazwe
            if (name.substring(name.lastIndexOf(".")).equals(".csv")) {
                return chooser.getSelectedFile().getPath();
            } else {
                return "";
            }
        }
        return "";
    }
    
    /**
     * Pokazuje okno z opcja wpisania nazwy championa
     * 
     * @return Stromg
     */
    public String showWindowGetChampName() {
    	String name = JOptionPane.showInputDialog(this, "Chamption name");
    	
    	return name;
    }
    
    /**
     * Pokazuje okno z errorem
     * 
     * @param msg String
     */
    public void showError(String msg) {
    	JOptionPane.showMessageDialog(this, msg, "Error",JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Dodaje buttonom action listenera
     * 
     * @param al ActionListener
     */
    public void addBtnActionListener(ActionListener al) {
    	btnAddGame.addActionListener(al);
    	btnDelGame.addActionListener(al);
        btnAddChamp.addActionListener(al);
        btnDelChamp.addActionListener(al);
    }
    
    /**
     * Dodaje TextFieldowi action listenera
     * 
     * @param al ActionListener
     */
    public void addTxtActionListener(KeyListener al) {
    	txtInput.addKeyListener(al);
    }
    
    /**
     * Zdobywa panel na ktorym logowane sa wiadomosci z programu
     * 
     * @return JTextArea
     */
    public JTextArea getLogPanel() {
    	return txtOutput;
    }
    
    /**
     * Zdobywa panel w ktorym uzytkownik wpisuje komendy
     * 
     * @return
     */
    public JTextField getInputPanel() {
    	return txtInput;
    }
    
    /**
     * Dodaje liste championow do okna
     * 
     * @param champs ArrayList<String>
     */
    public void setCmbChamps(ArrayList<String> champs) {
    	cmbChamp.removeAll();
    	for (String champ : champs) {
			cmbChamp.addItem(champ);
		}
    }
    
    public void addChamp(String champ) {
    	cmbChamp.addItem(champ);
    }
    
    public void removeSelectedChamp() {
    	cmbChamp.removeItemAt(cmbChamp.getSelectedIndex());
    }
}
