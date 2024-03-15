-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 09 Juin 2020 à 02:12
-- Version du serveur: 5.1.37
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `pfe2019`
--

-- --------------------------------------------------------

--
-- Structure de la table `absenceetudiant`
--

CREATE TABLE IF NOT EXISTS `absenceetudiant` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `SeanceID` int(11) NOT NULL,
  `Justification` tinyint(1) DEFAULT NULL,
  `Motif` varchar(255) DEFAULT NULL,
  `DocJustifAbsEtudiantID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `DocJustifAbsEtudiantID` (`DocJustifAbsEtudiantID`),
  KEY `SeanceID` (`SeanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `absenceetudiant`
--


-- --------------------------------------------------------

--
-- Structure de la table `absencepersonnel`
--

CREATE TABLE IF NOT EXISTS `absencepersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DocJustifAbsPersonnelID` int(11) DEFAULT NULL,
  `PersonnelUtilisateurID` int(11) NOT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Duree` smallint(6) DEFAULT NULL,
  `DateReprise` date DEFAULT NULL,
  `Motif` varchar(255) DEFAULT NULL,
  `Justification` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `DocJustifAbsPersonnelID` (`DocJustifAbsPersonnelID`),
  KEY `PersonnelUtilisateurID` (`PersonnelUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `absencepersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `absenceprofesseur`
--

CREATE TABLE IF NOT EXISTS `absenceprofesseur` (
  `ID` int(11) NOT NULL,
  `DocJustifAbsPersonnelID` int(11) DEFAULT NULL,
  `Justification` tinyint(1) DEFAULT NULL,
  `Motif` varchar(255) DEFAULT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `SeanceID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `DocJustifAbsPersonnelID` (`DocJustifAbsPersonnelID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `SeanceID` (`SeanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `absenceprofesseur`
--


-- --------------------------------------------------------

--
-- Structure de la table `acrivitepedagogique`
--

CREATE TABLE IF NOT EXISTS `acrivitepedagogique` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `acrivitepedagogique`
--


-- --------------------------------------------------------

--
-- Structure de la table `actualite`
--

CREATE TABLE IF NOT EXISTS `actualite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UtilisateurID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Objet` varchar(255) DEFAULT NULL,
  `Texte` varchar(255) DEFAULT NULL,
  `Priorite` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `DateExpiritation` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `actualite`
--


-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) NOT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`ID`, `Code`, `DateDebut`, `DateFin`) VALUES
(1, '2017/2018', '2017-09-05', '2018-06-29'),
(2, '2018/2019', '2018-09-04', '2019-06-28'),
(3, '2019/2020', '2019-09-04', '2020-06-30'),
(4, '2020/2021', '2020-09-03', '2020-06-30');

-- --------------------------------------------------------

--
-- Structure de la table `anneescolairecourante`
--

CREATE TABLE IF NOT EXISTS `anneescolairecourante` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AnneeScolaireID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `AnneeScolaireID` (`AnneeScolaireID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `anneescolairecourante`
--

INSERT INTO `anneescolairecourante` (`ID`, `AnneeScolaireID`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE IF NOT EXISTS `annonce` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UtilisateurID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Objet` varchar(255) DEFAULT NULL,
  `Texte` varchar(255) DEFAULT NULL,
  `Priorite` varchar(255) DEFAULT NULL,
  `DateExpiration` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `annonce`
--


-- --------------------------------------------------------

--
-- Structure de la table `annonce_classe`
--

CREATE TABLE IF NOT EXISTS `annonce_classe` (
  `AnnonceID` int(11) NOT NULL,
  `ClasseID` int(11) NOT NULL,
  PRIMARY KEY (`AnnonceID`,`ClasseID`),
  KEY `AnnonceID` (`AnnonceID`),
  KEY `ClasseID` (`ClasseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `annonce_classe`
--


-- --------------------------------------------------------

--
-- Structure de la table `avancementpersonnel`
--

CREATE TABLE IF NOT EXISTS `avancementpersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PersonnelUtilisateurID` int(11) DEFAULT NULL,
  `Echelle` varchar(255) DEFAULT NULL,
  `Echelon` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonnelUtilisateurID` (`PersonnelUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `avancementpersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `avancementtache`
--

CREATE TABLE IF NOT EXISTS `avancementtache` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TacheID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `TempsPasse` smallint(6) DEFAULT NULL,
  `TempsRestant` smallint(6) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TacheID` (`TacheID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `avancementtache`
--


-- --------------------------------------------------------

--
-- Structure de la table `avertissement`
--

CREATE TABLE IF NOT EXISTS `avertissement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Objet` varchar(255) DEFAULT NULL,
  `Desciption` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `avertissement`
--


-- --------------------------------------------------------

--
-- Structure de la table `bloc`
--

CREATE TABLE IF NOT EXISTS `bloc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `bloc`
--


-- --------------------------------------------------------

--
-- Structure de la table `cadre`
--

CREATE TABLE IF NOT EXISTS `cadre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `cadre`
--

INSERT INTO `cadre` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, '01', 'Professeurs de l''enseignement primaire', 'أستاذ التعليم الابتدائي'),
(2, '02', 'Professeurs de l''enseignement secondaire collégial', 'أستاذ التعليم الثانوي الإعدادي'),
(3, '03', 'Professeurs de l''enseignement secondaire qualifiant', 'أستاذ التعليم الثانوي التأهيلي'),
(4, '04', 'Professeurs agrégés de l''enseignement secondaire qualifiant', 'أستاذ مبرز للتعليم الثانوي التأهيلي'),
(5, '05', 'Intendant', 'ممون'),
(6, '52', 'Attaché pédagogique', 'ملحق تربوي'),
(7, '53', 'Attaché économique et administratif', 'ملحق الادارة والاقتصاد'),
(8, '54', 'Adjoint technique', 'مساعد تقني'),
(9, '66', 'Employé de bureau', 'كاتب');

-- --------------------------------------------------------

--
-- Structure de la table `cahierchargeprojet`
--

CREATE TABLE IF NOT EXISTS `cahierchargeprojet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `cahierchargeprojet`
--


-- --------------------------------------------------------

--
-- Structure de la table `cahiertexte`
--

CREATE TABLE IF NOT EXISTS `cahiertexte` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SeanceID` int(11) NOT NULL,
  `Texte` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SeanceID` (`SeanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `cahiertexte`
--


-- --------------------------------------------------------

--
-- Structure de la table `cahiertexte_acrivitepedagogique`
--

CREATE TABLE IF NOT EXISTS `cahiertexte_acrivitepedagogique` (
  `CahierTexteID` int(11) NOT NULL,
  `AcrivitePedagogiqueID` int(11) NOT NULL,
  PRIMARY KEY (`CahierTexteID`,`AcrivitePedagogiqueID`),
  KEY `CahierTexteID` (`CahierTexteID`),
  KEY `AcrivitePedagogiqueID` (`AcrivitePedagogiqueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `cahiertexte_acrivitepedagogique`
--


-- --------------------------------------------------------

--
-- Structure de la table `cahiertexte_concept`
--

CREATE TABLE IF NOT EXISTS `cahiertexte_concept` (
  `CahierTexteID` int(11) NOT NULL,
  `ConceptID` int(11) NOT NULL,
  PRIMARY KEY (`CahierTexteID`,`ConceptID`),
  KEY `ConceptID` (`ConceptID`),
  KEY `CahierTexteID` (`CahierTexteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `cahiertexte_concept`
--


-- --------------------------------------------------------

--
-- Structure de la table `caracteristique`
--

CREATE TABLE IF NOT EXISTS `caracteristique` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterielID` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Caracteristique` varchar(255) DEFAULT NULL,
  `Valeur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MaterielID` (`MaterielID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `caracteristique`
--


-- --------------------------------------------------------

--
-- Structure de la table `chapitre`
--

CREATE TABLE IF NOT EXISTS `chapitre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MatiereID` int(11) NOT NULL,
  `ModuleID` int(11) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `ModuleID` (`ModuleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `chapitre`
--


-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClasseGeneriqueID` int(11) NOT NULL,
  `AnneeScolaireID` int(11) NOT NULL,
  `Label` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `AnneeScolaireID` (`AnneeScolaireID`),
  KEY `ClasseGeneriqueID` (`ClasseGeneriqueID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `classe`
--

INSERT INTO `classe` (`ID`, `ClasseGeneriqueID`, `AnneeScolaireID`, `Label`) VALUES
(1, 1, 3, 'A'),
(2, 2, 3, 'A');

-- --------------------------------------------------------

--
-- Structure de la table `classegenerique`
--

CREATE TABLE IF NOT EXISTS `classegenerique` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NiveauID` int(11) NOT NULL,
  `FiliereID` int(11) NOT NULL,
  `CycleID` int(11) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `NiveauID` (`NiveauID`),
  KEY `FiliereID` (`FiliereID`),
  KEY `CycleID` (`CycleID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `classegenerique`
--

INSERT INTO `classegenerique` (`ID`, `NiveauID`, `FiliereID`, `CycleID`, `Description`) VALUES
(1, 1, 1, 2, '								    '),
(2, 2, 1, 2, '								    '),
(3, 1, 2, 2, '								    '),
(4, 2, 2, 2, '								    '),
(5, 1, 3, 2, '								    '),
(6, 2, 3, 2, '								    '),
(7, 1, 4, 2, '								    '),
(8, 2, 4, 2, '								    '),
(9, 1, 5, 2, '								    ');

-- --------------------------------------------------------

--
-- Structure de la table `classegunite`
--

CREATE TABLE IF NOT EXISTS `classegunite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClasseGeneriqueID` int(11) NOT NULL,
  `UniteID` int(11) NOT NULL,
  `NoteEliminatoire` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClasseGeneriqueID` (`ClasseGeneriqueID`),
  KEY `UniteID` (`UniteID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `classegunite`
--

INSERT INTO `classegunite` (`ID`, `ClasseGeneriqueID`, `UniteID`, `NoteEliminatoire`) VALUES
(1, 1, 1, 10),
(2, 1, 2, 10),
(3, 1, 3, 10),
(4, 2, 1, 10),
(5, 2, 2, 10),
(6, 2, 3, 10);

-- --------------------------------------------------------

--
-- Structure de la table `classe_demandephotocopie`
--

CREATE TABLE IF NOT EXISTS `classe_demandephotocopie` (
  `ClasseID` int(11) NOT NULL,
  `DemandePhotocopieID` int(11) NOT NULL,
  PRIMARY KEY (`ClasseID`,`DemandePhotocopieID`),
  KEY `DemandePhotocopieID` (`DemandePhotocopieID`),
  KEY `ClasseID` (`ClasseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `classe_demandephotocopie`
--


-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE IF NOT EXISTS `commentaire` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UtilisateurID` int(11) NOT NULL,
  `PublicationID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Texte` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UtilisateurID` (`UtilisateurID`),
  KEY `PublicationID` (`PublicationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `commentaire`
--


-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleID` int(11) NOT NULL,
  `UtilisateurID` int(11) DEFAULT NULL,
  `Login` varchar(255) DEFAULT NULL,
  `MotPass` varchar(255) DEFAULT NULL,
  `DateCreation` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `OnLine` tinyint(1) NOT NULL,
  `Statut` varchar(255) DEFAULT NULL,
  `CodeRecuperation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `RoleID` (`RoleID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`ID`, `RoleID`, `UtilisateurID`, `Login`, `MotPass`, `DateCreation`, `Etat`, `OnLine`, `Statut`, `CodeRecuperation`) VALUES
(1, 1, 1, 'anoiarazo2@gmail.com', 'AZOULAY', '2020-06-05', 'Active', 0, 'HorsLigne', NULL),
(2, 5, 2, '', '', '2020-06-05', 'Active', 0, 'HorsLigne', NULL),
(3, 1, 3, 'melhamdaoui888@gmail.com', 'EL HAMDAOUI', '2020-06-05', 'Active', 0, 'HorsLigne', NULL),
(4, 5, 4, '', '', '2020-06-05', 'Active', 0, 'HorsLigne', NULL),
(5, 1, 5, 'abdellah_zmarou@outlook.fr', 'ZMARROU', '2020-06-05', 'Active', 0, 'HorsLigne', NULL),
(6, 5, 6, '', '', '2020-06-05', 'Active', 0, 'HorsLigne', NULL),
(7, 1, 7, 'dodslim100@gmail.com', 'MRABET', '2020-06-06', 'Active', 0, 'HorsLigne', NULL),
(8, 5, 8, '', '', '2020-06-06', 'Active', 0, 'HorsLigne', NULL),
(9, 3, 9, 'chabbi@gmail.com', 'CHABBI', '2020-06-08', 'Active', 0, 'HorsLigne', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `concept`
--

CREATE TABLE IF NOT EXISTS `concept` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ChapitreID` int(11) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ChapitreID` (`ChapitreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `concept`
--


-- --------------------------------------------------------

--
-- Structure de la table `configurationmatiere`
--

CREATE TABLE IF NOT EXISTS `configurationmatiere` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClasseGUniteID` int(11) NOT NULL,
  `MatiereID` int(11) NOT NULL,
  `FormeEvaluationID` int(11) NOT NULL,
  `PeriodeID` int(11) NOT NULL,
  `VolumeHoraire` smallint(6) DEFAULT NULL,
  `HoraireS1` smallint(6) DEFAULT NULL,
  `HoraireS2` smallint(6) DEFAULT NULL,
  `NbreControles` smallint(6) DEFAULT NULL,
  `NoteEliminatoire` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClasseGUniteID` (`ClasseGUniteID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `PeriodeID` (`PeriodeID`),
  KEY `FormeEvaluationID` (`FormeEvaluationID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Contenu de la table `configurationmatiere`
--

INSERT INTO `configurationmatiere` (`ID`, `ClasseGUniteID`, `MatiereID`, `FormeEvaluationID`, `PeriodeID`, `VolumeHoraire`, `HoraireS1`, `HoraireS2`, `NbreControles`, `NoteEliminatoire`) VALUES
(1, 1, 1, 4, 1, 100, 2, 2, 3, 10),
(2, 1, 2, 4, 1, 100, 2, 2, 3, 10),
(3, 1, 3, 4, 1, 100, 2, 2, 3, 10),
(4, 1, 4, 4, 1, 100, 2, 2, 3, 10),
(5, 2, 5, 1, 1, 56, 2, 2, 3, 10),
(6, 2, 6, 1, 1, 200, 4, 4, 3, 10),
(7, 2, 7, 5, 1, 0, 0, 0, 3, 10),
(8, 2, 8, 5, 1, 0, 0, 0, 3, 10),
(9, 3, 9, 5, 1, 0, 0, 0, 3, 10),
(10, 4, 1, 4, 1, 100, 2, 2, 3, 10),
(11, 4, 2, 4, 1, 100, 2, 2, 3, 10),
(12, 4, 3, 4, 1, 100, 2, 2, 3, 10),
(13, 4, 4, 4, 1, 100, 2, 2, 3, 10),
(14, 5, 6, 1, 1, 200, 4, 4, 3, 10),
(15, 5, 8, 5, 1, 0, 0, 0, 3, 10),
(16, 6, 9, 5, 1, 0, 0, 0, 0, 10),
(17, 6, 11, 3, 1, 88, 4, 4, 0, 10),
(18, 6, 10, 3, 3, 0, 0, 0, 0, 10);

-- --------------------------------------------------------

--
-- Structure de la table `configurationmodule`
--

CREATE TABLE IF NOT EXISTS `configurationmodule` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ConfigurationMatiereID` int(11) NOT NULL,
  `ModuleID` int(11) NOT NULL,
  `PeriodeID` int(11) NOT NULL,
  `FormeEvaluationID` int(11) NOT NULL,
  `VolumeHoraire` smallint(6) DEFAULT NULL,
  `HoraireS1` smallint(6) DEFAULT NULL,
  `HoraireS2` smallint(6) DEFAULT NULL,
  `NbreControles` smallint(6) DEFAULT NULL,
  `NoteEliminatoire` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ConfigurationMatiereID` (`ConfigurationMatiereID`),
  KEY `ModuleID` (`ModuleID`),
  KEY `PeriodeID` (`PeriodeID`),
  KEY `FormeEvaluationID` (`FormeEvaluationID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Contenu de la table `configurationmodule`
--

INSERT INTO `configurationmodule` (`ID`, `ConfigurationMatiereID`, `ModuleID`, `PeriodeID`, `FormeEvaluationID`, `VolumeHoraire`, `HoraireS1`, `HoraireS2`, `NbreControles`, `NoteEliminatoire`) VALUES
(1, 7, 1, 2, 5, 28, 2, 0, 2, 6),
(2, 7, 2, 2, 4, 28, 2, 0, 2, 6),
(3, 7, 3, 3, 5, 56, 0, 4, 3, 6),
(4, 7, 4, 1, 5, 56, 2, 2, 3, 6),
(5, 7, 5, 1, 5, 56, 2, 2, 3, 6),
(6, 9, 6, 2, 5, 28, 2, 0, 2, 6),
(7, 9, 7, 3, 5, 56, 0, 4, 2, 6),
(8, 8, 13, 1, 5, 56, 2, 2, 3, 6),
(9, 8, 14, 1, 5, 56, 2, 2, 3, 6),
(10, 8, 16, 1, 5, 100, 2, 2, 3, 6),
(11, 8, 17, 2, 5, 28, 2, 0, 2, 6),
(12, 8, 18, 3, 5, 72, 0, 2, 2, 6),
(13, 15, 15, 1, 5, 88, 4, 4, 3, 10),
(14, 15, 16, 1, 5, 100, 2, 2, 3, 6),
(15, 15, 19, 1, 5, 44, 2, 2, 2, 6),
(16, 15, 18, 1, 5, 72, 2, 2, 3, 6),
(17, 16, 8, 1, 5, 44, 2, 2, 2, 6),
(18, 16, 9, 1, 5, 28, 2, 0, 2, 6),
(19, 16, 10, 3, 5, 16, 0, 2, 2, 6),
(20, 16, 11, 2, 5, 28, 2, 0, 2, 6),
(21, 16, 12, 3, 5, 16, 0, 2, 2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UtilisateurID` int(11) NOT NULL,
  `UtilisateurID2` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UtilisateurID` (`UtilisateurID`),
  KEY `UtilisateurID2` (`UtilisateurID2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `contact`
--


-- --------------------------------------------------------

--
-- Structure de la table `controle`
--

CREATE TABLE IF NOT EXISTS `controle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Comptabilise` tinyint(1) DEFAULT NULL,
  `MatiereID` int(11) NOT NULL,
  `ModuleID` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `DateDepotNotes` date DEFAULT NULL,
  `DatePassage` date DEFAULT NULL,
  `DatePlanifiee` date DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Duree` smallint(6) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `ClasseID` int(11) NOT NULL,
  `SalleID` int(11) NOT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `DocumentEvaluationID` int(11) DEFAULT NULL,
  `DocumentEvaluationID2` int(11) DEFAULT NULL,
  `FormeEvaluationID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `ModuleID` (`ModuleID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `DocumentEvaluationID` (`DocumentEvaluationID`),
  KEY `DocumentEvaluationID2` (`DocumentEvaluationID2`),
  KEY `FormeEvaluationID` (`FormeEvaluationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `controle`
--


-- --------------------------------------------------------

--
-- Structure de la table `coordination`
--

CREATE TABLE IF NOT EXISTS `coordination` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `AnneeScolaireID` int(11) NOT NULL,
  `FiliereID` int(11) NOT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `AnneeScolaireID` (`AnneeScolaireID`),
  KEY `FiliereID` (`FiliereID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `coordination`
--


-- --------------------------------------------------------

--
-- Structure de la table `couverturelivre`
--

CREATE TABLE IF NOT EXISTS `couverturelivre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `couverturelivre`
--


-- --------------------------------------------------------

--
-- Structure de la table `cycle`
--

CREATE TABLE IF NOT EXISTS `cycle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `cycle`
--

INSERT INTO `cycle` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'CSQ', 'Secondaire Qualifiant', 'الثانوي التأهيلي'),
(2, 'BTS', 'Brevet de Technicien Supérieur', 'شهادة التقني العالي');

-- --------------------------------------------------------

--
-- Structure de la table `demandedocetudiant`
--

CREATE TABLE IF NOT EXISTS `demandedocetudiant` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `TypeDocumentEtudiantID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `DateRetrait` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `TypeDocumentEtudiantID` (`TypeDocumentEtudiantID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `demandedocetudiant`
--


-- --------------------------------------------------------

--
-- Structure de la table `demandedocpersonnel`
--

CREATE TABLE IF NOT EXISTS `demandedocpersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PersonnelUtilisateurID` int(11) NOT NULL,
  `TypeDocumentPersonnelID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `DateRetrait` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonnelUtilisateurID` (`PersonnelUtilisateurID`),
  KEY `TypeDocumentPersonnelID` (`TypeDocumentPersonnelID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `demandedocpersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `demandephotocopie`
--

CREATE TABLE IF NOT EXISTS `demandephotocopie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ModuleID` int(11) DEFAULT NULL,
  `MatiereID` int(11) NOT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `TypeDocumentID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `DatePrevue` date DEFAULT NULL,
  `DateRetrait` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ModuleID` (`ModuleID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `TypeDocumentID` (`TypeDocumentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `demandephotocopie`
--


-- --------------------------------------------------------

--
-- Structure de la table `diplome`
--

CREATE TABLE IF NOT EXISTS `diplome` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeDiplomeID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TypeDiplomeID` (`TypeDiplomeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `diplome`
--

INSERT INTO `diplome` (`ID`, `TypeDiplomeID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 1, '1', NULL, 'ش.الدروس الإبتدائية'),
(2, 1, '2', NULL, 'ش.التعليم الثانوي'),
(3, 1, '3', NULL, 'البكالوريا أو ما يعادلها'),
(4, 1, '40', NULL, 'د.السلك الأول من الإجازة أو ما يعادلها '),
(5, 1, '41', NULL, 'الإجازة أو ما يعادلها'),
(6, 1, '42', NULL, 'د.الدراسات المعمقة'),
(7, 1, '43', NULL, 'ماستر'),
(8, 1, '44', NULL, 'دكتوراه'),
(9, 1, '80', NULL, 'شهادات أخرى'),
(10, 2, '1', NULL, 'ش.الأهلية التربوية'),
(11, 2, '3', NULL, 'ش.الدروس العادية'),
(12, 2, '20', NULL, 'ش.الأهلية التربوية المهنية'),
(13, 2, '21', NULL, 'امتحان التخرج من المركز التربوي الجهوي'),
(14, 2, '22', NULL, 'د.المدرسة العليا للأساتــــذة'),
(15, 2, '23', NULL, 'د.كلية علوم التربية'),
(16, 2, '24', NULL, 'إمتحان التخرج من السلك  الخاص بالمغرب'),
(17, 2, '25', NULL, 'إمتحان التخرج من السلك  الخاص بالخارج'),
(18, 2, '26', NULL, 'ش.الأهلية التربوية للتعليم الثانوي ( سلك 1)'),
(19, 2, '27', NULL, 'ش.الأهلية التربوية للتعليم الثانوي ( سلك 2)'),
(20, 2, '28', NULL, 'شهادات أخرى');

-- --------------------------------------------------------

--
-- Structure de la table `diplomepersonnel`
--

CREATE TABLE IF NOT EXISTS `diplomepersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SpecialiteID` int(11) NOT NULL,
  `Annee` varchar(255) DEFAULT NULL,
  `Etablissement` varchar(255) DEFAULT NULL,
  `DiplomeID` int(11) NOT NULL,
  `PersonnelUtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SpecialiteID` (`SpecialiteID`),
  KEY `DiplomeID` (`DiplomeID`),
  KEY `PersonnelUtilisateurID` (`PersonnelUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `diplomepersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

CREATE TABLE IF NOT EXISTS `discipline` (
  `ID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `discipline`
--


-- --------------------------------------------------------

--
-- Structure de la table `docjustifabsetudiant`
--

CREATE TABLE IF NOT EXISTS `docjustifabsetudiant` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `DateDepot` date DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `docjustifabsetudiant`
--


-- --------------------------------------------------------

--
-- Structure de la table `docjustifabspersonnel`
--

CREATE TABLE IF NOT EXISTS `docjustifabspersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  `DateDepot` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `docjustifabspersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentactualite`
--

CREATE TABLE IF NOT EXISTS `documentactualite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ActualiteID` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ActualiteID` (`ActualiteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentactualite`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentannonce`
--

CREATE TABLE IF NOT EXISTS `documentannonce` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AnnonceID` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `AnnonceID` (`AnnonceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentannonce`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentevaluation`
--

CREATE TABLE IF NOT EXISTS `documentevaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentevaluation`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentmateriel`
--

CREATE TABLE IF NOT EXISTS `documentmateriel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterielID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MaterielID` (`MaterielID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentmateriel`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentmessage`
--

CREATE TABLE IF NOT EXISTS `documentmessage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MessageID` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MessageID` (`MessageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentmessage`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentphotocopie`
--

CREATE TABLE IF NOT EXISTS `documentphotocopie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DemandePhotocopieID` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `DemandePhotocopieID` (`DemandePhotocopieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentphotocopie`
--


-- --------------------------------------------------------

--
-- Structure de la table `documentpublication`
--

CREATE TABLE IF NOT EXISTS `documentpublication` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `documentpublication`
--


-- --------------------------------------------------------

--
-- Structure de la table `domainelivre`
--

CREATE TABLE IF NOT EXISTS `domainelivre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `domainelivre`
--


-- --------------------------------------------------------

--
-- Structure de la table `empruntbibliotheque`
--

CREATE TABLE IF NOT EXISTS `empruntbibliotheque` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DateEmprunt` date DEFAULT NULL,
  `DateRetour` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `ExemplaireLivreID` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ExemplaireLivreID` (`ExemplaireLivreID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `empruntbibliotheque`
--


-- --------------------------------------------------------

--
-- Structure de la table `empruntmateriel`
--

CREATE TABLE IF NOT EXISTS `empruntmateriel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DateEmprunt` date DEFAULT NULL,
  `DateRetour` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `ExemplaireMaterielID` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ExemplaireMaterielID` (`ExemplaireMaterielID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `empruntmateriel`
--


-- --------------------------------------------------------

--
-- Structure de la table `encadrantstage`
--

CREATE TABLE IF NOT EXISTS `encadrantstage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  `Prenom` varchar(255) DEFAULT NULL,
  `Fonction` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `encadrantstage`
--


-- --------------------------------------------------------

--
-- Structure de la table `engagement`
--

CREATE TABLE IF NOT EXISTS `engagement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Objet` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `engagement`
--


-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE IF NOT EXISTS `etablissement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProvinceID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  `Telephone` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Adresse_Fr` varchar(255) DEFAULT NULL,
  `Adresse_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProvinceID` (`ProvinceID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `etablissement`
--

INSERT INTO `etablissement` (`ID`, `ProvinceID`, `Code`, `Nom_Fr`, `Nom_Ar`, `Telephone`, `Email`, `Adresse_Fr`, `Adresse_Ar`) VALUES
(1, 4, 'IDRISS PREMIER', 'Lycee IDRISS PREMIER', NULL, '0537-36-55-98 ', '', 'AVENUE MOHAMMED V KENITRA - Kenitra ', NULL),
(2, 4, 'IBNOU AL HAYTAM', 'Lycée IBNOU AL HAYTAM', NULL, '0661759718', NULL, 'OULED OUJIH KENITRA - KENITRA ', NULL),
(3, 4, 'ABD ERRAHMAN ENNACER ', 'Lycee ABD ERRAHMAN ENNACER ', NULL, '0537-37-00-25 ', NULL, 'AVENUE HOUMMANE ALFATOUAKI KENITRA - Kenitra ', NULL),
(4, 4, 'ABD ALMALEK ASSAADI', 'Lycee ABD ALMALEK ASSAADI', NULL, ' 0537-37-99-16  ', NULL, 'RUE SEBOU KENITRA - Kenitra ', NULL),
(5, 4, 'MILITAIRE ROYAL', 'Lycee MILITAIRE ROYAL', NULL, '0537371121', NULL, 'TROISIEME BASE AERIENNE KENITRA - Kenitra', NULL),
(6, 4, 'IBN SINA', 'Lycee TECHNIQUE IBN SINA', NULL, NULL, NULL, 'AVENUE CHAKIB ARSSALANE - Kenitra', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `UtilisateurID` int(11) NOT NULL,
  `EtablissementID` int(11) DEFAULT NULL,
  `FiliereID` int(11) DEFAULT NULL,
  `Cne` varchar(255) DEFAULT NULL,
  `NumInscription` varchar(255) DEFAULT NULL,
  `AnneeBac` varchar(255) DEFAULT NULL,
  `OptionBacID` int(11) DEFAULT NULL,
  `MoyenneBac` float DEFAULT NULL,
  `MentionID` int(11) DEFAULT NULL,
  `Candidat` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `ParentUtilisateurID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UtilisateurID`),
  KEY `EtablissementID` (`EtablissementID`),
  KEY `FiliereID` (`FiliereID`),
  KEY `OptionBacID` (`OptionBacID`),
  KEY `MentionID` (`MentionID`),
  KEY `ParentUtilisateurID` (`ParentUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`UtilisateurID`, `EtablissementID`, `FiliereID`, `Cne`, `NumInscription`, `AnneeBac`, `OptionBacID`, `MoyenneBac`, `MentionID`, `Candidat`, `Etat`, `ParentUtilisateurID`) VALUES
(1, 6, 1, 'E142031431', '29/18', '2018', 1, 13.31, 2, 'Officiel', 'Scolarisé', 2),
(3, 6, 1, 'J140021618', '48/18', '2018', 2, 13.51, 2, 'Officiel', 'Scolarisé', 4),
(5, 6, 1, 'E135210177', '60/17', '2015', 1, 12.02, 2, 'Officiel', 'Scolarisé', 6),
(7, 5, 1, 'E139207568', '99/18', '2018', 1, 12, 1, 'Officiel', 'Scolarisé', 8);

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeExamenID` int(11) NOT NULL,
  `Session` varchar(255) DEFAULT NULL,
  `MatiereID` int(11) NOT NULL,
  `ClasseID` int(11) NOT NULL,
  `SalleID` int(11) NOT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `FormeEvaluationID` int(11) NOT NULL,
  `DocumentEvaluationID` int(11) DEFAULT NULL,
  `DocumentEvaluationID2` int(11) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `DateDepotNotes` date DEFAULT NULL,
  `DatePassage` date DEFAULT NULL,
  `DatePlanifiee` date DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Duree` smallint(6) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `SalleID` (`SalleID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `FormeEvaluationID` (`FormeEvaluationID`),
  KEY `DocumentEvaluationID` (`DocumentEvaluationID`),
  KEY `DocumentEvaluationID2` (`DocumentEvaluationID2`),
  KEY `ClasseID` (`ClasseID`),
  KEY `TypeExamenID` (`TypeExamenID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `examen`
--


-- --------------------------------------------------------

--
-- Structure de la table `exemplairelivre`
--

CREATE TABLE IF NOT EXISTS `exemplairelivre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LivreID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `NumInventaire` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `LivreID` (`LivreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `exemplairelivre`
--


-- --------------------------------------------------------

--
-- Structure de la table `exemplairemateriel`
--

CREATE TABLE IF NOT EXISTS `exemplairemateriel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterielID` int(11) NOT NULL,
  `SalleID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `NumInventaire` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MaterielID` (`MaterielID`),
  KEY `SalleID` (`SalleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `exemplairemateriel`
--


-- --------------------------------------------------------

--
-- Structure de la table `fanspublication`
--

CREATE TABLE IF NOT EXISTS `fanspublication` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `PublicationID` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PublicationID` (`PublicationID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fanspublication`
--


-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE IF NOT EXISTS `filiere` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `filiere`
--

INSERT INTO `filiere` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'DSI', 'Développement des Systèmes d''Informations', 'تطوير نظم الإعلام'),
(2, 'MI', 'Maintenance Industrielle', 'الصيانة الصناعية'),
(3, 'SE', 'Systèmes Electriques', 'الأنظمة الكهروبية'),
(4, 'CPI', 'Conception du Produit Industriel', 'إبتكار المنتوج الصناعي'),
(5, 'PME-PMI', 'Gestion des PME et PMI', 'تسيير المقاولات الصغرى و المتوسطة');

-- --------------------------------------------------------

--
-- Structure de la table `fonction`
--

CREATE TABLE IF NOT EXISTS `fonction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) NOT NULL DEFAULT '',
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `fonction`
--

INSERT INTO `fonction` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, '01', NULL, 'التدريس'),
(2, '03', NULL, 'مدير مؤسسة تعليمية'),
(3, '04', NULL, 'ناظر الدروس'),
(4, '05', NULL, 'حارس عام'),
(5, '06', NULL, 'رئيس الأشغال'),
(6, '07', NULL, 'محضر مختبر'),
(7, '08', NULL, 'معيد'),
(8, '10', NULL, 'مسير المصالح المادية والاقتصادية'),
(9, '11', NULL, 'مساعد مسير المصالح المادية والاقتصادية'),
(10, '12', NULL, 'مرشد تربوي'),
(11, '60', NULL, 'قيم على الخزانة'),
(12, '95', NULL, 'مهام أخرى');

-- --------------------------------------------------------

--
-- Structure de la table `fonctionjury`
--

CREATE TABLE IF NOT EXISTS `fonctionjury` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fonctionjury`
--


-- --------------------------------------------------------

--
-- Structure de la table `fonctionpersonnel`
--

CREATE TABLE IF NOT EXISTS `fonctionpersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtablissementID` int(11) NOT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `PersonnelUtilisateurID` int(11) NOT NULL,
  `FonctionID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtablissementID` (`EtablissementID`),
  KEY `PersonnelUtilisateurID` (`PersonnelUtilisateurID`),
  KEY `FonctionID` (`FonctionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fonctionpersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `formeevaluation`
--

CREATE TABLE IF NOT EXISTS `formeevaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `formeevaluation`
--

INSERT INTO `formeevaluation` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'ECR', 'Ecrit', 'كتابي'),
(2, 'PRA', 'Pratique', 'تطبيقي'),
(3, 'ORL', 'Oral', 'شفوي'),
(4, 'ECR/ORL', 'Ecrit/Oral', 'كتابي/شفوي'),
(5, 'ECR/PRA', 'Ecrit/Pratique', 'كتابي/تطبيقي'),
(6, 'PRA/ORL', 'Pratique/Oral', 'تطبيقي/شفوي');

-- --------------------------------------------------------

--
-- Structure de la table `formeexamen`
--

CREATE TABLE IF NOT EXISTS `formeexamen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `formeexamen`
--


-- --------------------------------------------------------

--
-- Structure de la table `inspecteur`
--

CREATE TABLE IF NOT EXISTS `inspecteur` (
  `UtilisateurID` int(11) NOT NULL,
  `SpecialiteID` int(11) NOT NULL,
  PRIMARY KEY (`UtilisateurID`),
  KEY `SpecialiteID` (`SpecialiteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `inspecteur`
--


-- --------------------------------------------------------

--
-- Structure de la table `inspection`
--

CREATE TABLE IF NOT EXISTS `inspection` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `InspecteurUtilisateurID` int(11) NOT NULL,
  `CahierTexteID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CahierTexteID` (`CahierTexteID`),
  KEY `InspecteurUtilisateurID` (`InspecteurUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `inspection`
--


-- --------------------------------------------------------

--
-- Structure de la table `invitation`
--

CREATE TABLE IF NOT EXISTS `invitation` (
  `ID` int(11) NOT NULL,
  `UtilisateurID2` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Lu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UtilisateurID2` (`UtilisateurID2`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `invitation`
--


-- --------------------------------------------------------

--
-- Structure de la table `jalon`
--

CREATE TABLE IF NOT EXISTS `jalon` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProjetID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProjetID` (`ProjetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `jalon`
--


-- --------------------------------------------------------

--
-- Structure de la table `livrableprojet`
--

CREATE TABLE IF NOT EXISTS `livrableprojet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `JalonID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `JalonID` (`JalonID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `livrableprojet`
--


-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE IF NOT EXISTS `livre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CouvertureLivreID` int(11) DEFAULT NULL,
  `DomaineLivreID` int(11) NOT NULL,
  `Isbn` varchar(255) DEFAULT NULL,
  `Titre` varchar(255) DEFAULT NULL,
  `Auteur` varchar(255) DEFAULT NULL,
  `MaisonEdit` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Empruntable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CouvertureLivreID` (`CouvertureLivreID`),
  KEY `DomaineLivreID` (`DomaineLivreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `livre`
--


-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE IF NOT EXISTS `materiel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeMaterielID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Empruntable` tinyint(1) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TypeMaterielID` (`TypeMaterielID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `materiel`
--


-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `matiere`
--

INSERT INTO `matiere` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'ARA', 'Arabe', 'اللغة العربية'),
(2, 'FRA', 'Français', 'اللغة الفرنسية'),
(3, 'ANG', 'Anglais', 'اللغة الإنجليزية'),
(4, 'TEC', 'Techniques d’expression et de communication', 'تقنيات التعبير و التواصل'),
(5, 'EEJE', 'Environnement économique et juridique de l’entreprise', 'المحيط الإقتصادي و القانوني للمقاولة'),
(6, 'MATH', 'Mathématiques', 'الرياضيات'),
(7, 'ASI', 'Architecture des systèmes informatiques', 'هندسة الأنظمة المعلوماتية'),
(8, 'DAI', 'Développement d''applications informatiques', 'تطوير التطبيقات المعلوماتية'),
(9, 'CAI', 'Conception des applications informatiques', 'تصميم التطبيقات المعلوماتية'),
(10, 'STAGE', 'Soutenance de stage', 'مناقشة تقرير التدريب'),
(11, 'PFE', 'Soutenance de projet de fin d''études', 'مناقشة مشروع نهاية التكوين');

-- --------------------------------------------------------

--
-- Structure de la table `matiere_inspecteur`
--

CREATE TABLE IF NOT EXISTS `matiere_inspecteur` (
  `InspecteurUtilisateurID` int(11) NOT NULL,
  `MatiereID` int(11) NOT NULL,
  PRIMARY KEY (`InspecteurUtilisateurID`,`MatiereID`),
  KEY `MatiereID` (`MatiereID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `matiere_inspecteur`
--


-- --------------------------------------------------------

--
-- Structure de la table `membrejury`
--

CREATE TABLE IF NOT EXISTS `membrejury` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FonctionJuryID` int(11) NOT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `SoutenanceID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FonctionJuryID` (`FonctionJuryID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `SoutenanceID` (`SoutenanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `membrejury`
--


-- --------------------------------------------------------

--
-- Structure de la table `mention`
--

CREATE TABLE IF NOT EXISTS `mention` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `mention`
--

INSERT INTO `mention` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'P', 'Passable', 'مقبول'),
(2, 'AB', 'Assez bien', 'مستحسن'),
(3, 'B', 'Bien', 'حسن'),
(4, 'TB', 'Très bien', 'حسن جدا');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UtilisateurID2` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Objet` varchar(255) DEFAULT NULL,
  `Texte` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Lu` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `UtilisateurID2` (`UtilisateurID2`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `message`
--


-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE IF NOT EXISTS `module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `module`
--

INSERT INTO `module` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'DSI-M1', 'Structure technologie des composants des ordinateurs', ''),
(2, 'DSI-M2', 'Structure et fonctionnement des ordinateurs', ''),
(3, 'DSI-M3', 'Programmation en langage assembleur', ''),
(4, 'DSI-M4', 'Systèmes d''exploitation', ''),
(5, 'DSI-M5', 'Réseaux informatiques', ''),
(6, 'DSI-M6', 'Conception des systèmes d’informations', ''),
(7, 'DSI-M7', 'Base de Données Relationnelle', ''),
(8, 'DSI-M8', 'Système de Gestion de Base de Données', ''),
(9, 'DSI-M9', 'Méthodes de conception orienté objet', ''),
(10, 'DSI-M10', 'Atelier de Génie logicie', ''),
(11, 'DSI-M11', 'Gestion de projet', ''),
(12, 'DSI-M12', 'Assurance qualité, test et maintenance', ''),
(13, 'DSI-M13', 'Algorithmique et structures de données', ''),
(14, 'DSI-M14', 'Programmation procédurale', ''),
(15, 'DSI-M15', 'Programmation orientée objets', ''),
(16, 'DSI-M16', 'Environnement de développement intégré ', ''),
(17, 'DSI-M17', 'Multimédia', ''),
(18, 'DSI-M18', 'Développement WEB', ''),
(19, 'DSI-M19', 'Développement d’application client/serveur', ''),
(20, 'DSI-M21', 'Logiciel de bureautique et communication', '');

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE IF NOT EXISTS `niveau` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `niveau`
--

INSERT INTO `niveau` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, '1ère', '1ère Année', 'السنة الأولى'),
(2, '2ème', '2ème Année', 'السنة التانية');

-- --------------------------------------------------------

--
-- Structure de la table `notation`
--

CREATE TABLE IF NOT EXISTS `notation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeNoteID` int(11) NOT NULL,
  `PersonnelUtilisateurID` int(11) DEFAULT NULL,
  `Note` float NOT NULL,
  `Annee` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TypeNoteID` (`TypeNoteID`),
  KEY `PersonnelUtilisateurID` (`PersonnelUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `notation`
--


-- --------------------------------------------------------

--
-- Structure de la table `notecontrole`
--

CREATE TABLE IF NOT EXISTS `notecontrole` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `Note` float DEFAULT NULL,
  `Valide` tinyint(1) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `ControleID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `ControleID` (`ControleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `notecontrole`
--


-- --------------------------------------------------------

--
-- Structure de la table `noteexamen`
--

CREATE TABLE IF NOT EXISTS `noteexamen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `Note` float DEFAULT NULL,
  `Valide` tinyint(1) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `ExamenID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `ExamenID` (`ExamenID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `noteexamen`
--


-- --------------------------------------------------------

--
-- Structure de la table `noteprojet`
--

CREATE TABLE IF NOT EXISTS `noteprojet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `ProjetID` int(11) NOT NULL,
  `Note` float NOT NULL,
  `Valide` tinyint(1) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `ProjetID` (`ProjetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `noteprojet`
--


-- --------------------------------------------------------

--
-- Structure de la table `notestage`
--

CREATE TABLE IF NOT EXISTS `notestage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `StageID` int(11) NOT NULL,
  `Note` float NOT NULL,
  `Valide` tinyint(1) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `StageID` (`StageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `notestage`
--


-- --------------------------------------------------------

--
-- Structure de la table `optionbac`
--

CREATE TABLE IF NOT EXISTS `optionbac` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `optionbac`
--

INSERT INTO `optionbac` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'SVT', 'Sciences et vies de la terre', 'علوم الحياة و الأرض'),
(2, 'SP', 'Sciences physiques', 'علوم فيزيائية'),
(3, 'SMA', 'Sciences mathématiques A', 'علوم رياضية أ'),
(4, 'SMB', 'Sciences mathématiques B', 'علوم رياضية ب'),
(5, 'SEC', 'Sciences économiques', 'علوم إقتصادية'),
(6, 'STM', 'Sciences et techniques mécaniques', 'علوم و تكنوليجيات ميكانيكية'),
(7, 'STE', 'Sciences et techniques électriques', 'علوم و تكنوليجيات كهربائية'),
(8, 'AAP', 'Arts appliqués', 'فنون تطبيقية'),
(9, 'SGC', 'Sciences de Gestion Comptable', 'علوم التدبير المحاسباتي'),
(10, 'SH', 'Sciences humaines', 'علوم إنسانية');

-- --------------------------------------------------------

--
-- Structure de la table `organisme`
--

CREATE TABLE IF NOT EXISTS `organisme` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  `Telephone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Site` varchar(255) DEFAULT NULL,
  `Adresse` varchar(255) DEFAULT NULL,
  `Division` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `organisme`
--


-- --------------------------------------------------------

--
-- Structure de la table `panne`
--

CREATE TABLE IF NOT EXISTS `panne` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `ExemplaireMaterielID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `ExemplaireMaterielID` (`ExemplaireMaterielID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `panne`
--


-- --------------------------------------------------------

--
-- Structure de la table `parent`
--

CREATE TABLE IF NOT EXISTS `parent` (
  `UtilisateurID` int(11) NOT NULL,
  `LienParente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `parent`
--

INSERT INTO `parent` (`UtilisateurID`, `LienParente`) VALUES
(2, '1'),
(4, 'Père'),
(6, 'Père'),
(8, 'Père');

-- --------------------------------------------------------

--
-- Structure de la table `periode`
--

CREATE TABLE IF NOT EXISTS `periode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `periode`
--

INSERT INTO `periode` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'AN', 'Annuelle', 'طول السنة'),
(2, 'S1', 'Semestre 1', 'الفصل الدراسي 1'),
(3, 'S2', 'Semestre 2', 'الفصل الدراسي 2');

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Permission` varchar(255) DEFAULT NULL,
  `DateMAJ` date DEFAULT NULL,
  `RessourceID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `RessourceID` (`RessourceID`),
  KEY `RoleID` (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `permission`
--


-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE IF NOT EXISTS `personnel` (
  `UtilisateurID` int(11) NOT NULL,
  `Som` varchar(255) DEFAULT NULL,
  `DateEmbauche` date DEFAULT NULL,
  `DateAffectation` date DEFAULT NULL,
  `NbrEnfants` smallint(6) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `SomConjoint` varchar(255) DEFAULT NULL,
  `NumContrat` varchar(255) DEFAULT NULL,
  `CadreID` int(11) NOT NULL,
  `SituationAdministrativeID` int(11) NOT NULL,
  `FonctionActuelleID` int(11) NOT NULL,
  PRIMARY KEY (`UtilisateurID`),
  KEY `CadreID` (`CadreID`),
  KEY `SituationAdministrativeID` (`SituationAdministrativeID`),
  KEY `FonctionActuelleID` (`FonctionActuelleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `phase`
--

CREATE TABLE IF NOT EXISTS `phase` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProjetID` int(11) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Duree` smallint(6) NOT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProjetID` (`ProjetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `phase`
--


-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE IF NOT EXISTS `professeur` (
  `UtilisateurID` int(11) NOT NULL,
  `CycleID` int(11) NOT NULL,
  `SpecialiteID` int(11) NOT NULL,
  PRIMARY KEY (`UtilisateurID`),
  KEY `CycleID` (`CycleID`),
  KEY `SpecialiteID` (`SpecialiteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `professeur`
--


-- --------------------------------------------------------

--
-- Structure de la table `professeur_projet`
--

CREATE TABLE IF NOT EXISTS `professeur_projet` (
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `ProjetID` int(11) NOT NULL,
  PRIMARY KEY (`ProfesseurUtilisateurID`,`ProjetID`),
  KEY `ProjetID` (`ProjetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `professeur_projet`
--


-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CahierChargeProjetID` int(11) DEFAULT NULL,
  `ClasseID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Titre` varchar(255) DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `SoutenanceID` int(11) DEFAULT NULL,
  `DisciplineID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CahierChargeProjetID` (`CahierChargeProjetID`),
  KEY `ClasseID` (`ClasseID`),
  KEY `SoutenanceID` (`SoutenanceID`),
  KEY `DisciplineID` (`DisciplineID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `projet`
--


-- --------------------------------------------------------

--
-- Structure de la table `projet_etudiant`
--

CREATE TABLE IF NOT EXISTS `projet_etudiant` (
  `ProjetID` int(11) NOT NULL,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ProjetID`,`EtudiantUtilisateurID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `projet_etudiant`
--


-- --------------------------------------------------------

--
-- Structure de la table `province`
--

CREATE TABLE IF NOT EXISTS `province` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RegionID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `RegionID` (`RegionID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=76 ;

--
-- Contenu de la table `province`
--

INSERT INTO `province` (`ID`, `RegionID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 1, 'Rabat', 'Préfecture de Rabat', NULL),
(2, 1, 'Salé', 'Préfecture de Salé', NULL),
(3, 1, 'Skhirate-Témara', 'Préfecture de Skhirate-Témara', NULL),
(4, 1, 'Kénitra', 'Province de Kénitra', NULL),
(5, 1, 'Khémisset', 'Province de Khémisset', NULL),
(6, 1, 'Sidi Kacem', 'Province de Sidi Kacem', NULL),
(7, 1, 'Sidi Slimane', 'Province de Sidi Slimane', NULL),
(8, 2, 'Tanger-Assilah', 'Préfecture de Tanger-Assilah', NULL),
(9, 2, 'M''diq-Fnideq', 'Préfecture de M''diq-Fnideq', NULL),
(10, 2, 'Tétouan', 'Province de Tétouan', NULL),
(11, 2, 'Fahs-Anjra', 'Province de Fahs-Anjra', NULL),
(12, 2, 'Larache', 'Province de Larache', NULL),
(13, 2, 'Al Hoceïma', 'Province d''Al Hoceïma', NULL),
(14, 2, 'Chefchaouen', 'Province de Chefchaouen', NULL),
(15, 2, 'Ouezzane', 'Province d''Ouezzane', NULL),
(16, 3, 'Casablanca', 'Préfecture de Casablanca', NULL),
(17, 3, 'Mohammédia', 'Préfecture de Mohammédia', NULL),
(18, 3, 'El Jadida', 'Province d''El Jadida', NULL),
(19, 3, 'Nouaceur', 'Province de Nouaceur', NULL),
(20, 3, 'Médiouna', 'Province de Médiouna', NULL),
(21, 3, 'Benslimane', 'Province de Benslimane', NULL),
(22, 3, 'Berrechid', 'Province de Berrechid', NULL),
(23, 3, 'Settat', 'Province de Settat', NULL),
(24, 3, 'Sidi Bennour', 'Province de Sidi Bennour', NULL),
(25, 4, 'Errachidia', 'Province d''Errachidia', NULL),
(26, 4, 'Ouarzazate', 'Province de Ouarzazate', NULL),
(27, 4, 'Midelt', 'Province de Midelt', NULL),
(28, 4, 'Tinghir', 'Province de Tinghir', NULL),
(29, 4, 'Zagora', 'Province de Zagora', NULL),
(30, 5, 'Oujda-Angad', 'Préfecture d''Oujda-Angad', NULL),
(31, 5, 'Nador', 'Province de Nador', NULL),
(32, 5, 'Driouch', 'Province de Driouch', NULL),
(33, 5, 'Jerada', 'Province de Jerada', NULL),
(34, 5, 'Berkane', 'Province de Berkane', NULL),
(35, 5, 'Taourirt', 'Province de Taourirt', NULL),
(36, 5, 'Guercif', 'Province de Guercif', NULL),
(37, 5, 'Figuig', 'Province de Figuig', NULL),
(38, 6, 'Agadir Ida-Outanane', 'Préfecture d''Agadir Ida-Outanane', NULL),
(39, 6, 'Inezgane-Aït Melloul', 'Préfecture d''Inezgane-Aït Melloul', NULL),
(40, 6, 'Chtouka-Aït Baha', 'Province de Chtouka-Aït Baha', NULL),
(41, 6, 'Taroudant', 'Province de Taroudant', NULL),
(42, 6, 'Tiznit', 'Province de Tiznit', NULL),
(43, 6, 'Tata', 'Province de Tata', NULL),
(44, 7, 'Fès', 'Préfecture de Fès', NULL),
(45, 7, 'Meknès', 'Préfecture de Meknès', NULL),
(46, 7, 'El Hajeb', 'Province d’El Hajeb', NULL),
(47, 7, 'Ifrane', 'Province d’Ifrane', NULL),
(48, 7, 'Moulay Yaâcoub', 'Province de Moulay Yaâcoub', NULL),
(49, 7, 'Séfrou', 'Province de Séfrou', NULL),
(50, 7, 'Boulemane', 'Province de Boulemane', NULL),
(51, 7, 'Taounate', 'Province de Taounate', NULL),
(52, 7, 'Taza', 'Province de Taza', NULL),
(53, 8, 'Marrakech', 'Préfecture de Marrakech', NULL),
(54, 8, 'Chichaoua', 'Province de Chichaoua', NULL),
(55, 8, 'Al Haouz', 'Province d''Al Haouz', NULL),
(56, 8, 'El Kelaâ des Sraghna', 'Province d''El Kelaâ des Sraghna', NULL),
(57, 8, 'Essaouira', 'Province d''Essaouira', NULL),
(58, 8, 'Rehamna', 'Province de Rehamna', NULL),
(59, 8, 'Safi', 'Province de Safi', NULL),
(60, 8, 'Youssoufia', 'Province de Youssoufia', NULL),
(61, 9, 'Béni-Mellal', 'Province de Béni-Mellal', NULL),
(62, 9, 'Azilal', 'Province d''Azilal', NULL),
(63, 9, 'Fquih Ben Salah', 'Province de Fquih Ben Salah', NULL),
(64, 9, 'Khénifra', 'Province de Khénifra', NULL),
(65, 9, 'Khouribga', 'Province de Khouribga', NULL),
(66, 10, 'Guelmim', 'Province de Guelmim', NULL),
(67, 10, 'Assa-Zag', 'Province d''Assa-Zag', NULL),
(68, 10, 'Tan-Tan', 'Province de Tan-Tan', NULL),
(69, 10, 'Sidi Ifni', 'Province de Sidi Ifni', NULL),
(70, 11, 'Laâyoune', 'Province de Laâyoune', NULL),
(71, 11, 'Boujdour', 'Province de Boujdour', NULL),
(72, 11, 'Tarfaya', 'Province de Tarfaya', NULL),
(73, 11, 'Es-Semara', 'Province d''Es-Semara', NULL),
(74, 12, 'Oued Ed Dahab', 'Province d''Oued Ed Dahab', NULL),
(75, 12, 'Aousserd', 'Province d''Aousserd', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE IF NOT EXISTS `publication` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClasseID` int(11) NOT NULL,
  `DocumentPublicationID` int(11) DEFAULT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Objet` varchar(255) DEFAULT NULL,
  `Texte` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClasseID` (`ClasseID`),
  KEY `DocumentPublicationID` (`DocumentPublicationID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `publication`
--


-- --------------------------------------------------------

--
-- Structure de la table `rapportprojet`
--

CREATE TABLE IF NOT EXISTS `rapportprojet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProjetID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  `Titre` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProjetID` (`ProjetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `rapportprojet`
--


-- --------------------------------------------------------

--
-- Structure de la table `rapportstage`
--

CREATE TABLE IF NOT EXISTS `rapportstage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `StageID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Taille` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StageID` (`StageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `rapportstage`
--


-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `region`
--

INSERT INTO `region` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'Rabat-Salé-Kénitra', 'Rabat-Salé-Kénitra', 'جهة الرباط سلا القنيطرة'),
(2, 'Tanger-Tétouan-Al Hoceïma', 'Tanger-Tétouan-Al Hoceïma', 'جهة طنجة تطوان الحسيمة'),
(3, 'Casablanca-Settat', 'Casablanca-Settat', 'جهة الدار البيضاء سطات'),
(4, ' Drâa-Tafilalet', ' Drâa-Tafilalet', 'جهة درعة تافيلالت'),
(5, 'l''Oriental', 'l''Oriental', 'جهة الشرق'),
(6, 'Souss-Massa', 'Souss-Massa', 'جهة سوس ماسة'),
(7, 'Fès-Meknès', 'Fès-Meknès', 'جهة فاس مكناس'),
(8, 'Marrakech-Safi', 'Marrakech-Safi', 'جهة مراكش آسفي'),
(9, 'Béni Mellal-Khénifra', 'Béni Mellal-Khénifra', 'جهة بني ملال خنيفرة'),
(10, 'Guelmim-Oued Noun', 'Guelmim-Oued Noun', 'جهة كلميم واد نون'),
(11, 'Laâyoune-Sakia El Hamra', 'Laâyoune-Sakia El Hamra', 'جهة العيون الساقية الحمراء'),
(12, 'Dakhla-Oued Ed Dahab', 'Dakhla-Oued Ed Dahab', 'جهة الداخلة وادي الذهب');

-- --------------------------------------------------------

--
-- Structure de la table `reparartion`
--

CREATE TABLE IF NOT EXISTS `reparartion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PanneID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PanneID` (`PanneID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `reparartion`
--


-- --------------------------------------------------------

--
-- Structure de la table `reservationbibliotheque`
--

CREATE TABLE IF NOT EXISTS `reservationbibliotheque` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `LivreID` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LivreID` (`LivreID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `reservationbibliotheque`
--


-- --------------------------------------------------------

--
-- Structure de la table `reservationmateriel`
--

CREATE TABLE IF NOT EXISTS `reservationmateriel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `MaterielID` int(11) NOT NULL,
  `UtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `MaterielID` (`MaterielID`),
  KEY `UtilisateurID` (`UtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `reservationmateriel`
--


-- --------------------------------------------------------

--
-- Structure de la table `ressource`
--

CREATE TABLE IF NOT EXISTS `ressource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `ressource`
--


-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`, `Description`) VALUES
(1, 'ETUDIANT', 'Etudiant', NULL, NULL),
(2, 'PROFESSEUR', 'Professeur', NULL, NULL),
(3, 'DIRECTEUR-ETUDES', 'Directeur Etudes', NULL, NULL),
(4, 'SCOLRITE', 'Scolarite', NULL, NULL),
(5, 'PARENT', 'Parent', NULL, NULL),
(6, 'INSPECTEUR', 'Inspecteur', NULL, NULL),
(7, 'MAINTENANCE', 'Technicien de maintenance', NULL, NULL),
(8, 'DIRECTEUR', 'Directeur', NULL, NULL),
(9, 'INTENDANT', 'Intendent', NULL, NULL),
(10, 'MAGASINIER', 'Magasinier', NULL, NULL),
(11, 'ADMIN', 'Administrateur', NULL, NULL),
(12, 'PHOTOCOPIE', 'Agent de photocopie', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeSalleID` int(11) NOT NULL,
  `BlocID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TypeSalleID` (`TypeSalleID`),
  KEY `BlocID` (`BlocID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `salle`
--


-- --------------------------------------------------------

--
-- Structure de la table `scolarite`
--

CREATE TABLE IF NOT EXISTS `scolarite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `ClasseID` int(11) NOT NULL,
  `DateInscription` date DEFAULT NULL,
  `DecisionFinAnnee` varchar(255) DEFAULT NULL,
  `MentionID` int(11) DEFAULT NULL,
  `Moyenne` float DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `ClasseID` (`ClasseID`),
  KEY `MentionID` (`MentionID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `scolarite`
--

INSERT INTO `scolarite` (`ID`, `EtudiantUtilisateurID`, `ClasseID`, `DateInscription`, `DecisionFinAnnee`, `MentionID`, `Moyenne`, `Etat`, `Observation`) VALUES
(1, 1, 2, '2020-06-05', NULL, 1, 0, NULL, NULL),
(2, 3, 2, '2020-06-05', NULL, 1, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SeanceGeneriqueID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SeanceGeneriqueID` (`SeanceGeneriqueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `seance`
--


-- --------------------------------------------------------

--
-- Structure de la table `seancegenerique`
--

CREATE TABLE IF NOT EXISTS `seancegenerique` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClasseID` int(11) NOT NULL,
  `MatiereID` int(11) NOT NULL,
  `ModuleID` int(11) DEFAULT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `SalleID` int(11) NOT NULL,
  `PeriodeID` int(11) NOT NULL,
  `Jour` varchar(255) DEFAULT NULL,
  `HeureDebut` varchar(255) DEFAULT NULL,
  `HeureFin` varchar(255) DEFAULT NULL,
  `Duree` smallint(6) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClasseID` (`ClasseID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `ModuleID` (`ModuleID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `SalleID` (`SalleID`),
  KEY `PeriodeID` (`PeriodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `seancegenerique`
--


-- --------------------------------------------------------

--
-- Structure de la table `situationadministrative`
--

CREATE TABLE IF NOT EXISTS `situationadministrative` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` int(11) NOT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `situationadministrative`
--


-- --------------------------------------------------------

--
-- Structure de la table `soutenance`
--

CREATE TABLE IF NOT EXISTS `soutenance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClasseID` int(11) NOT NULL,
  `SalleID` int(11) NOT NULL,
  `MatiereID` int(11) NOT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  `DocumentEvaluationID` int(11) NOT NULL,
  `DocumentEvaluationID2` int(11) NOT NULL,
  `FormeEvaluationID` int(11) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `DateDepotNotes` date DEFAULT NULL,
  `DatePassage` date DEFAULT NULL,
  `DatePlanifiee` date DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Duree` smallint(6) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClasseID` (`ClasseID`),
  KEY `SalleID` (`SalleID`),
  KEY `MatiereID` (`MatiereID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`),
  KEY `DocumentEvaluationID` (`DocumentEvaluationID`),
  KEY `DocumentEvaluationID2` (`DocumentEvaluationID2`),
  KEY `FormeEvaluationID` (`FormeEvaluationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `soutenance`
--


-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE IF NOT EXISTS `specialite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Contenu de la table `specialite`
--

INSERT INTO `specialite` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, '10', 'Arabe', 'اللغة العربية'),
(2, '11', 'Instruction islamique', 'التربية الاسلامية'),
(3, '12', 'Philosophie', 'الفلسفة و الفكر الاسلامي'),
(4, '13', 'Histoire-Géographie', 'الاجتماعيات'),
(5, '14', 'Sciences de l''éducation', 'علوم التربية'),
(6, '15', 'Education physique', 'التربية البدنية'),
(7, '16', 'Education artistique', 'التربية التشكيلية'),
(8, '17', NULL, 'الثقافة النسوية'),
(9, '18', 'Français', 'اللغة الفرنسية'),
(10, '19', 'Anglais', 'اللغة الانجليزية'),
(11, '20', 'Espagnol', 'اللغة الاسبانية'),
(12, '21', 'Allemand', 'اللغة الألمانية'),
(13, '22', 'Mathématiques', 'الرياضيات'),
(14, '23', 'Science de la vie et de la terre', 'علوم الحياة والارض'),
(15, '24', 'Physique et chimie', 'الفيزياء و الكيمياء'),
(16, '25', 'Informatique', 'الإعلاميات'),
(17, '26', 'Traduction', 'الترجمة'),
(18, '27', 'Italien', 'اللغة الايطالية'),
(19, '28', 'Musique', 'الموسيقى'),
(20, '50', 'Technologie', 'التكنولوجيا'),
(21, '51', 'Génie mécanique', 'الهندسة الميكانيكية'),
(22, '52', 'Génie électrique', 'الهندسة الكهربائية'),
(23, '56', 'Economie et gestion', 'هندسة الاقتصاد والتسيير');

-- --------------------------------------------------------

--
-- Structure de la table `stage`
--

CREATE TABLE IF NOT EXISTS `stage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EncadrantStageID` int(11) NOT NULL,
  `TypeStageID` int(11) NOT NULL,
  `ClasseID` int(11) NOT NULL,
  `EtudiantUtilisateurID` int(11) NOT NULL,
  `OrganismeID` int(11) NOT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `SoutenanceID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EncadrantStageID` (`EncadrantStageID`),
  KEY `TypeStageID` (`TypeStageID`),
  KEY `ClasseID` (`ClasseID`),
  KEY `EtudiantUtilisateurID` (`EtudiantUtilisateurID`),
  KEY `OrganismeID` (`OrganismeID`),
  KEY `SoutenanceID` (`SoutenanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `stage`
--


-- --------------------------------------------------------

--
-- Structure de la table `stage_professeur`
--

CREATE TABLE IF NOT EXISTS `stage_professeur` (
  `StageID` int(11) NOT NULL,
  `ProfesseurUtilisateurID` int(11) NOT NULL,
  PRIMARY KEY (`StageID`,`ProfesseurUtilisateurID`),
  KEY `ProfesseurUtilisateurID` (`ProfesseurUtilisateurID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `stage_professeur`
--


-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE IF NOT EXISTS `tache` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PhaseID` int(11) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Duree` smallint(6) NOT NULL,
  `Etat` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PhaseID` (`PhaseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `tache`
--


-- --------------------------------------------------------

--
-- Structure de la table `typediplome`
--

CREATE TABLE IF NOT EXISTS `typediplome` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `typediplome`
--

INSERT INTO `typediplome` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'D. Scolaire/Univrsitaire', 'Diplôme scolaire ou universitaire', 'شهادة مدرسية أو جامعية'),
(2, 'D. Professionnel', 'Diplôme professionnel', 'شهادة مهنيـــــــــة');

-- --------------------------------------------------------

--
-- Structure de la table `typedocument`
--

CREATE TABLE IF NOT EXISTS `typedocument` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typedocument`
--


-- --------------------------------------------------------

--
-- Structure de la table `typedocumentetudiant`
--

CREATE TABLE IF NOT EXISTS `typedocumentetudiant` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typedocumentetudiant`
--


-- --------------------------------------------------------

--
-- Structure de la table `typedocumentpersonnel`
--

CREATE TABLE IF NOT EXISTS `typedocumentpersonnel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typedocumentpersonnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `typeexamen`
--

CREATE TABLE IF NOT EXISTS `typeexamen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typeexamen`
--


-- --------------------------------------------------------

--
-- Structure de la table `typemateriel`
--

CREATE TABLE IF NOT EXISTS `typemateriel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typemateriel`
--


-- --------------------------------------------------------

--
-- Structure de la table `typenote`
--

CREATE TABLE IF NOT EXISTS `typenote` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) NOT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `typenote`
--

INSERT INTO `typenote` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'Administrative', 'Note administrative', 'نقطة إدارية'),
(2, 'Pédagogique', 'Note pédagogique', 'نقطة تربوية');

-- --------------------------------------------------------

--
-- Structure de la table `typesalle`
--

CREATE TABLE IF NOT EXISTS `typesalle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typesalle`
--


-- --------------------------------------------------------

--
-- Structure de la table `typestage`
--

CREATE TABLE IF NOT EXISTS `typestage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `typestage`
--

INSERT INTO `typestage` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'Stage 1ére Année', 'Stage première année', 'تدريب السنة الأولى'),
(2, 'Stage 2ème Année', 'Stage deuxième année', 'تدريب السنة الثانية');

-- --------------------------------------------------------

--
-- Structure de la table `unite`
--

CREATE TABLE IF NOT EXISTS `unite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `unite`
--

INSERT INTO `unite` (`ID`, `Code`, `Nom_Fr`, `Nom_Ar`) VALUES
(1, 'U1', 'Langue et Communication', 'اللغات والتواصل'),
(2, 'U2', 'Scientifique et Technique', 'العلمية و التقنية'),
(3, 'U3', 'Professionnelle', 'المهنية');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Photo` varchar(255) DEFAULT NULL,
  `Nom_Fr` varchar(255) DEFAULT NULL,
  `Nom_Ar` varchar(255) DEFAULT NULL,
  `Prenom_Fr` varchar(255) DEFAULT NULL,
  `Prenom_Ar` varchar(255) DEFAULT NULL,
  `Sexe` varchar(255) DEFAULT NULL,
  `Titre` varchar(255) DEFAULT NULL,
  `Cin` varchar(255) DEFAULT NULL,
  `Nationalite` varchar(255) DEFAULT NULL,
  `DateNais` date DEFAULT NULL,
  `LieuNais_Fr` varchar(255) DEFAULT NULL,
  `LieuNais_Ar` varchar(255) DEFAULT NULL,
  `Adresse_Fr` varchar(255) DEFAULT NULL,
  `Adresse_Ar` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SituationF` varchar(255) DEFAULT NULL,
  `TeleMobile` varchar(255) DEFAULT NULL,
  `TeleDomicile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `Photo`, `Nom_Fr`, `Nom_Ar`, `Prenom_Fr`, `Prenom_Ar`, `Sexe`, `Titre`, `Cin`, `Nationalite`, `DateNais`, `LieuNais_Fr`, `LieuNais_Ar`, `Adresse_Fr`, `Adresse_Ar`, `Email`, `SituationF`, `TeleMobile`, `TeleDomicile`) VALUES
(1, 'c:\\School\\data\\users\\usersphotos\\Chrysanthemum9001591320959596.jpg', 'AZOULAY', 'ازولي', 'Anouar', 'أنور', 'M', 'M.', 'GA221521', 'Marocaine', '1999-10-28', 'Missour Boulemane', 'ميسور بولمان', '', 'تجزئة جليل التازي قطاع 2 رقم 179 سيدي سليمان', 'anoiarazo2@gmail.com', NULL, '0653077997', ''),
(2, NULL, '', '', '', '', NULL, 'M.', '', NULL, NULL, NULL, NULL, '', NULL, '', NULL, '', ''),
(3, 'c:\\School\\data\\users\\usersphotos\\Tulips6711591375829439.jpg', 'EL HAMDAOUI', 'الحمداوي', 'Mohammed', 'محمد', 'M', 'M.', 'AE266781', 'Marocaine', '1999-09-18', 'Salé Bettana Salé', 'سلا بطانة سلا', '', '88 زنقة اغبالو قطاع الفتح لعيايدة سلا', 'melhamdaoui888@gmail.com', NULL, '0670319175', ''),
(4, NULL, '', '', '', '', NULL, 'M.', '', NULL, NULL, NULL, NULL, '', NULL, '', NULL, '', ''),
(5, 'c:\\School\\data\\users\\usersphotos\\Jellyfish7101591376650991.jpg', 'ZMARROU', 'زمرو', 'Abdellah', 'عبد الله', 'M', 'M.', 'G702644', 'Marocaine', '1997-04-15', 'Kénitra', 'القنيطرة', '', 'العنوان\r\nحي النور الزنقة 102 رقم 37 القنيطرة', 'abdellah_zmarou@outlook.fr', NULL, '642113470', ''),
(6, NULL, '', '', '', '', NULL, 'M.', '', NULL, NULL, NULL, NULL, '', NULL, '', NULL, '', ''),
(7, 'c:\\School\\data\\users\\usersphotos\\Desert9791591411294434.jpg', 'MRABET', 'امرابط', 'Houssam', 'حسام', 'M', 'M.', 'GI2956', 'Marocaine', '2000-12-01', 'Kénitra', 'القنيطرة', '', 'القنيطرة', 'dodslim100@gmail.com', NULL, '0602925048', ''),
(8, NULL, '', '', '', '', NULL, 'M.', '', NULL, NULL, NULL, NULL, '', NULL, '', NULL, '', ''),
(9, 'c:\\School\\data\\users\\usersphotos\\Penguins900159132091245.jpg', 'CHABBI', 'الشابي', 'Hamid', 'حميد', 'M', 'M.', 'G124578', 'Marocaine', '1961-06-12', 'Kénitra', 'القنيطرة', 'Kénitra', 'القنيطرة', 'chabbii@gmail.com', 'M', '0666666666', '0537373737');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `absenceetudiant`
--
ALTER TABLE `absenceetudiant`
  ADD CONSTRAINT `absenceetudiant_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absenceetudiant_ibfk_2` FOREIGN KEY (`SeanceID`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absenceetudiant_ibfk_3` FOREIGN KEY (`DocJustifAbsEtudiantID`) REFERENCES `docjustifabsetudiant` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `absencepersonnel`
--
ALTER TABLE `absencepersonnel`
  ADD CONSTRAINT `absencepersonnel_ibfk_1` FOREIGN KEY (`DocJustifAbsPersonnelID`) REFERENCES `docjustifabspersonnel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absencepersonnel_ibfk_2` FOREIGN KEY (`PersonnelUtilisateurID`) REFERENCES `personnel` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `absenceprofesseur`
--
ALTER TABLE `absenceprofesseur`
  ADD CONSTRAINT `absenceprofesseur_ibfk_1` FOREIGN KEY (`DocJustifAbsPersonnelID`) REFERENCES `docjustifabspersonnel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absenceprofesseur_ibfk_2` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absenceprofesseur_ibfk_3` FOREIGN KEY (`SeanceID`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `actualite`
--
ALTER TABLE `actualite`
  ADD CONSTRAINT `actualite_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `anneescolairecourante`
--
ALTER TABLE `anneescolairecourante`
  ADD CONSTRAINT `anneescolairecourante_ibfk_1` FOREIGN KEY (`AnneeScolaireID`) REFERENCES `anneescolaire` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `annonce_classe`
--
ALTER TABLE `annonce_classe`
  ADD CONSTRAINT `annonce_classe_ibfk_1` FOREIGN KEY (`AnnonceID`) REFERENCES `annonce` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `annonce_classe_ibfk_2` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `avancementpersonnel`
--
ALTER TABLE `avancementpersonnel`
  ADD CONSTRAINT `avancementpersonnel_ibfk_1` FOREIGN KEY (`PersonnelUtilisateurID`) REFERENCES `personnel` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `avancementtache`
--
ALTER TABLE `avancementtache`
  ADD CONSTRAINT `avancementtache_ibfk_1` FOREIGN KEY (`TacheID`) REFERENCES `tache` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `avertissement`
--
ALTER TABLE `avertissement`
  ADD CONSTRAINT `avertissement_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cahiertexte`
--
ALTER TABLE `cahiertexte`
  ADD CONSTRAINT `cahiertexte_ibfk_2` FOREIGN KEY (`SeanceID`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cahiertexte_acrivitepedagogique`
--
ALTER TABLE `cahiertexte_acrivitepedagogique`
  ADD CONSTRAINT `cahiertexte_acrivitepedagogique_ibfk_1` FOREIGN KEY (`CahierTexteID`) REFERENCES `cahiertexte` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cahiertexte_acrivitepedagogique_ibfk_2` FOREIGN KEY (`AcrivitePedagogiqueID`) REFERENCES `acrivitepedagogique` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cahiertexte_concept`
--
ALTER TABLE `cahiertexte_concept`
  ADD CONSTRAINT `cahiertexte_concept_ibfk_1` FOREIGN KEY (`CahierTexteID`) REFERENCES `cahiertexte` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cahiertexte_concept_ibfk_2` FOREIGN KEY (`ConceptID`) REFERENCES `concept` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `caracteristique`
--
ALTER TABLE `caracteristique`
  ADD CONSTRAINT `caracteristique_ibfk_1` FOREIGN KEY (`MaterielID`) REFERENCES `materiel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `chapitre`
--
ALTER TABLE `chapitre`
  ADD CONSTRAINT `chapitre_ibfk_1` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chapitre_ibfk_2` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`AnneeScolaireID`) REFERENCES `anneescolaire` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classe_ibfk_3` FOREIGN KEY (`ClasseGeneriqueID`) REFERENCES `classegenerique` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classegenerique`
--
ALTER TABLE `classegenerique`
  ADD CONSTRAINT `classegenerique_ibfk_1` FOREIGN KEY (`NiveauID`) REFERENCES `niveau` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classegenerique_ibfk_2` FOREIGN KEY (`FiliereID`) REFERENCES `filiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classegenerique_ibfk_3` FOREIGN KEY (`CycleID`) REFERENCES `cycle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classegunite`
--
ALTER TABLE `classegunite`
  ADD CONSTRAINT `classegunite_ibfk_1` FOREIGN KEY (`ClasseGeneriqueID`) REFERENCES `classegenerique` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classegunite_ibfk_2` FOREIGN KEY (`UniteID`) REFERENCES `unite` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classe_demandephotocopie`
--
ALTER TABLE `classe_demandephotocopie`
  ADD CONSTRAINT `classe_demandephotocopie_ibfk_1` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classe_demandephotocopie_ibfk_2` FOREIGN KEY (`DemandePhotocopieID`) REFERENCES `demandephotocopie` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`PublicationID`) REFERENCES `publication` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`RoleID`) REFERENCES `role` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `concept`
--
ALTER TABLE `concept`
  ADD CONSTRAINT `concept_ibfk_1` FOREIGN KEY (`ChapitreID`) REFERENCES `chapitre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `configurationmatiere`
--
ALTER TABLE `configurationmatiere`
  ADD CONSTRAINT `configurationmatiere_ibfk_1` FOREIGN KEY (`ClasseGUniteID`) REFERENCES `classegunite` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `configurationmatiere_ibfk_2` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `configurationmatiere_ibfk_4` FOREIGN KEY (`PeriodeID`) REFERENCES `periode` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `configurationmatiere_ibfk_5` FOREIGN KEY (`FormeEvaluationID`) REFERENCES `formeevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `configurationmodule`
--
ALTER TABLE `configurationmodule`
  ADD CONSTRAINT `configurationmodule_ibfk_1` FOREIGN KEY (`ConfigurationMatiereID`) REFERENCES `configurationmatiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `configurationmodule_ibfk_2` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `configurationmodule_ibfk_3` FOREIGN KEY (`PeriodeID`) REFERENCES `periode` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `configurationmodule_ibfk_4` FOREIGN KEY (`FormeEvaluationID`) REFERENCES `formeevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contact_ibfk_2` FOREIGN KEY (`UtilisateurID2`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `controle`
--
ALTER TABLE `controle`
  ADD CONSTRAINT `controle_ibfk_1` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `controle_ibfk_2` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `controle_ibfk_3` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `controle_ibfk_4` FOREIGN KEY (`DocumentEvaluationID`) REFERENCES `documentevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `controle_ibfk_5` FOREIGN KEY (`DocumentEvaluationID2`) REFERENCES `documentevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `controle_ibfk_6` FOREIGN KEY (`FormeEvaluationID`) REFERENCES `formeevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `coordination`
--
ALTER TABLE `coordination`
  ADD CONSTRAINT `coordination_ibfk_1` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coordination_ibfk_2` FOREIGN KEY (`AnneeScolaireID`) REFERENCES `anneescolaire` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coordination_ibfk_3` FOREIGN KEY (`FiliereID`) REFERENCES `filiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demandedocetudiant`
--
ALTER TABLE `demandedocetudiant`
  ADD CONSTRAINT `demandedocetudiant_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandedocetudiant_ibfk_2` FOREIGN KEY (`TypeDocumentEtudiantID`) REFERENCES `typedocumentetudiant` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demandedocpersonnel`
--
ALTER TABLE `demandedocpersonnel`
  ADD CONSTRAINT `demandedocpersonnel_ibfk_1` FOREIGN KEY (`PersonnelUtilisateurID`) REFERENCES `personnel` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandedocpersonnel_ibfk_2` FOREIGN KEY (`TypeDocumentPersonnelID`) REFERENCES `typedocumentpersonnel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demandephotocopie`
--
ALTER TABLE `demandephotocopie`
  ADD CONSTRAINT `demandephotocopie_ibfk_1` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandephotocopie_ibfk_2` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandephotocopie_ibfk_3` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandephotocopie_ibfk_4` FOREIGN KEY (`TypeDocumentID`) REFERENCES `typedocument` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD CONSTRAINT `diplome_ibfk_1` FOREIGN KEY (`TypeDiplomeID`) REFERENCES `typediplome` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `diplomepersonnel`
--
ALTER TABLE `diplomepersonnel`
  ADD CONSTRAINT `diplomepersonnel_ibfk_1` FOREIGN KEY (`SpecialiteID`) REFERENCES `specialite` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `diplomepersonnel_ibfk_2` FOREIGN KEY (`DiplomeID`) REFERENCES `diplome` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `diplomepersonnel_ibfk_3` FOREIGN KEY (`PersonnelUtilisateurID`) REFERENCES `personnel` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `documentactualite`
--
ALTER TABLE `documentactualite`
  ADD CONSTRAINT `documentactualite_ibfk_1` FOREIGN KEY (`ActualiteID`) REFERENCES `actualite` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `documentannonce`
--
ALTER TABLE `documentannonce`
  ADD CONSTRAINT `documentannonce_ibfk_1` FOREIGN KEY (`AnnonceID`) REFERENCES `annonce` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `documentmateriel`
--
ALTER TABLE `documentmateriel`
  ADD CONSTRAINT `documentmateriel_ibfk_1` FOREIGN KEY (`MaterielID`) REFERENCES `materiel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `documentmessage`
--
ALTER TABLE `documentmessage`
  ADD CONSTRAINT `documentmessage_ibfk_1` FOREIGN KEY (`MessageID`) REFERENCES `message` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `documentphotocopie`
--
ALTER TABLE `documentphotocopie`
  ADD CONSTRAINT `documentphotocopie_ibfk_1` FOREIGN KEY (`DemandePhotocopieID`) REFERENCES `demandephotocopie` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `empruntbibliotheque`
--
ALTER TABLE `empruntbibliotheque`
  ADD CONSTRAINT `empruntbibliotheque_ibfk_1` FOREIGN KEY (`ExemplaireLivreID`) REFERENCES `exemplairelivre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empruntbibliotheque_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `empruntmateriel`
--
ALTER TABLE `empruntmateriel`
  ADD CONSTRAINT `empruntmateriel_ibfk_1` FOREIGN KEY (`ExemplaireMaterielID`) REFERENCES `exemplairemateriel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empruntmateriel_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `engagement`
--
ALTER TABLE `engagement`
  ADD CONSTRAINT `engagement_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD CONSTRAINT `etablissement_ibfk_1` FOREIGN KEY (`ProvinceID`) REFERENCES `province` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`EtablissementID`) REFERENCES `etablissement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_ibfk_3` FOREIGN KEY (`FiliereID`) REFERENCES `filiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_ibfk_4` FOREIGN KEY (`OptionBacID`) REFERENCES `optionbac` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_ibfk_5` FOREIGN KEY (`MentionID`) REFERENCES `mention` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_ibfk_6` FOREIGN KEY (`ParentUtilisateurID`) REFERENCES `parent` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `examen_ibfk_1` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_2` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_3` FOREIGN KEY (`SalleID`) REFERENCES `salle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_4` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_5` FOREIGN KEY (`FormeEvaluationID`) REFERENCES `formeevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_6` FOREIGN KEY (`DocumentEvaluationID`) REFERENCES `documentevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_7` FOREIGN KEY (`DocumentEvaluationID2`) REFERENCES `documentevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examen_ibfk_8` FOREIGN KEY (`TypeExamenID`) REFERENCES `typeexamen` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exemplairelivre`
--
ALTER TABLE `exemplairelivre`
  ADD CONSTRAINT `exemplairelivre_ibfk_1` FOREIGN KEY (`LivreID`) REFERENCES `livre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exemplairemateriel`
--
ALTER TABLE `exemplairemateriel`
  ADD CONSTRAINT `exemplairemateriel_ibfk_1` FOREIGN KEY (`MaterielID`) REFERENCES `materiel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `exemplairemateriel_ibfk_2` FOREIGN KEY (`SalleID`) REFERENCES `salle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fanspublication`
--
ALTER TABLE `fanspublication`
  ADD CONSTRAINT `fanspublication_ibfk_1` FOREIGN KEY (`PublicationID`) REFERENCES `publication` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fanspublication_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fonctionpersonnel`
--
ALTER TABLE `fonctionpersonnel`
  ADD CONSTRAINT `fonctionpersonnel_ibfk_1` FOREIGN KEY (`EtablissementID`) REFERENCES `etablissement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fonctionpersonnel_ibfk_2` FOREIGN KEY (`PersonnelUtilisateurID`) REFERENCES `personnel` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fonctionpersonnel_ibfk_3` FOREIGN KEY (`FonctionID`) REFERENCES `fonction` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `inspecteur`
--
ALTER TABLE `inspecteur`
  ADD CONSTRAINT `inspecteur_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inspecteur_ibfk_2` FOREIGN KEY (`SpecialiteID`) REFERENCES `specialite` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `inspection`
--
ALTER TABLE `inspection`
  ADD CONSTRAINT `inspection_ibfk_1` FOREIGN KEY (`InspecteurUtilisateurID`) REFERENCES `inspecteur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inspection_ibfk_2` FOREIGN KEY (`CahierTexteID`) REFERENCES `cahiertexte` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD CONSTRAINT `invitation_ibfk_1` FOREIGN KEY (`UtilisateurID2`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invitation_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `jalon`
--
ALTER TABLE `jalon`
  ADD CONSTRAINT `jalon_ibfk_1` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `livrableprojet`
--
ALTER TABLE `livrableprojet`
  ADD CONSTRAINT `livrableprojet_ibfk_1` FOREIGN KEY (`JalonID`) REFERENCES `jalon` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `livre_ibfk_1` FOREIGN KEY (`CouvertureLivreID`) REFERENCES `couverturelivre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `livre_ibfk_2` FOREIGN KEY (`DomaineLivreID`) REFERENCES `domainelivre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `materiel_ibfk_1` FOREIGN KEY (`TypeMaterielID`) REFERENCES `typemateriel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `matiere_inspecteur`
--
ALTER TABLE `matiere_inspecteur`
  ADD CONSTRAINT `matiere_inspecteur_ibfk_1` FOREIGN KEY (`InspecteurUtilisateurID`) REFERENCES `inspecteur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `matiere_inspecteur_ibfk_2` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `membrejury`
--
ALTER TABLE `membrejury`
  ADD CONSTRAINT `membrejury_ibfk_1` FOREIGN KEY (`FonctionJuryID`) REFERENCES `fonctionjury` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `membrejury_ibfk_2` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `membrejury_ibfk_3` FOREIGN KEY (`SoutenanceID`) REFERENCES `soutenance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`UtilisateurID2`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notation`
--
ALTER TABLE `notation`
  ADD CONSTRAINT `notation_ibfk_1` FOREIGN KEY (`TypeNoteID`) REFERENCES `typenote` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notation_ibfk_2` FOREIGN KEY (`PersonnelUtilisateurID`) REFERENCES `personnel` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notecontrole`
--
ALTER TABLE `notecontrole`
  ADD CONSTRAINT `notecontrole_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notecontrole_ibfk_2` FOREIGN KEY (`ControleID`) REFERENCES `controle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `noteexamen`
--
ALTER TABLE `noteexamen`
  ADD CONSTRAINT `noteexamen_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `noteexamen_ibfk_2` FOREIGN KEY (`ExamenID`) REFERENCES `examen` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `noteprojet`
--
ALTER TABLE `noteprojet`
  ADD CONSTRAINT `noteprojet_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `noteprojet_ibfk_2` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notestage`
--
ALTER TABLE `notestage`
  ADD CONSTRAINT `notestage_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notestage_ibfk_2` FOREIGN KEY (`StageID`) REFERENCES `stage` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `panne`
--
ALTER TABLE `panne`
  ADD CONSTRAINT `panne_ibfk_1` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `panne_ibfk_2` FOREIGN KEY (`ExemplaireMaterielID`) REFERENCES `exemplairemateriel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `parent`
--
ALTER TABLE `parent`
  ADD CONSTRAINT `parent_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `permission`
--
ALTER TABLE `permission`
  ADD CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`RessourceID`) REFERENCES `ressource` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `permission_ibfk_2` FOREIGN KEY (`RoleID`) REFERENCES `role` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `personnel_ibfk_2` FOREIGN KEY (`CadreID`) REFERENCES `cadre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `personnel_ibfk_3` FOREIGN KEY (`SituationAdministrativeID`) REFERENCES `situationadministrative` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `personnel_ibfk_4` FOREIGN KEY (`FonctionActuelleID`) REFERENCES `fonction` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `phase`
--
ALTER TABLE `phase`
  ADD CONSTRAINT `phase_ibfk_1` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `professeur_ibfk_1` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `professeur_ibfk_2` FOREIGN KEY (`CycleID`) REFERENCES `cycle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `professeur_ibfk_3` FOREIGN KEY (`SpecialiteID`) REFERENCES `specialite` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `professeur_projet`
--
ALTER TABLE `professeur_projet`
  ADD CONSTRAINT `professeur_projet_ibfk_1` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `professeur_projet_ibfk_2` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`CahierChargeProjetID`) REFERENCES `cahierchargeprojet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_2` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_3` FOREIGN KEY (`SoutenanceID`) REFERENCES `soutenance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_4` FOREIGN KEY (`DisciplineID`) REFERENCES `discipline` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `projet_etudiant`
--
ALTER TABLE `projet_etudiant`
  ADD CONSTRAINT `projet_etudiant_ibfk_1` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_etudiant_ibfk_2` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `province`
--
ALTER TABLE `province`
  ADD CONSTRAINT `province_ibfk_1` FOREIGN KEY (`RegionID`) REFERENCES `region` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_2` FOREIGN KEY (`DocumentPublicationID`) REFERENCES `documentpublication` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_3` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rapportprojet`
--
ALTER TABLE `rapportprojet`
  ADD CONSTRAINT `rapportprojet_ibfk_1` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rapportstage`
--
ALTER TABLE `rapportstage`
  ADD CONSTRAINT `rapportstage_ibfk_1` FOREIGN KEY (`StageID`) REFERENCES `stage` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reparartion`
--
ALTER TABLE `reparartion`
  ADD CONSTRAINT `reparartion_ibfk_1` FOREIGN KEY (`PanneID`) REFERENCES `panne` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservationbibliotheque`
--
ALTER TABLE `reservationbibliotheque`
  ADD CONSTRAINT `reservationbibliotheque_ibfk_1` FOREIGN KEY (`LivreID`) REFERENCES `livre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservationbibliotheque_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservationmateriel`
--
ALTER TABLE `reservationmateriel`
  ADD CONSTRAINT `reservationmateriel_ibfk_1` FOREIGN KEY (`MaterielID`) REFERENCES `materiel` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservationmateriel_ibfk_2` FOREIGN KEY (`UtilisateurID`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`TypeSalleID`) REFERENCES `typesalle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `salle_ibfk_2` FOREIGN KEY (`BlocID`) REFERENCES `bloc` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `scolarite`
--
ALTER TABLE `scolarite`
  ADD CONSTRAINT `scolarite_ibfk_1` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `scolarite_ibfk_2` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `scolarite_ibfk_3` FOREIGN KEY (`MentionID`) REFERENCES `mention` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`SeanceGeneriqueID`) REFERENCES `seancegenerique` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seancegenerique`
--
ALTER TABLE `seancegenerique`
  ADD CONSTRAINT `seancegenerique_ibfk_1` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seancegenerique_ibfk_2` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seancegenerique_ibfk_3` FOREIGN KEY (`ModuleID`) REFERENCES `module` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seancegenerique_ibfk_4` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seancegenerique_ibfk_5` FOREIGN KEY (`SalleID`) REFERENCES `salle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seancegenerique_ibfk_6` FOREIGN KEY (`PeriodeID`) REFERENCES `periode` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `soutenance`
--
ALTER TABLE `soutenance`
  ADD CONSTRAINT `soutenance_ibfk_1` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soutenance_ibfk_2` FOREIGN KEY (`SalleID`) REFERENCES `salle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soutenance_ibfk_3` FOREIGN KEY (`MatiereID`) REFERENCES `matiere` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soutenance_ibfk_4` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soutenance_ibfk_5` FOREIGN KEY (`DocumentEvaluationID`) REFERENCES `documentevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soutenance_ibfk_6` FOREIGN KEY (`DocumentEvaluationID2`) REFERENCES `documentevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soutenance_ibfk_7` FOREIGN KEY (`FormeEvaluationID`) REFERENCES `formeevaluation` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `stage`
--
ALTER TABLE `stage`
  ADD CONSTRAINT `stage_ibfk_1` FOREIGN KEY (`EncadrantStageID`) REFERENCES `encadrantstage` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stage_ibfk_2` FOREIGN KEY (`TypeStageID`) REFERENCES `typestage` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stage_ibfk_3` FOREIGN KEY (`ClasseID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stage_ibfk_4` FOREIGN KEY (`EtudiantUtilisateurID`) REFERENCES `etudiant` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stage_ibfk_5` FOREIGN KEY (`OrganismeID`) REFERENCES `organisme` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stage_ibfk_6` FOREIGN KEY (`SoutenanceID`) REFERENCES `soutenance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `stage_professeur`
--
ALTER TABLE `stage_professeur`
  ADD CONSTRAINT `stage_professeur_ibfk_1` FOREIGN KEY (`StageID`) REFERENCES `stage` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stage_professeur_ibfk_2` FOREIGN KEY (`ProfesseurUtilisateurID`) REFERENCES `professeur` (`UtilisateurID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`PhaseID`) REFERENCES `phase` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
