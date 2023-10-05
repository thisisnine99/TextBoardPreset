package article.model;

import util.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommentRepository {
    private ArrayList<Comment> comments = new ArrayList<>();
    private int LastCommentNum = 0;
    public void insert(String content, int articleId) {
        LastCommentNum++;
        Comment comment = new Comment(LastCommentNum, articleId, content, Util.getDate());
        comments.add(comment);
    }

    public ArrayList<Comment> findByarticleNum(int articleId) {
        ArrayList<Comment> articleComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getArticleId() == articleId) {
                articleComments.add(comment);
            }
        }
        return articleComments;
    }
}
