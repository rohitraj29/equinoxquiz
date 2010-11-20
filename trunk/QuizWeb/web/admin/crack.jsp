<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




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
                    
                    <h1><span id="clock">&nbsp;</span></h1>  
                    <br/>
                    
                </div>
                
            </div>
            <!-- end header -->
            <br/><br/>
            <!-- end header -->
            <div>
                <h:form>
                   
                        <rich:toolBar itemSeparator="disc">
                    <rich:dropDownMenu value="Users Menu" >
                        
                            <rich:menuItem value="Add Users" action="addusers"/>
                            <rich:menuItem value="Generate users" action="genusers"/>
                            <rich:menuItem value="Delete Users" action="delusers"/>
                        
                    </rich:dropDownMenu>
                    <rich:dropDownMenu value="Questions Menu">
                        <rich:menuItem value="Add Questions" action="addques"/>
                        <rich:menuItem value="Edit Questions" action="editques"/>
                        <rich:menuItem value="Delete Questions" action="delques"/>
                        <rich:menuItem value="View Questions" action="viewques"/>
                    </rich:dropDownMenu>
                    <rich:dropDownMenu value="Tests Menu">
                        <rich:menuItem value="Add Tests" action="addtest"/>
                        <rich:menuItem value="View Tests" action="viewtest"/>
                        
                        <rich:menuItem value="Delete Test"action="deltest"/>
                        <rich:menuItem value="Edit Tests" action="edittest"/>
                        
                    </rich:dropDownMenu>
                    <rich:dropDownMenu value="Results Menu">
                        <rich:menuItem value="View Results" action="viewres"/>
                    </rich:dropDownMenu>
                    <rich:dropDownMenu value="Admin Home" >
                        <rich:menuItem value="Go to Home" action="adminhome"/>
                        <rich:menuItem value="Logout" action="logout"/>
                    </rich:dropDownMenu>
                    
                </rich:toolBar>
                    
                
                </h:form>
            </div>
            <div id="headerbg"><p class="text1">&#8220;In Search of Excellence in realms <br />
                of the World&#8221;</p>
            </div>
            <!-- start page -->
            <div id="page">
                <!-- start content -->
                <div id="content">
                    <a4j:outputPanel id="pm">
                        <rich:panel header="CRACKOSHACK PANEL" id="container">
                            <h:form>
                                <h:panelGrid columns="4" width="100%">
                                    <rich:comboBox value="#{CrackBean.userid}" valueChangeListener="#{CrackBean.userChanged}" immediate="true">
                                        <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
                                        <f:selectItems value="#{CrackBean.userlist}"/>
                                    </rich:comboBox>
                                    <a4j:commandButton reRender="pm" value="GET VALUES" action="#{CrackBean.updateAction}" immediate="true"/>
                                    <a4j:commandButton reRender="pm" value="SPOOF" action="#{CrackBean.spoofAction}" immediate="true"/>
                                    <a4j:commandButton reRender="pm" value="PARTY" action="#{CrackBean.PartyAction}" immediate="true"/>
                                </h:panelGrid>
                            </h:form>
                            <br/><br/>
                            <rich:dataTable width="100%" id="data1" value="#{CrackBean.hitlist}" var="row" >
                                <rich:column><f:facet name="header"><h:outputText value="Hit ID"/></f:facet><h:outputText value="#{row.hitid}"/></rich:column>
                                <rich:column><f:facet name="header"><h:outputText value="Quest ID"/></f:facet><h:outputText value="#{row.questid}"/></rich:column>
                                <rich:column><f:facet name="header"><h:outputText value="Test ID"/></f:facet><h:outputText value="#{row.testid}"/></rich:column>
                                <rich:column><f:facet name="header"><h:outputText value="Score"/></f:facet><h:outputText value="#{row.score}"/></rich:column>
                            </rich:dataTable>
                            
                            
                            
                            
                            
                        </rich:panel>
                    </a4j:outputPanel>
                    <!-- end latest-post -->
                    <!-- start recent-posts -->
                 
                <!-- end recent-posts -->
           
            <!-- end content -->
            <!-- start sidebar -->
            
                    
                </div>
                <div id="sidebar">
                    
                    
                    <br/>
                    <br/>
                    
                    
                </div>
                
                <!-- end sidebar -->
            </div>
            <!-- end page -->
            <div id="footer">
            </div>  
            
        </f:view>
    </body>
    
</html>



       
