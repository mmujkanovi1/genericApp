package ba.barbers.shop.entity.generic;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public abstract class AuditingData {

  @Column(name = "DATUM_UNOSA")
  @Transient
  private LocalDateTime datumUnosa;

  @Column(name = "DATUM_AZURIRANJA")
  @Transient
  private LocalDateTime datumAzuriranja;

  @Column(name = "USER_UNOSA")
  @Transient
  private String userUnosa;

  @Column(name = "USER_AZURIRANJA")
  @Transient
  private String userAzuriranja;

  @PrePersist
  public void prePersist() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
        .getAuthentication()
        .getPrincipal();
    datumUnosa = LocalDateTime.now();
    userUnosa = userDetails.getUsername();
  }

  @PreUpdate
  public void preUpdate() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
        .getAuthentication()
        .getPrincipal();
    datumAzuriranja = LocalDateTime.now();
    userAzuriranja = userDetails.getUsername();
  }

}