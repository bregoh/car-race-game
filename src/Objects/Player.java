package Objects;

import Maincarrace.Assets;
import Maincarrace.Check;
import Maincarrace.MainF;
import Menu_System.Pause;
import System.Vector2F;
import generator.World;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import managers.HudManager;
//import managers.MouseManager;
  
public class Player implements KeyListener {
    
    Vector2F pos;
    private World world;
    
    //set width and height of player
    private int width = 70;
    private int height = 70;
    //y coord to load images form spritesheet to buffered image
    private static int carSpriteY = 0; 
    //values for car animation state
    private static boolean up, down, left, right, upRight;
    //ecs to test if pressed to call pause
    public static boolean esc;
    
    private boolean mapMove = true;
    private float maxSpeed = 5 * 38F;
    
    //speed variables
    private float speedUp = 0;
    private float speedDown = 0;
    private float speedLeft = 0;
    private float speedRight = 0;
    
    private float speed = 56.093F;
    private float fixDt = 1F/60F;
    
    //to check what lap it is 
    private int lap = 0;
    private int lap2 = 0;
    private int lapzero = 0;
    private int lapzero2 = 0;
    
    //for multiplayer
    public static boolean server;
    
    //RENDERING
    private int renderDistanceW = 50;//width of the blocks rendered on screen
    private int renderDistanceH = 28;//height of the blocks rendered on screen
    public static Rectangle render;
    
    //to load different state images for the car
    private BufferedImage carUp, carUpRight, carRight, carDownRight, carDown, carDownLeft, carLeft, carUpLeft;
        
    private int animationState = 0;
	/*
	 * 0 = up
	 * 1 = upright
	 * 2 = right
	 * 3 = downright
	 * 4 = down
	 * 5 = downleft
	 * 6 = left
	 * 7 = upleft
	 */
    
    //calls HUD
    private HudManager hudm;
        
    //constructor
    public Player(boolean main) {
        hudm = new HudManager(this);
        pos = new Vector2F(MainF.width / 2 - width / 2,  MainF.height / 2 - height / 2);
        if(main) {
            server = true;
        }
        if(!main) {
            server = false;
            pos = new Vector2F(MainF.width / 2 - width / 2 + 100,  MainF.height / 2 - height / 2);
        }
    }
    
    //initializes
    public void init(World world) { 
        
        this.world = world;
        
        render = new Rectangle(
                (int) (pos.xpos - pos.getWorldLocation().xpos + pos.xpos - renderDistanceW * 28 / 2 + width / 2), 
                (int) (pos.ypos - pos.getWorldLocation().ypos + pos.ypos - renderDistanceH * 28 / 2 + height / 2), 
                renderDistanceW * 28,
                renderDistanceH * 28);
        
        if(server) {
            carUp = Assets.player.getTile(0, carSpriteY, 64, 64);
            carUpRight = Assets.player.getTile(64, carSpriteY, 64, 64); 
            carRight = Assets.player.getTile(128, carSpriteY, 64, 64); 
            carDownRight = Assets.player.getTile(192, carSpriteY, 64, 64); 
            carDown = Assets.player.getTile(256, carSpriteY, 64, 64);
            carDownLeft = Assets.player.getTile(320, carSpriteY, 64, 64);
            carLeft = Assets.player.getTile(384, carSpriteY, 64, 64);
            carUpLeft = Assets.player.getTile(448, carSpriteY, 64, 64);
        }
        if(!server) {
            carUp = Assets.player.getTile(0, carSpriteY + 64, 64, 64);
            carUpRight = Assets.player.getTile(64, carSpriteY + 64, 64, 64); 
            carRight = Assets.player.getTile(128, carSpriteY + 64, 64, 64); 
            carDownRight = Assets.player.getTile(192, carSpriteY + 64, 64, 64); 
            carDown = Assets.player.getTile(256, carSpriteY + 64, 64, 64);
            carDownLeft = Assets.player.getTile(320, carSpriteY + 64, 64, 64);
            carLeft = Assets.player.getTile(384, carSpriteY + 64, 64, 64);
            carUpLeft = Assets.player.getTile(448, carSpriteY + 64, 64, 64);
        }
    }
    
    //ticks
    public void tick(double deltaTime) {
        
        render = new Rectangle(
                (int) (pos.xpos - pos.getWorldLocation().xpos + pos.xpos - renderDistanceW * 28 / 2 + width / 2), 
                (int) (pos.ypos - pos.getWorldLocation().ypos + pos.ypos - renderDistanceH * 28 / 2 + height / 2), 
                renderDistanceW * 28,
                renderDistanceH * 28);
        
        float moveAmountU = (float)(speedUp * fixDt);
        float moveAmountD = (float)(speedDown * fixDt);
        float moveAmountL = (float)(speedLeft * fixDt);
        float moveAmountR = (float)(speedRight * fixDt);
        
                        
            if(up) {
                if(up && right) {
                    animationState = 1;
                }
                else if (up && left) {
                    animationState = 7;
                }
                else {
                    animationState = 0;
                }
                
                moveMapUp(moveAmountU);
            }
            else {
                moveMapUpGlide(moveAmountU);
            }
            
            if(down) {
                if(down && right) {
                    animationState = 3;
                }
                else if (down && left) {
                    animationState = 5;
                }
                else {
                    animationState = 4;
                }
                
                moveMapDown(moveAmountD);
            }
            else {
                moveMapDownGlide(moveAmountD);
            }

            if(left) {
                if (up && left) {
                    animationState = 7;
                }
                else if (down && left) {
                    animationState = 5;
                }
                else {
                    animationState = 6;
                }
                
                moveMapLeft(moveAmountL);
            }
            else {
                moveMapLeftGlide(moveAmountL);
            }

            if(right) {
                if(up && right) {
                    animationState = 1;
                }
                else if(down && right) {
                    animationState = 3;
                }
                else {
                    animationState = 2;
                }
                
                moveMapRight(moveAmountR);
            }
            else {
                moveMapRightGlide(moveAmountR);
            } 
            
            if(esc) {
                
                Pause pause = new Pause();
                pause.setVisible(true);
                esc = false;
            }
    }
  
    //MAP & PLAYER MOVE METHODS
    public void moveMapUp(float movSpeed) {
        
        if(!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.map_pos.xpos), 
                          (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                new Point ((int) (pos.xpos + world.map_pos.xpos + width), 
                           (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
            
            if(Check.HalfWay(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                        new Point((int) (pos.xpos + world.map_pos.xpos + width), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
                lap = 1;
                lapzero = 1;
            }
            
            if(Check.Finish(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                        new Point((int) (pos.xpos + world.map_pos.xpos + width), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
                if(lap == 1 && lapzero == 1) {
                    lap2 = 1;
                    lapzero2 = 1;
                    if(lap2 == 1) {
                        movSpeed = 0;
                        maxSpeed = 0;
                       
                    }
                }
            }
            
            if(speedUp < maxSpeed) {
                speedUp += speed;
            }
            else {
                speedUp = maxSpeed;
            }
            world.map_pos.ypos -= movSpeed;
        }
        else {
            speedUp = 0;
        }
    }
    
    public void moveMapUpGlide(float movSpeed) {
        if(!Check.CollisionPlayerBlock(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                        new Point((int) (pos.xpos + world.map_pos.xpos + width), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
            
            if(Check.HalfWay(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                        new Point((int) (pos.xpos + world.map_pos.xpos + width), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
                lap = 1;
                lapzero = 1;
            }
            
            if(Check.Finish(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                        new Point((int) (pos.xpos + world.map_pos.xpos + width), 
                                  (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
                if(lap == 1 && lapzero == 1) {
                    lap2 = 1;
                    lapzero2 = 1;
                }
            }
                
                if(speedUp != 0) {
                        speedUp -= speed;
                    if(speedUp < 0) {
                        speedUp = 0;
                    }  
                    world.map_pos.ypos -= movSpeed; 
                }
        }
        else{
            speedUp = 0;
        }
    }
    
    
    public void moveMapDown(float movSpeed) {
        if(!Check.CollisionPlayerBlock(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos + height + movSpeed)),
                        new Point ((int) (pos.xpos + world.map_pos.xpos + width), 
                                   (int) (pos.ypos + world.map_pos.ypos + height + movSpeed)))) {
            if (Check.Finish(
                            new Point((int) (pos.xpos + world.map_pos.xpos), 
                                      (int) (pos.ypos + world.map_pos.ypos - movSpeed)),
                            new Point((int) (pos.xpos + world.map_pos.xpos + width), 
                                      (int) (pos.ypos + world.map_pos.ypos - movSpeed)))) {
                lap++;
            }
                
                if(speedDown < maxSpeed) {
                    speedDown += speed;
                }
                else {
                    speedDown = maxSpeed;
                }
                world.map_pos.ypos += movSpeed;
                }
        else {
            speedDown = 0;
        }
    }
    
    public void moveMapDownGlide(float movSpeed) {
        if(!Check.CollisionPlayerBlock(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos), 
                                  (int) (pos.ypos + world.map_pos.ypos + height + movSpeed)),
                        new Point ((int) (pos.xpos + world.map_pos.xpos + width), 
                                   (int) (pos.ypos + world.map_pos.ypos + height + movSpeed)))) {
                
            if(speedDown != 0) {
                    speedDown -= speed;
                    if(speedDown < 0) {
                        speedDown = 0;
                    }
            }
            world.map_pos.ypos += movSpeed;
        }
        else{
            speedDown = 0;
        }
    }
    
    
    public void moveMapRight(float movSpeed) {
        if(!Check.CollisionPlayerBlock(

                new Point((int) (pos.xpos + world.map_pos.xpos + width + movSpeed), 
                          (int) (pos.ypos + world.map_pos.ypos)),
                new Point ((int) (pos.xpos + world.map_pos.xpos + width + movSpeed), 
                           (int) (pos.ypos + world.map_pos.ypos + height)))) {

            if(speedRight < maxSpeed) {
                speedRight += speed;
            }
            else {
                speedRight = maxSpeed;
            }
            world.map_pos.xpos += movSpeed;
        }
        else{
            speedRight = 0;
        }
    }
        
    public void moveMapRightGlide(float movSpeed) {
        if(!Check.CollisionPlayerBlock(

                    new Point((int) (pos.xpos + world.map_pos.xpos + width + movSpeed), 
                              (int) (pos.ypos + world.map_pos.ypos)),
                    new Point ((int) (pos.xpos + world.map_pos.xpos + width + movSpeed), 
                               (int) (pos.ypos + world.map_pos.ypos + height)))) {
                if(speedRight != 0) {
                    speedRight -= speed;
                    if(speedRight < 0) {
                        speedRight = 0;
                    }
                }
                world.map_pos.xpos += movSpeed;
        }
        else {
            speedRight = 0;
        }
        
    }
    
    
    public void moveMapLeft(float movSpeed) {
        if(!Check.CollisionPlayerBlock(
                        
                        new Point((int) (pos.xpos + world.map_pos.xpos - movSpeed), 
                                  (int) (pos.ypos + world.map_pos.ypos + height)),
                        new Point ((int) (pos.xpos + world.map_pos.xpos - movSpeed), 
                                   (int) (pos.ypos + world.map_pos.ypos)))) {
                
            if(speedLeft < maxSpeed) {
                    speedLeft += speed;
                }
                else {
                    speedLeft = maxSpeed;
                }
                world.map_pos.xpos -= movSpeed;
        }
        else{
            speedLeft = 0;
        }
    }
    
    public void moveMapLeftGlide(float movSpeed) {
                        if(!Check.CollisionPlayerBlock(

                       new Point((int) (pos.xpos + world.map_pos.xpos - movSpeed), 
                                 (int) (pos.ypos + world.map_pos.ypos + height)),
                       new Point ((int) (pos.xpos + world.map_pos.xpos - movSpeed), 
                                  (int) (pos.ypos + world.map_pos.ypos)))) {
                   if(speedLeft != 0) {
                       speedLeft -= speed;
                        if(speedLeft < 0) {
                            speedLeft = 0;
                        }
                   }
                   world.map_pos.xpos -= movSpeed;
                }
                else{
                    speedLeft = 0;
                }

    }
    
    //render car
    public void render(Graphics2D g){
                             
        //IDLE or UP
         if(animationState == 0) {
             g.drawImage(carUp, (int) pos.xpos,(int) pos.ypos, width, height, null);
         }

         //UPRIGHT
         if(animationState == 1) {
            g.drawImage(carUpRight, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }

         //RIGHT
         if(animationState == 2) {
            g.drawImage(carRight, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }

         //DOWNRIGHT
         if(animationState == 3) {
             g.drawImage(carDownRight, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }

         //DOWN
         if(animationState == 4) {
             g.drawImage(carDown, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }

         //DOWNLEFT
         if(animationState == 5) {
             g.drawImage(carDownLeft, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }

         //LEFT
         if(animationState == 6) {
             g.drawImage(carLeft, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }

         //UPLEFT
         if(animationState == 7) {
             g.drawImage(carUpLeft, (int) pos.xpos,(int) pos.ypos, width, height, null); 
         }
         
         g.drawRect((int) pos.xpos - renderDistanceW * 28 / 2 + width / 2, (int) pos.ypos - renderDistanceH * 28 / 2 + height / 2, renderDistanceW * 28,renderDistanceH * 28);
         hudm.render(g);
         
         
         
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(server) {
            if (key == KeyEvent.VK_DOWN) {
                down = true;      
            }

            if (key == KeyEvent.VK_UP) {
                up = true;            
            }

            if (key == KeyEvent.VK_LEFT) {
                left = true;
            }

            if (key == KeyEvent.VK_RIGHT) {
                right = true;
            }
        }
        
        if(!server) {
            if (key == KeyEvent.VK_S) {
                down = true;      
            }

            if (key == KeyEvent.VK_W) {
                up = true;
            }

            if (key == KeyEvent.VK_A) {
                left = true;
            }

            if (key == KeyEvent.VK_D) {
                right = true;
            }
        }
        
        if (key == KeyEvent.VK_ESCAPE) {
            esc = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(server) {
            if (key == KeyEvent.VK_DOWN) {
                down = false;      
            }

            if (key == KeyEvent.VK_UP) {
                up = false;
            }

            if (key == KeyEvent.VK_LEFT) {
                left = false;
            }

            if (key == KeyEvent.VK_RIGHT) {
                right = false;
            }
        }
        
        if(!server) {
            if (key == KeyEvent.VK_S) {
                down = false;      
            }

            if (key == KeyEvent.VK_W) {
                up = false;
            }

            if (key == KeyEvent.VK_A) {
                left = false;
            }

            if (key == KeyEvent.VK_D) {
                right = false;
            }
        }
        
        if (key == KeyEvent.VK_ESCAPE) {
            esc = false;
        }
    }
    
    //change car function for the car select menu
    public static void changeCar(int car) {
        if (car == 1) {
            carSpriteY = 0;
        }
        if (car == 2) {
            carSpriteY = 64;
        }
        if (car == 3) {
            carSpriteY = 128;
        }
        if (car == 4) {
            carSpriteY = 192;
        }
    }
    
    /**
     * @return **********************************************************/
    //GETTERS HERE
    public Vector2F getPos() {
        return pos;
    }
    
    public float getMaxSpeed() {
        return maxSpeed;
    }
    
    public float getSpeed() {
        if(up) {
            if(up && right) {
                return speedUp + speedRight;
            }
            if(up && left) {
                return speedUp + speedLeft;
            }
            return speedUp;
        }
        if(right) {
            if(up && right) {
                return speedUp + speedRight;
            }
            return speedRight;
        }
        if(down) {
            if(down && left) {
                return speedDown + speedLeft;
            }
            if(down && right) {
                return speedDown + speedRight;
            }
            return speedDown;
        }
        if(left) {
            if(down && left) {
                return speedDown + speedLeft;
            }
            return speedLeft;
        }
        return 0.0F;
    }

    public int getLap2() {
        return lap2;
    }

    public int getLapZero2() {
        return lapzero2;
    }    
    //SETTERS
    public void setLap2(int lap){
        lap2 = lap;
    }
}
