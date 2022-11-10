package space.terwer.openkm.core.common;

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
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:/index.html";
    }
}