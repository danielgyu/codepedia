package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;

public class MemberServiceV3_2 {
    //private final PlatformTransactionManager manager;
    private final TransactionTemplate txnTemplate;
    private final MemberRepositoryV3 memberRepositoryV3;

    public MemberServiceV3_2(PlatformTransactionManager txnManager, MemberRepositoryV3 memberRepositoryV3) {
        this.txnTemplate = new TransactionTemplate(txnManager);
        this.memberRepositoryV3 = memberRepositoryV3;
    }

    public void accountTransfer(String fromId, String toId, int amount) throws SQLException {
        txnTemplate.executeWithoutResult((transactionStatus -> {
            try {
                runLogic(fromId, toId, amount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));
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
