<?php
session_start(); // 开始会话

// 检查会话中是否存在用户名
if (isset($_SESSION['username'])) {
    // 销毁会话
    session_destroy();
}

// 确保会话销毁完成
session_commit();

// 重定向到登录界面
header('Location: login.html');
exit;
?>
