insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Tailandesa');
insert into cozinha (id, nome) values (4, 'Francesa');
insert into cozinha (id, nome) values (5, 'Inglesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ("Sanji restaurantes", 5.99, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ("Baratiê", 3.99, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ("Souma family", 6.99, 4);

insert into permissao (nome, descricao) values ("Administrador", "Tem acesso a tudo")
insert into permissao (nome, descricao) values ("Usuario", "Tem acesso as funcionalidades padrões")

insert into estado (nome) values ('Maranhão')
insert into estado (nome) values ("São Paulo")
insert into estado (nome) values ("Rio de janeiro")
insert into estado (nome) values ('Minas Gerais')

insert into cidade (nome, estado_id) values ("São Luís", 1)
insert into cidade (nome, estado_id) values ("São Paulo", 2)
insert into cidade (nome, estado_id) values ("Rio de janeiro", 3)
insert into cidade (nome, estado_id) values ("Ouro Preto", 4)
