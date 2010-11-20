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
                    <li><a4j:commandLink value="Photos" action="#{PageBean.photoaction}" reRender="panel1" limitToList="true"/></li>
                    <li><a4j:commandLink value="About Us" action="#{PageBean.aboutaction}" reRender="panel1" limitToList="true"/></li>
                    
                    <li><a href="#">contact</a></li>
                    </h:form>
                </ul>
            </div>
        </div>
        <!-- end header -->
        <div id="headerbg"><p class="text1">&#8220;ERROR!! Page <br />
            of the World&#8221;</p>
        </div>
        <!-- start page -->
        <div id="page">
            <!-- start content -->
            <div id="content">
                <!-- start latest-post -->
                <div id="latest-post" class="post">
                    <h1 class="title">The AnachronoxApplication Seems to be Down Please Relogin or Contact Admininstrator</h1>
                    
                    
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
                
                <h:commandButton value="Login For Apptitude Test">
       <rich:componentControl for="loginpanel" event="onclick" disableDefault="true"
operation="show">
      <f:param name="show" value="componentControl work(show)"/>
   </rich:componentControl>
</h:commandButton>

<rich:modalPanel  id="loginpanel" height="200" width="400" resizeable="false" moveable="false">
    <f:facet name="header">
        <h:outputText value="Registered Users Please Login"/>
    </f:facet>
   
       <h:form>
           <br/><br/><br/>
           <h:panelGrid columns="2" width="400">
           
           <h:outputText value="Enter User Name" />
           <h:inputText value="#{LoginBean.username}"/>
           <h:outputText value="Enter Password"/>
           <h:inputSecret value="#{LoginBean.password}"/>
           <a4j:commandButton value="Login" action="#{LoginBean.userlogin}"/>
           <a4j:commandButton value="Administrator" action="#{LoginBean.adminlogin}"/>
           
       </h:panelGrid>
       
       
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



      
