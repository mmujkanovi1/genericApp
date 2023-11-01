package ba.barbers.shop.entity.generic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Appointment")
@Table(name = "appointment")
public class Appointment extends BaseEntity {

  /*
  @Id
  @SequenceGenerator(
      name = "appointment_sequence",
      sequenceName = "appointment_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "appointment_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;


   */
  @Column(name = "durationMinutes")
  private Integer durationMinutes;
  
  @Column(name = "startTime")
  private LocalTime startTime;
  
  @Column(name = "endTime")
  private LocalTime endTime;
  /*
  @ManyToOne(fetch = FetchType.LAZY)
  private User usersAppointments;


   */
  @OneToOne(mappedBy = "appointmentReserved")
  private User userBookAppointment;
  

}
