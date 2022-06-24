package fr.yoann.architecturemodulaire.dal.jdbc;



import fr.yoann.architecturemodulaire.bo.Auteur;
import fr.yoann.architecturemodulaire.dal.DALException;
import fr.yoann.architecturemodulaire.dal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuteurJdbcImpl implements DAO<Auteur> {
    private static final String SQL_INSERT = "INSERT INTO auteur (nom, prenom) VALUES (?, ?)";


    @Override
    public void insert(final Auteur obj) throws DALException {
        try (Connection connection = jdbcTools.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
                statement.setString(1, obj.getNom());
                statement.setString(2, obj.getPrenom());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DALException("Insert failed", e.getCause());
        }


    }
}
