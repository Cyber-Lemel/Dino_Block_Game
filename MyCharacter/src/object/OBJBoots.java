package object;

import entity.Entity;
import main.GamePanel;

public class OBJBoots extends Entity{
   

public OBJBoots(GamePanel gp){
    super (gp);
    name = "Boots";
     down1 = setup("/Objects/AppleSpeed",gp.tileSize, gp.tileSize);

    collision = true;
    }


}
