
<?php
//// 连接到数据库并查询训练师列表
//// 假设 $trainers 是一个包含训练师名字的数组
//$trainers = array("Trainer1", "Trainer2");
//
//// 输出选项
//foreach ($trainers as $trainer) {
//    echo "<option value='$trainer'>$trainer</option>";
//}
//?>
<?php
session_start();

// 检查用户是否已经登录，如果未登录则重定向到登录页面
if (!isset($_SESSION['username'])) {
    header("Location: login.html");
    exit();
}

//// 数据库连接信息
//include_once 'config.php'; // 这里假设你将数据库连接信息存储在一个名为 config.php 的文件中
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "user_info";
// 创建连接
$conn = new mysqli($servername, $username, $password, $dbname);

// 检查连接是否成功
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


// 使用预处理语句查询用户计划
$sql_user = "SELECT plan FROM plans WHERE username = ?";
$stmt_user = $conn->prepare($sql_user);
$stmt_user->bind_param("s", $_SESSION['username']);
$stmt_user->execute();
$result_plan = $stmt_user->get_result();

if ($result_plan->num_rows > 0) {
    // 输出用户信息
    $user_row = $result_plan->fetch_assoc();
    $user_plan = $user_row['plan'];

echo $user_plan;
    // 使用预处理语句查询trainer信息
    $sql_trainer = "SELECT trainer FROM trainers WHERE rank = ?";
    $stmt_trainer = $conn->prepare($sql_trainer);
    $stmt_trainer->bind_param("i", $user_plan);
    $stmt_trainer->execute();
    $result_trainer = $stmt_trainer->get_result();

    // 检查查询结果是否为空
    if ($result_trainer->num_rows > 0) {
        // 输出每一行数据
        while($row = $result_trainer->fetch_assoc()) {
            echo "<option value='" . $row["trainer"] ."'>" . $row["trainer"] . "</option>";
        }
    } else {
        echo "<option value=''>No trainers found</option>";
    }
} else {
    echo "<option value=''>No plan found for this user</option>";
}

// 关闭语句对象
$stmt_user->close();
$stmt_trainer->close();

// 关闭数据库连接
$conn->close();
?>
