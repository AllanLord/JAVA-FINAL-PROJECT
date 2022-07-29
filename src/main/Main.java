package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

public class Main{

    public static void main(String[] args) throws Exception {

        // new Field();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("IWATANI QUEST");
        
        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanel.startGameThread();






    }
}
