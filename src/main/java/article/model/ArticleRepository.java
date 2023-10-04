package article.model;

import util.Util;

import java.util.ArrayList;

public class ArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();
    private int LastArticleNum = 3;
    public ArticleRepository() {
        articles.add(new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "안녕하세요", Util.getDate()));
        articles.add(new Article(2, "자바 질문좀 할게요~", "할게요~", Util.getDate()));
        articles.add(new Article(3, "정처기 따야되나요?", "되나요?", Util.getDate()));
    }

    public ArrayList<Article> allArticle() {
        return articles;
    }

    public void insert(String title, String content) {
        LastArticleNum++;
        Article article = new Article(LastArticleNum, title, content, Util.getDate());
        articles.add(article);
    }

    public void remove(Article article) {
        articles.remove(article);
    }

    public Article findByNum(int num) {
        for (Article article : articles) {
            if (article.getId() == num) {
                return article;
            }
        }
        return null;
    }

    public ArrayList<Article> findByKeyword(String keyWord) {
        ArrayList<Article> searchedArticle = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTitle().contains(keyWord)) {
                searchedArticle.add(article);
            }
        }
        return searchedArticle;
    }
}
