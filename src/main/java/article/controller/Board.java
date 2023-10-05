package article.controller;

import article.model.Member;

import java.util.Scanner;

public class Board {
    Scanner sc = new Scanner(System.in);
    ArticleController articleController = new ArticleController();
    MemberController memberController = new MemberController();

    public void start() {
        while(true) {
            Member member = memberController.getLoginedMember();
            if (member == null) {
                System.out.print("명령어 : ");
            } else {
                System.out.printf("명령어[%s(%s)] : ", member.getUserId(), member.getUserName());
            }
            String cmd = sc.nextLine();
            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("add")) {
                articleController.add(member);
            } else if (cmd.equals("list")) {
                articleController.list();
            } else if (cmd.equals("update")) {
                articleController.update();
            } else if (cmd.equals("delete")) {
                articleController.delete();
            } else if (cmd.equals("detail")) {
                articleController.detail();
            } else if (cmd.equals("search")) {
                articleController.search();
            } else if (cmd.equals("signup")) {
                memberController.signup();
            } else if (cmd.equals("login")) {
                memberController.login();
            }
        }

    }
}
