package upeu.myapp;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

import javax.swing.*;

/**
 * Example of Fonts.
 *
 * @author Chuidiang
 *
 */
public class Fuentes {

    public static void main(String[] args) throws InterruptedException {
        // List all available fonts.
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        System.out.println(Arrays.toString(fontNames));

        // A windows with a label.
        JFrame frame = new JFrame("Fonts Example");
        JTextArea label = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(label);
        frame.getContentPane().add(scrollPane);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        String f = "";
        for (String font : fontNames) {
            f += font+"\n";
            label.setText(f);
            label.setFont(new Font(font, Font.PLAIN, 15));
            Thread.sleep(100);
        }
    }

}