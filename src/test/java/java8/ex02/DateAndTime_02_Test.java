package java8.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.IllegalFormatCodePointException;

import javax.management.MalformedObjectNameException;

import org.junit.Test;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

	@Test
	public void test_localDate_of() {

		// TODO créer un objet LocalDate à la date 24/12/2050
		LocalDate result = null;
		result = LocalDate.of(2050,12,24);
		
		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
		int year = 0;
		Month month = null;
		int dayOfMonth = 0;
		DayOfWeek dayOfWeek = null;
		int dayOfYear = 0;
		year = result.getYear();
		month = result.getMonth();
		dayOfMonth = result.getDayOfMonth(); 		
		assertThat(year, is(2050));
		assertThat(month, is(Month.DECEMBER));
		assertThat(dayOfMonth, is(24));
		assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
		assertThat(dayOfYear, is(358));
	}

	@Test
	public void test_localDate_parse() {

		// TODO créer un objet LocalDate à la date 10/01/1990
		// TODO utiliser la méthode parse
		LocalDate result = null;
		result = LocalDate.parse("1990-01-10");
		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
		int year = 0;
		Month month = null;
		int dayOfMonth = 0;
		year = result.getYear();
		month = result.getMonth();
		dayOfMonth = result.getDayOfMonth();
		assertThat(year, is(1990));
		assertThat(month, is(Month.JANUARY));
		assertThat(dayOfMonth, is(10));
	}

	@Test
	public void test_localDate_format() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// en utilisant la méthode of
		LocalDate localDate = null;
		localDate = LocalDate.of(2015, 3, 11);
		// TODO Formatter la date pour que le test soit passant
		String result = null;
		result = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy"));
		assertThat(result, is("11 - 03 - 2015"));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void test_localDate_format_with_hour() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// TODO utiliser la méthode of
		LocalDate localDate = null;
		localDate = LocalDate.of(2015, 03, 11);
		//LocalTime localTime = LocalTime.of(0,0,0);
		//LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

		// TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
		localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 00:00:00") );
	}

	@Test
	public void test_with() {

		// TODO créer un objet LocalDate à la date 10/01/2000
		// TODO utiliser la méthode of
		LocalDate localDate = null;
		localDate = LocalDate.of(2000, 01, 10);
		// TODO transformer la date précédente en 05/02/2015
		LocalDate result = null;
		result = localDate.withYear(2015).withMonth(2).withDayOfMonth(5);
//		for (int i = 0; i < 15; i++) {
//			result = localDate.with(TemporalAdjusters.firstDayOfNextYear());
//		}
//		result = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
//		result = localDate.with(TemporalAdjusters.firstDayOfMonth());
//		switch (localDate.getDayOfWeek()) {
//		case MONDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
//			break;
//		case TUESDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
//			break;
//		case WEDNESDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
//			break;
//		case THURSDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//			break;
//		case FRIDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
//			break;
//		case SATURDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
//			break;
//		case SUNDAY:
//			result = localDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
//			break;
//		}
			


		assertThat(result.getYear(), is(2015));
		assertThat(result.getMonth(), is(Month.FEBRUARY));
		assertThat(result.getDayOfMonth(), is(5));
	}

}
