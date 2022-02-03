package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
    // in case you don't want to include some of the attributes in Object
@JsonIgnoreProperties(ignoreUnknown = true)
    // ignore unknown properties while parsing JSON format into Java Object
public class Teacher {

    String premanentAddress;
    String section;
    String subject;
    String phone;
    int batch;
    String birthDate;
    String department;
    String gender;
    String password;
    String firstName;
    String lastName;
    String emailAddress;
    String joinDate;
    int salary;

    int teacherId;
/*
    Subject subject;
    com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct
    instance of `apiModels.Subject` (although at least one Creator exists): no
    String-argument constructor/factory method to deserialize from String value ('Administration')
    at [Source: (StringReader); line: 1, column: 189] (through reference chain: apiModels.ResponseBody["teachers"]->
*/

}
