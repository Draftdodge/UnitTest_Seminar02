import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleTest {

    Car car = new Car();
    Motorcycle motorcycle = new Motorcycle();



    //- проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void instanceOf() {
        assertThat(car).isInstanceOf(Vehicle.class);

    }

    //- проверка того, объект Car создается с 4-мя колесами
    @Test
    void WheelsCar() {
        Car car = new Car();
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
    //             - проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void WheelsMotorcycle() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    //- проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void testDriveCar(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void testDriveMotorcycle(){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    // - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void testDriveStopCar(){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    //- проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    void testDriveStopMotorcycle(){
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}