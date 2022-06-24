package fr.yoann.architecturemodulaire.dal.jdbc;

import fr.yoann.architecturemodulaire.bo.Glace;
import fr.yoann.architecturemodulaire.bo.ProduitPerissable;
import fr.yoann.architecturemodulaire.dal.DALException;
import fr.yoann.architecturemodulaire.dal.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GlaceJdbcImpl implements DAO<Glace> {
    private static final String SQL_INSERT = "INSERT INTO produit (refProd, libelle, marque, prixUnitaire, qteStock,  parfum, temperatureConservation, dateLimiteConso) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

    public void insert(final Glace obj) throws DALException {
        try (Connection connection = jdbcTools.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
                statement.setInt(1, obj.getRefProd());
                statement.setString(2, obj.getLibelle());
                statement.setString(3, obj.getMarque());
                statement.setDouble(4, obj.getPrixUnitaire());
                statement.setInt(5, obj.getQteStock());
                statement.setString(6, obj.getParfum());
                statement.setInt(7, obj.getTemperatureConservation());
                statement.setDate(8, Date.valueOf(ProduitPerissable.getDateLimiteConso()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DALException("Insert failed", e.getCause());
        }

    }
}
