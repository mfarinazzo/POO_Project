from helpers.help import openCsv, handleData, normalize, denormalize
from network import NeuralNetwork
import torch
import torch.optim as optim
import torch.nn as nn
from controllerDataset import generate_dataset, generate_csv

class Controller():

    def __init__(self):

        self.model = NeuralNetwork.Net(1, 1)
        self.gradienteErro = nn.MSELoss()
        self.correcaoErro = optim.SGD(self.model.parameters(), lr=0.01, momentum=0.7)
        self.eraError = torch.tensor([0.0], dtype=torch.float64)
        self.lr = float()
        pass
    
    def prepareData(self, data):
        trainData, validationData, header = handleData(data)
        
        return trainData, validationData

    def train(self, trainData, epocs):

        #por 400 epocas
        for i in range(epocs):
            """ if i%20==0:
                lr = 10.01 - (i/40)
                if lr < 0.01:
                    lr = 0.01
                correcaoErro = optim.Adam(net.parameters(), lr=lr) """

            print(round(i/40)*'#'+f' {i/4}%')
            
            for item in trainData:

                #zera o gradiente
                self.correcaoErro.zero_grad()

                #faz a passagem para frente
                saida = self.model(item[:-1])
                #calcula o erro
                erro = self.gradienteErro(saida[0], item[-1])
                self.eraError += erro

                #faz a propagração do erro para trás
                erro.backward()

                #corrige os pesos
                self.correcaoErro.step()

            print(f'erro: {self.eraError/len(trainData)}')
            print('-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-')
            self.eraError = 0.0

    def validate(self, validationData):

        saida = self.model(validationData)
            
        return saida
    
    