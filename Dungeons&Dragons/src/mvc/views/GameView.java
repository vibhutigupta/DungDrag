package mvc.views;

import java.awt.*;
import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import mvc.controllers.GameController;

public class GameView {

	private JFrame mainMenuFrame;
	private JFrame classSelectionFrame;
	private JFrame gamePlayFrame;
	private JPanel mainPanel,centerPanel,southPanel,classSelectionPanel,gameplayPanel,mapSelectionPanel;
	private JLabel logo = new JLabel(new ImageIcon(".\\data\\images\\dnd.png"));
	private JLabel classImage;
	
	public GameView(){

		//Setup and initialize mainMenu Frame and it's components
		mainMenuFrame = new JFrame();
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainMenuFrame.setTitle("Dungeons & Dragons"); 
		mainMenuFrame.setSize(900,900); 

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
		classSelectionFrame = new JFrame("Select your class");
		classSelectionFrame.setSize(600,600);
		classSelectionPanel = new JPanel();
		classSelectionPanel.add(new JLabel("Choose your class"));
		
		JButton classNextButton = new JButton("Start Game");
		classNextButton.setActionCommand("classSelectionNext");
		
		JButton mapNextButton = new JButton("Select Map");
		mapNextButton.setActionCommand("mapSelectionNext");
		

		
		JRadioButton fighterButton = new JRadioButton("Fighter");
		JRadioButton mageButton = new JRadioButton("Mage");
		JRadioButton archerButton = new JRadioButton("Archer");
		ButtonGroup classOptionGroup = new ButtonGroup();
		classOptionGroup.add(fighterButton);
		classOptionGroup.add(mageButton);
		classOptionGroup.add(archerButton);
		fighterButton.setSelected(true);
		classImage = new JLabel(new ImageIcon(".\\data\\images\\Fighter.png"));
		classImage.setPreferredSize(new Dimension(50, 50));
		
		classSelectionPanel.add(fighterButton);
		classSelectionPanel.add(mageButton);
		classSelectionPanel.add(archerButton);
		classSelectionPanel.add(classImage);
		classSelectionPanel.add(classNextButton);
		classSelectionPanel.add(mapNextButton);

	


		classSelectionFrame.add(classSelectionPanel);
		

		
		classSelectionFrame.add(classSelectionPanel);
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


		
		mainMenuFrame.setVisible(false);
		classSelectionFrame.setVisible(false);
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
		components = classSelectionPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}



	}
	

	public void setMainFrameVisibility(boolean visibility){
		mainMenuFrame.setVisible(visibility);		
	}

	public void setClassSelectionFrameVisibility(boolean visibility){
		classSelectionFrame.setVisible(visibility);		
	}	
	public void setGamePlayFrameVisibility(boolean visibility){
		gamePlayFrame.setVisible(visibility);
	}

	public void setClassImage(String path) {
		classImage.setIcon(new ImageIcon(path));		
	}

	public void loadMap(JPanel mapPanel){
		gameplayPanel.add(mapPanel);
	}





}
