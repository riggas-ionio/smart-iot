# import main Flask class and request object
from flask import Flask, request
from flask_cors import CORS
import json

# create the Flask app
app = Flask(__name__)
CORS(app)

@app.route('/')
def root():
    return 'Please POST to /post'

@app.route('/post', methods=['GET', 'POST'])
def post():
    if request.method == 'GET':
        return 'Please POST to /post'
    request_data = request.json
    print(format(request_data))
    return json.dumps(request_data)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80, debug=True)
