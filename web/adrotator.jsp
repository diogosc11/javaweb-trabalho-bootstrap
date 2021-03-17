<%@page import="controle.Rotator"%>

<jsp:useBean id = "rotator" scope = "session" class = "controle.Rotator" />

      <% rotator.nextAd(); %>
  
      <p> 
         <a href = "<jsp:getProperty name = "rotator" 
            property = "link" />" target="_blank">

            <img src = "<jsp:getProperty name = "rotator"
               property = "image" />" alt = "advertisement" />
         </a>
      </p>


