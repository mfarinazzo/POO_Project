import torch
import torch.nn as nn

class Net(torch.nn.Module):
    """ 
        Classe que representa a rede neural
    """
    def __init__(self, input_size, output_size):
        """ 
            Inicializa a rede neural
            @param input_size: int - Tamanho da entrada da rede
            @param hidden_size: list - Lista com o tamanho das camadas escondidas
            @param output_size: int - Tamanho da saída da rede 
        """
        super(Net, self).__init__()
        self.fc1 = nn.Linear(input_size, 128)
        self.fc2 = nn.Linear(128, 256)
        self.fc3 = nn.Linear(256, 528)
        self.fc4 = nn.Linear(528, 128)
        self.out = nn.Linear(128, 1)
    
    def forward(self, x):
        """ 
            Faz a passagem para frente da rede neural
            @param x: tensor - Entrada da rede
            @return x: tensor - Saída da rede
        """
        x = torch.sigmoid(self.fc1(x))
        x = nn.functional.tanh(self.fc2(x))
        x = nn.functional.sigmoid(self.fc3(x))
        x = torch.tanh(self.fc4(x))
        x = nn.functional.leaky_relu(self.out(x))
        return x