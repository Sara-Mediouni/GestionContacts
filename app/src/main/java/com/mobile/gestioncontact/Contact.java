package com.mobile.gestioncontact;

public class Contact {
    private int id;
    private String nom,prenom;
    private String tel;

    public Contact(){};

    public Contact(int id,String nom,String prenom,String tel){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getTel(){
        return this.tel;
    }
    public Integer getId(){
        return this.id;
    }
}
