package bzu.lgx.bf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 11:21
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "bf_template")
@ApiModel(value = "模板实体类", description = "")
public class Template implements Serializable {

    private static final long serialVersionUID = -7407066998858848026L;

    @Id
    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes ="模板ID" )
    private String id;

    @ApiModelProperty(example = "华为手机", notes = "模板名称")
    private String name;

    @ApiModelProperty(example = "0", notes = "模板规格数量")
    private int specNum;

    @ApiModelProperty(example = "0", notes = "模板参数数量")
    private int paraNum;


}
