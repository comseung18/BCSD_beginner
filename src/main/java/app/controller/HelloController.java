package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/helloBody",  method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        try
        {
            Thread.sleep(100);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return "hello";
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello2(){
        return "hello";
    }
}
