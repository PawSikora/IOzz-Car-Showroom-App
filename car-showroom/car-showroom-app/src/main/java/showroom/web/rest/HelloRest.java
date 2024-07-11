package showroom.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRest {

    //@RequestMapping(value="/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    @ResponseBody String sayHello() { return "Hello, World!"; }
}
