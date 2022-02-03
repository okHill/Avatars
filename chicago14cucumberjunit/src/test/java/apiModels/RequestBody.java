package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
// in case you don't want to include some of the attributes in Object
@JsonIgnoreProperties(ignoreUnknown = true)

public class RequestBody {

    // We can add here all the information, like teacher, student etc.
    // When we pass the instance variables of Teacher class , requestBody will work like teacher;
    // These variables can be used for any other object, like Student, Dog etc.

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

    String major;
    String admissionNo;
    Contact contact;
    Company company;

}
