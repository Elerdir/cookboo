package ess.cz.server.common.exchange;

import ess.cz.server.common.util.StatusCode;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class GeneralResponse {

    private int statusCode;

    private String message;

    private Object object;
}
