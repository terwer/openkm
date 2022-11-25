package space.terwer.openkm.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SpringBeanUtils工具类
 *
 * @name: SpringBeanUtil
 * @author: terwer
 * @date: 2022-03-07 14:26
 **/
public final class SpringBeanUtil implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(SpringBeanUtil.class);

    private static ApplicationContext coreApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.coreApplicationContext = applicationContext;
        logger.info("设置容器的Spring上下文");
    }

    /**
     * 获取容器的Spring上下文
     *
     * @return
     */
    public static ApplicationContext getCoreApplicationContext() {
        if (null == SpringBeanUtil.coreApplicationContext) {
            throw new RuntimeException("应用未初始化完成，上下文获取失败，请调整获取上下文的时机");
        }
        return SpringBeanUtil.coreApplicationContext;
    }

    /**
     * 根据名称获取bean
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return SpringBeanUtil.coreApplicationContext.getBean(beanName);
    }

    /**
     * 根据类型获取bean
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> t) {
        return SpringBeanUtil.coreApplicationContext.getBean(t);
    }
}
