package pl.akjos.CookBook.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
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

}
