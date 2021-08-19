package app.service;

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

import app.dao.IEmpleadoDAO;
import app.dto.Empleado;
import app.dto.Trabajos;

public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	IEmpleadoDAO eDAO;

	@Override
	public Empleado leerEmpleado(Long id) {
		// TODO Auto-generated method stub
		return eDAO.findById(id).get();
	}

	@Override
	public List<Empleado> leerEmpleadosPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return eDAO.findByName(nombre);
	}

	@Override
	public List<Empleado> leerTodosEmpleados() {
		// TODO Auto-generated method stub
		return eDAO.findAll();
	}

	@Override
	public List<Empleado> leerEmpleadosPorTrabajo(String trabajo) {
		// TODO Auto-generated method stub
		return eDAO.findByJob(trabajo);
	}

	@Override
	public Empleado insertarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return eDAO.save(empleado);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return eDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		// TODO Auto-generated method stub
		eDAO.deleteById(id);
		
	}

	
}
