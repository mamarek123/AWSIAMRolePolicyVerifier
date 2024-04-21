package pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AwsIAMRolePolicy(
        @NotBlank(message = "PolicyName cannot be blank")
        @Pattern(regexp = "[\\w+=,.@-]+", message = "PolicyName contains invalid characters")
        @Size(min = 1, max = 128, message = "PolicyName must be between 1 and 128 characters long")
        String PolicyName,

        @NotNull(message = "PolicyDocument cannot be null")
        @Valid
        PolicyDocument PolicyDocument) {
}