package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Phone")
public class Phone extends Product{
    @Column(name = "OS")
    private String operationSystem;

    @Column(name = "memory")
    private int memory;

    public Phone() {

    }

    public Phone(String productTitle, int productPrice, String operationSystem, int memory) {
        super(productTitle, productPrice);
        this.operationSystem = operationSystem;
        this.memory = memory;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
