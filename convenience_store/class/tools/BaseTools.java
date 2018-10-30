package tools;

public abstract class BaseTools {
	
	private String id;
	private boolean isbusy;
//	private String name;
	

	public abstract void work(Object requestBag, Object returnObj);

	public BaseTools() {
        this.isbusy = false;
	}

	public boolean isBusy() {
		return isbusy;
	}

    public void setIsbusy(boolean isBusy) {
        this.isbusy = isBusy;
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
