/*  Author: Carter Buckner
    project: Assignment5 - Model Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/

import java.awt.Graphics;
import java.io.IOException;
import java.util.*;


class Model
{
    // private Sprite sprite;
    private List<Sprite> sprites;
    private int currSprite;

    Model() throws IOException {
		// sprite = new Sprite("smiley.jpg");
    sprites = new ArrayList<Sprite>();
    sprites.add(new Bank());
    // sprites.add(new RobberAuto());
    currSprite = 0;
    }

    public void update(Graphics g) {
      for(int i = 0; i < sprites.size(); i++){
        sprites.get(i).updateImage(g);
      }
    }
    public void setLocation(int X, int Y){
      if(currSprite%2 == 0){
        sprites.add(new CopAuto());
        sprites.get(sprites.size()-1).setX(X);
        sprites.get(sprites.size()-1).setY(Y);
      }else{
        sprites.add(new RobberAuto());
        sprites.get(sprites.size()-1).setX(300);
        sprites.get(sprites.size()-1).setY(300);
      }

      currSprite++;
    }
    public void updateScene(int width, int height){
      boolean doesOverlap = false;
      synchronized(sprites){
        for(int i = 1; i < sprites.size(); i++){
          sprites.get(i).updateState(width, height);

          if(sprites.get(i) instanceof CopAuto){

            for(int a = 0; a < sprites.size(); a++){

              if(sprites.get(a) instanceof RobberAuto){
                doesOverlap = sprites.get(i).overlaps(sprites.get(a));
                if(doesOverlap){
                  ((RobberAuto)sprites.get(a)).captured();
                  // System.out.println("Gotcha!");
                }
              }
             }
           }
        }
        // check if Robber has escaped - remove if true
        /* note: used ArrayList remove method. Why was it recommended
        to use method from Collection/Iterator? (no luck)
        */
        for(int b = 0; b < sprites.size(); b++){
          if((sprites.get(b) instanceof RobberAuto) && (((RobberAuto)sprites.get(b)).hasEscaped())){
              System.out.println("I'm free!");
              sprites.remove(b);
          }
        }
    }
    }
    public void initialize(){
      RobberAuto robber = new RobberAuto();
      robber.robberCaughtCount = 0;
      robber.robberEscapeCount = 0;
      sprites = new ArrayList<Sprite>();
      sprites.add(new Bank());
    }

  }
