package pl.akjos.CookBook.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private User user;
    private Role userRole;
    private String userName = "UserName";
    private String roleName = "ROLE_USER";
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
    public void shouldGetUserByUserName() {
//        given
        when(userRepositoryMock.findUserByUsername(anyString())).thenReturn(Optional.of(user));

//        when
        User returnUser = testObject.getUserByName(userName);

//        then
        assertEquals(user, returnUser);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionWhenGetUserByUserName() {
//        given
        when(userRepositoryMock.findUserByUsername(anyString())).thenReturn(Optional.ofNullable(null));

//        when
        testObject.getUserByName(anyString());

//        then
    }

    @Test
    public void shouldEncodePasswordAddUserToDatabase() {
//        given
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        UserRegisterDTO userRegisterDTO = UserRegisterDTO.builder().password("password").build();

//        when
        testObject.saveUser(userRegisterDTO);

//        then
        verify(userRepositoryMock).save(argumentCaptor.capture());
        assertTrue(passwordEncoder.matches(userRegisterDTO.getPassword(), argumentCaptor.getValue().getPassword()));
    }

    @Test
    public void shouldSetUserRoleInAddUserToDatabase() {
//        given
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        UserRegisterDTO userRegisterDTO = UserRegisterDTO.builder().password("password").build();

//        when
        testObject.saveUser(userRegisterDTO);

//        then
        verify(roleRepositoryMock).getRoleByName(argumentCaptor.capture());
        assertTrue(roleName.equals(argumentCaptor.getValue()));
    }

}