package bzu.lgx.bf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 11:00
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "bf_admin")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) // FIXME: JSON Has NULL, Need Config It.
public class Admin implements Serializable {

    private static final long serialVersionUID = 1488770918845763999L;

    @Id
    private String id;

    private String username;

    private String password;

    private String status;
}
