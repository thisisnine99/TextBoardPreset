package article.view;

import article.model.Article;
import article.model.Member;

import java.util.ArrayList;

public class ArticleView {
    public void printArticleList(ArrayList<Article> articles) {
        for (Article article : articles) {
            System.out.printf("번호 : %d\n", article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.printf("작성일 : %s\n", article.getRegDate());
            System.out.println("==============================");
        }
    }

    public void printArticle(Article article, Member member) {
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("내용 : %s\n", article.getContent());
        System.out.printf("작성일 : %s\n", article.getRegDate());
        System.out.printf("조회수 : %d\n", article.getHit());
        System.out.printf("작성자 : %s\n", member.getUserName());
        System.out.println("==============================");
        System.out.println("========== 댓글 ==========");

    }
}
