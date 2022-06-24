package fr.yoann.architecturemodulaire.dal.jdbc;

import fr.yoann.architecturemodulaire.bo.CartePostale;
import fr.yoann.architecturemodulaire.dal.DALException;
import fr.yoann.architecturemodulaire.dal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartePostaleJdbcImpl implements DAO<CartePostale> {
    private static final String SQL_INSERT = "INSERT INTO produit (refProd, libelle, marque, prixUnitaire, qteStock, typeCarte) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public void insert(final CartePostale obj) throws DALException {
        try (Connection connection = jdbcTools.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
                statement.setInt(1, obj.getRefProd());
                statement.setString(2, obj.getLibelle());
                statement.setString(3, obj.getMarque());
                statement.setDouble(4, obj.getPrixUnitaire());
                statement.setInt(5, obj.getQteStock());
                statement.setString(6, String.valueOf(obj.getType()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}