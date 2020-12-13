package pl.akjos.CookBook.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public static RoleBuilder builder() {return new RoleBuilder();}

    public static class RoleBuilder {
        private Long id;
        private String name;

        public RoleBuilder() {}

        public RoleBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoleBuilder name(String name) {
            this.name = name;
            return this;
        }
        public Role build() {return new Role(id,name);}
    }
}