package pl.akjos.CookBook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String goToHome() {
        log.debug("Go to home page");
        return "/index";
    }

    @RequestMapping("/about")
    public String goToAbout() {
        log.debug("Go to about page");
        return "/about";
    }

    @RequestMapping("/contact")
    public String goToContact() {
        log.debug("Go to about page");
        return "/contact";
    }

    @GetMapping("/app/dashboard")
    public String prepareDashboardForLoggedUser() {
        log.debug("Go to main page loged user");
        return "app/dashboard";
    }
}
