/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizard.s.tower;


/**
 *
 * @author 627885
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public StartUp(){
        
       
    }
    
    public static void main(String[] args) {
        Game game = new Game("game",500,500);
        game.start();
        
    }
    
}
