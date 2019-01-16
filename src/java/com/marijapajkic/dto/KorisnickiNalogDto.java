package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class KorisnickiNalogDto implements Serializable {

    private short korisnickinalogId;
    private String korisnickoime;
    private String korisnickiemail;
    private String korisnickalozinka;
    private ZaposlenDto zaposlen;
    private Set<ZaposlenDto> zaposlenCollection;

    public KorisnickiNalogDto() {
    }

    public KorisnickiNalogDto(short korisnickinalogId, String korisnickoime, String korisnckiemail, String korisnickalozinka, ZaposlenDto zaposlenId, Set<ZaposlenDto> zaposlenCollection) {
        this.korisnickinalogId = korisnickinalogId;
        this.korisnickoime = korisnickoime;
        this.korisnickiemail = korisnckiemail;
        this.korisnickalozinka = korisnickalozinka;
        this.zaposlen = zaposlenId;
        this.zaposlenCollection = zaposlenCollection;

    }

    public short getKorisnickinalogId() {
        return korisnickinalogId;
    }

    public void setKorisnickinalogId(short korisnickinalogId) {
        this.korisnickinalogId = korisnickinalogId;
    }

    public String getKorisnickoime() {
        return korisnickoime;
    }

    public void setKorisnickoime(String korisnickoime) {
        this.korisnickoime = korisnickoime;
    }

    public String getKorisnickiemail() {
        return korisnickiemail;
    }

    public void setKorisnickiemail(String korisnickiemail) {
        this.korisnickiemail = korisnickiemail;
    }

    public String getKorisnickalozinka() {
        return korisnickalozinka;
    }

    public void setKorisnickalozinka(String korisnickalozinka) {
        this.korisnickalozinka = korisnickalozinka;
    }

    public ZaposlenDto getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(ZaposlenDto zaposlen) {
        this.zaposlen = zaposlen;
    }

    public Set<ZaposlenDto> getZaposlenCollection() {
        return zaposlenCollection;
    }

    public void setZaposlenCollection(Set<ZaposlenDto> zaposlenCollection) {
        this.zaposlenCollection = zaposlenCollection;
    }
}
