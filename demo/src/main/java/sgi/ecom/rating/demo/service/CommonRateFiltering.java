package sgi.ecom.rating.demo.service;

import org.springframework.stereotype.Service;
import sgi.ecom.rating.demo.model.ProdRates;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommonRateFiltering {


    public List<ProdRates> commonRateReqFilter(List<ProdRates> data, LinkedHashMap jsonPayload) {

        Integer odometer = jsonPayload.containsKey("odometer")?Integer.valueOf(jsonPayload.get("odometer").toString()): null;
        Integer financeAmount = jsonPayload.containsKey("financeAmount")?Integer.valueOf(jsonPayload.get("financeAmount").toString()): null;
        String vehicleCondition = jsonPayload.containsKey("vehicleCondition")?jsonPayload.get("vehicleCondition").toString() : null;
        Integer term =  jsonPayload.containsKey("term")?Integer.valueOf(jsonPayload.get("term").toString()): null;
        Integer termMileage = jsonPayload.containsKey("termMileage")?Integer.valueOf(jsonPayload.get("termMileage").toString()) :null;
        Integer deductible = jsonPayload.containsKey("deductible")?Integer.valueOf(jsonPayload.get("deductible").toString()): null;
        System.out.println("odometer "+ odometer + "deductible " + deductible);

        List<ProdRates> finalfiltereddata = data.stream().filter(!(odometer==null)? item->(odometer >= item.getOdometerMin() && odometer <= item.getOdometerMax()) : item->true)
                .filter(!(financeAmount==null) ? item->(financeAmount >= item.getVehicleCostMin() && financeAmount <= item.getVehicleCostMax()) : item->true)
                .filter(!(vehicleCondition==null)? item->item.getVehicleCondition() == vehicleCondition : item->true)
                .filter(!(term==null)? item->(term >= item.getTermMonthsMin()) && term <= item.getTermMonthsMax() : item->true)
                .filter(!(termMileage==null)? item-> termMileage == item.getTermMileage() : item->true)
                .filter(!(deductible==null)? item-> deductible == item.getDeductible() : item-> true)
                .collect(Collectors.toList());
        System.out.println("data in commonfiltering class" + data);

        return finalfiltereddata;
    }



}
