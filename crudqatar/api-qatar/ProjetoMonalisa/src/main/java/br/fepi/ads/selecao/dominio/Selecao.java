package br.fepi.ads.selecao.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Selecao {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int numeroCopas;
	private String corCamisaPrincipal;
	private String corCamisaSecundaria;
	private Boolean favorita;

	// getters and setters
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroCopas() {
		return numeroCopas;
	}
	public void setNumeroCopas(int numeroCopas) {
		this.numeroCopas = numeroCopas;
	}
	public String getCorCamisaPrincipal() {
		return corCamisaPrincipal;
	}
	public void setCorCamisaPrincipal(String corCamisaPrincipal) {
		this.corCamisaPrincipal = corCamisaPrincipal;
	}
	public String getCorCamisaSecundaria() {
		return corCamisaSecundaria;
	}
	public void setCorCamisaSecundaria(String corCamisaSecundaria) {
		this.corCamisaSecundaria = corCamisaSecundaria;
	}
	public Boolean isFavorita() {
		return favorita;
	}
	public void setFavorita(Boolean favorita) {
		this.favorita = favorita;
	}
	
	// construtor
	public Selecao(String nome, int numeroCopas, String corCamisaPrincipal, String corCamisaSecundaria,
			Boolean favorita) {
		this.nome = nome;
		this.numeroCopas = numeroCopas;
		this.corCamisaPrincipal = corCamisaPrincipal;
		this.corCamisaSecundaria = corCamisaSecundaria;
		this.favorita = favorita;	
	}
	
	public Selecao() {
	}
	
}
