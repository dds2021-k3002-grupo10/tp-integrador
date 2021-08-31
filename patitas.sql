-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-08-2021 a las 01:48:47
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `patitas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicativo`
--

CREATE TABLE `aplicativo` (
  `ID_APLICATIVO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  `OBSERVACION` varchar(200) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `aplicativo`
--

INSERT INTO `aplicativo` (`ID_APLICATIVO`, `DESCRIPCION`, `OBSERVACION`, `ESTADO`) VALUES
(1, 'PATITAS', 'Patitas, aplicacion inicial', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicativo_rol`
--

CREATE TABLE `aplicativo_rol` (
  `ID_APLICATIVO_ROL` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL,
  `ID_APLICATIVO` int(11) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `aplicativo_rol`
--

INSERT INTO `aplicativo_rol` (`ID_APLICATIVO_ROL`, `DESCRIPCION`, `ID_APLICATIVO`, `ESTADO`) VALUES
(1, 'ADMINISTRADOR', 1, 'A'),
(2, 'USUARIO', 1, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica`
--

CREATE TABLE `caracteristica` (
  `ID_CARACTERISTICA` int(11) NOT NULL,
  `DESCRIPCION_FAQ` varchar(100) NOT NULL,
  `ID_ORGANIZACION` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A',
  `ID_COMPORTAMIENTO_TIPO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica_detalle`
--

CREATE TABLE `caracteristica_detalle` (
  `ID_DETALLE` int(11) NOT NULL,
  `ID_MASCOTA` int(11) NOT NULL,
  `ID_CARACTERISTICA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica_detalle_valor`
--

CREATE TABLE `caracteristica_detalle_valor` (
  `ID_DETALLE_VALOR` int(11) NOT NULL,
  `ID_DETALLE` int(11) NOT NULL,
  `ID_VALOR` int(11) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica_valor`
--

CREATE TABLE `caracteristica_valor` (
  `ID_CARACTERISTICA_VALOR` int(11) NOT NULL,
  `ID_CARACTERISTICA` int(11) NOT NULL,
  `ID_VALOR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comportamiento_tipo`
--

CREATE TABLE `comportamiento_tipo` (
  `ID_COMPORTAMIENTO_TIPO` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comportamiento_tipo`
--

INSERT INTO `comportamiento_tipo` (`ID_COMPORTAMIENTO_TIPO`, `DESCRIPCION`) VALUES
(1, 'RADIOBUTTON'),
(2, 'CHECKBOX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto_medio_notificacion`
--

CREATE TABLE `contacto_medio_notificacion` (
  `ID_CONTACTO_NOTIFICACION` int(11) NOT NULL,
  `ID_PERSONA_CONTACTO` int(11) NOT NULL,
  `ID_MEDIO_NOTIFICACION` int(11) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A',
  `PREFERIDO` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `ID_MASCOTA` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `APODO` varchar(50) NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `ID_SEXO` int(11) NOT NULL,
  `DESCRIPCION_FISICA` varchar(2000) NOT NULL,
  `ID_TIPO_MASCOTA` int(11) NOT NULL,
  `ID_PERSONA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`ID_MASCOTA`, `NOMBRE`, `APODO`, `FECHA_NACIMIENTO`, `ID_SEXO`, `DESCRIPCION_FISICA`, `ID_TIPO_MASCOTA`, `ID_PERSONA`, `FECHA_ALTA`, `FECHA_ULTIMA_MODIFICACION`, `FECHA_BAJA`, `ESTADO`) VALUES
(1, 'LOBA', 'LOBITA', '2021-08-09', 1, '', 1, 1, '2021-08-27', '2021-08-27', NULL, 'A'),
(3, 'COMOTU', 'COMO', '2021-08-03', 1, '', 1, 1, '2021-08-27', '2021-08-27', NULL, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota_foto`
--

CREATE TABLE `mascota_foto` (
  `ID_MASCOTA_FOTO` int(11) NOT NULL,
  `VALOR_FOTO` blob NOT NULL,
  `ID_MASCOTA` int(11) DEFAULT NULL,
  `ID_MASCOTA_RESCATADA` int(11) DEFAULT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota_hogar_transito`
--

CREATE TABLE `mascota_hogar_transito` (
  `ID_MASCOTA_HOGAR` int(11) NOT NULL,
  `ID_HOGAR` int(11) NOT NULL,
  `ID_MASCOTA_RESCATADA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota_rescatada`
--

CREATE TABLE `mascota_rescatada` (
  `ID_MASCOTA_RESCATADA` int(11) NOT NULL,
  `DESCRIPCION` varchar(2000) NOT NULL,
  `ID_PERSONA` int(11) NOT NULL,
  `ID_TIPO_MASCOTA` int(11) NOT NULL,
  `ID_TAMANIO` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medio_notificacion`
--

CREATE TABLE `medio_notificacion` (
  `ID_MEDIO_NOTIFICACION` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `normaliza_img`
--

CREATE TABLE `normaliza_img` (
  `ID_NORMALIZA_IMG` int(11) NOT NULL,
  `ANCHO` int(11) NOT NULL,
  `LARGO` int(11) NOT NULL,
  `CALIDAD` int(11) NOT NULL,
  `ID_ORGANIZACION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `normaliza_img`
--

INSERT INTO `normaliza_img` (`ID_NORMALIZA_IMG`, `ANCHO`, `LARGO`, `CALIDAD`, `ID_ORGANIZACION`) VALUES
(1, 5, 5, 100, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizacion`
--

CREATE TABLE `organizacion` (
  `ID_ORGANIZACION` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `URL_NOMALIZADOR` varchar(200) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `organizacion`
--

INSERT INTO `organizacion` (`ID_ORGANIZACION`, `NOMBRE`, `URL_NOMALIZADOR`, `ESTADO`) VALUES
(1, 'UTN', 'URL_NORMALIZADOR', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `ID_PERSONA` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `APELLIDO` varchar(50) NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE`, `APELLIDO`, `FECHA_NACIMIENTO`, `FECHA_ALTA`, `FECHA_ULTIMA_MODIFICACION`, `FECHA_BAJA`, `ESTADO`) VALUES
(1, 'GRUPO', 'DIEZ', '2021-08-10', '2021-08-27', '2021-08-27', NULL, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_contacto`
--

CREATE TABLE `persona_contacto` (
  `ID_PERSONA_CONTACTO` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `APELLIDO` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `TELEFONO` int(11) NOT NULL,
  `ID_PERSONA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_direccion`
--

CREATE TABLE `persona_direccion` (
  `ID_DIRECCION` int(11) NOT NULL,
  `CALLE` varchar(200) NOT NULL,
  `NUMERO` int(3) NOT NULL,
  `PISO` int(11) DEFAULT NULL,
  `DEPARTAMENTO` varchar(2) DEFAULT NULL,
  `OBSERVACIONES` varchar(2000) DEFAULT NULL,
  `COD_POSTAL` int(11) DEFAULT NULL,
  `ID_PERSONA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_documento`
--

CREATE TABLE `persona_documento` (
  `ID_DOCUMENTO` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `ID_TIPO_DOC` int(11) NOT NULL,
  `ID_PERSONA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo_mascota`
--

CREATE TABLE `sexo_mascota` (
  `ID_SEXO` int(11) NOT NULL,
  `DESCRIPCION` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sexo_mascota`
--

INSERT INTO `sexo_mascota` (`ID_SEXO`, `DESCRIPCION`) VALUES
(1, 'HEMBRA'),
(2, 'MACHO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tamanio_mascota`
--

CREATE TABLE `tamanio_mascota` (
  `ID_TAMANIO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tamanio_mascota`
--

INSERT INTO `tamanio_mascota` (`ID_TAMANIO`, `DESCRIPCION`, `ESTADO`) VALUES
(1, 'GRANDE', 'A'),
(2, 'MEDIANO', 'A'),
(3, 'CHICO', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `ID_TIPO_DOC` int(11) NOT NULL,
  `DESCRIPCION_CORTA` varchar(5) NOT NULL,
  `DESCRIPCION_LARGA` varchar(50) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`ID_TIPO_DOC`, `DESCRIPCION_CORTA`, `DESCRIPCION_LARGA`, `ESTADO`) VALUES
(1, 'DNI', 'DOCUMENTO NACIONAL DE IDENTIDAD', 'A'),
(2, 'CM', 'CEDULA DEL MERCOSUR', 'A'),
(3, 'LC', 'LIBRETA CIVICA', 'A'),
(4, 'LE', 'LIBRETA DE ENROLAMIENTO', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_mascota`
--

CREATE TABLE `tipo_mascota` (
  `ID_TIPO_MASCOTA` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_mascota`
--

INSERT INTO `tipo_mascota` (`ID_TIPO_MASCOTA`, `NOMBRE`) VALUES
(1, 'PERRO'),
(2, 'GATO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion_mascota_rescatada`
--

CREATE TABLE `ubicacion_mascota_rescatada` (
  `ID_UBICACION` int(11) NOT NULL,
  `DIRECCION` varchar(200) NOT NULL,
  `LATITUD` int(11) DEFAULT NULL,
  `LONGITUD` int(11) DEFAULT NULL,
  `ID_MASCOTA_RESCATADA` int(11) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `CLAVE` varchar(80) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `FECHA_ULTIMA_MODIFICACION` date NOT NULL,
  `FECHA_BAJA` int(11) DEFAULT NULL,
  `CANTIDAD_LOGIN` int(11) NOT NULL DEFAULT 0,
  `ID_PERSONA` int(11) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `NOMBRE`, `CLAVE`, `FECHA_ALTA`, `FECHA_ULTIMA_MODIFICACION`, `FECHA_BAJA`, `CANTIDAD_LOGIN`, `ID_PERSONA`, `ESTADO`) VALUES
(1, 'GRUPO.DIEZ', '123456', '2021-08-27', '2021-08-27', NULL, 0, 1, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_organizacion`
--

CREATE TABLE `usuario_organizacion` (
  `ID_USUARIO_ORG` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `ID_ORGANIZACION` int(11) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_organizacion`
--

INSERT INTO `usuario_organizacion` (`ID_USUARIO_ORG`, `ID_USUARIO`, `ID_ORGANIZACION`, `ESTADO`) VALUES
(1, 1, 1, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `ID_USUARIO_ROL` int(11) NOT NULL,
  `ID_USUARIO_ORG` int(11) NOT NULL,
  `ID_APLICATIVO_ROL` int(11) NOT NULL,
  `ESTADO` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`ID_USUARIO_ROL`, `ID_USUARIO_ORG`, `ID_APLICATIVO_ROL`, `ESTADO`) VALUES
(1, 1, 1, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valor`
--

CREATE TABLE `valor` (
  `ID_VALOR` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aplicativo`
--
ALTER TABLE `aplicativo`
  ADD PRIMARY KEY (`ID_APLICATIVO`);

--
-- Indices de la tabla `aplicativo_rol`
--
ALTER TABLE `aplicativo_rol`
  ADD PRIMARY KEY (`ID_APLICATIVO_ROL`),
  ADD KEY `ID_APLICATIVO` (`ID_APLICATIVO`);

--
-- Indices de la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  ADD PRIMARY KEY (`ID_CARACTERISTICA`),
  ADD KEY `ID_ORGANIZACION` (`ID_ORGANIZACION`),
  ADD KEY `ID_COMPORTAMIENTO_TIPO` (`ID_COMPORTAMIENTO_TIPO`);

--
-- Indices de la tabla `caracteristica_detalle`
--
ALTER TABLE `caracteristica_detalle`
  ADD PRIMARY KEY (`ID_DETALLE`),
  ADD KEY `ID_MASCOTA` (`ID_MASCOTA`),
  ADD KEY `ID_CARACTERISTICA` (`ID_CARACTERISTICA`);

--
-- Indices de la tabla `caracteristica_detalle_valor`
--
ALTER TABLE `caracteristica_detalle_valor`
  ADD PRIMARY KEY (`ID_DETALLE_VALOR`),
  ADD KEY `ID_DETALLE` (`ID_DETALLE`),
  ADD KEY `ID_VALOR` (`ID_VALOR`);

--
-- Indices de la tabla `caracteristica_valor`
--
ALTER TABLE `caracteristica_valor`
  ADD PRIMARY KEY (`ID_CARACTERISTICA_VALOR`),
  ADD KEY `ID_CARACTERISTICA` (`ID_CARACTERISTICA`),
  ADD KEY `ID_VALOR` (`ID_VALOR`);

--
-- Indices de la tabla `comportamiento_tipo`
--
ALTER TABLE `comportamiento_tipo`
  ADD PRIMARY KEY (`ID_COMPORTAMIENTO_TIPO`);

--
-- Indices de la tabla `contacto_medio_notificacion`
--
ALTER TABLE `contacto_medio_notificacion`
  ADD PRIMARY KEY (`ID_CONTACTO_NOTIFICACION`),
  ADD KEY `ID_PERSONA_CONTACTO` (`ID_PERSONA_CONTACTO`),
  ADD KEY `ID_MEDIO_NOTIFICACION` (`ID_MEDIO_NOTIFICACION`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`ID_MASCOTA`),
  ADD KEY `ID_SEXO` (`ID_SEXO`),
  ADD KEY `ID_TIPO_MASCOTA` (`ID_TIPO_MASCOTA`),
  ADD KEY `ID_PERSONA` (`ID_PERSONA`);

--
-- Indices de la tabla `mascota_foto`
--
ALTER TABLE `mascota_foto`
  ADD PRIMARY KEY (`ID_MASCOTA_FOTO`),
  ADD KEY `ID_MASCOTA` (`ID_MASCOTA`),
  ADD KEY `ID_MASCOTA_RESCATADA` (`ID_MASCOTA_RESCATADA`);

--
-- Indices de la tabla `mascota_hogar_transito`
--
ALTER TABLE `mascota_hogar_transito`
  ADD PRIMARY KEY (`ID_MASCOTA_HOGAR`),
  ADD KEY `ID_MASCOTA_RESCATADA` (`ID_MASCOTA_RESCATADA`);

--
-- Indices de la tabla `mascota_rescatada`
--
ALTER TABLE `mascota_rescatada`
  ADD PRIMARY KEY (`ID_MASCOTA_RESCATADA`),
  ADD KEY `ID_PERSONA` (`ID_PERSONA`),
  ADD KEY `ID_TIPO_MASCOTA` (`ID_TIPO_MASCOTA`),
  ADD KEY `ID_TAMANIO` (`ID_TAMANIO`);

--
-- Indices de la tabla `medio_notificacion`
--
ALTER TABLE `medio_notificacion`
  ADD PRIMARY KEY (`ID_MEDIO_NOTIFICACION`);

--
-- Indices de la tabla `normaliza_img`
--
ALTER TABLE `normaliza_img`
  ADD PRIMARY KEY (`ID_NORMALIZA_IMG`),
  ADD KEY `ID_ORGANIZACION` (`ID_ORGANIZACION`);

--
-- Indices de la tabla `organizacion`
--
ALTER TABLE `organizacion`
  ADD PRIMARY KEY (`ID_ORGANIZACION`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`ID_PERSONA`);

--
-- Indices de la tabla `persona_contacto`
--
ALTER TABLE `persona_contacto`
  ADD PRIMARY KEY (`ID_PERSONA_CONTACTO`),
  ADD KEY `ID_PERSONA` (`ID_PERSONA`);

--
-- Indices de la tabla `persona_direccion`
--
ALTER TABLE `persona_direccion`
  ADD PRIMARY KEY (`ID_DIRECCION`),
  ADD KEY `ID_PERSONA` (`ID_PERSONA`);

--
-- Indices de la tabla `persona_documento`
--
ALTER TABLE `persona_documento`
  ADD PRIMARY KEY (`ID_DOCUMENTO`),
  ADD KEY `ID_TIPO_DOC` (`ID_TIPO_DOC`),
  ADD KEY `ID_PERSONA` (`ID_PERSONA`);

--
-- Indices de la tabla `sexo_mascota`
--
ALTER TABLE `sexo_mascota`
  ADD PRIMARY KEY (`ID_SEXO`);

--
-- Indices de la tabla `tamanio_mascota`
--
ALTER TABLE `tamanio_mascota`
  ADD PRIMARY KEY (`ID_TAMANIO`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`ID_TIPO_DOC`);

--
-- Indices de la tabla `tipo_mascota`
--
ALTER TABLE `tipo_mascota`
  ADD PRIMARY KEY (`ID_TIPO_MASCOTA`);

--
-- Indices de la tabla `ubicacion_mascota_rescatada`
--
ALTER TABLE `ubicacion_mascota_rescatada`
  ADD PRIMARY KEY (`ID_UBICACION`),
  ADD KEY `ID_MASCOTA_RESCATADA` (`ID_MASCOTA_RESCATADA`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD KEY `ID_PERSONA` (`ID_PERSONA`);

--
-- Indices de la tabla `usuario_organizacion`
--
ALTER TABLE `usuario_organizacion`
  ADD PRIMARY KEY (`ID_USUARIO_ORG`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`),
  ADD KEY `ID_ORGANIZACION` (`ID_ORGANIZACION`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`ID_USUARIO_ROL`),
  ADD KEY `ID_USUARIO_ORG` (`ID_USUARIO_ORG`),
  ADD KEY `ID_APLICATIVO_ROL` (`ID_APLICATIVO_ROL`);

--
-- Indices de la tabla `valor`
--
ALTER TABLE `valor`
  ADD PRIMARY KEY (`ID_VALOR`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aplicativo`
--
ALTER TABLE `aplicativo`
  MODIFY `ID_APLICATIVO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `aplicativo_rol`
--
ALTER TABLE `aplicativo_rol`
  MODIFY `ID_APLICATIVO_ROL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  MODIFY `ID_CARACTERISTICA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caracteristica_detalle`
--
ALTER TABLE `caracteristica_detalle`
  MODIFY `ID_DETALLE` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caracteristica_detalle_valor`
--
ALTER TABLE `caracteristica_detalle_valor`
  MODIFY `ID_DETALLE_VALOR` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caracteristica_valor`
--
ALTER TABLE `caracteristica_valor`
  MODIFY `ID_CARACTERISTICA_VALOR` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comportamiento_tipo`
--
ALTER TABLE `comportamiento_tipo`
  MODIFY `ID_COMPORTAMIENTO_TIPO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `contacto_medio_notificacion`
--
ALTER TABLE `contacto_medio_notificacion`
  MODIFY `ID_CONTACTO_NOTIFICACION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `ID_MASCOTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `mascota_foto`
--
ALTER TABLE `mascota_foto`
  MODIFY `ID_MASCOTA_FOTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota_hogar_transito`
--
ALTER TABLE `mascota_hogar_transito`
  MODIFY `ID_MASCOTA_HOGAR` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota_rescatada`
--
ALTER TABLE `mascota_rescatada`
  MODIFY `ID_MASCOTA_RESCATADA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medio_notificacion`
--
ALTER TABLE `medio_notificacion`
  MODIFY `ID_MEDIO_NOTIFICACION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `normaliza_img`
--
ALTER TABLE `normaliza_img`
  MODIFY `ID_NORMALIZA_IMG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `organizacion`
--
ALTER TABLE `organizacion`
  MODIFY `ID_ORGANIZACION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `ID_PERSONA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `persona_contacto`
--
ALTER TABLE `persona_contacto`
  MODIFY `ID_PERSONA_CONTACTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona_direccion`
--
ALTER TABLE `persona_direccion`
  MODIFY `ID_DIRECCION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona_documento`
--
ALTER TABLE `persona_documento`
  MODIFY `ID_DOCUMENTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sexo_mascota`
--
ALTER TABLE `sexo_mascota`
  MODIFY `ID_SEXO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tamanio_mascota`
--
ALTER TABLE `tamanio_mascota`
  MODIFY `ID_TAMANIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `ID_TIPO_DOC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_mascota`
--
ALTER TABLE `tipo_mascota`
  MODIFY `ID_TIPO_MASCOTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ubicacion_mascota_rescatada`
--
ALTER TABLE `ubicacion_mascota_rescatada`
  MODIFY `ID_UBICACION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario_organizacion`
--
ALTER TABLE `usuario_organizacion`
  MODIFY `ID_USUARIO_ORG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  MODIFY `ID_USUARIO_ROL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `valor`
--
ALTER TABLE `valor`
  MODIFY `ID_VALOR` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aplicativo_rol`
--
ALTER TABLE `aplicativo_rol`
  ADD CONSTRAINT `fk_id_aplicativo` FOREIGN KEY (`ID_APLICATIVO`) REFERENCES `aplicativo` (`ID_APLICATIVO`);

--
-- Filtros para la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  ADD CONSTRAINT `caracteristica_ibfk_1` FOREIGN KEY (`ID_COMPORTAMIENTO_TIPO`) REFERENCES `comportamiento_tipo` (`ID_COMPORTAMIENTO_TIPO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `caracteristica_ibfk_2` FOREIGN KEY (`ID_ORGANIZACION`) REFERENCES `organizacion` (`ID_ORGANIZACION`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `caracteristica_detalle`
--
ALTER TABLE `caracteristica_detalle`
  ADD CONSTRAINT `caracteristica_detalle_ibfk_1` FOREIGN KEY (`ID_CARACTERISTICA`) REFERENCES `caracteristica_detalle_valor` (`ID_DETALLE_VALOR`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `caracteristica_detalle_ibfk_2` FOREIGN KEY (`ID_MASCOTA`) REFERENCES `mascota` (`ID_MASCOTA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `caracteristica_detalle_valor`
--
ALTER TABLE `caracteristica_detalle_valor`
  ADD CONSTRAINT `caracteristica_detalle_valor_ibfk_1` FOREIGN KEY (`ID_DETALLE`) REFERENCES `caracteristica_detalle` (`ID_DETALLE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `caracteristica_detalle_valor_ibfk_2` FOREIGN KEY (`ID_VALOR`) REFERENCES `valor` (`ID_VALOR`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `caracteristica_valor`
--
ALTER TABLE `caracteristica_valor`
  ADD CONSTRAINT `caracteristica_valor_ibfk_1` FOREIGN KEY (`ID_CARACTERISTICA`) REFERENCES `caracteristica` (`ID_CARACTERISTICA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `caracteristica_valor_ibfk_2` FOREIGN KEY (`ID_VALOR`) REFERENCES `valor` (`ID_VALOR`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `contacto_medio_notificacion`
--
ALTER TABLE `contacto_medio_notificacion`
  ADD CONSTRAINT `contacto_medio_notificacion_ibfk_1` FOREIGN KEY (`ID_MEDIO_NOTIFICACION`) REFERENCES `medio_notificacion` (`ID_MEDIO_NOTIFICACION`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contacto_medio_notificacion_ibfk_2` FOREIGN KEY (`ID_PERSONA_CONTACTO`) REFERENCES `persona_contacto` (`ID_PERSONA_CONTACTO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mascota_ibfk_2` FOREIGN KEY (`ID_SEXO`) REFERENCES `sexo_mascota` (`ID_SEXO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mascota_ibfk_3` FOREIGN KEY (`ID_TIPO_MASCOTA`) REFERENCES `tipo_mascota` (`ID_TIPO_MASCOTA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota_foto`
--
ALTER TABLE `mascota_foto`
  ADD CONSTRAINT `mascota_foto_ibfk_1` FOREIGN KEY (`ID_MASCOTA`) REFERENCES `mascota` (`ID_MASCOTA`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `mascota_foto_ibfk_2` FOREIGN KEY (`ID_MASCOTA_RESCATADA`) REFERENCES `mascota_rescatada` (`ID_MASCOTA_RESCATADA`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `mascota_hogar_transito`
--
ALTER TABLE `mascota_hogar_transito`
  ADD CONSTRAINT `mascota_hogar_transito_ibfk_1` FOREIGN KEY (`ID_MASCOTA_RESCATADA`) REFERENCES `mascota_rescatada` (`ID_MASCOTA_RESCATADA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota_rescatada`
--
ALTER TABLE `mascota_rescatada`
  ADD CONSTRAINT `mascota_rescatada_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mascota_rescatada_ibfk_2` FOREIGN KEY (`ID_TAMANIO`) REFERENCES `tamanio_mascota` (`ID_TAMANIO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mascota_rescatada_ibfk_3` FOREIGN KEY (`ID_TIPO_MASCOTA`) REFERENCES `tipo_mascota` (`ID_TIPO_MASCOTA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `normaliza_img`
--
ALTER TABLE `normaliza_img`
  ADD CONSTRAINT `normaliza_img_ibfk_1` FOREIGN KEY (`ID_ORGANIZACION`) REFERENCES `organizacion` (`ID_ORGANIZACION`);

--
-- Filtros para la tabla `persona_contacto`
--
ALTER TABLE `persona_contacto`
  ADD CONSTRAINT `persona_contacto_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona_direccion`
--
ALTER TABLE `persona_direccion`
  ADD CONSTRAINT `persona_direccion_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona_documento`
--
ALTER TABLE `persona_documento`
  ADD CONSTRAINT `persona_documento_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `persona_documento_ibfk_2` FOREIGN KEY (`ID_TIPO_DOC`) REFERENCES `tipo_documento` (`ID_TIPO_DOC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ubicacion_mascota_rescatada`
--
ALTER TABLE `ubicacion_mascota_rescatada`
  ADD CONSTRAINT `ubicacion_mascota_rescatada_ibfk_1` FOREIGN KEY (`ID_MASCOTA_RESCATADA`) REFERENCES `mascota_rescatada` (`ID_MASCOTA_RESCATADA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_organizacion`
--
ALTER TABLE `usuario_organizacion`
  ADD CONSTRAINT `usuario_organizacion_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_organizacion_ibfk_2` FOREIGN KEY (`ID_ORGANIZACION`) REFERENCES `organizacion` (`ID_ORGANIZACION`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `usuario_rol_ibfk_1` FOREIGN KEY (`ID_APLICATIVO_ROL`) REFERENCES `aplicativo_rol` (`ID_APLICATIVO_ROL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_rol_ibfk_2` FOREIGN KEY (`ID_USUARIO_ORG`) REFERENCES `usuario_organizacion` (`ID_USUARIO_ORG`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
