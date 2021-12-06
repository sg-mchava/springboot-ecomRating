package sgi.ecom.rating.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import sgi.ecom.rating.demo.model.ProdRates;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface ProductRatesRepository extends MongoRepository<ProdRates,String> {

    @Query("{ 'productCode' : :#{#productCode}}")
    List<ProdRates> findProdRates(String productCode);

    @Query("{'$or': :#{#doc}}")
    List<ProdRates> findRates(List<LinkedHashMap> doc);


}
