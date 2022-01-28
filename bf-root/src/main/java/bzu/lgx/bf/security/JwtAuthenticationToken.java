package bzu.lgx.bf.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 19:13
 * @Description: 自定义令牌对象
 */
@Getter
@Setter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = -5869271489433218723L;

    private String token;

    public JwtAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtAuthenticationToken(Object principal, Object credentials, String token) {
        super(principal, credentials);
        this.token = token;
    }

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }
}
