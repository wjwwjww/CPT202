document.addEventListener("DOMContentLoaded", function() {
    // 获取预约历史按钮
    var historyButton = document.querySelector(".history button");

    // 添加点击事件监听器
    historyButton.addEventListener("click", function() {
        // 发送GET请求到服务器获取预约历史数据
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "history.php", true); // 假设服务器端脚本为history.php
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // 如果请求成功，将预约历史数据显示在弹出窗口中
                    var historyData = JSON.parse(xhr.responseText);
                    showHistoryPopup(historyData);
                } else {
                    // 处理请求失败的情况
                    console.error("Failed to fetch appointment history.");
                }
            }
        };
        xhr.send();
    });

    // 在弹出窗口中显示预约历史数据的函数
    function showHistoryPopup(historyData) {
        // 创建弹出窗口
        var popup = window.open("", "预约历史", "width=600,height=400");

        // 创建弹出窗口中的内容
        var historyContent = "<h2>预约历史</h2><ul>";

        historyData.forEach(function(appointment) {
            historyContent += "<li>Time: " + appointment.time + ", Trainer: " + appointment.trainer + ", statue:" + appointment.statue + "</li>";

        });

        historyContent += "</ul>";

        // 将内容写入弹出窗口
        popup.document.write(historyContent);

        // 关闭弹出窗口按钮
        popup.document.write("<button onclick='window.close()'>关闭</button>");
    }
});
