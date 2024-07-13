package hello.jdbc.service;

import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceV3_3Test {
    static final String MEM_A = "memberA";
    static final String MEM_B = "memberE";
    static final String MEM_EX = "ex";

    @Autowired private MemberRepositoryV3 memberRepositoryV3;
    @Autowired private MemberServiceV3_3 memberServiceV3;

    @TestConfiguration
    static class TestConfig {
        @Bean
        DataSource dataSource() {
            return new DriverManagerDataSource(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        }

        @Bean
        PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        MemberRepositoryV3 memberRepositoryV3() {
            return new MemberRepositoryV3(dataSource());
        }

        @Bean
        MemberServiceV3_3 memberServiceV3() {
            return new MemberServiceV3_3(memberRepositoryV3());
        }

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