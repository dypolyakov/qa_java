package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;


    @Before
    public void setup() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        cat.getFood();
        List<String> food = List.of("Royal Canin", "Pro Plan", "Grandorf");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        List<String> actual = cat.getFood();
        Assert.assertEquals(food, actual);

    }
}