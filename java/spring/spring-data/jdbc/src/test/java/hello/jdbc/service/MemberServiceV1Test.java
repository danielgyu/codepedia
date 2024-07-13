package hello.jdbc.service;

import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceV1Test {
    static final String MEM_A = "memberA";
    static final String MEM_B = "memberE";
    static final String MEM_EX = "ex";

    private MemberServiceV1 memberServiceV1;
    private MemberRepositoryV1 memberRepositoryV1;

    @BeforeEach
    void before() {
        DataSource ds = new DriverManagerDataSource(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        memberRepositoryV1 = new MemberRepositoryV1(ds);
        memberServiceV1 = new MemberServiceV1(memberRepositoryV1);
    }

    @Test
    void accountTransfer() throws SQLException {
        Member memberA = new Member(MEM_A, 1000);
        Member memberB = new Member(MEM_B, 5000);
        Member memberEX = new Member(MEM_EX, 5000);
        memberRepositoryV1.delete();
        memberRepositoryV1.save(memberA);
        memberRepositoryV1.save(memberB);
        memberRepositoryV1.save(memberEX);

        //memberServiceV1.accountTransfer(MEM_A, MEM_B, 1000);
        memberServiceV1.accountTransfer(MEM_A, MEM_EX, 1000);
    }
}