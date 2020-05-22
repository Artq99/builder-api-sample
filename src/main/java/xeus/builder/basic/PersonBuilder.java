package xeus.builder.basic;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.Builder;

import xeus.model.Person;

/**
 * The builder for the {@link Person} class.
 * 
 * In this approach only the inner classes are used to provide the foolproof mechanism.
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

        public LastNameProvider withRequiredFirstName(String firstName) {
            builder.firstName = firstName;
            return new LastNameProvider(builder);
        }
    }

    public static class LastNameProvider {

        private PersonBuilder builder;

        private LastNameProvider(PersonBuilder builder) {
            this.builder = builder;
        }

        public DateOfBirthProvider withRequiredLastName(String lastName) {
            builder.lastName = lastName;
            return new DateOfBirthProvider(builder);
        }
    }

    public static class DateOfBirthProvider {
        
        private PersonBuilder builder;

        private DateOfBirthProvider(PersonBuilder builder) {
            this.builder = builder;
        }

        public PersonBuilder withRequiredDateOfBirth(GregorianCalendar dateOfBirth) {
            builder.dateOfBirth = dateOfBirth;
            return builder;
        }
    }

    public PersonBuilder withOptionalSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public PersonBuilder withOptionalAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
        return this;
    }

    public PersonBuilder withOptionalDateOfDeath(GregorianCalendar dateOfDeath) {
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