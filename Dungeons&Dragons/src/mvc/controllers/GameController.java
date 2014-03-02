package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.Main;
import mvc.models.Character;
import mvc.models.GameModel;
import mvc.models.Variables;
import mvc.views.CharacterSelectionFrame;
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
			view.setCharacterSelectionFrameVisibility(true);

		}
		if (command.equalsIgnoreCase("newCharacter")){
			view.setCharacterSelectionFrameVisibility(false);
			view.setNewCharacterFrameVisibility(true);

		}
		if (command.equalsIgnoreCase("createCharacter")){
			
			view.setNewCharacterFrameVisibility(false);
			view.setCharacterSelectionFrameVisibility(true);
			//Create new character and save it to file
			Character c = new Character();			
			c.setC_class(view.getClassOptionGroupSelection());
			c.setC_level(1);
			c.setC_name(view.getCharacterName());
			saveCharacterFile(c);
			view.reloadCharacterSelectionFrame();

		}			

		if (command.equals("Fighter") || command.equals("Mage") || command.equals("Archer")){
			view.setClassImage(Variables.IMAGE_PATH+ command+ ".png");		
		}


	}

	private List<Character> loadCharacters() {

		List<Character> characterList = new ArrayList<Character>();

		File navigate = new File(Variables.CHARACTER_SAVE_PATH);
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
		return characterList;}

	private void saveCharacterFile(Character c) {

		System.out.println(c);
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(Variables.CHARACTER_SAVE_PATH+c.getC_name()+".txt");
			// set the properties value
			prop.setProperty("name", c.getC_name());
			prop.setProperty("level", c.getC_level()+"");
			prop.setProperty("class", c.getC_class());

			// save properties to project root folder
			prop.store(output, null);
			output.close();

		} catch (IOException io) { 
			System.out.println("GameController.saveCharacterFile()");
			io.printStackTrace();

		}





	}




}





