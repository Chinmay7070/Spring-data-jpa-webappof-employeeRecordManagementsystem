<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Employee Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .form-container {
            max-width: 500px;
            margin: 60px auto;
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            color: #1976d2;
            margin-bottom: 25px;
            font-weight: bold;
        }

        .form-label {
            font-weight: 600;
            color: #333;
        }

        .btn-custom {
            background-color: #1976d2;
            color: #fff;
            font-weight: 600;
            border-radius: 8px;
            transition: all 0.3s ease-in-out;
        }

        .btn-custom:hover {
            background-color: #0d47a1;
            transform: scale(1.05);
            box-shadow: 0px 4px 12px rgba(0,0,0,0.3);
        }
    </style>
</head>
<body>

<div class="form-container">
    <h1>Employee Edit</h1>

    <form:form modelAttribute="emp" >
    <div class="mb-3">
            <label class="form-label">Employee no</label>
            <form:input path="empno" readonly="true"   cssClass="form-control" placeholder="Enter employee name"/>
        </div>

        <!-- Employee Name -->
        <div class="mb-3">
            <label class="form-label">Employee Name</label>
            <form:input path="ename" cssClass="form-control" placeholder="Enter employee name"/>
        </div>

        <!-- Job -->
        <div class="mb-3">
            <label class="form-label">Job</label>
            <form:input path="job" cssClass="form-control" placeholder="Enter job title"/>
        </div>

        <!-- Salary -->
        <div class="mb-3">
            <label class="form-label">Salary</label>
            <form:input path="sal" cssClass="form-control" placeholder="Enter salary"/>
        </div>
        <div class="mb-3">
    <label for="deptno" class="form-label">Department Number</label>
    <form:select path="deptno" id="deptno" cssClass="form-select">
        <form:options items="${dnoList}" />
    </form:select>
</div>
        

        <!-- Submit -->
        <div class="text-center">
            <button type="submit" class="btn btn-custom px-4">Edit</button>
        </div>

    </form:form>
</div>

</body>
</html>
