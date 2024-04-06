<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        h2 {
            margin-top: 50px;
            text-align: center;
        }
        .no-appointments {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "user_info";

    $conn = new mysqli($servername, $username, $password, $dbname);

    if ($conn->connect_error) {
        die("连接失败: " . $conn->connect_error);
    }

    $sql = "SELECT * FROM appointment";
    $result = $conn->query($sql);
    if ($result->num_rows > 0) {
        echo "<h2>Appointment Information</h2>";
        echo "<table>";
        echo "<tr><th>Username</th><th>Trainer</th><th>Time</th><th>Status</th></tr>";
        while($row = $result->fetch_assoc()) {
            echo "<tr><td>" . $row["username"] . "</td><td>" . $row["trainer"] . "</td><td>" . $row["time"] . "</td><td>" . $row["statue"] . "</td></tr>";
        }
        echo "</table>";
    } else {
        echo "<h2>No Appointments</h2>";
        echo "<p class='no-appointments'>There are currently no appointments.</p>";
    }

    $conn->close();
    ?>
</div>

</body>
</html>
