package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int CharX, CharY;
    public int speed;

    public BufferedImage squatRight, squatLeft, standLeft, walkLeft, standRight, walkRight;
    public String direction;
    public String jump;
    public int spriteCounter = 0;
    public int spriteNum =1;

    public Rectangle solidArea;
    public boolean collisionOn =false;
    public boolean platform = false;
    public boolean death = false;
    public boolean savePoint = false;


    public void Player_One(){
        try{
            squatRight = ImageIO.read(getClass().getResourceAsStream("/player/SquatRight.png"));
            squatLeft = ImageIO.read(getClass().getResourceAsStream("/player/SquatLeft.png"));
            standLeft = ImageIO.read(getClass().getResourceAsStream("/player/StandLeft.png"));
            walkLeft = ImageIO.read(getClass().getResourceAsStream("/player/WalkLeft.png"));
            standRight = ImageIO.read(getClass().getResourceAsStream("/player/StandRight.png"));
            walkRight = ImageIO.read(getClass().getResourceAsStream("/player/WalkRight.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Player_Two(){
        try{
            squatRight = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            squatLeft = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            standLeft = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            walkLeft = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            standRight = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            walkRight = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


