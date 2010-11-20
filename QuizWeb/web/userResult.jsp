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
                       <h:form>
                        <h1 class="title"><h:outputText value="Welcome,#{ResultBean.loginbean1.username} Your Score Is #{ResultBean.score}"/></h1><br/><br/>
                        <rich:panel header="Result Details ">
                        <rich:dataTable value="#{ResultBean.result}" var="row2" >
                            <h:column>
                                <f:facet name="header"><h:outputText value="User"/></f:facet>
                                <h:outputText value="#{row2.uid.username}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header"><h:outputText value="Question"/></f:facet>
                                <h:outputText value="#{row2.questid.question}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header"><h:outputText value="Score"/></f:facet>
                                <h:outputText value="#{row2.score}"/>
                          </h:column>
                        </rich:dataTable>
                        
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



       
