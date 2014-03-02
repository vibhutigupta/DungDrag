package mvc.models;

import java.io.File;

import javax.swing.AbstractListModel;

public class MapListModel extends AbstractListModel {
public String Maps[];
public MapListModel() {
	// TODO Auto-generated constructor stub
	
	 File[] listOfFiles = new File(System.getProperty("user.dir")+"\\data\\maps").listFiles(); 
	 Maps =new String[listOfFiles.length];
	  for (int i = 0; i < listOfFiles.length; i++) 
	  {
	 
	   if (listOfFiles[i].isFile()) 
	   {
	   Maps[i] = listOfFiles[i].getName().split(".txt")[0];
	      }
	  }

}
	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return this.Maps[arg0];
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		if(this.Maps!=null)
		return this.Maps.length;
		return 0;
	}

}
