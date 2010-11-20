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
    <f:view>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Anachronox</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">


function updateClock ( )
{
  var currentTime = new Date ( );

  var currentHours = currentTime.getHours ( );
  var currentMinutes = currentTime.getMinutes ( );
  var currentSeconds = currentTime.getSeconds ( );

  // Pad the minutes and seconds with leading zeros, if required
  currentMinutes = ( currentMinutes < 10 ? "0" : "" ) + currentMinutes;
  currentSeconds = ( currentSeconds < 10 ? "0" : "" ) + currentSeconds;

  // Choose either "AM" or "PM" as appropriate
  var timeOfDay = ( currentHours < 12 ) ? "AM" : "PM";

  // Convert the hours component to 12-hour format if needed
  currentHours = ( currentHours > 12 ) ? currentHours - 12 : currentHours;

  // Convert an hours component of "0" to "12"
  currentHours = ( currentHours == 0 ) ? 12 : currentHours;

  // Compose the string for display
  var currentTimeString = currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay;

  // Update the time display
  document.getElementById("clock").firstChild.nodeValue = currentTimeString;
}


</script>
      
    </head>
    <body onload="updateClock(); setInterval(updateClock(),1000);">
        
            <!-- start header -->
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Anachronox</a></h1>
                    <p>&nbsp;&nbsp;by&nbsp; Equinox</p>
                </div>
                <div id="menu">
                    
                  <h1><span id="clock">&nbsp;</span></h1>  
                  <br/>
                  <h2>Welcome User&nbsp;<h:outputText value="#{LoginBean.username}"/></h2>
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
                    
                   <h:form>
                     <a4j:poll enabled="true" immediate="true" interval="#{TestBean.durationmili}" action="#{TestBean.finishAction}" />
                     </h:form>
                     
                     <a4j:form>
                    <rich:panel id="quizpanel"header="QUIZ" style="background-color:#{TestBean.currentvar.background}">
                                   <h:panelGrid columns="2">
                                   <h:outputText value="Question no.#{TestBean.currentvar.qnumber}"/>
                                   <h:outputText value="#{TestBean.currentvar.questio.question}"/>
                                   <h:outputText value="Option 1"/>
                                   <h:outputText value="#{TestBean.currentvar.questio.option1}"/>
                                   <h:outputText value="Option 2"/>
                                   <h:outputText value="#{TestBean.currentvar.questio.option2}"/>
                                   <h:outputText value="Option 3"/>
                                   <h:outputText value="#{TestBean.currentvar.questio.option3}"/>
                                   <h:outputText value="Option 4"/>
                                   <h:outputText value="#{TestBean.currentvar.questio.option4}"/>
                                   <h:selectOneMenu  value="#{TestBean.response}" valueChangeListener="#{TestBean.valueChanged}">
                                       <f:selectItems value="#{TestBean.optionlist}"/>
                                   </h:selectOneMenu>
                                   </h:panelGrid>
                      
                      </rich:panel>
                      
                      
                         
                 
                      
                          <rich:panel>
                          <h:panelGrid columns="3" width="800">
                          <a4j:commandButton action="#{TestBean.prevaction}" reRender="quizpanel" type="image" image="/images/prev.gif"/>
                          <a4j:commandButton action="#{TestBean.nextaction}" reRender="quizpanel" type="image" image="/images/next.gif"/>
                          <a4j:commandButton action="#{TestBean.submitaction}" reRender="quizpanel" type="image" image="/images/submit.gif" />
                          </h:panelGrid>
                          </rich:panel>
                          </a4j:form>
                    <!-- end latest-post -->
                <!-- start recent-posts -->
                 
                <!-- end recent-posts -->
           
            <!-- end content -->
            <!-- start sidebar -->
            
                    
                </div>
                <div id="sidebar">
                    <h:form>
                        <a4j:commandLink action="#{TestBean.finishAction}" value="END QUIZ"/>
                        
                       
                       <rich:panel id ="timer">
                           <rich:progressBar id="timerbar" mode="ajax" actionListener="#{TestBean.increment}" progressVar="#{TestBean.remaining}" reRender="timer" interval="1000"/>
                   </rich:panel>
                </h:form>
                </div>
                
                <!-- end sidebar -->
            </div>
            <!-- end page -->
            <div id="footer">
            </div>  
            
       
    </body>
     </f:view>
</html>



       
