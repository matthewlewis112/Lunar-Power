from flask import Flask, jsonify, make_response
from flask import abort, request
from flask_restful import Resource, Api
from flask_httpauth import HTTPBasicAuth
from werkzeug.security import generate_password_hash, check_password_hash

app = Flask(__name__)
api = Api(app)

#Set up fake devices
#return json formatted list of devices
#That user has already theoretically added to service

#How to run:::: python WebApp.py

#https://blog.miguelgrinberg.com/post/designing-a-restful-api-with-python-and-flask
#That's a blog I'm using for reference on how to make an API

auth = HTTPBasicAuth()

users = {
    "admin": generate_password_hash("LunarPower5"),
    "user1": generate_password_hash("password")
}

@auth.get_password 
def get_password(username):
    if username in users:
        return users.get(username)
    return None

@auth.error_handler
def unathorized():
    return make_response(jsonify({'error': 'Unauthorized access'}), 401)

@app.errorhandler(404)
def notFound(error):
    return make_response(jsonify({'error': '404: Not found'}), 404)

#This is a fake set of data. We will need to 
#include a database for this to work
devices = [
    {
        'id': 1,
        'title': u'Rumbaaa',
        'done': False
    },
    {
        'id': 2,
        'title': u'Smart House',
        'done': False
    },
    {
        'id': 3,
        'title': u'Computer',
        'done': False
    },
    {
        'id': 4,
        'title': u'Something else',
        'done': False
    }
]
# class Devices(Resource):
#     def get(self):
#         return {'devices': devices} 

# class Device(Resource):
#     def get(self, device_id):

#curl -i <localhost_url>
@app.route('/', methods=['GET'])
@auth.login_required
def getDevices():
    return jsonify({'devices' : devices})

#Returns a specific device based on its id
@app.route('/<int:deviceId>', methods=['GET'])
@auth.login_required
def getDevice(deviceId):
    targetDevice = []
    for device in devices:
        if device.get('id') == deviceId:
            targetDevice.append(device)
    if len(targetDevice) == 0:
        abort(404)
    return jsonify({'devices': targetDevice})

#curl -i -H "Content-Type: application/json" -X POST -d "{"""title""":"""Read a book"""}" <localhost_url>
##The above command isn't working right now, I'll figure it out later
@app.route('/', methods=['POST'])
@auth.login_required
def addDevice():
    #this will change when we get a new database
    #right now it is based off of my fake database
    if not request.json or not 'title' in request.json: 
        abort(400)
    addedDevice = {
        'id': devices[-1]['id'] + 1,
        'title': request.json['title'],
        'done': False
    }
    devices.append(addedDevice)
    return jsonify({'devices': addedDevice}), 201


# api.add_resource(Devices, '/')
# api.add_resource()


if __name__ == '__main__':
    app.run()
