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
        } else {
            const userEmail = data.userEmail;
            console.log('User email:', userEmail);

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
                            console.log('Appointments response:', response);
                            return response.json();
                        })
                        .then(appointments => {
                            // 在这里处理获取到的预约数据
                            displayAppointments(appointments);
                            console.log(appointments);
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
    appointments.forEach(appointment => {
        var row = document.createElement("tr");
        row.innerHTML = "<td>" + appointment.appointmentTime + "</td>" +
            "<td>" + appointment.appointmentEndTime + "</td>" +
            "<td>" + appointment.trainer.trainerName + "</td>";
        appointmentBody.appendChild(row);
    });
}

