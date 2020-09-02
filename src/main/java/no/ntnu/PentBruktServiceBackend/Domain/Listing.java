package no.ntnu.PentBruktServiceBackend.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
/*

eee


 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "listing")
public class Listing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long listingId;

    @NotNull
    private String item;

    @NotNull
    private String desc;

    @NotNull
    private int price;

    @NotNull
    private LocalDate published;

    @PrePersist
    private void init(){
        setPublished(LocalDate.now());
    }

}
