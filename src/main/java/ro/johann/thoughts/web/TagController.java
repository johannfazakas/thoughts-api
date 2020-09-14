package ro.johann.thoughts.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.johann.thoughts.service.TagService;
import ro.johann.thoughts.transfer.TagCreateInput;
import ro.johann.thoughts.transfer.TagOutput;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequestMapping("/thoughts-api/v1/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public TagOutput create(@RequestBody TagCreateInput input) {
        log.info("create >> input = {}", input);
        return new TagOutput(tagService.create(input));
    }

    @GetMapping("/{tagId}")
    @ResponseStatus(OK)
    public TagOutput get(@PathVariable("tagId") String id) {
        log.info("get >> id = {}", id);
        return new TagOutput(tagService.get(id));
    }
}

