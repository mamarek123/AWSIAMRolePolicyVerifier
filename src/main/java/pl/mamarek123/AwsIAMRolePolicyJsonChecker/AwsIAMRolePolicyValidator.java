package pl.mamarek123.AwsIAMRolePolicyJsonChecker;

import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject.AwsIAMRolePolicy;

class AwsIAMRolePolicyValidator {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(AwsIAMRolePolicy awsIAMRolePolicy) {
        var violations = validator.validate(awsIAMRolePolicy);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (var violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new ValidationException("Validation error: " + sb);
        }
    }
}
