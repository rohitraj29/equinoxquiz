<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--



-->
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Anachronox</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <f:view>
        <!-- start header -->
        <div id="header">
            <div id="logo">
                <h1><a href="#">Anachronox</a></h1>
                <p>&nbsp;&nbsp;by&nbsp; Equinox</p>
            </div>
            <div id="menu">
                <ul>

                    <h:form>
                        <li ><a4j:commandLink value="Home" action="#{PageBean.homeaction}" reRender="panel1" limitToList="true"/></li>
                    
                    <li><a4j:commandLink value="About Us" action="#{PageBean.aboutaction}" reRender="panel1" limitToList="true"/></li>
                    
                    <li><a href="faces/admin/welcomeJSF.jsp">Admin</a></li>
                    <li><a href="docs/welcomeJSF.jsp">Developer Doc</a></li>
                    </h:form>
                </ul>
            </div>
        </div>
        <!-- end header -->
        <div id="headerbg"><p class="text1">&#8220;In Search of Excellence in realms <br />
            of the World&#8221;</p>
        </div>
        <!-- start page -->
        <div id="page">
            <!-- start content -->
            <div id="content">
                <!-- start latest-post -->
                <div id="latest-post" class="post">
                    <h1 class="title"></h1>
                    
                    
                        <h:form>
                            <rich:panel header="#{PageBean.richpaneltitle}" id="panel1">
                                <p>  <h:outputText value="#{PageBean.panelcontent}"/></p>
                               
                            </rich:panel>
                                
                            
                        </h:form>   
                        
                    
                </div>
                <!-- end latest-post -->
                 <!-- start recent-posts -->
                 
                <!-- end recent-posts -->
            </div>
            <!-- end content -->
            <!-- start sidebar -->
            
            <div id="recent-posts">
                
                <h:commandButton value="Please Login To Proceed">
       <rich:componentControl for="loginpanel" event="onclick" disableDefault="true"
operation="show">
      <f:param name="show" value="componentControl work(show)"/>
   </rich:componentControl>
</h:commandButton>

<rich:modalPanel  id="loginpanel" height="250" width="500" resizeable="false" moveable="false">
    <f:facet name="header">
        <h:outputText value="Registered Users Please Login"/>
    </f:facet>
   
       <h:form>
           <br/><br/><br/>
           
           <h:panelGrid columns="2" width="400">
           <h:outputText value="Enter User Name" />
           <h:inputText value="#{LoginBean.username}" />
           <h:outputText value="Enter Password"/>
           <h:inputSecret value="#{LoginBean.password}"/>
           <a4j:commandButton value="Login" action="#{LoginBean.userlogin}" reRender="message" limitToList="true"/>
           <a4j:commandButton value="Cancel" id="cancel" />
           
           <rich:componentControl id="compcon1" attachTo="cancel" for="loginpanel" event="onclick" operation="hide" />
           
           
       </h:panelGrid>
       <div width="100%">
       <rich:panel id="message"><h:messages errorStyle="color: red"  infoStyle="color: green" layout="table"/></rich:panel>
   </div>
       
       </h:form>
   
</rich:modalPanel>

                       </div>
                       <div id="sidebar">
                          
                            </div>
            <!-- end sidebar -->
        </div>
        <!-- end page -->
        <div id="footer">
        </div>        
        </f:view>
    </body>

</html>



      
