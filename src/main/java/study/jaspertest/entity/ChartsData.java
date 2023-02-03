package study.jaspertest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "charts_data")
@NoArgsConstructor
public class ChartsData {
  @Id
  @GeneratedValue
  private Long id;
  private Integer sq;
  private String name;
  private Integer val;

  public ChartsData(Integer sq, String name, Integer val) {
    this.sq = sq;
    this.name = name;
    this.val = val;
  }
}
