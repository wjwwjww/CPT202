<?php

session_start();

// 销毁当前会话
session_destroy();

session_start();

// 数据库连接信息
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "user_info";

// 创建数据库连接
$conn = new mysqli($servername, $username, $password, $dbname);

// 检查连接是否成功
if ($conn->connect_error) {
    die("连接失败: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // 收集表单数据
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    // 在实际应用中，你应该对用户输入进行验证和防止SQL注入攻击

    // 检查用户名是否已经存在
    $check_username_sql = "SELECT * FROM users WHERE username='$username'";
    $check_username_result = $conn->query($check_username_sql);
    if ($check_username_result->num_rows > 0) {
        echo "用户名已经存在，请选择另一个用户名。";
        exit();
    }

    // 检查电子邮件是否已经存在
    $check_email_sql = "SELECT * FROM users WHERE email='$email'";
    $check_email_result = $conn->query($check_email_sql);
    if ($check_email_result->num_rows > 0) {
        echo "该电子邮件地址已被注册，请使用另一个电子邮件地址。";
        exit();
    }

    // 将数据插入数据库
    $insert_sql = "INSERT INTO users (username, email, password) VALUES ('$username', '$email', '$password')";
    if ($conn->query($insert_sql) === TRUE) {
        $_SESSION['username'] = $username;
//        echo "注册成功";
        header("Location: planselection.html");
        exit();
    } else {
        echo "Error: " . $insert_sql . "<br>" . $conn->error;
    }
}

// 关闭数据库连接
$conn->close();
?>
