package app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name="nombre")
	String nombre;
	@Column(name="salario")
	int salario;
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="trabajo")
	Trabajos trabajo;
	
	private Trabajos AsignarTrabajo(String trabajo) {
		Trabajos enumTrabajo = Trabajos.Desempleado;
		
		if (trabajo.equalsIgnoreCase("Ayudante")) {
			enumTrabajo = Trabajos.Ayudante;
		}
		
		else if (trabajo.equalsIgnoreCase("Montador")) {
			enumTrabajo = Trabajos.Montador;
		}
		
		else if (trabajo.equalsIgnoreCase("Ingeniero")) {
			enumTrabajo = Trabajos.Ingeniero;
		}
		
		return enumTrabajo;

	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Trabajos getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajos trabajo) {
		this.trabajo = trabajo;
	}

	public Empleado() {
		
	}
	
	public Empleado(long id, String trabajo) {
		this.id = id;
		this.trabajo = AsignarTrabajo(trabajo);
		AsignarSalario(this.trabajo);
		
	}
	
	void AsignarSalario(Trabajos trabajo) {
		
		if (trabajo == Trabajos.Montador) {
			this.salario = 1400;
		}
		
		else if (trabajo == Trabajos.Ayudante) {
			this.salario = 1200;
		}
		
		else if (trabajo == Trabajos.Ingeniero) {
			this.salario = 2200;
		}		
	};

}
