package br.com.caelum.casadocodigo.model;

import java.util.Calendar;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	@Lob
	private String descricao;
	
	@DateTimeFormat
	private Calendar dataLancamento;
	
	private int paginas;
	
	//	Indicando que este atributo é uma coleção de elementos (gera uma tabela). Permite armazenar uma lista e persistir
	@ElementCollection
	private List<Preco> precos;
	
	public Produto(){
		
	}
	
	public Produto(Long id, String titulo, String descricao, Calendar dataLancamento, int paginas, List<Preco> precos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataLancamento = dataLancamento;
		this.paginas = paginas;
		this.precos = precos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
	
	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataLancamento="
				+ dataLancamento + ", paginas=" + paginas + ", precos=" + precos + "]";
	}
	
}
