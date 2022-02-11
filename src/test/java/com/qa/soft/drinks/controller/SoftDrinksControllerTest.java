package com.qa.soft.drinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.soft.drinks.domain.SoftDrinks;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:SoftDrinks-schema.sql",
		"classpath:Softdrinks-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SoftDrinksControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map; // ObjectMapper converts our java code to fit the JSON style/ format of writing
								// this would usually be done for us but since we're testing we have to
								// do it ourselves (converts to a json string)

	@Test
	void testCreateController() throws Exception {
		SoftDrinks newSD = new SoftDrinks("coca cola", "The Coca Cola Company", 1.87, 330, 139); // here we are just
																									// making the mock
																									// request

		String newSDJSON = this.map.writeValueAsString(newSD);

		RequestBuilder mockRequest = post("/softdrink/create").contentType(MediaType.APPLICATION_JSON)
				.content(newSDJSON);
		// in the same way we go to postman for example and select post, raw, json etc
		// we must declare all those here too

		SoftDrinks savedSD = new SoftDrinks(2L, "coca cola", "The Coca Cola Company", 1.87, 330, 139); // *our return*
		// previously manually inserted a record so we must auto increment the id's
		// ourselves (next one being 2L)

		String savedSDJSON = this.map.writeValueAsString(savedSD);

		ResultMatcher matchStatus = status().isCreated(); // here we are just specifying the status code for when the
															// record is created

		ResultMatcher matchBody = content().json(savedSDJSON);

		// here is where the test takes place we are calling the mockmvc and we're
		// expecting the status code mentioned above and the body created
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testingreadall() throws JsonProcessingException, Exception {
		SoftDrinks savedSD = new SoftDrinks(1L, "coca cola", "The Coca Cola Company", 1.87, 330, 139);
		this.mock.perform(get("/softdrink/readAll")).andExpect(status().isOk())
				.andExpect(content().json(this.map.writeValueAsString(List.of(savedSD))));

	}

	@Test
	void testinggetbyid() throws Exception {
		SoftDrinks savedSD = new SoftDrinks(1L, "coca cola", "The Coca Cola Company", 1.87, 330, 139);
		this.mock.perform(get("/softdrink/getById/1")).andExpect(status().isFound())
				.andExpect(content().json(this.map.writeValueAsString(savedSD)));

	}

	@Test
	void testingupdate() throws Exception {
		SoftDrinks savedSD = new SoftDrinks("coca cola cherry", "The Coca Cola Company", 1.87, 330, 139);
		SoftDrinks updatedSD = new SoftDrinks(1L, "coca cola cherry", "The Coca Cola Company", 1.87, 330, 139);
		this.mock
				.perform(put("/softdrink/update/1").contentType(MediaType.APPLICATION_JSON)
						.content(this.map.writeValueAsString(savedSD)))
				.andExpect(status().isAccepted()).andExpect(content().json(this.map.writeValueAsString(updatedSD)));
	}

	@Test
	void testingdelete() throws Exception {
		SoftDrinks deletedSD = new SoftDrinks(1L, "coca cola", "The Coca Cola Company", 1.87, 330, 139);
		String deletedSDJSON = this.map.writeValueAsString(deletedSD);

		Long delId = 1L;
		RequestBuilder deleteRequest = delete("/softdrink/delete/" + delId);
		ResultMatcher Status = status().isGone();
		ResultMatcher Body = content().string("true");
		this.mock.perform(deleteRequest).andExpect(Status).andExpect(Body);
	}

}
