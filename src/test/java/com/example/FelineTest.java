package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void doesReturnCorrectListOfFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void doesReturnCorrectFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void doesReturnCorrectKittensCountWithoutArgument() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }


    @Test
    public void doesReturnCorrectKittensCountWithArgument() {
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(5);
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }

}