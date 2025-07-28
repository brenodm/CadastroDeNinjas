-- Migrations para adicionar a coluna de rank na Tabela de Cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);