from flask import Flask
app = Flask(__name__)

@app.route('/')
def run_test_server():
    return 'Working boss!'
