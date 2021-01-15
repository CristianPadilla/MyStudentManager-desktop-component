-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-12-2020 a las 03:28:07
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mystudentmanager`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `codigo_curso` varchar(45) NOT NULL,
  `asignatura_curso` varchar(45) NOT NULL,
  `grupo_curso` int(11) NOT NULL,
  `hora_curso` time NOT NULL,
  `dia_curso` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1,
  `id_usuario` int(11) NOT NULL,
  `id_programa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id_curso`, `codigo_curso`, `asignatura_curso`, `grupo_curso`, `hora_curso`, `dia_curso`, `estado`, `id_usuario`, `id_programa`) VALUES
(1, 'FI20204303', 'CALCULO VECTORIAL', 4303, '07:00:00', 'Martes', 1, 3, 1),
(2, 'RE20201003', 'MATEMATICAS BÁSICAS', 1020, '10:30:00', 'Martes', 1, 3, 3),
(4, 'F10354542', 'MEDIO AMBIENTE', 2606, '10:00:00', 'Viernes', 0, 14, 2),
(5, 'F245645', 'ECUACIONES DIFERENCIALES', 3101, '08:00:00', 'Jueves', 1, 13, 3),
(6, 'DI456132', 'FISICA III', 8505, '02:00:00', 'Sabado', 1, 13, 1),
(7, 'GI87456185', 'COMUNICACIÓN Y LENGUAJE', 2202, '09:30:00', 'Lunes', 1, 3, 2),
(8, 'FO15684151', 'Calculo Integral', 6505, '09:30:00', 'Miercoles', 0, 18, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `id_matricula` int(11) NOT NULL,
  `clase1` tinyint(4) DEFAULT NULL,
  `clase2` tinyint(4) DEFAULT NULL,
  `clase3` tinyint(4) DEFAULT NULL,
  `clase4` tinyint(4) DEFAULT NULL,
  `clase5` tinyint(4) DEFAULT NULL,
  `clase6` tinyint(4) DEFAULT NULL,
  `clase7` tinyint(4) DEFAULT NULL,
  `clase8` tinyint(4) DEFAULT NULL,
  `clase9` tinyint(4) DEFAULT NULL,
  `clase10` tinyint(4) DEFAULT NULL,
  `clase11` tinyint(4) DEFAULT NULL,
  `clase12` tinyint(4) DEFAULT NULL,
  `clase13` tinyint(4) DEFAULT NULL,
  `clase14` tinyint(4) DEFAULT NULL,
  `clase15` tinyint(4) DEFAULT NULL,
  `clase16` tinyint(4) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1,
  `id_estudiante` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`id_matricula`, `clase1`, `clase2`, `clase3`, `clase4`, `clase5`, `clase6`, `clase7`, `clase8`, `clase9`, `clase10`, `clase11`, `clase12`, `clase13`, `clase14`, `clase15`, `clase16`, `estado`, `id_estudiante`, `id_curso`) VALUES
(1, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1),
(2, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 1),
(3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 2),
(4, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 11, 2),
(15, 1, 1, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 12, 2),
(16, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 9, 2),
(23, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 9, 1),
(24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 4),
(26, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 15, 4),
(27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 12, 4),
(28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 11, 4),
(29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 9, 4),
(30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 4),
(31, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 9, 5),
(32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 5),
(33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 12, 5),
(34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 6),
(35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 9, 6),
(36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 12, 6),
(37, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 12, 1),
(38, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 7),
(39, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 7),
(40, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 9, 7),
(41, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 12, 7),
(42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 15, 7),
(43, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 19, 7),
(44, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 15, 1),
(45, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 19, 1),
(46, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 20, 1),
(47, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 21, 1),
(48, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 21, 2),
(49, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 20, 2),
(50, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 19, 2),
(51, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 15, 2),
(52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 8),
(53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 21, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `id_notas` int(11) NOT NULL,
  `primer_parcial` double DEFAULT 0,
  `segundo_parcial` double DEFAULT 0,
  `tercer_parcial` double DEFAULT 0,
  `proyecto_integrador` double DEFAULT 0,
  `notas_adicionales` double DEFAULT 0,
  `id_matricula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`id_notas`, `primer_parcial`, `segundo_parcial`, `tercer_parcial`, `proyecto_integrador`, `notas_adicionales`, `id_matricula`) VALUES
(1, 1.3, 4.2, 5, 4.8, 3, 1),
(2, 1.3, 4.2, 0, 0, 0, 2),
(3, 1, 4.2, 3.2, 4.7, 2.2, 3),
(4, 1.3, 0, 0, 0, 0, 4),
(5, 1.2, 1.5, 2.5, 2.5, 4.1, 15),
(6, 0, 3.6, 0, 0, 0, 16),
(8, 3, 4.5, 0, 0, 0, 23),
(9, 0, 0, 0, 0, 0, 24),
(11, 0, 0, 0, 0, 0, 26),
(12, 0, 0, 0, 0, 0, 27),
(13, 0, 0, 0, 0, 0, 28),
(14, 0, 0, 0, 0, 0, 29),
(15, 0, 0, 0, 0, 0, 30),
(16, 0, 0, 0, 0, 0, 31),
(17, 0, 0, 0, 0, 0, 32),
(18, 0, 0, 0, 0, 0, 33),
(19, 0, 0, 0, 0, 0, 34),
(20, 0, 0, 0, 0, 0, 35),
(21, 0, 0, 0, 0, 0, 36),
(22, 4, 3, 0, 0, 0, 37),
(23, 3, 4, 0, 0, 0, 38),
(24, 5, 0, 0, 0, 0, 39),
(25, 1, 0, 0, 0, 0, 40),
(26, 4, 0, 0, 0, 0, 41),
(27, 3.5, 3, 0, 0, 0, 42),
(28, 4.8, 3, 0, 0, 0, 43),
(29, 4, 0, 0, 0, 0, 44),
(30, 2, 3, 0, 0, 0, 45),
(31, 4.5, 0, 0, 0, 0, 46),
(32, 3, 0, 0, 0, 0, 47),
(33, 4, 0, 0, 0, 0, 48),
(34, 3.9, 4, 0, 0, 0, 49),
(35, 3.8, 0, 0, 0, 0, 50),
(36, 4.5, 3, 0, 0, 0, 51),
(37, 0, 0, 0, 0, 0, 52),
(38, 0, 0, 0, 0, 0, 53);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE `programa` (
  `id_programa` int(11) NOT NULL,
  `nombre_programa` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`id_programa`, `nombre_programa`) VALUES
(1, 'INGENIERIA DE SISTEMAS'),
(2, 'COMUNICACIÓN SOCIAL'),
(3, 'INGENIERIA INDUSTRIAL'),
(4, 'SALUD OCUPACIONAL'),
(5, 'DISEÑO GRAFICO'),
(6, 'CONTADURÍA PUBLICA'),
(7, 'ADMINISTRACIÓN EN SALUD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre_rol`) VALUES
(3, 'estudiante'),
(4, 'profesor'),
(5, 'administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,
  `documento_identidad` bigint(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `nombre_usuario`, `correo_electronico`, `documento_identidad`, `id_rol`, `estado`) VALUES
(1, 'Daniela Rojas', 'DaniR', 'rdanny3533@gmail.com', 12345, 3, 1),
(2, 'Cristian Lozada padilla', 'CrisL', 'crislozada@mail.com', 24526, 3, 1),
(3, 'Carlos Rodriguez', 'carloR', 'carlosr@hotmail.com', 54321, 4, 1),
(4, 'Carolina Ramirez', 'carorami', 'carito@gmail.com', 33453, 5, 1),
(8, 'pepito ramirez', 'pepe', 'pepipepe@mai.co', 12232, 4, 0),
(9, 'Jhoana Silva', 'Jhoanita06', 'jhoana@hotmail.com', 23378, 3, 1),
(11, 'Andres Cortez', 'andre', 'andre@mail.com', 23342, 3, 0),
(12, 'Andrea Fernandez', 'andrikta', 'andreita@mail.com', 56423, 3, 1),
(13, 'Juan Martinez', 'juanMa1', 'juanm@gmail.com', 35241, 4, 1),
(14, 'Ricardo Muñoz', 'RicardM', 'RicardoMuñ2000@gmail.com', 12335, 4, 1),
(15, 'Fabian Lopez', 'FabL', 'FabianLz@gmail.com', 12348, 3, 1),
(16, 'Pablo Torrez', 'Pabz', 'Pabz@gmail.com', 98765, 5, 1),
(17, 'Eduardo perez', 'eduardp', 'eduardp@gmail.com', 45345, 4, 1),
(18, 'Antonella Pettergrow', 'antonp', 'antonp@gmail.com', 54161, 4, 1),
(19, 'Manolo Gonzales', 'manogo', 'manogo@gmail.com', 45687, 3, 1),
(20, 'Shakira Pique ', 'Shakp', 'shakp@gmail.com', 98756, 3, 1),
(21, 'Dua Lipa ', 'dualp', 'dualp@hotmail.com', 98745, 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `fk_programaCurso_idx` (`id_programa`),
  ADD KEY `fk_usuarioCurso_idx` (`id_usuario`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id_matricula`),
  ADD KEY `fk_usuarioMatricula_idx` (`id_estudiante`),
  ADD KEY `fk_cursoMatricula_idx` (`id_curso`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`id_notas`),
  ADD KEY `fk_matriculaNotas_idx` (`id_matricula`);

--
-- Indices de la tabla `programa`
--
ALTER TABLE `programa`
  ADD PRIMARY KEY (`id_programa`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_rolUsuario_idx` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `id_matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `id_notas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `programa`
--
ALTER TABLE `programa`
  MODIFY `id_programa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_programaCurso` FOREIGN KEY (`id_programa`) REFERENCES `programa` (`id_programa`),
  ADD CONSTRAINT `fk_usuarioCurso` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `fk_cursoMatricula` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`),
  ADD CONSTRAINT `fk_usuarioMatricula` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `fk_matriculaNotas` FOREIGN KEY (`id_matricula`) REFERENCES `matricula` (`id_matricula`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_rolUsuario` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
