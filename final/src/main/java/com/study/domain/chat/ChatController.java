package com.study.domain.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes("info")
@Controller
public class ChatController {
   @Autowired
   ChatHandler chathandler;

   @GetMapping("/chat/chat")
   public String method2(HttpServletRequest request,Model model) throws Exception{
      HttpSession session=request.getSession();
      if(session.getAttribute("info")!=null) {
         //session에 저장된 info값이 존재한다면 해당 코드를 실행한다.
         int count=chathandler.getCount();
         
          model.addAttribute("count",count);
          System.out.println("컨트롤러 화면리턴 직전 /chat/chat " + count+"명입니당");
            
            return "/chat/chat";
      }
      else {
         //session에 저장된 info값이 존재하지 않는다면 해당 코드를 실행한다.
         return"redirect:/fail";
      }
   }


}