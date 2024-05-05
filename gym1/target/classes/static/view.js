fetch('/getUserData')
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch user data');

        }
        return response.json();
    })
    .then(data => {
        if (data.error) {
            console.error('Error:', data.error);
            alert("Please login first!");
            window.location.href = "/login";
        } else {
            const userEmail = data.userEmail;
            console.log('User email:', userEmail);

            let ranking ;
            fetch('/api/trainerbyemail/' + userEmail)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to fetch trainers');
                    }
                    return response.json();
                })
                .then(trainers => {
                    // 获取到训练师数据后，填充到<select>元素中
                    const trainerSelect = document.getElementById('trainer1');
                    trainerSelect.innerHTML = ''; // 清空原有的选项

                    // 循环遍历训练师数组，并将每个训练师信息添加到<select>元素中
                    trainers.forEach(trainer => {
                        ranking = trainer.trainerRanking;
                        const option = document.createElement('option');
                        option.value = trainer.trainerId; // 使用trainerId作为值
                        option.textContent = trainer.trainerName; // 使用trainerName作为显示文本
                        trainerSelect.appendChild(option);
                    });
                })
                .catch(error => {
                    console.error('Error fetching trainers:', error);
                });

            // 根据用户邮箱获取用户ID
            fetch('/getUserIdByEmail/' + userEmail)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to fetch user ID');
                    }
                    return response.json();
                })
                .then(userData => {
                    const userId = userData;
                    console.log('User ID:', userId);

                    // 根据用户ID获取用户的所有预约信息
                    fetch('/api/getall/' + userId)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('Failed to fetch appointments');
                            }
                            return response.json();
                        })
                        .then(appointments => {
                            // 在这里处理获取到的预约数据
                            displayAppointments(appointments);
                        })
                        .catch(error => {
                            console.error('Error fetching appointments:', error);
                        });
                })
                .catch(error => {
                    console.error('Error fetching user ID:', error);
                });
        }
    })
    .catch(error => {
        console.error('Error fetching user data:', error);
    });
function displayAppointments(appointments) {
    var appointmentBody = document.getElementById("appointmentBody");
    appointmentBody.innerHTML = ""; // 清空表格内容

    // 将预约数据按照预约时间排序
    appointments.sort((a, b) => new Date(a.appointmentTime) - new Date(b.appointmentTime));


    appointments.forEach(appointment => {
        // 格式化日期时间

        var startDateTime = formatDateTime(new Date(appointment.appointmentTime));
        var endDateTime = formatDateTime(new Date(appointment.appointmentEndTime));
        var duration = calculateDuration(startDateTime, endDateTime);
        var row = document.createElement("tr");
        row.innerHTML = "<td>" + startDateTime + "</td>" +
            "<td>" + duration + "</td>" +
            "<td>" + endDateTime + "</td>" +
            "<td>" + appointment.trainer.trainerName + "</td>"+
        "<td><button onclick='editappointment(\"" +appointment.id + "\", \"" + startDateTime + "\", \"" + duration + "\", \"" + appointment.trainer+ "\")'>edit</button></td>"+
        "<td><button onclick='deleteappointment(\"" + appointment.id + "\", \"" + startDateTime + "\", \"" + endDateTime + "\", \"" + appointment.trainer.trainerName + "\")'>delete</button></td>";
        appointmentBody.appendChild(row);
    });
}

function reverseOrder() {
    var appointmentBody = document.getElementById("appointmentBody");
    var rows = Array.from(appointmentBody.getElementsByTagName("tr"));
    rows.reverse();
    appointmentBody.innerHTML = ""; // 清空表格内容
    rows.forEach(row => {
        appointmentBody.appendChild(row);
    });
}

// 格式化日期时间函数
function formatDateTime(date) {
    var year = date.getFullYear();
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var day = ('0' + date.getDate()).slice(-2);
    var hours = ('0' + date.getHours()).slice(-2);
    var minutes = ('0' + date.getMinutes()).slice(-2);
    return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
}
function calculateDuration(startDateTime, endDateTime) {
    var start = new Date(startDateTime).getTime();
    var end = new Date(endDateTime).getTime();
    var durationMs = end - start;
    var durationMinutes = durationMs / (1000 * 60); // 将持续时间转换为分钟
    return durationMinutes;
}

function deleteappointment(id) {
    fetch(`/api/delete/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to delete appointment');

            }
            document.getElementById('deleteMessage').innerText = 'Appointment deleted successfully!';
            // 删除成功后重新获取预约列表并显示
            fetch('/api/getall/' + userId) // Assuming you have access to userId
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to fetch appointments');
                    }
                    return response.json();
                })
                .then(appointments => {
                    // 重新显示预约列表
                    // displayAppointments(appointments);
                    window.location.reload();
                })
                .catch(error => {
                    console.error('Error fetching appointments:', error);
                });
        })
        .catch(error => {
            console.error('Error deleting appointment:', error);
        });
}


//编辑部分

// 点击编辑按钮显示模态框
    function editappointment(id, startDateTime, duration, trainer) {

        // 将原始预约信息填入模态框
        // document.getElementById('editStartDateTime').value = startDateTime;
        // document.getElementById('editDuration').value = duration;

        //默认trainer
        // var selectElement = document.getElementById('editTrainerName');
        // for (var i = 0; i < selectElement.options.length; i++) {
        //     if (selectElement.options[i].value === trainerName) {
        //         selectElement.options[i].selected = true;
        //         break;
        //     }
        // }

        // 显示模态框
        var editModal = document.getElementById('editAppointmentModal');
        editModal.style.display = 'block';

        // // 提交编辑后的预约信息
        document.getElementById("saveEditAppointmentBtn").addEventListener("click", function() {

            var newDate = document.getElementById("myDate1").value;
            var newTime = document.getElementById("startTimeSelect").value;
            if (!newDate) {
                alert("Please select a date.");
                return;
            }

            if(!newTime){
                alert("please choose time");
                return;
            }
            console.log(newDate);
            console.log(newTime);
            var dateTimeString = newDate + "T" + newTime;
            if (!dateTimeString) {
                alert("Please select a duration");
                return;
            }
            var dateTime = new Date(dateTimeString);


// 获取年、月、日、小时和分钟
            var year = dateTime.getFullYear();
            var month = (dateTime.getMonth() + 1).toString().padStart(2, '0'); // 月份从 0 开始，需要加 1
            var day = dateTime.getDate().toString().padStart(2, '0');
            var hours = dateTime.getHours().toString().padStart(2, '0');
            var minutes = dateTime.getMinutes().toString().padStart(2, '0');

// 格式化为指定格式的日期时间字符串
            var formattedDateTimeString = `${year}-${month}-${day}T${hours}:${minutes}`;

            console.log("Formatted date time:", formattedDateTimeString);
            var trainerId = document.getElementById("trainer1").value;

            gettrainerByid(trainerId)
                .then(trainer => {

                    // document.getElementById("appointment-form").addEventListener("submit", function (event) {
                    //     event.preventDefault(); // 阻止表单默认提交行为

                     newTrainer=trainer;

                    saveEditedAppointment(id, formattedDateTimeString, duration, newTrainer);
                });
                    // 显示模态框
                    modal.style.display = "none";

                });


}

// 保存编辑后的预约信息
function saveEditedAppointment(id, newDatetime, duration, newTrainer) {
    if (!newTrainer) {
        console.error("新训练师不能为空");
        return; // 如果newTrainer为空，则不发送请求
    }
    if(!newDatetime){
        console.error("新时间不能为空");
        return;
    }
    if(!duration){
        console.error("新时长不能为空");
        return;
    }

    // 构建要发送的数据对象

    var data = {
        id: id,
        appointmentTime: newDatetime,
        duration: duration,
        trainer: newTrainer,
    };
    console.log(data);

    // 发送fetch请求
    fetch('/api/updateappointment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                console.log("提交成功");
                window.location.reload();
            } else {
                console.error("提交失败: " + response.status);
            }
        })
        .catch(error => {
            console.error("提交失败: " + error);
        });
}



function gettrainerByid(id) {
    return new Promise((resolve, reject) => {
        fetch('/gettrainerbyid/' + id)
            .then(response => response.json())
            .then(trainer => {
                // console.log('User data:', user);
                resolve(trainer); // 返回解析后的用户数据
            })
            .catch(error => {
                reject('Error fetching user: ' + error);
            });
    });
}

