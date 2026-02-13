CREATE TABLE pedido (
                        id BIGINT PRIMARY KEY AUTO_INCREMENTE
                        usuario_id BIGINT,
                        status VARCHAR(50),
                        valor_total DECIMAL(10,2),
                        data_criacao TIMESTAMP,
                        FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
