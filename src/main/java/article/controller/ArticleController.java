package article.controller;

import article.model.*;
import article.view.ArticleView;
import article.view.CommentView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();
    Scanner sc = new Scanner(System.in);
    CommentRepository commentRepository = new CommentRepository();
    CommentView commentView = new CommentView();
    MemberRepository memberRepository = new MemberRepository();

    public void add(Member member) {
        if (member == null) {
            System.out.println("로그인 후 이용가능 합니다.");
            return;
        }
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();
        articleRepository.insert(title, content, member);
        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        ArrayList<Article> articles = articleRepository.allArticle();
        articleView.printArticleList(articles);
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        String strNum = sc.nextLine();
        int num = convertInt(strNum);
        if (num == -1) {
            System.out.println("숫자를 입력해주세요");
        } else {
            Article article = articleRepository.findByNum(num);
            if (article == null) {
                System.out.println("없는 게시물 번호입니다.");
            } else {
                setTitleContent(article);
                System.out.printf("%d번 게시물이 수정되었습니다\n", num);
            }
        }
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        String strNum = sc.nextLine();
        int num = convertInt(strNum);
        if (num == -1) {
            System.out.println("숫자를 입력해주세요");
        } else {
            Article article = articleRepository.findByNum(num);
            if (article == null) {
                System.out.println("없는 게시물 번호입니다.");
            } else {
                articleRepository.remove(article);
                System.out.printf("%d번 게시물이 삭제되었습니다\n", num);
            }
        }
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호 : ");
        String strNum = sc.nextLine();
        int num = convertInt(strNum);
        if (num == -1) {
            System.out.println("숫자를 입력해주세요");
        } else {
            Article article = articleRepository.findByNum(num);
            if (article == null) {
                System.out.println("없는 게시물 번호입니다.");
            } else {
                article.setHit(article.getHit() + 1);
                Member member = memberRepository.findByUserId(article.getUserId());
                articleView.printArticle(article, member);
                ArrayList<Comment> comments = commentRepository.findByarticleNum(article.getId());
                commentView.printComment(comments);
                detailFunc(article);
            }
        }
    }

    public void search() {
        System.out.print("검색 키워드 : ");
        String keyWord = sc.nextLine();
        ArrayList<Article> searchedArticles = articleRepository.findByKeyword(keyWord);
        if (searchedArticles.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            articleView.printArticleList(searchedArticles);
        }
    }

    public void detailFunc(Article article) {
        while (true) {
            System.out.print("상세보기 기능을 선택해주세요\n 1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로\n");
            String detailFuncStrNum = sc.nextLine();
            int detailFunNum = convertInt(detailFuncStrNum);
            if (detailFunNum == -1) {
                System.out.println("숫자를 입력해주세요");
            } else if (detailFunNum == 1) {
                addComment(article);
            } else if (detailFunNum == 2) {
                System.out.println("추천");
            } else if (detailFunNum == 3) {
                setTitleContent(article);
            } else if (detailFunNum == 4) {
                System.out.print("정말 게시물을 삭제하시겠습니까? ( Y / N) : ");
                String answer = sc.nextLine();
                if (answer.equals("Y")) {
                    System.out.println("게시물이 삭제되었습니다");
                    articleRepository.remove(article);
                    break;
                } else if (answer.equals("N")) {
                    System.out.println("취소되었습니다");
                    break;
                }
            } else if (detailFunNum == 5) {
                System.out.println("목록으로 돌아갑니다.");
                break;
            }
        }
    }

    public void setTitleContent(Article article) {
        System.out.print("새로운 제목 : ");
        String newTitle = sc.nextLine();
        System.out.print("새로운 내용 : ");
        String newContent = sc.nextLine();
        article.setTitle(newTitle);
        article.setContent(newContent);
        ArrayList<Comment> comments = commentRepository.findByarticleNum(article.getId());
        Member member = memberRepository.findByUserId(article.getUserId());
        articleView.printArticle(article, member);
        commentView.printComment(comments);
    }

    public void addComment(Article article) {
        System.out.print("댓글 내용 : ");
        String comment = sc.nextLine();
        commentRepository.insert(comment, article.getId());
        System.out.println("댓글이 성공적으로 등록되었습니다.");
        ArrayList<Comment> comments = commentRepository.findByarticleNum(article.getId());
        Member member = memberRepository.findByUserId(article.getUserId());
        articleView.printArticle(article, member);
        commentView.printComment(comments);
    }

    public int convertInt(String strNum) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException ignored) {
        }
        return -1;
    }
}
