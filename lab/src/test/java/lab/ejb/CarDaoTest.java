package lab.ejb;

import javax.inject.Inject;

import lab.ejb.CarDao;
import lab.entities.Car;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class CarDaoTest {
   @Inject
   private CarDao cardao;

   @Deployment
   public static JavaArchive createDeployment() {
      return ShrinkWrap.create(JavaArchive.class, "cars.jar").
    		  addClass(CarDao.class).
    		  addPackage(Car.class.getPackage()).
    		  addAsManifestResource("META-INF/persistence.xml", "persistence.xml").
    		  addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void testIsDeployed()
   {
      Assert.assertNotNull(cardao);
   }
   
   @Test
   public void testNewCar() {
       Assert.assertEquals(0, cardao.getFastCars().size());
       cardao.saveCar(new Car("Porsche", 320));
       Assert.assertEquals(1, cardao.getFastCars().size());
   }
   
}
