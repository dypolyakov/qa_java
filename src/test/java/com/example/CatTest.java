package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.Assert.*;

public class CatTest {

    @Spy
    Cat cat = new Cat(new Feline());

    @Test
    public void getSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }
}