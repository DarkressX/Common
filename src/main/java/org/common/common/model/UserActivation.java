package org.common.common.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "act_user")
public class UserActivation {

    @Id
    @Column(name = "activation_id")
    private UUID uuid;

    @NotNull
    @DateTimeFormat(pattern="dd.MM.yyyy")
    @Column(name = "date")
    private Date expirationDate;

    @NotNull
    @Column(name = "userid")
    private Long userId;

    @SuppressWarnings("unused")
    public UserActivation(){
    }
    public UserActivation(UUID uuid, Date date, Long userid){
        this.uuid = uuid;
        this.expirationDate = date;
        this.userId = userid;
    }

    public Long getUserId(){
        return this.userId;
    }

    public boolean checkIfExpired(Date date){
        if(this.expirationDate.before(date)){
            return true;
        }
        return false;
    }

}
