package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class ResponseBody {

    List<Student> students;
    List<Teacher> teachers;
    String message;
    int studentID;

/*
    public ResponseBody() {
    }

    public List<Student> getStudents() {

        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }*/
}
