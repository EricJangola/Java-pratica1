create table categoria (codigo int primary key auto_increment, nome varchar(100));
create table produto (codigo int primary key auto_increment, nome varchar(100), preco varchar(100), codCategoria int);
ALTER TABLE produto ADD CONSTRAINT fk_categoria FOREIGN KEY ( codCategoria ) REFERENCES categoria ( codigo ) ;