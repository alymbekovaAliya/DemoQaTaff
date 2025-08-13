package com.demoqa.data;

import com.github.javafaker.Faker;
import java.util.Random;

public class MockDataService {
     Faker faker = new Faker();
     Random random = new Random();

    public  String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public  String generateRandomLastName() {
        return faker.name().lastName();
    }

    public String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String generateRandomNumber() {
        return "0" + (550 + random.nextInt(5)) + (100 + random.nextInt(800) +""+ (100+ random.nextInt(800)));
    }

    public String generateRandomAge() {
        return String.valueOf(faker.number().numberBetween(20, 50));
    }

    public String generateRandomDigits() {
        return String.valueOf(faker.number().numberBetween(3000, 10000));
    }

    public String generateRandomCompany() {
        return String.valueOf(faker.company());
    }

    public String generateRandomAddress() {
        return String.valueOf(faker.address());
    }

    public String generateRandomState() {
        return String.valueOf(faker.address().state());
    }

    public String generateRandomCity() {
        return String.valueOf(faker.address().city());
    }

    public String generateRandomZipcode() {
        return String.valueOf(faker.address().zipCode());
    }

    public String generateRandomPassword() {
        return String.valueOf(faker.internet().password());
    }

}
