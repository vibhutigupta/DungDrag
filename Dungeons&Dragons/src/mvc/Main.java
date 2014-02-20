package mvc;

import javax.swing.SwingUtilities;

import mvc.models.*;
import mvc.views.*;
import mvc.controllers.*;

public class Main
{
    public static void main(String[] args) {           
       
    	    	
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	        
            	GameModel model = new GameModel();
            	GameView view = new GameView();
            	GameController controller = new GameController(model, view);
            	view.registerListener(controller);
            	view.setMainFrameVisibility(true);
            }
            
        });  
    }
}