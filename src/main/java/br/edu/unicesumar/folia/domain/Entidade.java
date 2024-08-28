package br.edu.unicesumar.folia.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "ENTIDADE")
@Getter
public abstract class Entidade {

    @Column(name = "id")
    @Id
    private UUID id = UUID.randomUUID();


}
