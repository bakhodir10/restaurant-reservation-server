package reservation_server.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import reservation_server.domain.Role;
import reservation_server.domain.User;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private Key key;
    public final String NOT_GRANTED_MESSAGE = "YOU CANT ACCESS THIS SERVICE";

    public JwtUtil(){
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public Key getKey(){
        return key;
    }

    public boolean isGranted(String token, String role) {
        try {

            List<Object> list = Jwts.parser().setSigningKey(this.getKey())
                    .parseClaimsJws(token).getBody().entrySet().stream()
                    .filter( entry -> entry.getKey().equals("role"))
                    .map(value -> value.getValue()).collect(Collectors.toList());
             list.stream().forEach(System.out::println);

             boolean roleFound = role.toLowerCase().equals(list.get(0).toString().toLowerCase()) ;

            if(!roleFound){
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String generateToken(User user, String role,boolean exist){
        String uId="2";
        if(role.toLowerCase().equals("admin")){
            uId="1";
        }
        if(exist){
            return uId+Jwts.builder()
                    .setSubject(user.getUsername())
                    .claim("role",role)
                    .claim("id",user.getId())
                    .signWith(this.getKey())
                    .compact();
        }else{
            return "";
        }
    }


}
