package fr.yoann.architecturemodulaire.dal;



public interface DAO<T> {
    void insert(T obj) throws DALException;
}
