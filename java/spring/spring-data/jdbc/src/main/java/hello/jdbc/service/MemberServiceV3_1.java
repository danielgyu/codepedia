package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV3_1 {
    private final PlatformTransactionManager manager;
    private final MemberRepositoryV3 memberRepositoryV3;

    public void accountTransfer(String fromId, String toId, int amount) throws SQLException {
        TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());

        try {
            runLogic(fromId, toId, amount);
            manager.commit(status);
        } catch (Exception e) {
            manager.rollback(status);
            throw new IllegalStateException();
        }
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
