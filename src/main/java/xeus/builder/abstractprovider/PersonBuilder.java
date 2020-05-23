package xeus.builder.abstractprovider;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.Builder;

import xeus.model.Person;

/**
 * The builder for the {@link Person} class.
 *
 * In this approach an abstract class is used as a parent for each provider.
 * This way only the 'with...' method must be implemented in each provider and
 * the constructor and the private field for the master builder can be hidden.
 */
public class PersonBuilder implements Builder<Person> {

    private String firstName;
    private String secondName;
    private String lastName;
    private String academicTitle;
    private GregorianCalendar dateOfBirth;
    private GregorianCalendar dateOfDeath;

    public static class FirstNameProvider extends Provider<PersonBuilder> {

        public LastNameProvider withRequiredFirstName(String firstName) {
            this.builder.firstName = firstName;
            return Provider.getInstanceOf(LastNameProvider.class, this.builder);
        }
    }

    public static class LastNameProvider extends Provider<PersonBuilder> {

        public DateOfBirthProvider withRequiredLastName(String lastName) {
            this.builder.lastName = lastName;
            return Provider.getInstanceOf(DateOfBirthProvider.class, this.builder);
        }
    }

    public static class DateOfBirthProvider extends Provider<PersonBuilder> {

        public PersonBuilder withRequiredDateOfBirth(GregorianCalendar dateOfBirth) {
            this.builder.dateOfBirth = dateOfBirth;
            return this.builder;
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
        return Provider.getInstanceOf(FirstNameProvider.class, builder);
    }

    @Override
    public Person build() {
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setSecondName(this.secondName);
        person.setLastName(this.lastName);
        person.setAcademicTitle(this.academicTitle);
        person.setDateOfBirth(this.dateOfBirth);
        person.setDateOfDeath(this.dateOfDeath);
        return person;
    }
}