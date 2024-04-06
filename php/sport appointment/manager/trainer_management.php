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

// 执行查询
$sql = "SELECT * FROM trainers";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // 输出数据
    while($row = $result->fetch_assoc()) {
        ?>
        <form action="" method="post">
            Trainer ID: <?php echo $row["trainer"]; ?> - Rank:
            <input type="number" name="new_rank" value="<?php echo $row["rank"]; ?>">
            <input type="hidden" name="trainer_id" value="<?php echo $row["trainer"]; ?>">
            <input type="submit" name="submit" value="更新">
        </form>
        <?php
    }
} else {
    echo "0 结果";
}

// 处理表单提交
if(isset($_POST['submit'])) {
    $new_rank = $_POST['new_rank'];
    $trainer_id = $_POST['trainer_id'];

    // 更新rank字段
    $update_sql = "UPDATE trainers SET rank=? WHERE trainer=?";
    $stmt = $conn->prepare($update_sql);
    $stmt->bind_param("is", $new_rank, $trainer_id); // 'ii' 表示两个参数都是整数
    if ($stmt->execute() === TRUE) {
        echo "Rank 更新成功";
        // 重定向到当前页面
        header("Refresh:0");
    } else {
        echo "Error 更新记录: " . $conn->error;
    }
    $stmt->close();
}

// 关闭数据库连接
$conn->close();
?>
