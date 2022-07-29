package entity;
import java.awt.image.BufferedImage;


import main.GamePanel;
import main.KeyHandler;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    public KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        worldX = gp.tileSize*46;
        worldY = gp.tileSize*46;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("player/right2.png"));
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void update(){
        
        if(keyH.upPressed == true || keyH.downPressed == true|| keyH.leftPressed == true || keyH.rightPressed == true){
        

        if(keyH.upPressed == true){
            direction = "up";
        }
        else if(keyH.downPressed == true){
            direction = "down";
        }
        else if(keyH.leftPressed == true){
            direction = "left";
        }
        else if(keyH.rightPressed == true){
            direction = "right";
        }

        spriteCounter++;
        if(spriteCounter > 20){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        
        //check tile collision
        collisionOn = false;
        gp.c.checkTile(this);
        
        // if collision is false, player can move
        if(collisionOn == false){
            
            // switch(direction){
            //     case "up": 
            //     worldY -= speed;
            //     break;
            //     case "down": 
            //     worldY += speed;
            //     break;
            //     case "left": 
            //     worldX -= speed;
            //     break;
            //     case "right": 
            //     worldX += speed;
            //         break;
            // }
            if(keyH.upPressed == true){
                worldY -= speed;
            }
            else if(keyH.downPressed == true){
                worldY += speed;
            }
            else if(keyH.leftPressed == true){
                worldX -= speed;
            }
            else if(keyH.rightPressed == true){
                worldX += speed;
            }
        }
      }
      
    }

    public void draw(Graphics2D g2){
        
        BufferedImage image = null;

        switch(direction){
            case "up":
                if(spriteNum==1){
                    image = up1;
                }
                if(spriteNum==2){
                    image = up2;
                }
                break;
            case "down" :
                if(spriteNum ==1){
                image = down1;
                }
                if(spriteNum ==2){
                image = down2;
                }
                break;
            case "left":
                if(spriteNum ==1){
                image = left1;
                }
                if(spriteNum ==2){
                image = left2;
                }
                break;
            case "right":
                if(spriteNum ==1){
                image = right1;
                }
                if(spriteNum ==2){
                image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
