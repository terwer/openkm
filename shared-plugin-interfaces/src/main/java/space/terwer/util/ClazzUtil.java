package space.terwer.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 字节码工具类
 *
 * @name: ClazzUtil
 * @author: terwer
 * @date: 2022-11-10 21:42
 **/
public class ClazzUtil {
    /**
     * 递归获取class文件，返回Clazz
     *
     * @param clazz
     * @return
     */
    public static List<String> getClassNames(Class clazz) {
        List<String> classNames = new ArrayList<>();
        doScan(classNames, null, clazz, null);
        return classNames;
    }

    /**
     * 递归获取class文件，返回Class
     *
     * @param clazz
     * @return
     */
    public static List<Class> getClasszzes(Class clazz) {
        List<Class> clazzes = new ArrayList<>();
        doScan(null, clazzes, clazz, null);
        return clazzes;
    }

    /**
     * 扫描类
     *
     * @param classNames  结果集名称
     * @param clazzes     结果集Class
     * @param clazz       扫描package所在的类
     * @param scanPackage 包，第一次传null即可
     */
    private static void doScan(List<String> classNames, List<Class> clazzes, Class clazz, String scanPackage) {
        if (StringUtils.isEmpty(scanPackage)) {
            scanPackage = clazz.getPackage().getName();
            System.out.println("scanPackage=>" + scanPackage);
        }

        String scanPackagePath = clazz.getClassLoader().getResource(".").getPath() + scanPackage.replaceAll("\\.", "/");
        File pack = new File(scanPackagePath);

        File[] files = pack.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                doScan(classNames, clazzes, clazz, scanPackage + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = scanPackage + "." + file.getName().replaceAll(".class", "");

                if (null != classNames) {
                    classNames.add(className);
                }

                if (null != clazzes) {
                    try {
                        Class resultClazz = Class.forName(className);

                        clazzes.add(resultClazz);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    /**
     * 检测是否包含某个注解集合
     *
     * @param currentClazz
     * @param annotationClazz
     * @return
     */
    public static boolean isInAnnotationList(Class currentClazz, List<Class> annotationClazz) {
        boolean flag = false;

        for (Class clazz : annotationClazz) {
            if (currentClazz.isAnnotationPresent(clazz)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
