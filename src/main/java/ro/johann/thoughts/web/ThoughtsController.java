package ro.johann.thoughts.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.johann.thoughts.transfer.ThoughtCreateInput;
import ro.johann.thoughts.transfer.ThoughtOutput;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/thoughts-api/v1/thoughts")
public class ThoughtsController {

    @PostMapping
    @ResponseStatus(CREATED)
    public ThoughtOutput create(@RequestBody(required = false) ThoughtCreateInput request) {
        log.info("create >> request = {}", request);
        return getMockThought();
    }

    @GetMapping("/{thoughtId}")
    @ResponseStatus(OK)
    public ThoughtOutput get(@PathVariable("thoughtId") String id) {
        log.info("get >> id >> {}", id);
        return getMockThought();
    }

    private ThoughtOutput getMockThought() {
        return new ThoughtOutput("mock-id", "this is deep");
    }
}
