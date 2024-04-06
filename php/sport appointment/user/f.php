<?php

session_start(); // 开始会话
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

// 检查提交的表单是否存在用户名和密码
if (isset($_POST['account']) && isset($_POST['passwords'])) {
    // 获取提交的用户名和密码
    $username = $_POST['account'];
    $password = $_POST['passwords'];

    // 查询数据库中是否存在该用户
    $sql = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
    $result = $conn->query($sql);

    if ($result->num_rows == 1) {
        $row = $result->fetch_assoc();
        $_SESSION['username'] = $row['username'];
        // 用户名和密码验证成功，重定向到新界面
        header('Location: traninng.html');
        exit;
    } else {
        // 用户名或密码错误
        echo "用户名或密码错误";
    }
} else {
    // 如果没有提交用户名和密码，返回到登录界面
    header('Location: login.html');
    exit;
}

$conn->close();
?>

<?php
//// 数据库连接信息
//$servername = "localhost";
//$username = "root";
//$password = "";
//$dbname = "user_info";
//
//// 创建数据库连接
//$conn = new mysqli($servername, $username, $password, $dbname);
//
//// 检查连接是否成功
//if ($conn->connect_error) {
//    die("连接失败: " . $conn->connect_error);
//}
//
//// 检查提交的表单是否存在用户名和密码
//if (isset($_POST['account']) && isset($_POST['passwords'])) {
//    // 获取提交的用户名和密码
//    $username = $_POST['account'];
//    $password = $_POST['passwords'];
//
//    // 使用预处理语句防止 SQL 注入攻击
//    $stmt = $conn->prepare("SELECT * FROM users WHERE username = ?");
//    $stmt->bind_param("s", $username);
//    $stmt->execute();
//    $result = $stmt->get_result();
//
//    if ($result->num_rows == 1) {
//        // 用户名存在，检查密码
//        $row = $result->fetch_assoc();
//
//        // 从数据库中取出存储的密码
//        $stored_password = $row['password'];
//
//        if (password_verify($password, $stored_password)) {
//            // 密码验证成功，重定向到新界面
//            header('Location: traninng.html');
//            exit;
//        } else {
//            // 密码错误
//            echo "密码错误";
//        }
//    } else {
//        // 用户名不存在
//        echo "用户名不存在";
//    }
//    $stmt->close();
//} else {
//    // 如果没有提交用户名和密码，返回到登录界面
//    header('Location: login.html');
//    exit;
//}
//
//$conn->close();
//?>
//



