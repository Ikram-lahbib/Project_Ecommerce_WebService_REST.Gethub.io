<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddCategory</title>
</head>
<body>
<%@ include file="HeaderAdmin.jsp"%>
<div class="banner"></div>
<section class="contact" >
    <div class="container">
        <h3 class="title-txt"><span>A</span>dd Category</h3>
        <div class="contact-grids" style="width:1720px; height:720px; margin-left:240px;">
            <div class=" col-md-5 contact-form">
                <h4 class="heading">New Category</h4>
                <form action="AddCategory" method="post">
                    <input type="file" placeholder="Image" name="image"/>
                    <input type="text" placeholder="Category Name" name="name"/>
                    <textarea placeholder="Description" name="description"></textarea>
                    <div class="submit1">
                        <input type="submit" value="Add Category">
                    </div>
                </form>
            </div>
      </div>
      </div>
 </section>
<%@ include file="Footer.jsp"  %>
</body>
</html>