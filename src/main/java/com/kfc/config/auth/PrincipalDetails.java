package com.kfc.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kfc.dto.User;

import lombok.Data;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

//시큐리티가 login 주소 요청이 오면 낚아채서 로그인을 진행시킨다
//로그인을 진행이 완료가 되면 시큐리티 session을 만들어 준다(Security ContextHolder 라는 키에 세션정보 저장)
//세션에 들어갈 수 있는 object는 정해져 있음 => Authentication 타입 객체
//Authentication 안에 User정보가 있어야 함.
//User 오브젝트 타입 => UserDetails 타입 객체 여야 함 정해져 있음
//시큐리티 세션 영역에 저장 될 수 있는 객체는 Authentication 여야 하고 여기 저장될 수 있는 객체 타입은UserDetails 여야함
//PrincipalDetails가 UserDetails를 가져오기 떄문에 PrincipalDetails가 UserDetails 타입이 됨

// Authentication 객체에 저장할 수 있는 유일한 타입
@Data
public class PrincipalDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public PrincipalDetails(User user) {
		this.user = user;
	}
	public User getUser() {
        return user;
    }
	@Override
	public String getPassword() {
		return user.getUser_password();
	}

	@Override
	public String getUsername() {
		return user.getUser_id(); //
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	//권한을 리턴 하는 곳! 타입이 정해져 있다
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
		//collet.add(()->{ return user.getRole();});
		return collet;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrincipalDetails other = (PrincipalDetails) obj;
        // 여기에서 사용자를 식별하는 필드를 비교하여 동일한지 확인합니다.
        return Objects.equals(user.getUser_id(), other.user.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getUser_id());
    }
	
}