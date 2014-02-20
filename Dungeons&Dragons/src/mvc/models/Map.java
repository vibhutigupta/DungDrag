package mvc.models;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

public class Map {

	Vector<Tile> map;
	
	public Map(){
		Vector<Tile> tiles;
	}
	
	public Map loadMap(String path){
		
	
		
		String data = "GGGGGGGG\nGGGGGGGG\nGGGGGGGG\nGGGGGGGG\nGGGGGGGG\nGGGGGGGG\nGGGGGGGG\nGGGGGGGG\n";	//Store data from file into string object
		
		String[] splitData = data.split("\n");
		//Parse th data from file and build map object
		Tile t = new Tile();
		for (int i =0;i<splitData.length;i++){
			String row = splitData[i];
			for (int j=0;j<row.length();j++){
				t.setX(j);
				t.setY(i);
				t.setTileElement(row.charAt(j));
				map.add(t);
			}
			
		}
		
		JPanel mapPanel = new JPanel(new GridLayout(8,8));
		ArrayList<Rectangle> squares = new ArrayList<Rectangle>();
		Rectangle r = new Rectangle();
		for (int i =0;i<8;i++){
			squares.add(r);
		}
		

		
		
		return null;
	}
}
