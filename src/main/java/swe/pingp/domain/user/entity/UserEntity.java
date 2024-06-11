//package swe.pingp.domain.user.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import java.time.LocalDateTime;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name = "User")
//@Getter
//@Setter
//public class UserEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String name;
//
//    @Column
//    private String email;
//
//    @Column(name = "image_url")
//    private String imageUrl;
//
//    @Column
//    private String role;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//}
