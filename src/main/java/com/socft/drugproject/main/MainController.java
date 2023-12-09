package com.socft.drugproject.main;

import com.socft.drugproject.login.UserService;
import com.socft.drugproject.login.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/")
    public String index(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값


        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());
        System.out.println(menuList);
        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);
        return "/main/main";
    }
}
