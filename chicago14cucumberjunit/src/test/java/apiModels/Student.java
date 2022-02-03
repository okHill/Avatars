package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.junit.Ignore;
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

//    Create Model Classes for the following student API
    /**
     * {
     *   "students": [
     *     {
     *       "admissionNo": "string",
     *       "batch": 0,
     *       "birthDate": "2020-05-20T16:14:45.882Z",
     *       "company": {
     *         "address": {
     *           "addressId": 0,
     *           "city": "string",
     *           "state": "string",
     *           "street": "string",
     *           "zipCode": 0
     *              },
     *         "companyId": 0,
     *         "companyName": "string",
     *         "startDate": "string",
     *         "title": "string"
     *          },
     *       "contact": {
     *         "contactId": 0,
     *         "emailAddress": "string",
     *         "phone": "string",
     *         "premanentAddress": "string"
     *          },
     *       "firstName": "string",
     *       "gender": "string",
     *       "joinDate": "2020-05-20T16:14:45.882Z",
     *       "lastName": "string",
     *       "major": "string",
     *       "password": "string",
     *       "section": "string",
     *       "studentId": 0,
     *       "subject": "string"
     *     }
     *   ]
     * }
     */


        private int studentId;
        private String firstName;
        private String lastName;
        private String section;
        private int batch;
        String subject;
        String joinDate;

        Contact contact;
        Company company;

//      Lombok Library will take care of the Getters and Setters
}
