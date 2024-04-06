<?php
session_start();
// 这里假设你连接了数据库，并且有一个表格来存储预约历史数据
// 假设数据库连接信息为：
// 数据库连接信息
$servername = "localhost";
$dbusername = "root";
$password = "";
$dbname = "user_info";


// 创建数据库连接
$conn = new mysqli($servername, $dbusername, $password, $dbname);

// 检查连接是否成功
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$username=$_SESSION['username'];
// 查询预约历史数据
$sql = "SELECT time, trainer, statue FROM appointment WHERE username = $username";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // 将查询结果转换为数组
    $historyData = array();
    while($row = $result->fetch_assoc()) {
        $historyData[] = $row;
    }
//
//    $current_time = date('Y-m-d H:i:s');
//
//     //遍历历史数据数组
//    foreach ($historyData as $key => $appointment) {
//        // 将时间字符串转换为时间戳
//        $appointment_time = strtotime($appointment['time']);
//
//        // 如果预约时间已经过去，则更新状态为"passed"
//        if ($appointment_time < $current_time && $appointment['statue'] != "passed") {
//            // 更新状态为"passed"
//            $historyData[$key]['statue'] = "passed";
//
//            // 更新数据库中的状态信息
//            $update_sql = "UPDATE appointment SET status = 'passed' WHERE time = '" . $appointment['time'] . "'";
//            $conn->query($update_sql);
//        }
//    }

    // 将数组转换为 JSON 格式并输出
    header('Content-Type: application/json');
    echo json_encode($historyData);
} else {
    // 如果没有查询到数据，输出空数组
    echo json_encode(array());
}

// 关闭数据库连接
$conn->close();
?>
