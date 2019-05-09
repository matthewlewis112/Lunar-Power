from flask import Flask
from flask_restful import Resource, Api
app = Flask(__name__)
api = Api(app)

class Devices(Resource):
    def get(self):
        return {'Device1': 'Roomba'}

api.add_resource(Devices, '/')

if __name__ == '__main__':
    app.run()
