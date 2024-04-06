<?php
session_start();

// 检查用户是否已经登录，如果未登录则重定向到登录页面
if (!isset($_SESSION['username'])) {
    header("Location: login.html");
    exit();
}

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

// 处理表单提交
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // 清理和验证表单提交的数据
    $trainer_id = isset($_POST['trainers']) ? strval($_POST['trainers']) : null;
    $appointment_date = isset($_POST['date']) ? $_POST['date'] : null;
    $appointment_time = isset($_POST['time']) ? $_POST['time'] : null;
    $datetime = $appointment_date . ' ' . $appointment_time . ':00';
    //    // 输出提交的日期和时间信息
    //    echo "提交的教练：" . $trainer_id . "<br>";
    //    echo "提交的日期：" . $appointment_date . "<br>";
    //    echo "提交的时间：" . $appointment_time . "<br>";


    // 确保所有必要的字段都有值
    if ($trainer_id !== null && $appointment_date !== '' && $appointment_time !== '') {

        // 将预约信息插入到数据库中
        $stmt = $conn->prepare('INSERT INTO appointment (username, trainer, time, statue) VALUES (?, ?, ?, "assigned")');

        $stmt->bind_param('sss', $_SESSION['username'], $trainer_id, $datetime);

        $stmt->execute();

        // 检查预约是否成功插入
        if ($stmt->affected_rows > 0) {
            echo "预约成功！";
        } else {
            echo "预约失败，请重试。";
        }
    } else {
        echo "请填写所有必填字段。";
    }
}

// 关闭数据库连接
$conn->close();
?>
