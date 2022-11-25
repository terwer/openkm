package space.terwer.openkm.common.plugin.api;

import org.pf4j.PluginRuntimeException;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import space.terwer.openkm.common.util.ClazzUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 插件基类，建议所有的插件都继承此类
 */
public abstract class BasePlugin extends SpringPlugin {
    private final PluginLogger logger = PluginLoggerFactory.getLogger(BasePlugin.class, this.getClass());

    /**
     * 需要加上 super.autoRegisterBeans(xxx.class) 来自动注册bean，目前支撑 @Component，@Controller，@Service，@Configuration注解自动注册
     *
     * @param wrapper
     */
    public BasePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    /**
     * 注册插件的bean，建议所有的插件实现此方法，请在插件实现此方法，用于注册插件依赖
     */
    public void autoRegisterBeans(Class clazz) {
        List<String> classNames = ClazzUtil.getClassNames(clazz);

        int beanCount = 0;
        for (String className : classNames) {
            GenericApplicationContext applicationContext = (GenericApplicationContext) this.getApplicationContext();
            try {
                Class aClass = this.wrapper.getPluginClassLoader().loadClass(className);

                // 只注册有特定注解的bean
                List<Class> annotationClazz = new ArrayList<>();
                annotationClazz.add(Component.class);
                annotationClazz.add(Controller.class);
                annotationClazz.add(Service.class);
                annotationClazz.add(Configuration.class);
                if (ClazzUtil.isInAnnotationList(aClass, annotationClazz)) {
                    applicationContext.registerBean(aClass);
                    beanCount++;
                    logger.info("Pugin registerBean " + aClass);
                }
            } catch (ClassNotFoundException e) {
                logger.error("插件类加载失败");
                throw new RuntimeException(e);
            }

        }
        logger.info("自动注册bean结束，共注册 " + beanCount + " 个bean");
    }

    /**
     * 创建上下文，这里把插件与容器的上文保持一致，便于交互
     *
     * @return
     */
    @Override
    protected ApplicationContext createApplicationContext() {
        logger.info("Creating BasePlugin applicationContext");
        SpringPluginManager springPluginManager = (SpringPluginManager) (this.getWrapper().getPluginManager());
        ApplicationContext applicationContext = springPluginManager.getApplicationContext();
        logger.info("BasePlugin applicationContext is:" + applicationContext);
        return applicationContext;
    }

    /**
     * 通用的插件启动方法
     */
    @Override
    public void start() {
        try {
            logger.debug("插件启动中...");
            super.start();
            logger.debug("插件已启动");
        } catch (Exception e) {
            throw new PluginRuntimeException("插件启动失败，请排查", e);
        }
    }

    /**
     * 通用的插件停止方法
     */
    @Override
    public void stop() {
        try {
            super.stop();
        } catch (Exception e) {
            logger.error("插件停止发生异常", e);
        }
        logger.debug("插件已停止");
    }
}
