/** Classe deprecada - -
 * @author Matheus Aguinelo
 * @version 1.0
 * @since Release 0.0.01 da aplicação
 */

package br.com.book.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "author")
@Entity(name = "author")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    public Author(String name, Long id) {
        this.name = name;
        this.id = id;
    }


}
