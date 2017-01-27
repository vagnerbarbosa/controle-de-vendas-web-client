package com.vagnerbarbosa.termometro.vendas.web.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vagner
 */ 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao dao;
 
    @Override
    public User findById(int id) {
        return dao.findById(id);
    }
 
    @Override
    public User findBySso(String sso) {
        return dao.findBySSO(sso);
    }
 
}
