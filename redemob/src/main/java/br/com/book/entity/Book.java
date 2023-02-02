/** Classe responsável pela criação da entidade Usuário
 * @author Matheus Aguinelo
 * @version 1.0
 * @since Release 0.0.01 da aplicação
 */

package br.com.book.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_mae")
    private String nome_mae;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dt_nasc")
    private String dt_nasc;

    @Lob
    @Column(name = "foto_rosto")
    private byte[] foto_rosto;

    @Lob
    @Column(name = "foto_documento")
    private byte[] foto_documento;

    @Lob
    @Column(name = "foto_comprovante")
    private byte[] foto_comprovante;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;
    // ...

    @PrePersist
    @PreUpdate
    public void hashPassword() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        this.password = Base64.getEncoder().encodeToString(hash);
    }

/*    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;*/

    public Book(String nome) {
        this.nome = nome;
    }
}
