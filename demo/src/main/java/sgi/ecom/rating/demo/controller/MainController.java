package sgi.ecom.rating.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sgi.ecom.rating.demo.model.Dealer;
import sgi.ecom.rating.demo.model.ProdRates;
import sgi.ecom.rating.demo.model.Response;
import sgi.ecom.rating.demo.repository.DealerRepository;
import sgi.ecom.rating.demo.repository.ProductRatesRepository;
import sgi.ecom.rating.demo.service.CommonRateFiltering;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/get")
public class MainController{

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    ProductRatesRepository productRatesRepository;

    @Autowired
    CommonRateFiltering filtering;

    @GetMapping("/dealer/{dealerCode}")
    public Dealer getDealers(@PathVariable("dealerCode") String dealerCode)
    {
        System.out.println("DEALER CODE " + dealerCode);
        return dealerRepository.findByDealerCode(dealerCode);
    }

    @GetMapping("/rates")
    public List<ProdRates> getRates(@RequestBody ProdRates body)
    {
        System.out.println("PROD RATES REQ" + body);

        return productRatesRepository.findProdRates(body.getProductCode());

    }

    @GetMapping("/prodrates")
    public Response getProdRates(@RequestBody List<LinkedHashMap> body)
    {
        Response finalResponse = new Response();

        System.out.println("REQ BODY " + body);
        LinkedHashMap map = new LinkedHashMap();
        map.put("odometer",10);

        List<ProdRates> rates = productRatesRepository.findRates(body);
        List<ProdRates> filtered= filtering.commonRateReqFilter(rates,map);
        finalResponse.setStatus("SUCCESS");
        finalResponse.setResponseCode("200");
        finalResponse.setResponseDescription("productRate method executed successfully");
        finalResponse.setData(filtered);
        return finalResponse;
    }



}
