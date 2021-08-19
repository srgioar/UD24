package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.Empleado;
import app.dto.Trabajos;
import app.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/empleados")
	public List <Empleado> leerEmpleados(){
		return empleadoServiceImpl.leerTodosEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	public Empleado leerEmpleadoPorId(@PathVariable(name="id") long id) {
		Empleado emp = new Empleado();
		emp = empleadoServiceImpl.leerEmpleado(id);
		return emp;
	}
	
	//listar Clientes por campo nombre
	@GetMapping("/empleados/nombre/{nombre}")
	public List <Empleado> leerEmpleadosPorNombre(@PathVariable(name="nombre") String nombre) {
		return empleadoServiceImpl.leerEmpleadosPorNombre(nombre);
	}
	
	@PostMapping("/empleados")
	public Empleado insertarEmpleado(@PathVariable(name="nombre") String nombre, @PathVariable(name="trabajo") Trabajos trabajo) {
		Empleado emp = new Empleado();
		emp.setNombre(nombre);
		emp.setTrabajo(trabajo);
		return empleadoServiceImpl.insertarEmpleado(emp);
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado modificarEmpleadoPorId(@PathVariable(name="id") Long id, @RequestBody Empleado empleado) {
		
		Empleado emp_original, emp_modificado;
		emp_original = new Empleado();
		emp_modificado = new Empleado();
		
		emp_original = empleadoServiceImpl.leerEmpleado(id);
		
		emp_original.setNombre(empleado.getNombre());
		emp_original.setSalario(empleado.getSalario());
		emp_original.setTrabajo(empleado.getTrabajo());
		
		emp_modificado = empleadoServiceImpl.actualizarEmpleado(emp_original);
		
		System.out.println("El empleado actualizado es: "+ emp_modificado);
		
		return emp_modificado;
		
	}
	
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleadoPorId(@PathVariable(name="id") long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}

}
