package fr.yoann.architecturemodulaire.dal.jdbc;

import fr.yoann.architecturemodulaire.bo.Stylo;
import fr.yoann.architecturemodulaire.dal.DALException;

import java.sql.Connection;
import java.sql.SQLException;

public class TestStyloJdbcImpl {
    public static void main(String[] args) throws DALException, SQLException {
        Connection connection = jdbcTools.getConnection();
        Stylo stylo = new Stylo(115454, "Stylo bic", "Bic", 10.0f, 100, "rouge", "Bille");
        StyloJdbcImpl styloJdbcImpl = new StyloJdbcImpl();
        styloJdbcImpl.insert(stylo);
        jdbcTools.closeConnection(connection);
    }
}
