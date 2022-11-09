package space.terwer.openkm.core.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {
    @Getter
    public static boolean pluginSwitch;

    @Value("${openkm.plugin-switch}")
    public void setDatabase(boolean ps) {
        pluginSwitch = ps;
    }
}

