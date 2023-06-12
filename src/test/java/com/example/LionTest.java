package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    Lion lion;


    public LionTest() throws Exception {
    }

    @Test
    public void getKittens() throws Exception {
        lion = new Lion(feline, "Самец");
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void doesHaveManeMaleReturnsTrue() throws Exception {
        lion = new Lion(feline, "Самец");
        boolean expected = true;
        boolean actual = lion.hasMane;
        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeFemaleReturnsFalse() throws Exception {
        lion = new Lion(feline, "Самка");
        boolean expected = false;
        boolean actual = lion.hasMane;
        assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}