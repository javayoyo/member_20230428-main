package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String saveForm() {
        return "memberSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        int saveResult = memberService.save(memberDTO);
        if (saveResult > 0) {
            return "memberLogin";
        } else {
            return "index";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "memberLogin";
    }

    /*
    *  세션(session)
    * */
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
//            model.addAttribute("loginEmail", memberDTO.getMemberEmail());
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "memberMain";
        } else {
            return "memberLogin";
        }
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "memberMain";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에 담긴 값 전체 삭제
        session.invalidate();
        // 특정 파라미터만 삭제
        session.removeAttribute("loginEmail");
        return "redirect:/";
    }
}















