/*  Author: Carter Buckner
    project: Assignment5 - Sprite Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 23 Oct 2019 21:01 PM
*/


import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;
	// private int test;
	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}

	public int getX() {		return locationX; }
	public int getY() {		return locationY; }
	public void setX(int x) {		locationX = x; }
	public void setY(int y) {   locationY = y; }



	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }

	public void updateState(int width, int height) {

	}
	public void updateImage(Graphics g) {
		// Move the sprite
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	public boolean overlaps(Sprite s){
		// overlap = true if an (x,y) is shared bt two photos
		boolean doesOverlap = false;
		// System.out.println(getX() + " " + getY());
		// System.out.println(s.getX() + " " + s.getY() + "\n");
		if(((getX() - s.getX() <= 60) && (getX() - s.getX() >= -60)) && ((getY() - s.getY() <= 60) && (getY() - s.getY() >= -60))){
			doesOverlap = true;
		}
		return doesOverlap;
	}
}
