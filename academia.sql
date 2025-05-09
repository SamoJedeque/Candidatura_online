-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Abr-2025 às 06:16
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `academia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

CREATE TABLE `candidato` (
  `user_id` int(11) NOT NULL,
  `nome` varchar(111) NOT NULL,
  `sobrenome` varchar(111) NOT NULL,
  `idade` int(11) NOT NULL,
  `genero` varchar(111) NOT NULL,
  `bairro` varchar(111) NOT NULL,
  `cidade` varchar(111) NOT NULL,
  `escola` varchar(111) NOT NULL,
  `seccao` varchar(111) NOT NULL,
  `nuit` varchar(111) NOT NULL,
  `username` varchar(100) NOT NULL,
  `senha` varchar(111) NOT NULL,
  `nivel_de_acesso` varchar(11) NOT NULL DEFAULT 'canditado'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `candidato`
--

INSERT INTO `candidato` (`user_id`, `nome`, `sobrenome`, `idade`, `genero`, `bairro`, `cidade`, `escola`, `seccao`, `nuit`, `username`, `senha`, `nivel_de_acesso`) VALUES
(1, 'Samo', 'Jedeque', 29, 'Masculino', 'Choupal', 'Maputo', 'Escola Secundaria Francisco Manyanga', 'Ciencias com Desenho', '533363q', 'Jedeque_29_466', 'Jedeque_591', 'canditado'),
(2, 'Edmilson', 'Bie', 12, 'Masculino', 'Laulane', 'Beira', 'Escola Secundaria de Laulane', 'Letras com Geografia', '67464737437B', 'Bie_12_162', 'Bie_21', 'canditado'),
(3, 'Celio', 'Barbosa', 43, 'Masculino', 'COOP', 'Maputo', '', '', '1422532B', 'celio_43', '147258369', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `inscricao`
--

CREATE TABLE `inscricao` (
  `inscricao_id` int(11) NOT NULL,
  `cand_id` int(111) NOT NULL,
  `curso` varchar(111) NOT NULL,
  `status` varchar(111) NOT NULL DEFAULT 'pendente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `inscricao`
--

INSERT INTO `inscricao` (`inscricao_id`, `cand_id`, `curso`, `status`) VALUES
(6, 1, 'Direito', 'PAGO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `paga_id` int(11) NOT NULL,
  `candidatura_id` int(111) NOT NULL,
  `valor` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pagamento`
--

INSERT INTO `pagamento` (`paga_id`, `candidatura_id`, `valor`) VALUES
(1, 6, 1000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `salas`
--

CREATE TABLE `salas` (
  `id` int(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `capacidade` int(11) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `localizacao` varchar(255) DEFAULT NULL,
  `disponivel` varchar(11) DEFAULT 'Disponivel',
  `criado_em` timestamp NOT NULL DEFAULT current_timestamp(),
  `atualizado_em` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `salas`
--

INSERT INTO `salas` (`id`, `nome`, `capacidade`, `tipo`, `localizacao`, `disponivel`, `criado_em`, `atualizado_em`) VALUES
(1, 'Anfiteatro', 20, 'Matematica', 'Brigada', 'Disponivel', '2025-04-24 00:27:08', '2025-04-24 00:27:08'),
(2, 'Sala1', 32, 'Fisica', 'Alto-mae', 'Disponivel', '2025-04-24 00:28:35', '2025-04-24 00:28:35'),
(3, 'E2', 25, 'Biologia', 'Brigada', 'Disponivel', '2025-04-24 00:31:15', '2025-04-24 00:31:15'),
(4, 'A21', 40, 'Quimica', 'Jardim', 'Disponivel', '2025-04-24 00:32:22', '2025-04-24 00:32:22'),
(5, 'H3', 14, 'Historia', 'Alto-mae', 'Disponivel', '2025-04-24 00:33:38', '2025-04-24 00:33:38'),
(6, 'Laboratorio', 10, 'Desenho', 'Junta', 'Disponivel', '2025-04-24 00:34:31', '2025-04-24 00:34:31');

-- --------------------------------------------------------

--
-- Estrutura da tabela `session`
--

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `username` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `candidato`
--
ALTER TABLE `candidato`
  ADD PRIMARY KEY (`user_id`);

--
-- Índices para tabela `inscricao`
--
ALTER TABLE `inscricao`
  ADD PRIMARY KEY (`inscricao_id`),
  ADD UNIQUE KEY `cand_id` (`cand_id`);

--
-- Índices para tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`paga_id`),
  ADD UNIQUE KEY `cand_id` (`candidatura_id`);

--
-- Índices para tabela `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `candidato`
--
ALTER TABLE `candidato`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `inscricao`
--
ALTER TABLE `inscricao`
  MODIFY `inscricao_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `pagamento`
--
ALTER TABLE `pagamento`
  MODIFY `paga_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `salas`
--
ALTER TABLE `salas`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
