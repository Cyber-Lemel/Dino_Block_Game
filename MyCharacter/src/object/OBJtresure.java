package object;

import entity.Entity;
import main.GamePanel;

public class OBJtresure extends Entity { 
    GamePanel gp;

 public OBJtresure(GamePanel gp){
    super (gp);
        name = "Tresure";
        down1 = setup("/Objects/tresure",gp.tileSize, gp.tileSize);
        collision = true;

        // ito ay para talaga sa door,
       // para sa likod ka nang door 
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
    
}
