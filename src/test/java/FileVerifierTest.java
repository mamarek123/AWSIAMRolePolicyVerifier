import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;
import pl.mamarek123.AwsIAMRolePolicyJsonChecker.FileVerifier;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileVerifierTest {

    @Test
    public void shouldReturnFalseIfAnyStatementHasSingleAsterisk() throws IOException {
        //given
        String filePathWithSingleAsterisk = "src/test/java/ExampleRolePolicyWithSingleAsterisk.json";
        FileVerifier fileVerifier = new FileVerifier();

        //when
        boolean result = fileVerifier.verify(filePathWithSingleAsterisk);

        //then
        assertFalse(result, "Should return false for policy with '*' in Resource field");
    }

    @Test
    public void shouldReturnTrueIfNoStatementIsSingleAsterisk() throws IOException {
        //given
        String filePathWithoutSingleAsterisk = "src/test/java/ExampleRolePolicyWithoutSingleAsterisk.json";
        FileVerifier fileVerifier = new FileVerifier();

        //when
        boolean result = fileVerifier.verify(filePathWithoutSingleAsterisk);

        //then
        assertTrue(result, "Should return true when no statement has '*' as Resource");
    }

    @Test
    public void shouldThrowFileNotFoundExceptionIfFileNotExisting() {
        //given
        String notExistingFilePath = "foo";
        FileVerifier fileVerifier = new FileVerifier();

        //when&&then
        assertThrows(FileNotFoundException.class, () -> fileVerifier.verify(notExistingFilePath));
    }

    @Test
    public void shouldWorkWithOptionalSidFieldMissing() throws IOException {
        //given
        String filePathToFileWithSidFieldMissing = "src/test/java/ExampleRolePolicyWithWithSidFieldMissing.json";
        FileVerifier fileVerifier = new FileVerifier();

        //when&&then
        assertFalse(fileVerifier.verify(filePathToFileWithSidFieldMissing));
    }

    @Test
    public void shouldThrowValidationExceptionWhenResourceFieldIsMissing() {
        //given
        String filePathToFileWithMissingResourceField = "src/test/java/ExampleRolePolicyWithMissingResourceField.json";
        FileVerifier fileVerifier = new FileVerifier();

        //when&&then
        assertThrows(ValidationException.class,() -> fileVerifier.verify(filePathToFileWithMissingResourceField));
    }

    @Test
    public void shouldThrowValidationExceptionWhenOtherRequiredFieldsMissing() {
        //given
        String filePathToMissingRequiredFields = "src/test/java/ExampleRolePolicyMissingOtherRequiredFields.json";
        FileVerifier fileVerifier = new FileVerifier();

        //when&&then
        assertThrows(ValidationException.class, () -> fileVerifier.verify(filePathToMissingRequiredFields));
    }

    @Test
    public void shouldThrowValidationExceptionWhenPolicyNameInvalid() {
        //given
        String filePathWithTooLongPolicyName = "src/test/java/ExampleRolePolicyWithTooLongPolicyName.json";
        String filePathWithPolicyNameNotMatchingRegex = "src/test/java/ExampleRolePolicyWithPolicyNameNotMatchingRegex.json";
        FileVerifier fileVerifier = new FileVerifier();

        //when&&then
        assertThrows(ValidationException.class, () -> fileVerifier.verify(filePathWithTooLongPolicyName));
        assertThrows(ValidationException.class, () -> fileVerifier.verify(filePathWithPolicyNameNotMatchingRegex));
    }

}
