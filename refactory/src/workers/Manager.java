package workers;

import java.util.ArrayList;

public class Manager extends Employee {
    public Manager(String id, String name) {
        super(id, name);
    }

    private ArrayList<Employee> followers = new ArrayList<>();

    public ArrayList<String> getFollowers() {
        ArrayList<String> s = new ArrayList<>();
        for (Employee e : followers) {
            s.add(e.getName());
            s.add(" ");
        }
        return s;
    }

    /**
     * 打印出该manager手下的所有员工姓名
     *
     */
    public void printOut() {
        ArrayList<String> s = this.getFollowers();
        StringBuffer sb = new StringBuffer();
        for (String str : s) {
            sb.append(str + " | ");
        }
        System.out.println(String.format("%s's staffs are: ",this.getName()));
        System.out.println(sb);
    }

    /**
     * 给该manager手下增加员工
     * @param id
     * @param name
     */
    public Staff addFollower(String id, String name) {
        Staff newStaff = new Staff(id, name);
        newStaff.setLeader_id(this.getId());
        this.followers.add(newStaff);
        return newStaff;
    }
}
