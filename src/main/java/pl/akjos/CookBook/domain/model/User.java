package pl.akjos.CookBook.domain.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private Boolean admin;

    @Column
    private Boolean enable;

    @ManyToOne
    private Role role;

}
