package main;

import object.OBJtresure;
import Monsters.MONBee;
import Monsters.MONRock;
import Monsters.MONSnake;
import Monsters.MONTractor;
import entity.NPCwizard;
import object.OBJBoots;
import object.OBJDoor;
import object.OBJEgg;
//import object.OBJFly;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
public void setObject(){
   gp.obj[0] = new OBJEgg(gp); 
   gp.obj[0].worldx = 36 * gp.tileSize;
   gp.obj[0].worldy = 36 * gp.tileSize;

    gp.obj[1] = new OBJEgg(gp);
    gp.obj[1].worldx = 32 * gp.tileSize;
    gp.obj[1].worldy = 1 * gp.tileSize;

    gp.obj[2] = new OBJEgg(gp);
    gp.obj[2].worldx = 20 * gp.tileSize;
    gp.obj[2].worldy = 24 * gp.tileSize;

    gp.obj[3] = new OBJEgg(gp);
    gp.obj[3].worldx = 17 * gp.tileSize;
    gp.obj[3].worldy = 34 * gp.tileSize;

    gp.obj[4] = new OBJEgg(gp);
    gp.obj[4].worldx = 1 * gp.tileSize;
    gp.obj[4].worldy = 12 * gp.tileSize;
//DOOR
    gp.obj[5] = new OBJDoor(gp);
    gp.obj[5].worldx = 12 * gp.tileSize;
    gp.obj[5].worldy = 1 * gp.tileSize;
//TRESURE
   gp.obj[6] = new OBJtresure(gp);
   gp.obj[6].worldx = 23 * gp.tileSize;
   gp.obj[6].worldy = 10 * gp.tileSize;
//BOOTS
   gp.obj[7] = new OBJBoots(gp);
   gp.obj[7].worldx = 25 * gp.tileSize;
   gp.obj[7].worldy = 32 * gp.tileSize;
//FLY
/* 
    gp.obj[8] = new OBJFly(gp);
    gp.obj[8].worldx = 3 * gp.tileSize;
    gp.obj[8].worldy = 38 * gp.tileSize;*/
//EGGS
    gp.obj[10] = new OBJEgg(gp); 
   gp.obj[10].worldx = 8 * gp.tileSize;
   gp.obj[10].worldy = 19 * gp.tileSize;

    gp.obj[11] = new OBJEgg(gp);
    gp.obj[11].worldx = 26 * gp.tileSize;
    gp.obj[11].worldy = 10 * gp.tileSize;

    gp.obj[12] = new OBJEgg(gp);
    gp.obj[12].worldx = 25 * gp.tileSize;
    gp.obj[12].worldy = 16 * gp.tileSize;

    gp.obj[13] = new OBJEgg(gp);
    gp.obj[13].worldx = 16 * gp.tileSize;
    gp.obj[13].worldy = 37 * gp.tileSize;

    gp.obj[14] = new OBJEgg(gp);
    gp.obj[14].worldx = 17 * gp.tileSize;
    gp.obj[14].worldy = 6 * gp.tileSize;


}
    public void setNPC(){
        gp.npc[0] = new NPCwizard(gp);
        gp.npc[0].worldx = gp.tileSize * 12;
        gp.npc[0].worldy = gp.tileSize * 28;

        gp.npc[1] = new NPCwizard(gp);
        gp.npc[1].worldx = gp.tileSize * 13;
        gp.npc[1].worldy = gp.tileSize * 32;

        gp.npc[2] = new NPCwizard(gp);
        gp.npc[2].worldx = gp.tileSize * 17;
        gp.npc[2].worldy = gp.tileSize * 1;
    }
    public void setMonsters() {
        gp.monster[0] = new MONSnake(gp);
        gp.monster[0].worldx = gp.tileSize * 17;
        gp.monster[0].worldy = gp.tileSize * 12;

        gp.monster[1] = new MONSnake(gp);
        gp.monster[1].worldx = gp.tileSize * 18;
        gp.monster[1].worldy = gp.tileSize * 32;

        gp.monster[2] = new MONSnake(gp);
        gp.monster[2].worldx = gp.tileSize * 30;
        gp.monster[2].worldy = gp.tileSize * 25;

        gp.monster[3] = new MONSnake(gp);
        gp.monster[3].worldx = gp.tileSize * 35;
        gp.monster[3].worldy = gp.tileSize * 34;

        gp.monster[4] = new MONSnake(gp);
        gp.monster[4].worldx = gp.tileSize * 34;
        gp.monster[4].worldy = gp.tileSize * 1;

        gp.monster[5] = new MONSnake(gp);
        gp.monster[5].worldx = gp.tileSize * 36;
        gp.monster[5].worldy = gp.tileSize * 3;

        gp.monster[6] = new MONBee(gp);
        gp.monster[6].worldx = gp.tileSize * 4;
        gp.monster[6].worldy = gp.tileSize * 9;

        gp.monster[7] = new MONSnake(gp);
        gp.monster[7].worldx = gp.tileSize * 27;
        gp.monster[7].worldy = gp.tileSize * 14;

        gp.monster[8] = new MONSnake(gp);
        gp.monster[8].worldx = gp.tileSize * 28;
        gp.monster[8].worldy = gp.tileSize * 9;

        gp.monster[9] = new MONSnake(gp);
        gp.monster[9].worldx = gp.tileSize * 8;
        gp.monster[9].worldy = gp.tileSize * 19;
    
// MOnster Bee

        gp.monster[11] = new MONBee(gp);
        gp.monster[11].worldx = gp.tileSize * 13;
        gp.monster[11].worldy = gp.tileSize * 12;

        gp.monster[12] = new MONBee(gp);
        gp.monster[12].worldx = gp.tileSize * 10;
        gp.monster[12].worldy = gp.tileSize * 23;

        gp.monster[13] = new MONBee(gp);
        gp.monster[13].worldx = gp.tileSize * 13;
        gp.monster[13].worldy = gp.tileSize * 27;

        gp.monster[14] = new MONBee(gp);
        gp.monster[14].worldx = gp.tileSize * 27;
        gp.monster[14].worldy = gp.tileSize * 15;

        gp.monster[15] = new MONBee(gp);
        gp.monster[15].worldx = gp.tileSize * 13;
        gp.monster[15].worldy = gp.tileSize * 33;

        gp.monster[16] = new MONBee(gp);
        gp.monster[16].worldx = gp.tileSize * 33;
        gp.monster[16].worldy = gp.tileSize * 26;

        gp.monster[17] = new MONBee(gp);
        gp.monster[17].worldx = gp.tileSize * 20;
        gp.monster[17].worldy = gp.tileSize * 10;

        gp.monster[18] = new MONBee(gp);
        gp.monster[18].worldx = gp.tileSize * 15;
        gp.monster[18].worldy = gp.tileSize * 19;

        gp.monster[19] = new MONBee(gp);
        gp.monster[19].worldx = gp.tileSize * 22;
        gp.monster[19].worldy = gp.tileSize * 22;
// Monsters Rocks
        gp.monster[20] = new MONRock(gp);
        gp.monster[20].worldx = gp.tileSize * 17;
        gp.monster[20].worldy = gp.tileSize * 4;

        gp.monster[21] = new MONRock(gp);
        gp.monster[21].worldx = gp.tileSize * 23;
        gp.monster[21].worldy = gp.tileSize * 19;

        gp.monster[22] = new MONRock(gp);
        gp.monster[22].worldx = gp.tileSize * 33;
        gp.monster[22].worldy = gp.tileSize * 18;

        gp.monster[23] = new MONRock(gp);
        gp.monster[23].worldx = gp.tileSize * 29;
        gp.monster[23].worldy = gp.tileSize * 23;

        gp.monster[24] = new MONRock(gp);
        gp.monster[24].worldx = gp.tileSize * 13;
        gp.monster[24].worldy = gp.tileSize * 22;

        gp.monster[25] = new MONRock(gp);
        gp.monster[25].worldx = gp.tileSize * 10;
        gp.monster[25].worldy = gp.tileSize * 24;

        gp.monster[26] = new MONRock(gp);
        gp.monster[26].worldx = gp.tileSize * 20;
        gp.monster[26].worldy = gp.tileSize * 31;

        gp.monster[27] = new MONRock(gp);
        gp.monster[27].worldx = gp.tileSize * 8;
        gp.monster[27].worldy = gp.tileSize * 27;

        gp.monster[28] = new MONRock(gp);
        gp.monster[28].worldx = gp.tileSize * 16;
        gp.monster[28].worldy = gp.tileSize * 10;

        gp.monster[29] = new MONRock(gp);
        gp.monster[29].worldx = gp.tileSize * 30;
        gp.monster[29].worldy = gp.tileSize * 9;
// Tractor
        gp.monster[30] = new MONTractor(gp);
        gp.monster[30].worldx = gp.tileSize * 14;
        gp.monster[30].worldy = gp.tileSize * 29;

        gp.monster[31] = new MONTractor(gp);
        gp.monster[31].worldx = gp.tileSize * 13;
        gp.monster[31].worldy = gp.tileSize * 19;

        gp.monster[32] = new MONTractor(gp);
        gp.monster[32].worldx = gp.tileSize * 8;
        gp.monster[32].worldy = gp.tileSize * 24;

        gp.monster[33] = new MONTractor(gp);
        gp.monster[33].worldx = gp.tileSize * 29;
        gp.monster[33].worldy = gp.tileSize * 19;

        gp.monster[34] = new MONTractor(gp);
        gp.monster[34].worldx = gp.tileSize * 23;
        gp.monster[34].worldy = gp.tileSize * 32;

        gp.monster[35] = new MONTractor(gp);
        gp.monster[35].worldx = gp.tileSize * 15;
        gp.monster[35].worldy = gp.tileSize * 23;

        gp.monster[36] = new MONTractor(gp);
        gp.monster[36].worldx = gp.tileSize * 19;
        gp.monster[36].worldy = gp.tileSize * 3;
            
}
}