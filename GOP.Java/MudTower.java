/* [MudTower.java]
 * Seyedali Meshkatosadat
 * Abstract tower object that is the super of its 4 different levels 
 * extends Tower
 * attacks all those in its range 
 * low range, high attack speed, low damage
 * June 14, 2017
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

import java.util.ArrayList; 
abstract class MudTower extends Tower{ //attacks all those in its range (no animation for its attack )
  private static double delayTimeLimit; //marks the wait time for the tower before it can shoot again
  MudTower(int x ,int y){
    super(x,y);
  }
    public static double getDelayTimeLimit(){
    return delayTimeLimit = 0.05;
  }
  
  
}
/* [MudTowerLevel1.java]
 * Seyedali Meshkatosadat
 * tower object that extends MudTower 
 * June 14, 2017
 */
class MudTowerLevel1 extends MudTower{
   private static Image image; 
  MudTowerLevel1(int x, int y){
    
    super(x, y);
    
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    super.setDamage(2);
    super.setRange(200);  
  }
  
  
  /*shoot 
   * Ali Meshkat 
   * this method takes in the arralist of enemies in addition to the elapsedTime 
   * finds those in range   
   * it decreases health from the enemy being shot(one enemy at a time) all those in range 
   * has no return value 
   */
  void shoot(ArrayList<Enemy> enemies, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >=super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>(); //holds the index of all enemy objects in enemies that are in rangee 
        
        //resets in range 
        if(inRange.size() != 0){
          for (int i = 0; i< inRange.size(); i++){
            inRange.remove(i);
          }
        }
        
        //finds the distance of the enemies 
        for (int i = 0; i <= enemies.size()-1; i++){
          distance = Math.sqrt(Math.pow(enemies.get(i).getX()-super.getX(),2) + 
                               Math.pow(enemies.get(i).getY()-super.getY(),2)); // finds the distance using pythagorean theorem
          if(distance < super.getRange()-120){
            inRange.add(i); // stores those in range 
          }
        }
        
        //damages all those in radius 
        for (int i = 0; i <= inRange.size()-1; i++){ //runs through all in range 
          enemies.get(inRange.get(i)).setHealth(enemies.get(inRange.get(i)).getHealth() - super.getDamage()); //decreases health 
        }
      }
    }
    
  }
  
  
  
  
  public Image getImage(){
    return image;
  }
  
}
class MudTowerLevel2 extends MudTower{
  private static Image image; 
  
  MudTowerLevel2(int x, int y){ 
    super(x, y);
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    
    super.setDamage(3);
    super.setRange(300);
  }
  
  void shoot(ArrayList<Enemy> enemies, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >= super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>(); //holds the index of all enemy objects in enemies that are in rangee 
        
        //resets in range 
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
        
        //damages all those in radius 
        for (int i = 0; i <= inRange.size()-1; i++){ //runs through all in range 
          enemies.get(inRange.get(i)).setHealth(enemies.get(inRange.get(i)).getHealth() - super.getDamage()); //decreases health 
        }
      }
    }
  }
  
  public Image getImage(){
    return image;
  }
  
}
class MudTowerLevel3 extends MudTower{
    private static Image image; 
  
  MudTowerLevel3(int x, int y){
    
    super(x, y);
    
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    super.setDamage(5);
    super.setRange(350);
    
  }
  
  void shoot(ArrayList<Enemy> enemies, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >= super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>(); //holds the index of all enemy objects in enemies that are in rangee 
        
        //resets in range 
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
        
        //damages all those in radius 
        for (int i = 0; i <= inRange.size()-1; i++){ //runs through all in range 
          enemies.get(inRange.get(i)).setHealth(enemies.get(inRange.get(i)).getHealth() - super.getDamage()); //decreases health 
        }
      }
    }
    
  }
  
  public Image getImage(){
    return image;
  }
}
class MudTowerLevel4 extends MudTower{
  private static Image image; 
  
  MudTowerLevel4(int x, int y){
    
    super(x, y);
    
    image = Toolkit.getDefaultToolkit().getImage("mortar.png");
    super.setDamage(7);
    super.setRange(425);
  }
  void shoot(ArrayList<Enemy> enemies, double elapsedTime){
    if(!super.getMoveable()){
      super.setAttackDelay (super.getAttackDelay() + elapsedTime);
      if (super.getAttackDelay() >=super.getDelayTimeLimit() ){
        super.setAttackDelay(0);
        double distance; // has distance of the enemy to the tower calculated using pythagorean theorea 
        ArrayList<Integer> inRange = new ArrayList<Integer>(); //holds the index of all enemy objects in enemies that are in rangee 
        
        //resets in range 
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
        
        //damages all those in radius 
        for (int i = 0; i <= inRange.size()-1; i++){ //runs through all in range 
          enemies.get(inRange.get(i)).setHealth(enemies.get(inRange.get(i)).getHealth() - super.getDamage()); //decreases health 
        }
      }
    }
    
  }
  
  
  public Image getImage(){
    return image;
  }
}