package com.vagnerbarbosa.termometro.vendas.web.datasource;


import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private Integer lounge;
    
        public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked,
                      Collection<GrantedAuthority> authorities, Integer lounge) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
 
        // Initialize all the custom attributes here like the following.
        this.lounge = lounge;
    }

    public Integer getLounge() {
        return lounge;
    }

    public void setLounge(Integer lounge) {
        this.lounge = lounge;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" + "lounge=" + lounge + '}';
    }
      
}
