package bzu.lgx.bf.filter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 19:40
 * @Description: 安全用户模型
 */
public class JwtUserDetails extends User {

    private static final long serialVersionUID = 2252223445685340926L;

    public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities){
        this(username, password, true, true, true, true, authorities);
    }

    public JwtUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
