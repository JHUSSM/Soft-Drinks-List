package com.qa.soft.drinks.service;

import java.util.List;

public interface CRUDSoftDrinksInterface<S> {

	// CRUD METHODS

	// CREATE

	S create(S s);

	// READ

	List<S> readAll();

	// READ BY ID
	S readById(int id);

	// UPDATE - There's an id to update and then a replacement drink(in this case)
	// object to replace the last one

	S update(int id, S s);

	// Delete //simply put if the boolean is true it means that the (id) or
	// variable still exists so therefore it hasn't been deleted. The opposite is
	// that if it's false it means the variable has been deleted
	boolean delete(int id);

}
