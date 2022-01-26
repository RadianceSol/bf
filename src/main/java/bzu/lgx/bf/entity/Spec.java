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
 * @Data: 2022-01-20 11:54
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "bf_spec")
@ApiModel(value = "规格实体类", description = "")
public class Spec implements Serializable {

    private static final long serialVersionUID = 5556609742174333721L;

    @Id
    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes ="规格ID" )
    private String id;

    @ApiModelProperty(example = "G", notes = "规格名称")
    private String name;

    @ApiModelProperty(example = "G", notes = "规格选项")
    private String options;

    @ApiModelProperty(example = "G", notes = "规格排序")
    private int sort;

    @ApiModelProperty(example = "1111111111111111111",value = "Default String", notes = "模板ID")
    private String templateId;
}
