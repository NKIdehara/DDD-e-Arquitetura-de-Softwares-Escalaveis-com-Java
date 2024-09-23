package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.model.Categoria;
import br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(Categoria categoria);
}
