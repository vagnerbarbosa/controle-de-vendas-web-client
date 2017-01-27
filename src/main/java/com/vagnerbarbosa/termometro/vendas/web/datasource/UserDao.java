package com.vagnerbarbosa.termometro.vendas.web.datasource;

/**
 *
 * @author vagner
 */
public interface UserDao {
 
    User findById(int id);
     
    User findBySSO(String sso);
     
}
