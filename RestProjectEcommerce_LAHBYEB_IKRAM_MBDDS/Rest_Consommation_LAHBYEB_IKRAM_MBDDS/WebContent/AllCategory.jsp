<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Enteties.Category"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@page import="java.util.List"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.WebTarget" %>
<%@page import="javax.ws.rs.core.MediaType" %>
<%@page import="javax.ws.rs.core.Response" %>
<%@page import="javax.ws.rs.core.GenericType" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllCategory</title>
</head>
<body>
<%@ include file="HeaderAdmin.jsp"%>
<% 
Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/Categories/getAllCategory");
List<Category> cs = target.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Category>>(){});
%>


<!--service-->
<div class="w3-agile-services" style="margin-top:70px;">
    <div class="container">
        <h3 class="title-txt"><span>C</span>ategory</h3>
        <div class="agileits-services">
            <div class="services-right-grids">
           <% for(int i=0;i<cs.size();i++) {%>
                <div class="col-sm-4 services-right-grid thumbnail team-w3agile">
                    <div class="se-top" style="height:340px; width:350px">
                        <div class="services-icon">
                            <img src="images/<%=cs.get(i).getImage_Category() %>" style="width:100px;height:100px;">
                        </div>
                        <div class="services-icon-info">
                            <h5><a href="Science.html"><%=cs.get(i).getName_Category() %></a></h5>
                            <p><%=cs.get(i).getDescription_Category() %></p>
                        </div>
                    </div>
                    <div class="team-info" style="width:350px">
                            <div class="w3ls-social-icons">
                                <a class="facebook" href="DeleteCategory?id_category=<%=cs.get(i).getId_Catygory()%>"><span class="fa fa-trash"></span></a>
                            </div>
                    </div>
                    </div>
                </div>
               <%} %>
                
                <div class="clearfix"> </div>
            </div>

        </div>
    </div>
</div>
<!-- //services -->
<%@ include file="Footer.jsp"  %>
</body>
</html>