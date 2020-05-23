package xeus.builder.abstractprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static xeus.builder.basic.PersonBuilder.newPerson;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import xeus.model.Person;

public class PersonBuilderTest {

    @Test
    void shouldCreatePerson() {
        // when
        Person person = newPerson()
                .withRequiredFirstName("John")
                .withRequiredLastName("Connor")
                .withRequiredDateOfBirth(new GregorianCalendar(1990, Calendar.JANUARY, 1))
                .withOptionalSecondName("Mike")
                .withOptionalAcademicTitle("professor")
                .withOptionalDateOfDeath(new GregorianCalendar(2010, Calendar.DECEMBER, 31))
                .build();

        // then
        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Connor", person.getLastName());
        assertEquals(
                new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime(),
                person.getDateOfBirth().getTime());
        assertEquals("Mike", person.getSecondName());
        assertEquals("professor", person.getAcademicTitle());
        assertEquals(
                new GregorianCalendar(2010, Calendar.DECEMBER, 31).getTime(),
                person.getDateOfDeath().getTime());
    }
}
