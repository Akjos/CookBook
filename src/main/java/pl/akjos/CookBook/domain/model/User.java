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

    @Column(nullable = false)
    private String email;

    @Column
    private Boolean enable;

    @ManyToOne
    private Role role;

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @PrePersist
    private void onCreate() {
        this.enable = true;
    }

    public static class UserBuilder {
        private Long id;
        private String username;
        private String password;
        private String email;
        private Boolean enable;
        private Role role;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder enable(Boolean enable) {
            this.enable = enable;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(id, username, password, email, enable, role);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", email=" + this.email + ", enable=" + this.enable + ", role=" + this.role + ")";
        }
    }
}
