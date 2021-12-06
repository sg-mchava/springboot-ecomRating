package sgi.ecom.rating.demo.model;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "prodRates")
@Valid
public class ProdRates {

    @Id
    public ObjectId _id;
    public String productSku;
    public String carrierSku;
    @Field("class")
    public String classy;
    public Boolean commercial;
    public String coverageCode;
    public String coverageDescription;
    public String coverageDescriptionPortal;
    public ArrayList coverageOption;
    public String dealerTier;
    public String dealerTierProgramType;
    public Integer deductible;
    public Boolean disappearingDeductible;
    public ArrayList multiCoverage;
    public String multiCoverageCode;

    public Integer odometerMax= 1000000;
    public Integer odometerMin= 0;
    public String paymentType;
    public String planCode;
    public String planName;
    public String premiumCoverageCode;

    @NotNull
    @NotBlank
    public String productCode;

    public String productType;
    public String program;
    public String programAgentCode;
    public String programType;
    public List rates;
    public ArrayList regulatedRules;
    public String riskType;
    public String startingInterval;
    public String startingIntervalName;
    public String surcharges;
    public Integer termMileage =0 ;
    public Integer termMonthsMax = 300;
    public Integer termMonthsMin = 1;
    public String vehicleCondition = "N";
    public Integer vehicleCostMax = 1000000;
    public Integer vehicleCostMin = 0;

}
