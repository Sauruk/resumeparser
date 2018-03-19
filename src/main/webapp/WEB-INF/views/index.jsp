<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rparser.hibernate.entities.Resume" %>
<html>
<head>
    <title>Resumeparser</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"/>
    <SCRIPT LANGUAGE="JavaScript">
    </SCRIPT>
    <script>

        var self = this;
        self.acceptor = new Object();
        function forceUpdate()
        {
            $.get('forceUpdate', function (result) {
                location.reload();
            });
        }

        function doFilter() {
            $.post( "filter", self.acceptor)
                .success(function( resumeList ) {
                    $("#rTable").find("tr[id]").remove();
                    var tbody = $("#rTable").find('tbody');
                    if (resumeList) {
                        console.log(resumeList);
                        resumeList.forEach(function (value, index) {

                            tbody.append("<tr id = " + value.id  +">" +
                                "<td>" + value.jobInterestIn + "</td>" +
                                "<td>" + value.fullname + "</td>" +
                                "<td>" + value.age + "</td>" +
                                "<td>" + value.salaryReq + "</td>" +
                                "<td>" + value.experience + "</td>" +
                                "<td>" + value.education + "</td>" +
                                "<td>" + value.publishDate + "</td>" +
                                "</tr>");
                        });
                    }
                });
        }

    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Date synchronization:

    <c:out value="${empty lastSyncDate ? 'Not avalible' : lastSyncDate}" />
    <%--<button id="forceUpdate" style="margin-left: 30px;" onclick='forceUpdate()'>Force update</button>--%>
    <button id="doFilter" style="margin-left: 30px;" onclick='doFilter()'>Filter</button>

    <table id="rTable" width="100%" border="1px" style="margin-top: 10px">
        <tbody>
        <tr>
            <th>Job title</th>
            <th>Full name</th>
            <th>Age</th>
            <th>Salary request(Rub)</th>
            <th>Experience</th>
            <th>Education</th>
            <th>Publish date</th>
        </tr>
        <tr>
            <td><input style="margin-top:3px; margin-bottom: 3px; width: 100%;" type="text" onchange="self.acceptor.jobInterestIn = this.value">></td>
            <td><input style="margin-top:3px; margin-bottom: 3px; width: 100%;" type="text" onchange="self.acceptor.fullname = this.value">></td>
            <td><input style="margin-top:3px; margin-bottom: 3px; width: 100%;" type="text" onchange="self.acceptor.age = this.value">></td>
            <td><input style="margin-top:3px; margin-bottom: 3px; width: 100%;" type="text" onchange="self.acceptor.salaryReq = this.value">></td>
            <td><input style="margin-top:3px; margin-bottom: 3px; width: 100%;" type="text" onchange="self.acceptor.experience = this.value">></td>
            <td><input style="margin-top:3px; margin-bottom: 3px; width: 100%;" type="text" onchange="self.acceptor.education = this.value">></td>
            <td>not implemented</td>
        </tr>
        <% ArrayList<Resume> resumeList = (ArrayList)request.getAttribute("resumeList");
            for (Resume resume : resumeList) {
        %> <tr id=" <% out.print(resume.getId()); %> ">
            <td><% out.print(resume.getJobInterestIn()); %></td>
            <td><% out.print(resume.getFullname()); %></td>
            <td><% out.print(resume.getAge()); %></td>
            <td><% out.print(resume.getSalaryReq()); %></td>
            <td><% out.print(resume.getExperience()); %></td>
            <td><% out.print(resume.getEducation()); %></td>
            <td><% out.print(resume.getPublishDate()); %></td>
            </tr>
         <%  }  %>
        </tbody>
    </table>
</body>