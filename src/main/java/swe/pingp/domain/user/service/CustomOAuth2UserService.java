//package swe.pingp.domain.user.service;
//
//import java.time.LocalDateTime;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//import swe.pingp.domain.user.dto.CustomOAuth2User;
//import swe.pingp.domain.user.dto.GoogleResponse;
//import swe.pingp.domain.user.dto.OAuth2Response;
//import swe.pingp.domain.user.entity.UserEntity;
//import swe.pingp.domain.user.repository.UserRepository;
//
//@Slf4j
//@Service
//public class CustomOAuth2UserService extends DefaultOAuth2UserService {
//
//    private final UserRepository userRepository;
//
//    public CustomOAuth2UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//        log.info("oAuth2User = {}", oAuth2User);
//
//        String registrationId = userRequest.getClientRegistration().getRegistrationId();
//        OAuth2Response oAuth2Response = null;
//
//        if (registrationId.equals("google")) {
//            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
//        } else {
//            return null;
//        }
//
////        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
//        String username = (String) oAuth2User.getAttributes().get("name");
//        String imageUrl = (String) oAuth2User.getAttributes().get("picture");
//        UserEntity existData = userRepository.findByName(username);
//
//        String role = "ROLE_USER";
//        if (existData == null) {
//            UserEntity userEntity = new UserEntity();
//            userEntity.setName(username);
//            userEntity.setEmail(oAuth2Response.getEmail());
//            userEntity.setImageUrl(imageUrl);
//            userEntity.setRole(role);
//            userEntity.setCreatedAt(LocalDateTime.now());
//
//            userRepository.save(userEntity);
//
//        } else {
//            existData.setEmail(oAuth2Response.getEmail());
//            role = existData.getRole();
//
//            userRepository.save(existData);
//        }
//
//        return new CustomOAuth2User(oAuth2Response, role);
//    }
//}
