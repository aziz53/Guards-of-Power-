/* [Car.java]
 * Seyedali Meshkatosadat
 * Car obejects that extend enemies 
 * are the easiest type of enemy and found in early game
 * June 14, 2017
 */
import java.lang.Math; 
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
class Car extends Enemy{
  private static Image image;
  
  Car(int x, int y,int health){//takes in difficulty and determines health (already stored)
    super(x, y,health);
    image = Toolkit.getDefaultToolkit().getImage("car90.png");

    
  }
  

    /*move 
   * Ali Meshkat 
   * this method takes in the elapsed time
   * it updates the x and y of enemies based on the predefined coordinates using ifs for each map
   * it also updates the sprite of the tower bassed on the diretion of movement 
   */
  void move(double elapsedTime){ 
    if (mapChooser.getMapChosen() == 1){ // if map 1 chosen 
      if (super.getX() <10 * hor - hor/2 -10&& super.getY() == 2  * ver ){ //condition that will 
        super.setX(super.getX() + 1 * elapsedTime*100);//first turn
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 10 * hor - hor/2-10){
          super.setX(10*hor - hor/2-10);
        }
      }else if (Math.floor(super.getX())  == 10  * hor  - hor/2-10 && super.getY() < 14 * ver - ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reached second turn 
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 14 * ver - ver/2  -10|| Math.floor(super.getY()) == 14 * ver - ver/2 -10|| Math.ceil(super.getY()) == 14 * ver - ver/2 -10){
          super.setY(14*ver - ver/2 -10);
        }
      }else if (super.getX() > 5 * hor  - hor/2 -10&& Math.round(super.getY()) == 14  * ver- ver/2 -10){
        super.setX(super.getX() - 1 * elapsedTime*100);//reached turn 3   
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 5 * hor - hor/2  -10|| Math.floor(super.getX()) == 5 * hor - hor/2 -10|| Math.ceil(super.getX()) == 5 * hor - hor/2 -10){
          super.setX(5*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 5* hor - hor/2-10 && super.getY()  > 12  * ver- ver/2 -10){
        super.setY(super.getY() - 1 * elapsedTime*100);//reached turn 4
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 12 * ver - ver/2  -10|| Math.floor(super.getY()) == 12 * ver - ver/2 -10|| Math.ceil(super.getY()) == 12 * ver - ver/2 -10){
          super.setY(12*ver - ver/2 -10);
        }
      }else if (super.getX()< 8  * hor  - hor/2 -10&& Math.round(super.getY()) == 12 * ver- ver/2 -10 && super.getX() > 3.5 * hor +1 ){// extra && is to avoid this from being true at the wrong time
        super.setX(super.getX() + 1 * elapsedTime*100);//reached turn 5
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 8 * hor - hor/2  -10|| Math.floor(super.getX()) == 88 * hor - hor/2 -10|| Math.ceil(super.getX()) == 8 * hor - hor/2 -10){
          super.setX(8*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 8 * hor - hor/2-10 && super.getY() > 5 * ver- ver/2 -10){
        super.setY(super.getY() - 1 * elapsedTime*100);//reached turn 6
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 5 * ver - ver/2  -10|| Math.floor(super.getY()) == 5 * ver - ver/2 -10|| Math.ceil(super.getY()) == 5 * ver - ver/2 -10){
          super.setY(5*ver - ver/2 -10);
        }
      }else if (super.getX()  > 5 * hor  - hor/2 -10&& Math.round(super.getY()) == 5 * ver- ver/2 -10){
        super.setX(super.getX() - 1 * elapsedTime*100);//reached turn 7
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 5 * hor - hor/2  -10|| Math.floor(super.getX()) == 5 * hor - hor/2 -10|| Math.ceil(super.getX()) == 5 * hor - hor/2 -10){
          super.setX(5*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 5  * hor - hor/2-10 && super.getY() < 7 * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reached turn 8
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 7 * ver - ver/2  -10|| Math.floor(super.getY()) == 7 * ver - ver/2 -10|| Math.ceil(super.getY()) == 7 * ver - ver/2 -10){
          super.setY(7*ver - ver/2 -10);
        }
      }else if (super.getX()  < 6 * hor - hor/2 -10&&Math.round(super.getY()) == 7 * ver - ver/2 -10){
        super.setX(super.getX() + 1 * elapsedTime*100);//reached turn 9
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 6 * hor - hor/2  -10|| Math.floor(super.getX()) == 6 * hor - hor/2 -10|| Math.ceil(super.getX()) == 6 * hor - hor/2 -10){
          super.setX(6*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX())  ==6  * hor - hor/2 -10&& super.getY()< 10 * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reached turn 10
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 10 * ver - ver/2  -10|| Math.floor(super.getY()) == 10 * ver - ver/2 -10|| Math.ceil(super.getY()) == 10 * ver - ver/2 -10){
          super.setY(10*ver - ver/2 -10);
        }
      }else if (super.getX()  > 3 * hor  - hor/2 -10&& Math.round(super.getY()) == 10 * ver- ver/2 -10){
        super.setX(super.getX() - 1 * elapsedTime*100);//reached turn 11        
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 3 * hor - hor/2  -10|| Math.floor(super.getX()) == 3 * hor - hor/2 -10|| Math.ceil(super.getX()) == 3 * hor - hor/2 -10){
          super.setX(3*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 3  * hor - hor/2 -10&& super.getY() < 17 * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reached END        
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 17 * ver - ver/2  -10|| Math.floor(super.getY()) == 17 * ver - ver/2 -10|| Math.ceil(super.getY()) == 17 * ver - ver/2 -10){
          super.setY(17*ver - ver/2 -10);
          super.setReachedEnd(true);
        }
      }

    }else if (mapChooser.getMapChosen() == 2){
      if (super.getX() == 2 * hor - hor/2 -10 && super.getY() < 12 * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//first turn
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 12 * ver - ver/2-10){
          super.setY(12*ver - ver/2-10);
        }
      }else if (super.getX() < 4 * hor  - hor/2 -10&& Math.round(super.getY()) == 12  * ver- ver/2 -10){
        super.setX(super.getX() + 1 * elapsedTime*100);
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 4 * hor - hor/2  -10|| Math.floor(super.getX()) == 4 * hor - hor/2 -10|| Math.ceil(super.getX()) == 4 * hor - hor/2 -10){
          super.setX(4*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 4 * hor - hor/2-10 && super.getY()  > 9  * ver- ver/2 -10){
        super.setY(super.getY() - 1 * elapsedTime*100);//reached third turn 
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 9 * ver - ver/2  -10|| Math.floor(super.getY()) == 9 * ver - ver/2 -10|| Math.ceil(super.getY()) == 9 * ver - ver/2 -10){
          super.setY(9*ver - ver/2 -10);
        }
      }else if (super.getX()< 9  * hor  - hor/2 -10&& Math.round(super.getY()) == 9 * ver- ver/2 -10 ){//&& super.getX() > 3.5 * hor +1 ){// extra && is to avoid this from being true at the wrong time
        super.setX(super.getX() + 1 * elapsedTime*100);//reached turn 4
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 9 * hor - hor/2  -10|| Math.floor(super.getX()) == 9 * hor - hor/2 -10|| Math.ceil(super.getX()) == 9 * hor - hor/2 -10){
          super.setX(9*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 9 * hor - hor/2-10 && super.getY() < 11 * ver- ver/2 -10 && super.getY() > 8 * ver - ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reahced turn 5
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 11 * ver - ver/2  -10|| Math.floor(super.getY()) == 11 * ver - ver/2 -10|| Math.ceil(super.getY()) == 11 * ver - ver/2 -10){
          super.setY(11*ver - ver/2 -10);
        }
      }else if (super.getX()  > 6 * hor  - hor/2 -10&& Math.round(super.getY()) == 11 * ver- ver/2 -10&& super.getX()<10* hor - hor/2 - 10){
        super.setX(super.getX() - 1 * elapsedTime*100);//reahced turn 6
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 6 * hor - hor/2  -10|| Math.floor(super.getX()) == 6 * hor - hor/2 -10|| Math.ceil(super.getX()) == 6 * hor - hor/2 -10){
          super.setX(6*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 6  * hor - hor/2-10 && super.getY() < 14 * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reached 7
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 14 * ver - ver/2  -10|| Math.floor(super.getY()) == 14 * ver - ver/2 -10|| Math.ceil(super.getY()) == 14 * ver - ver/2 -10){
          super.setY(14*ver - ver/2 -10);
        }
      }else if (super.getX()  < 11 * hor - hor/2 -10&&Math.round(super.getY()) == 14 * ver - ver/2 -10){
        super.setX(super.getX() + 1 * elapsedTime*100);//reached 8
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 11 * hor - hor/2  -10|| Math.floor(super.getX()) == 11 * hor - hor/2 -10|| Math.ceil(super.getX()) == 11 * hor - hor/2 -10){
          super.setX(11*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX())  ==11  * hor - hor/2 -10&& super.getY() > 7 * ver- ver/2 -10 ){
        super.setY(super.getY() - 1 * elapsedTime*100);//reached 9   right direction 
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 7 * ver - ver/2  -10|| Math.floor(super.getY()) == 7 * ver - ver/2 -10|| Math.ceil(super.getY()) == 7 * ver - ver/2 -10){
          super.setY(7*ver - ver/2 -10);
        }
      }else if (super.getX()  > 9 * hor  - hor/2 -10&& Math.round(super.getY()) == 7 * ver- ver/2 -10){
        super.setX(super.getX() - 1 * elapsedTime*100);       // reached 10
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 9 * hor - hor/2  -10|| Math.floor(super.getX()) == 9 * hor - hor/2 -10|| Math.ceil(super.getX()) == 9 * hor - hor/2 -10){
          super.setX(9*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 9  * hor - hor/2 -10&& super.getY() > 6 * ver- ver/2 -10){
        super.setY(super.getY() - 1 * elapsedTime*100);     //reached 11
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 6 * ver - ver/2  -10|| Math.floor(super.getY()) == 6 * ver - ver/2 -10|| Math.ceil(super.getY()) == 6 * ver - ver/2 -10){
          super.setY(6*ver - ver/2 -10);

        }
     }else if (super.getX()  > 7 * hor  - hor/2 -10&& Math.round(super.getY()) == 6 * ver- ver/2 -10){
        super.setX(super.getX() - 1 * elapsedTime*100);       //12
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 7 * hor - hor/2  -10|| Math.floor(super.getX()) == 7 * hor - hor/2 -10|| Math.ceil(super.getX()) == 7 * hor - hor/2 -10){
          super.setX(7*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 7  * hor - hor/2 -10&& super.getY() > 2  * ver- ver/2 -10){
        super.setY(super.getY() - 1 * elapsedTime*100);   //13
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 2 * ver - ver/2  -10|| Math.floor(super.getY()) == 2 * ver - ver/2 -10|| Math.ceil(super.getY()) == 2 * ver - ver/2 -10){
          super.setY(2*ver - ver/2 -10);
        }
     }else if (super.getX()  < 13 * hor  - hor/2 -10&& Math.round(super.getY()) == 2 * ver- ver/2 -10){
        super.setX(super.getX() + 1 * elapsedTime*100);       
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 13 * hor - hor/2  -10|| Math.floor(super.getX()) == 13 * hor - hor/2 -10|| Math.ceil(super.getX()) ==13 * hor - hor/2 -10){
          super.setX(13*hor - hor/2 -10);
          super.setReachedEnd(true);
        }
      }

    } else{
       if (super.getX() == 6 * hor - hor/2 -10 && super.getY() < 5 * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//first turn
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 5 * ver - ver/2-10){
          super.setY(5*ver - ver/2-10);
        }
      }else if (super.getX() > 3 * hor  - hor/2 -10&& Math.round(super.getY()) == 5  * ver- ver/2 -10 && super.getX() < 8 * hor  - hor/2 -10 ){
        super.setX(super.getX() - 1 * elapsedTime*100);//reached 2
        image = Toolkit.getDefaultToolkit().getImage("car180.png");
        if (Math.round(super.getX()) == 3 * hor - hor/2  -10|| Math.floor(super.getX()) == 3 * hor - hor/2 -10|| Math.ceil(super.getX()) == 3 * hor - hor/2 -10){
          super.setX(3*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 3 * hor - hor/2-10 && super.getY()  < 12  * ver- ver/2 -10){
        super.setY(super.getY() + 1 * elapsedTime*100);//reached third turn 
        image = Toolkit.getDefaultToolkit().getImage("car270.png");
        if (Math.round(super.getY()) == 12 * ver - ver/2  -10|| Math.floor(super.getY()) == 12 * ver - ver/2 -10|| Math.ceil(super.getY()) == 12 * ver - ver/2 -10){
          super.setY(12*ver - ver/2 -10);
        }
      }else if (super.getX()< 8  * hor  - hor/2 -10&& Math.round(super.getY()) == 12 * ver- ver/2 -10 ){//&& super.getX() > 3.5 * hor +1 ){// extra && is to avoid this from being true at the wrong time
        super.setX(super.getX() + 1 * elapsedTime*100);//reached turn 4
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 8 * hor - hor/2  -10|| Math.floor(super.getX()) == 8 * hor - hor/2 -10|| Math.ceil(super.getX()) == 8 * hor - hor/2 -10){
          super.setX(8*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 8 * hor - hor/2-10 && super.getY() > 6 * ver- ver/2 -10 ){
        super.setY(super.getY() - 1 * elapsedTime*100);//reahced turn 5
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 6 * ver - ver/2  -10|| Math.floor(super.getY()) == 6 * ver - ver/2 -10|| Math.ceil(super.getY()) == 6 * ver - ver/2 -10){
          super.setY(6*ver - ver/2 -10);
        }
      }else if (super.getX()  < 10 * hor  - hor/2 -10&& Math.round(super.getY()) == 6 * ver- ver/2 -10){
        super.setX(super.getX() + 1 * elapsedTime*100);//reahced turn 6
        image = Toolkit.getDefaultToolkit().getImage("car0.png");
        if (Math.round(super.getX()) == 10 * hor - hor/2  -10|| Math.floor(super.getX()) == 10 * hor - hor/2 -10|| Math.ceil(super.getX()) == 10 * hor - hor/2 -10){
          super.setX(10*hor - hor/2 -10);
        }
      }else if (Math.round(super.getX()) == 10  * hor - hor/2-10 && super.getY() > 0 * ver- ver/2 -10){
        super.setY(super.getY() - 1 * elapsedTime*100);//reached 7
        image = Toolkit.getDefaultToolkit().getImage("car90.png");
        if (Math.round(super.getY()) == 0 * ver - ver/2  -10|| Math.floor(super.getY()) == 0 * ver - ver/2 -10|| Math.ceil(super.getY()) == 0 * ver - ver/2 -10){
          super.setY(0*ver - ver/2 -10);
          super.setReachedEnd(true);
        }
      }
      
        
        
    }
  }
  Image getImage(){
    return image;
  }
}
