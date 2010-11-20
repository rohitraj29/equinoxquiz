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
    <h1 class="title">Tests Currently Available for you</h1><br/><br/>
    <h:form>
        <rich:panel header="Selected Test Details"  id="details">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h:panelGrid id="current" columns="2">
                <h:outputText value="TestName"/>
                <h:outputText value="#{PrepareTestBean.test.testname}"/>
                <h:outputText value="Test Duration"/>
                <h:outputText value="#{PrepareTestBean.test.durationMin}"/>
                <h:outputText value="Number of Questions"/>
                <h:outputText value="#{PrepareTestBean.test.noOfQues}"/>
                <a4j:commandButton action="#{PrepareTestBean.checkTestExists}" value="Proceed To Test...." reRender="details"/>
            </h:panelGrid>
        </rich:panel>
        <rich:panel header="Rules For the test">
            

            <ul>
                <li>Select Treasure Hunt with Appropriate Test to start the Quiz.</li>
                <li>The duration of the test is 30 Minutes. After that the user will automatically logout.</li>
                <li>The test consists of 30 questions.</li>
                <li> The un-attempted question appears White.</li>
                <li>The question appears Green once you have submitted it.</li>
                <li>The answer to the submitted question can be changed any number of times.</li>
                <li>You can view the next or previous questions with the arrow keys provided.</li>
            </ul>
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
        <h:form>
            <rich:panel header="TestList">
                <rich:dataTable value="#{PrepareTestBean.testvector}" var="row">
                    <rich:column>
                        <f:facet name="header"><h:outputText value="Select From Following"/></f:facet>
                        <h:outputText value="#{row.testname}"/>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText value=""/></f:facet>
                        <a4j:commandButton value="Select" actionListener="#{PrepareTestBean.selectaction}" data="#{row.testid}"reRender="details"/>
                    </rich:column>
                </rich:dataTable>
            </rich:panel>
        </h:form>
        
        
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



       
