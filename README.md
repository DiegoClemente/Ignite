# Projeto API de Cursos de Programação

Bem-vindo ao projeto de API de uma empresa fictícia de cursos de programação! Aqui você encontrará todas as informações necessárias para entender e utilizar esta API.

# Sobre o Projeto
Este projeto consiste em uma API desenvolvida em Spring Boot que se comunica com um banco de dados PostgreSQL em um contêiner Docker. Foram utilizadas tecnologias como Lombok, JPA e Insomnia para facilitar o desenvolvimento e a interação com a API.

# Funcionalidades
A API possui as seguintes funcionalidades:

Criação de um novo curso: Permite criar um novo curso especificando o nome e a categoria.
Listagem de todos os cursos: Retorna todos os cursos salvos no banco de dados.
Atualização de um curso pelo ID: Permite atualizar o nome e/ou a categoria de um curso especificando seu ID.
Remoção de um curso pelo ID: Remove um curso do banco de dados pelo seu ID.
Marcação de um curso como ativo ou inativo: Alterna o status de ativo/inativo de um curso.

# Estrutura da Task (Curso)
<ol>
  <li>id: Identificador único de cada curso.</li>
  <li>name: Nome do curso.</li>
  <li>category: Categoria do curso.</li>
  <li>active: Define se o curso está ativo ou não.</li>
  <li>created_at: Data de quando o curso foi criado.</li>
  <li>updated_at: Data de quando o curso foi atualizado pela última vez.</li>
</ol>


# Rotas
<ul>
  <li>POST - /cursos: Cria um novo curso no banco de dados. Deve-se enviar os campos name e category no corpo da requisição. Os campos id, created_at e updated_at são preenchidos automaticamente.</li>
  <li>GET - /cursos: Retorna todos os cursos salvos no banco de dados. Permite busca/filtro por name e category.</li>
  <li>PUT - /cursos/:id: Atualiza um curso pelo seu ID. Deve-se enviar no corpo da requisição o name e/ou category a serem atualizados.</li>
  <li>DELETE - /cursos/:id: Remove um curso pelo seu ID.</li>
  <li>PATCH - /cursos/:id/active: Alterna o status de ativo/inativo de um curso.  </li>
</ul>

# Como Executar
Para executar o projeto localmente, siga estas etapas:

Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.<br><br>
Clone este repositório.<br><br>
Execute docker-compose up na raiz do projeto para iniciar o banco de dados PostgreSQL.<br><br>
Inicie a aplicação Spring Boot.


# Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir um issue ou enviar um pull request com melhorias, correções de bugs ou novas funcionalidades.

# Autor
Este projeto foi desenvolvido por Diego Clemente.
