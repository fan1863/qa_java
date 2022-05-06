package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Spy
    private Feline feline;

    @Test
    public void doesReturnCorrectKittensCount() {
        Lion lion = new Lion(feline);
        int expectedKittensCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);

        int actualKittensCount = lion.getKittens();

        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }


    @Test
    public void doesReturnCorrectFood() throws Exception {
        Lion lion = new Lion(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void lionReturnsCorrectTextException() {
        String message = "В конструкторе Lion(String sex) некорректно отрабатывает исключение";
        String actualException = "";
        String expectedException = "Используйте допустимые значения пола животного - самей или самка";
        try {
            new Lion("Мужчина");
        } catch (Exception exception) {
           actualException = exception.getMessage();
        }
        assertEquals(message, expectedException, actualException);
    }
}