package upeu.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainR extends JFrame{

    panelImage panel = new panelImage();

    public MainR(){

        this.setTitle("Ventana con Imagen");
        this.setSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.add(panel, BorderLayout.CENTER);
    }

    public static void main(String [] args){
        MainR frame = new MainR();
        frame.setVisible(true);
    }
}
class panelImage extends JPanel{

    @Override
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon("imagenes/roboto.png");
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }
}