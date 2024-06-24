# Antes de tudo, é preciso instalar os seguintes componentes python:
<hr>
Pytorch (para placas Nvidia): pip3 install torch torchvision torchaudio --index-url https://download.pytorch.org/whl/cu118

Pytorch (para quem não tem placas Nvidia): pip3 install torch torchvision torchaudio --index-url https://download.pytorch.org/whl/cpu

<hr>

Flask: pip install Flask

## Inicializando o servidor python
<hr>
Apenas rode o comando abaixo, e espere a menságem que o servidor está online.
Pode demorar alguns minutos, onde será visto que a rede neural estará sendo treinada antes do servidor subir.
comando (Windows): python server.py
comando (Linux): python3 server.py

## Utilização da classe java criada
<hr>
Instanciando o gerador de números, e um exemplo de utilização. Quanto mais perto de 499 o número passado como parâmetro para gerarNumeroNormal, menor o número trazido
```
import br.unesp.rc.poooficina.AI;
Generator gen = new Generator();
float val = gen.gerarNumeroNormal(100); 
```

Instanciando a AI e um exemplo de utilização. A resposta será 0 ou 1, se 1, o número faz parte da dist. Normal (ta funcionando o componente), se não, o número não faz parte da dist. Normal (ta quebrado o componente).
     
```
import br.unesp.rc.poooficina.Generator;
AI ai = new AI();
float answer = ai.testarValor(val);
System.out.println(answer);
```

Adicione os códigos na classe que você desejar. Importe 