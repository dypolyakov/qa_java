package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemaleReturnsFalse() throws Exception {
        lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeUnknownSexThrowsException() throws Exception {
        try {
            lion = new Lion(feline, "sex");
            fail("Ожидается Exception");
        } catch (Exception exception) {
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            String actual = exception.getMessage();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}