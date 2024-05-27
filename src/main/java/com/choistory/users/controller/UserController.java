package com.choistory.users.controller;

import com.choistory.users.dto.HttpJoinRequestDto;
import com.choistory.users.dto.HttpUserProfileRequestDto;
import com.choistory.users.dto.HttpUserProfileResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("v1/users")
public class UserController {
  @Operation(summary="회원가입", description = "새로운 회원을 생성한다.")
  @Parameters({
          @Parameter(name="body", description = "회원가입에 필요한 정보 객체")
  })
  @PostMapping
  public ResponseEntity<Void> createUser(@RequestBody HttpJoinRequestDto body){
    return ResponseEntity.status(200).build();
  }

  @Operation(summary = "회원프로필 조회", description = "회원의 프로필정보를 조회한다.")
  @Parameters({
          @Parameter(name="userId", description = "회원 아이디")
  })
  @GetMapping("/{userId}")
  public ResponseEntity<HttpUserProfileResponseDto> getUser(@PathVariable String userId){
    return ResponseEntity.status(200).body(null);
  }

  @Operation(summary = "회원정보(프로필)업데이트", description = "회원정보를 업데이트 한다. 유저네임, 바이오를 수정할 수 있다.")
  @Parameters({
          @Parameter(name="userId", description = "회원 아이디"),
          @Parameter(name="body", description = "수정하려는 회원정보")
  })
  @PostMapping("/{userId}")
  public ResponseEntity<Void> updateProfile(@PathVariable String userId, @RequestPart HttpUserProfileRequestDto body){
    return ResponseEntity.status(200).build();
  }
  
  @Operation(summary = "이미지 업데이트", description = "프로필 이미지나 헤더이미지를 변경한다.")
  @Parameters({
          @Parameter(name="userId", description = "회원 아이디"),
          @Parameter(name="type", description = "프로필 이미인지 또는 헤더이미지인지 타입정보. P: 프로필, H: 헤더"),
          @Parameter(name="imageFile", description = "변경하려는 이미지 파일")
  })
  @PostMapping("/{userId}/image/{type}")
  public ResponseEntity<Void> updateProfileImage(@PathVariable String userId, @PathVariable String type, MultipartFile imageFile){
    return ResponseEntity.status(200).build();
  }
  
  @Operation(summary = "회원탈퇴", description = "회원을 탈퇴 상태로 만든다.")
  @Parameters({
          @Parameter(name="userId", description = "탈퇴하려는 회원 아이디")
  })
  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId){
    return ResponseEntity.status(200).build();
  }
}
