package com.ardent.mailorderpharmacy.dto.drug;

import lombok.Data;

@Data
public class DrugResponseDTO {
    private Long drugId;
    private String drugName;
    private String manufacturer;
    private String dosageForm;
    private String strength;
    private double price;

    public DrugResponseDTO(Long drugId, String drugName, String manufacturer, String dosageForm, String strength, double price) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.manufacturer = manufacturer;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.price = price;
    }
}
