package pl.akjos.CookBook.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.akjos.CookBook.domain.model.Role;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RoleRepository;
import pl.akjos.CookBook.domain.repositories.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private User user;
    private Role userRole;
    private String userName = "UserName";
    private String roleName = "ROLE_NAME";
    private Long userId = 4L;

    @Spy
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Mock
    private RoleRepository roleRepositoryMock;

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService testObject;

    @Before
    public void setUser() {
        user = User.builder()
                .id(userId)
                .username(userName)
                .role(null)
                .build();

        userRole = Role.builder()
                .id(1L)
                .name(roleName)
                .build();
    }

    @Test
    public void shouldGetUserById() {
//        given
        when(userRepositoryMock.getUserByUsername(anyString())).thenReturn(user);

//        when
        User returnUser = testObject.getUserByName(userName);

//        then
        assertEquals(user, returnUser);
    }

}