package object;


import entity.Entity;
import main.GamePanel;

public class OBJFly extends Entity {
    

public OBJFly(GamePanel gp){
    super(gp);
    name = "Fly";
      down1 = setup("/Objects/AppleFly",gp.tileSize, gp.tileSize);

   collision = false;
    }



}
