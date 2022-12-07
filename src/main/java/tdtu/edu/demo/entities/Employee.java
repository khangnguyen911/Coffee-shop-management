package tdtu.edu.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ho")
	private String ho;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "tuoi")
	private int tuoi;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "diachi")
	private String diachi;
	
	@Column(name = "bophan")
	private String bophan;
}
