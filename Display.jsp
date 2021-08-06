<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>  
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>
</head>
<body>

      
      
      
      
      <c:set var="str" value="younes ready to code"></c:set>
      
      
        Length : ${fn:length(str)}  
      
      
      
      
  <!--   <sql:setDataSource  var="db" driver="com.mysql.jdbc.Driver"  
          url="jdbc:mysql://localhost/university"  
          user="root"  password="Qweasdzxc123"/>
     
     <sql:query dataSource="${db}" var="rs">  
        SELECT * from Students;  
     </sql:query> 

     <table border="2" width="100%">  
          <tr>  
             <th>Student ID</th>  
             <th>First Name</th>  
             <th>Last Name</th> 
          </tr>
     </table>
     
     <c:forEach var="table" items="${rs.rows}">  
         <tr>  
            <td><c:out value="${table.id}"/></td>  
            <td><c:out value="${table.firstname}"/></td>  
            <td><c:out value="${table.lastname}"/></td>
         </tr>  
      </c:forEach>  -->
</body>
</html>