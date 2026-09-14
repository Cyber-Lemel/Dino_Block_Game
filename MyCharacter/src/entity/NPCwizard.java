package entity;
 import java.util.Random;

import main.GamePanel;

public class NPCwizard extends Entity {

    public NPCwizard(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 2;
        npcName = "Gunther";

        getImage();
        setDialog();
    }

      public void getImage(){
    
 up1 = setup("/NPC/wizardNPC",gp.tileSize, gp.tileSize);
 up2 = setup("/NPC/wizardNPC1",gp.tileSize, gp.tileSize);
 down1 = setup("/NPC/wizardNPC",gp.tileSize, gp.tileSize);
 down2 = setup("/NPC/wizardNPC1",gp.tileSize, gp.tileSize);
 left1 = setup("/NPC/wizardNPC",gp.tileSize, gp.tileSize);
 left2 = setup("/NPC/wizardNPC1",gp.tileSize, gp.tileSize);
 right1 = setup("/NPC/wizardNPC",gp.tileSize, gp.tileSize);
 right2 = setup("/NPC/wizardNPC1",gp.tileSize, gp.tileSize);

}
    // for Dialog of Npc
    public void setDialog(){
        dialog[0] = "Hello Dino!";
        dialog[1] = "Oww, so you lost your eggs?";
        dialog[2] = "I used to be a great wizard but now... \nI can't help you";
        dialog[3] = "Goodluck on your Adventure! \n'Little Dino'";
    }


    public void setAction(){

        actionLockCounter++;
        if (actionLockCounter == 120){// per frame
        Random random = new Random();
        int i = random.nextInt(100)+1; // pick a number from 1 to 100;
        if( i <= 25 ){
            direction = "up";
        }
        if( i > 25 && i <= 50){
            direction = "down";
        }if ( i > 50 && i <= 75 ){
            direction = "left";       
        }if( i > 75 &&  i <= 100 ){
            direction = "right";
        }
        actionLockCounter = 0;
        }   
    }

    public void speak(){

        // do some npc specific stuff, but for future upgrade pa sya for now wala pa
        super.speak();
    }
}