
USE bancoteste;

CREATE TABLE funcionario (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(15) DEFAULT NULL,
    email VARCHAR(100) DEFAULT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    nascimento DATE NOT NULL,
    endereço VARCHAR(100) UNIQUE NOT NULL,
    cargo VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE servico (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) DEFAULT NULL,
    preco DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (id)
);


CREATE TABLE clientes (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(15) DEFAULT NULL,
    email VARCHAR(100) DEFAULT NULL,
    endereço VARCHAR(100) UNIQUE NOT NULL,
    debito BOOLEAN() NOT NULL,
    nascimento DATE NOT NULL,
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
    CONSTRAINT fk_pedidos_funcionarios FOREIGN KEY (funcionarios_id)
        REFERENCES funcionarios (id)
    
);

