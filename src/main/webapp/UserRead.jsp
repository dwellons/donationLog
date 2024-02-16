<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>

<!-- Sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- Header -->
            <c:import url="assets/index_files/header.jsp"/>

            <!-- Tab on Side -->
            <div class="info">
                Search Users
            </div>

            <!-- Donation Search Form -->
            <h2>Search for a User</h2>

            <form action="readUsers" method="get">

                <label for="searchType">What will you be searching by?</label>

                </br>

                <input type="radio" id="userName"
                       name="searchType" value="userName" required>
                <label for="userName">Username</label>

                <br>

                <input type="radio" id="firstName"
                       name="searchType" value="firstName" required>
                <label for="firstName">First Name</label>

                <br>
                <br>

                <label for="searchTerm">Enter the Username, or First Name: </label>

                <br>

                <input type="text" id="searchTerm" name="searchTerm" required>

                <br>

                <input type="submit" name="submit" value="Submit">

            </form>

            <br>
            <br>

            <form action="readUsers" method="get">

                <input type ="submit" name="submit" value="Show All Users">

            </form>

        </article>
    </div>
</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/calendar/calendar.js"></script>


</body>
</html>