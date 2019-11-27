/*  Author: Carter Buckner
    project: Assignment5 - RobberAuto Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/

import java.awt.Graphics;
import java.util.*;

class RobberAuto extends Auto{
  private int xRatio;
  private int yRatio;
  private Sprite sprite;
  private boolean isCaptured;
  public static int robberCaughtCount;
  public static int robberEscapeCount;
  private boolean isEscaped;


  public RobberAuto(){
    super("RobberAuto", 5000, (new Engine("V6", 20, 200)), "red-auto.jpg");
    super.fillUp();
    // System.out.println(getDescription());
    Random random = new Random();
    xRatio = random.nextInt(11)-5;
    yRatio = random.nextInt(11)-5;
    isCaptured = false;
    isEscaped = false;
  }
  public void updateImage(Graphics g){
    super.updateImage(g);
  }
  public void updateState(int width, int height){
    // System.out.println("X: " + getX() + " " + width);
    // System.out.println("Y: " + getY() + " " + height);
    super.drive(4, xRatio, yRatio);
    if(!isEscaped){
      if((getX() < 0) || (getX() > width)){
        // System.out.println("escaped");
        isEscaped = true;
        robberEscapeCount++;
      }
      if((getY() < 0) || (getY() > height)){
        // System.out.println("escaped");
        isEscaped = true;
        robberEscapeCount++;
      }
      // System.out.println(robberEscapeCount);
    }
  }
  public void captured(){
    // System.out.println("in true if");
    if(!isCaptured){
      super.setImage("jail.jpg");
      xRatio = 0;
      yRatio = 0;
      isCaptured = true;
      robberCaughtCount++;
      // System.out.println(robberCaughtCount);
    }
  }
  public boolean isCaptured(){
    return isCaptured;
  }
  public boolean hasEscaped(){
    return isEscaped;
  }
}
