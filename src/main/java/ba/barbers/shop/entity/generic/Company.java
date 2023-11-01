package ba.barbers.shop.entity.generic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Company")
@Table(name = "company")
public class Company extends BaseEntity{
  /*
  @Id
  @SequenceGenerator(
      name = "company_sequence",
      sequenceName = "company_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "company_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;

   */
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "worksFrom")
  private LocalTime worksFrom;
  
  @Column(name = "worksTo")
  private LocalTime worksTo;
  
  @Column(name = "city")
  private String city;
  
  @Column(name = "address")
  private String address;
  
  @OneToMany(mappedBy = "company")
  private List<Post> posts = new ArrayList<Post>();
  
  @ManyToMany(mappedBy = "companyList")
  private List<User> users;
  
  @OneToMany(mappedBy = "company")
  private List<CompanyHairstyle> companyHairstyles = new ArrayList<CompanyHairstyle>();
  
}
