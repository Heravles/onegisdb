package cn.ict.onedbcore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="dataobject")
public class Dobject {
	@Id
	private Long id;
	@NotNull
	private String name;
	@JsonProperty(value = "dataSource")
	private Long datasource;
	private String data;
	@JsonProperty(value = "dType")
	private Long dtype;

}
