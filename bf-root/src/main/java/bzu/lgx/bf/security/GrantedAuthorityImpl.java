package bzu.lgx.bf.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 19:22
 * @Description: 权限封禁
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = -2846339284831194592L;

    private String authority;

    public GrantedAuthorityImpl(String authority){
        this.authority = authority;
    }

    public void setAuthority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
