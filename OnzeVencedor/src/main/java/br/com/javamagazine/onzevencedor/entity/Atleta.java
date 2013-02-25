package br.com.javamagazine.onzevencedor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atleta implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="IDF_ATLETA")
	private Integer idf;
	
	@Column(name="NOME")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NASCIMENTO")
	private Date dtaNascimento;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="IDF_POSICAO")
	private Posicao posicao;
	
	@ManyToOne
	@JoinColumn(name="IDF_CLUBE")
	private Clube clube;
	
	public Integer getIdf() {
		return idf;
	}
	public void setIdf(Integer idf) {
		this.idf = idf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtaNascimento() {
		return dtaNascimento;
	}
	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}
	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
}
