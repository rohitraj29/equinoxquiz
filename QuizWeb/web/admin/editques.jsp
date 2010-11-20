<%-- 
    Document   : editques
    Created on : Apr 5, 2009, 8:55:42 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

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
                            
                            <rich:panel id="userpanel" header="Questions List">
                                
                                <h:panelGrid columns="3">
                                    
                                    <h:outputText value="Select The Test from the DropDown List"></h:outputText>
                                    <rich:comboBox value="#{ListQuesBean.testid}" valueChangeListener="#{ListQuesBean.valueChanged}" ><f:selectItems value="#{ListQuesBean.testlist}"/></rich:comboBox>
                                    <a4j:commandButton action="#{ListQuesBean.selectAction}" value="Get Questions" reRender="userpanel"/>
                                </h:panelGrid>
                                <h:messages errorStyle="color:red" infoStyle="color :green" layout="table"/>
                                <rich:dataTable value="#{ListQuesBean.queslist}" var="row" width="100%">
                                    <rich:column title="User Id"><f:facet name="header"><h:outputText value="Question Id"/></f:facet>
                                        
                                        <h:outputText value="#{row.qid}"/>
                                    </rich:column>
                                    <rich:column title="User Name"><f:facet name="header"><h:outputText value="Question"/></f:facet>
                                        <h:outputText value="#{row.question}"/>
                                    </rich:column>
                                    <rich:column title="Role Played"><f:facet name="header"><h:outputText value="Option 1"/></f:facet>
                                        <h:outputText value="#{row.option1}"/>
                                    </rich:column>
                                    <rich:column title="Role Played"><f:facet name="header"><h:outputText value="Option 2"/></f:facet>
                                        <h:outputText value="#{row.option2}"/>
                                    </rich:column>
                                    <rich:column title="Role Played"><f:facet name="header"><h:outputText value="Option 3"/></f:facet>
                                        <h:outputText value="#{row.option3}"/>
                                    </rich:column>
                                    <rich:column title="Role Played"><f:facet name="header"><h:outputText value="Option 4"/></f:facet>
                                        <h:outputText value="#{row.option4}"/>
                                    </rich:column>
                                    <rich:column title="Role Played"><f:facet name="header"><h:outputText value="Correct Option"/></f:facet>
                                        <h:outputText value="#{row.optionCorrect}"/>
                                    </rich:column>
                                    <rich:column title="delete">
                                        <a4j:commandButton id="edit" actionListener="#{EditQuestionBean.actionPerformed}"  value="Edit" reRender="userpanel,editpanel" ajaxSingle="true"  data="#{row.qid}" ></a4j:commandButton>
                                        
                                    </rich:column>
                                </rich:dataTable>
                                
                            </rich:panel>
                            
                       
                            
                                
                                
                                <rich:panel header="Edit Question" id="editpanel">
                                    <h:panelGrid columns="2">
                                        <h:outputText value="Question Description"/>
                                        <h:inputTextarea value="#{EditQuestionBean.questiondetail}" rows="5"cols="40"></h:inputTextarea>
                                        <h:outputText value="Option 1"/>
                                        <h:inputText value="#{EditQuestionBean.option1}"><a4j:support  ajaxSingle="true" event="onblur"/></h:inputText>
                                        <h:outputText value="Option 2"/>
                                        <h:inputText value="#{EditQuestionBean.option2}"><a4j:support   ajaxSingle="true" event="onblur"/></h:inputText>
                                        <h:outputText value="Option 3"/>
                                        <h:inputText value="#{EditQuestionBean.option3}"><a4j:support ajaxSingle="true" event="onblur"/></h:inputText>
                                        <h:outputText value="Option 4"/>
                                        <h:inputText value="#{EditQuestionBean.option4}"><a4j:support ajaxSingle="true" event="onblur"/></h:inputText>
                                        <h:outputText value="Correct Option"/>
                                        <h:inputText value="#{EditQuestionBean.optionCorrect}"><a4j:support requestDelay="10" ajaxSingle="true" event="onblur"/></h:inputText>
                                        <a4j:commandButton id="save" value="Save Changes" action="#{EditQuestionBean.updateAction}" reRender="userpanel,editpanel"/>
                                        
                                    </h:panelGrid>
                                </rich:panel>
                            
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