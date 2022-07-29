package tile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;

public class TileManager {
    
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("maps/map01.txt");
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("tiles/bash.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("tiles/ocian.png"));
            tile[1].colision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("tiles/redWall.png"));
            tile[2].colision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("tiles/tree.png"));
            tile[3].colision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("tiles/sand.png"));
            

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void loadMap(String mapfile){

        try {
           InputStream is = getClass().getResourceAsStream(mapfile);
           BufferedReader br = new BufferedReader(new InputStreamReader(is));

           int col = 0;
           int row = 0;
           while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void draw(Graphics2D g2){
        int worldcol = 0;
        int worldrow = 0;
        
        
        while(worldcol < gp.maxWorldCol && worldrow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldcol][worldrow];

            int worldX = worldcol * gp.tileSize;
            int worldY = worldrow * gp.tileSize;
            int screenX = worldX -gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
            worldcol++;
            

            if(worldcol == gp.maxWorldCol){
                worldcol = 0;
               
                worldrow++;
                
            }

        }


    }


}
