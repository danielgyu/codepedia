package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


public class MemberServiceV3_3 {
    //private final PlatformTransactionManager manager;
    private final MemberRepositoryV3 memberRepositoryV3;

    public MemberServiceV3_3(MemberRepositoryV3 memberRepositoryV3) {
        this.memberRepositoryV3 = memberRepositoryV3;
    }

    @Transactional
    public void accountTransfer(String fromId, String toId, int amount) throws SQLException {
        runLogic(fromId, toId, amount);
    }

    private void runLogic(String fromId, String toId, int amount) throws  SQLException{
        Member fromMember = memberRepositoryV3.findById(fromId);
        Member toMember = memberRepositoryV3.findById(toId);

        memberRepositoryV3.update(fromMember.getMemberId(), fromMember.getMoney()-amount);
        validate(toMember);
        memberRepositoryV3.update(toMember.getMemberId(), toMember.getMoney()+amount);
    }

    private static void validate(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("error during transfer");
        }
    }
}
