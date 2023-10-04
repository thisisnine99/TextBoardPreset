package article.controller;

import article.model.Article;
import article.model.ArticleRepository;
import article.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();
    Scanner sc = new Scanner(System.in);

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();
        articleRepository.insert(title, content);
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
                System.out.print("새로운 제목 : ");
                String newTitle = sc.nextLine();
                System.out.print("새로운 내용 : ");
                String newContent = sc.nextLine();
                article.setTitle(newTitle);
                article.setContent(newContent);
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
                articleView.printArticle(article);
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

    public int convertInt(String strNum) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException ignored) {
        }
        return -1;
    }
}
