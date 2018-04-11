package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReservationTest {

	@Test
	public void create() throws Exception {

		Reservation reservation = new Reservation(1L, "Josh");
		//Assert.assertEquals("aJosh", reservation.getName());
//		Assert.assertThat(reservation.getId(), Matchers.allOf(
//				Matchers.notNullValue(),
//				Matchers.is(2L)
//		));
		Assertions.assertThat(reservation)
				.as("Reservation was created/constructed")
				.isNotNull();

		Assertions.assertThat(reservation.getReservationName())
				.as("Reservation should have  a name of Josh")
				.isNotNull()
				.isEqualTo("Josh");

	}
}
