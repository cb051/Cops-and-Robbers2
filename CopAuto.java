/*  Author: Carter Buckner
    project: Assignment5 - CopAuto Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/

import java.awt.Graphics;
import java.util.*;


class CopAuto extends Auto{
  private static int xRatio;
  private static int yRatio;
  private int x;
  private int y;
  private Sprite sprite;

  public CopAuto(){
    super("CopAuto", 5000, (new Engine("V6", 30, 100)), "cop-auto.jpg");
    super.fillUp();
    // System.out.println(getDescription());
    Random random = new Random();
    xRatio = random.nextInt(11)-5;
    yRatio = random.nextInt(11)-5;
    x = 1;
    y = 1;
    // System.out.println("new (x,y) " + xRatio + " " + yRatio);
    // if(sprite.getY() == getWidth()){yRatio = -(yRatio);}
  }
  public void updateImage(Graphics g){
    super.updateImage(g);
  }
  public void updateState(int width, int height){
    /*
      notes: x and y change together
      signs change only when CopAuto goes out of frame
    */

    // System.out.println("X: " + getX() + " " + width);
    // System.out.println("Y: " + getY() + " " + height);
    // System.out.println("(x,y) " + x + " " + y + "\n");
    if((getX() < 0) || (getX() >= width)){
      // System.out.println("in x");
      x = -(x);
    }
    if((getY() < 0) || (getY() >= height)){
      // System.out.println("in y");
      y = -(y);
    }

    drive(2, xRatio*x, yRatio*y);

  }
}
