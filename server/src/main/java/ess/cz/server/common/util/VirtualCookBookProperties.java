package ess.cz.server.common.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Data
@Component
@SuppressWarnings("SpringPropertySource")
@PropertySource("classpath:application.properties")
public class VirtualCookBookProperties {

    public static final Charset LSM_CONFIG_CHARSET = Charset.forName("windows-1250");

    @Value("${app.version:unknown}")
    private String version;

    @Value("${app.buildTimestampLabel:unknown}")
    private String buildTimestampLabel;
}
