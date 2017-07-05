/* [RocketLauncher.java]
 * Seyedali Meshkatosadat
 * Abstract tower object that is the super of its 4 different levels 
 * extends Tower
 * medium range, medium attack speed, relatively high damage
 * is the most powerful tower 
 * June 14, 2017
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
abstract class RocketLauncher extends Tower{
  private static double delayTimeLimit; //marks the wait time for the tower before it can shoot again
  RocketLauncher(int x ,int y){
    super(x, y);
    delayTimeLimit = 0.5;
  }
  
  public static double getDelayTimeLimit(){
    return delayTimeLimit;
    
  }
  
  
}


/* [RocketLauncherLevel1.java]
 * Seyedali Meshkatosadat
 * tower object that extends RocketLauncher 
 * June 14, 2017
 */
class RocketLauncherLevel1 extends RocketLauncher{
  private static Rectangle bulletBox;
  private static Image image; 
  
  RocketLauncherLevel1(int x, int y){
    
    super(x, y);
    image = Toolkit.getDefaultToolkit().getImage("Rl90.png");
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    super.setDamage(50);
    super.setRange(300);
    
  }
  /*shoot 
   * Ali Meshkat 
   * this method takes in the arralist of enemies and the bullets in addition to the elapesTime 
   * finds those in range 
   * it redraws the tower facing the enemy that is closest to the finish line when in range 
   * it initializes the bullet(rectangle) that will be displayed passing on the coordinates of the enemy and the tower 
   * it decreases health from the enemy being shot(one enemy at a time)
   * has no return value 
   * fully commented code can be found in MachineGunLevel1.java
   */
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >= super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        double angle;
        int quadrant;  // stores in which quadrant the enemey is in so we can find the angle of that enemy to the tower to the x axis 
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
          
          //finds the quadrant the enemy is in if the tower is the origin
          if (enemies.get(minIndex).getX() - super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){ //checkks 
            quadrant = 1; //sets quadrant 
          }else if (enemies.get(minIndex).getX() - super.getX()<= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){
            quadrant = 2;
          }else if (enemies.get(minIndex).getX()- super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() <= 0){
            quadrant = 4;
          }else {
            quadrant = 3;
          }
          
          
          
          angle = 90 * (quadrant -1) + Math.abs(Math.toDegrees(Math.atan((enemies.get(minIndex).getY()-
                                                                          super.getY())/(enemies.get(minIndex).getX()-super.getX())))); // finds anlge to tower 
          
          
          if (angle <= 22.5 || angle > 337.5){   //if in this portion of tower's range
            image = Toolkit.getDefaultToolkit().getImage("Rl0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            image = Toolkit.getDefaultToolkit().getImage("Rl45.png");
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

class RocketLauncherLevel2 extends RocketLauncher{
  private static Rectangle bulletBox;
  private static Image image; 
  
  RocketLauncherLevel2(int x, int y){
    
    super(x, y);
    image = Toolkit.getDefaultToolkit().getImage("2Rl90.png");
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    
    super.setDamage(125);
    super.setRange(350);
    
  }
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >= super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        double angle;
        int quadrant;  // stores in which quadrant the enemey is in so we can find the angle of that enemy to the tower to the x axis 
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
          
          //finds the quadrant the enemy is in if the tower is the origin
          if (enemies.get(minIndex).getX() - super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){ //checkks 
            quadrant = 1; //sets quadrant 
          }else if (enemies.get(minIndex).getX() - super.getX()<= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){
            quadrant = 2;
          }else if (enemies.get(minIndex).getX()- super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() <= 0){
            quadrant = 4;
          }else {
            quadrant = 3;
          }
          
          
          
          angle = 90 * (quadrant -1) + Math.abs(Math.toDegrees(Math.atan((enemies.get(minIndex).getY()-
                                                                          super.getY())/(enemies.get(minIndex).getX()-super.getX())))); // finds anlge to tower 
          
          
          if (angle <= 22.5 || angle > 337.5){   //if in this portion of tower's range
            image = Toolkit.getDefaultToolkit().getImage("2Rl0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            image = Toolkit.getDefaultToolkit().getImage("2Rl45.png");
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
class RocketLauncherLevel3 extends RocketLauncher{
  private static Rectangle bulletBox;
  private static Image image; 
 
  RocketLauncherLevel3(int x, int y){
    
    super(x, y);
    image = Toolkit.getDefaultToolkit().getImage("3Rl90.png");
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    super.setDamage(175);
    super.setRange(400);
  }
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >= super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        double angle;
        int quadrant;  // stores in which quadrant the enemey is in so we can find the angle of that enemy to the tower to the x axis 
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
          
          //finds the quadrant the enemy is in if the tower is the origin
          if (enemies.get(minIndex).getX() - super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){ //checkks 
            quadrant = 1; //sets quadrant 
          }else if (enemies.get(minIndex).getX() - super.getX()<= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){
            quadrant = 2;
          }else if (enemies.get(minIndex).getX()- super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() <= 0){
            quadrant = 4;
          }else {
            quadrant = 3;
          }
          
          
          
          angle = 90 * (quadrant -1) + Math.abs(Math.toDegrees(Math.atan((enemies.get(minIndex).getY()-
                                                                          super.getY())/(enemies.get(minIndex).getX()-super.getX())))); // finds anlge to tower 
          
          
          if (angle <= 22.5 || angle > 337.5){   //if in this portion of tower's range
            image = Toolkit.getDefaultToolkit().getImage("3Rl0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            image = Toolkit.getDefaultToolkit().getImage("3Rl45.png");
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
class RocketLauncherLevel4 extends RocketLauncher{
  private static Rectangle bulletBox;
  private static Image image; 
  
  RocketLauncherLevel4(int x, int y){
    super(x, y);
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    image = Toolkit.getDefaultToolkit().getImage("4Rl90.png");
    super.setDamage(275);
    super.setRange(500);
    
  }
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >= super.getDelayTimeLimit()){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        double angle;
        int quadrant;  // stores in which quadrant the enemey is in so we can find the angle of that enemy to the tower to the x axis 
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
          
          //finds the quadrant the enemy is in if the tower is the origin
          if (enemies.get(minIndex).getX() - super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){ //checkks 
            quadrant = 1; //sets quadrant 
          }else if (enemies.get(minIndex).getX() - super.getX()<= 0 && enemies.get(minIndex).getY() - super.getY() >= 0){
            quadrant = 2;
          }else if (enemies.get(minIndex).getX()- super.getX() >= 0 && enemies.get(minIndex).getY() - super.getY() <= 0){
            quadrant = 4;
          }else {
            quadrant = 3;
          }
          
          
          
          angle = 90 * (quadrant -1) + Math.abs(Math.toDegrees(Math.atan((enemies.get(minIndex).getY()-
                                                                          super.getY())/(enemies.get(minIndex).getX()-super.getX())))); // finds anlge to tower 
          
          
          if (angle <= 22.5 || angle > 337.5){   //if in this portion of tower's range
            image = Toolkit.getDefaultToolkit().getImage("4Rl0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            image = Toolkit.getDefaultToolkit().getImage("4Rl45.png");
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