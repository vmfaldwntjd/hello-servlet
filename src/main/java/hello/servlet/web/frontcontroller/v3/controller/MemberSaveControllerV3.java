package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance(); //싱글톤이기 때문에 getInstance로 받아오기

    @Override
    public ModelView process(Map<String, String> paraMap) {
        String userName = paraMap.get("userName");
        int age = Integer.parseInt(paraMap.get("age"));

        Member member = new Member(userName, age);

        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");

        modelView.getModel().put("member", member);
        return modelView;
    }
}
