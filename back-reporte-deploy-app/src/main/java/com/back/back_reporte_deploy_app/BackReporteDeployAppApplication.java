package com.back.back_reporte_deploy_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackReporteDeployAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackReporteDeployAppApplication.class, args);
	}

}

/*
	Para generar ese deploy necesito generar antes de iniciar el deploy:
	- Se crea usando un objeto
	luego se pone las validaciones para que selecciones y pongas un comentario
	Si es un MAYOR O MENOR, se pone Cambios, Funcionalidades y Componentes deplegados
	Si es un PATCH se describe el bug

	Luego se pone eso para finalmente por cada cuenta, darle la opcion a firmar digitalmente
	Usando un garabato por web y usuario.
*/