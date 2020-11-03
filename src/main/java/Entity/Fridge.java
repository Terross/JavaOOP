package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Fridge")
public class Fridge extends Product {
    @Column(name = "volume")
    private int volume;

    @Column(name = "noise_level")
    private int noiseLevel;

    public Fridge () {
        super();
    }

    public Fridge(String productTitle, int price, int volume, int noiseLevel) {
        super(productTitle, price);
        this.volume = volume;
        this.noiseLevel = noiseLevel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }
}
