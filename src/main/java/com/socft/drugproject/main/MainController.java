package com.socft.drugproject.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MainService mainService;

    @RequestMapping(value = "/")
    public String index(HttpServletResponse response, HttpServletRequest request) throws Exception {

        List<Map> result = this.mainService.getTest();
        System.out.println(result);

        return "/main/main";
    }
}
