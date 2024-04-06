<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "user_info";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("连接失败: " . $conn->connect_error);
}

$sql = "SELECT plan, COUNT(*) AS count FROM plans GROUP BY plan";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<h2>Current Customer</h2>";
    echo "<table>";
    echo "<tr><th>Plan</th><th>Count</th></tr>";
    while($row = $result->fetch_assoc()) {
        $plan = "";
        if ($row["plan"] == "3") {
            $plan = "Silver";
        }
        else if ($row["plan"] == "4") {
            $plan = "Gold";
        }
        else if($row["plan"] == "5"){
            $plan = "Diamond";
        }
        echo "<tr><td>" . $plan . "</td><td>" . $row["count"] . "</td></tr>";
    }
    echo "</table>";
} else {
    echo "0 结果";
}

$sqll = "SELECT COUNT(*) AS count FROM appointment";
$appointment = $conn->query($sqll);
if ($appointment->num_rows > 0) {
    $row = $appointment->fetch_assoc();
    echo "<h2>Total Appointment</h2>";
    echo "<p>Total: " . $row["count"] . "</p>";
} else {
    echo "<p>0 预约结果</p>";
}

$conn->close();
?>

</body>
</html>
