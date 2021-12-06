package sgi.ecom.rating.demo.model;
import lombok.Data;
import java.util.List;

@Data
public class Response {
    public String status;
    public String responseCode;
    public String responseDescription;
    public List data;


}
