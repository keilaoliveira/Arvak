package br.com.arvak.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.arvak.domain.Grupo;
import br.com.arvak.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
		
	//Forma de realizar a consulta com o spring data
	@Transactional(readOnly=true)
	Page<Produto> findDistinctBydescricaoProdutoContainingAndGruposIn(String descricaoProduto, List<Grupo> grupos, Pageable pageRequest);
	
	//Outra forma utilizando consulta no hibernate
	//@Transactional(readOnly=true)
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.grupos gpr WHERE obj.descricaoProduto like %:descricaoProduto% AND gpr IN :grupos")
	//Page<Produto> search(@Param("descricaoProduto") String descricaoProduto, @Param("grupos") List<Grupo> grupos, Pageable pageRequest);
}
