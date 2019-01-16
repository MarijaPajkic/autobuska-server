/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.dto;

import java.util.Objects;

/**
 *
 * @author marij
 */
public class AuthResponseDto {

    private String korisnickinalog;
    private String zanimanje;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String korisnickinalog, String zanimanje) {
        this.korisnickinalog = korisnickinalog;
        this.zanimanje = zanimanje;
    }

    public String getKorisnickinalog() {
        return korisnickinalog;
    }

    public void setKorisnickinalog(String korisnickinalog) {
        this.korisnickinalog = korisnickinalog;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.korisnickinalog);
        hash = 83 * hash + Objects.hashCode(this.zanimanje);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthResponseDto other = (AuthResponseDto) obj;
        if (!Objects.equals(this.korisnickinalog, other.korisnickinalog)) {
            return false;
        }
        if (!Objects.equals(this.zanimanje, other.zanimanje)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthResponseDto{" + "korisnickinalog=" + korisnickinalog + ", zanimanje=" + zanimanje + '}';
    }
}
