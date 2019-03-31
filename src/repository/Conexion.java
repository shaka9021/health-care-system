package repository;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class Conexion {

    private static HikariDataSource DATASOURCE;
    private static QueryRunner RUNNER;

    static {
        DATASOURCE = new HikariDataSource();
        DATASOURCE.setJdbcUrl("jdbc:mysql://localhost/medical_record?"
                + "useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                + "useLegacyDatetimeCode=false&serverTimezone=UTC");
        DATASOURCE.setUsername("root");
        DATASOURCE.setPassword("2535818");
        RUNNER = new QueryRunner(DATASOURCE);
    }

    public static QueryRunner runner() {
        return RUNNER;
    }

}
