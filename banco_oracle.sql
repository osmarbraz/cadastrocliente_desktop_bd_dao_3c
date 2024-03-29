--  -------------------------------------------------- 
--  Generated by Enterprise Architect Version 8.0.863
--  Created On : segunda-feira, 19 novembro, 2012 
--  DBMS       : Oracle 
--  -------------------------------------------------- 

DROP TABLE Cliente CASCADE CONSTRAINTS;
CREATE TABLE Cliente
(
	clienteID  NUMBER(38) CONSTRAINT NN_CLIENTE_CLIENTEID NOT NULL,    -- Identificador da tabela Cliente. 
	nome       VARCHAR2(100),    -- Nome do Cliente. 
	cpf        VARCHAR(11) CONSTRAINT NN_CLIENTE_CPF NOT NULL    -- CPF do cliente. 
);

COMMENT ON TABLE Cliente IS 'Tabela que armazena os dados de Cliente.';
COMMENT ON COLUMN Cliente.clienteID  IS 'Identificador da tabela Cliente.';
COMMENT ON COLUMN Cliente.nome       IS 'Nome do Cliente.';
COMMENT ON COLUMN Cliente.cpf        IS 'CPF do cliente.';

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente PRIMARY KEY (clienteID);

ALTER TABLE Cliente ADD CONSTRAINT Uk_Cliente_cpf UNIQUE (cpf);