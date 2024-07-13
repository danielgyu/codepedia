package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {
    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        repositoryV0.delete();

        String memberId = "member1";
        Member member1 = new Member(memberId, 1000);
        repositoryV0.save(member1);

        Member foundMember = repositoryV0.findById(memberId);
        log.info("foundMember" + foundMember);
        Assertions.assertThat(foundMember).isEqualTo(member1);

        repositoryV0.update(memberId, 2000);
        Member updatedMember = repositoryV0.findById(memberId);
        log.info("updatedMember" + updatedMember);
    }
}