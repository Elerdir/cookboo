package ess.cz.server.core;

import ess.cz.server.core.exchange.VersionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core")
@RequiredArgsConstructor
public class CoreController {

    private final CoreService coreService;

    @GetMapping("/version")
    public VersionResponse getVersion() {
        return coreService.getVersion();
    }
}
