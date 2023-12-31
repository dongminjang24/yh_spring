package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.argumentResolver.Login;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;
//    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @GetMapping("/")//false인 이유는 로그인 안한사용자도 들어와야해서
    public String homeLoginV1(@CookieValue(name = "memberId",required = false) Long memberId, Model model){

        if (memberId == null){
            log.info("1단계");
            return "home";
        }

        //로그인한 사용자

        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null){
            log.info("2단계");
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }


//    @GetMapping("/")//false인 이유는 로그인 안한사용자도 들어와야해서
    public String homeLoginV2(HttpServletRequest request,Model model){

        //세션 관리자에 저장된 회원 정보 조회
        Member member = (Member)sessionManager.getSession(request);

        //로그인한 사용자
        if (member == null){
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }


//    @GetMapping("/")//false인 이유는 로그인 안한사용자도 들어와야해서
    public String homeLoginV3(HttpServletRequest request,Model model){

        // true라면 세션을 자동으로 생성해주는데,로그인을 하지 않은 유저들도 자동으로 생성해주면 안되기 때문에,false로
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "home";
        }

        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);


        //세션에 회원 데이터가 없으면 홈
        if (loginMember == null){
            return "home";
        }

        // 세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }


//    @GetMapping("/")//false인 이유는 로그인 안한사용자도 들어와야해서
    public String homeLoginSpring(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false) Member loginMember, Model model){


        //세션에 회원 데이터가 없으면 홈
        if (loginMember == null){
            return "home";
        }

        // 세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }


    @GetMapping("/")
    public String homeLoginArgumentResolver(@Login Member loginMember, Model model){


        //세션에 회원 데이터가 없으면 홈
        if (loginMember == null){
            return "home";
        }

        // 세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}