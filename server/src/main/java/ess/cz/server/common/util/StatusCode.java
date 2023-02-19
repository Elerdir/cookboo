package ess.cz.server.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    OK(200), NO_FOUND_TAG(501), FAIL(500);

    private Integer code;
}
