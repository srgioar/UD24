package app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.dto.Empleado;
import app.dto.Trabajos;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{
		
		//Listar clientes or campo nombre
		public List<Empleado> findByName(String nombre);
		
		//Listar empleados por campo trabajo
		public List<Empleado> findByJob(String trabajo);
		
		// Insertar empleado asignándole trabajo
		public Empleado insertarEmpleadoConTrabajo(String nombre, String trabajo);
		
		
	}



