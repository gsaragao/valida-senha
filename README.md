# Valida Senha API

Esta API Web fornece serviços REST para validação de senha forte e fraca através de JSON.
Ela foi desenvolvida com:

* Spring Boot 2.2.6
* Springfox Swagger2 2.9.2
* Junit 5

#### Passos para utilizar a API:

1) Dentro do diretório raiz da aplicação, execute a instrução abaixo para iniciar o servidor:

```
$ mvn spring-boot:run
```

2) Para acessar os endpoints via GET: 

* Validação de senha forte: http://localhost:8080/senhaforte
* Validação de senha fraca: http://localhost:8080/senhafraca

3) Passar o parâmetro "senha" no JSON:

```
{
    "senha": "12345678"
}
```
4) Retornará true se sua senha for validada com sucesso e false se fracassar na validação.

5) É necessário autenticar para ter acesso aos serviços:

```
Basic Auth

user: senha
pass: 1234
```

### Documentação

- Javadoc = No diretório da aplicação tem uma pasta 'doc' com a documentação gerada.
- APIs Rest = Documentação gerada via Swagger, para acessar -> http://localhost:8080/swagger-ui.html 

### Testes de Acesso

Os testes foram feitos via Postman e Swagger.

Para quem tem o Ruby na máquina, cria um arquivo com nome app.rb e coloca o código abaixo:

```
require 'rest-client'
require 'json'

puts 'Senhas fortes'

senhas_fortes = ["", "aa", "ab", "AAAbbbCc", "AbTp9!foo"]

for senha in senhas_fortes
	response = RestClient::Request.execute(:method => 'post', :url => 'http://localhost:8080/senhaforte', 
	:payload =>JSON.generate({"senha" => senha}), :headers => {:content_type=>"application/json"}, 
	:user => 'senha', :password => '1234')
	print "#{response.code} - #{response.body} - #{senha}"
	puts 
end

puts
puts 'Senhas fracas'

senhas_fracas = ["", "aa", "12a ", "BBBB", "Ab11"]

for senha in senhas_fracas
	response = RestClient::Request.execute(:method => 'post', :url => 'http://localhost:8080/senhafraca', 
	:payload =>JSON.generate({"senha" => senha}), :headers => {:content_type=>"application/json"}, 
	:user => 'senha', :password => '1234')
	print "#{response.code} - #{response.body} - #{senha}"
	puts 
end

```
Para executar, no mesmo diretório do arquivo app.rb:

```
$ ruby app.rb
```
Resultado esperado:

```
Senhas fortes
200 - false - 
200 - false - aa
200 - false - ab
200 - false - AAAbbbCc
200 - true - AbTp9!foo

Senhas fracas
200 - false - 
200 - false - aa
200 - true - 12a 
200 - false - BBBB
200 - true - Ab11
```
