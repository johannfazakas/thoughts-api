package ro.johann.thoughts.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.johann.thoughts.model.Thought;
import ro.johann.thoughts.persistence.ThoughtJDBCRepository;
import ro.johann.thoughts.persistence.ThoughtRepository;
import ro.johann.thoughts.transfer.ThoughtCreateInput;
import ro.johann.thoughts.transfer.ThoughtOutput;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/thoughts-api/v1/thoughts")
public class ThoughtController {

    private final ThoughtRepository thoughtRepo;

    public ThoughtController(ThoughtRepository thoughtJDBCRepository) {
        this.thoughtRepo = thoughtJDBCRepository;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ThoughtOutput create(@RequestBody ThoughtCreateInput request) {
        log.info("create >> request = {}", request);
        Thought thought = request.toModel();
        return new ThoughtOutput(thoughtRepo.create(thought));
    }

    @GetMapping("/{thoughtId}")
    @ResponseStatus(OK)
    public ThoughtOutput get(@PathVariable("thoughtId") Integer id) {
        log.info("get >> id >> {}", id);
        return thoughtRepo.get(id)
                .map(ThoughtOutput::new)
                .orElseThrow(() -> new RuntimeException("Thought not found"));
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ThoughtOutput> list() {
        log.info("list >>");
        return thoughtRepo.list().stream()
                .map(ThoughtOutput::new)
                .collect(toList());
    }
}
