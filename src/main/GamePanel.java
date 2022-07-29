package main;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthScrollBarUI;

import entity.Player;
import tile.TileManager;

import java.awt.*;
import java.time.chrono.ThaiBuddhistChronology;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxScreenCol;
    public final int worldHeight = tileSize * maxScreenRow;


    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker c = new CollisionChecker(this);
    public Player player = new Player(this, keyH);

    //FPS
    int FPS = 60;

    // // set player's default position
    // int playerX = 100;
    // int playerY = 100;
    // int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension (screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            update();

            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void update(){
        player.update();
        // if(keyH.upPressed == true){

        //     playerY -= playerSpeed;
        // }
        // else if(keyH.downPressed== true){
        
        //     playerY += playerSpeed;
        // }
        // else if(keyH.leftPressed== true){
        
        //     playerX -= playerSpeed;
        // }
        // else if(keyH.rightPressed== true){
            
        //     playerX += playerSpeed;
        // }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);

        // g2.setColor(Color.white);
        // g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }

}
