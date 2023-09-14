package com.sukasa.infraestructure.Utiles;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sukasa.infraestructure.dtos.ThFormato;
import com.sukasa.infraestructure.dtos.sk_formatoModel;
import com.sukasa.infraestructure.enums.GrupoEnum;
import com.sukasa.infraestructure.models.BeneficioModel;

public class Util {
    
     public List<BeneficioModel> leerArchivoXML() throws JAXBException, IOException {
         	ClassPathResource resource = new ClassPathResource("th_formato.xml");
			InputStream inputStream = resource.getInputStream();

			JAXBContext context = JAXBContext.newInstance(ThFormato.class);
        	Unmarshaller unmarshaller = context.createUnmarshaller();

			ThFormato thFormato = (ThFormato) unmarshaller.unmarshal(inputStream);
            ArrayList<BeneficioModel> list= new ArrayList<>();
            BeneficioModel model;
            for (var item : thFormato.getBeneficios()) {
                model= new BeneficioModel();
                model.setNombre(item);
                model.setEstado(true);
                model.setTipo(GrupoEnum.TH.getTipo());
                list.add( model);
            }
            
			inputStream.close();
            return list;
              
    }


     private ObjectMapper objectMapper = new ObjectMapper();

	 public List<BeneficioModel> leerArchivoJSON() {
        
              ArrayList<BeneficioModel> list= new ArrayList<>();
		try {
            Resource resource = new ClassPathResource("sk_formato.json");
            sk_formatoModel object = objectMapper.readValue(resource.getInputStream(), sk_formatoModel.class);
		
            BeneficioModel model;

            for (var item : object.getSk_formato()) {
                model= new BeneficioModel();
                model.setNombre(item.getBeneficio());
                model.setEstado(true);
                model.setTipo(GrupoEnum.SK.getTipo());
                list.add( model);
            }
            return list;
        } catch (Exception e) {
            return list;
        }}

}
