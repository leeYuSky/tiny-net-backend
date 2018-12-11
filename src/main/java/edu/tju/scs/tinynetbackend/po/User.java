package edu.tju.scs.tinynetbackend.po;


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