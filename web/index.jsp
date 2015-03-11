<%-- 
    Document   : prompt
    Created on : 2014-10-15, 22:50:17
    Author     : zhengkaiming
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype") %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indexed Cartoon Finder</title>
    </head>
    <body>
         <p>Choose a category to find an Indexed cartoon on that topic:</p>
        <form action="IndexedCartoonServlet" method="GET">
            <select name="function" value="">
                <option value="5x7">5x7</option>
                <option value="arrogance">arrogance</option>
                <option value="booze">booze</option>
                <option value="brands">brands</option>
                <option value="communication">communication</option>
            </select>
            
            <input type="submit" value="Click Here"/>
            <br/>
            <p><a href ="http://thisisindexed.com./">Indexed</a> is copyrighted by Jessica Hagy.</p>
        </form>
        
    </body>
</html>
