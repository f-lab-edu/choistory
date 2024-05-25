package com.choistory.email.controller;

import com.choistory.email.dto.HttpEmailCertificationRequestDto;
import com.choistory.email.dto.HttpEmailRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
public class EmailController {

  @Operation(summary="이메일 중복 확인", description="회원가입시 이미 사용중인 이메일이 있는지 확인한다.")
  @Parameters({
          @Parameter(name="email", description = "중복 확인하려는 이메일", required = true)
  })
  @GetMapping
  public ResponseEntity<Boolean> isDuplicatedEmail(@RequestParam String email){
    boolean result = false;
    return ResponseEntity.status(200).body(result);
  }

  @Operation(summary = "인증용 이메일 전송")
  @Parameters({
          @Parameter(name="body", description = "이메일을 전송하려는 대상 주소", required = true)
  })
  @PostMapping
  public ResponseEntity<Void> sendEmail(@RequestBody HttpEmailRequestDto body){
    return ResponseEntity.status(200).build();
  }

  /**
   * 이메일 인증확인
   * @param body
   */
  @Operation(summary = "이메일 인증 확인", description = "이 엔드포인트로 적절한 키와 함께 진입하면 그 키와 이메일을 확인한 후 해당 이메일이 인증되었음 상태로 변경한다.")
  @Parameters({
          @Parameter(name="body", description = "이메일 인증에 필요한 요소를 담은 객체", required = true)
  })
  @PatchMapping
  public ResponseEntity<Void> confirmEmailAddress(@RequestBody HttpEmailCertificationRequestDto body){
    return ResponseEntity.status(200).build();
  }

}
