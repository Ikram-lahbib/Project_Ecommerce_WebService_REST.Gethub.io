<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Enteties.Category"%>
<%@page import="Enteties.Book"%>
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
<title>BookShop</title>
</head>
<body>
<%@ include file="Header.jsp"  %>
<% 
Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/BookService/getAllBook");
WebTarget target2 = client.target("http://localhost:8081/RestProjectEcommerce/rest/Categories/getAllCategory");
List<Category> cs = target2.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Category>>(){});
List<Book> bs = target.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Book>>(){});
%>
<% 
%>
<div class="banner"></div>
<!-- product right -->
<!-- gallery -->
<div class="gallery">
    <div class="container">
        <h3 class="title-txt"><span>O</span>ur BookShop</h3>
        <div class="container" style="width:200px;height:160px;position:absolute;">
            <h2 style="text-align:left;color:#040a2e;font-size:30px;">Filter By</h2><br />
            <ul class="list-group" style="width:250px; font-size:20px;">
                <li class="list-group-item active" style="font-size:25px;background-color:yellowgreen;border-color:yellowgreen;">Category</li>
                <li class="list-group-item" style="font-size:20px;color:#0b102b;"><a href="BookShop.jsp">All</a></li>
                <%for(int j=0;j<cs.size();j++){ %>
                <li class="list-group-item" style="font-size:20px;color:#0b102b;"><a href="FilterBookCategory.jsp?id_category=<%=cs.get(j).getId_Catygory()%>"><%=cs.get(j).getName_Category()  %></a></li>
                <%} %>
                <!--<li class="list-group-item" style="font-size:20px;color:#0b102b;"><a href="All.jsp">Science</a></li>
                <li class="list-group-item" style="font-size:20px;color:#0b102b;"><a href="All.jsp">Phylosofie</a></li>-->
            </ul>
            <ul class="list-group" style="width:250px; font-size:25px;">
                <li class="list-group-item active" style="font-size:20px;background-color:yellowgreen;border-color:yellowgreen;">Price</li>
                <li class="list-group-item" style="font-size:20px;color:#0b102b;"><a href="All.jsp">Price UP</a></li>
                <li class="list-group-item" style="font-size:20px;color:#0b102b;"><a href="All.jsp">Price Down</a></li>
            </ul>
        </div>

        <div class="container" style="margin-left:350px;width:1000px;">
            <% int i = 0; 
            while (i<bs.size()){%>
                <div class="gallery_gds">
                    <div class="col-md-3 col-sm-6 thumbnail team-w3agile" style="margin-right: 10px;margin-bottom:10px;">
                        <img src="images/<%=bs.get(i).getBook_Image()%>" class="img-responsive" style="width:400px;height:300px;">
                        <div class="team-info">
                            <div class="caption">
                                <h4><%=bs.get(i).getBook_Name() %></h4>
                                <p><%=bs.get(i).getBook_Price() %>$</p>
                            </div>
                            <div class="w3ls-social-icons">
                                <a class="facebook" href="ShowBook.jsp?id_book=<%=bs.get(i).getBook_id()%>" ><span class="fa fa-eye"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <%i++;}%>
            <div class="clearfix"> </div>



        </div>
    </div>
</div>






<%@ include file="Footer.jsp"  %>
</body>
</html>