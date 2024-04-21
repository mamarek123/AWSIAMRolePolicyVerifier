package pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PolicyDocument(
        @NotBlank(message = "Version cannot be blank")
        String Version,

        @NotNull(message = "Statements cannot be null")
        @Size(min = 1, message = "There must be at least one statement")
        List<@Valid Statement> Statement) {
}
