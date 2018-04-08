package com.example.myoauth.common.entity;

import com.example.myoauth.dto.AccessTokenDTO;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class AccessTokenDO implements Cloneable {

    private String accessToken;
    private Integer refreshTokenId;
    private String clientKey;
    private Date createTime;
    private Integer expiresTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getRefreshTokenId() {
        return refreshTokenId;
    }

    public void setRefreshTokenId(Integer refreshTokenId) {
        this.refreshTokenId = refreshTokenId;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(Integer expiresTime) {
        this.expiresTime = expiresTime;
    }

    public AccessTokenDTO tranferToDTO() {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        BeanUtils.copyProperties(this, accessTokenDTO);
        return accessTokenDTO;


    }

    public AccessTokenDO tranferToDO(AccessTokenDTO accessTokenDTO) {
        BeanUtils.copyProperties(accessTokenDTO, this);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccessTokenDO{");
        sb.append(", accessToken='").append(accessToken).append('\'');
        sb.append(", refreshTokenId=").append(refreshTokenId);
        sb.append(", clientId=").append(clientKey);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
