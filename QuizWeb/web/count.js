<form name="counter"><input type="text" size="8" 
name="d2"></form> 

<script> 
<!-- 
// 
 var milisec=0 
 var seconds=30 
 document.counter.d2.value='30' 

function display(){ 
 if (milisec<=0){ 
    milisec=9 
    seconds-=1 
 } 
 if (seconds<=-1){ 
    milisec=0 
    seconds+=1 
 } 
 else 
    milisec-=1 
    document.counter.d2.value=seconds+"."+milisec 
    setTimeout("display()",100) 
} 
display() 
--> 
</script> 

