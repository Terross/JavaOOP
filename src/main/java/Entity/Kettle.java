package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Kettle")
public class Kettle extends Product{
    @Column(name = "power")
    private int power;

    @Column(name = "temp_control")
    private String tempControl;

    public Kettle() {

    }

    public Kettle(String productTitle, int productPrice, int power, String tempControl) {
        super(productTitle, productPrice);
        this.power = power;
        this.tempControl = tempControl;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getTempControl() {
        return tempControl;
    }

    public void setTempControl(String tempControl) {
        this.tempControl = tempControl;
    }
}
