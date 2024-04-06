# from flask import Flask, render_template, request, redirect, url_for
#
# app = Flask(__name__)
#
# # Dummy data representing trainers and their star ratings
# trainers = {
#     "Trainer1": 3,
#     "Trainer2": 4,
#     "Trainer3": 5
# }
#
# # Dummy data representing available time slots for trainers
# time_slots = {
#     "Trainer1": ["10:00 AM", "11:00 AM", "12:00 PM"],
#     "Trainer2": ["9:00 AM", "10:00 AM", "11:00 AM"],
#     "Trainer3": ["8:00 AM", "9:00 AM", "10:00 AM"]
# }
#
# @app.route('/')
# def index():
#     return render_template('index.html', trainers=trainers)
#
# @app.route('/make_appointment', methods=['POST'])
# def make_appointment():
#     if request.method == 'POST':
#         trainer = request.form['trainer']
#         date = request.form['date']
#         time = request.form['time']
#         # Process appointment (e.g., save to database)
#         return f"Appointment made with {trainer} on {date} at {time}."
#     else:
#         return redirect(url_for('index'))
#
# if __name__ == '__main__':
#     app.run(debug=True)
