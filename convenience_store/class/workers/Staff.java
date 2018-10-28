package workers;

public class Staff extends Employee {
	
	private String leader_id;
	
	
	
	public Staff() {
	}

	@Override
	public boolean isWorking() {
		return false;
	}

	@Override
	public boolean isBusy() {
		return false;
	}
	
	public String getLeader_id() {
		return leader_id;
	}

	public void setLeader_id(String leader_id) {
		this.leader_id = leader_id;
	}
	
}
