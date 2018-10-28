package tools;

public abstract class BaseTools {
	
	private String id;
	
//	private String name;
	


	public BaseTools() {
	}

	public boolean isBusy() {
		return true;
	}
	
	public abstract void work();
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	
}
