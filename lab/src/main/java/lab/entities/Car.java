package lab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
    @Id @GeneratedValue
    private long id;

    private String name;
    private int speed;

    public Car() {
    }
    
    public Car(String name, int speed) {
    	this.name = name;
    	this.speed = speed;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
