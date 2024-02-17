package matdori.matdori_basic.web.login;

import lombok.extern.slf4j.Slf4j;
import matdori.matdori_basic.domain.login.LoginService;
import matdori.matdori_basic.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String loginForm() {
        return "login/loginForm";
    }

    @PostMapping
    public String login(@ModelAttribute("member") Member member) {
        if (loginService.login(member.getLoginId(), member.getPassword()) == null) {
            return "login/loginform";
        }
        return "redirect:/";
    }
}
