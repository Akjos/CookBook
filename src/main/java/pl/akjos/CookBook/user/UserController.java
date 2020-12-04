package pl.akjos.CookBook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String prepareRegisterFrom(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute("user") UserRegisterDTO userRegisterDTO) {
        log.debug("User data: {}", userRegisterDTO);
        userService.saveUser(userRegisterDTO);
        return "redirect:/login";
    }

}
