package com.sukasa.infraestructure.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "th_formato")
public class ThFormato {
     private List<String> beneficios;

    @XmlElementWrapper(name = "beneficios")
    @XmlElement(name = "beneficio")
    public List<String> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<String> beneficios) {
        this.beneficios = beneficios;
    }
}
