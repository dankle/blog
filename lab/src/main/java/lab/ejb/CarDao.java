package lab.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lab.entities.Car;



@Stateless
public class CarDao {
    @PersistenceContext
    private EntityManager em;

    public void saveCar(Car car) {
        if(car.getSpeed() == 0) {
            em.persist(car);
        } else {
            em.merge(car);
        }
    }

    public List<Car> getFastCars() {
        return em.createQuery("select c from Car c where c.speed > 200", Car.class).getResultList();
    }
}