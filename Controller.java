/*  Author: Carter Buckner
    project: Assignment5 - Controller Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/



import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.util.*;

class Controller implements KeyListener, MouseListener
{
    Model model;
    View view;
    RobberAuto robber;



    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);

    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
  		if (SwingUtilities.isLeftMouseButton(e)) {
  			// Gets here is left mouse button was clicked
        model.setLocation(e.getX(), e.getY());
  		} else if (SwingUtilities.isRightMouseButton(e))  {
  			// Gets here if right mouse button was clicked
        model.updateScene(view.getWidth(), view.getHeight());
  		}
      view.repaint();
    }

    public void mouseReleased(MouseEvent e) {   }
    public void mouseEntered(MouseEvent e) {   }
    public void mouseExited(MouseEvent e) {   }
    public void mouseClicked(MouseEvent e) {   }


      public void keyPressed(KeyEvent e){
        // System.out.println("key pressed");
      }

      public void keyReleased(KeyEvent e){
        // System.out.println("key pressed");
      }

      public void keyTyped(KeyEvent e){
        // if(e.getKeyChar() == 'h'){
        //   System.out.println("hello world");
        // }
        if(e.getKeyChar() == 'n'){
          System.out.println("robbers captured = " + RobberAuto.robberCaughtCount);
          System.out.println("robbers escaped = " + RobberAuto.robberEscapeCount);
        }
        if(e.getKeyChar() == 'r'){
          model.initialize();
          view.repaint();
        }
        if(e.getKeyChar() == 's'){
          SpriteMover mover = new SpriteMover(model, view);
          Thread thread = new Thread(mover);
          thread.start();
        }
      }


    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));


        new Controller();
    }
}
