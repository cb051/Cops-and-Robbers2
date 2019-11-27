/*  Author: Carter Buckner
    project: Assignment5 - Auto Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/
import java.awt.Graphics;


class Auto extends Sprite{
  //private ---------------------------------------
  private String autoName;
  private GasTank gasObject;
  private Engine engineObject;
  // public ----------------------------------------
  public Auto(String autoName, int maxFuel, Engine engine, String jpgName){
    super(jpgName);

    this.autoName = autoName;
    gasObject = new GasTank(maxFuel);
    // System.out.println("Auto constructor");
    if(engine == null){
      this.autoName = "Generic auto";
      this.engineObject = new Engine("Generic engine", 0, 0);
    }else {
      this.engineObject = engine;
    }


  }
  public String getDescription(){
    // print method
    // use &.2f to specify 2 decimal places

    String description = autoName + String.format(" (Engine: %s (MPG: %d, Max speed: %d)), fuel: %.2f/%d, location: (%d,%d)"
                          , engineObject.getEngineName(), engineObject.getMPG(), engineObject.getMaxSpeed()
                          , this.getLevel(), gasObject.getCapacity(), this.getX(), this.getY()) ;
    return description;
  }

  public double getLevel(){
    // shows current gas level
    //format two decimal places using %.2f
    double gasLevel = gasObject.getLevel();
    return gasLevel;
  }
  public int getMPG(){
    //return Engine getMPG method
    return engineObject.getMPG();
  }
  public void fillUp(){
    /*
    fillUp() should
    cause the gas tank to be filled to its maximum capacity
    */
    int maxGasLevel = gasObject.getCapacity();
    gasObject.setLevel(maxGasLevel);
  }
  public int getMaxSpeed(){
    // return engine max speed method
    return engineObject.getMaxSpeed();
  }
  public double drive(int distance, double xRatio, double yRatio){
    // disable negative sign and factor back in later
    boolean xIsNegative = false;
    boolean yIsNegative = false;
    boolean isGasEmpty = false;
    int milesDriven = 0;

      if(xRatio < 0){
        xRatio = -(xRatio);
        xIsNegative = true;
      }
      if(yRatio < 0){
        // System.out.println("Y is negative");
        yRatio = -(yRatio);
        yIsNegative = true;
      }

      // check gas level - shorten distance traveled based on gas level
      double gasAmt = (this.getMPG()*this.getLevel());
      if(gasAmt < distance){
        System.out.printf("Ran out of gas after driving %.2f  miles\n", (gasAmt));
        distance = (int) gasAmt;
      }

      // calculate coordinates
      // true if a^2 + b^2 = c^2 and Law of Similar Triangles (xRatio/yRatio)=(xDistance/yDistance)
        double xDistance =  (double) (Math.sqrt(((xRatio*xRatio*distance*distance)/(yRatio*yRatio))/(1+((xRatio*xRatio)/(yRatio*yRatio))))) ;
        double yDistance = (double) ((yRatio*xDistance)/(xRatio));
        // handles cases where x and/or y is 0
        if(xRatio == 0){
          xDistance = 0;
          yDistance = (double) (distance);
        }
        if(yRatio == 0){
          xDistance = (double) (distance);
          yDistance = 0;
        }
        // added for Assignment5
        if((yRatio == 0) && (xRatio == 0)){
          xDistance = 0;
          yDistance = 0;
        }
        // update coordinates - note: factor in negative direction
        if(yIsNegative){
          yDistance = -(yDistance);
        }
        if(xIsNegative){
          xDistance = -(xDistance);
        }
        super.setX(((int) ((double) (super.getX() + xDistance))));
        super.setY(((int) ((double) (super.getY() + yDistance))));

        // update gas level
        double newGasLevel = (double) (this.getLevel() - ((double) distance/this.getMPG()));
        gasObject.setLevel(newGasLevel);


      return distance;
  }
  public void updateImage(Graphics g) {
    // Move the sprite
    super.updateImage(g);
	}
}
