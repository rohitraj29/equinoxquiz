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
        <script type="text/javascript" src="count.js">
        </script> 
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
            <br/><br/>
            <!-- end header -->
            <div>
                <h:form>
                   
                        <rich:toolBar itemSeparator="disc">
                    <rich:dropDownMenu value="Users Menu" >
                        
                            <rich:menuItem value="Add Users" action="adduser"/>
                            <rich:menuItem value="Generate users" action="genuser"/>
                            <rich:menuItem value="Delete Users" action="deluser"/>
                        
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
                    <!-- start latest-post -->
                    <div id="latest-posts">
                        <h:form>
                            <h:messages errorStyle="color :red" infoStyle="color :green" layout="table"/>
                            <h:panelGrid width="500" columns="2">
                                <h:outputText value="Test Title"/>
                                <h:inputText value="#{TestCreateBean.tdetail}">
                                    <a4j:support ajaxSingle="true" immediate="true" event="onblur"/>
                                </h:inputText>
                                <h:outputText value="TestDuration"/>
                                <h:inputText value="#{TestCreateBean.tduration}">
                                    <a4j:support ajaxSingle="true" immediate="true" event="onblur"/>
                                    </h:inputText>
                                <h:outputText value="No. of Questions"/>
                                <h:inputText value="#{TestCreateBean.noques}">
                                    <a4j:support ajaxSingle="true" immediate="true" event="onblur"/>
                                    </h:inputText>
                                <h:outputText value="On Correct"/>
                                <h:inputText value="#{TestCreateBean.oncorrect}">
                                    <a4j:support ajaxSingle="true" immediate="true" event="onblur"/>
                                    </h:inputText>
                                <h:outputText value="On Wrong"/>
                                <h:inputText value="#{TestCreateBean.onwrong}">
                                    <a4j:support ajaxSingle="true" immediate="true" event="onblur"/>
                                    </h:inputText>
                                <h:commandButton value="Persist" action="#{TestCreateBean.persist}"/>
                            </h:panelGrid>
                        </h:form>
                    </div>
                <!-- start recent-posts -->
                    <div id="recent-posts">
                        
                    </div>
              
                    
                <!-- end recent-posts -->
            </div>
            <!-- end content -->
            <!-- start sidebar -->
            
                    
                
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



       
