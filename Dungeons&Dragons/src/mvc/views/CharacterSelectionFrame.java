package mvc.views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import mvc.controllers.GameController;
import mvc.models.Character;
import mvc.models.Variables;

@SuppressWarnings("serial")
public class CharacterSelectionFrame extends JFrame {


	private JLabel classImage;
	private JPanel characterSelectionPanel,newCharacterPanel;
	private JFrame newCharacterFrame;
	JTextField characterNameField;
	ButtonGroup classOptionGroup;
	public CharacterSelectionFrame(){ 


		//Setup classSelection frame and it's components
		
		this.setTitle("Select Your Character");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		characterSelectionPanel = new JPanel(new BorderLayout());
		JButton newCharacterButton = new JButton("Create New Character");
		newCharacterButton.setActionCommand("newCharacter");


		JButton selectMapButton = new JButton("Next");
		selectMapButton.setActionCommand("selectMap");

		JPanel southPanel = new JPanel();
		southPanel.add(newCharacterButton);
		southPanel.add(selectMapButton);
		characterSelectionPanel.add(southPanel,BorderLayout.SOUTH);
		reloadCharacterPanel();
		this.add(characterSelectionPanel);
		/** **/


		//Setup create new character frame and it's elements
		characterNameField = new JTextField(20);
		JRadioButton fighterButton = new JRadioButton("Fighter");
		JRadioButton mageButton = new JRadioButton("Mage");
		JRadioButton archerButton = new JRadioButton("Archer");
		classOptionGroup = new ButtonGroup();		
		classOptionGroup.add(fighterButton);
		classOptionGroup.add(mageButton);
		classOptionGroup.add(archerButton);
		fighterButton.setSelected(true);
		classImage = new JLabel(new ImageIcon(".\\data\\images\\Fighter.png"));
		classImage.setPreferredSize(new Dimension(50, 50));
		JButton createButton = new JButton("Create");
		createButton.setActionCommand("createCharacter");


		newCharacterPanel = new JPanel();		
		newCharacterPanel.add(new JLabel("Enter Name:"));
		newCharacterPanel.add(characterNameField);
		newCharacterPanel.add(new JLabel("Choose your class"));
		newCharacterPanel.add(fighterButton);
		newCharacterPanel.add(mageButton);
		newCharacterPanel.add(archerButton);
		newCharacterPanel.add(classImage);
		newCharacterPanel.add(createButton);

		newCharacterFrame = new JFrame("Create a new Character");
		newCharacterFrame.setSize(400,300);
		newCharacterFrame.add(newCharacterPanel);
		newCharacterFrame.setVisible(false);

		newCharacterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		/** **** ***/

	}


	/**
	 * 
	 * @return
	 */
	public String getCharacterName() {
		return characterNameField.getText();
	}


	public String getClassOptionGroupSelection() {
		
		String c_class = "";

		for (Enumeration<AbstractButton> buttons = classOptionGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                c_class =   button.getText();
            }
        }

		return c_class;

	}



	private List<Character> loadCharacters() {

		List<Character> characterList = new ArrayList<Character>();

		String characterPath = ".\\data\\characters\\";

		File navigate = new File(characterPath);
		File[] characterFiles = navigate.listFiles();
		Properties prop = new Properties();
		InputStream input = null;


		for (int i=0;i<characterFiles.length;i++){
			File f = characterFiles[i];

			try {
				input = new FileInputStream(f.getAbsoluteFile());
				prop.load(input);
			} catch (IOException e) {
				System.out.println("CharacterSelectionFrame.loadCharacters()");
				e.printStackTrace();
			}
			//Create the characters from the data files and add them to a list 
			Character character = new Character();			
			character.setC_name(prop.getProperty("name"));
			character.setC_level(Integer.parseInt(prop.getProperty("level")));
			character.setC_class(prop.getProperty("class"));
			characterList.add(character);			
		}
		return characterList;

	}

	/**
	 * 
	 * @param visibility
	 */
	public void setNewCharacterFrameVisibility(boolean visibility){

		newCharacterFrame.setVisible(visibility);
	}

	/**
	 * Register listener (controller) to all components (buttons/radio buttons/fields) so that the controller can respond to the user input and initiate the necessary action	  
	 * @param controller - the controller receiving user input
	 */
	public void registerListener(GameController controller){

		
		Component[] components = characterSelectionPanel.getComponents();
		for (Component component : components) {
			if (component instanceof JPanel) {
				Component[] c2 = ((JPanel) component).getComponents();
				for (Component subcomponent :  c2) {
					if (subcomponent instanceof AbstractButton) {
						AbstractButton button = (AbstractButton) subcomponent;
						button.addActionListener(controller);
					}

				}
			}

			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}

		components = newCharacterPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}


	}
	public void setIcon(String path){
		classImage.setIcon(new ImageIcon(path));
	}


	public void reloadCharacterPanel() {
		
		
		List<Character> characterList =  loadCharacters();
		JPanel existingCharactersPanel = new JPanel(new GridLayout(characterList.size()+1,1,10,2));
		
		for (int i=0; i<characterList.size(); i++){
			
			
			JPanel subCharacterPanel = new JPanel();	
			subCharacterPanel.add(new JRadioButton());
			subCharacterPanel.add(new JLabel(new ImageIcon(Variables.IMAGE_PATH+characterList.get(i).getC_class()+".png")));
			subCharacterPanel.add(new JLabel(characterList.get(i).getC_name()));			
			subCharacterPanel.add(new JLabel("Level "+characterList.get(i).getC_level()+" "+characterList.get(i).getC_class()));
			subCharacterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			existingCharactersPanel.add(subCharacterPanel);
			
			
		}
		Component[] components = characterSelectionPanel.getComponents();
		Component c = null;
		for (int i = 0;i<components.length;i++){
			c = components[i];
			System.out.println(c);
		}
		

		
		characterSelectionPanel.removeAll();
		characterSelectionPanel.add(existingCharactersPanel,BorderLayout.CENTER);		
		characterSelectionPanel.add(c,BorderLayout.SOUTH);
		characterSelectionPanel.repaint();
		characterSelectionPanel.validate();
		
	}



}
