package com.company.service;

import com.company.repository.*;
import com.company.model.Coffee;
import com.company.model.Roaster;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    CoffeeRepository coffeeRepository;
    RoasterRepository roasterRepository;

    @Before
    public void setUp() throws Exception {
        setUpCoffeeRepositoryMock();
        setUpRoasterRepositoryMock();

        service = new ServiceLayer(coffeeRepository, roasterRepository);

    }

    // Helper methods
    private void setUpCoffeeRepositoryMock() {
        coffeeRepository = mock(CoffeeRepository.class);

        Coffee coffee = new Coffee();
        coffee.setId(1);
        coffee.setName("Folgers");
        coffee.setDescription("Folgers Brand Coffee");
        coffee.setCount(100);
        coffee.setUnitPrice(new BigDecimal("4.99"));
        coffee.setRoasterId(1);

        Coffee coffee2 = new Coffee();
        coffee2.setId(2);
        coffee2.setName("Dunkin");
        coffee2.setDescription("Dunkin Brand Coffee");
        coffee2.setCount(50);
        coffee2.setUnitPrice(new BigDecimal("3.99"));
        coffee2.setRoasterId(2);

        List<Coffee> aList = new ArrayList<>();
        aList.add(coffee);
        aList.add(coffee2);

        doReturn(coffee).when(coffeeRepository).save(coffee);
        doReturn(coffee2).when(coffeeRepository).save(coffee2);
        doReturn(Optional.of(coffee)).when(coffeeRepository).findById(1);
        doReturn(Optional.of(coffee2)).when(coffeeRepository).findById(2);
        doReturn(aList).when(coffeeRepository).findAll();
    }

    private void setUpRoasterRepositoryMock() {
        roasterRepository = mock(RoasterRepository.class);

        Roaster roaster = new Roaster();
        roaster.setId(1);
        roaster.setName("ABC Roaster");
        roaster.setCity("Augusta");
        roaster.setState("Maine");
        roaster.setEmail("abc@hotmail.com");
        roaster.setPhone("207-555-1212");
        roaster.setPostalCode("04330");
        roaster.setStreet("100 Main Street");
        roaster.setNote("Some Interesting Description");

        Roaster roaster2 = new Roaster();
        roaster2.setId(1);
        roaster2.setName("XYZ Roaster");
        roaster2.setCity("Old Orchard Beach");
        roaster2.setState("Maine");
        roaster2.setEmail("abc@hotmail.com");
        roaster2.setPhone("207-555-1212");
        roaster2.setPostalCode("04063");
        roaster2.setStreet("100 Broadway");
        roaster2.setNote("More Details");

        List<Roaster> aList = new ArrayList<>();
        aList.add(roaster);
        aList.add(roaster2);

        doReturn(roaster).when(roasterRepository).save(roaster);
        doReturn(roaster2).when(roasterRepository).save(roaster2);
        doReturn(Optional.of(roaster)).when(roasterRepository).findById(1);
        doReturn(Optional.of(roaster2)).when(roasterRepository).findById(2);
        doReturn(aList).when(roasterRepository).findAll();
    }

    @Test
    public void shouldSaveCoffee() {
        // Arrange
        Coffee coffee = new Coffee();
        coffee.setId(1);
        coffee.setName("Folgers");
        coffee.setDescription("Folgers Brand Coffee");
        coffee.setCount(100);
        coffee.setUnitPrice(new BigDecimal("4.99"));
        coffee.setRoasterId(1);

        Coffee expectedResult = new Coffee();
        expectedResult.setId(1);
        expectedResult.setName("Folgers");
        expectedResult.setDescription("Folgers Brand Coffee");
        expectedResult.setCount(100);
        expectedResult.setUnitPrice(new BigDecimal("4.99"));
        expectedResult.setRoasterId(1);

        // ACT
        Coffee createdCoffee = service.saveCoffee(coffee);
        assertEquals(expectedResult, createdCoffee);
    }

    @Test
    public void shouldSaveRoaster() {
        // Arrange
        Roaster roaster = new Roaster();
        roaster.setId(1);
        roaster.setName("ABC Roaster");
        roaster.setCity("Augusta");
        roaster.setState("Maine");
        roaster.setEmail("abc@hotmail.com");
        roaster.setPhone("207-555-1212");
        roaster.setPostalCode("04330");
        roaster.setStreet("100 Main Street");
        roaster.setNote("Some Interesting Description");

        Roaster expectedResult = new Roaster();
        expectedResult.setId(1);
        expectedResult.setName("ABC Roaster");
        expectedResult.setCity("Augusta");
        expectedResult.setState("Maine");
        expectedResult.setEmail("abc@hotmail.com");
        expectedResult.setPhone("207-555-1212");
        expectedResult.setPostalCode("04330");
        expectedResult.setStreet("100 Main Street");
        expectedResult.setNote("Some Interesting Description");

        // ACT
        Roaster createdRoaster = service.saveRoaster(roaster);
        assertEquals(expectedResult, createdRoaster);
    }

    @Test
    public void shouldFindCoffee() {
        Coffee coffee2 = new Coffee();
        coffee2.setId(2);
        coffee2.setName("Dunkin");
        coffee2.setDescription("Dunkin Brand Coffee");
        coffee2.setCount(50);
        coffee2.setUnitPrice(new BigDecimal("3.99"));
        coffee2.setRoasterId(2);

        Coffee coffeeToFind = service.findCoffee(2);
        assertEquals(coffee2, coffeeToFind);
    }
}
