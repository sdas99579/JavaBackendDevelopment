package org.gfg.minor1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String bookNo;

    private int cost;

    @Enumerated(value = EnumType.STRING)
    private BookType type;

    @ManyToOne
    @JoinColumn
//    @JsonIgnoreProperties({"bookList","txnList"})
    private Student student;

    @ManyToOne
    @JoinColumn
//    @JsonIgnore
    @JsonIgnoreProperties({"bookList","txnList"})
    private Author author;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<Txn> txnList;
}
