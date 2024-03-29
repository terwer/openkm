package space.terwer.openkm.plugins.appstore.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import space.terwer.openkm.common.plugin.api.PluginLogger;
import space.terwer.openkm.common.plugin.api.PluginLoggerFactory;
import space.terwer.openkm.plugins.appstore.service.IAppStoreService;
import space.terwer.openkm.plugins.appstore.AppStorePlugin;

/**
 * 控制器
 *
 * @author Terwer
 * @version 1.0
 * 2018/11/29 1:23
 **/
@Controller
@RequestMapping("appstore")
public class AppStoreController {
    private final PluginLogger logger = PluginLoggerFactory.getLogger(AppStorePlugin.class, this.getClass());

    private IAppStoreService appStoreService;

    @Autowired
    public void setAppStoreService(IAppStoreService appStoreService) {
        this.appStoreService = appStoreService;
    }

    @RequestMapping
    public String index() {
        String info = appStoreService.getAppStoreInfo();
        logger.info("从AppStoreController返回的信息：" + info);
        return "forward:/appstore/index.html";
    }
//    @RequestMapping
//    public String appStore(Model model) {
//        SiteConfig siteConfig = commonService.getSiteConfig();
//        model.addAttribute("siteConfig", siteConfig);
//        return "appstore/index";
//    }
//
//    @RequestMapping("/upload")
//    public String upload(Model model) {
//        SiteConfig siteConfig = commonService.getSiteConfig();
//        model.addAttribute("siteConfig", siteConfig);
//        return "appstore/upload";
//    }
//
//    @RequestMapping("/copyright")
//    public String copyright() {
//        return "appstore/copyright";
//    }
}
