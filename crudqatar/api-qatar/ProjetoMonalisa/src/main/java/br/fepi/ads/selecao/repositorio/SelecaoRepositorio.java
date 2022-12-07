package br.fepi.ads.selecao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.ads.selecao.dominio.Selecao;

public interface SelecaoRepositorio extends JpaRepository<Selecao, Long> {

}
