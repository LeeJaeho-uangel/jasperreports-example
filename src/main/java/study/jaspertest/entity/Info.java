package study.jaspertest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Info {
  @Id
  @GeneratedValue
  private Long id;
  private String shipNumber;
  private String shipName;
  private String desc;

  public Info(String shipNumber, String shipName, String desc) {
    this.shipName = shipName;
    this.shipNumber = shipNumber;
    this.desc = desc;
  }
}
