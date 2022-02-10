package com.qa.soft.drinks.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class SoftDrinksUnitTest {

	@Test
	public void testingConstructorWithoutId() {
		SoftDrinks drink = new SoftDrinks("coco cola", "The Coco Cola Company", 1.87, 330, 139);
		assertNotNull(drink.getName());
		assertNotNull(drink.getOwnedBy());
		assertNotNull(drink.getUkPrice());
		assertNotNull(drink.getMillilitresOfDrink());
		assertNotNull(drink.getCalories());

		assertEquals("coco cola", drink.getName());
		assertEquals("The Coco Cola Company", drink.getOwnedBy());
		assertEquals((Object) 1.87, drink.getUkPrice());
		assertEquals(330, drink.getMillilitresOfDrink());
		assertEquals(139, drink.getCalories());
	}

	@Test
	public void emptyConstructor() {
		SoftDrinks drink = new SoftDrinks();

	}

	@Test
	public void testingConstructorWithId() {
		SoftDrinks drink = new SoftDrinks(1L, "coco cola", "The Coco Cola Company", 1.87, 330, 139);
		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getOwnedBy());
		assertNotNull(drink.getUkPrice());
		assertNotNull(drink.getMillilitresOfDrink());
		assertNotNull(drink.getCalories());

		assertEquals("coco cola", drink.getName());
		assertEquals("The Coco Cola Company", drink.getOwnedBy());
		assertEquals((Object) 1.87, drink.getUkPrice());
		assertEquals(330, drink.getMillilitresOfDrink());
		assertEquals(139, drink.getCalories());
	}

	@Test
	public void testingGetters() {
		SoftDrinks drink = new SoftDrinks(1L, "coco cola", "The Coco Cola Company", 1.87, 330, 139);

	}

}
