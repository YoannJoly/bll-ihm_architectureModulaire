package fr.yoann.architecturemodulaire.dal.jdbc;

import fr.yoann.architecturemodulaire.bo.Glace;
import fr.yoann.architecturemodulaire.dal.DALException;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestGlaceJdbcImpl {
    static LocalDate dateLimiteConso = LocalDate.of(2020, 12, 31);

    public static void main(String[] args) throws DALException, SQLException {
        Connection connection = jdbcTools.getConnection();
        Glace glace = new Glace(121541, "Glace au chocolat", "Miko", 4, 60, dateLimiteConso, "Chocolat", -18);
        GlaceJdbcImpl glaceJdbcImpl = new GlaceJdbcImpl();
        glaceJdbcImpl.insert(glace);
        jdbcTools.closeConnection(connection);

    }
}



