# API do Troféu Caetano
API para gerenciar os dados (CRUD) da aplicação do troféu caetano. É um projeto para gerenciar a pontuação de jogadores em jogos de adivinhação de palavras.
Exemplo de jogos suportados: Term.ooo e Letreco.

# Banco de dados
Precisaremos de 3 tabelas, pelo menos por enquanto, para registrar os dados da aplicação do Troféu Caetano.
Jogadores - terá ID, Nome e Foto
Jogo - terá ID, Nome e Icone
Apontamentos - Terá ID, IDJogador, IDJogo e Tentativas

# Arquitetura
Teremos esse backend em java
Banco de dados mysql
Aplicação angular para FED