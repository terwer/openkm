package space.terwer.openkm.core.config;

import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import space.terwer.openkm.core.container.OpenkmPluginManager;

import java.util.List;

/**
 * Web资源解析处理器
 *
 * @name: WebConfig
 * @author: terwer
 * @date: 2022-11-10 14:31
 **/
@ConditionalOnProperty(name = "openkm.plugin-switch", havingValue = "true")
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ApplicationContext context;
    private OpenkmPluginManager openkmPluginManager;

    @Autowired
    public WebConfig(ApplicationContext context) {
        super();
        this.context = context;
    }

    public OpenkmPluginManager getOpenkmPluginManager() {
        if (null == openkmPluginManager) {
            openkmPluginManager = this.context.getBean(OpenkmPluginManager.class);
        }
        return openkmPluginManager;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        return new InternalResourceViewResolver();// 用于解析重定向 redirect:
    }

    /**
     * 添加静态文件路径
     *
     * @param registry 资源注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("添加容器静态资源映射");

        // Core静态资源映射
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/dist/");
        logger.info("添加Core容器Webapp资源映射，from /** to classpath:/META-INF/resources/dist/");
        // 统一使用webapp这个前端项目提供静态页面，不再自定义映射，否则容易产生目录冲突
        // registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // logger.info("添加Core容器静态资源映射，from /static/** to classpath:/static");

        // 插件静态资源映射
        List<PluginWrapper> plugins = getOpenkmPluginManager().getStartedPlugins();
        for (PluginWrapper pluginWrapper : plugins) {
            // 插件静态资源映射
            registerPluginMetaInfDistResource(registry, pluginWrapper, "dist/");
            // registerPluginStaticResource(registry, pluginWrapper, "static/");
        }
    }

    private void registerPluginMetaInfDistResource(ResourceHandlerRegistry registry, PluginWrapper pluginWrapper, String pluginResourcePath) {
        // 虚拟路径
        String prefix = pluginWrapper.getPluginId().replace("-plugin", "");
        String virtualPath = "/" + prefix + "/**";
        // 实际路径
        String absPath = pluginWrapper.getPluginClassLoader().getResource(".").getPath();
        String pluginResourceLocation = "file://" + absPath + "META-INF/resources/" + pluginResourcePath;
        // 注册路径到Web上下文
        registry.addResourceHandler(virtualPath).addResourceLocations(pluginResourceLocation);
        logger.info("添加插件Webapp资源映射，from " + virtualPath + " to " + pluginResourceLocation);
    }

    /**
     * 注册静态资源映射
     *
     * @param registry
     * @param pluginWrapper
     * @param pluginResourcePath
     */
    private void registerPluginStaticResource(ResourceHandlerRegistry registry, PluginWrapper pluginWrapper, String pluginResourcePath) {
        // 虚拟路径
        String prefix = pluginWrapper.getPluginId().replace("-plugin", "");
        String virtualPath = "/" + prefix + "/" + pluginResourcePath + "**";
        // 实际路径
        String absPath = pluginWrapper.getPluginClassLoader().getResource(".").getPath();
        String pluginResourceLocation = "file://" + absPath + pluginResourcePath;
        // 注册路径到Web上下文
        registry.addResourceHandler(virtualPath).addResourceLocations(pluginResourceLocation);
        logger.info("添加插件静态资源映射，from " + virtualPath + " to " + pluginResourceLocation);
    }
}
