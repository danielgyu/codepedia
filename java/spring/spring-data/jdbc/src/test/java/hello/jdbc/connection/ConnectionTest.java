package hello.jdbc.connection;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionTest {

    @Test
    void dataSourceConnectionPool() throws SQLException, InterruptedException {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(ConnectionConst.URL);
        hikariDataSource.setUsername(ConnectionConst.USERNAME);
        hikariDataSource.setPassword(ConnectionConst.PASSWORD);
        hikariDataSource.setMaximumPoolSize(10);
        hikariDataSource.setPoolName("MyPool");
        Thread.sleep(1000);

        //userDataSource(hikariDataSource);
    }

    @Test
    void driverManager() throws SQLException {
        Connection con1 = DriverManager.getConnection(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        Connection con2 = DriverManager.getConnection(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        log.info("con1={}, class={}", con1, con1.getClass());
        log.info("con2={}, class={}", con2, con2.getClass());
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);

        Connection con1 = driverManagerDataSource.getConnection();
        Connection con2 = driverManagerDataSource.getConnection();
        log.info("con1={}, class={}", con1, con1.getClass());
        log.info("con2={}, class={}", con2, con2.getClass());
    }

    void userDataSource(DataSource ds) throws SQLException {
        Connection con1 = ds.getConnection();
        Connection con2 = ds.getConnection();
        log.info("con1={}, class={}", con1, con1.getClass());
        log.info("con2={}, class={}", con2, con2.getClass());
    }
}
