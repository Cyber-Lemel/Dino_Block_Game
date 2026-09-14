package Monsters;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MONTractor extends Entity{
GamePanel gp;

    public MONTractor(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = 2;
        attackMons = 2;
        name = "Tracty";
        speed = 4;
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
// Left and right lng to
        left1 = setup("/monster/TractorLeft1",gp.tileSize, gp.tileSize);
        left2 = setup("/monster/TractorLeft2",gp.tileSize, gp.tileSize);

        left3 = setup("/monster/TractorLeft3",gp.tileSize, gp.tileSize);
        left4 = setup("/monster/TractorLeft4",gp.tileSize, gp.tileSize);

        right1 = setup("/monster/TractorRight1",gp.tileSize, gp.tileSize);
        right2 = setup("/monster/TractorRight2",gp.tileSize, gp.tileSize);

        right3 = setup("/monster/TractorLeft3",gp.tileSize, gp.tileSize);
        right4 = setup("/monster/TractorLeft4",gp.tileSize, gp.tileSize);
        
        
    }
    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 50){// per frame
        Random random = new Random();
        int i = random.nextInt(6)+1; // pick a number from 1 to 100;
        if( i <= 3 ){
            direction = "left";
        }
        if( i > 3 && i <= 6){
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
