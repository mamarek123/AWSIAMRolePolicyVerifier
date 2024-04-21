
# AWS IAM Role Policy Verifier

This project contains a Java application that verifies JSON input data against specified conditions for AWS IAM Role Policies. It ensures that the `Resource` field in the input JSON does not contain a single asterisk (`"*"`), as this might represent overly broad permissions.

## Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher

## Setup

To set up the project on your local machine:

1. **Clone the repository**

   ```bash
   git clone https://github.com/mamarek123/AWSIamRolePolicyVerifier.git
   cd aws-iam-role-policy-verifier
   ```

2. **Build the project**

   This command compiles the project and runs all unit tests.

   ```bash
   mvn clean install
   ```

## Running the Application

To run the application, use the following command:

```bash
java -jar target/aws-iam-role-policy-verifier-1.0-SNAPSHOT.jar
```


## Running Tests

To execute all unit tests, use:

```bash
mvn test
```


## Usage

The `AwsIAMRolePolicyJsonChecker` package provides a `FileVerifier` class that is used to verify the validity of AWS IAM Role Policy JSON files against specific conditions. It parses the provided file, validates the policy data, and then verifies if the `Resource` field contains a single asterisk.

To use the `FileVerifier` class in your application, you need to:

1. Create an instance of `FileVerifier`.
2. Call the `verify` method with the file path as the argument.
## Functionality
Current version accepts a string containing filepath to the JSON file. The project is made with the thought in mind to be easily modifiable. If one wishes to extend the program to accept different input like a string containing the JSON, all he needs to do is write new short Verifier class and modify existing or add new Parser.