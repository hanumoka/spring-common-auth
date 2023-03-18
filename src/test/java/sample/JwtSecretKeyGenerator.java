package sample;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretKeyGenerator {

    public static String generateSecretKey() {
        // 256비트의 길이를 가지는 안전한 난수 생성기를 생성합니다.
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[32]; // 32바이트 = 256비트
        secureRandom.nextBytes(randomBytes);

        // Base64 인코딩을 사용하여 바이트 배열을 문자열로 변환합니다.
        String secretKey = Base64.getEncoder().encodeToString(randomBytes);

        return secretKey;
    }

    public static void main(String[] args) {
        String secretKey = generateSecretKey();
        System.out.println("Generated secret key: " + secretKey);
    }
}