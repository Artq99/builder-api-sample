package xeus.builder;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.Builder;

import xeus.model.Person;

/**
 * The builder for the {@link Person} class.
 */
public class PersonBuilder implements Builder<Person> {

    private String firstName;
    private String secondName;
    private String lastName;
    private String academicTitle;
    private GregorianCalendar dateOfBirth;
    private GregorianCalendar dateOfDeath;

    public static class FirstNameProvider {

        private PersonBuilder builder;

        private FirstNameProvider(PersonBuilder builder) {
            this.builder = builder;
        }

        public LastNameProvider withFirstName(String firstName) {
            builder.firstName = firstName;
            return new LastNameProvider(builder);
        }
    }

    public static class LastNameProvider {

        private PersonBuilder builder;

        private LastNameProvider(PersonBuilder builder) {
            this.builder = builder;
        }

        public DateOfBirthProvider withLastName(String lastName) {
            builder.lastName = lastName;
            return new DateOfBirthProvider(builder);
        }
    }

    public static class DateOfBirthProvider {
        
        private PersonBuilder builder;

        private DateOfBirthProvider(PersonBuilder builder) {
            this.builder = builder;
        }

        public PersonBuilder withDateOfBirth(GregorianCalendar dateOfBirth) {
            builder.dateOfBirth = dateOfBirth;
            return builder;
        }
    }

    public PersonBuilder withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public PersonBuilder withAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
        return this;
    }

    public PersonBuilder withDateOfDeath(GregorianCalendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
        return this;
    }

    private PersonBuilder() {

    }

    public static FirstNameProvider newPerson() {
        PersonBuilder builder = new PersonBuilder();
        return new FirstNameProvider(builder);
    }

    @Override
    public Person build() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setSecondName(secondName);
        person.setLastName(lastName);
        person.setAcademicTitle(academicTitle);
        person.setDateOfBirth(dateOfBirth);
        person.setDateOfDeath(dateOfDeath);
        return person;
    }
}