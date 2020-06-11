<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.SQLException"%>
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
<title>Add New Book</title>
</head>
<body>
<%@ include file="HeaderAdmin.jsp"  %>
<% 
Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/Categories/getAllCategory");
List<Category> cs = target.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Category>>(){});
%>
<div class="banner"></div>
<section class="contact" >
    <div class="container">
        <h3 class="title-txt"><span>A</span>dd Book</h3>
        <div class="contact-grids" style="width:1720px; height:797px; margin-left:210px;">
            <div class=" col-md-5 contact-form">
                <h4 class="heading">New Book</h4>
                <form action="AddBook" method="post">
                    <input type="file" placeholder="Image" name="image"/>
                    <input type="text" placeholder="Book Name" name="name"/>
                    <input type="text" placeholder="Book Writer" name="writer" />
                    <select name="category" style="margin: .5em 0;  padding: .7em 1em;font-size: .9em; width: 100%; background: transparent; border: 1px solid #fff; color: #fff;  letter-spacing: 2px;">
                       <%int i=0; 
                         while(i< cs.size()){ %>
                        	 <option value="<%=cs.get(i).getId_Catygory()%>"><%=cs.get(i).getName_Category() %></option>
                        	 <% i++;} %>
                   </select>
                    <input type="text" placeholder="Book Price" name="price" />
                    <input type="text" placeholder="Book Stock" name="stock" />
                    <input type="date" placeholder="Book Date" name="date" />
                    <textarea placeholder="Summary" name="summary"></textarea>
                    <div class="submit1">
                        <input type="submit" value="Add Book">
                    </div>
                </form>
            </div>
          </div>
      </div>
 </section>
<%@ include file="Footer.jsp"  %>
</body>
</html>