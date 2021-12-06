package sgi.ecom.rating.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import sgi.ecom.rating.demo.model.Dealer;

@Repository
public interface DealerRepository extends MongoRepository<Dealer,String> {
    Dealer findByDealerCode(String dealerCode);

}
