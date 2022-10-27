package seedu.watson.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.watson.model.Database;
import seedu.watson.model.ReadOnlyDatabase;
import seedu.watson.model.person.Address;
import seedu.watson.model.person.Attendance;
import seedu.watson.model.person.Email;
import seedu.watson.model.person.IndexNumber;
import seedu.watson.model.person.Name;
import seedu.watson.model.person.Person;
import seedu.watson.model.person.Phone;
import seedu.watson.model.person.Remark;
import seedu.watson.model.person.StudentClass;
import seedu.watson.model.person.subject.Subject;
import seedu.watson.model.person.subject.SubjectHandler;
import seedu.watson.model.tag.Tag;

/**
 * Contains utility methods for populating {@code Database} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(new Name("Alex Yeoh"), new IndexNumber("1"), new Phone("87438807"),
                       new Email("alexyeoh@example.com"),
                       new Address("Blk 30 Geylang Street 29, #06-40"), new StudentClass("1.2"),
                       new Attendance(), getRemarkSet("family"),
                       new SubjectHandler("english: CA1:[80.0, 100.0, 0.2, 1.0], CA2:[30.0, "
                               + "56.0, 0.4, 2.0] %%math: CA1:[80.0, 100.0, 0.2, 1.0],"
                                          + "CA2:[30.0, 56.0, 0.4, 2.0]"),
                       getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new IndexNumber("2"), new Phone("99272758"),
                       new Email("berniceyu@example.com"),
                       new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new StudentClass("2.1"),
                       new Attendance(), getRemarkSet("family"),
                       new SubjectHandler("english: CA1:[80.0, 100.0, 0.2, 1.0], CA2:[30.0, "
                               + "56.0, 0.4, 2.0] %%math: CA1:[80.0, 100.0, 0.2, 1.0],"
                                          + "CA2:[30.0, 56.0, 0.4, 2.0]"),
                       getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new IndexNumber("3"), new Phone("93210283"),
                       new Email("charlotte@example.com"),
                       new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new StudentClass("3.6"),
                       new Attendance(), getRemarkSet("family"),
                       new SubjectHandler("english: CA1:[80.0, 100.0, 0.2, 1.0], CA2:[30.0, "
                               + "56.0, 0.4, 2.0] %%math: CA1:[80.0, 100.0, 0.2, 1.0],"
                                          + "CA2:[30.0, 56.0, 0.4, 2.0]"),
                       getTagSet("neighbours")),
            new Person(new Name("David Li"), new IndexNumber("4"), new Phone("91031282"),
                       new Email("lidavid@example.com"),
                       new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new StudentClass("4.2"),
                       new Attendance(), getRemarkSet("family"),
                       new SubjectHandler("english: CA1:[80.0, 100.0, 0.2, 1.0], CA2:[30.0, "
                               + "56.0, 0.4, 2.0] %%math: CA1:[80.0, 100.0, 0.2, 1.0],"
                                          + "CA2:[30.0, 56.0, 0.4, 2.0]"),
                       getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new IndexNumber("5"), new Phone("92492021"),
                       new Email("irfan@example.com"),
                       new Address("Blk 47 Tampines Street 20, #17-35"), new StudentClass("2.6"),
                       new Attendance(), getRemarkSet("family"),
                       new SubjectHandler("english: CA1:[80.0, 100.0, 0.2, 1.0], CA2:[30.0, "
                               + "56.0, 0.4, 2.0] %%math: CA1:[80.0, 100.0, 0.2, 1.0],"
                                          + "CA2:[30.0, 56.0, 0.4, 2.0]"),
                       getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new IndexNumber("10"), new Phone("92624417"),
                       new Email("royb@example.com"),
                       new Address("Blk 45 Aljunied Street 85, #11-31"), new StudentClass("3.10"),
                       new Attendance(), getRemarkSet("family"),
                       new SubjectHandler("english: CA1:[80.0, 100.0, 0.2, 1.0], CA2:[30.0, "
                               + "56.0, 0.4, 2.0] %%math: CA1:[80.0, 100.0, 0.2, 1.0],"
                                          + "CA2:[30.0, 56.0, 0.4, 2.0]"),
                       getTagSet("colleagues"))
        };
    }

    public static ReadOnlyDatabase getSampleAddressBook() {
        Database sampleAb = new Database();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                     .map(Tag::new)
                     .collect(Collectors.toSet());
    }

    /**
     * Returns a remark set containing the list of strings given.
     */
    public static Set<Remark> getRemarkSet(String... strings) {
        return Arrays.stream(strings)
                     .map(Remark::new)
                     .collect(Collectors.toSet());
    }

    /**
     * Returns a remark set containing the list of strings given.
     */
    public static Set<Subject> getSubjectSet(String... strings) {
        return Arrays.stream(strings)
                     .map(Subject::new)
                     .collect(Collectors.toSet());
    }
}