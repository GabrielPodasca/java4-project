-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2016 at 01:07 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java4project`
--

-- --------------------------------------------------------

--
-- Table structure for table `cabinete`
--

CREATE TABLE IF NOT EXISTS `cabinete` (
`id` int(11) NOT NULL,
  `denumire` varchar(200) DEFAULT NULL,
  `locatie` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `medici`
--

CREATE TABLE IF NOT EXISTS `medici` (
  `users_id` int(11) NOT NULL,
  `nume` varchar(200) DEFAULT NULL,
  `prenume` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `cnp` varchar(45) DEFAULT NULL,
  `statut` enum('primar','specialist') DEFAULT NULL,
  `specialitate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `pacienti`
--

CREATE TABLE IF NOT EXISTS `pacienti` (
  `users_id` int(11) NOT NULL,
  `nume` varchar(200) DEFAULT NULL,
  `prenume` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `cnp` varchar(45) DEFAULT NULL,
  `inaltime` decimal(5,2) DEFAULT NULL,
  `greutate` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `reg_medici`
--

CREATE TABLE IF NOT EXISTS `reg_medici` (
`id` int(11) NOT NULL,
  `medici_users_id` int(11) NOT NULL,
  `cabinete_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reg_pacienti`
--

CREATE TABLE IF NOT EXISTS `reg_pacienti` (
`id` int(11) NOT NULL,
  `pacienti_users_id` int(11) NOT NULL,
  `medici_users_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reg_vizite`
--

CREATE TABLE IF NOT EXISTS `reg_vizite` (
`id` int(11) NOT NULL,
  `pacienti_users_id` int(11) NOT NULL,
  `medici_users_id` int(11) NOT NULL,
  `cabinete_id` int(11) NOT NULL,
  `data_vizita` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `parola` text NOT NULL,
  `enabled` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `parola`, `enabled`) VALUES
(1, 'admin', 'admin', 1),
(7, 'gabi', '1234', 1),
(8, 'gabi1', '234', 1),
(9, 'gabi2', '2345', 1),
(10, 'gabi3', '2345', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
`id` int(11) NOT NULL,
  `role` enum('ROLE_ADMIN','ROLE_MEDIC','ROLE_PACIENT') DEFAULT NULL,
  `users_id` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=38 ;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `role`, `users_id`) VALUES
(1, 'ROLE_ADMIN', 1),
(26, 'ROLE_ADMIN', 7),
(27, 'ROLE_MEDIC', 7),
(28, 'ROLE_PACIENT', 7),
(29, 'ROLE_ADMIN', 8),
(30, 'ROLE_PACIENT', 9),
(31, 'ROLE_MEDIC', 9),
(36, 'ROLE_MEDIC', 10),
(37, 'ROLE_ADMIN', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cabinete`
--
ALTER TABLE `cabinete`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medici`
--
ALTER TABLE `medici`
 ADD PRIMARY KEY (`users_id`);

--
-- Indexes for table `pacienti`
--
ALTER TABLE `pacienti`
 ADD PRIMARY KEY (`users_id`);

--
-- Indexes for table `reg_medici`
--
ALTER TABLE `reg_medici`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_medici_has_cabinete_cabinete1_idx` (`cabinete_id`), ADD KEY `fk_reg_medici_medici1_idx` (`medici_users_id`);

--
-- Indexes for table `reg_pacienti`
--
ALTER TABLE `reg_pacienti`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_pacienti_has_medici_medici1_idx` (`medici_users_id`), ADD KEY `fk_pacienti_has_medici_pacienti1_idx` (`pacienti_users_id`);

--
-- Indexes for table `reg_vizite`
--
ALTER TABLE `reg_vizite`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_reg_vizite_cabinete1_idx` (`cabinete_id`), ADD KEY `fk_reg_vizite_pacienti1_idx` (`pacienti_users_id`), ADD KEY `fk_reg_vizite_medici1_idx` (`medici_users_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_user_roles_users1_idx` (`users_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cabinete`
--
ALTER TABLE `cabinete`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reg_medici`
--
ALTER TABLE `reg_medici`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reg_pacienti`
--
ALTER TABLE `reg_pacienti`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reg_vizite`
--
ALTER TABLE `reg_vizite`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=38;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `medici`
--
ALTER TABLE `medici`
ADD CONSTRAINT `fk_medici_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pacienti`
--
ALTER TABLE `pacienti`
ADD CONSTRAINT `fk_pacienti_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reg_medici`
--
ALTER TABLE `reg_medici`
ADD CONSTRAINT `fk_medici_has_cabinete_cabinete1` FOREIGN KEY (`cabinete_id`) REFERENCES `cabinete` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_reg_medici_medici1` FOREIGN KEY (`medici_users_id`) REFERENCES `medici` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reg_pacienti`
--
ALTER TABLE `reg_pacienti`
ADD CONSTRAINT `fk_pacienti_has_medici_pacienti1` FOREIGN KEY (`pacienti_users_id`) REFERENCES `pacienti` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_pacienti_has_medici_medici1` FOREIGN KEY (`medici_users_id`) REFERENCES `medici` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reg_vizite`
--
ALTER TABLE `reg_vizite`
ADD CONSTRAINT `fk_reg_vizite_cabinete1` FOREIGN KEY (`cabinete_id`) REFERENCES `cabinete` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_reg_vizite_pacienti1` FOREIGN KEY (`pacienti_users_id`) REFERENCES `pacienti` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_reg_vizite_medici1` FOREIGN KEY (`medici_users_id`) REFERENCES `medici` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
ADD CONSTRAINT `fk_user_roles_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
