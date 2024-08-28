package br.edu.unicesumar.folia.domain.banco;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class BancoService {
    private final BancoRepository bancoRepository;

    public BancoService(BancoRepository bancoRepository){this.bancoRepository = bancoRepository;}

    public void deletarBanco(UUID uuid){
        Banco banco = bancoRepository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        bancoRepository.delete(banco);
    }

    public Banco salvaBanco(Banco banco){
        return bancoRepository.save(banco);
    }

    public Banco atualizaBanco(UUID uuid, Banco bancoAtualizado) {
        Banco bancoExistente = bancoRepository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        bancoAtualizado.setAgencia((bancoAtualizado.getAgencia()));
        bancoAtualizado.setConta((bancoAtualizado.getAgencia()));
        bancoAtualizado.setAgenciaDigito((bancoAtualizado.getAgencia()));
        bancoAtualizado.setContaDigito((bancoAtualizado.getAgencia()));
        bancoAtualizado.setDigitoVerificador((bancoAtualizado.getAgencia()));

        return bancoRepository.save(bancoExistente);
    }

    public Banco encontrarPorIdBanco(UUID uuid) {
        return bancoRepository.findById(uuid).orElseThrow(EntityNotFoundException::new);
    }

    public List<Banco> encontrarTodos() {
        return bancoRepository.findAll();
    }

}
