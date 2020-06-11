<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Enteties.Book"%>
<%@page import="Enteties.Cart"%>
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
<title>Cart</title>
</head>
<body>
<%@ include file="Header.jsp"  %>
<%
	//HttpSession ses = request.getSession();
int id_user =(int)ses.getAttribute("iduser");
Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/CartService");
List<Cart> cs = target.path("/getCartByUser/"+ id_user).request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Cart>>(){});
 double total=0;
%>
   <% if(username==null) { 
	   response.sendRedirect("Register.jsp");
	   
   %>
   <%}else{ %>
<div class="banner"></div>
<div class="container">
    <table id="cart" class="table table-hover table-condensed">
        <thead>
            <tr>
                <th style="width:50%">Product</th>
                <th style="width:10%">Price</th>
                <th style="width:8%">Quantity</th>
                <th style="width:22%" class="text-center">Subtotal</th>
                <th style="width:10%"></th>
            </tr>
        </thead>
         <% int i=0;
        while(i<cs.size()){
        	total=total+cs.get(i).getPrice_book();
        	%>
        <tbody>
             <tr>
                    <td data-th="Product">
                        <div class="row">
                            <div class="col-sm-2 hidden-xs"><img src="images/<%=cs.get(i).getImage_book() %>" alt="..." class="img-responsive" /></div>
                            <div class="col-sm-10">
                                <h4 class="nomargin"><%=cs.get(i).getName_book() %></h4>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price"><%=cs.get(i).getPrice_book() %></td>
                    <td data-th="Quantity">
                        <input type="number" name="Qty" class="form-control text-center" value="1">
                    </td>
                    <td data-th="Subtotal" class="text-center"><%=cs.get(i).getPrice_book() %></td>
                    <td class="actions" data-th="">
                        <a href="RefreshCart?id_cart=<%=cs.get(i).getId_Cart()%>" class="btn btn-info btn-sm" ><i class="fa fa-refresh"></i></a>
                        <a href="DeleteBookCart?id_cart=<%=cs.get(i).getId_Cart()%>" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a>
                    </td>
                </tr>
        </tbody>
         <%i++;} %>
        <tfoot>
            <tr class="visible-xs">
                <td class="text-center"><strong>Total 1.99</strong></td>
            </tr>
            <tr>
                <td><a href="BookShop.jsp" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                <td colspan="2" class="hidden-xs"></td>
                <td class="hidden-xs text-center"><strong>Total  <%=total %> DH</strong></td>
                <td><a href="PayBook.jsp" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
            </tr>
        </tfoot>
    </table>
</div>
<% } %>
<%@ include file="Footer.jsp"  %>

</body>
</html>