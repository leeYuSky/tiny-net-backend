package edu.tju.scs.tinynetbackend.model.po;


import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Getter @Setter private String username;

    @Getter @Setter private String password;

    @Getter @Setter private Integer type;

}