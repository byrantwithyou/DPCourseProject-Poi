package tools;

public abstract class BaseTools {
	
	private String id;
	private boolean isBusy;
//	private String name;
	


	public BaseTools() {
        this.isBusy = false;
	}

	public boolean checkIfBusy() {
		return isBusy;
	}

    public void setBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }
	
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
