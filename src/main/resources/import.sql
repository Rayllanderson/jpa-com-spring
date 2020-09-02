insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Tailandesa');
insert into cozinha (id, nome) values (4, 'Francesa');
insert into cozinha (id, nome) values (5, 'Inglesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ("Sanji restaurantes", 5.99, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ("Baratiê", 3.99, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ("Souma family", 6.99, 4);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into estado (nome) values ('Maranhão')
insert into estado (nome) values ("São Paulo")
insert into estado (nome) values ("Rio de janeiro")
insert into estado (nome) values ('Minas Gerais')

insert into cidade (nome, estado_id) values ("São Luís", 1)
insert into cidade (nome, estado_id) values ("São Paulo", 2)
insert into cidade (nome, estado_id) values ("Rio de janeiro", 3)
insert into cidade (nome, estado_id) values ("Ouro Preto", 4)

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1,2), (2,1), (3,2), (3,1)