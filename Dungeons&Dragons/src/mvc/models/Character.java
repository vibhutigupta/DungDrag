package mvc.models;

public class Character {


	String c_name;
	int c_level;
	String c_class;
	
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_level() {
		return c_level;
	}
	public void setC_level(int c_level) {
		this.c_level = c_level;
	}
	public String getC_class() {
		return c_class;
	}
	public void setC_class(String c_class) {
		this.c_class = c_class;
	}
	@Override
	public String toString() {
		return "Character [c_name=" + c_name + ", c_level=" + c_level
				+ ", c_class=" + c_class + "]";
	}
	

	
}


