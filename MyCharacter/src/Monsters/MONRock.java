package Monsters;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MONRock extends Entity{
GamePanel gp;

    public MONRock(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = 2;
        attackMons = 1;
        name = "RockyChan";
        speed = 6;
        maxLife  = 4;
        life = maxLife;
        

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage() {

        up1 = setup("/monster/RockUp1",gp.tileSize, gp.tileSize);
        up2 = setup("/monster/RockUp2",gp.tileSize, gp.tileSize);

        down1 = setup("/monster/RockDown1",gp.tileSize, gp.tileSize);
        down2 = setup("/monster/RockDown2",gp.tileSize, gp.tileSize);
/* 
        left1 = setup("/monster/LeftBee1",gp.tileSize, gp.tileSize);
        left2 = setup("/monster/LeftBee2",gp.tileSize, gp.tileSize);

        right1 = setup("/monster/RightBee1",gp.tileSize, gp.tileSize);
        right2 = setup("/monster/RightBee2",gp.tileSize, gp.tileSize);
*/
        
    }
    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 50){// per frame
        Random random = new Random();
        int i = random.nextInt(6)+1; // pick a number from 1 to 100;
        if( i <= 3 ){
            direction = "up";
        }
        if( i > 3 && i <= 6){
            direction = "down";
        }
        actionLockCounter = 0;
        }   
    }
    public void damageReaction(){
        actionLockCounter = 0;
        direction = gp.player.direction;
    }

}
