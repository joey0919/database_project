package com.socft.drugproject.main;

import com.socft.drugproject.login.UserService;
import com.socft.drugproject.login.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MainService mainService;

    /**
     * 시작 페이지 ->
     * 로그인시: 약물정보
     * 비로그인시: 로그인창
     **/
    @RequestMapping(value = "/")
    public String index(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());

        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);
        return "/main/druginfo";
    }

    /**
     * 약물정보 페이지
     **/
    @RequestMapping(value = "/main/druginfo")
    public String druginfo(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());

        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);

        // 약물정보 리스트
        List<DrugVo> drugList = this.mainService.getDrugInfo();
        model.addAttribute("drug", drugList);

        return "/main/druginfo";
    }

    /**
     * 약물 부작용 상세조회
     **/
    @ResponseBody
    @GetMapping(value = "/ajax/getDrugDetail")
    public Map getDrugDetail(ModelAndView mv, HttpServletRequest req) throws Exception {
        HashMap paramMap = formatMapRequest(req);
        System.out.println("getDrugDetail");

        int drugID = Integer.parseInt(String.valueOf(paramMap.get("drugId")));

        //약물 상세조회
        SideEffectVo effect = this.mainService.getDrugDetail(drugID);

        Map resultMap = new HashMap();
        resultMap.put("drugDetail", effect);

        return resultMap;
    }

    /**
     * 전문직 -> 약물관리 페이지
     **/
    @RequestMapping(value = "/main/drugManage")
    public String drugManage(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());

        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);

        // 약물정보 리스트
        List<DrugVo> drugList = this.mainService.getDrugInfo();
        model.addAttribute("drug", drugList);

        return "/main/drugManage";
    }
    
    /**
     * 전문직 -> 약물 추가
     **/
    @PostMapping(value = "/main/insertDrug")
    public String insertDrug(@RequestParam("drugName") String drugName,
                             @RequestParam("manufacturer") String manufacturer,
                             @RequestParam("description") String description) throws Exception {
        System.out.println(drugName + " " + manufacturer + " " + description);

        DrugVo drugVo = new DrugVo();
        drugVo.setDrugName(drugName);
        drugVo.setManufacturer(manufacturer);

        this.mainService.insertDrug(drugName, manufacturer, description);

        return "redirect:/main/drugManage";
    }

    /**
     * 전문직 -> 약물 수정
     **/
    @RequestMapping(value = "/main/updateDrug")
    public String updateDrug(@RequestParam("drugId") Long drugId,
                             @RequestParam("drugName") String drugName,
                             @RequestParam("manufacturer") String manufacturer,
                             @RequestParam("description") String description) throws Exception {

        System.out.println(drugId);
        this.mainService.updateDrug(drugId, drugName, manufacturer, description);

        return "redirect:/main/drugManage";
    }

    /**
     * 전문직 -> 약물 삭제
     **/
    @RequestMapping(value = "/main/deleteDrug")
    public String deleteDrug(@RequestParam("drugId") Long drugId) throws Exception {

        System.out.println(drugId);
        this.mainService.deleteDrug(drugId);

        return "redirect:/main/drugManage";
    }

    /**
     * 약물 상호작용조회 페이지
     **/
    @RequestMapping(value = "/main/druginteraction")
    public String druginteraction(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());
        System.out.println(userVo.getUserType());
        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);

        // 약물정보 리스트
        List<DrugVo> drugList = this.mainService.getDrugInfo();
        model.addAttribute("drug", drugList);

        return "/main/druginteraction";
    }

    /**
     * 전문직 -> 약물 상호작용 조회 수행
     **/
    @ResponseBody
    @GetMapping(value = "/ajax/interactionProcess")
    public Map interactionProcess(ModelAndView mv, HttpServletRequest req) throws Exception {
        HashMap paramMap = formatMapRequest(req);

        int drug1 = Integer.parseInt(String.valueOf(paramMap.get("drug1")));
        int drug2 = Integer.parseInt(String.valueOf(paramMap.get("drug2")));

        //약물 상호작용 조회
        InteractionVo interaction = this.mainService.getInteraction(drug1, drug2);

        Map resultMap = new HashMap();
        resultMap.put("interaction", interaction);

        return resultMap;
    }

    /**
     * 일반사용자 -> 전문직 인증 요청
     **/
    @RequestMapping(value = "/main/certification")
    public String certification(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());
        System.out.println(userVo.getUserType());
        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);


        return "/main/certification";
    }

    /**
     * 일반사용자 -> 전문직 권한으로 변경
     **/
    @PostMapping(value = "/main/updateUserType")
    public String updateUserType(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //전문가 업데이트
        this.mainService.updateUserType(id);
        return "redirect:/";
    }

    /**
     * 일반사용자 -> 피드백 페이지
     **/
    @RequestMapping(value = "/main/feedback")
    public String feedback(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정

        // 메뉴 목록 가져오기
        List<MenuVo> menuList = this.mainService.getMenuList(userVo.getUserType());
        System.out.println(userVo.getUserType());
        model.addAttribute("user", userVo);
        model.addAttribute("menu", menuList);


        return "/main/feedback";
    }

    /**
     * 일반사용자 -> 피드백 요청
     **/
    @PostMapping(value = "/main/insertFeedback")
    public String insertFeedback(@RequestParam("feedback") String feedback) throws Exception {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //전문가 업데이트
        this.mainService.insertFeedback(id, feedback);
        return "redirect:/main/feedback";
    }

    /**
     * 프론트에서 요청한 request -> HashMap
     **/
    public HashMap<String,Object> formatMapRequest(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();

        Enumeration<String> enumber = request.getParameterNames();

        while (enumber.hasMoreElements()) {
            String key = enumber.nextElement().toString();
            String value = request.getParameter(key);

            map.put(key, value);
        }

        return map;
    }

}
