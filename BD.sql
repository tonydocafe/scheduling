
USE bancoteste;


CREATE TABLE funcionario (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE ,
    telefone VARCHAR(15)  UNIQUE,
    email VARCHAR(100)  UNIQUE,
    login VARCHAR(50) UNIQUE,
    password VARCHAR(100) NOT NULL,
    nascimento DATE ,
    endereço VARCHAR(100),
    cargo VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE servico (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    descricao VARCHAR(255) DEFAULT NULL,
    preco DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (id)
);


CREATE TABLE clientes (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) ,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    endereço VARCHAR(100) ,
    debito BOOLEAN,
    nascimento DATE ,
    PRIMARY KEY (id)
);


CREATE TABLE agendamentos (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cliente_id INT UNSIGNED NOT NULL,
    funcionario_id INT UNSIGNED NOT NULL,
    servico_id INT UNSIGNED NOT NULL,
    total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    marcado DATE DEFAULT NULL,
    PRIMARY KEY (id),
    
    CONSTRAINT fk_pedidos_servico FOREIGN KEY (servico_id)
        REFERENCES servico (id),
    CONSTRAINT fk_pedidos_clientes FOREIGN KEY (cliente_id)
        REFERENCES clientes (id),
    CONSTRAINT fk_pedidos_funcionario FOREIGN KEY (funcionario_id)
        REFERENCES funcionario (id)
    
);

