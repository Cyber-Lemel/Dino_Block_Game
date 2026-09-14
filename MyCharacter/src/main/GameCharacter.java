package main;

import javax.swing.JFrame;

public class GameCharacter {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("DinoBlock");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // preferred for setting size based on JPanel

        window.setLocationRelativeTo(null); // center on screen
        window.setVisible(true);

        gamePanel.setupGame();

        gamePanel.startGameThread();
    }
}
