package com.qa.soft.drinks.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.soft.drinks.domain.SoftDrinks;
import com.qa.soft.drinks.repository.SoftDrinksRepo;

@SpringBootTest
@ActiveProfiles("test")
public class SoftDrinksServiceUnitTest {

	private SoftDrinks newDrink;
	private SoftDrinks savedDrink;

	@Autowired
	private SoftDrinksService service;

	@MockBean
	private SoftDrinksRepo repo;

	@BeforeEach
	void setUp() {
		newDrink = new SoftDrinks("coco cola", "The Coco Cola Company", 1.87, 330, 139);
		savedDrink = new SoftDrinks(1L, "coco cola", "The Coco Cola Company", 1.87, 330, 139);
	}

	@Test
	void testCreate() {

		Mockito.when(this.repo.save(newDrink)).thenReturn(savedDrink);

		assertThat(this.service.create(newDrink)).isEqualTo(savedDrink);

		Mockito.verify(this.repo, Mockito.times(1)).save(newDrink);
	}

	@Test
	void testUpdate() {

		Long id = 1L;

		SoftDrinks toUpdate = new SoftDrinks("cherry coco cola", "The Coco Cola Company", 1.87, 330, 139);

		Optional<SoftDrinks> optionalDrink = Optional.of(new SoftDrinks(id, null, null, 0, 0, 0));

		SoftDrinks updated = new SoftDrinks(id, toUpdate.getName(), toUpdate.getOwnedBy(), toUpdate.getUkPrice(),
				toUpdate.getMillilitresOfDrink(), toUpdate.getCalories());

		Mockito.when(this.repo.findById(id)).thenReturn(optionalDrink);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertThat(this.service.update(id, toUpdate)).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	void testDeleting() {

		Long id = 12L;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		assertThat(this.service.delete(id)).isFalse();

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}

}
