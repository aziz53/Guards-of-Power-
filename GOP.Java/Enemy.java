/* [Enemy.java]
 * Seyedali Meshkatosadat
 * abstract class of enemy 
 * enemies are targeted by towers and have a set health 
 * super of car, helicopter, plane, tank 
 * June 14, 2017
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
abstract class Enemy {
  private double  x, y;
  private int health;
  static int hor = 150;
  static int ver = 60;
  private boolean reachedEnd;
  private int maxHealth; //is the initial health 
  Enemy(int x, int y, int health){
    this.x = x;
    this.y = y;
    this.health = health;
    this.maxHealth = health;
    reachedEnd = false;
  }
  
     /*move 
   * Ali Meshkat 
   * this method takes in the graphics
   * displays a representation of the enemy's health using 
   * a bar that empties as health goes down 
   */
  void healthBar(Graphics g){
    //converts stats into doubles
    Double DoubleHealth = (double)this.health;
    Double DoubleMaxHealth = (double)this.maxHealth;
    double percentage = DoubleHealth / DoubleMaxHealth* 14; // 
    g.setColor(new Color(78,255,3)); // green colour
    
    g.drawRect((int)this.x+ 30/2 - 7, (int)this.y -10, 14, 8); // oute rectangle 
    g.fillRect((int)this.x + 30/2 -7,(int) this.y -10, (int)(percentage),8 ); //inner rect that shows health
  }
  
  abstract void move(double elapsedTime);
  
  //getters and setters for variables 
  //setters return variables 
  //setters take in and then change the variables 
  void setHealt(int health){
    this.health = health;
  }
  int getHealth(){
    return this.health;
  }
  public void setHealth(int health){
    this.health = health;
  }
  void setX(double x){
    this.x = x;
  }
  double getX(){
    return this.x;
  }  
  void setY(double y){
    this.y = y;
  }
  double getY(){
    return this.y;
  }
  public boolean getReachedEnd(){
    return this.reachedEnd;
  }
  public void setReachedEnd(boolean change){
    reachedEnd = change;
  }
  public static int getHor(){
    return hor;
  }
  public static  void setHor(int h){
    hor = h;
  }
  public static int getVer(){
    return ver;
  }
  public static  void setVer(int v){
    ver = v;
  }
}