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
 * @Data: 2022-01-20 14:45
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "bf_para")
@ApiModel(value = "参数实体类", description = "")
public class Para implements Serializable {

    private static final long serialVersionUID = -3338281333073559631L;

    @Id
    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes ="参数ID" )
    private String id;

    @ApiModelProperty(example = "C", notes = "参数名称")
    private String name;

    @ApiModelProperty(example = "C", notes = "参数选项")
    private String options;

    @ApiModelProperty(example = "C", notes = "参数排序")
    private int sort;

    @ApiModelProperty(example = "1111111111111111111",value = "Default String", notes = "模板ID")
    private String templateId;
}
