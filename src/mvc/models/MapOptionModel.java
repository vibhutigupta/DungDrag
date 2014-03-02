package mvc.models;

public class MapOptionModel {
	public boolean create=true;
	public int dx;
	public int dy;
	public String mapname;
	public MapOptionModel() {

	}
	public void intialize(String map,int dx,int dy)
	{
		this.dx=dx;
		this.dy=dy;
		this.mapname=map;
	}

}
