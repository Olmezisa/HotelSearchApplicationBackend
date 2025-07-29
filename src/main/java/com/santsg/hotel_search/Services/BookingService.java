package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.RemoveServicesRequest; // Yeni DTO'yu import et
import com.santsg.hotel_search.DTO.AddServices.AddServicesRequest;
import com.santsg.hotel_search.DTO.CommitTransaction.CommitTransactionRequest;
import com.santsg.hotel_search.DTO.CommitTransaction.CommitTransactionResponse;
import com.santsg.hotel_search.DTO.HotelProduct.BeginTransactionRequest;
import com.santsg.hotel_search.DTO.Reservation.GetReservationDetailRequest;
import com.santsg.hotel_search.DTO.Reservation.GetReservationDetailResponse;
import com.santsg.hotel_search.DTO.Reservation.GetReservationListRequest;
import com.santsg.hotel_search.DTO.Reservation.GetReservationListResponse;
import com.santsg.hotel_search.DTO.SetReservationInfo.SetReservationInfoRequest;
import com.santsg.hotel_search.DTO.Transaction.BeginTransactionResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BookingService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public BookingService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    public BeginTransactionResponse beginTransaction(BeginTransactionRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BeginTransactionRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/begintransaction";

        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, BeginTransactionResponse.class).getBody();
    }

    public BeginTransactionResponse addServices(AddServicesRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AddServicesRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/addservices";

        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, BeginTransactionResponse.class).getBody();
    }
    
    
    public BeginTransactionResponse removeServices(RemoveServicesRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RemoveServicesRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/removeservices";

       
        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, BeginTransactionResponse.class).getBody();
    }
    public BeginTransactionResponse setReservationInfo(SetReservationInfoRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SetReservationInfoRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/setreservationinfo";
        
        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, BeginTransactionResponse.class).getBody();
    }
    public CommitTransactionResponse commitTransaction(CommitTransactionRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CommitTransactionRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/committransaction";

        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, CommitTransactionResponse.class).getBody();
    }
    public GetReservationDetailResponse getReservationDetail(GetReservationDetailRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GetReservationDetailRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/getreservationdetail";

        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, GetReservationDetailResponse.class).getBody();
    }
    public GetReservationListResponse getReservationList(GetReservationListRequest apiRequest) {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GetReservationListRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/bookingservice/getreservationlist";

        return restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, GetReservationListResponse.class).getBody();
    }
}