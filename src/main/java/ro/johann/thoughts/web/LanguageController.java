package ro.johann.thoughts.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.johann.thoughts.service.LanguageService;
import ro.johann.thoughts.transfer.LanguageCreateInput;
import ro.johann.thoughts.transfer.LanguageOutput;

@Slf4j
@RestController
@RequestMapping("/thoughts-api/v1/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LanguageOutput create(@RequestBody LanguageCreateInput input) {
        log.info("create >> input = {}", input);
        return languageService.create(input);
    }

    @GetMapping("/{languageId}")
    @ResponseStatus(HttpStatus.OK)
    public LanguageOutput get(@PathVariable("languageId") String id) {
        log.info("get >> id = {}", id);
        return languageService.get(id);
    }
}
