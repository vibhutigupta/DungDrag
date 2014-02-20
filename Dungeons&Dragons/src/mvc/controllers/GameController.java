package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.Main;
import mvc.models.GameFrame;
import mvc.models.GameModel;
import mvc.views.GameView;

public class GameController implements ActionListener{

	private GameModel model;
	private GameView view;

	public GameController(GameModel model, GameView view){

		this.model = model;
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
				
		String command = e.getActionCommand();		
		System.err.println(e);
		if (command.equals("New Game")){
			view.setMainFrameVisibility(false);
			view.setClassSelectionFrameVisibility(true);
		}
		if (command.equals("classSelectionNext")){
			view.setClassSelectionFrameVisibility(false);
			view.setGamePlayFrameVisibility(true);			
		}
		if (command.equals("Fighter") || command.equals("Mage") || command.equals("Archer")){
			view.setClassImage(".\\data\\images\\"+ command+ ".png");		
		}
		if (command.equalsIgnoreCase("mapSelectionNext")){
			GameFrame g = new GameFrame();
//			g.setVisible(true);
			
		}
		
		
		
		
	}

}



