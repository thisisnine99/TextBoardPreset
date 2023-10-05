package article.model;

import util.Util;

import java.util.ArrayList;

public class MemberRepository {
    private ArrayList<Member> members = new ArrayList<>();
    private int LastUserNumber = 2;
    public MemberRepository() {
        members.add(new Member(1, "admin1", "1234", "어드민1", Util.getDate()));
        members.add(new Member(2, "admin2", "1234", "어드민2", Util.getDate()));
    }
    public void insert(String userId, String userPw, String userName) {
        LastUserNumber++;
        Member member = new Member(LastUserNumber, userId, userPw, userName, Util.getDate());
        members.add(member);
    }
    public Member findByUserId(int userId) {
        for (Member member : members) {
            if (member.getId() == userId) {
                return member;
            }
        }
        return null;
    }

    public Member compareByInput(String inputId, String inputPw) {
        for (Member member : members) {
            if (member.getUserId().equals(inputId)) {
                if (member.getUserPw().equals(inputPw)) {
                    return member;
                }
            }
        }
        return null;
    }
}
