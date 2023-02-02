package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance(); //싱글톤이기 때문에 getInstance로 받아오기

    @RequestMapping("/springmvc/v2/members/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }


    @RequestMapping("/springmvc/v2/members/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(userName, age);

        memberRepository.save(member);

        ModelAndView modelAndView = new ModelAndView("save-result");
        modelAndView.addObject("member", member);
        return modelAndView;
    }

    @RequestMapping("/springmvc/v2/members")
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("members", members);

        return modelAndView;
    }

}
