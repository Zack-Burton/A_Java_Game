package wizard.s.tower;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Manager {

    Handler handler;
    boolean playerAttack = true;
    public String choice;

    public Manager(Handler handler) {
        this.handler = handler;
    }

    public void tick() {
        int temp = -1;
        int inv = -1;
        bound();
       

        for (int i =0; i < Enemy.enemies.length;i++) {
            if (Enemy.enemies[i]!=null && GameState.getPlayer().getBound().intersects(Enemy.enemies[i].getBound())) {
                if (playerAttack) {
                    GameState.getPlayer().setHealth((int) (GameState.getPlayer().getHealth() - 1));
                } else {
                    GameState.getEnemy().setHealth((int) (GameState.getEnemy().getHealth() - GameState.getPlayer().damage));
                }
                playerAttack = !playerAttack;

            }
            
        }
        for (Item x : Item.items) {
            if (GameState.getPlayer().getBound().intersects(x.getBound())) {
                GameState.getPlayer().inventory.add(x);
                inv = Item.items.indexOf(x);
               
              
            }
        }
        if (inv >= 0) {
            Item.items.remove(inv);
        }
    }

    public void bound() {
        for (wall e : wall.maps) {
            for(Entity p : Player.pc)
            {
                
            
            if (p.bound.intersects(e.getBound())) {
                if (!e.getBound().contains(p.bound)) {
                    //checks to see if Bob is on a vertical side of map
                    if (p.getY() > e.getBound().getY() && p.getBound().getMaxY() < e.getBound().getMaxY()) {
//              checks to see which way it is supposed to move in the x direction
                        if (p.getBound().getMaxX() > e.getBound().getMaxX()) {
                            p.x++;
                        } else if (p.getBound().x < e.getBound().x) {
                            p.x--;
                        }

                    }
                    //checks to see if Bob is on a horizantal side of map
                    if (p.getBound().getMaxX() < e.getBound().getMaxX() && p.getBound().x > e.getBound().x) {
//                  checks to see wich way it is supposed to move in the y direction
                        if (p.getBound().y < e.getBound().y) {
                            p.y--;
                        } else if (p.getBound().getMaxY() > e.getBound().getMaxY()) {
                            p.y++;
                        }
                    }
                }
            }
            }
            
        for(int i =0; i<Projectile.projectiles.length;i++)
        {
            for(int j = 0; j<Enemy.enemies.length;j++)
            {
                if(Projectile.projectiles[i]!=null && Enemy.enemies[j]!= null && Projectile.projectiles[i].getBound().intersects(Enemy.enemies[j].getBound()))
                {
                    Projectile.projectiles[i] = null;
                    GameState.getEnemy().setHealth((int) (GameState.getEnemy().getHealth() - Projectile.damage));
                }
            }
         if(Projectile.projectiles[i]!=null && Projectile.projectiles[i].getBound().intersects(e.getBound()))
         {
             Projectile.projectiles[i] = null;
         }
        }
        }
    }

    public void playerDamage() {
        if(Player.inventory.isEmpty())
        {
        System.out.println("you have nothing in your inventory");
        return;
        }
        if (choice.equalsIgnoreCase("hammer")) {
            int temp = Player.inventory.indexOf(handler.getTest2());
            Item test = Player.inventory.get(temp);
            int x = test.getDamage();
            GameState.getPlayer().damage = x;
        } else {
            int temp = Player.inventory.indexOf(handler.getTest());
            Item test = Player.inventory.get(temp);
            int x = test.getDamage();
            GameState.getPlayer().damage = x;
        }

    }

}
