package Bernardes.Alex;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "app_user")
public class User extends PanacheEntity {
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
}
