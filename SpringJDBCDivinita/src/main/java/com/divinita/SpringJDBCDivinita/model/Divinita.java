package com.divinita.SpringJDBCDivinita.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Scope("prototype")
@Entity
@Data
@Table(name = "Divinita")
public class Divinita {
	
	@Id
	@Column(name = "divinitaId")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "razza")
	private String razza;
	
	@Column(name = "abilita")
	private String abilita;
	
	@Column(name = "equipaggiamento")
	private String equipaggiamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public String getAbilita() {
		return abilita;
	}

	public void setAbilita(String abilita) {
		this.abilita = abilita;
	}

	public String getEquipaggiamento() {
		return equipaggiamento;
	}

	public void setEquipaggiamento(String equipaggiamento) {
		this.equipaggiamento = equipaggiamento;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", razza=" + razza + ", abilita=" + abilita
				+ ", equipaggiamento=" + equipaggiamento;
	}

}
