package matdori.matdori_basic.web.player;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import matdori.matdori_basic.domain.player.Player;
import matdori.matdori_basic.domain.player.playerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/players")
@Slf4j
public class playerController {

    private final playerRepository store;

    @Autowired
    public playerController(playerRepository store) {
        this.store = store;
    }

    @GetMapping
    public String players(Model model) {
        List<Player> list = store.findAll();
        model.addAttribute("list", list);
        return "players/list";
    }

    @GetMapping("/{playerId}")
    public String player(@PathVariable("playerId") Long playerId, Model model) {
        Player player = store.findById(playerId);
        model.addAttribute("player", player);
        return "player/player";
    }

    @GetMapping("/add")
    public String add() {
        return "player/add";
    }

    @PostMapping("/add")
    public String addPlayer(@ModelAttribute("player") Player player,
                            RedirectAttributes redirectAttributes) {

        Player savedPlayer = store.save(player);
        redirectAttributes.addAttribute("playerId", savedPlayer.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/players/{playerId}";
    }

    @GetMapping("{playerId}/edit")
    public String edit(@PathVariable("playerId") Long playerId, Model model) {
        Player player = store.findById(playerId);
        model.addAttribute(player);
        return "player/edit";
    }

    @PostMapping("{playerId}/edit")
    public String edit(@PathVariable("playerId") Long playerId, @ModelAttribute Player player) {
        store.updatePlayer(playerId, player);
        return "redirect:/players/{playerId}";
    }

    //해당 빈의 의존관계 주입이 완료되면 초기화 용도로 사용
    @PostConstruct
    public void init() {
        //default data(tester)
        store.save(new Player(10, 10000, "lee", "RM"));
        store.save(new Player(11, 15000, "son", "LW"));
        store.save(new Player(13, 8000, "park", "CM"));
        store.save(new Player(9, 12000, "jo", "CF"));
    }
}
