package mvc.views;

import java.awt.*;

import javax.swing.*;

import mvc.controllers.GameController;

public class GameView {

	private JFrame mainMenuFrame;
	private CharacterSelectionFrame characterSelectionFrame;
	private JFrame gamePlayFrame;
	private JPanel mainPanel,centerPanel,southPanel,gameplayPanel,mapSelectionPanel;
	private JLabel logo = new JLabel(new ImageIcon(".\\data\\images\\dnd.png"));
	private JLabel classImage;

	public GameView(){

		//Setup and initialize mainMenu Frame and it's components
		mainMenuFrame = new JFrame();
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainMenuFrame.setTitle("Dungeons & Dragons"); 
		mainMenuFrame.setSize(900,900);
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton newGameButton,mapEditorButton,creditsButton;       
		mainPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel();
		southPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		southPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		newGameButton = new JButton("New Game");
		mapEditorButton = new JButton("Map Editor");
		creditsButton = new JButton("Credits");
		centerPanel.add(newGameButton);
		centerPanel.add(mapEditorButton);
		centerPanel.add(creditsButton);

		mainPanel.add(logo,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		mainPanel.add(southPanel,BorderLayout.SOUTH);
		mainMenuFrame.add(mainPanel); 
		/** **** ***/


		//Setup classSelection frame and it's components
		gamePlayFrame = new JFrame("Dungeons & Dragons Basic");
		gameplayPanel = new JPanel();			//Primary panel for gameplay
		gamePlayFrame.setSize(600,600);
		gamePlayFrame.add(gameplayPanel);
		/** **** ***/


		//Setup classSelection frame and it's components
		mapSelectionPanel = new JPanel();		//Panel for map selection
		mapSelectionPanel.setSize(600,600);
		/** **** ***/


		characterSelectionFrame = new CharacterSelectionFrame();
		mainMenuFrame.setVisible(false);
		characterSelectionFrame.setVisible(false);
		gamePlayFrame.setVisible(false);

	}

	
	
	public void registerListener(GameController controller){


		Component[] components = centerPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {	
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}
		characterSelectionFrame.registerListener(controller);

	}
	
	
	public String getCharacterName() {
		return characterSelectionFrame.getCharacterName();
	}


	public String getClassOptionGroupSelection() {
		return characterSelectionFrame.getClassOptionGroupSelection();

	}

	public void setMainFrameVisibility(boolean visibility){
		mainMenuFrame.setVisible(visibility);		
	}

	public void setCharacterSelectionFrameVisibility(boolean visibility){
		characterSelectionFrame.setVisible(visibility);		
	}	
	public void setGamePlayFrameVisibility(boolean visibility){
		gamePlayFrame.setVisible(visibility);
	}

	public void setNewCharacterFrameVisibility(boolean visibility){
		characterSelectionFrame.setNewCharacterFrameVisibility(visibility);
	}

	/**
	 * 
	 * @param path
	 */
	public void setClassImage(String path) {
		characterSelectionFrame.setIcon(path);	

	}

	public void loadMap(JPanel mapPanel){
		gameplayPanel.add(mapPanel);
	}



	public void reloadCharacterSelectionFrame() {
		characterSelectionFrame.reloadCharacterPanel();
	}





}
