package com.page.server.entity;

import com.page.server.constant.AccessRight;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "_PERMISSION")
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long permissionNo;

    public Long userNo;

    public Long groupNo;

    @NotNull
    public AccessRight accessRight;

    @Builder
    public Permission(Long permissionNo, Long userNo, Long groupNo, AccessRight accessRight) {
        this.permissionNo = permissionNo;
        this.userNo = userNo;
        this.groupNo = groupNo;
        this.accessRight = accessRight;
    }

    public Boolean hasUserNo(Long userNo){
        return this.userNo != null && this.userNo.equals(userNo);
    }

    public Boolean hasGroupNo(Long groupNo){
        return this.groupNo != null && this.groupNo.equals(groupNo);
    }
}
