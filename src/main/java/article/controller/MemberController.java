package article.controller;

import article.model.Member;
import article.model.MemberRepository;

import java.util.Scanner;

public class MemberController {
    MemberRepository memberRepository = new MemberRepository();
    Scanner sc = new Scanner(System.in);
    private Member loginedMember = null;
    public void signup() {
        System.out.println("===== 회원가입을 진행합니다.=====");
        System.out.print("아이디 : ");
        String userId = sc.nextLine();
        System.out.print("비밀번호 : ");
        String userPw = sc.nextLine();
        System.out.print("닉네임 : ");
        String userName = sc.nextLine();
        memberRepository.insert(userId, userPw, userName);
        System.out.println("===== 회원가입이 완료되었습니다. =====");
    }

    public void login() {
        System.out.print("아이디 : ");
        String inputId = sc.nextLine();
        System.out.print("비밀번호 : ");
        String inputPw = sc.nextLine();
        Member member = memberRepository.compareByInput(inputId, inputPw);
        if (member == null) {
            System.out.println("비밀번호가 틀렸거나 잘못입력하셨습니다.");
        } else {
            System.out.printf("%s님 환영합니다!\n", member.getUserName());
            loginedMember = member;
        }
    }

    public Member getLoginedMember() {
        return loginedMember;
    }
}
