package workers;

public abstract class Employee {
	
	private String id;
	
	private String name;
	
	
	
	public Employee() {
	}
	
	public abstract boolean isWorking();
	
	public abstract boolean isBusy();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
