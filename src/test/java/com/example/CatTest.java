package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Spy
    private Feline feline;

    @Spy
    private Predator predator;

    @Test
    public void doesMakeCorrectSound() {
        Cat cat = new Cat (feline);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        Assert.assertEquals(expectedSound, actualSound);
    }

    @Test
    public void doesReturnCorrectFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.lenient().when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = cat.getFood();

        Assert.assertEquals(expectedFood, actualFood);
    }
}