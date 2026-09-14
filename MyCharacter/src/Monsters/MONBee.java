package Monsters;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MONBee extends Entity{
GamePanel gp;

    public MONBee(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = 2;
        attackMons = 1;
        name = "DollyBee";
        speed = 3;
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

        up1 = setup("/monster/UpBee1",gp.tileSize, gp.tileSize);
        up2 = setup("/monster/UpBee2",gp.tileSize, gp.tileSize);

        down1 = setup("/monster/DownBee",gp.tileSize, gp.tileSize);
        down2 = setup("/monster/DownBee",gp.tileSize, gp.tileSize);

        left1 = setup("/monster/LeftBee1",gp.tileSize, gp.tileSize);
        left2 = setup("/monster/LeftBee2",gp.tileSize, gp.tileSize);

        right1 = setup("/monster/RightBee1",gp.tileSize, gp.tileSize);
        right2 = setup("/monster/RightBee2",gp.tileSize, gp.tileSize);
        
        
    }
    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 50){// per frame
        Random random = new Random();
        int i = random.nextInt(12)+1; // pick a number from 1 to 100;
        if( i <= 3 ){
            direction = "up";
        }
        if( i > 3 && i <= 6){
            direction = "down";
        }if ( i > 6 && i <= 9 ){
            direction = "left";       
        }if( i > 9 &&  i <= 12 ){
            direction = "right";
        }
        actionLockCounter = 0;
        }   
    }
    public void damageReaction(){
        actionLockCounter = 0;
        direction = gp.player.direction;
    }

}
