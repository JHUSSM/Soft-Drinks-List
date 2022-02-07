package com.qa.soft.drinks.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Soft Drinks")
public class SoftDrinks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@NotNull(message = "All drinks require a Name.") // message is prompting the user to fill in the empty space as it
	@Column // empty space as it should not be left empty
	private String name;

	@Column
	private String ownedBy; // company

	@Min(0)
	@NotNull(message = "Price of drink is required.")
	@Column
	private double ukPrice;

	@NotNull(message = "Size of beverage is a requirement.")
	@Min(30)
	@Max(2000)
	@Column
	private int millilitresOfDrink;

	@NotNull(message = "Must include calories.")
	@Min(10)
	@Max(1000)
	@Column
	private int calories;

	public SoftDrinks(int id, String name, String ownedBy, double ukPrice, int millilitresOfDrink, int calories) {
		this.id = id;
		this.name = name;
		this.ownedBy = ownedBy;
		this.ukPrice = ukPrice;
		this.millilitresOfDrink = millilitresOfDrink;
		this.calories = calories;
	}

	public SoftDrinks(String name, String ownedBy, double ukPrice, int millilitresOfDrink, int calories) {
		this.name = name;
		this.ownedBy = ownedBy;
		this.ukPrice = ukPrice;
		this.millilitresOfDrink = millilitresOfDrink;
		this.calories = calories;
	}

	public SoftDrinks() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

	public double getUkPrice() {
		return ukPrice;
	}

	public void setUkPrice(double ukPrice) {
		this.ukPrice = ukPrice;
	}

	public int getMillilitresOfDrink() {
		return millilitresOfDrink;
	}

	public void setMillilitresOfDrink(int millilitresOfDrink) {
		this.millilitresOfDrink = millilitresOfDrink;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calories, id, millilitresOfDrink, name, ownedBy, ukPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftDrinks other = (SoftDrinks) obj;
		return calories == other.calories && id == other.id && millilitresOfDrink == other.millilitresOfDrink
				&& Objects.equals(name, other.name) && Objects.equals(ownedBy, other.ownedBy)
				&& Double.doubleToLongBits(ukPrice) == Double.doubleToLongBits(other.ukPrice);
	}

}
