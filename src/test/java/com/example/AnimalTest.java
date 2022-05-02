package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void doesGetFoodReturnCorrectException() {
        Animal animal = new Animal();
        String message = "В методе getFood() некорректно отрабатывает исключение";
        String actualException = "";
        String expectedException = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            animal.getFood("Земноводные");
        } catch (Exception exception) {
            actualException = exception.getMessage();
        }
        assertEquals(message, expectedException, actualException);
    }

    @Test
    public void doesReturnCorrectFamily() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actualFamily = animal.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }
}