<h1>Deployment</h1>

O Deployment é fundamental para termos um fluxo da aplicação, começando no seu estágio de desenvolvimento até o ambiente de produção, sendo necessário integrar diversas tecnologias para o processo de “deployment”. O processo por completo foi divido nas seguintes camadas: “Acesso”, “Deploy” e “Produção”.
##

<p align="center">
  <img src="https://i.imgur.com/ggCugeI_d.webp?maxwidth=760&fidelity=grand">
</p>

<h1>Camada de Acesso</h1>

A camada de acesso é responsável por disponibilizar os serviços hospedados no Servidor de Produção para a internet através de uma instância EC2. Essa camada também é utilizada para proteger a conexão da rede local x rede nuvem, fazer bloqueios de serviços que não podem ser acessados diretamente da internet e monitorar o tráfego da instância.

<p align="center">
  <img src="https://i.imgur.com/5WRfimW.png">
</p>

<h1>Camada de Deploy</h1>

A camada de produção é responsável por pegar o código-fonte de produção da aplicação, fazer a construção da imagem Docker através do GitHub Actions, usando o Maven para build do executável da aplicação dentro da Imagem, após o processo de construção, o GitHub Actions envia a imagem Docker para DockerHub, onde é utilizado pelo Servidor de Produção para subir os contêineres da aplicação.

<p align="center">
  <img src="https://i.imgur.com/sYh3DRR.png">
</p>

<h1>Camada de Produção</h1>

A camada de produção é composta pelo servidor onde está hospedado o Web Server do NGINX, onde vai fazer a rota para os contêineres da API de status e Social-Media-API e a instância do banco de dados (MongoDB). Essa camada é responsável por manter os web services ativos e disponíveis.
<p align="center">
  <img src="https://i.imgur.com/hHjHN0C.png">
</p>

<h1>Resultado</h1>

Com os esforços das camadas anteriores para a criação e geração da aplicação até subir os serviços no servidor local e publicar na internet, foi possível acessar a API de qualquer lugar a partir do front-end adequado.

<p align="center">
  <img src="https://i.imgur.com/1PzXNkx.png">
</p>

<h1>Disclaimer</h1>

Esse projeto foi projetado do jeito que está com o intuito de utilizar diferentes ferramentas para a implantação do projeto, certamente existem jeitos melhores de fazer esse tipo de implantação, porém, foi divertido explorar mais a fundo todas essas ferramentas.
