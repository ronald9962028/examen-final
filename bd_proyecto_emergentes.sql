-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2021 a las 22:46:47
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_proyecto_emergentes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion`
--

CREATE TABLE `asignacion` (
  `id` int(11) NOT NULL,
  `id_aula` int(11) DEFAULT NULL,
  `id_gestion` int(11) DEFAULT NULL,
  `id_materia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `asignacion`
--

INSERT INTO `asignacion` (`id`, `id_aula`, `id_gestion`, `id_materia`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 2),
(3, 3, 1, 3),
(4, 6, 1, 4),
(5, 4, 1, 5),
(6, 7, 2, 6),
(7, 5, 2, 7),
(8, 1, 2, 8),
(9, 6, 3, 9),
(10, 6, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `id` int(11) NOT NULL,
  `nombre_aula` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`id`, `nombre_aula`) VALUES
(1, 'AULA - 300'),
(2, 'AULA - 301'),
(3, 'AULA - 400'),
(4, 'AULA - 401'),
(5, 'AULA - 402'),
(6, 'LABORATORIO SOFTWARE'),
(7, 'LABORATORIO INTERNET');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestion`
--

CREATE TABLE `gestion` (
  `id` int(11) NOT NULL,
  `nombre_gestion` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `gestion`
--

INSERT INTO `gestion` (`id`, `nombre_gestion`) VALUES
(1, 'PRIMER SEMESTRE'),
(2, 'SEGUNDO SEMESTRE'),
(3, 'TERCER SEMESTRE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `nombre_materia` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id`, `nombre_materia`) VALUES
(1, 'INGLES I'),
(2, 'FISICA I'),
(3, 'ALGEBRA I'),
(4, 'INTRODUCCION A LA PROGRAMACION'),
(5, 'HISTORIA Y CULTURA ANDINA'),
(6, 'PROGRAMACION II'),
(7, 'ALGEBRA II'),
(8, 'FISICA II'),
(9, 'ESTRUCTURA DE DATOS'),
(10, 'BASE DE DATOS I');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `email` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `email`, `password`) VALUES
(1, 'admin@gmail.com', 'd033e22ae348aeb5660fc2140aec35850c4da997');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aula` (`id_aula`),
  ADD KEY `id_gestion` (`id_gestion`),
  ADD KEY `id_materia` (`id_materia`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `gestion`
--
ALTER TABLE `gestion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `gestion`
--
ALTER TABLE `gestion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD CONSTRAINT `asignacion_ibfk_1` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id`),
  ADD CONSTRAINT `asignacion_ibfk_2` FOREIGN KEY (`id_gestion`) REFERENCES `gestion` (`id`),
  ADD CONSTRAINT `asignacion_ibfk_3` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
