package com.vagnerbarbosa.termometro.vendas.web.datasource;

/**
 *
 * @author vagner
 */
public interface UserService {
 
    User findById(int id);     
    User findBySso(String sso);
     
}
