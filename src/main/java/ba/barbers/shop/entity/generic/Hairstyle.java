package ba.barbers.shop.entity.generic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Hairstyle")
@Table(name = "hairstyle")
public class Hairstyle extends BaseEntity{
  /*
  @Id
  @SequenceGenerator(
      name = "hairstyle_sequence",
      sequenceName = "hairstyle_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "hairstyle_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;

   */
  
  @Column(name = "name")
  private String name;
  
  @OneToMany(mappedBy = "hairstyle")
  private List<User> users = new ArrayList<User>();
  
  @OneToMany(mappedBy = "hairstyle")
  private List<CompanyHairstyle> companyHairstyles = new ArrayList<CompanyHairstyle>();
  
  
  
}
