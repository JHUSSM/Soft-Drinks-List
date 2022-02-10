package com.qa.soft.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.soft.drinks.domain.SoftDrinks;

@Repository
public interface SoftDrinksRepo extends JpaRepository<SoftDrinks, Long> { // the id type for my soft drinks is a long

	// we're taking all these fields from SoftDrinks
	public SoftDrinks findSoftDrinksByName(String name);

	public SoftDrinks findSoftDrinksByOwnedBy(String ownedBy);

	public SoftDrinks findSoftDrinksByUkPrice(double ukPrice);

	public SoftDrinks findSoftDrinksByMillilitresOfDrink(int millilitresOfDrink);

	public SoftDrinks findSoftDrinksByCalories(int calories);

	public SoftDrinks findSoftDrinksById(Long id);

	@Override
	public Optional<SoftDrinks> findById(Long id);

	@Override
	public boolean existsById(Long id);

	@Override
	public void deleteById(Long id);

}
