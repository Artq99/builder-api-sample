package xeus.builder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import xeus.model.Person;

import static xeus.builder.PersonBuilder.newPerson;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonBuilderTest {

    @Test
    void shouldCreatePerson() {
        // when
        Person person = newPerson() //
                .withFirstName("John") //
                .withLastName("Connor") //
                .withDateOfBirth(new GregorianCalendar(1990, Calendar.JANUARY, 1)) //
                .withSecondName("Mike") //
                .withAcademicTitle("professor") //
                .withDateOfDeath(new GregorianCalendar(2010, Calendar.DECEMBER, 31)) //
                .build();

        // then
        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Connor", person.getLastName());
        assertEquals(
                new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime(),
                person.getDateOfBirth().getTime()
        );
        assertEquals("Mike", person.getSecondName());
        assertEquals("professor", person.getAcademicTitle());
        assertEquals(
                new GregorianCalendar(2010, Calendar.DECEMBER, 31).getTime(),
                person.getDateOfDeath().getTime()
        );
    }
}