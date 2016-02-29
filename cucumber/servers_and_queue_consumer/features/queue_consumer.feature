Feature: put message in the queue and retrieve results by service

Background:
Given usuário logado "guest" e senha "guest"

Scenario Outline:postar mensagem na fila "dojo" e verificar se o valor foi salvo
When acessar a fila "dojo"
And inserir o header <header> igual a <value>
And postar conteúdo <payload> na fila dojo
Then recuperar arquivo <value> com conteúdo <payload>

Examples:
|header|value|payload|
|"name" |"arquivoX"|"X"|
|"name"| "outro_arquivoX"| "outroX"|


Scenario:postar mensagem inválida na fila e verificar resultado
When acessar a fila "dojo"
And inserir o header "name" igual a "teste"
And postar conteúdo "Y" na fila dojo
Then não recuperar arquivo "teste"
And verificar na fila "erro" o nome do arquivo "teste"
