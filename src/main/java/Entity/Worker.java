package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Worker")
public class Worker{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "floor_number")
    private int floorNumber;

    public Worker() {

    }

    public Worker(String firstName, String secondName, int salary, int floorNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.floorNumber = floorNumber;
    }

    public void setId(int id) {
        this.workerId = id;
    }

    public int getId() {
        return workerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }


}
