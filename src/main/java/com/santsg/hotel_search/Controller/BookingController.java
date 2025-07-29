package com.santsg.hotel_search.Controller;


import com.santsg.hotel_search.DTO.RemoveServicesRequest;
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
import com.santsg.hotel_search.Services.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private static final Logger log = LoggerFactory.getLogger(BookingController.class);

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/begin-transaction")
    public ResponseEntity<BeginTransactionResponse> beginTransaction(@RequestBody BeginTransactionRequest request) {
        if (request.getOfferIds() == null || request.getOfferIds().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Rezervasyon işlemi başlatılıyor. Offer ID: {}", request.getOfferIds().get(0));
        BeginTransactionResponse response = bookingService.beginTransaction(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-services")
    public ResponseEntity<BeginTransactionResponse> addServices(@RequestBody AddServicesRequest request) {
        if (request.getTransactionId() == null || request.getOffers() == null || request.getOffers().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Mevcut işleme yeni hizmet ekleniyor. Transaction ID: {}", request.getTransactionId());
        BeginTransactionResponse response = bookingService.addServices(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/remove-services")
    public ResponseEntity<BeginTransactionResponse> removeServices(@RequestBody RemoveServicesRequest request) {
        if (request.getTransactionId() == null || request.getServices() == null || request.getServices().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Mevcut işlemden hizmet kaldırılıyor. Transaction ID: {}", request.getTransactionId());
        BeginTransactionResponse response = bookingService.removeServices(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/set-info")
    public ResponseEntity<BeginTransactionResponse> setReservationInfo(@RequestBody SetReservationInfoRequest request) {
        if (request.getTransactionId() == null || request.getTravellers() == null || request.getTravellers().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Rezervasyon bilgileri kaydediliyor. Transaction ID: {}", request.getTransactionId());
        BeginTransactionResponse response = bookingService.setReservationInfo(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/commit-transaction")
    public ResponseEntity<CommitTransactionResponse> commitTransaction(@RequestBody CommitTransactionRequest request) {
        if (request.getTransactionId() == null || request.getTransactionId().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Rezervasyon tamamlanıyor. Transaction ID: {}", request.getTransactionId());
        CommitTransactionResponse response = bookingService.commitTransaction(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/get-detail")
    public ResponseEntity<GetReservationDetailResponse> getReservationDetail(@RequestBody GetReservationDetailRequest request) {
        if (request.getReservationNumber() == null || request.getReservationNumber().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Rezervasyon detayı isteniyor. Rezervasyon No: {}", request.getReservationNumber());
        GetReservationDetailResponse response = bookingService.getReservationDetail(request);
        return ResponseEntity.ok(response);
    }
     @PostMapping("/get-list")
    public ResponseEntity<GetReservationListResponse> getReservationList(@RequestBody GetReservationListRequest request) {
        log.info("Rezervasyon listesi isteniyor. Kriterler: {}", request);
        GetReservationListResponse response = bookingService.getReservationList(request);
        return ResponseEntity.ok(response);
    }
}
