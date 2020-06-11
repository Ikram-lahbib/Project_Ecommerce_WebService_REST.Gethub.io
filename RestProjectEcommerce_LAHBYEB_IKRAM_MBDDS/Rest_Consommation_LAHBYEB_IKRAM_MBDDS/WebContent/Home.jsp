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
<title>Home</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head> 
<body>
<%@ include file="Header.jsp"  %>
<div class="slider" style="margin-top: 140px;">
    <div class="callbacks_container">
        <ul class="rslides" id="slider3">
            <li>
                <div class="slider-img1">
                    <div class="container">
                        <div class="slider_banner_info_w3ls">
                            <h4> Book & You  <span>Learn</span></h4>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <div class="slider-img2">
                    <div class="container">
                        <div class="slider_banner_info_w3ls">
                            <h4>Book & You   <span>Learn</span></h4>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <div class="slider-img3">
                    <div class="container">
                        <div class="slider_banner_info_w3ls">
                            <h4>Book & You  <span>Learn</span></h4>
                        </div>
                    </div>
                </div>
            </li>

        </ul>
    </div>
</div>
<div class="clearfix"> </div>
<!--Category-->
<% 
Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/Categories/getAllCategory");
List<Category> cs = target.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Category>>(){});
%>
<div class="w3-agile-services" style="margin-top:70px;">
    <div class="container">
        <h3 class="title-txt"><span>C</span>ategory</h3>
        <div class="agileits-services">
            <div class="services-right-grids">
            <%
            	int i =0;
                          while( i<cs.size()){
            %>
                <div class="col-sm-4 services-right-grid thumbnail team-w3agile">
                    <div class="se-top" style="height:340px; width:350px">
                        <div class="services-icon">
                            <img src="images/<%=cs.get(i).getImage_Category()%>" style="width:100px;height:100px;">
                        </div>
                        <div class="services-icon-info">
                            <h5><a href="Science.html"><%=cs.get(i).getName_Category()%></a></h5>
                            <p><%=cs.get(i).getDescription_Category()%></p>
                        </div>
                    </div>
                    <div class="team-info" style="width:350px">
                            <div class="w3ls-social-icons">
                                <a class="facebook" href="FilterBookCategory.jsp?id_category=<%=cs.get(i).getId_Catygory()%>"><span class="fa fa-eye"></span></a>
                            </div>
                    </div>
                    </div>
                </div>
                <%
                	i++;}
                %>
                
                <div class="clearfix"> </div>
            </div>

        </div>
    </div>
</div>
<!-- /category -->
<!--Month'sbook-->
<%
Book b=new Book();
String format = "MM";
java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
java.util.Date date = new java.util.Date();
String dt=formater.format( date );
Client client1 = ClientBuilder.newClient();
WebTarget target1 = client.target("http://localhost:8081/RestProjectEcommerce/rest/BookService");
List<Book> bs = target1.path("/getBookByDate/"+dt).request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Book>>(){});
%>
<script type="text/javascript" >
$(document).ready (function(){
	$('.multiple-items').slick({
		infinite: true,
		  slidesToShow:3,
		  slidesToScroll:3
	});
});
</script>
<div class="events-section">
    <div class="team">
        <div class="container">
            <h3 class="title-txt two"><span>B</span>ook Month's</h3>
            <div class="multiple-items">
            <div class="row team-row">
            <% for(int j=0;j<bs.size();j++){ %>
                <div class="col-md-3 col-sm-6 thumbnail team-w3agile">
                    <img src="images/<%=bs.get(j).getBook_Image()%>" class="img-responsive" alt="" style="width:350px;height:370px;">
                    <div class="team-info">
                        <div class="caption">
                            <h4><%=bs.get(j).getBook_Name() %></h4>
                            <p><%=bs.get(j).getBook_Price()%> $</p>
                        </div>
                        <div class="w3ls-social-icons">
                            <a class="facebook" href="ShowBook.jsp?id_book=<%=bs.get(j).getBook_id()%>"><span class="fa fa-eye"></span></a>
                        </div>
                    </div>
                </div>
                <%} %>
                
                <div class="clearfix"> </div>
            </div>
            </div>
        </div>


    </div>
</div>
<!-- //bestbook -->
<!-- Testimonials -->
<div class="testimonials">
    <div class="container">
        <h3 class="title-txt"><span>B</span>est Book</h3>
        <div class="col-md-6 testimonials-main" style="width:960px;padding-left:100px;">
            <section class="slider">
                <div class="flexslider">
                    <ul class="slides">
                        <li>
                            <div class="inner-testimonials-w3ls">
                                
                                    <a asp-action="ShowBook" asp-route-id="1"><img src="images/cd.jpg" alt=" " class="img-responsive" /></a>
                                    <div class="testimonial-info-wthree">
                                        <h5>Power of Hapits</h5>
                                        <span>writher name</span>
                                        <p class="para-w3ls">
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis hendrerit lobortis elementum, Quis nostrum exercitationem
                                            ullam corporis suscipit laboriosam.
                                        </p>
                                    </div>
                            </div>
                        </li>
                        <li>
                            <div class="inner-testimonials-w3ls">

                                <a asp-action="ShowBook" asp-route-id="1"><img src="images/cd.jpg" alt=" " class="img-responsive" /></a>
                                <div class="testimonial-info-wthree">
                                    <h5>Candid</h5>
                                    <span>Voltaire</span>
                                    <p class="para-w3ls">
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis hendrerit lobortis elementum, Quis nostrum exercitationem
                                        ullam corporis suscipit laboriosam.
                                    </p>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="inner-testimonials-w3ls">

                                <a asp-action="ShowBook" asp-route-id="1"><<img src="images/bm.jpg" alt=" " class="img-responsive" /></a>
                                <div class="testimonial-info-wthree">
                                    <h5>Boite à Mervaille</h5>
                                    <span>Ahmed Sefrioui</span>
                                    <p class="para-w3ls">
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis hendrerit lobortis elementum, Quis nostrum exercitationem
                                        ullam corporis suscipit laboriosam.
                                    </p>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //Testimonials -->
<!--about-->
<div class="about">
    <div class="container">
        <div class="about-main">
            <div class="about-right">
                <h3 class="subheading-w3-agile">About Us</h3>
                <p class="para-w3-agileits">
                    Books play a significant role in our life.They say that When you open a book, you open a new world,I believe that everyone would agree with this statement as books have become inevitable to mankind.
                    For the majority of people, books are part of their everyday life,
                    A book is like a best friend who will never walk away from you.So our Web Site BookTime Offer for you a lot of the Book in different Category.
                </p>
                <!-- stats -->
                <div class="stats">
                    <div class="stats_inner">
                        <div class="col-md-6 col-sm-6 col-xs-6 stat-grids">
                            <p class="counter-agileits-w3layouts">100</p>
                            <div class="stats-text-wthree">
                                <h3>BOOK</h3>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6 stat-grids">
                            <p class="counter-agileits-w3layouts">6</p>
                            <div class="stats-text-wthree">
                                <h3>CATYGORY</h3>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6 stat-grids">
                            <p class="counter-agileits-w3layouts">100</p>
                            <div class="stats-text-wthree">
                                <h3> PRICE</h3>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6 stat-grids">
                            <p class="counter-agileits-w3layouts">45</p>
                            <div class="stats-text-wthree">
                                <h3>SRVICES</h3>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <!-- //stats -->

            </div>
        </div>

    </div>
</div>
<!--//about-->

<%@ include file="Footer.jsp"  %>
</body>
</html>