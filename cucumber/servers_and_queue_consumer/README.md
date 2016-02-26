# Dojo Cucumber

## Ferramentas Utilizadas

- __Cucumber__;
- __Rspec__ para fazer os _assertions_;
- __Guard__ para monitorar os arquivos modificados e executar os testes;
- __Capybara__ para fazer a manipulação em páginas html.

## Objetivo

O objetivo do dojo é postar um conteúdo em uma fila do rabbitmq pela
interface administrativa e após isso recuperar o mesmo conteúdo por 
um serviço que responde em http://localhost:4567/api/\<nome\_do\_arquivo\>.

Para fosse fácil subir esse mecanismo foram criados dois scripts
em ruby que estão dentro do diretório __servers__. Um sobe
um consumer do rabbitmq e o outro sobe um server em sinatra.
Para que os testes possam ser realizados será necessário rodar
os dois scripts.

O nome da fila que o consumer escuta é __dojo__.

Para realização da request ao serviço será utilizado a gem __HTTParty__.

## Documentação

Ruby Guia do Why: [http://why.carlosbrando.com/](http://why.carlosbrando.com/)

Capybara Cheatsheet: [https://upcase.com/test-driven-rails-resources/capybara.pdf](https://upcase.com/test-driven-rails-resources/capybara.pdf)

HTTParty: [https://github.com/jnunemaker/httparty](https://github.com/jnunemaker/httparty) 

RSpec Cheatsheet: [https://www.anchor.com.au/wp-content/uploads/rspec_cheatsheet_attributed.pdf](https://www.anchor.com.au/wp-content/uploads/rspec_cheatsheet_attributed.pdf)

Capybara + Cucumber: [http://www.rubydoc.info/github/jnicklas/capybara#using-capybara-with-cucumber](http://www.rubydoc.info/github/jnicklas/capybara#using-capybara-with-cucumber)


