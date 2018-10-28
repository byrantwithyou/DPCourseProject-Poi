package workers;

public class Manager extends Employee {
	
	private String[] followers;
	
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isWorking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBusy() {
		// TODO Auto-generated method stub
		return false;
	}
	

	public String[] getFollowers() {
		return followers;
	}

	public void setFollowers(String[] followers) {
		this.followers = followers;
	}

}
