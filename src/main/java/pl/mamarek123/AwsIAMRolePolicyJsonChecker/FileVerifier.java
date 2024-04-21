package pl.mamarek123.AwsIAMRolePolicyJsonChecker;

import pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject.AwsIAMRolePolicy;


import java.io.File;
import java.io.IOException;

public class FileVerifier {

    AwsIAMRolePolicyParser awsIAMRolePolicyParser = new AwsIAMRolePolicyParser();
    AwsIAMRolePolicyValidator awsIAMRolePolicyValidator = new AwsIAMRolePolicyValidator();

    AwsIAMRolePolicyVerifier awsIAMRolePolicyVerifier = new AwsIAMRolePolicyVerifier();

    public boolean verify(String filePath) throws IOException {
        AwsIAMRolePolicy awsIAMRolePolicy = awsIAMRolePolicyParser.parse(new File(filePath));
        awsIAMRolePolicyValidator.validate(awsIAMRolePolicy);
        return awsIAMRolePolicyVerifier.verify(awsIAMRolePolicy);
    }



}
