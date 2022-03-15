package main;

import entity.Entity;

public class CollisionCheck {
    GamePanel gp;

    public CollisionCheck(GamePanel gp) {

        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.CharX + entity.solidArea.x;
        int entityRightWorldX = entity.CharX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.CharY + entity.solidArea.y;
        int entityBottomWorldY = entity.CharY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision ) {
                    entity.collisionOn = true;
                    System.out.println("L col");
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision  || gp.tileM.tile[tileNum2].collision ){
                    entity.collisionOn = true;
                    System.out.println("R col");
                }
                break;
        }
        switch (entity.jump) {
            case "falling":
                entityBottomRow = (entityBottomWorldY - (entity.speed-(gp.tileSize/2))) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision  || gp.tileM.tile[tileNum2].collision ) {
                    entity.platform= true;
                    System.out.println("plats");

                }else{
                    entity.platform=false;
                    System.out.println("no plats");
                }
                break;
        }
        switch (entity.direction) {

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].death || gp.tileM.tile[tileNum2].death ) {
                    entity.death = true;
                    System.out.println("L col");
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].death  || gp.tileM.tile[tileNum2].death ){
                    entity.death = true;
                    System.out.println("R col");
                }
                break;
        }
        switch (entity.direction) {

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].save || gp.tileM.tile[tileNum2].save) {
                    entity.savePoint = true;
                    System.out.println("L col");
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].save  || gp.tileM.tile[tileNum2].save ){
                    entity.savePoint = true;
                    System.out.println("R col");
                }
                break;
        }
    }
}




