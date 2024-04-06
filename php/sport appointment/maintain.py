from flask import Flask, render_template, request, redirect, url_for
import os

app = Flask(__name__)

UPLOAD_FOLDER = '/path/to/upload/folder'
ALLOWED_EXTENSIONS = {'txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif'}

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/')
def index():
    files = os.listdir(UPLOAD_FOLDER)
    return render_template('index.html', files=files)

@app.route('/upload', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        if 'file' not in request.files:
            return redirect(request.url)
        file = request.files['file']
        if file.filename == '':
            return redirect(request.url)
        if file and allowed_file(file.filename):
            file.save(os.path.join(UPLOAD_FOLDER, file.filename))
            return redirect(url_for('index'))
    return render_template('upload.html')

@app.route('/edit/<filename>', methods=['GET', 'POST'])
def edit_file(filename):
    filepath = os.path.join(UPLOAD_FOLDER, filename)
    if request.method == 'POST':
        content = request.form['content']
        with open(filepath, 'w') as f:
            f.write(content)
        return redirect(url_for('index'))
    with open(filepath, 'r') as f:
        content = f.read()
    return render_template('edit.html', filename=filename, content=content)

if __name__ == '__main__':
    app.run(debug=True)
