package com.examplegestionDesNotes.bean;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private double tp=-1;
	private double td=-1;
	private double intero=-1;
	private double sortie=-1;
	private double projet=-1;
	private double stage=-1;
	private double premierControle=-1;
	private double deuxiemeControle=-1;
     private double total=-1;
     private String resultat;
	private String annee;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Module module;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPremierControle() {
		return premierControle;
	}
	public void setPremierControle(double premierControle) {
		this.premierControle = premierControle;
	}
	public double getDeuxiemeControle() {
		return deuxiemeControle;
	}
	public void setDeuxiemeControle(double deuxiemeControle) {
		this.deuxiemeControle = deuxiemeControle;
	}
	public double getTp() {
		return tp;
	}
	public void setTp(double tp) {
		this.tp = tp;
	}
	public double getTd() {
		return td;
	}
	public void setTd(double td) {
		this.td = td;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	 
	
	

	
	
	
	public double getSortie() {
		return sortie;
	}
	public void setSortie(double sortie) {
		this.sortie = sortie;
	}
	public double getProjet() {
		return projet;
	}
	public void setProjet(double projet) {
		this.projet = projet;
	}
	public double getStage() {
		return stage;
	}
	public void setStage(double stage) {
		this.stage = stage;
	}
	public double getIntero() {
		return intero;
	}
	public void setIntero(double intero) {
		this.intero = intero;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		long temp;
		temp = Double.doubleToLongBits(deuxiemeControle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((etudiant == null) ? 0 : etudiant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(intero);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		temp = Double.doubleToLongBits(premierControle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(projet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((resultat == null) ? 0 : resultat.hashCode());
		temp = Double.doubleToLongBits(sortie);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(td);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (Double.doubleToLongBits(deuxiemeControle) != Double.doubleToLongBits(other.deuxiemeControle))
			return false;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(intero) != Double.doubleToLongBits(other.intero))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (Double.doubleToLongBits(premierControle) != Double.doubleToLongBits(other.premierControle))
			return false;
		if (Double.doubleToLongBits(projet) != Double.doubleToLongBits(other.projet))
			return false;
		if (resultat == null) {
			if (other.resultat != null)
				return false;
		} else if (!resultat.equals(other.resultat))
			return false;
		if (Double.doubleToLongBits(sortie) != Double.doubleToLongBits(other.sortie))
			return false;
		if (Double.doubleToLongBits(stage) != Double.doubleToLongBits(other.stage))
			return false;
		if (Double.doubleToLongBits(td) != Double.doubleToLongBits(other.td))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (Double.doubleToLongBits(tp) != Double.doubleToLongBits(other.tp))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Note [id=" + id + ", tp=" + tp + ", td=" + td + ", intero=" + intero + ", sortie=" + sortie
				+ ", projet=" + projet + ", stage=" + stage + ", premierControle=" + premierControle
				+ ", deuxiemeControle=" + deuxiemeControle + ", total=" + total + ", resultat=" + resultat + ", annee="
				+ annee + ", etudiant=" + etudiant + ", module=" + module + "]";
	}
	
	public Note(Long id, double tp, double td, double intero, double sortie, double projet, double stage,
			double premierControle, double deuxiemeControle, double total, String resultat, String annee,
			Etudiant etudiant, Module module) {
		super();
		this.id = id;
		this.tp = tp;
		this.td = td;
		this.intero = intero;
		this.sortie = sortie;
		this.projet = projet;
		this.stage = stage;
		this.premierControle = premierControle;
		this.deuxiemeControle = deuxiemeControle;
		this.total = total;
		this.resultat = resultat;
		this.annee = annee;
		this.etudiant = etudiant;
		this.module = module;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
