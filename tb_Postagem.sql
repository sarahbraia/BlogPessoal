use blog_pessoal;
show tables;
select*from postagem;
select*from tb_tema;

insert into tb_tema values (1, "Assunto");
insert into tb_tema values (2, "Pedidos");

insert into postagem (id, ano, date, texto, titulo, tema_id)values (null, 2010, null, "Dúvida", "solicitações", 2);
insert into postagem (id, ano, date, texto, titulo, tema_id)values (null, 2011, null, "Preço", "solicitações", 2);
insert into postagem (id, ano, date, texto, titulo, tema_id) values (null, 2012, null, "Preço", "solicitações", 2);
insert into postagem (id, ano, date, texto, titulo, tema_id) values (null, 2013, null, "Preço", "solicitações", 2);
insert into postagem (id, ano, date, texto, titulo, tema_id)values (null, 2014, null, "Preço", "solicitações", 2);


SELECT * FROM blog_pessoal.postagem;

