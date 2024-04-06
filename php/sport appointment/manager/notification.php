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
$date = date('Y-m-d');
$sql = "SELECT username FROM plans WHERE expiryday < '$date'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // 输出每行数据
    while($row = $result->fetch_assoc()) {
        $username = $row["username"];
        $sqll = "SELECT email FROM users WHERE username='$username'";
        $email_result = $conn->query($sqll);
        if ($email_result->num_rows > 0) {
            while($email_row = $email_result->fetch_assoc()) {
                $email = $email_row['email'];
                // 发送邮件
                $to = $email;
                $subject = '关于您的计划';
                $message = "尊敬的用户，您的计划已经过期，请及时处理。";
                $headers = 'From: your_email@example.com' . "\r\n" .
                    'Reply-To: your_email@example.com' . "\r\n" .
                    'X-Mailer: PHP/' . phpversion();
                mail($to, $subject, $message, $headers);

                echo "已向邮箱 $email 发送信息<br>";
            }
        } else {
            echo "未找到与用户名 '$username' 相关的 Email<br>";
        }
    }
} else {
    echo "没有过期的计划<br>";
}
$conn->close();
?>
