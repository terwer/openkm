package space.terwer.openkm.core.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 公共控制器
 *
 * @name: CommonController
 * @author: terwer
 * @date: 2022-11-10 15:28
 **/
@Controller
@RequestMapping("/")
public class CommonController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        logger.info("访问容器首页");
        return "forward:/index.html";
    }
}
