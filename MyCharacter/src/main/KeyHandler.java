package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    GamePanel gp;
    public boolean up, down, left, right, enterPressed;
   public int gameNum = 0;
   public int deathCounter = 0;

//Debug 
    boolean checkDrawTime= false;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }


    public void keyTyped(KeyEvent e) {

    }
    

 public int code;
    @Override
    public void keyPressed(KeyEvent e) {
        code = e.getKeyCode();

        // Tittle State
        if (gp.gameState == gp.tittleState){
            if (code == KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                if(gp.keyH.gameNum >= 1 ){
                            if(gp.ui.commandNum < 0){
                            gp.ui.commandNum = 3;
                            }
                 }
                else if (gp.keyH.gameNum < 1) {
                        
                    } if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                }

                }
            if (code == KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                if(gp.keyH.gameNum >= 1 ){
                        if(gp.ui.commandNum > 3){
                            gp.ui.commandNum = 0;
                            }
                 }
                else if(gp.keyH.gameNum < 1){
                        if (gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                         
                        }
                }
            }
                if (code == KeyEvent.VK_ENTER){
                    if (gp.ui.commandNum == 0 ){
                        if(gp.player.life <= 0 ){
                            gp.player.life = gp.player.maxLife;
                        }
                        gp.stopMusic();
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
    
                        gameNum +=1;
                    }

                     // yung load game ay testing ko palng, pagagandahin pa
                    if(gp.ui.commandNum == 1){
                          // add later
                    }

                    if(gp.ui.commandNum == 2){
                        System.exit(0);
                    }
                if (code == KeyEvent.VK_ENTER){
                    if(gp.ui.commandNum == 3 && gameNum >= 1){
                        gp.stopMusic();
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                        gp.player.life = gp.player.maxLife;
                        gp.player.worldx = gp.tileSize *14;
                        gp.player.worldy = gp.tileSize *14;
                        
                      
                    }
                    enterPressed = false;
                }
                }
        }
        // PlayState
        else if(gp.gameState == gp.playState){ 

            if (code == KeyEvent.VK_W){
                up = true;
            }
            if (code == KeyEvent.VK_S){
                down = true;
            }
            if (code == KeyEvent.VK_A){
                left = true;
            }
            if (code == KeyEvent.VK_D) {
                right = true;
                
            }
                if (code == KeyEvent.VK_UP){
                    up = true;
                }
                if (code == KeyEvent.VK_DOWN){
                down = true;
                }
                if (code == KeyEvent.VK_LEFT){
                left = true;
                }
                if (code == KeyEvent.VK_RIGHT) {
                right = true;
                }    
                if (code == KeyEvent.VK_ENTER) {
                    enterPressed = true;
                }

                 if (code == KeyEvent.VK_P) {
                    gp.music.stop();
                    gp.gameState = gp.pauseState;
                    gp.music.stop();

                }
                    //PauseState
        }  else if (gp.gameState == gp.pauseState){
                   if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.playState;
                    gp.music.play();
                    
                }
            }
            
                // Debug
            else if (code == KeyEvent.VK_T){
                if(checkDrawTime == false){
                    checkDrawTime = true;
                }else if(checkDrawTime == true){
                    checkDrawTime = false;
                }
            }
        
    
      
           
            //DialogState
             if(gp.gameState == gp.dialogState){
                if(code == KeyEvent.VK_ENTER){
                    gp.gameState = gp.playState;
                }
            }
            
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
                up = false;
            }
            if (code == KeyEvent.VK_S){
                down = false;
            }
            if (code == KeyEvent.VK_A){
                left = false;
            }
            if (code == KeyEvent.VK_D) {
                right = false;
            }

                if ( code == KeyEvent.VK_UP) {
                    up = false;
                }

                if (code == KeyEvent.VK_DOWN){
                down = false;
                }
                if (code == KeyEvent.VK_LEFT){
                left = false;
                }
                if (code == KeyEvent.VK_RIGHT) {
                right = false;

                }
    }
    public void NewRetry(){

    }

}
