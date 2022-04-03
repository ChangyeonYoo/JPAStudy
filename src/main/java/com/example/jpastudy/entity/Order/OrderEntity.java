package com.example.jpastudy.entity.Order;

import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.entity.user.UserEntity;
import com.example.jpastudy.enums.OrderState;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="order")
@SQLDelete(sql = "UPDATE order SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderEntity extends BaseEntity {

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    OrderState orderState;
}
