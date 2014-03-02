package mvc.controllers;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mvc.models.GameFrame;
import mvc.models.MapOptionModel;
import mvc.views.MapEditingscreen;
import mvc.views.MapOption;
import mvc.views.MapSelection;
import mvc.views.Startgame;

public class MapEditorController implements ActionListener {
	MapOption view;
	MapOptionModel model;
	Startgame view1;
	MapSelection mapview;

	public MapEditorController(MapOption view, MapOptionModel model) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
	}

	public MapEditorController(Startgame view) {
		this.view1 = view;
	}

	public MapEditorController(MapSelection map) {
		mapview = map;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.err.println(command);
		if (command.equals("Next")) {
			if (model.create) {
				Startgame g = new Startgame();
				view.dispose();
				g.setVisible(true);
			} else {
				MapSelection map = new MapSelection();
				map.setVisible(true);

			}

			// view.setMainFrameVisibility(false);
			// view.setClassSelectionFrameVisibility(true);
		}

		if (command.equals("Nextmap")) {
			Startgame g = new Startgame(mapview.jList1.getSelectedValue()
					.toString());
			mapview.dispose();
			g.setVisible(true);

		}
		if (command.equals("SelectMap")) {
			mapview.view.setMapName(mapview.jList1.getSelectedValue()
					.toString());
			mapview.dispose();
			//g.setVisible(true);

		}
		
		if (command.equals("tomapeditor")) {
			if (view1.creatd) {
				MapOptionModel map = new MapOptionModel();
				if (view1.jTextField2.getText().toString()
						.equals(String.valueOf(view1.dx + ""))
						&& view1.jTextField3.getText().toString()
								.equals(String.valueOf(view1.dy + ""))) {
					view1.dispose();
					MapEditingscreen screen = new MapEditingscreen(
							view1.jTextField1.getText());
					screen.setVisible(true);
				} else {
					if (view1.setMapDetails1(map)) {
						view1.dispose();
						MapEditingscreen screen = new MapEditingscreen(map.dx,
								map.dy, map.mapname);
						screen.setVisible(true);
						// model.create = false;
					} else {
						JOptionPane.showMessageDialog(view, "Invalid Input",
								"error", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
			// view.setClassSelectionFrameVisibility(false);
			// view.setGamePlayFrameVisibility(true);
			else {
				MapOptionModel map = new MapOptionModel();
				if (view1.setMapDetails(map)) {
					view1.dispose();
					MapEditingscreen screen = new MapEditingscreen(map.dx,
							map.dy, map.mapname);
					screen.setVisible(true);
					// model.create = false;
				} else {
					JOptionPane.showMessageDialog(view, "Invalid Input",
							"error", JOptionPane.ERROR_MESSAGE);

				}
			}

		}
		if (command.equals("Edit exisisting map")) {
			// view.setClassSelectionFrameVisibility(false);
			// view.setGamePlayFrameVisibility(true);
			model.create = false;

		}
		if (command.equalsIgnoreCase("Create anew Map")) {
			
			// g.setVisible(true);
			model.create = false;
		}
		if (command.equals("Back")) {
			view.dispose();
		}
		// if(command.equals("next")){

		// }
		// else{

		// }

	}

}
