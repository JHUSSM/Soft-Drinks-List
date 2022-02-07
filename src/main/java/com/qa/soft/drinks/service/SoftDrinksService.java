package com.qa.soft.drinks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.soft.drinks.domain.SoftDrinks;
import com.qa.soft.drinks.repository.SoftDrinksRepo;

@Service
public class SoftDrinksService implements CRUDSoftDrinksInterface<SoftDrinks> {

	private SoftDrinksRepo repo;

	public SoftDrinksService(SoftDrinksRepo repo) {
		this.repo = repo;
	}

	@Override
	public SoftDrinks create(SoftDrinks drink) {
		return this.repo.save(drink);
	}

	@Override
	public List<SoftDrinks> readAll() {
		return this.repo.findAll();
	}

	@Override
	public SoftDrinks readById(int id) {
		return this.repo.getById(id);
	}

	@Override
	public SoftDrinks update(int id, SoftDrinks s) {
		Optional<SoftDrinks> existingDrink = this.repo.findById(id);
		SoftDrinks existing = existingDrink.get();
		existing.setName(s.getName());
		existing.setOwnedBy(s.getOwnedBy());
		existing.setUkPrice(s.getUkPrice());
		existing.setMillilitresOfDrink(s.getMillilitresOfDrink());
		existing.setCalories(s.getCalories());
		return existing;
	}

	@Override
	public boolean delete(int id) {
		if (!this.repo.existsById(id)) {
			System.out.println("id not found in database");
		} else {
			this.repo.deleteById(id);
		}
		return !this.repo.existsById(id);
	}

}
