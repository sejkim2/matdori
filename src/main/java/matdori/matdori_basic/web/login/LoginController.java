package matdori.matdori_basic.web.login;

import matdori.matdori_basic.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginForm() {
        return "login/loginForm";
    }
}
