package tile;

import java.awt.Graphics2D;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

    GamePanel gp;
   public Tile[] tile;
   public int mapTileNum[] [];


    public TileManager (GamePanel gp){
        this.gp = gp;

        tile = new Tile[99];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/mapMoving.txt");
    }


    public void getTileImage(){
        
           setup(0, "Grass", false);
           setup(1, "wall1", true);
           setup(2, "GrassLandRock", true);
           setup(3, "Mud", true);
           setup(4, "BushGrass", false);
           setup(5, "NewTree", true);
           setup(6, "Water", true);
           setup(7, "WaterTopLand", true);
           setup(8, "WaterDownLand", true);
           setup(9, "WaterLeftLand", true);
           setup(10, "WaterRightLand", true);
           setup(11, "HealTile", false);
           setup(12, "Trap", false);
           setup(13, "teleport", false);
           setup(14, "Mud2", true);
           setup(15, "Brick", true);
           setup(16, "BrickHon", true);
           
            

        
    }
    public void setup(int index, String imageName, boolean collision){
    UtilityTool uTool = new UtilityTool();
        try {
           tile[index] = new Tile();
           tile[index]. image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imageName +".png"));
           tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
           tile[index].collision = collision;

        } catch (Exception e) {
           e.printStackTrace();
        }

    }
    public void FlyColOff(){
           
        setup(5, "NewTree", false);
        setup(3, "Mud", false);
        setup(6, "Water", false);
        setup(7, "WaterTopLand", false);
        setup(8, "WaterDownLand", false);
        setup(9, "WaterLeftLand", false);
        setup(10, "WaterRightLand", false);
        

}

public void loadMap(String filePath){

    try {
        
        InputStream is = getClass().getResourceAsStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));


        int col = 0;
        int row = 0;

        while (row < gp.maxWorldRow) {
            String line = br.readLine();

            while (col < gp.maxWorldCol) {
                String number[] = line.split(" ");

                int num = Integer.parseInt(number[col]);

                mapTileNum[col][row] = num;
                col++;
            }

            if (col == gp.maxWorldCol){
                col = 0;
                row++;
            }
           
            
        }
         br.close();
    } catch (Exception e){


    }
       
}

     public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
        

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            
             int tileNum = mapTileNum[worldCol][worldRow];

            int worldx = worldCol * gp.tileSize;
            int worldy = worldRow * gp.tileSize;
            int screenX = worldx - gp.player.worldx + gp.player.screenX;
            int screenY = worldy - gp.player.worldy + gp.player.screenY;

            if (worldx + gp.tileSize > gp.player.worldx - gp.player.screenX &&
                worldx - gp.tileSize < gp.player.worldx + gp.player.screenX &&
                worldy + gp.tileSize > gp.player.worldy - gp.player.screenY &&
                worldy - gp.tileSize < gp.player.worldy + gp.player.screenY
            ){
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);// dito na sya ma dodraw sa screen
            }

           
           worldCol++;
          

            if(worldCol == gp.maxWorldCol){
               worldCol = 0;
                worldRow++;
                

            }
        }
        
        }
}
