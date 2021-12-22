package ee.hansab.homework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "car")
@Data
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String numberplate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @JsonFormat(pattern = "yyyy-mm-dd HH-mm-ss")
    @Column(name = "created_on", updatable = false)
    @CreationTimestamp
    public LocalDateTime createdOn;


}
