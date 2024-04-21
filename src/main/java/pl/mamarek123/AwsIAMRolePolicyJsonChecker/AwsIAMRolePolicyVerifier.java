package pl.mamarek123.AwsIAMRolePolicyJsonChecker;

import pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject.AwsIAMRolePolicy;
import pl.mamarek123.AwsIAMRolePolicyJsonChecker.dataObject.Statement;

class AwsIAMRolePolicyVerifier {
    public boolean verify(AwsIAMRolePolicy awsIAMRolePolicy) {
        for (Statement statement: awsIAMRolePolicy.PolicyDocument().Statement()){
            if (statement.Resource().equals("*")) return false;
        }
        return true;
    }
}
