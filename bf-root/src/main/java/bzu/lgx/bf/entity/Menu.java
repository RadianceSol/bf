package bzu.lgx.bf.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 16:48
 * @Description:
 */
@Setter
@Getter
@Entity
@Table(name = "bf_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -1518559694387633437L;

    @Id
    private String id;

    private String menuName;

    private String icon;

    private String url;

    private String parentId;

}
