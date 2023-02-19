package ess.cz.server.core.exchange;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class VersionResponse {

    private String version;

    private String buildTimestamp;
}
