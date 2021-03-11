DROP TABLE IF EXISTS `facultad`;
CREATE TABLE `facultad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;



DROP TABLE IF EXISTS `equipos`;
CREATE TABLE `equipos` (
  `numserie` char(4) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `facultad` INT NOT NULL,
  PRIMARY KEY (`numserie`),
  CONSTRAINT `facultad_FK_1` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `investigadores`;
CREATE TABLE `investigadores` (
  `dni` varchar(8) NOT NULL,
  `nomapels` varchar(100) NOT NULL,
  `facultad` INT NOT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `facultad_1` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `numserie` char(4) NOT NULL,
  `comienzo` DATETIME NOT NULL,
  `fin` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `investigador_FK_1` FOREIGN KEY (`dni`) REFERENCES `investigadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `equipo_FK_1` FOREIGN KEY (`numserie`) REFERENCES `equipos` (`numserie`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

INSERT INTO facultad (nombre) values ('Oxford');
INSERT INTO facultad (nombre) values ('Mid');

INSERT INTO equipos (numserie,nombre,facultad) values ('ADEC','Equipo 1',1);
INSERT INTO equipos (numserie,nombre,facultad) values ('BBBB','Equipo 2',2);

INSERT INTO investigadores (dni,nomapels,facultad) VALUES ('12345678','David Lascorz',1);
INSERT INTO investigadores (dni,nomapels,facultad) VALUES ('22222222','Jorge Lopez',2);

INSERT INTO reserva (dni,numserie,comienzo,fin) VALUES ('12345678','1234','2019-03-01','2020-10-03');
INSERT INTO reserva (dni,numserie,comienzo,fin) VALUES ('22222222','1235','2019-05-01','2020-09-03');
