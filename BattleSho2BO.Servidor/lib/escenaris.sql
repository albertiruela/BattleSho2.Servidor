-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Temps de generació: 28-08-2016 a les 12:33:36
-- Versió del servidor: 10.1.13-MariaDB
-- Versió de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `dpo2`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `escenaris`
--

CREATE TABLE `escenaris` (
  `Nom` varchar(15) NOT NULL,
  `Path` varchar(300) NOT NULL,
  `DataCreacio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcant dades de la taula `escenaris`
--

INSERT INTO `escenaris` (`Nom`, `Path`, `DataCreacio`) VALUES
('Facil2.txt', 'C:UsersAlbertDesktopHUNDIRFLOTABattleSho2BO.ServidormapesFacil2.txt', '2016-08-27 23:06:09'),
('Facil1.txt', 'C:UsersAlbertDesktopHUNDIRFLOTABattleSho2BO.ServidormapesFacil1.txt', '2016-08-27 23:07:06'),
('Facil1.txt', 'C:UsersAlbertDesktopHUNDIRFLOTABattleSho2BO.ServidormapesFacil1.txt', '2016-08-27 23:09:38'),
('Facil2.txt', 'C:UsersAlbertDesktopHUNDIRFLOTABattleSho2BO.ServidormapesFacil2.txt', '2016-08-28 01:14:15'),
('Facil1.txt', 'C:UsersAlbertDesktopHUNDIRFLOTABattleSho2BO.ServidormapesFacil1.txt', '2016-08-28 02:04:08'),
('Facil2.txt', 'C:UsersAlbertDesktopHUNDIRFLOTABattleSho2BO.ServidormapesFacil2.txt', '2016-08-28 02:04:13');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
