package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
    GamePanel gp;

    public BufferedImage up1, up2, down1, down2, left1, left2, left3, left4, right1, right2, right3, right4, Frame;
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackRight1, attackRight2, attackLeft1, attackLeft2;
    public String npcName;
    public Rectangle solidArea = new Rectangle(0,0,40,40);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    String dialog[] = new String[100];
    public BufferedImage image, image2,image3;

    // STATE
    public int worldx, worldy;
    public String direction = "down";
    int dialogIndex = 0; 
    public int spritesNum = 1;
    public boolean collisionOn = false; 
    public boolean invincible = false;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    boolean hpBarOn = false;
    


   
    // COUNTER
    public int spritesCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;
    int dyingCounter = 0;
    int hpBarCounter = 0;

    // CHARACTER ATTRIBUTES
    public int type; // 0 = player, 1 = npc, 2 = monsters
    public String name;
    public int speed;
    public int maxLife;
    public int life;
    public int attackMons;

    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void damageReaction(){
        
    }
    public void setAction(){

    }
    
    public void speak(){
           if(dialog[dialogIndex] == null){
            dialogIndex = 0;
        }
        gp.ui.currentDialog = dialog[dialogIndex];
        dialogIndex++;

    // for the direction of the npc talking, para hindi nakatalikod satin pag nagg uusap
        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        
            default:
                break;
        }
    }
    
    public void update(){
        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
       boolean contactPlayer = gp.cChecker.checkPlayer(this);

       if(this.type == 2 && contactPlayer == true){
            if(gp.player.invincible == false){

                gp.playSE(7);
                gp.player.life -= attackMons;
                gp.player.invincible = true;
                if(gp.player.life == 0){
                    gp.gameState = gp.tittleState;
                    gp.music.stop();
                    
                    
                    
                }
            }
       }

         if (collisionOn == false){
            switch (direction) {
                case "up":
                    worldy-= speed;
                    break;
                case "down":
                    worldy += speed;
                    break;
                case "left":
                    worldx -= speed;
                    break;
                case "right":
                    worldx += speed;
                    break;
            
                default:
                    break;
            }
        }

        spritesCounter++;
        if (spritesCounter > 12){
            if (spritesNum == 1){
                spritesNum = 2;
            }else if (spritesNum == 2){
                spritesNum = 1;
            }

            spritesCounter = 0;
        }

            if(invincible == true) {
                invincibleCounter++;
            if(invincibleCounter > 40){
                 invincible = false;
                invincibleCounter = 0;
            }
            }

    }

        public void draw(Graphics2D g2){

        
        BufferedImage image = null;
        int screenX = worldx - gp.player.worldx + gp.player.screenX;
        int screenY = worldy - gp.player.worldy + gp.player.screenY;

            if (worldx + gp.tileSize > gp.player.worldx - gp.player.screenX &&
                worldx - gp.tileSize < gp.player.worldx + gp.player.screenX &&
                worldy + gp.tileSize > gp.player.worldy - gp.player.screenY &&
                worldy - gp.tileSize < gp.player.worldy + gp.player.screenY
            ){
              

        switch (direction) {//para yung other images like up and down gumana, parang naglalakd talaga
            case "up":
                if (spritesNum == 1){image = up1;}
                if (spritesNum == 2){image = up2;}
                break;
            case "down":
               if (spritesNum == 1){image = down1;}
               if (spritesNum == 2){image = down2;}
                break;
            case "left":
               if (spritesNum == 1){image = left1;}
                if (spritesNum == 2){image = left2;}
                break;
            case "right":
                if (spritesNum == 1){image = right1;}
                if (spritesNum == 2){image = right2;}
                break;
            }

            // Monster health bar
            if (type == 2 && hpBarOn == true){
                double oneScale = (double)gp.tileSize/maxLife;
                double hpBarValue = oneScale * life; 
                // if yung maxlife ay 2 at 48 yung tilesize the one scale is 26

                g2.setColor(new Color(35,35,35));
                g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 1, 12);
                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);

                hpBarCounter++;

                if(hpBarCounter > 600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }

            if(invincible == true){
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4f);
            } 
            if(dying == true){
                dyingAnimation(g2);
            }
        
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);// dito na sya ma dodraw sa screen
                
                changeAlpha(g2, 1f);
}
    }
    // Yung Alpha na yun yung visibility lng nya o opacity, kung gano katagal yung transparency nya

    public void dyingAnimation(Graphics2D g2){

        dyingCounter++;
        int i = 5;

        if(dyingCounter <= i){
           changeAlpha(g2, 0f);
        }
        if(dyingCounter > i && dyingCounter <= i*2){
           changeAlpha(g2, 0.1f);
        }
        if(dyingCounter > i*2 && dyingCounter <= i*3){
           changeAlpha(g2, 0f);
        }
        if(dyingCounter > i*3 && dyingCounter <= i*4){
           changeAlpha(g2, 0.1f);
        }
        if(dyingCounter > i*4 && dyingCounter <= i*5){
           changeAlpha(g2, 0f);
        }
        if(dyingCounter > i*5 && dyingCounter <= i*6){
            changeAlpha(g2, 0.1f);
        }
        if(dyingCounter > i*6 && dyingCounter <= i*7){
            changeAlpha(g2, 0f);
        }
        if(dyingCounter > i*7 && dyingCounter <= i*8){
           changeAlpha(g2, 0.1f);
        }
        if(dyingCounter > i*8){
            dying = false;
            alive = false;
        }
    }
    public void changeAlpha(Graphics2D g2, float alphaValue){
        
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
        
    }

    public BufferedImage setup(String imagePath, int width, int height){

    UtilityTool uTool = new UtilityTool();
    BufferedImage image = null;
    try {
        image = ImageIO.read(getClass().getResourceAsStream(imagePath +".png"));
        image = uTool.scaleImage(image, width, height);
    } catch (IOException e) {
        e.printStackTrace();
}
    return image;

}
}
