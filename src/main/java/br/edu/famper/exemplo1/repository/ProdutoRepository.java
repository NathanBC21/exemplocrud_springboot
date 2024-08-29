package br.edu.famper.exemplo1.repository;

import br.edu.famper.exemplo1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
