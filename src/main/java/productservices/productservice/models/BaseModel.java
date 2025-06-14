package productservices.productservice.models;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.*;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
}
