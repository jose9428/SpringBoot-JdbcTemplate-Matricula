DROP DATABASE IF EXISTS bdmatricula;
create  database bdmatricula;
use bdmatricula;
CREATE TABLE ALUMNO (
	  NROMAT char (6) NOT NULL primary key ,
        CODCUR char (4) ,
	  APENOM VARCHAR (35) , 
        TIPO   CHAR(1)  ,
        PAGO numeric(8,1) 
   );


CREATE TABLE TABESP (
	CODESP char(2) NOT NULL PRIMARY KEY ,
	NOMESP varchar(20) 
);


CREATE TABLE CURSO (
	CODCUR char(4) NOT NULL PRIMARY KEY ,
	CODESP char(2) NULL ,
	NOMCUR varchar(15) NULL ,
	COSTO numeric(8, 1) NULL,
      Nrovac  integer   
); 





INSERT INTO ALUMNO VALUES ('000001','C001','Mariñas Allaso,Carlo','1',230 );
INSERT INTO ALUMNO VALUES ('000002','C002','Tirado Cisneros , Gregorio','2',100 );
INSERT INTO ALUMNO VALUES ('000003','C003','Herreara JUAN SANCHEZ','3',230 );
INSERT INTO ALUMNO VALUES ('000004','C001','ADELA MEZA','1',440 );
INSERT INTO ALUMNO VALUES ('000005','C002','GLORIA DELGADO','1',320 );
INSERT INTO ALUMNO VALUES ('000006','C003','VIRNA MEJIA','2',220 );
INSERT INTO ALUMNO VALUES ('000007','C010','JOSE LINARES','2',220 );
INSERT INTO ALUMNO VALUES ('000008','C008','JENIFER CRUZADO','3',110 );
INSERT INTO ALUMNO VALUES ('000009','C009','RAMON CERCADO','2',110 );
INSERT INTO ALUMNO VALUES ('000010','C012','TERESA EGUSQUIZA','1',320 );
INSERT INTO ALUMNO VALUES ('000011','C013','CAROLINA RETAMOZO','1',230);

INSERT INTO ALUMNO VALUES ('000012','C001','Reyes Francisco','2',230);
INSERT INTO ALUMNO VALUES ('000013','C007','Gonza Patricia','2',220);
INSERT INTO ALUMNO VALUES ('000014','C008','Quispe Maria','1',340);
INSERT INTO ALUMNO VALUES ('000015','C009','Polo Sanchez','2',180);
INSERT INTO ALUMNO VALUES ('000016','C010','Ramos Vanessa','3',250);
INSERT INTO ALUMNO VALUES ('000017','C007','Mendoza Marisol','3',330);
INSERT INTO ALUMNO VALUES ('000018','C011','Ardito Petronila','2',450);
INSERT INTO ALUMNO VALUES ('000019','C011','Hernandez Anastacia','2',450);
INSERT INTO ALUMNO VALUES ('000020','C012','Espinoza Juan','3',250);
INSERT INTO ALUMNO VALUES ('000021','C014','Yucar Carlos','2',230);


INSERT INTO ALUMNO VALUES ('000022','C001','Avellaneda saenz','2',230);
INSERT INTO ALUMNO VALUES ('000023','C007','Bobadilla Patricia','2',220);
INSERT INTO ALUMNO VALUES ('000024','C008','Bustamante Caballero','1',340);
INSERT INTO ALUMNO VALUES ('000025','C009','Carbajo Diaz','2',180);
INSERT INTO ALUMNO VALUES ('000026','C010','Cochachi Shulla','3',250);
INSERT INTO ALUMNO VALUES ('000027','C007','Cotrina Cordova','3',330);
INSERT INTO ALUMNO VALUES ('000028','C011','Escudero Valverde','2',450);
INSERT INTO ALUMNO VALUES ('000029','C011','Vasquez Anastacia','2',450);
INSERT INTO ALUMNO VALUES ('000030','C012','Espinoza Juan','3',250);
INSERT INTO ALUMNO VALUES ('000031','C014','Yucar Carlos','2',230);

INSERT INTO ALUMNO VALUES ('000032','C001','Avellaneda saenz','2',230);
INSERT INTO ALUMNO VALUES ('000033','C007','Bobadilla Patricia','2',220);
INSERT INTO ALUMNO VALUES ('000034','C008','Bustamante Caballero','1',340);
INSERT INTO ALUMNO VALUES ('000035','C009','Carbajo Diaz','2',180);
INSERT INTO ALUMNO VALUES ('000036','C010','Cochachi Shulla','3',250);
INSERT INTO ALUMNO VALUES ('000037','C007','Cotrina Cordova','3',330);
INSERT INTO ALUMNO VALUES ('000038','C011','Escudero Valverde','2',450);
INSERT INTO ALUMNO VALUES ('000039','C011','Vasquez Anastacia','2',450);
INSERT INTO ALUMNO VALUES ('000040','C012','Espinoza Juan','3',250);
INSERT INTO ALUMNO VALUES ('000041','C014','Yucar Carlos','2',230);

INSERT INTO ALUMNO VALUES ('000042','C001','Garcia Avellaneda','1',230 );
INSERT INTO ALUMNO VALUES ('000043','C002','Mamani AlvaREZ','2',100 );
INSERT INTO ALUMNO VALUES ('000044','C001','Mercado Vilca','1',440 );
INSERT INTO ALUMNO VALUES ('000045','C002','Meza Rosas','1',320 );
INSERT INTO ALUMNO VALUES ('000046','C003','Napan ramos','2',220 );
INSERT INTO ALUMNO VALUES ('000047','C010','Quispe Huertas','2',220 );
INSERT INTO ALUMNO VALUES ('000048','C008','Rivera Ramirez','3',110 );
INSERT INTO ALUMNO VALUES ('000049','C009','Santos Hoyos','2',110 );
INSERT INTO ALUMNO VALUES ('000050','C012','TERESA EGUSQUIZA','1',320 );

INSERT INTO tabesp VALUES ('01','Lenguajes Visuales');
INSERT INTO tabesp VALUES ('02','Programacion Web');
INSERT INTO tabesp VALUES ('03','Redes');
INSERT INTO tabesp VALUES ('04','Base de Dato');
INSERT INTO tabesp VALUES ('05','Sistema Operativo');
INSERT INTO tabesp VALUES ('06','Diseño Web');


INSERT INTO Curso VALUES ('C001','01','Java',850 ,10);
INSERT INTO Curso VALUES ('C002','01','Visual Basic',300,12 );
INSERT INTO Curso VALUES ('C003','01','Power Builder',650 ,6);
INSERT INTO Curso VALUES ('C004','01','Visual Rpg',350,13 );
INSERT INTO Curso VALUES ('C005','01','Prolog',450,14 );
INSERT INTO Curso VALUES ('C006','01','Visual Rpg',350,6 );
INSERT INTO Curso VALUES ('C007','02','Interdev',450 ,9);
INSERT INTO Curso VALUES ('C008','02','Dream Weber',650,5 );
INSERT INTO Curso VALUES ('C009','02','HTML',450,11 );
INSERT INTO Curso VALUES ('C010','02','ASP',350,14 );
INSERT INTO Curso VALUES ('C011','03','Windows NT',550,11 );
INSERT INTO Curso VALUES ('C012','03','Linux',650,12 );
INSERT INTO Curso VALUES ('C013','03','Unix',470,7 );
INSERT INTO Curso VALUES ('C014','03','Windos 2000',850,11 );


delimiter @@
drop procedure if exists sp_anularMatricula @@
create procedure sp_anularMatricula
(
_nroMatr char(6) ,
_codCurso char(4)
)
begin
	delete from alumno where NROMAT = _nroMatr;
    update curso set Nrovac = Nrovac + 1 where codcur = _codCurso;
end @@
delimiter ;


delimiter @@
drop procedure if exists sp_guardarMatricula @@
create procedure sp_guardarMatricula
(
_nroMatr char(6) ,
_codCurso char(4) ,
_nomAlumno varchar(30),
_tipo char(1) ,
_pago numeric(8,1)
)
begin
	insert into alumno values(_nroMatr , _codCurso , _nomAlumno,_tipo ,_pago);
    update curso set Nrovac = Nrovac - 1 where codcur = _codCurso;
end @@
delimiter ;





