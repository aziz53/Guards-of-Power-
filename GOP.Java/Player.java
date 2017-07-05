/* [Player.java]
 * Seyedali Meshkatosadat, Aziz Safri
 * keeps record of the user's stats eg health, wealth
 * June 14, 2017
 */
class Player {
  
  private static int health; //number of healths the player has left (before losing)
  private static int money; // money used to upgrade and purchase towers
  
  Player(int h, int m){
    health = h;
    money = m;
  }
  
  //getters and setters 
  void setHealth(int h){
    health = h;
  }
  void setMoney(int m){
    money = m;
  }
  int getHealth(){
    return health;
  }
  int getMoney(){
    return money;
  }
  void takeMoney(int cash){
    money = money - cash;
  }
  void addMoney(int m){
    money += m;
  }
  void takeHealth(int changer){
    health = health - changer;
  }
}