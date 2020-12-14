package pl.akjos.CookBook.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserRegisterDTO {

    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 7, max = 25)
    private String password;

    @NotEmpty
    @Size(min = 7, max = 25)
    private String rePassword;

    public UserRegisterDTO(String username, String email, String password, String rePassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public static UserDTOBuilder builder() {return new UserDTOBuilder();}

    public static class UserDTOBuilder {
        private String username;
        private String email;
        private String password;
        private String rePassword;

        UserDTOBuilder() {
        }

        public UserDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDTOBuilder rePassword(String rePassword) {
            this.rePassword = rePassword;
            return this;
        }

        public UserRegisterDTO build() {
            return new UserRegisterDTO(username, email, password, rePassword);
        }
    }
}
