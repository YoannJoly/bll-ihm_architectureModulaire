package fr.yoann.architecturemodulaire.dal;

import fr.yoann.architecturemodulaire.bo.Glace;
import fr.yoann.architecturemodulaire.bo.Pain;
import fr.yoann.architecturemodulaire.bo.Stylo;
import fr.yoann.architecturemodulaire.dal.jdbc.GlaceJdbcImpl;
import fr.yoann.architecturemodulaire.dal.jdbc.PainJdbcImpl;
import fr.yoann.architecturemodulaire.dal.jdbc.StyloJdbcImpl;

public class DAOFactory {

    public static DAO<Glace> getGlaceDAO() {
        return new GlaceJdbcImpl();
    }

    public static DAO<Stylo> getStyloDAO() {
        return new StyloJdbcImpl();
    }

    public static DAO<Pain> getPainDAO() {
        return new PainJdbcImpl();
    }

}



