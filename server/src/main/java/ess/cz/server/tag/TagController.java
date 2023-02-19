package ess.cz.server.tag;

import ess.cz.server.common.exchange.GeneralResponse;
import ess.cz.server.tag.dto.Tag;
import ess.cz.server.tag.exchange.TagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/list")
    public GeneralResponse getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping
    public GeneralResponse saveTag(@RequestBody TagRequest tag) {
        return tagService.saveTag(Tag.fromRequest(tag));
    }
}
