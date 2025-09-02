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
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .form-container {
            max-width: 500px;
            width: 100%;
            background: #fff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0px 10px 30px rgba(0,0,0,0.2);
            animation: fadeInUp 0.8s ease-in-out;
        }

        h1 {
            text-align: center;
            color: #1976d2;
            margin-bottom: 25px;
            font-weight: bold;
            letter-spacing: 1px;
            animation: glowText 2s infinite alternate;
        }

        .form-label {
            font-weight: 600;
            color: #333;
        }

        .form-control {
            border-radius: 8px;
            transition: all 0.3s ease-in-out;
        }

        .form-control:focus {
            border-color: #1976d2;
            box-shadow: 0 0 8px rgba(25,118,210,0.5);
            transform: scale(1.02);
        }

        .btn-custom {
            background-color: #1976d2;
            color: #fff;
            font-weight: 600;
            border-radius: 10px;
            transition: all 0.3s ease-in-out;
        }

        .btn-custom:hover {
            background-color: #0d47a1;
            transform: translateY(-3px) scale(1.05);
            box-shadow: 0px 6px 16px rgba(0,0,0,0.3);
        }

        /* Animations */
        @keyframes fadeInUp {
            from { opacity: 0; transform: translateY(40px); }
            to { opacity: 1; transform: translateY(0); }
        }

        @keyframes glowText {
            from { text-shadow: 0 0 5px #1976d2, 0 0 10px #74ebd5; }
            to { text-shadow: 0 0 15px #1976d2, 0 0 25px #74ebd5; }
        }
    </style>
</head>
<body>

<div class="form-container">
    <h1>Employee Registration</h1>

    <form:form modelAttribute="emp" >
       <%-- 
       <p style="color:red">
           <form:errors path="*"></form:errors>
       </p> --%>
           
        <!-- Employee Name -->
        <div class="mb-3">
            <label class="form-label">Employee Name</label>
            <form:input path="ename" cssClass="form-control" placeholder="Enter employee name"/>   
            <form:errors path="ename" cssClass="text-danger"/>
        </div>

        <!-- Job -->
        <div class="mb-3">
            <label class="form-label">Job</label>
            <form:input path="job" cssClass="form-control" placeholder="Enter job title"/>
            <form:errors path="job" cssClass="text-danger"/>
        </div>

        <!-- Salary -->
        <div class="mb-3">
            <label class="form-label">Salary</label>
            <form:input path="sal" cssClass="form-control" placeholder="Enter salary"/>
           <form:errors path="sal" cssClass="text-danger"/>
        </div>
        
       <div class="mb-3">
    <label for="deptno" class="form-label">Department Number</label>
    <form:select path="deptno" id="deptno" cssClass="form-select">
        <form:options items="${dnoList}" />
    </form:select>
</div>


        <!-- Submit -->
        <div class="text-center">
            <button type="submit" class="btn btn-custom px-4">Register</button>
        </div>

    </form:form>
</div>

<!-- JavaScript for interactive input effects -->
<script>
    document.querySelectorAll('.form-control').forEach(input => {
        input.addEventListener('focus', () => {
            input.style.backgroundColor = '#f0f8ff';
        });
        input.addEventListener('blur', () => {
            input.style.backgroundColor = '#fff';
        });
    });

    // Button ripple effect
    document.querySelectorAll('.btn-custom').forEach(btn => {
        btn.addEventListener('click', function(e) {
            let ripple = document.createElement('span');
            ripple.classList.add('ripple');
            ripple.style.left = e.clientX - btn.offsetLeft + "px";
            ripple.style.top = e.clientY - btn.offsetTop + "px";
            this.appendChild(ripple);
            setTimeout(() => ripple.remove(), 600);
        });
    });
</script>

<style>
    /* Ripple Effect */
    .btn-custom {
        position: relative;
        overflow: hidden;
    }
    .ripple {
        position: absolute;
        border-radius: 50%;
        transform: scale(0);
        background: rgba(255, 255, 255, 0.7);
        animation: rippleEffect 0.6s linear;
    }
    @keyframes rippleEffect {
        to {
            transform: scale(4);
            opacity: 0;
        }
    }
</style>

</body>
</html>
