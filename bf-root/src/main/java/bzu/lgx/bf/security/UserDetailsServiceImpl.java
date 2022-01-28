package bzu.lgx.bf.security;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Admin;
import bzu.lgx.bf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 19:44
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.findByUsername(username);
        if (admin == null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        Set<String> permissions = adminService.findPermissions(username);
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(username, admin.getPassword(), grantedAuthorities);
    }
}
