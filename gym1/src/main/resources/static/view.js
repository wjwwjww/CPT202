var username = localStorage.getItem("username"); // 获取当前用户的用户名
fetch('/appointments/views/' + username)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(appointments => {
        displayAppointment(appointments);
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });

// 将预约信息显示在表格中
function displayAppointment(appointments) {
    var appointmentBody = document.getElementById("appointmentBody");
    appointments.forEach(appointment => {
        var row = document.createElement("tr");
        row.innerHTML = "<td>" + appointment.date + "</td>" +
            "<td>" + appointment.time + "</td>" +
            "<td>" + appointment.trainer + "</td>" +

            "<td><button onclick='editAppointment(\"" + appointment.id + "\", \"" + appointment.date + "\", \"" + appointment.time + "\", \"" + appointment.trainer + "\")'>Edit</button></td>"+
            "<td><button onclick='cancelAppointment(\"" + appointment.id + "\")'>Cancel</button></td>"; // Add c
        appointmentBody.appendChild(row);
    });
}

// 编辑预约信息
function editAppointment(id, date, time, trainer) {
    var newRow = document.createElement("tr");
    newRow.innerHTML = "<td><input type='text' id='newDate' value='" + date + "'></td>" +
        "<td><input type='text' id='newTime' value='" + time + "'></td>" +
        "<td><input type='text' id='newTrainer' value='" + trainer + "'></td>" +
        "<td><button onclick='updateAppointment(\"" + id + "\")'>Update</button></td>";

    var oldRow = document.getElementById("appointmentBody").querySelector("tr");
    oldRow.parentNode.replaceChild(newRow, oldRow);
}

// 更新预约信息
function updateAppointment(id) {
    var newDate = document.getElementById("newDate").value;
    var newTime = document.getElementById("newTime").value;
    var newTrainer = document.getElementById("newTrainer").value;

    var updateData = {
        id: id,
        date: newDate,
        time: newTime,
        trainer: newTrainer
    };

    fetch('/appointments/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updateData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            location.reload(); // This will refresh the page
            // return response.json();

        })
        .then(updatedAppointment => {
            // 更新成功后重新加载预约信息
            // fetchAppointments();
            location.reload(); // This will refresh the page
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}
function cancelAppointment(id) {
    fetch('/appointments/delete/' + id, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            location.reload(); // This will refresh the page
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

// // 重新加载预约信息
// function fetchAppointments() {
//     fetch('/appointments/views/' + username)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Network response was not ok');
//             }
//             return response.json();
//         })
//         .then(appointments => {
//             var appointmentBody = document.getElementById("appointmentBody");
//             appointmentBody.innerHTML = ""; // 清空表格内容
//             displayAppointment(appointments);
//         })
//         .catch(error => {
//             console.error('There was a problem with the fetch operation:', error);
//         });
// }