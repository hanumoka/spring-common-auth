package sample;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtSecretKeyGenerator {

    public static String generateSecretKey() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        return Encoders.BASE64.encode(key.getEncoded());
    }

    public static void main(String[] args) {
        String secretKey = generateSecretKey();
        System.out.println("Generated secret key: " + secretKey);
    }
}