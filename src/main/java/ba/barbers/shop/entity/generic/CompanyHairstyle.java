package ba.barbers.shop.entity.generic;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Company_hairstyle")
@Table(name = "company_hairstyle")
public class CompanyHairstyle extends BaseEntity {

  /*
  @Id
  @SequenceGenerator(
      name = "company_hairstyle_sequence",
      sequenceName = "company_hairstyle_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "company_hairstyle_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;

   */
  
  @ManyToOne
  @JoinColumn(name = "hairstyle_id")
  private Hairstyle hairstyle;
  
  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;
  
  @Column(name = "prize")
  private double prize;
  
  
}
