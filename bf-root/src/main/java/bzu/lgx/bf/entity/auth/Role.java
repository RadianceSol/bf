package bzu.lgx.bf.entity.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 15:37
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "bf_role")
public class Role implements Serializable {

    @Id
    private String id;

    private String roleName;

}
