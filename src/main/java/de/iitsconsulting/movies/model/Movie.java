package de.iitsconsulting.movies.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_generator")
    @SequenceGenerator(name = "movie_id_generator", sequenceName = "movie_id_seq", allocationSize = 20)
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Title is mandatory")
    public String title;

    @Getter
    @Setter
    @Min(value = 1900, message = "Invalid year")
    public int year;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id", foreignKey = @ForeignKey(name = "fk_movie_director"))
    public Director director;

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title='" + title + '\'' + ", year=" + year + ", director=" + director + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Movie)) {return false;}
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
