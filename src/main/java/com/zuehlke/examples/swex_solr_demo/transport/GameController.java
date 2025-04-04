package com.zuehlke.examples.swex_solr_demo.transport;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;
import com.zuehlke.examples.swex_solr_demo.model.Game;
import com.zuehlke.examples.swex_solr_demo.model.GameRepository;
import com.zuehlke.examples.swex_solr_demo.solr.SearchService;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GameController {
    private final GameRepository gameRepository;
    private final SearchService searchService;

    @GetMapping("/games/{id}")
    public String showGame(@PathVariable("id") int id, Model model) {
        log.info("Get game " + id);
        final var game = gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("game", game);
        return "game";
    }

    @GetMapping("/")
    public RedirectView redirectRoot() {
        return new RedirectView("/games");
    }

    @GetMapping("/games/")
    public RedirectView redirectSlash() {
        return new RedirectView("/games");
    }

    @GetMapping("/games")
    public String showGames(@Param("search") String search, Model model) {
        final var games = getGames(search);
        model.addAttribute("search", search);
        model.addAttribute("games", games);
        return "games";
    }

    private Collection<Game> getGames(String search) {
        if (search == null) {
            log.info("Get all games");
            return gameRepository.findAll();
        } else {
            log.info("Search games by " + search);
            final var gameIds = searchService.search(search);
            return gameRepository.findAllById(gameIds);
        }
    }
}
