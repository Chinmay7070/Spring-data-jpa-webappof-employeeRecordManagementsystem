<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style>
        /* General body styling */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            font-size: 24px;
            font-weight: 600;
            margin: 30px 0 10px 0;
        }

        a {
            text-decoration: none;
        }

        /* Table styling */
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto 40px auto;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.15);
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
        }

        th {
            background: #1976d2;
            color: #fff;
            padding: 12px;
            font-size: 16px;
            text-align: center;
        }

        td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #e0e0e0;
            font-size: 15px;
            color: #333;
        }

        tr:hover {
            background-color: #e3f2fd;
            transition: 0.3s;
        }

        /* BUTTON STYLING */
        .btn {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 6px;
            padding: 8px 14px;
            border-radius: 6px;
            font-size: 14px;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
            transition: transform .2s ease, box-shadow .2s ease, background .2s ease;
        }

        .btn img {
            width: 18px;
            height: 18px;
        }

        .btn-edit {
            background: #4caf50;
            color: white;
            border: 1px solid #388e3c;
        }
        .btn-edit:hover {
            background: #388e3c;
            transform: scale(1.05);
            box-shadow: 0 3px 10px rgba(0,0,0,0.3);
        }

        .btn-delete {
            background: #f44336;
            color: white;
            border: 1px solid #c62828;
        }
        .btn-delete:hover {
            background: #c62828;
            transform: scale(1.05);
            box-shadow: 0 3px 10px rgba(0,0,0,0.3);
        }

        .btn-add {
            background: #2196f3;
            color: white;
            border: 1px solid #1976d2;
        }
        .btn-add:hover {
            background: #1976d2;
            transform: scale(1.05);
            box-shadow: 0 3px 10px rgba(0,0,0,0.3);
        }

        /* Align buttons horizontally */
        .actions {
            display: flex;
            justify-content: center;
            gap: 12px;
        }

        /* Center add button outside table */
        .add-container {
            text-align: center;
            margin: 20px 0;
        }

        /* No records message */
        .no-records {
            color: #d32f2f;
            text-align: center;
            font-size: 20px;
            margin: 30px 0;
        }

        /* Home link styling */
        .home-link {
            display: inline-block;
            margin: 20px 0 40px 0;
            padding: 8px 16px;
            background: #1976d2;
            color: #fff;
            border-radius: 6px;
            transition: 0.3s;
        }
        .home-link:hover {
            background: #1565c0;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

<!-- ADD button at top -->
<div class="add-container">
    <a href="register" class="btn btn-add">
        <img src="images/add.jpg" alt="Add"> Add New
    </a>
</div>

<c:choose>
   <c:when test="${!empty resultinfo}">
       <table>
           <tr>
               <th>EMPNO</th>
               <th>EMPNAME</th>
               <th>JOB</th>
               <th>SALARY</th>
               <th>OPERATIONS</th>
           </tr>

           <!-- Existing Records -->
           <c:forEach var="emp" items="${resultinfo}">
               <tr>
                   <td>${emp.empno}</td>
                   <td>${emp.ename}</td>
                   <td>${emp.job}</td>
                   <td>${emp.sal}</td>
                   <td>
                       <div class="actions">
                           <a href="edit?no=${emp.empno}" class="btn btn-edit">
                               <img src="images/edit.png" alt="Edit"> Edit
                           </a>
                           <a href="delete?no=${emp.empno}" class="btn btn-delete">
                               <img src="images/delete.png" alt="Delete"> Delete
                           </a>
                       </div>
                   </td>
               </tr>
           </c:forEach>
       </table>
   </c:when>
   <c:otherwise>
       <div class="no-records">Records are not found......</div>
   </c:otherwise>
</c:choose>

<center>
    <a href="./" class="home-link">HOME</a>
</center>

</body>
</html>
