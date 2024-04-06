<?php
// 数据库连接信息
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "user_info";

// 创建数据库连接
$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("连接失败: " . $conn->connect_error);
}

// 获取当前时间
$current_time = date('Y-m-d H:i:s');

// 查询需要更新状态的预约
$sql = "SELECT * FROM appointment WHERE time < '$current_time' AND statue = 'assigned'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // 更新预约状态为已过期
    $update_sql = "UPDATE appointment SET statue = 'passed' WHERE time < '$current_time' AND statue = 'assigned'";
    if ($conn->query($update_sql) === TRUE) {
        echo "预约状态已更新";
    } else {
        echo "Error updating record: " . $conn->error;
    }
} else {
    echo "没有需要更新状态的预约";
}

$conn->close();
?>
