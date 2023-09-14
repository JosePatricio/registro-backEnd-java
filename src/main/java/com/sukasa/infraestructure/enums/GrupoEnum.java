package com.sukasa.infraestructure.enums;
public enum  GrupoEnum {
    SK("SK"),
    TH("TH")
    ;

    public final String type;

    GrupoEnum(String type) {
        this.type = type;
    }

    public String getTipo() {
       return type;
    } 
}
