package article.view;

import article.model.Comment;

import java.util.ArrayList;

public class CommentView {
    public void printComment(ArrayList<Comment> comments) {
        for (Comment comment : comments) {
            System.out.printf("댓글 내용 : %s\n", comment.getContent());
            System.out.printf("댓글 작성일 : %s\n", comment.getRegDate());
            System.out.println("==============================");
        }
    }
}
