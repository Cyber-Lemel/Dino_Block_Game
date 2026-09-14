package main;

public class EventHandler {
    GamePanel gp;
   
   EventRect eventRect[][];
   int previousEventX, previousEventY;
   boolean canTouchEvent = true;

    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col = 0;
        int row = 0;
        
        while ( col < gp.maxWorldCol && row < gp.maxWorldRow) {
        eventRect[col][row] = new EventRect();
        eventRect[col][row].x = 23;
        eventRect[col][row].y = 23;
        eventRect[col][row].width = 5;
        eventRect[col][row].height = 5;
        eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
        eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

        col++;
        if( col == gp.maxWorldCol){
            col = 0;
            row++;
        }
        }

    }
// event happens
    public void checkEvent(){

        //
        int xDistance = Math.abs(gp.player.worldx - previousEventX);
        int yDistance = Math.abs(gp.player.worldy - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize){
            canTouchEvent = true;
        }

if(canTouchEvent == true){

    if(hit(15,27,"right") == true){       
            damagePit(gp.dialogState);
    }
    if(hit(12, 17, "any") == true){
        healingPool(gp.dialogState);
    }
    if(hit(33, 9, "up") == true){
        teleportTile(33,9,33,5, gp.dialogState);
    }
    if(hit(37, 2, "any") == true){
        teleportTile(37,2,30,35, gp.dialogState); 
    }
    if(hit(30, 36, "down") == true){
        teleportTile(30,36,36,33, gp.dialogState); 
    }
    if(hit(34, 36, "any") == true){
        teleportTile(34,36,4,9, gp.dialogState); 
    }
    if(hit(3, 13, "any") == true){
        teleportTile(3,13,17,1, gp.dialogState); 
    }
    if(hit(25, 9, "any") == true){
        healingPool(gp.dialogState);
    }
    
}
    }

    public boolean hit(int col, int row, String reqDirection){

        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldx + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldy + gp.player.solidArea.y;

        eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;

        if ( gp.player.solidArea.intersects(eventRect[col][row]) && (eventRect[col][row].eventDone == false)){
            if( gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any") ){
                hit = true;  

                previousEventX = gp.player.worldx;
                previousEventY = gp.player.worldy;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;

        return hit;
    
    }

    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.playSE(7
        );
        gp.ui.currentDialog = " You fall to a Trap!";
        gp.player.life -= 1;

        if (gp.player.life <= 0){          
            gp.gameState = gp.tittleState;
            if(gp.gameState == gp.tittleState){
                gp.music.stop();
            }
            
           
        }
         canTouchEvent = false;
    }

    public void healingPool(int gameState){
        
        if( gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.player.attackCanceled = true;
            gp.ui.currentDialog = "You drink a Healing Water!";
            gp.player.life = gp.player.maxLife;
        }
            
    }
    public void teleportTile(int col, int row, int destCol, int destRow, int gameState){
        
         gp.gameState = gameState;
             gp.ui.currentDialog = "Teleport!";
           // gp.player.life = gp.player.maxLife;
            gp.player.worldx = gp.tileSize*destCol;
            gp.player.worldy = gp.tileSize*destRow;    
        //eventRect[col][row].eventDone = true;
    }

}
