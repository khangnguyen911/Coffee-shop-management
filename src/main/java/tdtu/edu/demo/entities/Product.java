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
@Table(name = "tbl_product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tensanpham")
	private String tensanpham;
	
	@Column(name = "mota")
	private String mota;
	
	@Column(name = "hinhanh")
	private String hinhanh;
	
	@Column(name = "thanhphan")
	private String thanhphan;
	
	@Column(name = "danhmuc")
	private String danhmuc;
	
	@Column(name = "giaban")
	private int giaban;
}
