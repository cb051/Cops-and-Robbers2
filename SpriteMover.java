/*  Author: Carter Buckner
    project: Assignment5 - SpriteMover Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/

class SpriteMover implements Runnable{
  private Model model;
  private View view;
  SpriteMover(Model m, View v){
    model = m;
    view = v;
  }
  public void run(){
    while(true){
      model.updateScene(view.getWidth(), view.getHeight());
      view.repaint();
      try{
        Thread.sleep(2);
      }catch(InterruptedException e){}
    }
  }
}
