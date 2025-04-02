
USE banco;

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
    tipo_usuario ENUM('Gerente', 'Vendedor', 'ADMIN') NOT NULL,
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

-- Tabela de pedidos
CREATE TABLE pedidos (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cliente_id INT UNSIGNED NOT NULL,
    funcionario_id INT UNSIGNED NOT NULL,
    total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    status ENUM('Pendente', 'Pago', 'Cancelado') NOT NULL DEFAULT 'Pendente',
    cadastrado DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    editado DATETIME DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_pedidos_clientes FOREIGN KEY (cliente_id)
        REFERENCES clientes (id),
    CONSTRAINT fk_pedidos_vendedores FOREIGN KEY (vendedor_id)
        REFERENCES usuarios (id)
);

-- Tabela de itens do pedido
CREATE TABLE itens_pedido (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    pedido_id INT UNSIGNED NOT NULL,
    produto_id INT UNSIGNED NOT NULL,
    quantidade INT UNSIGNED NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_itens_pedido_pedidos FOREIGN KEY (pedido_id)
        REFERENCES pedidos (id),
    CONSTRAINT fk_itens_pedido_produtos FOREIGN KEY (produto_id)
        REFERENCES produtos (id)
);
