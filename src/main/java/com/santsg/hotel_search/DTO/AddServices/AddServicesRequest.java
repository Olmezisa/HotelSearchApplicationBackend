package com.santsg.hotel_search.DTO.AddServices;



import lombok.Data;
import java.util.List;

@Data
public class AddServicesRequest {
    private String transactionId;
    private List<OfferToAdd> offers;
    private String currency;
    private String culture;

    
    @Data
    public static class OfferToAdd {
        private String offerId;
        private List<String> travellers; 
    }
}
