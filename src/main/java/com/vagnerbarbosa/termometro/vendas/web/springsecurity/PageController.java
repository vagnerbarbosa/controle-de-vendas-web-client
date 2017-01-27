package com.vagnerbarbosa.termometro.vendas.web.springsecurity;

import com.vagnerbarbosa.termometro.vendas.web.datasource.CustomUserDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
 
     
    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("title", "Painel Administrativo");
        model.addAttribute("user", getPrincipal().getUsername());
        model.addAttribute("name", getPrincipal().getFirstName());
        model.addAttribute("surname", getPrincipal().getLastName());
        model.addAttribute("email", getPrincipal().getEmail());
        model.addAttribute("filial", getPrincipal().getLounge());
        return "welcome";
    }
    
    @RequestMapping(value = { "/vendas" }, method = RequestMethod.GET)
    public String salePage(ModelMap model) {
        model.addAttribute("title", "Mapa de Vendas");
        model.addAttribute("user", getPrincipal().getUsername());
        model.addAttribute("name", getPrincipal().getFirstName());
        model.addAttribute("surname", getPrincipal().getLastName());
        model.addAttribute("email", getPrincipal().getEmail());
        model.addAttribute("filial", getPrincipal().getLounge());
        return "salePage";
    }

   @RequestMapping(value = { "/controle" }, method = RequestMethod.GET)
    public String saleChartPage(ModelMap model) {
        model.addAttribute("title", "Controle de Entregas e Montagens");
        model.addAttribute("user", getPrincipal().getUsername());
        model.addAttribute("name", getPrincipal().getFirstName());
        model.addAttribute("surname", getPrincipal().getLastName());
        model.addAttribute("email", getPrincipal().getEmail());
        model.addAttribute("filial", getPrincipal().getLounge());
        return "saleChart";
    }      
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal().getUsername());
        model.addAttribute("name", getPrincipal().getFirstName());
        model.addAttribute("surname", getPrincipal().getLastName());
        model.addAttribute("email", getPrincipal().getEmail());
        model.addAttribute("filial", getPrincipal().getLounge());
        return "admin";
    }
     
    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal().getUsername());
        model.addAttribute("name", getPrincipal().getFirstName());
        model.addAttribute("surname", getPrincipal().getLastName());
        model.addAttribute("email", getPrincipal().getEmail());
        model.addAttribute("filial", getPrincipal().getLounge());
        return "dba";
    }
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("title", "Acesso não permitido");
        model.addAttribute("user", getPrincipal().getUsername());
        model.addAttribute("name", getPrincipal().getFirstName());
        model.addAttribute("surname", getPrincipal().getLastName());
        model.addAttribute("email", getPrincipal().getEmail());
        model.addAttribute("filial", getPrincipal().getLounge());
        return "accessDenied";
    }
 
    @RequestMapping(value = {"/login", "/" }, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
    private CustomUserDetails getPrincipal(){       
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        CustomUserDetails userName = null;
        if (principal instanceof UserDetails) {
            userName = ((CustomUserDetails)principal);
        } else {
            //userName = principal.toString();
        }
        return userName;
    }
 
}