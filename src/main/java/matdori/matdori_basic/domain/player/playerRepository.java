package matdori.matdori_basic.domain.player;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class playerRepository {

    private static final Map<Long, Player> store = new HashMap<>();
    private static Long sequence = 0L;

    public Player save(Player player) {
        player.setId(++sequence);
        store.put(sequence, player);
        return player;
    }

    public ArrayList<Player> findAll() {
        return new ArrayList<>(store.values());
    }

    public Player findById(Long id) {
        Player player = store.get(id);
        return player;
    }

    public void updatePlayer(Long id, Player player) {
        Player findPlayer = store.get(id);
        findPlayer.setBackNumber(player.getBackNumber());
        findPlayer.setName(player.getName());
        findPlayer.setPosition(player.getPosition());
        findPlayer.setSalary(player.getSalary());
    }

}
