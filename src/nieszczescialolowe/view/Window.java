/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nieszczescialolowe.view;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

/**
 *
 * @author Patryk
 */
public class Window extends JFrame {
    
    private JButton btnAddChamp;
    private JButton btnAddGame;
    private JComboBox<String> cmbChamp;
    private JComboBox<String> cmbLine;
    private JScrollPane jScrollPane1;
    private JLabel lblAfks;
    private JLabel lblChamp;
    private JLabel lblKda;
    private JLabel lblLine;
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
    
    public Window() {
        initComponents();
    }
    
    private void initComponents() {

        panelControl = new JPanel();
        lblKda = new JLabel();
        txtKda = new JTextField();
        lblChamp = new JLabel();
        cmbChamp = new JComboBox<>();
        lblLine = new JLabel();
        cmbLine = new JComboBox<>();
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

        lblLine.setText("Line");

        cmbLine.setModel(new DefaultComboBoxModel<>(new String[] { "Top", "Mid", "Adc", "Sup", "Jun" }));

        lblTime.setText("Game length");

        spinHour.setModel(new SpinnerNumberModel(0, 0, 24, 1));

        spinMin.setModel(new SpinnerNumberModel(0, 0, 60, 1));

        spinSec.setModel(new SpinnerNumberModel(0, 0, 60, 1));

        spinWL.setModel(new SpinnerListModel(new String[] {"W", "L"}));

        lblWL.setText("Win/ Lose");

        lblAfks.setText("Afks");

        spinAfks.setModel(new SpinnerNumberModel(0, 0, 5, 1));

        btnAddGame.setText("Add game");

        btnAddChamp.setText("Add Champion");

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
                                    .addComponent(lblLine))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(panelControlLayout.createSequentialGroup()
                                        .addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbChamp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddChamp)))
                            .addComponent(lblChamp)))
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addComponent(btnAddGame)
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
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAfks)
                        .addComponent(spinAfks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddChamp))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLine))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnAddGame)
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

    public void addBtnActionListener(ActionListener al) {
    	btnAddGame.addActionListener(al);
        btnAddChamp.addActionListener(al);
    }
}
