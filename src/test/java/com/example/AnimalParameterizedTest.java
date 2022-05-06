package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class AnimalParameterizedTest {
    private final String kindAnimal;
    private final List<String> expectedFood;

    public AnimalParameterizedTest(String kindAnimal, List<String> expectedFood) {
        this.kindAnimal = kindAnimal;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void doesReturnCorrectFood() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(kindAnimal);
        Assert.assertEquals(expectedFood, actualFood);
    }

}