package com.vagnerbarbosa.termometro.vendas.web.datasource;


import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private Integer lounge;
    private String firstName;
    private String lastName;
    private String email;
    
        public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked,
                      Collection<GrantedAuthority> authorities, Integer lounge, String firstName, String lastName, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
 
        // Initialize all the custom attributes here like the following.
        this.lounge = lounge;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getLounge() {
        return lounge;
    }

    public void setLounge(Integer lounge) {
        this.lounge = lounge;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" + "lounge=" + lounge + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }
      
}
