package br.com.caelum.casadocodigo.model;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

/**
 * Permite que a classe Preco seja persistida, desde que ela seja um atributo de uma entidade, 
 * nesse caso ela é um atributo da classe Produto que por sinal é uma entidade.
 */
@Embeddable
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipo;
	
	public Preco(){
		
	}
	
	public Preco(BigDecimal valor, TipoPreco tipo) {
		super();
		this.valor = valor;
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public TipoPreco getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Preco [valor=" + valor + ", tipo=" + tipo + "]";
	}

}
