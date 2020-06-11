-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 11 juin 2020 à 12:42
-- Version du serveur :  10.3.15-MariaDB
-- Version de PHP :  7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `siteecommerce`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `id_Book` int(10) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Writer` varchar(255) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Price` float NOT NULL,
  `Stock` int(10) NOT NULL,
  `id_Category` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Summary` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id_Book`, `Name`, `Writer`, `Image`, `Price`, `Stock`, `id_Category`, `Date`, `Summary`) VALUES
(2, 'The Philosophy for Heroes', 'LODE', 'PH1.png', 200, 10, 3, '2020-06-03', 'The Philosophy for Heroes book series is a scientific inquiry into question: what constitutes a leader?a hero?and how can we become one?'),
(3, 'The Philosophy Skills Book', 'Bob Underwood', 'PH2.jpg', 120, 10, 3, '2020-04-27', 'Exercises in Philosophical Thinking, Reading, and Writing'),
(4, 'Writing Philosophy', ' Professor Richard', 'PH3.jpg', 70, 10, 3, '2020-04-27', 'A Guide to Professional Writing and Publishing'),
(5, 'Career Paths', 'Virginia Evans', 'SC1.jpg', 54, 10, 2, '2020-06-01', 'Career Paths: Science is a new educational resource for industry professionals who want to improve their English communication in a work environment. '),
(6, 'Career Paths Information Technology', 'Jenny', 'SC2.jpg', 55, 10, 2, '2020-05-05', 'Career Paths: Science is a new educational resource for industry professionals who want to improve their English communication in a work environment. '),
(7, 'Music Theory', 'Nicolas Carter', 'AR1.jpg', 50, 10, 1, '2020-05-04', 'He Ultimate Step-By-Step Guide to Understanding and Learning Music Theory Effortlessly'),
(8, 'Drawing on the Right Side of the Brain', 'Betty Edwards', 'AR2.jpg', 140, 10, 1, '2020-06-05', 'A revised edition of the classic bestselling how to draw book. A life-changing book, this fully revised and updated edition of Drawing on the Right Side of the Brain is destined to inspire generations of readers and artists to come.'),
(9, 'Hamlet', 'Shakespeare', 'LIT1.jpg', 50, 10, 3, '2020-06-08', 'Shakespeare\'s Hamlet is a necessary read for high school students. It opens up many mysteries into what it means to be human that your classes should explore.');

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

CREATE TABLE `cart` (
  `id_cart` int(10) NOT NULL,
  `id_User` int(10) NOT NULL,
  `Image_book` varchar(255) NOT NULL,
  `Name_book` varchar(255) NOT NULL,
  `Price_book` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cart`
--

INSERT INTO `cart` (`id_cart`, `id_User`, `Image_book`, `Name_book`, `Price_book`) VALUES
(1, 2, 'PH1.png', 'The Philosophy for Heroes', 200),
(2, 2, 'PH2.jpg', 'The Philosophy Skills Book', 120),
(8, 3, 'PH1.png', 'The Philosophy for Heroes', 200),
(9, 3, 'SC2.jpg', 'Career Paths Information Technology', 55),
(22, 4, 'PH3.jpg', 'Writing Philosophy', 70);

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id_Category` int(10) NOT NULL,
  `Category_Name` varchar(255) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id_Category`, `Category_Name`, `Image`, `Description`) VALUES
(1, 'Art', 'Artcatg.PNG', 'The arts, also called fine arts, modes of expression that use skill or imagination in the creation of aesthetic objects.'),
(2, 'Science', 'Sciencecatg.PNG', 'Science is a systematic study of the nature and manners of an object .\r\n\r\n'),
(3, 'Phylosophy', 'Phylocatg.PNG', 'Philosophy is the study of general and fundamental questions about existence, knowledge, values, reason, mind, and language. ');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Login` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Date` varchar(16) NOT NULL,
  `Role` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `Username`, `Login`, `Password`, `Date`, `Role`) VALUES
(1, 'Admin', 'Admin@gmail.com', 'Admin', '2020-04-24', 1),
(2, 'ikram', 'ikram@gmail.com', '123456', '2020-04-27', 2),
(3, 'Lina', 'lina@gmail.com', '123456', '2020-04-28', 2),
(4, 'Rayane', 'Rayane@gmail.com', '123456', '2020-06-11', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id_Book`),
  ADD KEY `id_Category` (`id_Category`);

--
-- Index pour la table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id_cart`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_Category`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
  MODIFY `id_Book` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `cart`
--
ALTER TABLE `cart`
  MODIFY `id_cart` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id_Category` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`id_Category`) REFERENCES `category` (`id_Category`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
