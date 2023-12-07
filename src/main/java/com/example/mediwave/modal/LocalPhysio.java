package com.example.mediwave.modal;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="localphysio")
public class LocalPhysio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long idphysio;
	private String acts_et_soins;
	private String adresse;
	private boolean featured;
	private String genre;
	private String gouvernorat;
	private float lat;
	private float lng;
	private String mail;
	private List<String> media;
	private String name;
	private String phone1;
	private String phone2;
	private String prename;
	private String qualification_personnel;
	private String specialty;
	private String _id;
	private String img;
	 @ManyToOne
	    @JoinColumn(name="User_PhysioLocal")
	    private User user;
	public long getIdphysio() {
		return idphysio;
	}
	public void setIdphysio(long idphysio) {
		this.idphysio = idphysio;
	}
	public String getActs_et_soins() {
		return acts_et_soins;
	}
	public void setActs_et_soins(String acts_et_soins) {
		this.acts_et_soins = acts_et_soins;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<String> getMedia() {
		return media;
	}
	public void setMedia(List<String> media) {
		this.media = media;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPrename() {
		return prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public String getQualification_personnel() {
		return qualification_personnel;
	}
	public void setQualification_personnel(String qualification_personnel) {
		this.qualification_personnel = qualification_personnel;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public LocalPhysio(long idphysio, String acts_et_soins, String adresse, boolean featured, String genre,
			String gouvernorat, float lat, float lng, String mail, List<String> media, String name, String phone1,
			String phone2, String prename, String qualification_personnel, String specialty, String _id, String img,
			User user) {
		super();
		this.idphysio = idphysio;
		this.acts_et_soins = acts_et_soins;
		this.adresse = adresse;
		this.featured = featured;
		this.genre = genre;
		this.gouvernorat = gouvernorat;
		this.lat = lat;
		this.lng = lng;
		this.mail = mail;
		this.media = media;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.prename = prename;
		this.qualification_personnel = qualification_personnel;
		this.specialty = specialty;
		this._id = _id;
		this.img = img;
		this.user = user;
	}
	public LocalPhysio(long idphysio, String acts_et_soins, String adresse, boolean featured, String genre,
			String gouvernorat, float lat, float lng, String mail, List<String> media, String name, String phone1,
			String phone2, String prename, String qualification_personnel, String specialty, String _id, String img) {
		super();
		this.idphysio = idphysio;
		this.acts_et_soins = acts_et_soins;
		this.adresse = adresse;
		this.featured = featured;
		this.genre = genre;
		this.gouvernorat = gouvernorat;
		this.lat = lat;
		this.lng = lng;
		this.mail = mail;
		this.media = media;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.prename = prename;
		this.qualification_personnel = qualification_personnel;
		this.specialty = specialty;
		this._id = _id;
		this.img = img;
	} 
	public LocalPhysio() {
		super();
	}

}
