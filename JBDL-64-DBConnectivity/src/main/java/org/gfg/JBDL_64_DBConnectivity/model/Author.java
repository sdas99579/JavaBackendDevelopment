package org.gfg.JBDL_64_DBConnectivity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
//    @GenericGenerator(
//            name = "sequence-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @Parameter(name = "sequence_name",value = "user_sequence"),
//                    @Parameter(name = "initial_value", value = "1"),
//                    @Parameter(name = "increment_size",value = "1")
//            }
//    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
    @TableGenerator(
            name = "table-generator",
            initialValue=1,
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "aName",length = 30)
    private String authorName;
}
