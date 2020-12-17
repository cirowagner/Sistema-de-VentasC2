package upeu.gui.admin;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentasPanel extends JPanel implements ActionListener {

    public VentasPanel(){
        setVisible(true);
        setBounds(7,15,972, 465);
        setBorder(new TitledBorder(""));
        setLayout(null);
    }

    public void initComponents(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

