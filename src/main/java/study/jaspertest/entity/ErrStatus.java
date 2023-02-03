package study.jaspertest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrStatus {
  @Id
  @GeneratedValue
  private Long sensorNumber;
  private String sensorName;
  private String errDate;
  private Integer alarmCount;
}
