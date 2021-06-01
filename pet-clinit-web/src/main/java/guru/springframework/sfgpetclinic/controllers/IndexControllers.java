package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexControllers {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
    @RequestMapping("/oups")
    public String oupsHnadler(){

        return "notimplemented";
    }
}
