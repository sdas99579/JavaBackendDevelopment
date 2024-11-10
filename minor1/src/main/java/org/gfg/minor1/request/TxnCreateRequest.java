package org.gfg.minor1.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TxnCreateRequest {

    @NotBlank(message = "Student contact should not be blank")
    private String studentContact;

    @NotBlank(message = "Book No should not be blank")
    private String bookNo;

    @Positive(message = "Amount should be positive")
    private Integer amount;

}
