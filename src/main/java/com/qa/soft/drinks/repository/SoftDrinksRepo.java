package com.qa.soft.drinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.soft.drinks.domain.SoftDrinks;

@Repository
public interface SoftDrinksRepo extends JpaRepository<SoftDrinks, Integer> { // the id type for my soft drinks is an int
																				// but int's are not accepted here so we
																				// must wrap it as an integer

	// we're taking all these fields from SoftDrinks
	public SoftDrinks findSoftDrinksByName(String name);

	public SoftDrinks findSoftDrinksByOwnedBy(String ownedBy);

	public SoftDrinks findSoftDrinksByUkPrice(double ukPrice);

	public SoftDrinks findSoftDrinksByMillilitresOfDrink(int millilitresOfDrink);

	public SoftDrinks findSoftDrinksByCalories(int calories);

}
