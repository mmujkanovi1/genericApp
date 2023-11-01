package ba.barbers.shop.entity.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Users")
@Table(name = "users")
public class User extends BaseEntity{
  /*
  @Id
  @SequenceGenerator(
      name = "user_sequence",
      sequenceName = "user_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "user_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;

   */
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "Surname")
  private String surname;
  
  @Column(name = "phoneNumber")
  private String phoneNumber;
  
  @Column(name = "email", unique = true)
  private String email;
  
  @Column(name = "username", unique = true)
  private String username;
  
  @Column(name = "password")
  private String password;
  
  @Column(name = "accepted")
  private boolean accepted;
  
  @Column(name = "subscribed")
  private boolean subscribed;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id")
  @JsonIgnore
  private Role role;
  
  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Post> posts = new ArrayList<Post>();
  /*
  @OneToMany(mappedBy = "usersAppointments")
  @JsonIgnore
  private List<Appointment> appointments = new ArrayList<Appointment>();


   */
  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Notification> notifications = new ArrayList<Notification>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "appointmentId", referencedColumnName = "id", nullable = true)
  @JsonIgnore
  private Appointment appointmentReserved;



  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hairstyle_id")
  @JsonIgnore
  private Hairstyle hairstyle;


  
  @ManyToMany
  @JoinTable(
      name = "users_company",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "company_id"))
  @JsonIgnore
  private List<Company> companyList;



  

}
