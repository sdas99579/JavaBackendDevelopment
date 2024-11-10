package org.gfg.JBDL_64_DBConnectivity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyPerson {

    public MyPerson(String fName) {
        this.fName = fName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
    @TableGenerator(
            name = "table-generator",
            initialValue=1,
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "fName",length = 30)
    private String fName;

}

//create table my_person (id integer not null, f_name varchar(30), primary key (id)) engine=InnoDB
//create table my_person (id integer not null auto_increment, f_name varchar(30), primary key (id)) engine=InnoDB
//create table my_person (id integer not null, f_name varchar(30), primary key (id)) engine=InnoDB


//change the value in table generation type
//allocationsize 50 to 1

