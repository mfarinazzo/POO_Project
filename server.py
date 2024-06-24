from flask import Flask
from controllerAI import Controller
from controllerDataset import generate_dataset, generate_csv
from helpers.help import openCsv
import torch

#inicializa o servidor Flask
app = Flask(__name__)

#inicializa o controllerAI
controller = Controller()

#gera o dataset
samples, labels = generate_dataset(1000, 0, 1, 0.8)

#gera o arquivo csv a partir do dataset
generate_csv(samples, labels,'data.csv')

#carrega o dataset
data = openCsv('data.csv')

#prepara os dados para treinamento
trainData, validationData = controller.prepareData(data)

#treina o modelo de IA
controller.train(trainData, 100)

aux = []
for c in range(0, 500):
    aux.append(data[c][0])
aux.sort()

@app.route('/generate/<param>')
def controller_generate(param):
    return str(aux[int(param)])

@app.route('/predict/<param>')
def get_predicts(param):
    r = torch.round(controller.validate(torch.Tensor([float(param)])))[0]
    return str(r.item())

if __name__ == '__main__':
    app.run()