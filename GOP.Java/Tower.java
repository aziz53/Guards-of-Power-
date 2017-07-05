/* [Tower.java] (abstract)
 * Seyedali Meshkatosadat
 * Is placed  by the user to destroy enemeis
 * shoots enemies in its range 
 * is the super of MachineGun, Mortar, Mudtower, and RocketLauncher
 * June 14, 2017
 */
import java.awt.Rectangle;
abstract class Tower{
  private int x, y; // cooridnates 
  private int range;  
  private int attackSpeed, damage;  // stats of tower determine its strenght 
  private boolean moveable;    //when the tower is being purchased at first
  private static int width;  //the width and height of the tower's sizee
  private double attackDelay;   ///the time it takes the tower to reload 


  Tower(int x, int y){
    this.x = x;
    this.y = y;
    this.moveable = true;
    width = 55;
    this.attackDelay = 5; ///set to five so everytower attacks without wait time when first is placed
  }

  
  //getters and setters
  public int getDamage(){
    return this.damage;
  }
  public int getAttackSpeed(){
    return this.attackSpeed;
  }

  public int getRange(){
    return this.range;
  }
  public void setDamage(int damage){
    this.damage = damage;
  }
  public void setRange(int range){
    this.range = range;
  }
  public int getX(){
    return this.x;
  }
  public void setX(int x){
    this.x = x;
  }
  public int getY(){
    return this.y;
  }
  public void setY(int y){
    this.y =y;
  }
  public boolean getMoveable(){
    return this.moveable;
  }
  public void setMoveable (boolean y){
    this.moveable =y;
  }
  public static int getWidth(){
    return width;
  }

  public double getAttackDelay(){
    return this.attackDelay;
  }
  public void setAttackDelay(double a){
    this.attackDelay = a;
  }

}