<div id="sidebar">

    <!-- Home Button  -->
    <!-- removing /donationlog_war makes links work on AWS -->
    <h1 id="logo"><a href="/DonationLog_war/DonationRead.jsp">homepage</a></h1>



    <!-- Search -->
    <section>
        <form action="https://www.google.com/search" method="GET" target="_blank">
            <input type="text" name="q" id="searchInput" placeholder="Google Search">
        </form>
    </section>

    <!-- Display Weather Information -->
    <section>
        <h2>Local Weather Information</h2>
        <li>Location: ${sessionScope.location}</li>
        <li>Temperature: ${sessionScope.temperature} F</li>
        <li>Condition: ${sessionScope.condition}</li>
    </section>
    <!--Calendar  -->
    <section class="box calendar" id="calendar-container">
        <!-- ID calendar-container will receive calendar script -->
    </section>

    <!-- Links -->
    <section class="box recent-posts">
        <header>
            <h2>I want to...</h2>
        </header>
        <ul>

            <!-- removing /donationlog_war makes links work on AWS -->

            <a href = "/DonationLog_war/DonationRead.jsp">Search for a Donation</a>
            <br>
            <a href = "/DonationLog_war/UserCreate.jsp">Add a new User</a>
            <br>
            <a href = "/DonationLog_war/ReadRecentDonations">Sign Out</a>
            <br>
            <a href = "mailto:dwellons@madisoncollege.edu?subject=Donation%20Log%20Issue%20Report&body=Please%20describe%20your%20issue%20above.">Report an Issue</a>
            <br>
            <a href = "http://localhost:8080/DonationLog_war/services/donations">RESTful Response (Plain Text)</a>
            <br>
            <a href = "http://localhost:8080/DonationLog_war/services/donationsJSON">RESTful Response (JSON)</a>

        </ul>
    </section>

    <!-- Scripts -->
    <c:import url="/assets/index_files/scripts.jsp"/>

    <!-- Copyright -->
    <ul id="copyright">
        <li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
    </ul>
</div>
