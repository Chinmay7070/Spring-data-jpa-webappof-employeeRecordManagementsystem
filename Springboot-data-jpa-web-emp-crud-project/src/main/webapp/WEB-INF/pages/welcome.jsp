<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Welcome Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5 0%, #9face6 100%);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background: white;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
            text-align: center;
            width: 400px;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        p {
            color: #555;
            margin-bottom: 30px;
        }
        img {
            width: 180px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
            transition: transform 0.3s ease-in-out;
            cursor: pointer;
        }
        img:hover {
            transform: scale(1.08);
        }
        .btn {
            display: inline-block;
            margin-top: 25px;
            padding: 12px 25px;
            background: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
            transition: background 0.3s ease-in-out;
        }
        .btn:hover {
            background: #388e3c;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome to Employee Portal</h1>
    <p>Click below to view the Employee Report</p>
    <a href="report">
        <img src="images/report.jpg" alt="Report">
    </a>
    <br>
    <a href="report" class="btn">View Report</a>
</div>

</body>
</html>
