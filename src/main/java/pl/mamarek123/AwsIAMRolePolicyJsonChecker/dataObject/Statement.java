package pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record Statement(
        String Sid, // Optional field; no validation needed

        @NotBlank(message = "Effect cannot be blank")
        String Effect,

        @NotNull(message = "Actions cannot be null")
        @Size(min = 1, message = "There must be at least one action")
        List<@NotBlank(message = "Action cannot be blank") String> Action,

        @NotBlank(message = "Resource cannot be blank")
        String Resource) {
}
