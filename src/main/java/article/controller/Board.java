package article.controller;

import java.util.Scanner;

public class Board {
    Scanner sc = new Scanner(System.in);
    ArticleController articleController = new ArticleController();
    public void start() {
        while(true) {
            System.out.print("명령어 : ");
            String cmd = sc.nextLine();
            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("add")) {
                articleController.add();
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
            }
        }

    }
}
