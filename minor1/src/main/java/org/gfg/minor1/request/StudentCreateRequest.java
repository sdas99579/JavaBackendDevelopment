package org.gfg.minor1.request;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.gfg.minor1.model.Student;
import org.gfg.minor1.model.StudentType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {


    @NotBlank(message = "Name should not be blank")
    private String name;


    private String email;

    private String phoneNo;

    private String address;

    public Student toStudent() {
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .phoneNo(this.phoneNo)
                .address(this.address)
                .status(StudentType.ACTIVE)
                .build();
    }
}
