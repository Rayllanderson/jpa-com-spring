insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Tailandesa');
insert into cozinha (id, nome) values (4, 'Francesa');
insert into cozinha (id, nome) values (5, 'Inglesa');

insert into forma_pagamento (descricao) values ('Débito')
insert into forma_pagamento (descricao) values ('Crédito')
insert into forma_pagamento (descricao) values ("A Vista")

insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ("Sanji restaurantes", 5.99, 1, 1);
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ("Baratiê", 3.99, 2, 2);
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ("Souma family", 6.99, 4, 3);

