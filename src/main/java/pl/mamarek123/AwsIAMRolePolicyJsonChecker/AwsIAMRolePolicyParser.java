package pl.mamarek123.AwsIAMRolePolicyJsonChecker;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject.AwsIAMRolePolicy;

import java.io.File;
import java.io.IOException;

class AwsIAMRolePolicyParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public AwsIAMRolePolicy parse(File file) throws IOException {
        AwsIAMRolePolicy awsIAMRolePolicy = objectMapper.readValue(file, AwsIAMRolePolicy.class);
        return awsIAMRolePolicy;
    }

}
