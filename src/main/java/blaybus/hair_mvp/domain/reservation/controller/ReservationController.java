package blaybus.hair_mvp.domain.reservation.controller;

import blaybus.hair_mvp.auth.SecurityContextHelper;
import blaybus.hair_mvp.domain.reservation.dto.ReservationRequest;
import blaybus.hair_mvp.domain.reservation.service.ReservationService;
import blaybus.hair_mvp.domain.user.service.UserService;
import blaybus.hair_mvp.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final SecurityContextHelper securityContextHelper;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> reserve(@RequestBody final ReservationRequest request) throws IOException {
        reservationService.save(request, securityContextHelper.getEmailInToken());
        SuccessResponse response = new SuccessResponse(true, "예약 성공", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
