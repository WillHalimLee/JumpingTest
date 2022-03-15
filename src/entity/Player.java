package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public final int maxFall;
    ArrayList<Integer> save = new ArrayList<>();

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2;
        screenY = gp.screenHeight / 2;

        solidArea = new Rectangle(16, 16, 12, 12);

        maxFall = 125 * gp.tileSize;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        CharX = gp.tileSize * 6;
        CharY = gp.tileSize * 125;
        speed = 5;
        direction = "right";
        jump = "";

    }


    public void gravity() {
        int falling = 16;
        keyH.gravity =true;
        if (keyH.gravity && !platform) {
            if (CharY < maxFall) {
                    CharY += falling;
            } else {
                keyH.gravity = false;
                collisionOn =false;
            }
            platform = true;
        }
    }

    public void jump() {
        speed = 15;
                CharY -= speed;

    }
    public void reSpawn(){
        if(save.isEmpty()){
            save.add(CharY);
            save.add(CharX);
        }else {
            save.set(0, CharX);
            save.set(1, CharY);
        }
        savePoint = false;

    }
    public void death(){
        CharX = save.get(0);
        CharY = save.get(1);
        death = false;
    }

    public void getPlayerImage() {

        Player_One();
    }


    public void update() {
        if(savePoint) {
            reSpawn();
        }
        if (death) {
            death();
        }


        if ((keyH.leftPressed || keyH.rightPressed)) {
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
                direction = "right";
            }
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (!collisionOn) {
                keyH.gravity = true;
                switch (direction) {
                    case "left" -> {
                        speed = 6;
                        CharX -= speed;
                    }
                    case "right" -> {
                        speed = 6;
                        CharX += speed;
                    }
                }
            }
                spriteCounter++;
                if (spriteCounter > 15) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }

            }

        collisionOn = false;
        gp.cChecker.checkTile(this);
        if (!collisionOn) {
            if (keyH.upPressed && !keyH.jumpLock) {
                jump = "up";
                jump();
                platform=false;
            } else {
                jump = "falling";
                keyH.gravity = true;
                gravity();
            }

            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else {
            gravity();
        }

    }



    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "left" -> {
                if (spriteNum == 1) {
                    image = standLeft;
                }
                if (spriteNum == 2) {
                    image = walkLeft;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = standRight;
                }
                if (spriteNum == 2) {
                    image = walkRight;
                }
            }
        }
        if (jump.equals("up") && direction.equals("right")) {
            if (spriteNum == 1) {
                image = squatRight;
            }
            if (spriteNum == 2) {
                image = standRight;
            }

        }
        if (jump.equals("up") && direction.equals("left")) {
            if (spriteNum == 1) {
                image = squatLeft;
            }
            if (spriteNum == 2) {
                image = standLeft;
            }

        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

}

