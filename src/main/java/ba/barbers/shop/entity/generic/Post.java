package ba.barbers.shop.entity.generic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Post")
@Table(name = "post")
public class Post extends BaseEntity{
  /*
  @Id
  @SequenceGenerator(
      name = "post_sequence",
      sequenceName = "post_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "post_sequence"
  )
  @Column(
      name = "id"
  )
  private Long id;

   */
  
  @Column(name = "title")
  private String title;
  
  @Column(name = "text")
  private String text;
  
  @Column(name = "picture")
  private String picture;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "barbers_company_id")
  private Company company;
  
  @Column(name = "createdAt")
  @CreationTimestamp
  private LocalDateTime createdAt;
  
  @Column(name = "updatedAt")
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  
  
  
}
