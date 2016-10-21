package hu.wup.wuppadavans.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @RequestMapping("/index")
    @ResponseBody
    String home() {
        return "index";
    }
}
