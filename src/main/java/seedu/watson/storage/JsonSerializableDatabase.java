package seedu.watson.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.watson.commons.exceptions.IllegalValueException;
import seedu.watson.model.Database;
import seedu.watson.model.ReadOnlyDatabase;
import seedu.watson.model.person.Person;

/**
 * An Immutable Database that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableDatabase {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableDatabase} with the given persons.
     */
    @JsonCreator
    public JsonSerializableDatabase(@JsonProperty("persons") List<JsonAdaptedPerson> persons) {
        this.persons.addAll(persons);
    }

    /**
     * Converts a given {@code ReadOnlyDatabase} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableDatabase}.
     */
    public JsonSerializableDatabase(ReadOnlyDatabase source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
    }

    /**
     * Converts this watson book into the model's {@code Database} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Database toModelType() throws IllegalValueException {
        Database database = new Database();
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Person person = jsonAdaptedPerson.toModelType();
            if (database.hasPerson(person)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            database.addPerson(person);
        }
        return database;
    }

}