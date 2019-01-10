package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class ZaposlenDto implements Serializable {

    private short zaposlenId;
    private String ime;
    private String prezime;
    private short jmbg;
    private String adresaprebivalista;
    private short kontakttelefon;
    private java.util.Date datumzaposljavanja;
    private java.lang.Boolean status;
    private Set<KorisnickiNalogDto> korisnickiNalogCollection;
    private KorisnickiNalogDto korisnickinalog;
    private ZanimanjeDto zanimanje;
    private Set<VoznjaDto> voznjaCollection;
    private Set<DnevnaSmenaDto> dnevnaSmenaCollection;
    private Set<VoziloDto> voziloCollection;

    public ZaposlenDto() {
    }

    public ZaposlenDto(short zaposlenId, String ime, String prezime, short jmbg, String adresaprebivalista, short kontakttelefon, java.util.Date datumzaposljavanja, java.lang.Boolean status, Set<KorisnickiNalogDto> korisnickiNalogCollection, KorisnickiNalogDto korisnickinalogId, ZanimanjeDto zanimanjeId, Set<VoznjaDto> voznjaCollection, Set<DnevnaSmenaDto> dnevnaSmenaCollection, Set<VoziloDto> voziloCollection) {
        this.zaposlenId = zaposlenId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresaprebivalista = adresaprebivalista;
        this.kontakttelefon = kontakttelefon;
        this.datumzaposljavanja = datumzaposljavanja;
        this.status = status;
        this.korisnickiNalogCollection = korisnickiNalogCollection;
        this.korisnickinalog = korisnickinalogId;
        this.zanimanje = zanimanjeId;
        this.voznjaCollection = voznjaCollection;
        this.dnevnaSmenaCollection = dnevnaSmenaCollection;
        this.voziloCollection = voziloCollection;

    }

    public short getZaposlenId() {
        return zaposlenId;
    }

    public void setZaposlenId(short zaposlenId) {
        this.zaposlenId = zaposlenId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public short getJmbg() {
        return jmbg;
    }

    public void setJmbg(short jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresaprebivalista() {
        return adresaprebivalista;
    }

    public void setAdresaprebivalista(String adresaprebivalista) {
        this.adresaprebivalista = adresaprebivalista;
    }

    public short getKontakttelefon() {
        return kontakttelefon;
    }

    public void setKontakttelefon(short kontakttelefon) {
        this.kontakttelefon = kontakttelefon;
    }

    public java.util.Date getDatumzaposljavanja() {
        return datumzaposljavanja;
    }

    public void setDatumzaposljavanja(java.util.Date datumzaposljavanja) {
        this.datumzaposljavanja = datumzaposljavanja;
    }

    public java.lang.Boolean getStatus() {
        return status;
    }

    public void setStatus(java.lang.Boolean status) {
        this.status = status;
    }

    public Set<KorisnickiNalogDto> getKorisnickiNalogCollection() {
        return korisnickiNalogCollection;
    }

    public void setKorisnickiNalogCollection(Set<KorisnickiNalogDto> korisnickiNalogCollection) {
        this.korisnickiNalogCollection = korisnickiNalogCollection;
    }

    public KorisnickiNalogDto getKorisnickinalog() {
        return korisnickinalog;
    }

    public void setKorisnickinalog(KorisnickiNalogDto korisnickinalog) {
        this.korisnickinalog = korisnickinalog;
    }

    public ZanimanjeDto getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(ZanimanjeDto zanimanje) {
        this.zanimanje = zanimanje;
    }

    public Set<VoznjaDto> getVoznjaCollection() {
        return voznjaCollection;
    }

    public void setVoznjaCollection(Set<VoznjaDto> voznjaCollection) {
        this.voznjaCollection = voznjaCollection;
    }

    public Set<DnevnaSmenaDto> getDnevnaSmenaCollection() {
        return dnevnaSmenaCollection;
    }

    public void setDnevnaSmenaCollection(Set<DnevnaSmenaDto> dnevnaSmenaCollection) {
        this.dnevnaSmenaCollection = dnevnaSmenaCollection;
    }

    public Set<VoziloDto> getVoziloCollection() {
        return voziloCollection;
    }

    public void setVoziloCollection(Set<VoziloDto> voziloCollection) {
        this.voziloCollection = voziloCollection;
    }
}
