package com.study.domain.resttime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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

}