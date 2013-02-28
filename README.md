onzevencedor
============

Projeto de Integração Maven, JSF 2, Spring e Hibernate.

Script para criação das tabelas do banco, sendo que o nome do banco é: onzeVencedorDB.

CREATE TABLE `Atleta` (
  `IDF_ATLETA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(40) NOT NULL,
  `DTA_NASCIMENTO` date NOT NULL,
  `IDF_CLUBE` int(11) NOT NULL,
  `IDF_POSICAO` int(11) NOT NULL,
  PRIMARY KEY (`IDF_ATLETA`),
  KEY `FK_CLUBE_ATLETA` (`IDF_CLUBE`),
  CONSTRAINT `FK_CLUBE_ATLETA` FOREIGN KEY (`IDF_CLUBE`) REFERENCES `Clube` (`IDF_CLUBE`)
) ENGINE=InnoDB

CREATE TABLE `Clube` (
  `IDF_CLUBE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(40) NOT NULL,
  PRIMARY KEY (`IDF_CLUBE`)
) ENGINE=InnoDB
