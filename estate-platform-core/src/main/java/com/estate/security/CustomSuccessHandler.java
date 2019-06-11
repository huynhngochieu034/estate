package com.estate.security;

import com.estate.constant.SystemConstant;
import com.estate.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        //sau khi authentication thành công, chạy vào hàm handle trong customsuccesshandler
        //String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request, response, SystemConstant.ADMIN_HOME);
    }

    //xác định URL cần truy cập theo từng vài trò
    //admin: truy cập ngay vào trang /admin/home
    public String determineTargetUrl(Authentication authentication) {
        String url = "";
        List<String> roles = SecurityUtils.getAuthorities();
        if (isUser(roles)) {
            url = SystemConstant.ADMIN_HOME;
        } else if (isAdmin(roles)) {
            url = SystemConstant.ADMIN_HOME;
        }
        return url;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public boolean isAdmin(List<String> roles) {
        if (roles.contains(SystemConstant.ADMIN_ROLE)) {
            return true;
        }
        return false;
    }

    public boolean isUser(List<String> roles) {
        if (roles.contains(SystemConstant.USER_ROLE)) {
            return true;
        }
        return false;
    }
}
