CREATE TABLE IF NOT EXISTS athena_telefone(
    telefoneID INT PRIMARY KEY AUTO_INCREMENT, 
    telefone TEXT NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_email(
    emailID INT PRIMARY KEY AUTO_INCREMENT, 
    email TEXT NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_contato(
    contatoID INT PRIMARY KEY AUTO_INCREMENT,
    telefoneID INT NOT NULL,
    emailID INT NOT NULL,

    FOREIGN KEY(telefoneID) REFERENCES athena_telefone(telefoneID),
    FOREIGN KEY(emailID) REFERENCES athena_email(emailID)
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_pais(
    paisID INT PRIMARY KEY AUTO_INCREMENT, 
    pais TEXT NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_estado(
    estadoID INT PRIMARY KEY AUTO_INCREMENT, 
    estado TEXT NOT NULL,
    paisID INT NOT NULL,

    FOREIGN KEY(paisID) REFERENCES athena_pais(paisID)
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_cidade(
    cidadeID int PRIMARY KEY AUTO_INCREMENT, 
    cidade TEXT NOT NULL,
    estadoID INT NOT NULL,

    FOREIGN KEY(estadoID) REFERENCES athena_estado(estadoID)
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_endereco(
    enderecoID INT PRIMARY KEY AUTO_INCREMENT, 
    cep TEXT NOT NULL,
    logradouro TEXT NOT NULL,
    bairro TEXT NOT NULL,
    numero TEXT NOT NULL,
    complemento TEXT NOT NULL,
    cidadeID INT NOT NULL,

    FOREIGN KEY(cidadeID) REFERENCES athena_cidade(cidadeID)
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_rg(
    rgID INT PRIMARY KEY AUTO_INCREMENT,
    rg TEXT NOT NULL, 
    dataExpedicao TEXT NOT NULL,
    orgaoExpedidor TEXT NOT NULL,
    nomeMae TEXT NOT NULL,
    nomePai TEXT NOT NULL,
    nome TEXT NOT NULL,
    naturalidade INT NOT NULL,
    uf INT NOT NULL,

    FOREIGN KEY(naturalidade) REFERENCES athena_cidade(cidadeID),
    FOREIGN KEY(uf) REFERENCES athena_estado(estadoID)
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_pessoa(
    pessoaID INT PRIMARY KEY AUTO_INCREMENT,
    cpf TEXT NOT NULL,
    primeiroNome TEXT NOT NULL,
    ultimoNome TEXT NOT NULL,
    sexo TEXT NOT NULL,
    corRaca TEXT NOT NULL,
    possuiNecessidadesEspecificas BIT NOT NULL,
    contatoID INT NOT NULL,
    enderecoID INT NOT NULL,
    rgID INT NOT NULL,
    
    FOREIGN KEY(contatoID) REFERENCES athena_contato(contatoID),
    FOREIGN KEY(enderecoID) REFERENCES athena_endereco(enderecoID),
    FOREIGN KEY(rgID) REFERENCES athena_rg(rgID)
) AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS athena_usuario(
    pessoaID INT PRIMARY KEY AUTO_INCREMENT, 
    login TEXT NOT NULL,
    senha VARCHAR(16) NOT NULL,
    tipoUsuarioID ENUM('aluno', 'admin', 'professor', 'coordenacao') NOT NULL,

    FOREIGN KEY(pessoaID) REFERENCES athena_pessoa(pessoaID)
) AUTO_INCREMENT = 1;


DROP TABLE athena_usuario;
DROP TABLE athena_pessoa;
DROP TABLE athena_rg;
DROP TABLE athena_endereco;
DROP TABLE athena_cidade;
DROP TABLE athena_estado;
DROP TABLE athena_pais;
DROP TABLE athena_contato;
DROP TABLE athena_email;
DROP TABLE athena_telefone;


DELIMITER $$
    DROP PROCEDURE IF EXISTS getPessoa $$
    CREATE PROCEDURE getPessoa()
    BEGIN
        SELECT p.pessoaID AS pessoaID, p.cpf AS CPF, p.primeiroNome AS primeiroNome, p.ultimoNome AS ultimoNome, p.possuiNecessidadesEspecificas AS possuiNecessidadesEspecificas, p.sexo AS sexo, p.corRaca AS corRaca, 
        rg.rgID AS rgID, rg.rg AS rg, rg.nome AS nome, rg.dataExpedicao AS dataExpedicao, rg.orgaoExpedidor AS orgaoExpedidor, rg.nomeMae AS nomeMae, rg.nomePai AS nomePai, rg.naturalidade AS naturalidade, rg.uf AS uf,
        co.contatoID AS contatoID,
        t.telefoneID AS telefoneID, t.telefone AS telefone,
        e.emailID AS emailID, e.email AS email,
        en.enderecoID AS enderecoID, en.cep AS cep, en.logradouro AS logradouro, en.bairro AS bairro, en.numero AS numero, en.complemento AS complemento,
        c.cidadeID AS cidadeID, c.cidade AS cidade,
        es.estadoID AS estadoID, es.estado AS estado,
        pa.paisID AS paisID, pa.pais AS pais
        FROM athena_pessoa AS p
        JOIN athena_contato AS co USING(contatoID)
        JOIN athena_telefone AS t USING(telefoneID)
        JOIN athena_email AS e USING(emailID)
        JOIN athena_rg AS rg USING(rgID) 
        JOIN athena_endereco AS en USING(enderecoID)
        JOIN athena_cidade AS c USING(cidadeID)
        JOIN athena_estado AS es USING(estadoID)
        JOIN athena_pais AS pa USING(paisID);
    END $$
DELIMITER ;

CALL getPessoa();


