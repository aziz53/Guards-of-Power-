/* [mainGame.java]
 * Seyedali Meshkatosadat, Aziz Safri 
 * ICS3U6
 * This game is a strategic tower- defense game
 */
import javax.swing.JFrame;//d
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.io.File; 
import java.util.Scanner;
import java.util.ArrayList;
class mainGame extends JFrame{
  enterPanel game = new enterPanel();
  mainGame thisFrame;
  //rectangles/coordinates representing every buttin  
 Rectangle playButton = new Rectangle(420,300,1020,100);
  Rectangle tutorialButton = new Rectangle(590,500,700,70);
  Rectangle exitButton = new Rectangle(50,50,100,100);
  Rectangle aboutButton = new Rectangle(50,850,100,100);
  buttonMouseListener clickCheck = new buttonMouseListener(); //setting mouse listener 
  
  //intro window 
  mainGame(String gameTitle){
    this.setTitle(gameTitle); //sets title 
    this.setVisible(true);  // sets visible 
    this.setSize(2048,1536); //sets size  
    this.setResizable(true);  // allows window to change size 
    this.add(game); //adds the game panel 
    thisFrame = this; 
    game.setVisible(true); //sets panel to visible 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows it to be closed if x pressed
    this.addMouseListener(clickCheck); // adds click listener 
  }
  
  private class buttonMouseListener implements MouseListener{
    /**
* mouseClicked
* Aziz Safri
* @Override
* This method accepts a mouse event and then based on what button is clicked, a new frame is made,
* and repaints a new frame
* @param MouseEvent
* @return void function
*/
    public void mouseClicked(MouseEvent e){
      if(e.getX() >= playButton.getX() && e.getX() <= (playButton.getX() + playButton.getWidth()) && e.getY() >= playButton.getY() && e.getY() <= (playButton.getY() + playButton.getHeight())){ // if clicked on button 
        thisFrame.dispose(); // ends intro window  
        mapChooser choosingMap = new mapChooser("Guards of Power");// opens mapChooser window for the user to select maps/difficulty
      }else if(e.getX() >= tutorialButton.getX() && e.getX() <= (tutorialButton.getX() + tutorialButton.getWidth()) && e.getY() >= tutorialButton.getY() && e.getY() <= (tutorialButton.getY() + tutorialButton.getHeight())){
        thisFrame.dispose();
        tutorialFrame instructions = new tutorialFrame("Guards of Power"); //opens tutorial window 
      }else if(e.getX() > aboutButton.getX() && e.getX() < aboutButton.getX() + aboutButton.getWidth() && e.getY() > aboutButton.getY() && e.getY() < aboutButton.getY() + aboutButton.getHeight()){
        thisFrame.dispose();
        aboutFrame aboutUs = new aboutFrame("Guards of Power");//opens about window 
      }else if(e.getX() >= exitButton.getX() && e.getX() <= (exitButton.getX() + exitButton.getWidth()) && e.getY() >= exitButton.getY() && e.getY() <= (exitButton.getY() + exitButton.getHeight())){
        thisFrame.dispose();//closes window 
        System.exit(0);// ends program 
      }
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    } 
  }
}
class playFrame extends JFrame{
  int mapNum;
  playFrame(String gameTitle, int mapNum){
    this.setTitle(gameTitle);
    this.mapNum = mapNum;
    this.setSize(2048,1536);
    this.setVisible(true);

    this.add(new nemesisPanel());
    
  }
}
class mapChooser extends JFrame{
  mapPanel chooseMap = new mapPanel();
  mapChooser thisFrame;
  Rectangle nemesisBox = new Rectangle(100,100,500,700); ////////////////////////////////////////////////////////////////////
  Rectangle elysiumBox = new Rectangle(700,100,500,700);
  Rectangle thunderBaseBox = new Rectangle(1300,100,500,700);
  private static int mapChosen; // vairable that shows which map must be used in later stages 1-Nemeses  2-Elysium   3-Thunder Base
  mapChooser(String gameTitle){
    this.setTitle(gameTitle);
    thisFrame = this;
    this.setSize(2048,1536);
    this.setVisible(true);
    this.add(chooseMap);
    this.addMouseListener(new mapClickListener());
  }
  private class mapClickListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
      if(e.getX() >= nemesisBox.getX() && e.getX() <= (nemesisBox.getX() + nemesisBox.getWidth()) && e.getY() >= nemesisBox.getY() && e.getY() <= (nemesisBox.getY() + nemesisBox.getHeight())){
        thisFrame.dispose();
        mapChosen = 1;
        new playFrame("Guards of Power", 1);
      }else if(e.getX() >= elysiumBox.getX() && e.getX() <= (elysiumBox.getX() + elysiumBox.getWidth()) && e.getY() >= elysiumBox.getY() && e.getY() <= (elysiumBox.getY() + elysiumBox.getHeight())){
        thisFrame.dispose();
        mapChosen = 2;
        new playFrame("Guards of Power", 2);
      }else if(e.getX() >= thunderBaseBox.getX() && e.getX() <= (thunderBaseBox.getX() + elysiumBox.getWidth()) && e.getY() >= thunderBaseBox.getY() && e.getY() <= (thunderBaseBox.getY() + thunderBaseBox.getHeight())){
        thisFrame.dispose();
        mapChosen = 3;
        new playFrame("Guards of Power", 3);
      }
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    } 
  }
    
    //getters and setters 
    static void setMapChosen(int map){
      mapChosen = map;
    }
     static int getMapChosen(){
      return mapChosen;
    }
}
class tutorialFrame extends JFrame{
  tutorialPanel tutorial = new tutorialPanel();
  buttonClickListener myListener = new buttonClickListener();
  tutorialFrame thisFrame;
  Rectangle exitButton = new Rectangle(50,50,100,100);
  tutorialFrame(String gameTitle){
    thisFrame = this;
    this.setTitle(gameTitle);
    this.setSize(2048,1536);
    this.setVisible(true);
    this.add(tutorial);
    this.addMouseListener(myListener);
  }
  private class buttonClickListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
      if(e.getX() >= exitButton.getX() && e.getX() <= exitButton.getX() + exitButton.getWidth() && e.getY() >= exitButton.getY() && e.getY() <= exitButton.getY() + exitButton.getHeight()){
        thisFrame.dispose();
        new mainGame("Guards of Power");
      }      
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    } 
  }
}
class aboutFrame extends JFrame{
  aboutPanel aboutUs = new aboutPanel();
  aboutFrame thisFrame;
  Rectangle exitButton = new Rectangle(50,50,100,100);
  aboutFrame(String gameTitle){
    thisFrame = this;
    this.setTitle(gameTitle);
    this.setSize(2048,1536);
    this.setVisible(true);
    this.add(aboutUs);
    this.addMouseListener(new buttonClickListener());
  }
  private class buttonClickListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
      if(e.getX() >= exitButton.getX() && e.getX() <= exitButton.getX() + exitButton.getWidth() && e.getY() >= exitButton.getY() && e.getY() <= exitButton.getY() + exitButton.getHeight()){
        thisFrame.dispose();
        new mainGame("Guards of Power");
      }      
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    } 
  }
}
  /**
   * paintComponent
   * @Override
   * This method accepts a graphics object and then draws the background and button using special fonts
   * @param Graphics
   * @return void function
   */
class enterPanel extends JPanel{
  enterPanel thisPanel;
  mapPanel chooseMap = new mapPanel();
  Rectangle playButton = new Rectangle(420,300,1020,100);
  Rectangle tutorialButton = new Rectangle(590,500,700,70);
  Rectangle exitButton = new Rectangle(50,50,100,100);
  Rectangle aboutButton = new Rectangle(50,850,100,100);
  BufferedImage backgroundImage;
  enterPanel(){
    this.setVisible(true);
    this.thisPanel = this;
    try{
      backgroundImage = ImageIO.read(new File("EnterBackground.jpg"));
    }catch(Exception e){
      e.printStackTrace();
    };
  }
  public void paintComponent (Graphics g){
    super.paintComponent(g);
    g.drawImage(backgroundImage,0,0,1920,1080,this);
    g.fillRect((int)playButton.getX(), (int)playButton.getY(), (int)playButton.getWidth(), (int)playButton.getHeight());
    g.fillRect((int)tutorialButton.getX(), (int)tutorialButton.getY(), (int)tutorialButton.getWidth(), (int)tutorialButton.getHeight());
    g.fillRect((int)aboutButton.getX(), (int)aboutButton.getY(), (int)aboutButton.getWidth(), (int)aboutButton.getHeight());
    g.fillRect((int)exitButton.getX(), (int)exitButton.getY(), (int)exitButton.getWidth(), (int)exitButton.getHeight());
    g.setColor(new Color(96,96,96));
    g.setFont(new Font("Garamond", Font.BOLD, 100));
    g.drawString("Guards of Power",565,200);
    g.setColor(new Color(255,255,255));
    g.setFont(new Font("Garamond", Font.BOLD, 70));
    g.drawString("Play",(int)playButton.getX() +((int)playButton.getWidth()/2)- 60 , (int)playButton.getY() + ((int)playButton.getHeight()/2) + 20);
    g.setFont(new Font("Garamond", Font.BOLD, 60));
    g.drawString("Tutorial",(int)tutorialButton.getX() +((int)tutorialButton.getWidth()/2) - 120, (int)tutorialButton.getY()+((int)tutorialButton.getHeight()/2) + 20);
    g.setFont(new Font("Garamond", Font.BOLD, 25));
    g.drawString("About Us",(int)aboutButton.getX() +((int)aboutButton.getWidth()/2)- 50,(int)aboutButton.getY() +((int)aboutButton.getHeight()/2)+7 );
    g.drawString("Exit",(int)exitButton.getX() +((int)exitButton.getWidth()/2) - 20,(int)exitButton.getY() +((int)exitButton.getHeight()/2) + 7);
  }
}
class nemesisPanel extends JPanel{
  Player user = new Player(50,300);
  ArrayList<Tower>towers;
  towersPanel buyArea; 
  nemesisMap gameMap;
  upgradePanel upgrades;
  infoPanel healthWealth = new infoPanel(user);
  nemesisPanel(){
    towers = new ArrayList<Tower>();
    gameMap = new nemesisMap(towers, user);
    buyArea = new towersPanel(towers, user);
    upgrades = new upgradePanel(user, towers, gameMap);
    upgrades.setPreferredSize(new Dimension(104,104));
    this.setLayout(new BorderLayout());
    this.add(buyArea,BorderLayout.EAST);
    this.add(upgrades,BorderLayout.SOUTH);
    this.add(gameMap,BorderLayout.CENTER);
    this.add(healthWealth,BorderLayout.NORTH);
  }
}

class towersPanel extends JPanel{
  Image machineGun, mudGun, rocketGun, mortar;
  JButton machGunButton;
  JButton mudGunButton = new JButton();
  JButton rocketGunButton = new JButton();
  JButton mortarButton = new JButton();
  pickTower checker;
  Player player;
  ArrayList<Tower> myTowers;
  towersPanel(ArrayList<Tower> towers, Player p){
    player =  p;
    machineGun = Toolkit.getDefaultToolkit().getImage("MG90.png");
    mudGun = Toolkit.getDefaultToolkit().getImage("mortar.png"); /////////////////mud.png does not exist 200
    rocketGun = Toolkit.getDefaultToolkit().getImage("Rl90.png"); //400
    mortar = Toolkit.getDefaultToolkit().getImage("mortar.png");//300
    machGunButton = new JButton("Machine Gun ($150)");
    machGunButton.setHorizontalTextPosition(AbstractButton.CENTER);
    machGunButton.setVerticalTextPosition(AbstractButton.BOTTOM);
    machGunButton.setIcon(new ImageIcon(machineGun));
    mudGunButton = new JButton("Mud Gun ($200)");
    mudGunButton.setHorizontalTextPosition(AbstractButton.CENTER);
    mudGunButton.setVerticalTextPosition(AbstractButton.BOTTOM);
    mudGunButton.setIcon(new ImageIcon(mudGun));
    rocketGunButton = new JButton("Rocket Launcher ($400)");
    rocketGunButton.setHorizontalTextPosition(AbstractButton.CENTER);
    rocketGunButton.setVerticalTextPosition(AbstractButton.BOTTOM);
    rocketGunButton.setIcon(new ImageIcon(rocketGun));
    mortarButton = new JButton("Mortar ($300)");
    mortarButton.setHorizontalTextPosition(AbstractButton.CENTER);
    mortarButton.setVerticalTextPosition(AbstractButton.BOTTOM);
    mortarButton.setIcon(new ImageIcon(mortar));
    checker = new pickTower();
    this.setLayout(new GridLayout(2,2));
    this.add(machGunButton);
    this.add(mudGunButton);
    this.add(rocketGunButton);
    this.add(mortarButton);
    this.myTowers = towers;
    machGunButton.addActionListener(checker);
    mudGunButton.addActionListener(checker);
    rocketGunButton.addActionListener(checker);
    mortarButton.addActionListener(checker);
  }
  public class pickTower implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getSource().equals(machGunButton)){
        if(player.getMoney() >= 150){
          myTowers.add(new MachineGunLevel1(5000,5000));
          player.takeMoney(150);
        }
      }else if(e.getSource().equals(mudGunButton)){
        if(player.getMoney() >= 200){
          myTowers.add(new MudTowerLevel1(4000,4000));
          player.takeMoney(200);
        }
      }else if(e.getSource().equals(rocketGunButton)){
        if(player.getMoney() >= 400){
          myTowers.add(new RocketLauncherLevel1(6000,6000));
          player.takeMoney(400);
        }
      }else if(e.getSource().equals(mortarButton)){
        if(player.getMoney() >= 300){
          myTowers.add(new MortarLevel1(7000,7000));
          player.takeMoney(300);
        }
      }
    }                                                                              
  }
}

class upgradePanel extends JPanel{
  JButton upgrade1 = new JButton("Upgrade 1");
  JButton upgrade2 = new JButton("Upgrade 2");
  JButton upgrade3 = new JButton("Upgrade 3");
  upgradeListener checkUpgrade = new upgradeListener();
  Player user;
  ArrayList<Tower> myTowers;
  nemesisMap map;
  upgradePanel(Player user, ArrayList<Tower> towers, nemesisMap gameMap){
    this.setLayout(new GridLayout(1,3));
    this.add(upgrade1);
    this.add(upgrade2);
    this.add(upgrade3);
    upgrade1.addActionListener(checkUpgrade);
    upgrade2.addActionListener(checkUpgrade);
    upgrade3.addActionListener(checkUpgrade);
    this.user = user;
    this.myTowers = towers;
    this.map = gameMap;
  }
  private class upgradeListener implements ActionListener{
    /**
     * actionPerformed
     * @Override
     * This method accepts an action event and then based on what button is clicked, and a tower is upgraded
     * @param ActionEvent
     * @return void function
     */
    public void actionPerformed(ActionEvent e){
      int MG2Price = 200;
      int MT2Price = 200;
      int M2Price = 300;
      int RL2Price = 400;
      int MG3Price = 300;
      int MT3Price = 300;
      int M3Price = 400;
      int RL3Price = 500;
      int MG4Price = 400;
      int MT4Price = 400;
      int M4Price = 500;
      int RL4Price = 600;
      if(e.getSource().equals(upgrade1)){ 
       
        if (myTowers.get(map.getSelectedTower()) instanceof MachineGunLevel1){ // if selected tower is a machinegun at level 1
          if (user.getMoney() > MG2Price ){ //if sufficiet money 
            myTowers.add(new MachineGunLevel2(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY() )); // add new upgraded tower 
            myTowers.remove(map.getSelectedTower()); //remove old tower 
            myTowers.get(myTowers.size() -1).setMoveable(false); //set to the old location (cannot be replaced)
            user.takeMoney(MG2Price); //decreases money from the user 
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof MudTowerLevel1){
          if (user.getMoney() > MT2Price ){
            myTowers.add(new MudTowerLevel2(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY()  ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(MT2Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof MortarLevel1){
          if (user.getMoney() > M2Price ){
            myTowers.add(new MortarLevel2(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY()  ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(M2Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof RocketLauncherLevel1){
          if (user.getMoney() > RL2Price ){
            myTowers.add(new RocketLauncherLevel2(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY() ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(RL2Price);
          }
        }
        
      }else if(e.getSource().equals(upgrade2)){
        
        if (myTowers.get(map.getSelectedTower()) instanceof MachineGunLevel2){
          if (user.getMoney() > MG3Price ){
            myTowers.add(new MachineGunLevel3(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY()  ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(MG3Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof MudTowerLevel2){
          if (user.getMoney() > MT3Price ){
            myTowers.add(new MudTowerLevel3(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY()));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(MT3Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof MortarLevel2){
          if (user.getMoney() > M3Price ){
            myTowers.add(new MortarLevel3(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY() ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(M3Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof RocketLauncherLevel2){
          if (user.getMoney() > RL3Price ){
            myTowers.add(new RocketLauncherLevel3(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY()  ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(RL3Price);
          }
        }
        
        
      }else if(e.getSource().equals(upgrade3)){
        
        if (myTowers.get(map.getSelectedTower()) instanceof MachineGunLevel3){
          if (user.getMoney() > MG4Price ){
            myTowers.add(new MachineGunLevel4(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY() ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(MG4Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof MudTowerLevel3){
          if (user.getMoney() > MT4Price ){
            myTowers.add(new MudTowerLevel4(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY() ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(MT4Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof MortarLevel3){
          if (user.getMoney() > M4Price ){
            myTowers.add(new MortarLevel4(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY() ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(M4Price);
          }
        }else if (myTowers.get(map.getSelectedTower()) instanceof RocketLauncherLevel3){
          if (user.getMoney() > RL4Price ){
            myTowers.add(new RocketLauncherLevel4(myTowers.get(map.getSelectedTower()).getX(),myTowers.get(map.getSelectedTower()).getY()  ));
            myTowers.remove(map.getSelectedTower());
            myTowers.get(myTowers.size() -1).setMoveable(false);
            user.takeMoney(RL4Price);
          }
        }
        
        
        
      }
    }
  }
}

class mapPanel extends JPanel{
   Image nemesis = Toolkit.getDefaultToolkit().getImage("Nemesis.jpg");
  Image elysium = Toolkit.getDefaultToolkit().getImage("Elysium.jpg");
  Image thunderBase = Toolkit.getDefaultToolkit().getImage("ThunderBase.jpg");
  Image towerPanelBackground = Toolkit.getDefaultToolkit().getImage("TowerPanelBackground.jpg");
  mapPanel(){
    this.setVisible(true);
    this.setLayout(new FlowLayout());
  }
    /**
   * paintComponent
   * @Override
   * This method accepts a graphics object and then draws the layout
   * @param Graphics
   * @return void function
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(towerPanelBackground, 0, 0 , 1920, 1080, this);
    g.drawImage(nemesis,100,100,500,700,this);
    g.setFont(new Font("Garamond", Font.BOLD, 50));
    g.drawString("Nemesis",200,300);
    g.drawImage(elysium,700,100,500,700,this);
    g.drawString("Elysium",800,200);
    g.drawImage(thunderBase,1300,100,500,700,this);
    g.setColor(new Color(255,255,255));
    g.drawString("Thunder Base",1390,200);
  }
}
class tutorialPanel extends JPanel{
  Rectangle exitButton = new Rectangle(50,50,100,100);
  Image tutorialPanelBackground;
  tutorialPanel(){
    this.setVisible(true);
    tutorialPanelBackground = Toolkit.getDefaultToolkit().getImage("TutorialPanelBackground.jpg");
  }
    /**
   * paintComponent
   * @Override
   * This method accepts a graphics object and then draws the screen with the appropriate text
   * @param Graphics
   * @return void function
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Color myWhite = new Color(255, 255, 255);
    g.drawImage(tutorialPanelBackground, 0, 0 , 1920, 1080, this);
    g.setColor(myWhite);
    g.setFont(new Font("Garamond", Font.BOLD, 70));
    g.drawString("Tutorial",650,200);
    g.setFont(new Font("Serif", Font.BOLD, 30));
    g.drawString("The way this game works is by placing towers on the screen, anywhere except the roads", 100, 500);
    g.drawString("The enemies follow a strategic path and will try to reach the end. Based on your tower's position", 100,570);
    g.drawString("the enemies will be shot at. You can upgrade towers and also add extra towers to prevent enemies from reaching your base.",100,640);
    g.setColor(new Color(255,255,204));
    g.fillRect((int)exitButton.getX(), (int)exitButton.getY(), (int)exitButton.getWidth(), (int)exitButton.getHeight());
    g.setColor(myWhite);
    g.setFont(new Font("Garamond", Font.BOLD, 18));
    g.setColor(new Color(0,0,0));
    g.drawString("Main Menu",(int) exitButton.getX() + ((int) exitButton.getWidth()/2) -48, (int) exitButton.getY() +((int) exitButton.getHeight()/2));
  }
}
class aboutPanel extends JPanel{
 Rectangle exitButton = new Rectangle(50,50,100,100);
  Image aboutPanelBackground;
  aboutPanel(){
    this.setVisible(true);
    aboutPanelBackground = Toolkit.getDefaultToolkit().getImage("AboutPanelBackground.jpg");
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(aboutPanelBackground,0,0,1920,1080, this);
    g.fillRect((int)exitButton.getX(), (int)exitButton.getY(), (int) exitButton.getWidth(), (int) exitButton.getHeight());
    g.setFont(new Font("Garamond", Font.BOLD, 70));
    g.drawString("About Us",500,200);
    g.setFont(new Font("Serif", Font.BOLD, 30));
    g.drawString("Developers: Aziz Safri and Seyedali Meshkatosadat", 500, 500);
    g.drawString("Images: Found off of internet", 500, 570);
    g.drawString("Date: June 2017", 500, 640);
    g.setColor(new Color(255, 255, 255));
    g.setFont(new Font("Garamond", Font.BOLD, 18));
    g.drawString("Main Menu",(int) exitButton.getX() + ((int) exitButton.getWidth()/2) -48, (int) exitButton.getY() +((int) exitButton.getHeight()/2));
  }
}


class infoPanel extends JPanel{
  Player user;
  infoPanel(Player user){
    this.setVisible(true);
    this.setPreferredSize(new Dimension(50,50));
    this.user = user;
  }
      /**
   * paintComponent
   * @Override
   * This method draws the health and the wealth of the player
   * @param Graphics
   * @return void function
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setFont(new Font("Garamond", Font.BOLD, 18));
    g.drawString("Health:" + user.getHealth(), 700, 30);
    g.drawString("Wealth:" + user.getMoney(), 900, 30);
    repaint();
  }
}

class nemesisMap extends JPanel{
  Scanner fileReader =null;
  ArrayList<Enemy> enemies;
  Rectangle beginButton;
  char[][] map;
  Image terrain;
  ArrayList<Tower> myTowers;
  boolean begin;
  boolean beginWave;
  checkMotion mover;
  checkTowerClickListener clickChecker;
  Clock myClock;
  FrameRate myFrameRate;
  int selectedTower; // index of the tower that is selected in the arraylist 
  int waveNum; //shows the wave number 
  ArrayList<Bullet> bullets; 
  Player player;
  int count;
  //x,y coordinate of the starting location of enemies in each map
  int startingX;  
  int startingY;
  
  nemesisMap(ArrayList<Tower> towers, Player player){
    this.player = player;
    bullets = new ArrayList<Bullet>();
    enemies = new ArrayList<Enemy>();
    myClock = new Clock();//
    myFrameRate = new FrameRate();//
    beginButton = new Rectangle(400,0,200,100);//
    beginWave = false;//
    waveNum = 1;
    mover = new checkMotion();
    clickChecker = new checkTowerClickListener();
    this.addMouseListener(clickChecker);
    this.addMouseMotionListener(mover);
    if (mapChooser.getMapChosen() == 1){
      startingX = 0;
      startingY = 120;      
      terrain = Toolkit.getDefaultToolkit().getImage("nemesisGround.jpg");
      try{
        fileReader = new Scanner(new File("Nemesis.txt"));
      }catch(Exception e){e.printStackTrace();};
    }else if (mapChooser.getMapChosen() == 2){     
      startingX = 2 * Enemy.hor - Enemy.hor/2 -10;
      startingY = 0;   
      terrain = Toolkit.getDefaultToolkit().getImage("junlgeTerrain.jpg");
      try{
        fileReader = new Scanner(new File("Elysium.txt"));
      }catch(Exception e){e.printStackTrace();};
    }else{
      startingX = 6 * Enemy.hor - Enemy.hor/2 -10;
      startingY = 0;   
      terrain = Toolkit.getDefaultToolkit().getImage("snowTerrain.jpg");
      try{
        fileReader = new Scanner(new File("thunderBase.txt"));
      }catch(Exception e){e.printStackTrace();};
    }
    begin = false;
    myTowers = towers;
     
    int rows = fileReader.nextInt();
    int columns = fileReader.nextInt();
    
    map = new char[rows][columns];
    fileReader.nextLine();
    
    for(int i = 0; i<= rows-1; i++){    
      String temp = fileReader.nextLine();
      for(int j = 0; j <=columns-1 ; j++){
        map[i][j] = temp.charAt(j);
      }
    }
    
    
    this.setPreferredSize(new Dimension(1000,1000));
    
    
  } // end of constructor 
  
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    if(player.getHealth() == -100){ // if player lost (set to -100 later on if no lives left)
      try {
        Thread.sleep(3000);
      } catch (InterruptedException ie){}
      
      System.exit(0); //ends program
    }else if(player.getHealth() == 99){ //if player has 99 lives(set to 99 when max wave reached)
      g.setColor(new Color(255,255,255));
      g.setFont(new Font("Garamond",Font.BOLD,100));
      g.drawString("Amazing, you win!!",300,400);
      player.setHealth(100); //sets to 100 so the messages will be repainted and theen end game

    }else if(player.getHealth() == 100){
      
      try {
        Thread.sleep(3000);
      } catch (InterruptedException ie){}
      
      System.exit(0); //ends program
    }
    
    
    //draws the map 

    count++;
    for(int i=0; i<= map.length-1; i++){
      for(int j=0; j<= map[0].length-1; j++){
        if(map[i][j] == '1'){
          g.setColor(new Color(0,0,0)); // black colour
          g.fillRect( i*150,j*60, 150,60); //road

        }else{
          g.drawImage(terrain, i*150,j*60, 150,60, this);
        }
      }
    }//

    //diplays the towers and runs shoot 
    for(int i = 0; i<= myTowers.size()-1; i++){
      
      if(myTowers.get(i) instanceof MachineGunLevel1){ //if a machineGunlevel1
        g.drawImage(((MachineGunLevel1)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);   //display   
        ((MachineGunLevel1)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime());//run shoot
      }else if(myTowers.get(i) instanceof MachineGunLevel2){
        ((MachineGunLevel2)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime());
        g.drawImage(((MachineGunLevel2)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MachineGunLevel3){
        ((MachineGunLevel3)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime());
        g.drawImage(((MachineGunLevel3)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MachineGunLevel4){
        ((MachineGunLevel4)myTowers.get(i)).shoot(enemies, bullets, myClock.getElapsedTime());
        g.drawImage(((MachineGunLevel4)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof RocketLauncherLevel1){
        ((RocketLauncherLevel1)myTowers.get(i)).shoot(enemies, bullets, myClock.getElapsedTime());
        g.drawImage(((RocketLauncherLevel1)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof RocketLauncherLevel2){
        ((RocketLauncherLevel2)myTowers.get(i)).shoot(enemies, bullets, myClock.getElapsedTime());
        g.drawImage(((RocketLauncherLevel2)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof RocketLauncherLevel3){
        ((RocketLauncherLevel3)myTowers.get(i)).shoot(enemies, bullets, myClock.getElapsedTime());
        g.drawImage(((RocketLauncherLevel3)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof RocketLauncherLevel4){
        ((RocketLauncherLevel4)myTowers.get(i)).shoot(enemies, bullets, myClock.getElapsedTime());
        g.drawImage(((RocketLauncherLevel4)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MudTowerLevel1){
        ((MudTowerLevel1)myTowers.get(i)).shoot(enemies, myClock.getElapsedTime());
        g.drawImage(((MudTowerLevel1)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MudTowerLevel2){
        ((MudTowerLevel2)myTowers.get(i)).shoot(enemies, myClock.getElapsedTime());
        g.drawImage(((MudTowerLevel2)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MudTowerLevel3){
        ((MudTowerLevel3)myTowers.get(i)).shoot(enemies, myClock.getElapsedTime());
        g.drawImage(((MudTowerLevel3)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MudTowerLevel4){
        ((MudTowerLevel4)myTowers.get(i)).shoot(enemies, myClock.getElapsedTime());
        g.drawImage(((MudTowerLevel4)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MortarLevel1){
        ((MortarLevel1)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime());
        g.drawImage(((MortarLevel1)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MortarLevel2){
        ((MortarLevel2)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime());
        g.drawImage(((MortarLevel2)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MortarLevel3){
        ((MortarLevel3)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime());
        g.drawImage(((MortarLevel3)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }else if(myTowers.get(i) instanceof MortarLevel4){
        ((MortarLevel4)myTowers.get(i)).shoot(enemies, bullets,myClock.getElapsedTime() );
        g.drawImage(((MortarLevel4)(myTowers.get(i))).getImage(),myTowers.get(i).getX(), myTowers.get(i).getY(), Tower.getWidth(), Tower.getWidth(), this);          
      }

    }
    
   //runs bullets
   if (bullets.size() != 0){
     for (int i = 0; i < bullets.size(); i++){
       if (!bullets.get(i).getReachedTarget()){
         bullets.get(i).update(myClock.elapsedTime); //updates location 
         bullets.get(i).draw(g);  //draws on screen 
         if (bullets.get(i).getReachedTarget()){  //removes if reached target
           bullets.remove(i);
         }
       }
     }
   }
    
    //moves/displays the enemies on map 
    if (beginWave){   //if during wave
      for(int i = 0; i<= enemies.size() -1; i++){
        
        enemies.get(i).move(myClock.getElapsedTime()); //updates coordinates 

        //draw based on type
        if (enemies.get(i) instanceof Car){
          g.drawImage(((Car)(enemies.get(i))).getImage(), (int)enemies.get(i).getX(), (int)enemies.get(i).getY(), 30,30, this);//draws
        }else if (enemies.get(i) instanceof Tank){
          g.drawImage(((Tank)(enemies.get(i))).getImage(), (int)enemies.get(i).getX(), (int)enemies.get(i).getY(), 30,30, this);//draws
        }else if (enemies.get(i) instanceof Helicopter){
          g.drawImage(((Helicopter)(enemies.get(i))).getImage(), (int)enemies.get(i).getX(), (int)enemies.get(i).getY(), 30,30, this);//draws
        }else {
          g.drawImage(((Plane)(enemies.get(i))).getImage(), (int)enemies.get(i).getX(), (int)enemies.get(i).getY(), 30,30, this);//draws
        }
        
        enemies.get(i).healthBar(g); //displays the health bars
        
        //removes if reached end 
        if(enemies.get(i).getReachedEnd()){
          enemies.remove(i);
          player.takeHealth(1);
        }else if (enemies.get(i).getHealth()<= 0){
          enemies.remove(i);
          player.addMoney(10);
        }
        
        //shows loss if no healths + ends program 
        if (player.getHealth() <= 0){
          //draws message on screen
          g.setColor(new Color(255,255,255));
          g.setFont(new Font("Garamond",Font.BOLD,100));
          g.drawString("No lives left! You Lose!",300,400);
          player.setHealth(-100); //sets to -100 so the next loop the game will end
        } 
      }
      
      if (enemies.size() == 0) {//if no more enemies (dead or reached end)
        beginWave = false; //ends wave
      }
    }
    
    //adds enemies to list 
    if (!beginWave){
      waves(enemies, waveNum, startingX, startingY);
    }
    
    
    myClock.update(); //updates clock 
    myFrameRate.update(); //updates frame rate
    
    
    //begin wave button + fps display
    g.setColor(new Color(0,0,0)); 
    g.fillRect(0,0,60,40); //rect behind fps
    g.setColor(new Color(0,0,0));
    g.fillRect((int)beginButton.getX(),(int)beginButton.getY(), (int)beginButton.getWidth(), (int)beginButton.getHeight());//rect of beign wave
    g.setColor(new Color(255,255,255));
    g.setFont(new Font("Garamond",Font.BOLD,30));
    g.drawString("Begin Wave",(int)beginButton.getX() + (int)(beginButton.getWidth()/2) - 70, (int)beginButton.getY() + (int)(beginButton.getHeight()/2));

    g.setColor(new Color(0,0,255));
    g.setFont(new Font("Garamond",Font.BOLD,20));
    myFrameRate.draw(g,2,23);//draws fps
    
    
    
    selectTower(myTowers, selectedTower,  g); //runs select tower
    
    
    repaint(); 
  }
  
  
 /*selectTower
  * Ali Meshkat 
  * takes in the towers, the selectedslot(i), and graphics 
  * displays the range of the tower showing it is selected 
  */
  void selectTower(ArrayList<Tower> towers,int i, Graphics g){
    // i is the selcted slot (index)
    if(i < towers.size()){
      g.drawOval(towers.get(i).getX()-towers.get(i).getRange()/2 + Tower.getWidth()/2,
                 towers.get(i).getY()-towers.get(i).getRange()/2+ Tower.getWidth()/2, 
                 towers.get(i).getRange(),towers.get(i).getRange() );
    }
  }
  
 /*
  * waves
  * Ali Meshkat 
  * takes in the enemies, wave number and start x,y coordinates for each map
  * addds a new and more difficult set  of enemies to the list based on the waveNUm
  */
  void waves(ArrayList<Enemy> enemies, int waveNum, int startingX, int startingY ){
    int healthChangePerWave = 30; //the number the healths of enemies increase by everyround

    if(enemies.size() == 0){ //waits for wave to end
      if (mapChooser.getMapChosen() == 1){ //chekcs which map
        if (waveNum == 1){ //first wave 
          for(int i = 0; i <= 20; i++){
            enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
          }
        }
        else if(waveNum == 2){
          for(int i = 0; i <= 20; i++){
            if (i <= 19){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }
          }
        }else if (waveNum ==3){
          for(int i = 0; i <= 20; i++){
            if (i <= 15){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }
          }        
        }else if (waveNum ==4){
          for(int i = 0; i <= 30; i++){
            if (i <= 15){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else if (i <= 20){
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Helicopter(startingX-i*50,startingY,200 + waveNum * healthChangePerWave));
            }          
          }        
        }else if (waveNum ==5){
          for(int i = 0; i <= 30; i++){
            if (i <= 10){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX-i*50,startingY,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX-i*50,startingY,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==6){
          for(int i = 0; i <= 30; i++){
            
            enemies.add(new Tank(startingX-i*50,startingY,400 + waveNum * healthChangePerWave));
            
          }        
        }else if (waveNum ==7){
          for(int i = 0; i <= 30; i++){
            if (i <= 5){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX-i*50,startingY,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX-i*50,startingY,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==8){
          for(int i = 0; i <= 45; i++){
            if (i <= 15){
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }else if (i <= 30){
              enemies.add(new Helicopter(startingX-i*50,startingY,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX-i*50,startingY,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==9){
          for(int i = 0; i <= 50; i++){
            if (i <= 10){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX-i*50,startingY,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX-i*50,startingY,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX-i*50,startingY,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==10){
          for(int i = 0; i <= 60; i++){
            if (i <= 10){
              enemies.add(new Car(startingX- i * 50,startingY ,100 + waveNum * healthChangePerWave));
            }else if (i <= 35){
              enemies.add(new Tank(startingX- i * 50,startingY ,300 + waveNum * healthChangePerWave));
            }else if (i <= 45){
              enemies.add(new Helicopter(startingX- i * 50,startingY ,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX- i * 50,startingY ,700 + waveNum * healthChangePerWave));
            }    
          }
        }else{

          player.setHealth(99);//sets to 99 so victory message will be displayed next loop
        }
        
        
      }else if (mapChooser.getMapChosen() == 2){
        if (waveNum == 1){
          
          for(int i = 0; i <= 20; i++){

            enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));

          }
        }
        else if(waveNum == 2){
          for(int i = 0; i <= 20; i++){
            if (i <= 19){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }
          }
        }else if (waveNum ==3){
          for(int i = 0; i <= 20; i++){
            if (i <= 15){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }
          }        
        }else if (waveNum ==4){
          for(int i = 0; i <= 30; i++){
            if (i <= 15){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 20){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }          
          }        
        }else if (waveNum ==5){
          for(int i = 0; i <= 30; i++){
            if (i <= 10){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==6){
          for(int i = 0; i <= 30; i++){
            
            enemies.add(new Tank(startingX, startingY - i * 50,400 + waveNum * healthChangePerWave));
            
          }        
        }else if (waveNum ==7){
          for(int i = 0; i <= 30; i++){
            if (i <= 5){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==8){
          for(int i = 0; i <= 45; i++){
            if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 30){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==9){
          for(int i = 0; i <= 50; i++){
            if (i <= 10){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==10){
          for(int i = 0; i <= 60; i++){
            if (i <= 10){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 35){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 45){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }
        }else{
          player.setHealth(99);//sets to 99 so victory message will be displayed next loop
        }
        
        
      }else{
        if (waveNum == 1){
          
          for(int i = 0; i <= 20; i++){
            if (i <= 40){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX, startingY - i * 50,500));
            }
          }
        }
        else if(waveNum == 2){
          for(int i = 0; i <= 20; i++){
            if (i <= 19){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }
          }
        }else if (waveNum ==3){
          for(int i = 0; i <= 20; i++){
            if (i <= 15){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }
          }        
        }else if (waveNum ==4){
          for(int i = 0; i <= 30; i++){
            if (i <= 15){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 20){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else{
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }          
          }        
        }else if (waveNum ==5){
          for(int i = 0; i <= 30; i++){
            if (i <= 10){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==6){
          for(int i = 0; i <= 30; i++){
            
            enemies.add(new Tank(startingX, startingY - i * 50,400 + waveNum * healthChangePerWave));
            
          }        
        }else if (waveNum ==7){
          for(int i = 0; i <= 30; i++){
            if (i <= 5){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==8){
          for(int i = 0; i <= 45; i++){
            if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 30){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==9){
          for(int i = 0; i <= 50; i++){
            if (i <= 10){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 15){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 25){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }        
        }else if (waveNum ==10){
          for(int i = 0; i <= 60; i++){
            if (i <= 10){
              enemies.add(new Car(startingX, startingY - i * 50 ,100 + waveNum * healthChangePerWave));
            }else if (i <= 35){
              enemies.add(new Tank(startingX, startingY - i * 50,300 + waveNum * healthChangePerWave));
            }else if (i <= 45){
              enemies.add(new Helicopter(startingX, startingY - i * 50,200 + waveNum * healthChangePerWave));
            }else {
              enemies.add(new Plane(startingX, startingY - i * 50,700 + waveNum * healthChangePerWave));
            }    
          }   
        }else{
          player.setHealth(99);//sets to 99 so victory message will be displayed next loop
        }
        
        
      }
   
    }
  }
  
  
  private class checkMotion implements MouseMotionListener{
    public void mouseMoved(MouseEvent e){
      if(myTowers.size() > 0){
        if(myTowers.get(myTowers.size()-1).getMoveable() == true){ //checks last index to see if a tower is added(are iniatialy set to moveable when bought)
          myTowers.get(myTowers.size()-1).setX(e.getPoint().x);
          myTowers.get(myTowers.size()-1).setY(e.getPoint().y);
        }
      }
    }
    public void mouseDragged(MouseEvent e){
    }
  }
  private class checkTowerClickListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
      if(myTowers.size() > 0){
        if(myTowers.get(myTowers.size()-1).getMoveable()){ //if just bought (moveable)

              myTowers.get(myTowers.size()-1).setX(e.getPoint().x); //places when click 
              myTowers.get(myTowers.size()-1).setY(e.getPoint().y);
              myTowers.get(myTowers.size()-1).setMoveable(false);          
          
        }
      }
      
      //being wave button 
      if(e.getX() >= (int) beginButton.getX() && e.getX() <= (int)(beginButton.getX() + beginButton.getWidth()) && e.getY() >= (int) beginButton.getY() && e.getY() <= (int)(beginButton.getY() + beginButton.getHeight()) && beginWave == false){
        beginWave = true;
        waveNum++;
        player.addMoney(200); //awards money for evey wave including 1
      }
      
      
      // finds which tower is selected (clicked)
      //will then be used in void selecTower() andd upgrade
      boolean setToNew = false;
      for(int i = 0; i <= myTowers.size()-1; i ++){
        if(e.getX() >= myTowers.get(i).getX() && e.getX() <= (myTowers.get(i).getX() + Tower.getWidth()) && e.getY() >= myTowers.get(i).getY() && e.getY() <= (myTowers.get(i).getY() + Tower.getWidth())){ // if clicked on tower 
          selectedTower = i; // sets it to the index of the arraylist 
          setToNew = true;
        }else if (!setToNew){ //if no towers are selected 
          selectedTower = myTowers.size();
        }
      }
 
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    } 
    

    
  }

  ///getter for selected tower 
  public int getSelectedTower(){
    return this.selectedTower;
  }
  public void setSelectedTower(int s){
    this.selectedTower = s;
  }



}






//////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
