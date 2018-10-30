package workers;

public class Staff extends Employee {

    public Staff(String id, String name) {
        super(id, name);
        System.out.println(String.format("Staff %s constructed.",this.getName()));
    }

}
