package object;


import entity.Entity;
import main.GamePanel;

public class OBJDoor extends Entity{


     public OBJDoor(GamePanel gp){
        super(gp);
        name = "Door";
       down1 = setup("/Objects/nest",gp.tileSize, gp.tileSize); 

    collision = true;
    }


}
