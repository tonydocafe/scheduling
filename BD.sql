
USE bancoteste;


CREATE TABLE funcionario (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
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
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE agendamentos (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cliente_id INT UNSIGNED NOT NULL,
    funcionario_id INT UNSIGNED NOT NULL,
    servico_id INT UNSIGNED NOT NULL,
    marcado varchar(25) DEFAULT NULL,
    hora varchar(25) DEFAULT NULL,
    PRIMARY KEY (id),
    
    CONSTRAINT fk_pedidos_servico FOREIGN KEY (servico_id)
        REFERENCES servico (id),
    CONSTRAINT fk_pedidos_clientes FOREIGN KEY (cliente_id)
        REFERENCES clientes (id),
    CONSTRAINT fk_pedidos_funcionario FOREIGN KEY (funcionario_id)
        REFERENCES funcionario (id)
    
);

