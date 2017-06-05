package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class SQLconn {

    Connection c = null;
    public SQLconn(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assign1",
                    "postgres", "gabriel");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return c;
    }

    private List<Object> executeStatement(String statement){
        List<Object> results = null;
        Statement statementSQL;

        return results;
    }
}
