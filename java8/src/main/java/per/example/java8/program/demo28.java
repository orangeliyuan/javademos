package per.example.java8.program;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class demo28 {

    public String getName1(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Set<Optional<String>> getName2(List<Person> personList) {
        return personList.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName))
                .collect(Collectors.toSet());
    }
}

class Person {
    private Optional<Car> car;
    public Optional<Car> getCar() {
        return car;
    }
}

class Car {
    private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;
    public String getName() {
        return name;
    }
}
