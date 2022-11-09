package space.terwer.openkm.core.container;

import org.pf4j.spring.SpringPluginManager;

import java.nio.file.Path;

/**
 * 核心插件管理器
 */
public class OpenkmPluginManager extends SpringPluginManager {
    public OpenkmPluginManager(Path pluginsRoot) {
        super(pluginsRoot);
    }

    public OpenkmPluginManager() {
        super();
    }
}
