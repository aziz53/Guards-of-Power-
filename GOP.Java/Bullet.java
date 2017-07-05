/* [Bullet.java]
 * Seyedali Meshkatosadat
 * Bullet objects that are fired by towers to the enemies
 * June 14, 2017
 */
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
class Bullet{
  private double x, y; //current pos of the buller 
  private double enemyX, enemyY; // pos of the enemy when the bullet was shot 
  private Rectangle image; //is the rectanlge that will be drawn 
  private boolean reachedTarget; // used to remove the bullet after hitting the target
  private boolean moved;
  
  Bullet (double startX, double startY, double enemyX, double enemyY, Rectangle image){ // constructor 
    this.x = startX + Tower.getWidth()/2;
    this.y = startY + Tower.getWidth()/2;
    this.image  = image;
    this.enemyX  = enemyX;
    this.enemyY = enemyY;
    this.reachedTarget = false;
  }
  
  //updates the pos of the bullet at the speed that makes the bullet reach the enemy in 20 frames 
  //int x, int y,  int enemyX, int enemyY, Image image
  void update(double elapsedTime ){
    //checks and runs the updates until the bullet ends up in the area around the enemy 
    this.moved =false;
    if (this.x < enemyX && enemyX - this.x > 10){

      this.x += 5;//* elapsedTime*100;
      this.moved = true;
    }
    
    if(this.y < enemyY && enemyY - this.y > 10){
      this.y += 5;//* elapsedTime*100;
      this.moved = true;
    } 
    
    if (this.x > enemyX && enemyX - this.x < 10){
      this.x -= 5;//* elapsedTime*100;
      this.moved = true;
    } 
    
    if(this.y > enemyY && enemyY - this.y < 10){
      this.y -= 5;//* elapsedTime*100;
      this.moved = true;
    } 
    
    if (!moved){ // if not moved
      this.reachedTarget = true;
    }
  }
  
  void draw(Graphics g){
    if (!this.reachedTarget){ // if not there yet
      g.setColor(new Color(250,3,3)); // Red colour
      g.fillRect ((int)this.x, (int)this.y, (int)this.image.getWidth(), (int)this.image.getHeight());
    }else {
      g.clearRect((int)this.x, (int)this.y, (int)this.image.getWidth(), (int)this.image.getHeight()); // replaces it with the background pic
    }
       
    
  }
  
  
  //getters and setters for variables 
  //setters return variables 
  //setters take in and then change the variables 
  public double getX() {
    return this.x;
  }
  public double getY(){
    return this.y;
  }
  public boolean getReachedTarget(){
    return this.reachedTarget;
  }
  
  
  
  
  
}