package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import object.OBJEgg;
import object.OBJHeart;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font Consolas_40, Consolas_80B;
BufferedImage keyImage; 

BufferedImage fullHeart, halfHeart, noHeart;
public boolean messageOn = false;
public String message = "";
int messageCounter = 0;
public boolean gameFinished = false;
public String currentDialog = "";
public int commandNum = 0;



    public UI(GamePanel gp){
        this.gp = gp;
        Consolas_40 = new Font("Consolas", Font.PLAIN,35);
        Consolas_80B = new Font("Consolas", Font.BOLD,70);
        OBJEgg egg = new OBJEgg(gp);
       keyImage = egg.image;

        // Create 
        Entity heart = new OBJHeart(gp);
        fullHeart = heart.image;
        halfHeart = heart.image2;
        noHeart = heart.image3;
    }

public void showMessage(String text){
    message = text;
    messageOn = true;
}
    public void draw(Graphics2D g2){
// ito para sa pause and play state
        this.g2 = g2;
        g2.setFont(Consolas_40);
        g2.setColor(Color.white);
        // Tittle state
        if(gp.gameState == gp.tittleState){
            drawTileScreen();
            
        }
        // PLayState
        if (gp.gameState == gp.playState){
            drawPlayerLife();
            eggCounter();
        // PauseState
        }if (gp.gameState == gp.pauseState){
            drawPauseScreen();
            drawPlayerLife();
            eggCounter();
        }
        //DialogState
        if(gp.gameState == gp.dialogState){
            drawDialogScreen();
            drawPlayerLife();
        }

   

// tresure to para sa pag collect ng eggs 
    if (gameFinished == true){

        g2.setFont(Consolas_40);
        g2.setColor(Color.white);

        String text;
        int textLength;
        int x;
        int y;

        text = "You found the exit!";
        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y = gp.screenHeight/2 - (gp.tileSize * 3);
        g2.drawString(text, x, y);
       
        

        g2.setFont(Consolas_80B);
        g2.setColor(Color.yellow);

        text = "Congratulations!";
        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y = gp.screenHeight/2 + (gp.tileSize * 3);
        g2.drawString(text, x, y);

       gp.gamThread = null;

    }
        if (messageOn == true){

            g2.setFont(g2.getFont().deriveFont(15F));
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

            messageCounter++;

            if (messageCounter > 120){

                messageCounter = 0;
                messageOn = false;
            }
        }
      }      
      
      public void eggCounter(){
         // eggs drawing in screen yung may bilang
          g2.setFont(new Font("Consolas", Font.PLAIN,28));
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize+28, gp.tileSize,gp.tileSize,null);
        g2.drawString("= "+gp.player.hasKey, 70, 100);
      }


      public void drawPlayerLife(){
       
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        // draw  max heart
        while (i < gp.player.maxLife/2) {
            g2.drawImage(noHeart, x, y, null);
            i++;
            x += gp.tileSize;
            
        }
        // Reset
         x = gp.tileSize/2;
         y = gp.tileSize/2;
         i = 0;

        // Draw Current Life
        while ( i < gp.player.life) {
            g2.drawImage(halfHeart, x, y, null);
            i++;
            if ( i < gp.player.life) {
                g2.drawImage(fullHeart, x, y, null);
            }
            i++;
            x+= gp.tileSize;
        }

      }

    // tittle state
    public void drawTileScreen(){
        g2.setColor(new Color(0,100,0));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        // Title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80));
         String text = "Dino Block";        
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        // shadow
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //Frame 
         g2.drawImage(gp.player.Frame, 0, 0, gp.screenWidth, gp.screenHeight, null);
        // main color
        g2.setColor(new Color(50,205,50));
        g2.drawString(text, x, y);

        // Dino image
        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.right1, x, y, gp.tileSize*2, gp.tileSize*2, null);

        //MENU
        g2.setFont(new Font("Georgia", Font.BOLD,32));
        
        if (gp.gameState == gp.tittleState){
            if(gp.player.life <= 0){
            gp.keyH.deathCounter++;
            
            }
            if(gp.keyH.deathCounter == 0){
            text = "NEW GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if (commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
            gp.music.stop();
            }
            }
        }
        
   
        text = "LOAD GAME";
        if(gp.player.life <= 0){
            x = getXforCenteredText(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
        } else {
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
        }
        
         if (commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }
    
        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
         if (commandNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }
        
        if(gp.player.life <= 0){
        text = "RETRY";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        
         if (commandNum == 3){
            g2.drawString(">", x-gp.tileSize, y);
         }
    }
   
      
        
        

    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }


    //Dialog Window
    public void drawDialogScreen(){
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        // yung text to sa window
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,18));// font sa text
        x += gp.tileSize;
        y += gp.tileSize;

        
        for(String line : currentDialog.split("\n")){
            g2.drawString(line, x, y);
            y += 25;
        }
                
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0, 150);// rgb for black // a = for transparency 
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 20, 20);

        // For Frame sa Window yung white
        c = new Color(255,255,255);// 255 is the rgb number for white
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 5, 5);
    }

    // for the text pause 
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
       int x = gp.screenWidth/2 - length/2;
       return x;

    }
}
