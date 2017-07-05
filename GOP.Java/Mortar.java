/* [Mortar.java]
 * Seyedali Meshkatosadat
 * Abstract tower object that is the super of its 4 different levels 
 * extends Tower
 * can be poewrful in later game
 * huge range, insane damage, low attack speed
 * June 14, 2017
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;
abstract class Mortar extends Tower{ //has a huge range, insane damage but low attack speed(high reload time)
  private static double delayTimeLimit; //marks the wait time for the tower before it can shoot again
  Mortar(int x ,int y){
    super(x,y);
    delayTimeLimit = 2.5;//2.5 secs  reload time 
  }
  public static double getDelayTimeLimit(){
    return delayTimeLimit;
  }
  
}
/* [MortarLevel1.java]
 * Seyedali Meshkatosadat
 * tower object that extends Mortar 
 * June 14, 2017
 */
class MortarLevel1 extends Mortar{
  private static Rectangle bulletBox;
  private static Image image; 
  private double attackDelay;
  MortarLevel1(int x, int y){
    
    super(x, y);
    bulletBox = new Rectangle(super.getX(), super.getY(), 5, 5);
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    super.setDamage(100);
    super.setRange(300);
  }
  
  /*shoot 
   * Ali Meshkat 
   * this method takes in the arralist of enemies and the bullets in addition to the elapesTime 
   * finds enemies in rangee 
   * it redraws the tower facing the enemy that is closest to the finish line when in range 
   * it initializes the bullet(rectangle) that will be displayed passing on the coordinates of the enemy and the tower 
   * it decreases health from the enemy being shot(one enemy at a time)
   * has no return value 
   */
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      this.attackDelay += elapsedTime;
      if (this.attackDelay >= super.getDelayTimeLimit() ){
        this.attackDelay = 0;
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>();
        int minIndex; // marks the closest enemy to the end line (the one to be attacked)
        
        if(inRange.size() != 0){
          for (int i = 0; i< inRange.size(); i++){
            inRange.remove(i);
          }
        }
        
        
        for (int i = 0; i <= enemies.size()-1; i++){
          distance = Math.sqrt(Math.pow(enemies.get(i).getX()-super.getX(),2) + 
                               Math.pow(enemies.get(i).getY()-super.getY(),2)); // finds the distance using pythagorean theorem
          
          if(distance < super.getRange()-120){
            inRange.add(i); // stores those in range 
          }
        }
        
        if (inRange.size() != 0){ // if there are enemies in range 
          // finds the closest to finish line (first in arrayList)
          minIndex = enemies.size(); // initial value 
          for (int i = 0; i < inRange.size(); i ++){
            if(inRange.get(i) <= minIndex){
              minIndex = inRange.get(i); 
            }
          }
          
          //shoots the enemy
          bullets.add(new Bullet(super.getX(), super.getY(), enemies.get(minIndex).getX(), enemies.get(minIndex).getY(), bulletBox));
          
          //decreases health
          enemies.get(minIndex).setHealth(enemies.get(minIndex).getHealth() - super.getDamage());
        } 
      }
    }
  }
  
  
  
  public Image getImage(){
    return image;
  }
}

class MortarLevel2 extends Mortar{
  private static Rectangle bulletBox;
  private static Image image; 
    private double attackDelay;
  MortarLevel2(int x, int y){
    super(x, y);    
    bulletBox = new Rectangle(super.getX(), super.getY(), 5, 5);
    super.setDamage(300);
    super.setRange(400);
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
        this.attackDelay = 0;
  }
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      this.attackDelay += elapsedTime;
      if (this.attackDelay >= super.getDelayTimeLimit() ){
        this.attackDelay = 0;
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>();
        int minIndex; // marks the closest enemy to the end line (the one to be attacked)
        
        if(inRange.size() != 0){
          for (int i = 0; i< inRange.size(); i++){
            inRange.remove(i);
          }
        }
        
        
        for (int i = 0; i <= enemies.size()-1; i++){
          distance = Math.sqrt(Math.pow(enemies.get(i).getX()-super.getX(),2) + 
                               Math.pow(enemies.get(i).getY()-super.getY(),2)); // finds the distance using pythagorean theorem
          
          if(distance < super.getRange()-120){
            inRange.add(i); // stores those in range 
          }
        }
        
        if (inRange.size() != 0){ // if there are enemies in range 
          // finds the closest to finish line (first in arrayList)
          minIndex = enemies.size(); // initial value 
          for (int i = 0; i < inRange.size(); i ++){
            if(inRange.get(i) <= minIndex){
              minIndex = inRange.get(i); 
            }
          }
          
          //shoots the enemy
          bullets.add(new Bullet(super.getX(), super.getY(), enemies.get(minIndex).getX(), enemies.get(minIndex).getY(), bulletBox));
          
          //decreases health
          enemies.get(minIndex).setHealth(enemies.get(minIndex).getHealth() - super.getDamage());
        } 
      }
    }
  }
  
  public Image getImage(){
    return image;
  }
}

class MortarLevel3 extends Mortar{
  private static Rectangle bulletBox;
  private static Image image; 
    private double attackDelay;
  MortarLevel3(int x, int y){
    
    super(x, y);
    bulletBox = new Rectangle(super.getX(), super.getY(), 5, 5);
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    super.setDamage(500);
    super.setRange(500);
    this.attackDelay = 0;
  }
  
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      this.attackDelay += elapsedTime;
      if (this.attackDelay >=super.getDelayTimeLimit() ){
        this.attackDelay = 0;
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>();
        int minIndex; // marks the closest enemy to the end line (the one to be attacked)
        
        if(inRange.size() != 0){
          for (int i = 0; i< inRange.size(); i++){
            inRange.remove(i);
          }
        }
        
        
        for (int i = 0; i <= enemies.size()-1; i++){
          distance = Math.sqrt(Math.pow(enemies.get(i).getX()-super.getX(),2) + 
                               Math.pow(enemies.get(i).getY()-super.getY(),2)); // finds the distance using pythagorean theorem
          
          if(distance < super.getRange()-120){
            inRange.add(i); // stores those in range 
          }
        }
        
        if (inRange.size() != 0){ // if there are enemies in range 
          // finds the closest to finish line (first in arrayList)
          minIndex = enemies.size(); // initial value 
          for (int i = 0; i < inRange.size(); i ++){
            if(inRange.get(i) <= minIndex){
              minIndex = inRange.get(i); 
            }
          }
          
          //shoots the enemy
          bullets.add(new Bullet(super.getX(), super.getY(), enemies.get(minIndex).getX(), enemies.get(minIndex).getY(), bulletBox));
          
          //decreases health
          enemies.get(minIndex).setHealth(enemies.get(minIndex).getHealth() - super.getDamage());
        } 
      }
    }
  }
  
  
  public Image getImage(){
    return image;
  }
}
class MortarLevel4 extends Mortar{
  private static Rectangle bulletBox;
  private static Image image; 
  private double attackDelay;
  MortarLevel4(int x, int y){
    
    super(x, y);
    bulletBox = new Rectangle(super.getX(), super.getY(), 5, 5);
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    super.setDamage(800);
    super.setRange(700);
    this.attackDelay = 0;
  }
  /*shoot 
   * Ali Meshkat 
   * this method takes in the arralist of enemies and the bullets in addition to the elapesTime 
   * it redraws the tower facing the enemy that is closest to the finish line when in range 
   * it initializes the bullet(rectangle) that will be displayed passing on the coordinates of the enemy and the tower 
   * it decreases health from the enemy being shot(one enemy at a time)
   * has no return value 
   */
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      this.attackDelay += elapsedTime;
      if (this.attackDelay >= super.getDelayTimeLimit()){
        this.attackDelay = 0;
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>();
        int minIndex; // marks the closest enemy to the end line (the one to be attacked)
        
        if(inRange.size() != 0){
          for (int i = 0; i< inRange.size(); i++){
            inRange.remove(i);
          }
        }
        
        
        for (int i = 0; i <= enemies.size()-1; i++){
          distance = Math.sqrt(Math.pow(enemies.get(i).getX()-super.getX(),2) + 
                               Math.pow(enemies.get(i).getY()-super.getY(),2)); // finds the distance using pythagorean theorem
          
          if(distance < super.getRange()-super.getRange()/2){
            inRange.add(i); // stores those in range 
          }
        }
        
        if (inRange.size() != 0){ // if there are enemies in range 
          // finds the closest to finish line (first in arrayList)
          minIndex = enemies.size(); // initial value 
          for (int i = 0; i < inRange.size(); i ++){
            if(inRange.get(i) <= minIndex){
              minIndex = inRange.get(i); 
            }
          }
          
          //shoots the enemy
          bullets.add(new Bullet(super.getX(), super.getY(), enemies.get(minIndex).getX(), enemies.get(minIndex).getY(), bulletBox));
          
          //decreases health
          enemies.get(minIndex).setHealth(enemies.get(minIndex).getHealth() - super.getDamage());
        } 
      }
    }
  }
  
  public Image getImage(){
    return image;
  }
}