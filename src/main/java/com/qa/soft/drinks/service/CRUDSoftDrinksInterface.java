package com.qa.soft.drinks.service;

import java.util.List;

public interface CRUDSoftDrinksInterface<S> {

	// CRUD METHODS

	// CREATE

	S create(S s);

	// READ

	List<S> readAll();

	// READ BY ID
	S readById(int Id);

	// UPDATE - There's an id to update and then a replacement drink(in this case)
	// object to replace the last one

	S update(int Id, S s);

	// Delete
	boolean delete(int Id);

}
