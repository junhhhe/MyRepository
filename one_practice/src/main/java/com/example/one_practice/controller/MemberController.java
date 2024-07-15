package com.example.one_practice.controller;

import com.example.one_practice.dto.CustomUserDetails;
import com.example.one_practice.dto.RequestJoinDto;
import com.example.one_practice.dto.RequestLoginDto;
import com.example.one_practice.entity.Member;
import com.example.one_practice.jwt.JWTUtil;
import com.example.one_practice.repository.MemberRepository;
import com.example.one_practice.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class MemberController {

    private final MemberService memberService;
    private final JWTUtil jwtUtil;
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("loginType", "jwt-login");
        model.addAttribute("pageName", "스프링 시큐리티 JWT 로그인");

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        /*Member loginMember = joinService.getLoginMemberById(loginId);

        if (loginMember != null) {
            model.addAttribute("name", loginMember.getName());
        }*/

        return "MemberController: " + username + ", "+ role;
    }

    @GetMapping("/join")
    public String joinPage(Model model) {

        model.addAttribute("loginType", "jwt-login");
        model.addAttribute("pageName", "스프링 시큐리티 JWT 로그인");

        // 회원가입을 위해서 model 통해서 joinRequest 전달
        model.addAttribute("joinRequest", new RequestJoinDto());
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestBody RequestJoinDto joinRequest, BindingResult bindingResult, Model model) {

        model.addAttribute("loginType", "jwt-login");
        model.addAttribute("pageName", "스프링 시큐리티 JWT 로그인");

        // ID 중복 여부 확인
        if (memberService.checkLoginIdDuplicate(joinRequest.getUsername())) {
            return "ID가 존재합니다.";
        }


        // 비밀번호 = 비밀번호 체크 여부 확인
        if (!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())) {
            return "비밀번호가 일치하지 않습니다.";
        }

        // 에러가 존재하지 않을 시 joinRequest 통해서 회원가입 완료
        memberService.securityJoin(joinRequest);

        // 회원가입 시 홈 화면으로 이동
        return "redirect:/jwt-login";
    }
    @PostMapping("/login")
    public String login(@RequestBody RequestLoginDto loginRequest){

        Member member = memberService.login(loginRequest);

        if(member==null){
            return "ID 또는 비밀번호가 일치하지 않습니다!";
        }

        String token = jwtUtil.createJwt(member.getUsername(), String.valueOf(member.getRole()), member.getName());
        return token;
    }

    @GetMapping("/info")
    public String memberInfo(Authentication auth, Model model) {

        System.out.println("auth = " + auth);

        // CustomUserDetails를 사용하여 로그인된 사용자의 정보를 가져옴
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        Member loginMember = userDetails.getMember();

        return "ID : " + loginMember.getUsername() + "\n이름 : " + loginMember.getName() + "\nrole : " + loginMember.getRole();
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {

        return "인가 성공!";
    }

}