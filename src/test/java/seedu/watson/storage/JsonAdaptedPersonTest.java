package seedu.watson.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.watson.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.watson.testutil.Assert.assertThrows;
import static seedu.watson.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.watson.commons.exceptions.IllegalValueException;
import seedu.watson.model.person.Address;
import seedu.watson.model.person.Email;
import seedu.watson.model.person.Name;
import seedu.watson.model.person.Phone;
import seedu.watson.model.person.StudentClass;

public class JsonAdaptedPersonTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_INDEX_NUMBER = BENSON.getIndexNumber().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final String VALID_STUDENTCLASS = BENSON.getStudentClass().toString();
    private static final String VALID_ATTENDANCE = BENSON.getAttendance().toString();
    private static final String VALID_SUBJECTHANDLER = BENSON.getSubjectHandler().dataString();
    private static final List<JsonAdaptedRemark> VALID_REMARKS = BENSON.getRemarks().stream()
                                                                       .map(JsonAdaptedRemark::new)
                                                                       .collect(Collectors.toList());
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
                                                                 .map(JsonAdaptedTag::new)
                                                                 .collect(Collectors.toList());
    private static final List<JsonAdaptedSubject> VALID_SUBJECTS = BENSON.getSubjectsTaken().stream()
        .map(JsonAdaptedSubject::new)
        .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(INVALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                                  VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                  VALID_REMARKS, VALID_TAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(null, VALID_INDEX_NUMBER, VALID_PHONE,
                                                         VALID_EMAIL, VALID_ADDRESS,
                                                         VALID_STUDENTCLASS, VALID_ATTENDANCE,
                                                         VALID_SUBJECTHANDLER,
                                                         VALID_REMARKS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                                  VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                  VALID_REMARKS, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, null,
                                                         VALID_EMAIL, VALID_ADDRESS, VALID_STUDENTCLASS,
                                                         VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                                         VALID_REMARKS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                                  VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                  VALID_REMARKS, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE,
                                                         null, VALID_ADDRESS, VALID_STUDENTCLASS,
                                                         VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                                         VALID_REMARKS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                                  VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                  VALID_REMARKS, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE, VALID_EMAIL, null,
                                                         VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                                         VALID_REMARKS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullStudentClass_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE,
                                                         VALID_EMAIL, VALID_ADDRESS, null,
                                                         VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                                         VALID_REMARKS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, StudentClass.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidSubject_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                                  VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                  VALID_REMARKS, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, VALID_INDEX_NUMBER, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                                  VALID_STUDENTCLASS, VALID_ATTENDANCE, VALID_SUBJECTHANDLER,
                                  VALID_REMARKS, invalidTags);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

}