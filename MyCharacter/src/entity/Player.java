package entity;



import java.awt.AlphaComposite;
import java.awt.Color; // open ko nalang pag mag checheck ng hit box

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


import main.GamePanel;
import main.KeyHandler;

import tile.TileManager;

public class Player extends Entity  {

   
    KeyHandler keyH;
    TileManager TL;
     
    
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    int standCounter = 0;
    public boolean attackCanceled = false;
    public int doorNum = 1;// for testing lng
    int eggNum = 10;

    boolean showHitbox = false;

    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);

        this.keyH = keyH;
        this.TL = gp.tileM;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle(); // player size
        solidArea.x = 8; // offset from the top left corner
        solidArea.y = 16; // offset from the top left corner 
        solidAreaDefaultX = solidArea.x; 
        solidAreaDefaultY = solidArea.y;  
        solidArea.width = 30; // width of the player
        solidArea.height = 30; // height of the player

        attackArea.width = 36;
        attackArea.height = 36;
setDefaultValues();
getPlayerImage();
getPlayerAttackImage();

    }

    public void setDefaultValues(){

        worldx = gp.tileSize * 14; // position in the map
        worldy = gp.tileSize * 14;
        speed = 4;
        direction = "down";

        // Player Heart
        maxLife = 6;
        life = maxLife;

    }

public void getPlayerImage(){
    
 up1 = setup("/player/DinoRight",gp.tileSize, gp.tileSize);
 up2 = setup("/player/DinoRight",gp.tileSize, gp.tileSize);
 down1 = setup("/player/DinoLeft",gp.tileSize, gp.tileSize);
 down2 = setup("/player/DinoLeft",gp.tileSize, gp.tileSize);
 left1 = setup("/player/DinoWalkLeft",gp.tileSize, gp.tileSize);
 left2 = setup("/player/DinoLeft",gp.tileSize, gp.tileSize);
 right1 = setup("/player/DinoWalkRight",gp.tileSize, gp.tileSize);
 right2 = setup("/player/DinoRight",gp.tileSize, gp.tileSize);
 Frame = setup("/player/Frame7",gp.tileSize, gp.tileSize);
 
}

public void getPlayerAttackImage(){
    attackUp1 = setup("/player/ChargeUp",gp.tileSize, gp.tileSize*2);
    attackUp2 = setup("/player/AttackUp",gp.tileSize, gp.tileSize*2);
    attackDown1 = setup("/player/FinalDinoAttackDown1",gp.tileSize, gp.tileSize*2);
    attackDown2 = setup("/player/DinoAttackDown2",gp.tileSize, gp.tileSize*2);
    attackLeft1 = setup("/player/FinalDinoAttackLeft1",gp.tileSize*2, gp.tileSize);
    attackLeft2 = setup("/player/FinalDinoAttackLeft2",gp.tileSize*2, gp.tileSize);
    attackRight1 = setup("/player/FinalDinoAttackRight1",gp.tileSize*2, gp.tileSize);
    attackRight2 = setup("/player/FinalDinoAttackRight2",gp.tileSize*2, gp.tileSize);
}

public void FlyMe(){

 up1 = setup("/player/Dino2Right",gp.tileSize, gp.tileSize);
 up2 = setup("/player/Dino2Right",gp.tileSize, gp.tileSize);
 down1 = setup("/player/Dino2Left",gp.tileSize, gp.tileSize);
 down2 = setup("/player/Dino2Left",gp.tileSize, gp.tileSize);
 left1 = setup("/player/DinoLeftFly",gp.tileSize, gp.tileSize);
 left2 = setup("/player/Dino2Left",gp.tileSize, gp.tileSize);
 right1 = setup("/player/DinoRightFly",gp.tileSize, gp.tileSize);
 right2 = setup("/player/Dino2Right",gp.tileSize, gp.tileSize);

}
    public void update(){// same as dito yung comment sa baba para lumakad hind mukang frame lng na nag sslide
        
        if(attacking == true){
            attacking();
        }

        else if (keyH.code == KeyEvent.VK_H){
            showHitbox = !showHitbox;
            keyH.code = 0;
           }

        if (keyH.up == true || keyH.down == true || keyH.left == true || keyH.right ==true || keyH.enterPressed == true){
           
            if (keyH.up == true){
            direction = "up";
           
        }else if (keyH.down == true){
            direction = "down";
           
        }else if (keyH.left == true){
            direction = "left";
            
        }else if (keyH.right == true){
            direction = "right";
           
        }
//Tile collision
        collisionOn = false; // reset collision before checking
        gp.cChecker.checkTile(this); // check collision with tiles

// check NPC collision
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

// Check Monster Collision
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);

// check event 
        gp.eHandler.checkEvent();
        
        
//object collision
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObjects(objIndex);
        if (collisionOn == false && keyH.enterPressed == false){
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
        if(keyH.enterPressed == true && attackCanceled == false){
            gp.playSE(8);
            attacking = true;
            spritesCounter = 0;
        }

        attackCanceled = false;
         gp.keyH.enterPressed = false;

        spritesCounter++;
        if (spritesCounter > 12){
            if (spritesNum == 1){
                spritesNum = 2;
            }else if (spritesNum == 2){
                spritesNum = 1;
            }

            spritesCounter = 0;
        }
        else{
            standCounter++;
            if (standCounter == 20){
                spritesNum = 1;
                standCounter = 0;

            }
           
        }
        }
   if(invincible == true) {
        invincibleCounter++;
        if(invincibleCounter > 60){
            invincible = false;
            invincibleCounter = 0;
        }
   }
    }

    public void attacking(){
        spritesCounter++;

        if(invincibleCounter <= 5){
            spritesNum = 1;
        }
        if(spritesCounter > 5 && spritesCounter <= 25){
            spritesNum = 2;

            // Save current worldX, worldY, solidArea
            int currrentWorldX = worldx;
            int currentWorldY = worldy;
            int solidAreaWidth = solidArea.width; // for the weapon lahat to
            int solidAreaHeight = solidArea.height;

            // Adjust player's worldX/Y for the attack Area 
            switch (direction) {
                case "up": worldy -= attackArea.height; break;
                case "down": worldy += attackArea.height; break;
                case "left": worldx -= attackArea.width; break;
                case "right": worldx += attackArea.width; break;
            }
            // Attack area become solid Area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            // Check monster collision with the updated worldX/Y and solidArea
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);

            worldx = currrentWorldX;
            worldy = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;


        }
        if(spritesCounter > 25 ){
            spritesNum = 1;
            spritesCounter = 0;
            attacking = false;
        }
        
    }

    public void pickUpObjects(int i){

        if( i != 999 && gp.obj[i] != null ){
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "GrassEggs":
                    gp.playSE(2);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got your egg!");
                    eggNum--;
                    
                    break;

                case "Door":
                gp.playSE(2);
                    if (hasKey >= 10){
                        gp.obj[i] = null;
                        hasKey-=10;
                        doorNum--;
                    }else {
                        if (eggNum > 0 ){
                        gp.ui.showMessage("You need " + eggNum + "  more eggs!");
                        }
                    }
                   
                    break;
                    // Dito pwedi ng powerups, need pa ng idea para gawin.
                case "Boots":
                    speed += 1;
                    gp.playSE(1);
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed up!");

                    break;
                case "Tresure":
                    if (doorNum == 0){
                        gp.ui.gameFinished = true;
                        gp.playSE(5);
                        gp.obj[i] = null;
                        gp.stopMusic();
                        
                    }else{
                        gp.playSE(2);
                        gp.ui.showMessage("Put all 10 eggs to the nest First");
                    }
                    break;

                  case "Fly":
                    TL.FlyColOff();  // Use the correctly assigned tileM
                    FlyMe();
                   
                    gp.playSE(1);
                    gp.obj[i] = null;
                    break;

                default:
                    break;
            }
        }

    }

    public void interactNPC(int i){
       
    if(gp.keyH.enterPressed == true){

        if(i != 999 && gp.npc[i] != null){
            attackCanceled = true;
            gp.gameState = gp.dialogState;
            gp.npc[i].speak();

        } 
        }
    }

    public void contactMonster(int i){
        if( i != 999 && gp.monster[i] != null){
            if (invincible == false){
                gp.playSE(7);
                life -= gp.monster[i].attackMons;
                invincible = true;
                if(gp.player.life <= 0){
                    gp.gameState = gp.tittleState;
                   if(gp.gameState == gp.tittleState){
                    gp.music.stop();
                    }
                   
                }

            }
            
        }
         
    }

  public void damageMonster(int i){
    if(i != 999 && gp.monster[i] != null){
        if (gp.monster[i].invincible == false) {

            gp.playSE(6);
            gp.monster[i].life -= 1;
            gp.monster[i].invincible = true;
            gp.monster[i].damageReaction();

            if(gp.monster[i].life <= 0){
                gp.monster[i].dying = true;
            }
        }
    }
}


   public void draw(Graphics2D g2){
      g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

         BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        switch (direction) {//para yung other images like up and down gumana, parang naglalakd talaga
            case "up":
            if(attacking == false){
                if (spritesNum == 1){image = up1; }
                if (spritesNum == 2){image = up2; }
            }
            if(attacking == true){
                tempScreenY = screenY - gp.tileSize;
                if (spritesNum == 1){image = attackUp1; }
                if (spritesNum == 2){image = attackUp2; }
            }
                break;

            case "down":
            if(attacking == false){
               if (spritesNum == 1){image = down1; }
               if (spritesNum == 2){image = down2; }
            }
            if(attacking == true){
               
               if (spritesNum == 1){image = attackDown1; }
               if (spritesNum == 2){image = attackDown2; }
            }
               break;

            case "left":
            if(attacking == false){
                if (spritesNum == 1){image = left1; }
                if (spritesNum == 2){image = left2; }
            }
            if(attacking == true){
                tempScreenX = screenX - gp.tileSize;
               if (spritesNum == 1){image = attackLeft1; }
                if (spritesNum == 2){image = attackLeft2; }
            }
                break;

            case "right":
            if(attacking == false){
                if (spritesNum == 1){image = right1;}
                if (spritesNum == 2){image = right2; }
            }
            if(attacking == true){
                tempScreenX = screenX + gp.tileSize;
                if (spritesNum == 1){image = attackRight1;}
                if (spritesNum == 2){image = attackRight2;}
            }
                break;
        }

        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }

        g2.drawImage(image, tempScreenX, tempScreenY, gp.tileSize, gp.tileSize, null);
       

       if (showHitbox) {
    g2.setColor(Color.red);
    g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, 
                solidArea.width, solidArea.height);
}
// reset alpha kanina sa taas
     g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
}
}