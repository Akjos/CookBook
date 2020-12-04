package pl.akjos.CookBook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String prepareRegisterFrom(Model model) {
        log.debug("Go to registration page");
        model.addAttribute("user", new UserRegisterDTO());
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute("user") @Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        log.debug("User data: {}", userRegisterDTO);
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getRePassword())) {
            bindingResult.rejectValue("rePassword", "error.rePassword", "Password don't match");
        }
        if (bindingResult.hasErrors()) {
            log.debug("Binding result has error: {}", bindingResult.getAllErrors().toArray());
            return "/registration";
        }
        userService.saveUser(userRegisterDTO);
        return "redirect:/login";
    }

}
