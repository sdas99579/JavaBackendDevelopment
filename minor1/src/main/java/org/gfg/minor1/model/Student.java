package org.gfg.minor1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 15, unique = true, nullable = false)
    private String phoneNo;

    private String address;


    @CreationTimestamp
    private Date createdOn;


    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private StudentType status;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Book> bookList;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Txn> txnList;



}
