<?php

// 数据库连接信息
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "user_info";

session_start();
// 检查用户是否已经登录，如果未登录则重定向到登录页面
if (!isset($_SESSION['username'])) {
    header("Location: register.html");
    exit();
}
// 检查$_POST['plan']是否存在，以防止未经验证的表单提交
if (!isset($_POST['plan'])) {
    // 处理错误情况，例如重定向到错误页面或输出错误消息
    exit("Invalid form submission");
}

$conn = new mysqli($servername, $username, $password, $dbname);

// 检查连接
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


// 处理表单提交
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // 获取用户选择的计划和时间
    $planDuration = $_POST['plan'];
    list($plan, $duration) = explode("-", $planDuration);
    $expiryDate = date('Y-m-d', strtotime("+$duration months"));
    echo "Plan: " . $plan . "<br>";
    echo "Duration: " . $duration . "<br>";
    echo "Username: " . $_SESSION['username'] . "<br>";
    echo "New record created successfully";
    // 准备插入语句

    $sql = "INSERT INTO plans (plan, duration, username, expiryday) VALUES ('$plan', '$duration', '{$_SESSION['username']}', '$expiryDate')";

    if ($conn->query($sql) === TRUE) {
        echo "Plan: " . $plan . "<br>";
        echo "Duration: " . $duration . "<br>";
        echo "Username: " . $_SESSION['username'] . "<br>";
        echo "New record created successfully";
            header("Location: traninng.html");
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

// 关闭数据库连接
$conn->close();
?>
