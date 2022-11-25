package space.terwer.openkm.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.nio.file.Path;

/**
 * 插件测试
 *
 * @name: OpenkmPluginTests
 * @author: terwer
 * @date: 2022-11-11 12:37
 **/
@SpringBootTest
public class OpenkmPluginTests implements ApplicationContextAware {
    private GenericWebApplicationContext context;
//    private OpenkmPluginManager pluginManager;

    @TempDir
    Path pluginsPath;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = (GenericWebApplicationContext) applicationContext;
    }

    @BeforeEach
    public void setUp() {
//        String pluginsDir = GlobalValue.pluginDir;
//        // 创建插件管理器
//        Path pluginsRoot = Paths.get(pluginsDir);
//
//        pluginManager = new OpenkmPluginManager(pluginsRoot);
//        context.registerBean(PluginConfig.class);
    }

    @AfterEach
    public void tearDown() {
//        pluginManager = null;
    }

    @Test
    public void contextLoads() {
        System.out.println("context=>" + context);
    }

    @Test
    public void validateOK() {
//        RuntimeMode runtimeMode = pluginManager.getRuntimeMode();
//        System.out.println(runtimeMode);
    }
}
