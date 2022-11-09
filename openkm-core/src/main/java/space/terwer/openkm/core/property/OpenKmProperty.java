package space.terwer.openkm.core.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Global config
 */
@Data
@ConfigurationProperties(prefix = "openkm")
public class OpenKmProperty {
    private boolean pluginSwitch;
}
