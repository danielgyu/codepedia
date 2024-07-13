package hello.jdbc.service;

import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

class MemberServiceV3_2Test {
    static final String MEM_A = "memberA";
    static final String MEM_B = "memberE";
    static final String MEM_EX = "ex";

    private MemberServiceV3_2 memberServiceV3;
    private MemberRepositoryV3 memberRepositoryV3;

    @BeforeEach
    void before() {
        DataSource ds = new DriverManagerDataSource(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        memberRepositoryV3 = new MemberRepositoryV3(ds);
        PlatformTransactionManager manager = new DataSourceTransactionManager(ds);
        memberServiceV3 = new MemberServiceV3_2(manager, memberRepositoryV3);
    }

    @Test
    void accountTransfer() throws SQLException {
        Member memberA = new Member(MEM_A, 1000);
        Member memberB = new Member(MEM_B, 5000);
        Member memberEX = new Member(MEM_EX, 5000);
        memberRepositoryV3.delete();
        memberRepositoryV3.save(memberA);
        memberRepositoryV3.save(memberB);
        memberRepositoryV3.save(memberEX);

        memberServiceV3.accountTransfer(MEM_A, MEM_B, 1000);
        //memberServiceV3.accountTransfer(MEM_A, MEM_EX, 1000);
    }
}