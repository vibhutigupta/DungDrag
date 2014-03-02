/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Startgame.java
 *
 * Created on 19-Feb-2014, 5:19:12 PM
 */

package mvc.views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mvc.controllers.MapEditorController;
import mvc.models.MapListModel;
import mvc.models.MapOptionModel;

/**
 * 
 * @author sharathsind
 */
public class Startgame extends javax.swing.JFrame {
public	boolean creatd=false;
	/** Creates new form Startgame */
	public Startgame() {
		initComponents();
	}
	public int dx;
	public int dy;
	
	public Startgame(String mapname) {
		// TODO Auto-generated constructor stub
	creatd=true;
	initComponents();
	
	jTextField1.setEnabled(false);
	jTextField1.setText(mapname);
	File map=new File(System.getProperty("user.dir")+"\\data\\maps\\"+mapname);
    try {
		BufferedReader br = new BufferedReader(new FileReader(map));
		String line = br.readLine();
		String cordinates[]=line.split(";");
		dx=Integer.parseInt(cordinates[0].split("=")[1]);
		dy=Integer.parseInt(cordinates[1].split("=")[1]);
		jTextField2.setText(dx+"");
		jTextField3.setText(dy+"");
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField2.setSize(100, 100);
		jTextField3.setSize(100, 200);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Please enter the name and size of map");

		jLabel1.setText("Enter the name of map");

		jLabel2.setText("Enter the dimension:");

		jLabel3.setText("X:");
 
		jLabel4.setText("Y:");
		jTextField2.setText("     ");
		jTextField3.setText("     ");
		

		// jTextField3.setMaximumSize(new java.awt.Dimension(10, 20));

		jButton1.setText("next");
jButton1.setActionCommand("tomapeditor");
jButton1.addActionListener(new MapEditorController(this));
jButton2.addActionListener(new MapEditorController(this));
		jButton2.setText("back");
		jButton2.setActionCommand("backtooptions");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(29, 29,
																		29)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jTextField1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										127,
																										javax.swing.GroupLayout.PREFERRED_SIZE))))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(48, 48,
																		48)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel3))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton1)
																								.addGap(45,
																										45,
																										45)
																								.addComponent(
																										jButton2)))))
								.addContainerGap(130, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(68, 68, 68)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(34, 34, 34)
								.addComponent(jLabel2)
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										40, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addGap(24, 24, 24)));

		pack();
	}// </editor-fold>//GEN-END:initComponents
public boolean setMapDetails(MapOptionModel mapopt)

{
	MapListModel maplist=new MapListModel();
	for(String map :maplist.Maps){
		if(map.contains(jTextField1.getText())){
		return false;}
	}
	if(jTextField1.getText().length()<=0)
{
	return false;
	
}
try {
	Integer.parseInt(jTextField2.getText().trim().toString());
	Integer.parseInt(jTextField2.getText().trim().toString());
	mapopt.intialize(jTextField1.getText(), Integer.parseInt(jTextField2.getText().trim().toString()), Integer.parseInt(jTextField3.getText().trim().toString()));
	return true;
	
	
} catch (Exception e) {
	// TODO: handle exception\
	System.out.println(e);
	return false;
}



}
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Startgame().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	public javax.swing.JTextField jTextField1;
	public javax.swing.JTextField jTextField2;
public	 javax.swing.JTextField jTextField3;
public boolean setMapDetails1(MapOptionModel map) {
	// TODO Auto-generated method stub
	try {
		Integer.parseInt(jTextField2.getText().trim().toString());
		Integer.parseInt(jTextField2.getText().trim().toString());
		map.intialize(jTextField1.getText(), Integer.parseInt(jTextField2.getText().trim().toString()), Integer.parseInt(jTextField3.getText().trim().toString()));
		return true;
		
		
	} catch (Exception e) {
		// TODO: handle exception\
		System.out.println(e);
		return false;
	}
}

}
