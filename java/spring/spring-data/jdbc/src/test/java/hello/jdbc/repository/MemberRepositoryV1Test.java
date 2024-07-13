package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
class MemberRepositoryV1Test {
    MemberRepositoryV1 repositoryV1;

    @BeforeEach
    void beforeEach() throws InterruptedException{
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl(ConnectionConst.URL);
        ds.setUsername(ConnectionConst.USERNAME);
        ds.setPassword(ConnectionConst.PASSWORD);
        ds.setMaximumPoolSize(10);
        ds.setPoolName("MyPool");
        Thread.sleep(500);
        repositoryV1 = new MemberRepositoryV1(ds);
    }

    @Test
    void crud() throws SQLException {
        repositoryV1.delete();

        String memberId = "member1";
        Member member1 = new Member(memberId, 1000);
        repositoryV1.save(member1);

        Member foundMember = repositoryV1.findById(memberId);
        log.info("foundMember" + foundMember);
        Assertions.assertThat(foundMember).isEqualTo(member1);

        repositoryV1.update(memberId, 2000);
        Member updatedMember = repositoryV1.findById(memberId);
        log.info("updatedMember" + updatedMember);
    }
}