package ee.hansab.homework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "customer")
@Data
@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Pattern(regexp = "[^0-9]*", message = "Cannot contain numbers")
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH-mm-ss")
    @Column(name = "created_on", updatable = false)
    @CreationTimestamp
    public LocalDateTime createdOn;


}
