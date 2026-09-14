package object;

import entity.Entity;
import main.GamePanel;

public class OBJEgg extends Entity {
  

    public OBJEgg(GamePanel gp){
        super (gp);

        name = "GrassEggs";

        image = setup("/Objects/GrassLandEggs",gp.tileSize, gp.tileSize);
        down1 = image;

      
    }

}
