/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MapEditor.java
 *
 * Created on 22-Feb-2014, 4:43:34 PM
 */
package mvc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mvc.controllers.MapSelectionListener;

/**
 * 
 * @author sharathsind
 */
class DrawRect extends JPanel {
	private String ngjyra = "BLACK";
	Color color;
	BufferedImage image;

	public DrawRect(String b) {
		ngjyra = b;

	}

	public void paint(Color c) {
		color = c;
		validate();
	}

	/*
	 * @Override protected void paintComponent(Graphics g) {
	 * super.paintComponent(g); if(image!=null) { g.drawImage(image, 0, 0,
	 * null); } else if (color != null) { g.setColor(this.color); } else { if
	 * (ngjyra.equals("BLACK")) g.setColor(Color.BLACK); else
	 * g.setColor(Color.WHITE); } g.fillRect(0, 0, getWidth(), getHeight()); //
	 * add the square with the specified color
	 * 
	 * }
	 */
}

public class MapEditingscreen extends javax.swing.JFrame {
	File Map;
	String outputMap;
	DrawRect

	panels[][];

	/** Creates new form MapEditor */
	public MapEditingscreen(int dx, int dy, String Filename) {
		initComponents();
		outputMap = new String();
		outputMap = "dx=" + dx + ";dy=" + dy + ";";
		Map = new File(System.getProperty("user.dir") + "\\data\\maps\\"
				+ Filename + ".map");
		panels = new DrawRect[dx][dy];
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		jInternalFrame1.setLayout(new GridLayout(dx, dy, 3, 3));
		outputMap += "chests=";
		for (int row = 0; row < dx; row++)
			for (int col = 0; col < dy; col++) {
				boolean white = (col % 2 == 0) == (row % 2 == 0);
				panels[row][col] = new DrawRect(white ? "white" : "BLACK");

				// add();
				panels[row][col].setBackground(Color.LIGHT_GRAY);
				panels[row][col].addMouseListener(new MapSelectionListener());
				jInternalFrame1.add(panels[row][col]);
			}
		JLabel start = new JLabel("start");
		panels[dx - 1][0].add(start);
		panels[dx - 1][0].paint(Color.ORANGE);
		panels[dx - 1][0].setBackground(Color.ORANGE);
		JLabel stop = new JLabel("exit");
		panels[0][0].add(stop);
		panels[0][0].paint(Color.green);
		panels[0][0].setBackground(Color.green);
		BufferedImage myPicture = null;

		try {
			myPicture = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/data/images/images.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int counter = 0; counter < 10; counter++) {
			int chestX = (int) ((int) (dx - 1) * Math.random());
			int chestY = (int) ((int) (dy - 1) * Math.random());
			JLabel chest = new JLabel("C");
			panels[chestX][chestY].add(chest);
			outputMap += "[" + chestX + "," + chestY + "]";
			// panels[chestX][chestY].validate();
		}
		outputMap += ";Monsters=";
		for (int counter = 0; counter < 10; counter++) {
			int chestX = (int) ((int) (dx - 1) * Math.random());
			int chestY = (int) ((int) (dy - 1) * Math.random());
			JLabel chest = new JLabel("M");
			panels[chestX][chestY].add(chest);
			outputMap += "[" + chestX + "," + chestY + "]";
			// panels[chestX][chestY].validate();
		}
		outputMap += ";deserts=";
		int deserts = (int) (0.3 * (dx) * (dy));
		int water = (int) (0.3 * (dx) * (dy));
		for (int counter = 0; counter < deserts; counter++) {
			int chestX = (int) ((int) (dx - 1) * Math.random());
			int chestY = (int) ((int) (dy - 1) * Math.random());
			outputMap += "[" + chestX + "," + chestY + "]";
			panels[chestX][chestY].setBackground(Color.YELLOW);
			;
			// panels[chestX][chestY].validate();
		}
		outputMap += ";Water=";
		for (int counter = 0; counter < water; counter++) {
			int chestX = (int) ((int) (dx - 1) * Math.random());
			int chestY = (int) ((int) (dy - 1) * Math.random());
			panels[chestX][chestY].setBackground(Color.BLUE);
			;
			outputMap += "[" + chestX + "," + chestY + "]";
			// panels[chestX][chestY].validate();
		}
		outputMap += ";Rooms=";
		for (int row = 0; row < dx; row++) {
			for (int col = 0; col < dy; col++) {
				if (panels[row][col].getBackground() == Color.LIGHT_GRAY) {
					JLabel label = new JLabel("DL");
					JLabel label1 = new JLabel("DR");
					JLabel label2 = new JLabel("D");
					JLabel label3 = new JLabel("D");
					label.setLocation(panels[row][col].getLocation().x,panels[row][col].getY());
					setLayout(null);
					label.setSize(1,1 );
					panels[row][col].add(label);
					panels[row][col].add(label1);
					panels[row][col].add(label2);
					panels[row][col].add(label3);
					outputMap += "[" + row + "," + col + "]";
				}
				// add();
			}
		}

		try {
			FileWriter mapwriter = new FileWriter(Map.getAbsoluteFile());
			BufferedWriter buffer = new BufferedWriter(mapwriter);
			buffer.write(outputMap);
			buffer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	int dx, dy;

	public MapEditingscreen(String mapname) {
		// TODO Auto-generated constructor stub
		String line = null;
		initComponents();
		File map = new File(System.getProperty("user.dir") + "\\data\\maps\\"
				+ mapname);
		try {
			BufferedReader br = new BufferedReader(new FileReader(map));
			line = br.readLine();
			String cordinates[] = line.split(";");
			dx = Integer.parseInt(cordinates[0].split("=")[1]);
			dy = Integer.parseInt(cordinates[1].split("=")[1]);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputMap = new String();
		outputMap = "dx=" + dx + ";dy=" + dy + ";";
		Map = new File(System.getProperty("user.dir") + "\\data\\maps\\"
				+ mapname);
		panels = new DrawRect[dx][dy];
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		jInternalFrame1.setLayout(new GridLayout(dx, dy, 3, 3));
		outputMap += "chests=";
		for (int row = 0; row < dx; row++)
			for (int col = 0; col < dy; col++) {
				boolean white = (col % 2 == 0) == (row % 2 == 0);
				panels[row][col] = new DrawRect(white ? "white" : "BLACK");

				// add();
				panels[row][col].setBackground(Color.LIGHT_GRAY);

				jInternalFrame1.add(panels[row][col]);
			}
		JLabel start = new JLabel("start");
		panels[dx - 1][0].add(start);
		panels[dx - 1][0].paint(Color.ORANGE);
		panels[dx - 1][0].setBackground(Color.ORANGE);
		JLabel stop = new JLabel("exit");
		panels[0][0].add(stop);
		panels[0][0].paint(Color.green);
		panels[0][0].setBackground(Color.green);
		String cordinates[] = line.split(";");
		String chestcordinates[]=cordinates[2].split("=")[1].split("]");
		for(int i=0;i<chestcordinates.length;i++){
			JLabel chest = new JLabel("C");
			int chestX=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[0]);
			int chestY=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[1]);
			panels[chestX][chestY].add(chest);
			outputMap += "[" + chestX + "," + chestY + "]";
		}
		chestcordinates=cordinates[3].split("=")[1].split("]");
		for(int i=0;i<chestcordinates.length;i++){
			JLabel chest = new JLabel("M");
			int chestX=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[0]);
			int chestY=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[1]);
			panels[chestX][chestY].add(chest);
			outputMap += "[" + chestX + "," + chestY + "]";
		}
		chestcordinates=cordinates[4].split("=")[1].split("]");
		for(int i=0;i<chestcordinates.length;i++){
			int chestX=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[0]);
			int chestY=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[1]);
			panels[chestX][chestY].setBackground(Color.YELLOW);
			;
			outputMap += "[" + chestX + "," + chestY + "]";
		}
		chestcordinates=cordinates[5].split("=")[1].split("]");
		for(int i=0;i<chestcordinates.length;i++){
			int chestX=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[0]);
			int chestY=Integer.parseInt(chestcordinates[i].replace("[", "").split(",")[1]);
			panels[chestX][chestY].setBackground(Color.BLUE);
			;
			outputMap += "[" + chestX + "," + chestY + "]";
		}
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: DorNOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jInternalFrame1 = new javax.swing.JInternalFrame();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jInternalFrame1.setVisible(true);
		setSize(1000, 1000);
		javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(
				jInternalFrame1.getContentPane());
		jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
		jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 873, Short.MAX_VALUE));
		jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 486, Short.MAX_VALUE));

		jButton1.setText("Save");

		jButton2.setText("discard");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addGap(67, 67, 67)
								.addComponent(jButton1).addGap(62, 62, 62)
								.addComponent(jButton2)
								.addContainerGap(636, Short.MAX_VALUE))
				.addComponent(jInternalFrame1));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(jInternalFrame1)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JInternalFrame jInternalFrame1;
	// End of variables declaration//GEN-END:variables

}
