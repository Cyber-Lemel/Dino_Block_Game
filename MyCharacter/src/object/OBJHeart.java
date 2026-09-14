package object;

import entity.Entity;
import main.GamePanel;

public class OBJHeart extends Entity{
    

public OBJHeart(GamePanel gp){
    super (gp);

    name = "Heart";
    image = setup("/Objects/fullHeart",gp.tileSize, gp.tileSize);
    image2 = setup("/Objects/halfHeart",gp.tileSize, gp.tileSize);
    image3 = setup("/Objects/noHeart",gp.tileSize, gp.tileSize);

    }

}
