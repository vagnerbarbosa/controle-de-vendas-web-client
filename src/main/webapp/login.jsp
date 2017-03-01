<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:jsf="http://xmlns.jcp.org/jsf"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:a4j="http://richfaces.org/a4j"
      xmlns:p="http://primefaces.org/ui">

    <head jsf:id="head">

        <meta jsf:charset="utf-8"/>
        <meta jsf:name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

        <title>Lojão Rio do Peixe</title>

        <link jsf:name="contents/img/DB_16?16.png" rel="icon" type="image/png" href="contents/img/DB_16?16.png"/>
        <link jsf:name="contents/css/font-awesome.min.css" rel="stylesheet" href="contents/css/font-awesome.min.css" />        
        <link jsf:name="contents/css/bootstrap.min.css" rel="stylesheet" href="contents/css/bootstrap.min.css" />        
        <link jsf:name="contents/css/mdb.min.css" rel="stylesheet" href="contents/css/mdb.min.css" />        
        <link jsf:name="contents/css/style.css" rel="stylesheet" href="contents/css/style.css" />
        <f:event listener="${vendasResourceManagedBean.vendas}" type="preRenderView" />

    </head>
    <body jsf:id="body">

        <header jsf:id="header">
            <nav class="navbar bg-primary" jsf:id="nav-blue">
                <div>
                    <a href="#/" class="navbar-brand"><img id="logo" src="contents/img/logolrp.svg" alt="Logo Lojao Rio do Peixe"/></a>                
                    <ul class="nav navbar-nav">
                        <li class="nav-link text-xl-left"><h1 class="h1-responsive" style="color: #FFFFFF" id="titulo" >Lojão Rio do Peixe</h1></li>
                    </ul>
                </div>
            </nav>
        </header> 
        <div id="mainWrapper">
            <div class="view hm-black-light">
                <div class="full-bg-img flex-center">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <ul>
                                <li>
                                    <c:if test="${param.error != null}">
                                        <div >
                                            <p><h1 class="h1-responsive wow fadeInUp title"><span class="alert alert-danger">Usuário ou Senha inválida!</span></h1></p>
                                        </div>
                                    </c:if>
                                </li>
                                <li>   
                                    <c:if test="${param.logout != null}">
                                        <div >
                                            <p><h1 class="h1-responsive wow fadeInUp title">Por gentileza, informe seu Usuário e Senha.</h1></p>
                                        </div>
                                    </c:if>
                                </li>
                                <li>
                                    <c:if test="${param.logout == null && param.error == null}">
                                        <div >
                                            <p><h1 class="h1-responsive wow fadeInUp title">Por gentileza, informe seu Usuário e Senha.</h1></p>
                                        </div>
                                    </c:if>
                                </li>
                            </ul>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="md-form">
                                        <input type="text" class="form-control" id="username" name="ssoId" placeholder="Usuário" required>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="md-form">
                                        <input type="password" class="form-control" id="password" placeholder="Senha" name="password" required>
                                    </div>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                                <div class="form-actions">
                                    <div class="col-md-1">
                                        <div class="md-form">
                                            <input type="submit"
                                                   class="btn btn-md btn-success" value="Entrar">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                                  
        <script type="text/javascript" src="contents/js/utils.js"></script>        
        <script type="text/javascript" src="contents/js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="contents/js/tether.min.js"></script>
        <script type="text/javascript" src="contents/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="contents/js/mdb.min.js"></script>
        <script type="text/javascript" src="contents/js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="contents/js/tether.min.js"></script>
        <script type="text/javascript" src="contents/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="contents/js/mdb.min.js"></script>                                

    </body>
</html>