CREATE TABLE TbEmpresaCliente (
CdEmpresaCliente INTEGER NOT NULL,
CNPJ VARCHAR(18) NOT NULL,
InscricaoEstadual VARCHAR(15) NOT NULL,
NmEmpresa VARCHAR(45) NOT NULL,
Telefone VARCHAR(14) NOT NULL,
PRIMARY KEY (CdEmpresaCliente));

CREATE TABLE TbUnidadeMedida (
CdUnidade INTEGER NOT NULL,
NmUnidade VARCHAR(45) NOT NULL,
Descricao VARCHAR(200) NOT NULL,
PRIMARY KEY (CdUnidade));

CREATE TABLE TbCategoria (
CdCategoria INTEGER NOT NULL,
NmCategoria VARCHAR(45) NOT NULL,
Descricao VARCHAR(200) NOT NULL,
CdUnidade INTEGER NOT NULL,
PRIMARY KEY (CdCategoria),
FOREIGN KEY (CdUnidade) REFERENCES TbUnidadeMedida (CdUnidade));

CREATE TABLE TbItemInventario (
CdItemInventario INTEGER NOT NULL,
NmItemInventario VARCHAR(45) NOT NULL,
VlUnitario DOUBLE NOT NULL,
CdCategoria INTEGER NOT NULL,
PRIMARY KEY (CdItemInventario),
FOREIGN KEY (CdCategoria) REFERENCES TbCategoria (CdCategoria));

CREATE TABLE TbEmpresaClienteItemInventario (
CdEmpresaCliente INTEGER NOT NULL,
CdItemInventario INTEGER NOT NULL,
Qtd DOUBLE NOT NULL,
VlUnitario DOUBLE NOT NULL,
PRIMARY KEY (CdEmpresaCliente, CdItemInventario),
FOREIGN KEY (CdEmpresaCliente) REFERENCES TbEmpresaCliente (CdEmpresaCliente),
FOREIGN KEY (CdItemInventario) REFERENCES TbItemInventario (CdItemInventario));

INSERT INTO TbEmpresaCliente VALUES (1, '36.256.169/0001-54', '454.571.250.174', 'POPLAN', '(31)3847-4230');
INSERT INTO TbEmpresaCliente VALUES (2, '22.043.752/0001-72', '534.122.799.441', 'CECMG', '(31)3840-2030');
INSERT INTO TbEmpresaCliente VALUES (3, '83.346.352/0001-20', '271.373.869.560', 'Bretas', '(31)3860-3025');

INSERT INTO TbUnidadeMedida VALUES (1, 'Unidade', 'Unidade de Medida que indica a quantidade unitária de um Item de Inventário');
INSERT INTO TbUnidadeMedida VALUES (2, 'Metro', 'Unidade de Medida de Comprimento do SI');
INSERT INTO TbUnidadeMedida VALUES (3, 'Quilograma', 'Unidade de Medida de Massa do SI');
INSERT INTO TbUnidadeMedida VALUES (4, 'Arroba', 'Unidade de Massa que equivale a 15Kg');


INSERT INTO TbCategoria VALUES (1, 'Computador - Desktop', 'Máquina destinada ao processamento de dados', 1);
INSERT INTO TbCategoria VALUES (2, 'Cabo de Rede', 'O cabo de rede é utilizado para realizar a ligação entre computadores e dispositivos em uma rede', 2);
INSERT INTO TbCategoria VALUES (3, 'Alimento - Grão', 'Semente de certas leguminosas (como o feijão, o tremoço, a ervilha etc.) e de outros vegetais', 3);
INSERT INTO TbCategoria VALUES (4, 'Livro', 'Coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por meio de cola, costura etc., formando um volume que se recobre com capa resistente', 1);


INSERT INTO TbItemInventario VALUES (1, 'Dell Inspiron 20 3000 All in one', 2300, 1);
INSERT INTO TbItemInventario VALUES (2, 'Cabo de Rede Plus Cable CAT6e', 14, 2);
INSERT INTO TbItemInventario VALUES (3, 'Arroz Integral Agulhinha', 14, 3);
INSERT INTO TbItemInventario VALUES (4, 'Feijão Carioca Organico', 25, 3);
INSERT INTO TbItemInventario VALUES (5, 'Ervilha Seca', 4, 3);
INSERT INTO TbItemInventario VALUES (6, 'Dell Inspiron 24 3000 All in one', 3000, 1);
INSERT INTO TbItemInventario VALUES (7, 'O Homem Que Buscava Sua Sombra', 26, 4);
INSERT INTO TbItemInventario VALUES (8, 'Depravado', 35, 4);
INSERT INTO TbItemInventario VALUES (9, 'Olhos Prateados', 23, 4);
INSERT INTO TbItemInventario VALUES (10, 'O Cortiço', 10, 4);


INSERT TbEmpresaClienteItemInventario VALUES (1, 1, 5, 2300);
INSERT TbEmpresaClienteItemInventario VALUES (1, 2, 100, 14);
INSERT TbEmpresaClienteItemInventario VALUES (3, 3, 50, 14);
INSERT TbEmpresaClienteItemInventario VALUES (3, 4, 100, 25);
INSERT TbEmpresaClienteItemInventario VALUES (3, 5, 25, 4);
INSERT TbEmpresaClienteItemInventario VALUES (1, 6, 1, 3000);
INSERT TbEmpresaClienteItemInventario VALUES (2, 7, 2, 26);
INSERT TbEmpresaClienteItemInventario VALUES (2, 8, 1, 35);
INSERT TbEmpresaClienteItemInventario VALUES (2, 9, 3, 23);

/* Letra A */
SELECT CdItemInventario, NmItemInventario, NmCategoria, NmUnidade FROM TbUnidadeMedida UM, TbCategoria C, TbItemInventario II WHERE UM.CdUnidade = C.CdUnidade and C.CdCategoria = II.CdCategoria ORDER BY CdItemInventario;
SELECT CdItemInventario, NmItemInventario, NmCategoria, NmUnidade FROM TbUnidadeMedida UM, TbCategoria C, TbItemInventario II WHERE UM.CdUnidade = C.CdUnidade and C.CdCategoria = II.CdCategoria and NmCategoria = 'Livro' ORDER BY CdItemInventario;

/* Letra B */

SELECT NmItemInventario, ECII.VlUnitario, Qtd, (ECII.VlUnitario * Qtd) AS ValorTotal FROM TbEmpresaCliente EC INNER JOIN TbEmpresaClienteItemInventario ECII ON ECII.CdEmpresaCliente = EC.CdEmpresaCliente INNER JOIN TbItemInventario II ON II.CdItemInventario = ECII.CdItemInventario WHERE NmEmpresa = 'POPLAN';

/* Letra C */

SELECT DISTINCT CdItemInventario, NmItemInventario, VlUnitario FROM TbItemInventario;

/* Letra D */

SELECT NmEmpresa, COUNT(*) as Qtd FROM TbEmpresaCliente E,TbEmpresaClienteItemInventario I WHERE E.CdempresaCliente = I.CdempresaCliente GROUP BY NmEmpresa;
SELECT MAX(VlUnitario) FROM TbEmpresaClienteItemInventario;

/* Letra E */

SELECT NmEmpresa, COUNT(*) as QtdProduto FROM TbEmpresaCliente EC, TbEmpresaClienteItemInventario ECII WHERE EC.CdEmpresaCliente = ECII.CdEmpresaCliente GROUP BY NmEmpresa HAVING QtdProduto > 2;

/* Letra F */

SELECT NmUnidade, NmCategoria FROM TbUnidadeMedida UM LEFT JOIN TbCategoria C ON C.CdUnidade = UM.CdUnidade;
SELECT NmItemInventario, Qtd FROM TbItemInventario II LEFT JOIN TbEmpresaClienteItemInventario ECII ON II.CdItemInventario = ECII.CdItemInventario;

/* Letra G */

CREATE VIEW QuantidadeDeItens AS (SELECT COUNT(*) as QuantidadeDeProdutosCadastrados FROM TbItemInventario);

/* Letra H */

CREATE VIEW ListaEmpresas AS (SELECT CdEmpresaCliente, NmEmpresa, CNPJ, InscricaoEstadual, Telefone FROM TbEmpresaCliente);

/* Letra I */

SELECT CdEmpresaCliente, NmEmpresa FROM TbEmpresaCliente WHERE CdEmpresaCliente NOT IN (1,2);
SELECT CdItemInventario, NmItemInventario, VlUnitario, CdCategoria FROM TbItemInventario WHERE NmItemInventario NOT IN (SELECT NmItemInventario FROM TbItemInventario II INNER JOIN TbEmpresaClienteItemInventario ECII ON II.CdItemInventario = ECII.CdItemInventario);


