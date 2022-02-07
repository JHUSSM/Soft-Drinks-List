package com.qa.soft.drinks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.soft.drinks.domain.SoftDrinks;
import com.qa.soft.drinks.service.CRUDSoftDrinksInterface;

@RestController
public class SoftDrinksController {

	private CRUDSoftDrinksInterface<SoftDrinks> service;

	public SoftDrinksController(CRUDSoftDrinksInterface<SoftDrinks> service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<SoftDrinks> createSoftDrinks(@RequestBody SoftDrinks drink) {
		return new ResponseEntity<SoftDrinks>(this.service.create(drink), HttpStatus.CREATED);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<SoftDrinks>> readAllSoftDrinks() {
		return new ResponseEntity<List<SoftDrinks>>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/readById/{id}")
	public ResponseEntity<SoftDrinks> readSoftDrinksById(@PathVariable int id) {
		return new ResponseEntity<SoftDrinks>(this.service.readById(id), HttpStatus.FOUND);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<SoftDrinks> updateSoftDrinksById(@PathVariable int id, @RequestBody SoftDrinks drink) {
		return new ResponseEntity<SoftDrinks>(this.service.update(id, drink), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteSoftDrinksById(@PathVariable int id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.GONE);
	}

}
