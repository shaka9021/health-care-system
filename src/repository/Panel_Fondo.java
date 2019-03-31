
package repository;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class Panel_Fondo extends JDesktopPane{
 
       private  Image IMG=new ImageIcon(getClass().getResource("/image/historia-clinica.jpg")).getImage();
 
       @Override
        public void paintChildren(Graphics g){
            g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
            super.paintChildren(g);
        }
}
