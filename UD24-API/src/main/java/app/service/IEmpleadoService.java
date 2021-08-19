package app.service;

import java.util.List;

import app.dto.Empleado;
import app.dto.Trabajos;

public interface IEmpleadoService {
	
	// Métodos del CRUD
	
	// SELECT POR ID
	public Empleado leerEmpleado(Long id); // Consultar un único empleado POR ID
	
	// SELECT POR NOMBRE
	public List<Empleado> leerEmpleadosPorNombre(String nombre); //Consultar un único empleado por NOMBRE
	
	// SELECT *
	public List<Empleado> leerTodosEmpleados(); // Listar todos los empleados
	
	// SELECT EMPLEADOS POR TRABAJO
	
	public List<Empleado> leerEmpleadosPorTrabajo(String trabajo); // Devuelve todos los empleados de un trabajo
	
	// INSERT
	
	public Empleado insertarEmpleado(Empleado empleado); // INSERTA UN EMPLEADO
	
	// UPDATE 
	
	public Empleado actualizarEmpleado(Empleado empleado); // MODIFICA UN EMPLEADO
	
	// DELETE
	
	public void eliminarEmpleado(Long id); // Elimina un empleado
	
	
	}


