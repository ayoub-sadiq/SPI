package fr.univbrest.dosi.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the UNITE_ENSEIGNEMENT database table.
 * 
 */
@Entity
@Table(name="UNITE_ENSEIGNEMENT")
@NamedQuery(name="UniteEnseignement.findAll", query="SELECT u FROM UniteEnseignement u")
public class UniteEnseignement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UniteEnseignementPK id;

	private String description;

	private String designation;

	@Column(name="NBH_CM")
	private BigDecimal nbhCm;

	@Column(name="NBH_TD")
	private BigDecimal nbhTd;

	@Column(name="NBH_TP")
	private BigDecimal nbhTp;

	private String semestre;

	//bi-directional many-to-one association to ElementConstitutif
	@OneToMany(mappedBy="uniteEnseignement")
	@JsonIgnore
	private List<ElementConstitutif> elementConstitutifs;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT", referencedColumnName="NO_ENSEIGNANT")
	private Enseignant enseignant;

	public UniteEnseignement() {
	}

	public UniteEnseignementPK getId() {
		return this.id;
	}

	public void setId(UniteEnseignementPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getNbhCm() {
		return this.nbhCm;
	}

	public void setNbhCm(BigDecimal nbhCm) {
		this.nbhCm = nbhCm;
	}

	public BigDecimal getNbhTd() {
		return this.nbhTd;
	}

	public void setNbhTd(BigDecimal nbhTd) {
		this.nbhTd = nbhTd;
	}

	public BigDecimal getNbhTp() {
		return this.nbhTp;
	}

	public void setNbhTp(BigDecimal nbhTp) {
		this.nbhTp = nbhTp;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<ElementConstitutif> getElementConstitutifs() {
		return this.elementConstitutifs;
	}

	public void setElementConstitutifs(List<ElementConstitutif> elementConstitutifs) {
		this.elementConstitutifs = elementConstitutifs;
	}

	public ElementConstitutif addElementConstitutif(ElementConstitutif elementConstitutif) {
		getElementConstitutifs().add(elementConstitutif);
		elementConstitutif.setUniteEnseignement(this);

		return elementConstitutif;
	}

	public ElementConstitutif removeElementConstitutif(ElementConstitutif elementConstitutif) {
		getElementConstitutifs().remove(elementConstitutif);
		elementConstitutif.setUniteEnseignement(null);

		return elementConstitutif;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

}