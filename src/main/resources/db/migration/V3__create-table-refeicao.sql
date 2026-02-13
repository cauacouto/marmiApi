create table refeicoes(

   id char(36) primary key,



nome VARCHAR (255) not null ,
  descricao VARCHAR (255),

 calorias DOUBLE PRECISION,

 proteinas DOUBLE PRECISION,

 gorduras DOUBLE PRECISION,

  preco DECIMAL (10,2),

  ativo BOOLEAN default TRUE





);