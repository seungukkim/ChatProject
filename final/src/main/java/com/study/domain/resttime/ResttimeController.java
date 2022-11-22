package com.study.domain.resttime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes("info")
@RequiredArgsConstructor
public class ResttimeController {

    private final ResttimeService resttimeService;

    // 게시글 작성 페이지
    @GetMapping("/resttime/resttime")
    public String openPostWrite(Model model) {
        return "resttime/resttime";
    }
    
    @PostMapping("/register/main")
    @ResponseBody
    public String findUserMbti(final ResttimeRequest params) {
    	String mbti = resttimeService.findUserMbti(params);
    	System.out.println(mbti);
    	return mbti;
    }

}