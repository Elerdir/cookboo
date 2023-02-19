package ess.cz.server.core;

import ess.cz.server.common.util.VirtualCookBookProperties;
import ess.cz.server.core.exchange.VersionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoreService {

    private final VirtualCookBookProperties virtualCookBookProperties;

    public VersionResponse getVersion() {
        return VersionResponse.of(
                virtualCookBookProperties.getVersion(),
                virtualCookBookProperties.getBuildTimestampLabel()
        );
    }
}
