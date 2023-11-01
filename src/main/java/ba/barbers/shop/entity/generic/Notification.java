package ba.barbers.shop.entity.generic;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Entity(name = "Notification")
@Table(name = "notification")
public class Notification extends BaseEntity{
  /*
  @Id
  @SequenceGenerator(
      name = "notification_sequence",
      sequenceName = "notification_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "notification_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;

   */
  
  @Column(name = "message")
  private String message;

  @Column(name = "read")
  private boolean read;
  
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  
  
}
