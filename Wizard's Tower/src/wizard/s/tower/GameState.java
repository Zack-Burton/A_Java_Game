package wizard.s.tower;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class GameState extends State {

    private Game game;
    private static Player player;
    private static Enemy enemy;
    private static Manager manager;
    private State inventory;
    private static Item mace;
    private static Item hammer;
    private UIObject hammerTxt;
    private UIObject maceTxt;
    private boolean pause;
    private final UIObject invTitle;
    public Object[] test;
    public double buffer;
    public boolean set = true;

    private wall map;

    public GameState(Handler handler) {
        super(handler);
        manager = new Manager(handler);
        player = new Player(15, 15, 10, 10,1,handler);
        enemy = new Enemy(100, 100, 15, 15, 150,2,handler);
        mace = new Item("mace", 200, 200, 10, 10, handler);
        hammer = new Item("hammer", 250, 250, 10, 10, handler);
        gui = new GUI(handler);
        map = new wall(handler, 100, 400);
       hammerTxt = new UIObject("hammer", 0, 70, false, Color.black, Color.red, GUI.font);
        maceTxt = new UIObject("mace", 0, 110, false, Color.black, Color.red, GUI.font);
        invTitle = new UIObject("Inventory",0,50,false,Color.black,GUI.font);
        addText(maceTxt);
        addText(hammerTxt);
        addText(invTitle);
        hammerTxt.active = false;
        maceTxt.active = false;
        invTitle.active = true;
        

    }

    public void inventoryTick()
    {
        if(Player.inventory.contains(hammer))
        {
            hammerTxt.active = true;
        }
        if(Player.inventory.contains(mace))
        {
            maceTxt.active = true;
        }
        gui.tick();
        if(hammerTxt.wasClick())
        {
            player.damage = 15;
        }
        if(maceTxt.wasClick())
        {
            player.damage = 20;
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)) {
           pause = false;
        }
        
    }
    public void shopRender(Graphics g)
    {
        gui.render(g);
    }
    
   public void path()
   {
       if(Math.sqrt(Math.pow((enemy.x-player.x),2)+Math.pow((enemy.y-player.y),2))>5)
       {
           if(enemy.x-player.x < 0)
               enemy.x ++;
           if(enemy.x-player.x > 0)
               enemy.x --;
           if(enemy.y-player.y<0)
               enemy.y ++;
           if(enemy.y-player.y >0)
               enemy.y --;
       }
       
   }
    
    int count;
    @Override
    public void tick() {
        if(count>100)
            count = 0;
        count++;
        if(pause)
        {
            inventoryTick();
            return;
        }
        if (handler.getMouseManager().isLeftPressed()) {
            System.out.println(player.damage);
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP))
        {
            Projectile proj=new Projectile(player.x,player.y,5,10,handler);
            
            proj.setYspeed(-5);
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN))
        {
            Projectile proj=new Projectile(player.x,player.y,5,10,handler);
            
            proj.setYspeed(5);
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT))
        {
            Projectile proj=new Projectile(player.x,player.y,5,10,handler);
            
            proj.setXspeed(-5);
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT))
        {
            Projectile proj=new Projectile(player.x,player.y,5,10,handler);
            
            proj.setXspeed(5);
        }
        if(count%player.speed ==0)
             player.tick();
        enemy.tick();
        hammer.tick();
        mace.tick();
        manager.tick();
        map.tick();
        
            for(int i = 0; i < Projectile.projectiles.length;i++)
           {
               if(Projectile.projectiles[i] != null)
               Projectile.projectiles[i].tick();
           }
        
        if(set && count%enemy.speed ==0)
        {
        path();
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)) {
           pause = true;
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SHIFT))
        {
            set = !set;
            System.out.println("changed active state");
        }
    }

    @Override
    public void render(Graphics g) {
        if (!pause) {
            map.render(g);
            player.render(g);
            enemy.render(g);
            mace.render(g);
            hammer.render(g);
            
           for(int i = 0; i< Projectile.projectiles.length;i++)
           {
               if(Projectile.projectiles[i] != null)
               Projectile.projectiles[i].render(g);
           }
        
            
        } else {
           shopRender(g);
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        GameState.player = player;
    }

    public static Enemy getEnemy() {
        return enemy;
    }

    public static void setEnemy(Enemy enemy) {
        GameState.enemy = enemy;
    }

    public static Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public static Item getMace() {
        return mace;
    }

    public void setMace(Item mace) {
        this.mace = mace;
    }

    public static Item getHammer() {
        return hammer;
    }

    public void setHammer(Item test2) {
        this.hammer = hammer;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public wall getMap() {
        return map;
    }

    public void setMap(wall map) {
        this.map = map;
    }

    public State getInventory() {
        return inventory;
    }

    public void setInventory(State inventory) {
        this.inventory = inventory;
    }

    public UIObject getHammerTxt() {
        return hammerTxt;
    }

    public void setHammerTxt(UIObject hammerTxt) {
        this.hammerTxt = hammerTxt;
    }

    public UIObject getMaceTxt() {
        return maceTxt;
    }

    public void setMaceTxt(UIObject maceTxt) {
        this.maceTxt = maceTxt;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

}
