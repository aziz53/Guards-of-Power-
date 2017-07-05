/* [MachineGun.java]
 * Seyedali Meshkatosadat
 * Abstract tower object that is the super of its 4 different levels 
 * extends Tower
 * is the cheapest/weakest type of tower 
 * high attak speed, low range, and low damage
 * June 14, 2017
 */
import java.util.ArrayList; 
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.lang.Math; 
import java.awt.Rectangle; 
abstract class MachineGun extends Tower{
  private static double delayTimeLimit; //marks the wait time for the tower before it can shoot again
  
  MachineGun(int x, int y){
    super(x, y);
    delayTimeLimit = 0.05; // fires every 0.05 secs
  }
  
  
  //getter for attackspeed 
  public static double getDelayTimeLimit(){
    return delayTimeLimit;
  }
  

  
}

/* [MachineGunLevel1.java]
 * Seyedali Meshkatosadat
 * tower object that is the super of its 4 different levels 
 * extends MachineGun
 * is the cheapest/weakest type of tower 
 * June 14, 2017
 */
class MachineGunLevel1 extends MachineGun{
  
  private static Rectangle bulletBox;// is the rectangle that will be displayed when the tower shoots 
  private Image image;  // image of the tower 
  
  MachineGunLevel1(int x, int y){ //constructor 
    super(x, y);
    
    this.image = Toolkit.getDefaultToolkit().getImage("MG90.png"); //when the tower is played is will be facing up(90 degreses)

    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3); //initializes the bullet box 
    
    super.setDamage(3); // sets damage 
    super.setRange(250); //sets radius(range)
    
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
    if(!super.getMoveable()){//if tower not BEING placed 
      super.setAttackDelay (super.getAttackDelay() + elapsedTime); // adds time to wait time 
      if (super.getAttackDelay() >= super.getDelayTimeLimit() ){ // if time to attack(reload completed) then attack 
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        double angle;   //is the angle starting from the x axis(positive) moving counter-clockwise 
        int quadrant;  // stores in which quadrant the enemey is in so we can find the angle of that enemy to the tower to the x axis 
        ArrayList<Integer> inRange = new ArrayList<Integer>(); //holds the index of all enemy objects in enemies that are in rangee 
        int minIndex; // marks the closest enemy to the end line (the one to be attacked)
        
        
        // finds all enemies in range 
        for (int i = 0; i <= enemies.size()-1; i++){ //runs through enemies 
          distance = Math.sqrt(Math.pow(enemies.get(i).getX()-super.getX(),2) + 
                               Math.pow(enemies.get(i).getY()-super.getY(),2)); // finds the distance using pythagorean theorem
          if(distance < super.getRange()-120){       // if less distance than the radius of range
            inRange.add(i);        // stores those in range in arraylist 
          }
        }
        
        // finds the closest to finish line(smallest value(index of enemies))
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
          
          
          //finds anghle using the inverse tan of the y difference over x distance
          angle = 90 * (quadrant -1) + Math.abs(Math.toDegrees(Math.atan((enemies.get(minIndex).getY()-
                                                                          super.getY())/(enemies.get(minIndex).getX()-super.getX())))); // finds angle to tower 
          
          
          //finds which pic to use based on angle 
          if (angle <= 22.5 || angle > 337.5){   //if in this portion of tower's range
            this.image = Toolkit.getDefaultToolkit().getImage("MG0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            this.image = Toolkit.getDefaultToolkit().getImage("MG45.png");
          }
          
          
          
          //shoots the enemy
          bullets.add(new Bullet(super.getX(), super.getY(), enemies.get(minIndex).getX(), enemies.get(minIndex).getY(), bulletBox));
          
          //decreases health
          enemies.get(minIndex).setHealth(enemies.get(minIndex).getHealth() - super.getDamage());
          
          
          
          
        }
      }
    }
  }
  
  
  //getter for image 
  public Image getImage(){
    return this.image;
  }
  
}
class MachineGunLevel2 extends MachineGun{
  private static Rectangle bulletBox;
  private Image image; 
  MachineGunLevel2(int x, int y){
    super(x, y);
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    this.image = Toolkit.getDefaultToolkit().getImage("2MG90.png");
    super.setDamage(5);
    super.setRange(350);
  }
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >=super.getDelayTimeLimit() ){
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
            this.image = Toolkit.getDefaultToolkit().getImage("2MG0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            this.image = Toolkit.getDefaultToolkit().getImage("2MG45.png");
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
    return this.image;
  }
}
class MachineGunLevel3 extends MachineGun{
  private static Rectangle bulletBox;

  private Image image; 
  MachineGunLevel3(int x, int y){
    
    super(x, y);
    
    this.image = Toolkit.getDefaultToolkit().getImage("3MG90.png");
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    
    super.setDamage(7);
    super.setRange(400);
    
  }
  
  
  void shoot(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >=super.getDelayTimeLimit() ){
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
            this.image = Toolkit.getDefaultToolkit().getImage("3MG0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            this.image = Toolkit.getDefaultToolkit().getImage("3MG45.png");
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
    return this.image;
  }
}
class MachineGunLevel4 extends MachineGun{
  private static Rectangle bulletBox;
  private Image image; 
  MachineGunLevel4(int x, int y){
    
    super(x, y);
    
    this.image = Toolkit.getDefaultToolkit().getImage("4MG90.png");
    
    
    bulletBox = new Rectangle(super.getX(), super.getY(), 3, 3);
    super.setDamage(9);
    super.setRange(500);
    
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
            this.image = Toolkit.getDefaultToolkit().getImage("4MG0.png"); //use this picture
          }else if (angle > 22.5 && angle <= 67.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG315.png");
          }else if (angle > 67.5 && angle <= 112.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG270.png");
          }else if (angle > 112.5 && angle <= 157.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG225.png");
          }else if (angle > 157.5 && angle <= 202.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG180.png");
          }else if (angle > 202.5 && angle <= 247.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG135.png");
          }else if (angle > 247.5 && angle <= 292.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG90.png");
          }else if (angle > 292.5 && angle <= 337.5){
            this.image = Toolkit.getDefaultToolkit().getImage("4MG45.png");
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
    return this.image;
  }
  
}



