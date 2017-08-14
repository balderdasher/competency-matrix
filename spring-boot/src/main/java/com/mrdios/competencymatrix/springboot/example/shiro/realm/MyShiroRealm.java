package com.mrdios.competencymatrix.springboot.example.shiro.realm;

import com.mrdios.competencymatrix.springboot.example.shiro.UserInfoService;
import com.mrdios.competencymatrix.springboot.example.shiro.dao.UserInfoDao;
import com.mrdios.competencymatrix.springboot.example.shiro.entity.SysPermission;
import com.mrdios.competencymatrix.springboot.example.shiro.entity.SysRole;
import com.mrdios.competencymatrix.springboot.example.shiro.entity.UserInfo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通过Realm来获取应用程序中的用户、角色及权限信息的,相当于安全框架中的Dao
 *
 * @author MrDios
 * @date 2017-08-09
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 获取权限信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置--->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 获取身份信息
     * <p>
     * 该方法主要进行以下操作：
     * 1、检查提交的进行认证的令牌信息
     * 2、根据令牌信息从数据源(通常为数据库)中获取用户信息
     * 3、对用户信息进行匹配验证。
     * 4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
     * 5、验证失败则抛出AuthenticationException异常信息。
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户输入
        String username = (String) token.getPrincipal();    // username
        System.out.println(token.getCredentials());         // password
        // 通过用户输入查询用户信息，此处可做缓存，若无缓存shiro也有自己的时间限制：2分钟内不会重复执行方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("----------->>userInfo=" + userInfo);
        if (userInfo == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,                                               // 用户名
                userInfo.getPassword(),                                 // 密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),   // salt=username+salt
                getName());                                             // realm name
        return authenticationInfo;
    }
}
