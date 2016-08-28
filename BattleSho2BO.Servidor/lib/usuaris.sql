-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Temps de generació: 28-08-2016 a les 12:32:06
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
-- Estructura de la taula `usuaris`
--

CREATE TABLE `usuaris` (
  `Nickname` varchar(15) NOT NULL,
  `DataRegistre` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DataUltimAcces` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PartidesGuanyades` int(10) NOT NULL,
  `PartidesPerdudes` int(10) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcant dades de la taula `usuaris`
--

INSERT INTO `usuaris` (`Nickname`, `DataRegistre`, `DataUltimAcces`, `PartidesGuanyades`, `PartidesPerdudes`, `Password`) VALUES
('a', '2016-08-28 00:56:21', '2016-08-28 00:56:21', 0, 0, '1aaaaa'),
('asa', '2016-08-28 01:09:35', '2016-08-28 01:09:35', 0, 0, '1aaaaa'),
('kkkkk', '2016-08-28 08:51:27', '2016-08-28 08:51:27', 0, 0, '1aaaaa'),
('wert', '2016-08-27 23:20:58', '2016-08-27 23:20:58', 0, 0, '1aaaaa'),
('yu', '2016-08-27 16:44:52', '2016-08-27 16:44:52', 0, 0, '1aaaaa'),
('zxczxc<x', '2016-08-28 01:04:32', '2016-08-28 01:04:32', 0, 0, '1aaaaaa');

--
-- Indexos per taules bolcades
--

--
-- Index de la taula `usuaris`
--
ALTER TABLE `usuaris`
  ADD UNIQUE KEY `Nickname` (`Nickname`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
