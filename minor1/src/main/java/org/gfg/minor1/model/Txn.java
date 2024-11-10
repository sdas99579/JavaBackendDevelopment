package org.gfg.minor1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Txn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String txnId;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("txnList")
    private Student student;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("bookList")
    private Book book;


    private int paidAmount;

    @CreationTimestamp
    private Date createdOn;


    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private TxnStatus txnStatus;

}
