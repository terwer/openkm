package space.terwer.openkm.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {
    @Getter
    public static String env;
    @Getter
    public static boolean pluginSwitch;
    @Getter
    public static String pluginDir;

    @Value("${spring.profiles.active}")
    public void setEnv(String e) {
        env = e;
    }

    @Value("${openkm.plugin-switch}")
    public void setPluginSwitch(boolean ps) {
        pluginSwitch = ps;
    }

    @Value("${openkm.plugins-dir}")
    public void setPluginDir(String dir) {
        pluginDir = dir;
    }
}

